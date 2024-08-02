package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PortfolioPanel extends JPanel {
    private JTable portfolioTable;
    private PortfolioTableModel portfolioTableModel;

    public PortfolioPanel() {
        setLayout(new BorderLayout());

        portfolioTableModel = new PortfolioTableModel();
        portfolioTable = new JTable(portfolioTableModel);

        JScrollPane scrollPane = new JScrollPane(portfolioTable);
        add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("新增投資項目");
        add(addButton, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddPortfolio();
            }
        });
    }

    private void handleAddPortfolio() {
        // 顯示新增投資項目的對話框
    }
}
