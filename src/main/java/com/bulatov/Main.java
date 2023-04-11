package com.bulatov;

import com.bulatov.db.AccountRepository;
import com.bulatov.db.impl.PostgresAccountRepository;
import com.bulatov.entity.AccountEntity;

import javax.swing.*;

public class Main {

    static AccountRepository accountRepository = new PostgresAccountRepository();

    public static void main(String[] args) {
        String accountName = JOptionPane.showInputDialog("Представьтесь, пожалуйста");
        AccountEntity workAccount = accountRepository.getByName(accountName);
        if (workAccount == null) {
            int balance = Integer.parseInt(JOptionPane.showInputDialog("Введите баланс:"));

            AccountEntity account = new AccountEntity()
                    .setName(accountName)
                    .setValue(balance);

            accountRepository.addAccount(account);

        }
    }
}