
package com.stores;

import dao.ProductDAO;
import entity.Product;

public class App {
    public static void main(String[] args) {

        // 🧪 Create Product object
        Product product = new Product();
        product.setName("Notebook");
        product.setDescription("Classmate book");
        product.setQty(50);
        product.setPrice(65.50);

        // 💾 Save product using DAO
        ProductDAO dao = new ProductDAO();
        dao.saveProduct(product);

        System.out.println("✅ Product inserted successfully!");
    }
}
