package junit;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.RestAssured;
import org.jumbo.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

@Disabled
public class ProductsTests {

    @BeforeAll
    public static void setUp() throws IOException {
        InputStream propertiesInputStream = ProductsTests.class.getResourceAsStream("/application.properties");

        System.getProperties().load(propertiesInputStream);
        RestAssured.baseURI = System.getProperty("baseUrl");



    }

    @ParameterizedTest
    @CsvSource({"731, Бананы", "730,Лимоны"})
    void checkTitleProductsCsvSource(String productsId, String title) {
        String titleProducts = given()
                .param("product_id", productsId)
                .param("number", System.getProperty("number"))
                .header("x-vkusvill-token", System.getProperty("token"))
                .when()
                .get("/product")
                .then()
                .log().all()
                .extract().body().jsonPath().get("title");
        Assertions.assertEquals(titleProducts, title);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/tests.csv")
    void checkTitleProductsCsvFile(String productsId, String title) {
        String titleProducts = given()
                .param("product_id", productsId)
                .param("number", System.getProperty("number"))
                .header("x-vkusvill-token", System.getProperty("token"))
                .when()
                .get("/product")
                .then()
                .log().all()
                .extract().body().jsonPath().get("title");
        Assertions.assertEquals(titleProducts, title);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void checkTitleProductsStream(String productsId, String title) {
        String titleProducts = given()
                .param("product_id", productsId)
                .param("number", System.getProperty("number"))
                .header("x-vkusvill-token", System.getProperty("token"))
                .when()
                .get("/product")
                .then()
                .log().all()
                .extract().body().jsonPath().get("title");
        Assertions.assertEquals(titleProducts, title);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("731", "Бананы"),
                Arguments.of("730", "Лимоны"));
    }

    @Test
    void checkTitleProducts() {
        Product product = given()
                .param("product_id", "731")
                .param("number", System.getProperty("number"))
                .header("x-vkusvill-token", System.getProperty("token"))
                .when()
                .get("/product")
                .then()
                .log().all()
                .extract().body().jsonPath().getObject("", Product.class);
        Assertions.assertEquals("Catalog.Item.Packing.Weight", product.getWeight_type());
    }



}
