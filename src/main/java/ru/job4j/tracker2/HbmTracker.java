package ru.job4j.tracker2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import javax.persistence.OptimisticLockException;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        try {
            session.save(item);
            session.getTransaction().commit();
        } catch (final Exception e) {
            session.getTransaction().rollback();
        throw e;
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        item.setId(Integer.parseInt(id));
        Session session = sf.openSession();
        session.beginTransaction();
        try {
            session.update(item);
            session.getTransaction().commit();
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Item item = new Item(null);
            item.setId(Integer.parseInt(id));
            session.delete(item);
            session.getTransaction().commit();
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result;
        try {
            result = session.createQuery("from ru.job4j.tracker2.Item").list();
            session.getTransaction().commit();
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> list;
        try {
            String queryString = "from ru.job4j.tracker2.Item where " + "name" + "= :value";
            Query queryObject = session.createQuery(queryString);
            queryObject.setParameter("value", key);
            list = queryObject.list();
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public Item findById(String id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = null;
        try {
            result = session.get(Item.class, Integer.parseInt(id));
            session.getTransaction().commit();
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    /**The method is common between SqlTracker and HbmTracker. It has to be empty here. */
    @Override
    public void init() {
    }

    public static void main(String[] args) {
        new HbmTracker().add(new Item("HB Item1"));
        //System.out.println(new HbmTracker().replace("1742442", new Item("HB Item1 Replace 2")));
        //System.out.println(new HbmTracker().delete("1742441"));
        //System.out.println(new HbmTracker().findAll());
        //System.out.println(new HbmTracker().findByName("HB Item1 Replace 2"));
        //System.out.println(new HbmTracker().findById("1742442"));
    }
}


