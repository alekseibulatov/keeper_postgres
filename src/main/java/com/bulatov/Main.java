package com.bulatov;

import com.bulatov.db.DataSourceProvider;
import com.bulatov.entity.AccountEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JdbcTemplate template = 
                new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

        String accountName = JOptionPane.showInputDialog("Введите ваше имя:");
        int balance = Integer.parseInt(JOptionPane.showInputDialog("Введите баланс:"));

        AccountEntity account = new AccountEntity()
                .setName(accountName)
                .setValue(balance);

        template.update("INSERT INTO account (name, value) values (? , ?) ", account.getName(), account.getValue());
    }
}