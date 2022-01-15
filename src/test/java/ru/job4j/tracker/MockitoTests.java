package ru.job4j.tracker;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static ru.job4j.tracker.Item.FORMATTER;

public class MockitoTests {
    private final String ln = System.lineSeparator();

    @Test
    public void whenEdit() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replace item"));
        String replaceName = "New item name";
        EditIteamAction edit = new EditIteamAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replaceName);
        edit.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Edit Item ===" + ln + "Success" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replaceName));
    }

    @Test
    public void whenEditIsFalse() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replace item"));
        String replaceName = "New item name";
        EditIteamAction edit = new EditIteamAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(100);
        when(input.askStr(any(String.class))).thenReturn(replaceName);
        edit.execute(input, tracker);
        assertThat(output.toString(), is("=== Edit Item ===" + ln + "Something's wrong" + ln));
        assertThat(tracker.findAll().get(0).getName(), is("Replace item"));
    }

    @Test
    public void whenDelete() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("new Item"));
        DeleteAction delAction = new DeleteAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        delAction.execute(input, tracker);
        assertThat(output.toString(), is("=== Delete Item ===" + ln + "Success" + ln));
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenDeleteIsFalse() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        var item = new Item("new Item");
        tracker.add(item);
        DeleteAction delAction = new DeleteAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(100);
        delAction.execute(input, tracker);
        assertThat(output.toString(), is("=== Delete Item ===" + ln + "Error" + ln));
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        var item = new Item("new Item");
        tracker.add(item);
        FindByIdAction find = new FindByIdAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        find.execute(input, tracker);
        assertThat(output.toString(), is("=== Find Item by Id ===" + ln
                + "id: 1, name: new Item, created: " + FORMATTER.format(item.getCreated()) + ln));
    }

    @Test
    public void whenFindByIdIsFalse() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        var item = new Item("new Item");
        tracker.add(item);
        FindByIdAction find = new FindByIdAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askInt(any(String.class))).thenReturn(100500);
        find.execute(input, tracker);
        assertThat(output.toString(), is("=== Find Item by Id ===" + ln
                + "Not found" + ln));
    }

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        var item = new Item("new Item");
        tracker.add(item);
        FindByNameAction find = new FindByNameAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        find.execute(input, tracker);
        assertThat(output.toString(), is("=== Find Item by name ===" + ln
                + "id: 1, name: new Item, created: " + FORMATTER.format(item.getCreated()) + ln));
    }

    @Test
    public void whenFindByNameIsFalse() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        var item = new Item("new Item");
        tracker.add(item);
        FindByNameAction find = new FindByNameAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn("Bomfunk MC's");
        find.execute(input, tracker);
        assertThat(output.toString(), is("=== Find Item by name ===" + ln
                + "Not found" + ln));
    }
}
