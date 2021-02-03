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
                .getResourceAsStream("app.properties")) {
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
            tracker.add(new Item("itemNew"));
            assertThat(tracker.findByName("itemNew").size(), is(1));
        }
    }

    @Test
    public void replaceItemAndFindByName() throws SQLException, Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            String id = String.valueOf(tracker.findAll().get(1).getId());
            tracker.replace(id, new Item("itemNew"));
            assertThat(tracker.findByName("itemNew").size(), is(1));
        }
    }

    @Test
    public void deleteItemAndFindById() throws SQLException, Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            String id = String.valueOf(tracker.findAll().get(1).getId());
            tracker.delete(id);
            assertNull(tracker.findById(id));
        }
    }

    @Test
    public void findAll() throws SQLException, Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("itemNew"));
            int size = tracker.findAll().size();
            assertTrue(size > 0);
        }
    }

}