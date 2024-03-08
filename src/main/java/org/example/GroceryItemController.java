package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class GroceryItemController {

    @Autowired
    private ItemRepository groceryItemRepo;

    @GetMapping
    public List<GroceryItem> getAllItems() {
        return groceryItemRepo.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<GroceryItem> getItemByName(@PathVariable String name) {
        GroceryItem item = groceryItemRepo.findItemByName(name);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/{category}")
    public List<GroceryItem> getItemsByCategory(@PathVariable String category)
    {
        return groceryItemRepo.findAll(category);
    }


}
