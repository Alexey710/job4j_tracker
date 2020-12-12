package ru.job4j.tracker.collection.bank;


import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> list = new ArrayList<>();
        users.putIfAbsent(user, list);
    }

    public void addAccount(String passport, Account account) {
        User target = this.findByPassport(passport);
        users.get(target).add(account);
    }

    public User findByPassport(String passport) {
        for (Map.Entry<User, List<Account>> elem : users.entrySet()) {
            if (Objects.equals(elem.getKey().getPassport(), passport)) {
                return elem.getKey();
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User target = this.findByPassport(passport);
        if (target != null) {
            for (Account account : users.get(target)) {
                if (Objects.equals(account.getRequisite(), requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

}
