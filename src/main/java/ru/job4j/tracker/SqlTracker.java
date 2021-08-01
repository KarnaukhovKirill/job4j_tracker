package ru.job4j.tracker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    @Override
    public void init() {
        try (var in = SqlTracker.class.getClassLoader()
                                        .getResourceAsStream("app.properties")) {
            var config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Item add(Item item) {
        try (var statement = cn.prepareStatement("insert into items(name, created) "
                                                                           + "values (?, ?)",
                                                                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            var timestamp = Timestamp.valueOf(item.getCreated());
            statement.setTimestamp(2, timestamp);
            statement.execute();
            var keys = statement.getGeneratedKeys();
            if (keys.next()) {
                item.setId(keys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (var statement =
                     cn.prepareStatement("update items set name = ?, created = ? where id = ?")) {
            statement.setString(1, item.getName());
            var timestamp = Timestamp.valueOf(item.getCreated());
            statement.setTimestamp(2, timestamp);
            statement.setInt(3, id);
            rsl = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (var statement =
                        cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
            rsl = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();
        try (var statement = cn.prepareStatement("select * from items")) {
            try (var resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    itemList.add(new Item(resultSet.getInt(1),
                                        resultSet.getString(2),
                                        resultSet.getTimestamp(3).toLocalDateTime()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemList = new ArrayList<>();
        try (var statement =
                     cn.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            try (var resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    itemList.add(new Item(resultSet.getInt(1),
                                        resultSet.getString(2),
                                        resultSet.getTimestamp(3).toLocalDateTime()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (var statement =
                     cn.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            try (var resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = new Item(resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getTimestamp(3).toLocalDateTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}
