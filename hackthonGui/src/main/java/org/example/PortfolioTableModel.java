package org.example;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class PortfolioTableModel extends AbstractTableModel {
    private List<Portfolio> portfolios = new ArrayList<>();
    private String[] columnNames = {"資產名稱", "數量", "購買價格", "當前價格", "收益率"};

    public PortfolioTableModel() {
        // 添加示例數據
        portfolios.add(new Portfolio("資產1", 10, 100.0, 120.0, 20.0));
        portfolios.add(new Portfolio("資產2", 20, 50.0, 55.0, 10.0));
    }

    @Override
    public int getRowCount() {
        return portfolios.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Portfolio portfolio = portfolios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return portfolio.getName();
            case 1:
                return portfolio.getQuantity();
            case 2:
                return portfolio.getPurchasePrice();
            case 3:
                return portfolio.getCurrentPrice();
            case 4:
                return portfolio.getReturnRate();
            default:
                return null;
        }
    }

    public static class Portfolio {
        private String name;
        private int quantity;
        private double purchasePrice;
        private double currentPrice;
        private double returnRate;

        public Portfolio(String name, int quantity, double purchasePrice, double currentPrice, double returnRate) {
            this.name = name;
            this.quantity = quantity;
            this.purchasePrice = purchasePrice;
            this.currentPrice = currentPrice;
            this.returnRate = returnRate;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPurchasePrice() {
            return purchasePrice;
        }

        public double getCurrentPrice() {
            return currentPrice;
        }

        public double getReturnRate() {
            return returnRate;
        }
    }
}
