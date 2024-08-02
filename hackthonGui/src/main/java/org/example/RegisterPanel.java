package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private UserManager userManager;

    public RegisterPanel(CardLayout cardLayout, JPanel cardPanel, UserManager userManager) {
        this.userManager = userManager;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel usernameLabel = new JLabel("用戶名:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(usernameField, gbc);

        JLabel emailLabel = new JLabel("電子郵件:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(emailLabel, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(emailField, gbc);

        JLabel passwordLabel = new JLabel("密碼:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(passwordField, gbc);

        JButton registerButton = new JButton("註冊");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(registerButton, gbc);

        JButton loginButton = new JButton("返回登錄");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegister();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "login");
            }
        });
    }

    private void handleRegister() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "所有字段都是必填的。", "錯誤", JOptionPane.ERROR_MESSAGE);
        } else if (userManager.userExists(username)) {
            JOptionPane.showMessageDialog(this, "用戶名已經存在。", "錯誤", JOptionPane.ERROR_MESSAGE);
        } else {
            userManager.addUser(username, email, password);
            JOptionPane.showMessageDialog(this, "註冊成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
