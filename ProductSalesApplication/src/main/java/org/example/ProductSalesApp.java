package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductSalesApp extends JFrame {
    private JTextArea displayArea;
    private JLabel yearsLabel;
    private ProductSales productSales = new ProductSales();

    public ProductSalesApp() {
        setTitle("Product Sales Application");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");

        loadItem.addActionListener(e -> loadData());
        saveItem.addActionListener(e -> saveData());
        clearItem.addActionListener(e -> clearData());

        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Components
        JPanel buttonPanel = new JPanel();
        JButton loadBtn = new JButton("Load Product Data");
        JButton saveBtn = new JButton("Save Product Data");

        loadBtn.addActionListener(e -> loadData());
        saveBtn.addActionListener(e -> saveData());

        buttonPanel.add(loadBtn);
        buttonPanel.add(saveBtn);

        displayArea = new JTextArea(8, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        yearsLabel = new JLabel("Years Processed: ");

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(yearsLabel, BorderLayout.SOUTH);
    }

    private void loadData() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total Sales: ").append(productSales.GetTotalSales()).append("\n");
        sb.append("Average Sales: ").append(String.format("%.2f", productSales.GetAverageSales())).append("\n");
        sb.append("Sales over limit: ").append(productSales.GetSalesOverLimit()).append("\n");
        sb.append("Sales under limit: ").append(productSales.GetSalesUnderLimit()).append("\n");
        displayArea.setText(sb.toString());
        yearsLabel.setText("Years Processed: " + productSales.GetProductsProcessed());
    }

    private void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt"))) {
            writer.println("DATA LOG");
            writer.println("**********************");
            writer.println(displayArea.getText());
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file");
        }
    }

    private void clearData() {
        displayArea.setText("");
        yearsLabel.setText("Years Processed: ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductSalesApp().setVisible(true));
    }
}
