package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

public class CreateProductDemo {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();
        Product p = new Product();

        p.setBuyPrice(5.99);
        p.setMsrp(1.99);
        p.setProductName("New Product");
        p.setProductCode("NPC");
        p.setProductlineId(1);
        p.setProductDescription("Product Description");
        p.setQuantityInStock(50);

        System.out.println("before = " + p);
        productDAO.create(p);
        System.out.println("after = " + p);
    }
}
