import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestRestAssured {

    @Test
    public void run(){
        given().when().
                get("https://86379da6-cae3-424d-92e1-1e4b699cc1b1.mock.pstmn.io/students").
                then().
                assertThat().
                statusCode(200);
    }
    @Test
    public void runFailed(){
        given().when().
                get("https://86379da6-cae3-424d-92e1-1e4b699cc1b1.mock.pstmn.io/students").
                then().
                assertThat().
                header("Content-Type","application/json");

    }

    @Test
    public void sendMessageOnSlackAndValidateText(){
        given().when()
                .auth()
                .oauth2("xoxp-566936316423-577941770263-680826605331-223aee1627da68f0d5be6bf5abfa37dd")
                .body("{\n" +
                        "  \"channel\": \"general\",\n" +
                        "  \"text\": \"Hello World\"\n" +
                        "}")
                .header("Content-Type", "application/json")
                .post("https://slack.com/api/chat.postMessage")
                .then()
                .assertThat().
                body("message.text",equalTo("Hello World"));
    }

    @Test
    public void TestResponseSlack(){
        given().when().
                get("https://86379da6-cae3-424d-92e1-1e4b699cc1b1.mock.pstmn.io/students").
                then().
                assertThat().
                body("ok",equalTo(true));
    }
}
