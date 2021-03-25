package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    String ln = System.lineSeparator();

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        UserAction[] actions = {
                new EditIteamAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("New item name"));
    }

    @Test
    public void whenFingAllAction() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("New item"));
        UserAction[] actions = {
                new ShowAllItemAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + ln +
                                            "0. Show all items" + ln +
                                            "1. Exit programm" + ln +
                                            "=== List of Items ===" + ln +
                                            "Item{id=1, name='New item'}" + ln +
                                            " === End === " + ln +
                                            "Menu." + ln +
                                            "0. Show all items" + ln +
                                            "1. Exit programm" + ln +
                                            "Good bye" + ln));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output),
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + ln +
                        "0. Exit programm" + ln +
                        "Good bye" + ln
        ));
    }

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("New Item"));
        Input input = new StubInput(
                new String[] {"0", "New Item", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                                    "Menu." + ln +
                                        "0. Find items by name" + ln +
                                        "1. Exit programm" + ln +
                                        "=== Find Item by name ====" + ln +
                                        "Item{id=1, name='New Item'}" + ln +
                                        "Menu." + ln +
                                        "0. Find items by name" + ln +
                                        "1. Exit programm" + ln +
                                        "Good bye" + ln));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Finder item"));
        Input input = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + ln +
                        "0. Find item by Id" + ln +
                        "1. Exit programm" + ln +
                        "=== Find Item by Id ====" + ln +
                        "Finder item" + ln +
                        "Menu." + ln +
                        "0. Find item by Id" + ln +
                        "1. Exit programm" + ln +
                        "Good bye" + ln));
    }
}