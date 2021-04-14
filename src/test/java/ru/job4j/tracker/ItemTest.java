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
        List<Item> expected = Arrays.asList(
                new Item(1, "Kirill"),
                new Item(2, "Danil"),
                new Item(3, "Stas")
        );
        assertThat(items, is(expected));
    }

    @Test
    public void testSortByIdUpToDown() {
        List<Item> items = Arrays.asList(
                new Item(1, "Kirill"),
                new Item(3, "Stas"),
                new Item(2, "Danil")
        );
        Collections.sort(items, Collections.reverseOrder());
        List<Item> expected = Arrays.asList(
                new Item(3, "Stas"),
                new Item(2, "Danil"),
                new Item(1, "Kirill")
        );
        assertThat(items, is(expected));
    }

    @Test
    public void testSortByNameDownToUp() {
        List<Item> items = Arrays.asList(
                new Item(1, "Kirill"),
                new Item(3, "Stas"),
                new Item(2, "Danil")
        );
        Collections.sort(items, new SortItemByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "Danil"),
                new Item(1, "Kirill"),
                new Item(3, "Stas")
        );
        assertThat(items, is(expected));
    }

    @Test
    public void testSortByNameUpToDown() {
        List<Item> items = Arrays.asList(
                new Item(1, "ABBA"),
                new Item(3, "Ace of Base"),
                new Item(2, "Adriano Celentano")
        );
        Collections.sort(items, new SortItemByNameReverse());
        List<Item> expected = Arrays.asList(
                new Item(2, "Adriano Celentano"),
                new Item(3, "Ace of Base"),
                new Item(1, "ABBA")
        );
        assertThat(items, is(expected));
    }
}