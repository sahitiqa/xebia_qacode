package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Firststeps {

    Response response;

     @Given("^I enter the URL for the service$")
            public void URL(){
            RestAssured.baseURI="https://jsonplaceholder.typicode.com";
    }

    @When("^I get the response (.*)$")
    public void iGetTheResponseParameter(String param) {
            response=given().header("Content-Type","application/json").when().get(param).
                    then().log().all().assertThat().statusCode(200).extract().response();
    }

    @Then("^I assert for validation (.*) and (.*)$")
    public void iAssertForValidationResponseAndTitle(int res, String xyz) {
            int responseCode=response.getStatusCode();
            String body=response.getBody().as(PostPojo.class).getBody();
            //Compare Expected with Actual Value
            Assert.assertEquals(responseCode,res);
            Assert.assertEquals(body,xyz);
    }
    
}
