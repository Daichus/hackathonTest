package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private UserManager userManager;

    public MainFrame() {
        setTitle("Investment Portfolio Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 初始化 UserManager
        userManager = new UserManager();

        // 創建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // 創建卡片佈局面板
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // 添加註冊和登錄面板
        LoginPanel loginPanel = new LoginPanel(cardLayout, cardPanel, userManager);
        RegisterPanel registerPanel = new RegisterPanel(cardLayout, cardPanel, userManager);
        PortfolioPanel portfolioPanel = new PortfolioPanel();

        cardPanel.add(loginPanel, "login");
        cardPanel.add(registerPanel, "register");
        cardPanel.add(portfolioPanel, "portfolio");

        mainPanel.add(cardPanel, BorderLayout.CENTER);

        // 顯示登錄面板
        cardLayout.show(cardPanel, "login");
    }
}
