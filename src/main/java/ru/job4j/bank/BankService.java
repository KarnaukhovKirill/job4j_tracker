package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает базовый набор операции в банковской системе.
 * @author Kirill Karnaukhov
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит коллекцию данных типа HashMap. В ключе храниться конкретный пользователь.
     * В значении храниться список счётов пользователя.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     * С помощью метода putIfAbsent проверяем нет ли user в списке users. Если нет, то добавляем.
     * @param user пользователь, которого добавляем в список
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счёт к пользователю.
     * По уникальному номеру паспорта находим пользователя.
     * После нахождения пользователя, проверяем не существует ли уже такого же счёта.
     * После проверки добавляем или не добавляем новый счёт.
     * @param passport номер паспорта пользователя
     * @param account новый номер счёта
     */
    public void addAccount(String passport, Account account) {
        User newUser = findByPassport(passport);
        if (newUser != null) {
            List<Account> newListOfAccounts = users.get(newUser);
            if (!newListOfAccounts.contains(account)) {
                newListOfAccounts.add(account);
            }
        }
    }

    /**
     * Метод исчет пользователя по уникальному номеру паспорта.
     * Проверяем, содержит ли список users пользователя с номером passport.
     * Если такой пользователь есть, то записываем его в переменную result.
     * Выводим переменную result.
     * @param passport содержит уникальный номер паспорта
     * @return возвращает пользователя
     */
    public User findByPassport(String passport) {
        return users.keySet().
                stream().
                filter(user ->  passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод исчет счёт пользователя по номеру паспорта и реквизитам счёта.
     * По номеру паспорта находим пользователя.
     * Получаем все счета этого пользователя.
     * Сравниваем реквизиты счетов с requisite. Если находим такой же реквизит, записываем
     * и выводим счёт, который содержит requisite.
     * @param passport содержит уникальный номер паспорта
     * @param requisite содержит реквизиты счёта, куда нужно отправить / снять деньги
     * @return возвращает счёт, содержащий requisite
     */
    public Account findByRequisite(String passport, String requisite) {
        User newUser = findByPassport(passport);
        List<Account> listOfAccounts = users.get(newUser);
        if (listOfAccounts != null) {
            return listOfAccounts.stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод позволяет перечислять деньги с одного счёта на другой.
     * По номерам паспорта и реквизитам находим счета отправителя и получателя.
     * Проверяем наличие денег на счету оправителя. Если денег на счету достаточно,
     * то выполняется списание денег со счёта отправителя и зачисление денег на счёт получателя.
     * @param srcPassport содержит номер паспорта отправителя
     * @param srcRequisite содержит реквизиты счёта отправителя
     * @param destPassport содержит номер паспорта получателя
     * @param destRequisite содержит реквизиты счёта получателя
     * @param amount содержит сумму денег перевода
     * @return возвращает успешность или провал перевода денег
     */
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
