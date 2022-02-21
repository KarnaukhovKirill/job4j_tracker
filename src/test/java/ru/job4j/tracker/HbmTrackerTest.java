package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAdd() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("AddItem", "desc");
        tracker.add(item);
        assertThat(tracker.findAll().size(), is(1));
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplace() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("First item", "desc");
        tracker.add(item);
        Item newItem = new Item("new item", "desc");
        tracker.add(newItem);
        tracker.replace(item.getId(), newItem);
        assertThat(tracker.findById(item.getId()).getName(), is("new item"));
    }

    @Test
    public void whenDelete() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("Delete Item", "desc");
        tracker.add(item);
        assertThat(tracker.findAll().size(), is(1));
        tracker.delete(item.getId());
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenFindAll() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("Find item", "desc");
        Item secondItem = new Item("Second Item", "desc");
        Item thirdItem = new Item("Third Item", "desc");
        tracker.add(item);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        assertThat(tracker.findAll().size(), is(3));
    }

    @Test
    public void whenFindByName() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("Find item", "desc");
        tracker.add(item);
        var rsl = tracker.findByName("Find item");
        assertThat(rsl.get(0), is(item));
    }

    @Test
    public void whenFindById() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("Find item", "desc");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
}