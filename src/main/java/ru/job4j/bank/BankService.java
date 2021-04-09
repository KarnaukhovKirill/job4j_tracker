package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User newUser = findByPassport(passport);
        if (newUser != null) {
            List<Account> newListOfAccounts = users.get(newUser);
            if (!newListOfAccounts.contains(account)) {
                newListOfAccounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User u : users.keySet()) {
            if (passport.equals(u.getPassport())) {
                result = u;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User newUser = findByPassport(passport);
        List<Account> listOfAccounts = users.get(newUser);
        if (listOfAccounts != null) {
            for (Account acc : listOfAccounts) {
                if (acc.getRequisite().equals(requisite)) {
                    result = acc;
                }
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null) {
            if (srcAcc.getBalance() >= amount) {
                srcAcc.setBalance(srcAcc.getBalance() - amount);
                destAcc.setBalance(destAcc.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
