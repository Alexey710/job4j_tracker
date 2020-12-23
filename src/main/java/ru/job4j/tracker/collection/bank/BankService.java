package ru.job4j.tracker.collection.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> list = new ArrayList<>();
        users.putIfAbsent(user, list);
    }

    public void addAccount(String passport, Account account) {
        Optional<User> target = this.findByPassport(passport);
        users.get(target.get()).add(account);
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
        Optional<List<Account>> account = Optional.of(users.get(findByPassport(passport).get()));
        if (account.isPresent()) {
            for (Account elem : account.get()) {
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
        if (src.get().getBalance() >= amount) {
            src.get().setBalance(src.get().getBalance() - amount);
            dest.get().setBalance(dest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

}
