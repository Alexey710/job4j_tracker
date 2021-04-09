package ru.job4j.tracker2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void add() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("itemNew"));
        assertThat(tracker.findByName("itemNew").size(), is(1));
    }

    @Test
    public void replace() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("itemNew"));
        tracker.replace("1", new Item("itemNew1"));
        assertThat(tracker.findByName("itemNew1").size(), is(1));
    }

    @Test
    public void delete() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("itemNew"));
        tracker.delete("1");
        assertNull(tracker.findById("1"));
    }

    @Test
    public void findAll() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("itemNew"));
        int size = tracker.findAll().size();
        assertEquals(1, size);
    }

    @Test
    public void findByName() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("itemNew"));
        assertThat(tracker.findByName("itemNew").size(), is(1));
    }

    @Test
    public void findById() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("itemNew"));
        assertThat(tracker.findById("1").getName(), is("itemNew"));
    }
}