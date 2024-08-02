package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserManager userManager;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public LoginPanel(CardLayout cardLayout, JPanel cardPanel, UserManager userManager) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
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

        JLabel passwordLabel = new JLabel("密碼:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passwordField, gbc);

        JButton loginButton = new JButton("登錄");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        JButton registerButton = new JButton("註冊");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(registerButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "register");
            }
        });
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "所有字段都是必填的。", "錯誤", JOptionPane.ERROR_MESSAGE);
        } else if (userManager.validateUser(username, password)) {
            JOptionPane.showMessageDialog(this, "登錄成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(cardPanel, "portfolio");
        } else {
            JOptionPane.showMessageDialog(this, "無效的用戶名或密碼。", "錯誤", JOptionPane.ERROR_MESSAGE);
        }
    }
}
