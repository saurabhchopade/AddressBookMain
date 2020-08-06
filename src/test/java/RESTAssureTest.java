import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
public class RESTAssureTest {

    @Before
    public void setUp()  {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }
    @Test
    public Response getPersonList() {
    Response response=RestAssured.get("/home/saurabh/IdeaProjects/AaddressBookMain/src/main/resources/");
    return response;
    }

    @Test
    public void onCallingList_ReturnPersonList() {
        Response response=getPersonList();
        System.out.println("First: " + response.asString());
        response.then().body("id", Matchers.hasItems(1,2));
        response.then().body("title", Matchers.hasItems("json-server"));

    }
}
