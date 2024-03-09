package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody GroceryItem item) {
        groceryItemRepo.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateItem(@RequestParam("id") String id, @RequestBody GroceryItem updatedItem) {
        if (groceryItemRepo.existsById(id)) {
            updatedItem.setId(id);
            groceryItemRepo.save(updatedItem);
            return ResponseEntity.ok("Item updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

// Example usage localhost:8080/items?id=Dried%20Red%20Chilli
    @DeleteMapping()
    public ResponseEntity<String> deleteItem(@RequestParam("id") String id) {
        if(groceryItemRepo.existsById(id)) {
            groceryItemRepo.deleteById(id);
            return ResponseEntity.ok("Item successfully deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
