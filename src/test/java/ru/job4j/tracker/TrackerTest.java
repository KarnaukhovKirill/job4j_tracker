package ru.job4j.tracker;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import org.junit.Test;

import java.util.List;

public class TrackerTest {

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenReplaceId() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        bug.setId(50);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDeleteTwo() {
        Tracker tracker = new Tracker();
        Item f = new Item(1, "Google");
        Item s = new Item(2, "Yahoo");
        Item t = new Item(3, "Amazoon");
        tracker.add(f);
        tracker.add(s);
        tracker.add(t);
        tracker.delete(2);
        List<Item> items = tracker.findAll();
        assertThat(items.get(0).getName(), is(f.getName()));  //удалили Yahoo, остались items[0] = Google, items[1] = Amazoon
        assertThat(items.get(1).getName(), is(t.getName()));
        }
}