import org.example.App;
import org.example.GroceryItem;
import org.example.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = App.class)
//@DataMongoTest
public class GroceryItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFindAll() {
        // Given
        GroceryItem groceryItem1 = new GroceryItem("1","Apple", 5, "Fruits");
        GroceryItem groceryItem2 = new GroceryItem("2","Banana", 3, "Fruits");

        itemRepository.save(groceryItem1);
        itemRepository.save(groceryItem2);


        // When

        List<GroceryItem> items = itemRepository.findAll();

        // Then

        assertThat(items).isNotNull();
        assertThat(items).hasSize(7);
//        assertThat(items).contains(groceryItem1, groceryItem2);

    }
}