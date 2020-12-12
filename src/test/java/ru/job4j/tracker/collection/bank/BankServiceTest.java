package ru.job4j.tracker.collection.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        User found = bank.findByPassport("3434");
        assertThat(found, is(user));
    }

    @Test
    public void addDuplicateUser() {
        User user = new User("3434", "User 1");
        User user2 = new User("3434", "User 2");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addUser(user2);
        User found = bank.findByPassport("3434");
        assertThat(found.getUsername(), is("User 1"));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Account target = bank.findByRequisite("34", "5546");
        assertNull(target);
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(200D));
    }

    @Test
    public void whenInvalidTransferMoney() {
        User user = new User("3434", "Ivan Ivanov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 0));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        boolean rsl = bank.transferMoney(user.getPassport(), "5546",
                user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(50D));
    }
}