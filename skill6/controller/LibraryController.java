package skill6.library.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.library.model.Book;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // 2. /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // 3. /count
    @GetMapping("/count")
    public int bookCount() {
        return 100;
    }

    // 4. /price
    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    // 5. /books
    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Java Programming", "Spring Boot Guide", "Data Structures", "Operating Systems");
    }

    // 6. /books/{id}
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of book with ID: " + id;
    }

    // 7. /search?title=xyz
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book titled: " + title;
    }

    // 8. /author/{name}
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // 9. POST /addbook
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 10. /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}