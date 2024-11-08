package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

public class UpdatePriceDemo {

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        Product p = productDAO.findById(2);

        p.setProductCode("XYZ");

        p.setProductName("1975 Porsche");
        p.setProductDescription("ClassicRed");

        productDAO.update(p);

    }
}
