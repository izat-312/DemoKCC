package TestAPI;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


public class BasicsAPI {
    public static void main(String[] args) {

        RestAssured.baseURI="https://maps.googleapis.com";
        given().
                param("key","AIzaSyAwYqB2twcEw_b9KBHcieYE5IrXqQijrU4").
                param("input","Museum%20of%20Contemporary%20Art%20Australia").
                param("inputtype","textquery").
                param("fields","photos,formatted_address,name,rating,opening_hours,geometry").
                when().
                get("/maps/api/place/findplacefromtext/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
//        .and().body("jk", equalTo());

    }
}
