import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.when;

public class GroceryItemRepositoryTest {

        @Test
        public void healthCheck()
        {
            when().get("/items").then().statusCode(200);
        }
}