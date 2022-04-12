package ru.job4j.tracker;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import org.junit.Test;
import java.util.List;

public class MemTrackerTest {

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenReplaceId() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        bug.setId(50);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDeleteTwo() {
        MemTracker memTracker = new MemTracker();
        Item f = new Item(1, "Google", "desc");
        Item s = new Item(2, "Yahoo", "desc");
        Item t = new Item(3, "Amazoon", "desc");
        memTracker.add(f);
        memTracker.add(s);
        memTracker.add(t);
        memTracker.delete(2);
        List<Item> items = memTracker.findAll();
        assertThat(items.get(0).getName(), is(f.getName()));
        assertThat(items.get(1).getName(), is(t.getName()));
    }
}