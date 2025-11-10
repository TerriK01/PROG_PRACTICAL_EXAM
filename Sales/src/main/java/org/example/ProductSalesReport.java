package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class ProductSalesReport {
    public static void main(String[] args) {
        int[][] productSales = {{300, 150, 700}, {250, 200, 600}};

        ProductSales ps = new ProductSales();

        int total = ps.TotalSales(productSales);
        double average = ps.AverageSales(productSales);
        int max = ps.MaxSale(productSales);
        int min = ps.MinSale(productSales);

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("-----------------------------------------------------");
        System.out.println("Total sales: " + total);
        System.out.println("Average sales: " + Math.round(average));
        System.out.println("Maximum sale: " + max);
        System.out.println("Minimum sale: " + min);
        System.out.println("-----------------------------------------------------");
    }
}
