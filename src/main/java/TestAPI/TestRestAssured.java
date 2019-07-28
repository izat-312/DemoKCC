package TestAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    @Test
    public void GetNumberOfRaceCircuits2017(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","silvester");
        jsonObject.put("job","actor");

        RestAssured.given().when()
                .header("Content-Type", "application/json")
                .get("https://ergast.com/api/f1/2017/circuits")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void PodtMethodValidAssertion(){
        RequestSpecification request = RestAssured.given();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Silvester");
        jsonObject.put("job","actor");

        request.header("Content-Type","application/json");
        request.body(jsonObject.toString());
        Response response = request.post("https://reqres.in/api/users");
        int code = response.getStatusCode();
        Assert.assertEquals(code,201);
    }

    @Test
    public void PostMethodAndfailedAssertion(){
        RestAssured.given().when()
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"izat\",\n" +
                        "    \"job\": \"SDET\"\n" +
                        "}")
                .post("https://reqres.in/api/users")
                .then().assertThat().statusCode(201).and().body("name",equalTo("izat"));

        given().when()
                .header("Content-Type","application/json")
                .param("\"name\": \"izat\"")
                .delete("https://reqres.in/api/users")
                .then().assertThat().statusCode(204);

    }

    public static void main(String[] args) {
        String word="aaaabbcccdda";
        char[]ret = word.toCharArray();

        for (int i=0;i<ret.length; i++){
            int count=1;
            for (int j=i+1;j<ret.length; j++){
                if (word.charAt(i)==word.charAt(j)){
                    count++;
                    ret[j]='*';
                }
            }
            if (ret[i]!='*'){
                System.out.println(ret[i]+"= "+count);
            }
        }

    }

}
