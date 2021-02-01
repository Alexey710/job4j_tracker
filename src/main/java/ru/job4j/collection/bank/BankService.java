package ru.job4j.collection.bank;

import java.util.*;
/**
 * Класс для работы с банковскими переводами.
 * Функционал:
 * -добавлять пользователей {@link User}
 * -добавлять счета пользователей {@link Account}
 * -методы поиска по акаунту, по реквизитам
 *
 * @author KRYLOV ALEXEY
 * @version 1.0.
 * */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляет пользователя
     * @param user пользователь {@link User}
     */
    public void addUser(User user) {
        List<Account> list = new ArrayList<>();
        users.putIfAbsent(user, list);
    }

    /**
     * метод добавляет аккаунт пользоввателя
     * @param passport по номеру паспорта
     * @param account акаунт {@link Account}, который добавляем
     */
    public void addAccount(String passport, Account account) {
        Optional<User> target = findByPassport(passport);
        target.ifPresent(user -> users.get(user).add(account));
    }

    /**
     * метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта
     * @return возвращает пользователя {@link User}
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * метод находит аккаунт {@link Account} по реквизитам счета и номеру паспорта
     * @param passport номер паспорта из класса {@link User}
     * @param requisite ревизиты счета из класса {@link Account}
     * @return возвращает аккаунт пользователя {@link Account}
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> account = users.get(user.get());
            return account.stream()
                    .filter(o -> o.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * метод перемщает деньги с одного аккаунта пользователя {@link Account}
     * на другой аккаунт {@link Account}
     * по реквизитам счте и паспорту пользователя
     * @param srcPassport с номера паспорта из класса {@link User}
     * @param srcRequisite с ревизитов счета из класса {@link Account}
     * @param destPassport на номер паспорта из класса {@link User}
     * @param destRequisite на ревизиты счета из класса {@link Account}
     * @param amount сумма для перевода
     * @return возвращает true в случае упешного перевода, или в противном случае false
     */
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
