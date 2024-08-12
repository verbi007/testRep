package testng;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import org.jumbo.product.Product;
import org.junit.jupiter.api.Disabled;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;

import static io.restassured.RestAssured.given;

@Disabled
public class ProductsTestTestNG {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        InputStream propertiesInputStream = ProductsTestTestNG.class.getResourceAsStream("/application.properties");

        System.getProperties().load(propertiesInputStream);
        RestAssured.baseURI = System.getProperty("baseUrl");
    }

    @Test(groups = "productsRegression")
    public void testProducts() {
        String titleProducts = given()
                .param("product_id", "731")
                .param("number", System.getProperty("number"))
                .header("x-vkusvill-token", System.getProperty("token"))
                .when()
                .get("/product")
                .then()
                .log().all()
                .extract().body().jsonPath().get("title");
        Assert.assertEquals(titleProducts, "Бананы");
    }

    @Test
    @Parameters({"productId", "title"})
    public void testProductsParameters(String productId, String title) {
        String titleProducts = given()
                .param("product_id", productId)
                .param("number", System.getProperty("number"))
                .header("x-vkusvill-token", System.getProperty("token"))
                .when()
                .get("/product")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().jsonPath().get("title");
        Assert.assertEquals(titleProducts, title);
    }


    @Test(dataProvider = "DataProvider1")
    public void testProductsDataProvider(String productId, String title) {
        String titleProducts = given()
                .param("product_id", productId)
                .param("number", System.getProperty("number"))
                .header("x-vkusvill-token", System.getProperty("token"))
                .when()
                .get("/product")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().jsonPath().get("title");
        Assert.assertEquals(titleProducts, title);
    }

    @Test(dataProvider = "DataProvider2")
    public void testProductsDataProvider2(String productId, Integer price) {

        Product product = given()
                .param("product_id", productId)
                .param("number", System.getProperty("number"))
                .header("x-vkusvill-token", System.getProperty("token"))
                .when()
                .get("/product")
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath().getObject("", Product.class);
        Assert.assertEquals(product.getPrice().getPrice(), price);
    }

    @DataProvider(name = "DataProvider1")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {"731", "Бананы"},
                        {"730", "Лимоны"},
                        {"120", "Сыр \"Сулугуни\""}
                };
    }

    @DataProvider(name = "DataProvider2")
    public static Object[][] dataProvider2() {
        return new Object[][]
        {
            {"731", 158},
            {"730", 198}
        };
    }

    @Test
    public void checkPriceDoubleRequest() {

        Product product = given()
                .param("product_id", "120")
                .param("number", System.getProperty("number"))
                .header("x-vkusvill-token", System.getProperty("token"))
                .when()
                .get("/product")
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath().getObject("", Product.class);
        Assert.assertEquals(product.getPrice().getPrice(), getPrice());
    }

    public Integer getPrice() {
        JsonArray json = new JsonArray();
        json.add(System.getProperty("jsonOP"));
        String path = "src/test/resources/OP.json";

        String price = given()
                .header("x-online-pay-id", System.getProperty("tokenOP"))
                .contentType("application/json")
                .body(new File(path))
                .when()
                .post(System.getProperty("opUrl"))
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().jsonPath().get("Lines[0].Price");

        return Integer.parseInt(price.substring(0, price.length() -3));
    }
}
