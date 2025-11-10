package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductSalesReportTest {

    int[][] productSales = {
            {300, 150, 700},
            {250, 200, 600}
    };

    ProductSales ps = new ProductSales();

    @Test
    void CalculateTotalSales_ReturnsTotalSales() {
        int expected = 2200;
        assertEquals(expected, ps.TotalSales(productSales));
    }

    @Test
    void AverageSales_ReturnsAverageSales() {
        double expected = 366.67;
        assertEquals(expected, ps.AverageSales(productSales), 0.1);
    }

    @Test
    void MaxSale_ReturnsMaximumSale() {
        int expected = 700;
        assertEquals(expected, ps.MaxSale(productSales));
    }

    @Test
    void MinSale_ReturnsMinimumSale() {
        int expected = 150;
        assertEquals(expected, ps.MinSale(productSales));
    }
}
