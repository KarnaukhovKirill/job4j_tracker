package ru.job4j.tracker;

import org.junit.Test;
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
}