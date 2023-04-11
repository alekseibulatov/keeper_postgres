package com.bulatov.service;

import com.bulatov.db.AccountRepository;
import com.bulatov.db.impl.PostgresAccountRepository;
import com.bulatov.entity.AccountEntity;

import javax.swing.*;

public class AccountService {

    private AccountRepository accountRepository = new PostgresAccountRepository();

    public AccountEntity login() {
        String accountName = JOptionPane.showInputDialog("Представьтесь, пожалуйста");
        AccountEntity workAccount = accountRepository.getByName(accountName);
        if (workAccount == null) {
            int balance = Integer.parseInt(JOptionPane.showInputDialog("Введите баланс:"));

            AccountEntity account = new AccountEntity()
                    .setName(accountName)
                    .setValue(balance);

            accountRepository.addAccount(account);
            return accountRepository.getByName(accountName);
        } else {
            return workAccount;
        }
    }
}
