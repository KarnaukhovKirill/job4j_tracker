package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemTest {

    @Test
    public void testSortByIdDownToUp() {
        List<Item> items = Arrays.asList(
                new Item(1, "Kirill"),
                new Item(3, "Stas"),
                new Item(2, "Danil")
        );
        Collections.sort(items);
        assertThat(items.toString(), is("[Item{id=1, name='Kirill'}, " +
                                            "Item{id=2, name='Danil'}, " +
                                            "Item{id=3, name='Stas'}]"));
    }

    @Test
    public void testSortByIdUpToDown() {
        List<Item> items = Arrays.asList(
                new Item(1, "Kirill"),
                new Item(3, "Stas"),
                new Item(2, "Danil")
        );
        Collections.sort(items, Collections.reverseOrder());
        assertThat(items.toString(), is("[Item{id=3, name='Stas'}, " +
                                            "Item{id=2, name='Danil'}, " +
                                            "Item{id=1, name='Kirill'}]"));
    }

    @Test
    public void testSortByNameDownToUp() {
        List<Item> items = Arrays.asList(
                new Item(1, "Kirill"),
                new Item(3, "Stas"),
                new Item(2, "Danil")
        );
        Collections.sort(items, new SortItemByName());
        assertThat(items.toString(), is("[Item{id=2, name='Danil'}, " +
                                            "Item{id=1, name='Kirill'}, " +
                                            "Item{id=3, name='Stas'}]"));
    }

    @Test
    public void testSortByNameUpToDown() {
        List<Item> items = Arrays.asList(
                new Item(1, "ABBA"),
                new Item(3, "Ace of Base"),
                new Item(2, "Adriano Celentano")
        );
        Collections.sort(items, new SortItemByNameReverse());
        assertThat(items.toString(), is("[Item{id=2, name='Adriano Celentano'}, " +
                                                "Item{id=3, name='Ace of Base'}, " +
                                                "Item{id=1, name='ABBA'}]"));
    }
}
