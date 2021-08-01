package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenReplaceAndFindByIdIsTrue() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item newItem = new Item("Second");
        tracker.replace(item.getId(), newItem);
        assertThat(tracker.findById(item.getId()), is(newItem));
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenAddItemAndFindByNameIsTrue() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findByName("item").get(0), is(item));
    }

    @Test
    public void whenAddTwoItemAndDeleteFirst() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item secondItem = new Item("Second");
        tracker.add(item);
        tracker.add(secondItem);
        tracker.delete(1);
        assertThat(tracker.findById(secondItem.getId()), is(secondItem));
    }

    @Test
    public void whenFindAllIsTrue() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item secondItem = new Item("Second");
        tracker.add(item);
        tracker.add(secondItem);
        var expected = List.of(item, secondItem);
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenResultIsNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertNull(tracker.findById(100500));
    }
}