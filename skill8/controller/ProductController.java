
package skill8.product.controller;

import skill8.product.model.Product;
import skill8.product.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    // Insert sample products
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    // Search by category
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repository.findByCategory(category);
    }

    // Filter price range
    @GetMapping("/filter")
    public List<Product> filterByPrice(
            @RequestParam double min,
            @RequestParam double max) {

        return repository.findByPriceBetween(min, max);
    }

    // Sorted by price
    @GetMapping("/sorted")
    public List<Product> sortedProducts() {
        return repository.findAllSortedByPrice();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price) {
        return repository.findExpensiveProducts(price);
    }
}
```
