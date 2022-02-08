package ru.job4j.tracker;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    private final String ln = System.lineSeparator();

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditIteamAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is("New item name"));
    }

    @Test
    public void whenFingAllAction() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New item", "Desc",
                new Timestamp(new Date().getTime())));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllItemAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        assertThat(output.toString(), is("Menu." + ln
                                            + "0. Show all items" + ln
                                            + "1. Exit programm" + ln
                                            + "=== List of Items ===" + ln
                                            + item.toString() + ln
                                            + " === End === " + ln
                                            + "Menu." + ln
                                            + "0. Show all items" + ln
                                            + "1. Exit programm" + ln
                                            + "Good bye" + ln));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + ln
                        + "0. Exit programm" + ln
                        + "Good bye" + ln
        ));
    }

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New Item", "desc",
                new Timestamp(new Date().getTime())));
        Input input = new StubInput(
                new String[] {"0", "New Item", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                                    "Menu." + ln
                                        + "0. Find items by name" + ln
                                        + "1. Exit programm" + ln
                                        + "=== Find Item by name ===" + ln
                                        + item.toString() + ln
                                        + "Menu." + ln
                                        + "0. Find items by name" + ln
                                        + "1. Exit programm" + ln
                                        + "Good bye" + ln));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Finder item", "Finder description",
                new Timestamp(new Date().getTime())));
        Input input = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + ln
                        + "0. Find item by Id" + ln
                        + "1. Exit programm" + ln
                        + "=== Find Item by Id ===" + ln
                        + item.toString() + ln
                        + "Menu." + ln
                        + "0. Find item by Id" + ln
                        + "1. Exit programm" + ln
                        + "Good bye" + ln));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"10", "0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit programm" + ln
                        + "Wrong input, you can select: 0 . . 0" + ln
                        + "Menu." + ln
                        + "0. Exit programm" + ln
                        + "Good bye" + ln
        )
        );
    }
}