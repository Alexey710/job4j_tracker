package ru.job4j.tracker.collection.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> list = new ArrayList<>();
        users.putIfAbsent(user, list);
    }

    public void addAccount(String passport, Account account) {
        Optional<User> target = findByPassport(passport);
        target.ifPresent(user -> users.get(user).add(account));
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> account = users.get(user.get());
            for (Account elem : account) {
                if (elem.getRequisite().equals(requisite)) {
                    return Optional.of(elem);
                }
            }
        }
        return Optional.empty();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent()) {
            if (src.get().getBalance() >= amount) {
                src.get().setBalance(src.get().getBalance() - amount);
                dest.get().setBalance(dest.get().getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }

}
