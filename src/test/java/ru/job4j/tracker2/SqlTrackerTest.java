package ru.job4j.tracker2;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {
    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException, Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.createTableForTest();
            tracker.add(new Item("item1"));
            assertThat(tracker.findByName("item1").size(), is(1));
        }
    }

    @Test
    public void replaceItemAndFindByName() throws SQLException, Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.createTableForTest();
            tracker.add(new Item("item1"));
            tracker.replace("1", new Item("item2"));
            assertThat(tracker.findByName("item2").size(), is(1));
        }
    }

    @Test
    public void deleteItemAndFindById() throws SQLException, Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.createTableForTest();
            tracker.add(new Item("item1"));
            assertThat(tracker.findById("1"), is(new Item(1, "item1")));
            tracker.delete("1");
            assertNull(tracker.findById("1"));
        }
    }

    @Test
    public void findAll() throws SQLException, Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.createTableForTest();
            tracker.add(new Item("item1"));
            tracker.add(new Item("item2"));
            int size = tracker.findAll().size();
            assertEquals(size, 2);
        }
    }

}