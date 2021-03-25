package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};   //создаём массив с ответом
        Input input = new StubInput(answers); //записываем в input "fix pc"
        Tracker tracker = new Tracker();  //создаём tracker
        StartUI.createItem(input, tracker);  //
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void testEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId()),
                "replaced item" };
        StartUI.editItem(new StubInput(answer), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
        }

    @Test
    public void testDeliteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId())
        };
        StartUI.deliteItem(new StubInput(answer), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
    }
}