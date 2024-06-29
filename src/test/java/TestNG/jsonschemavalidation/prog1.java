package TestNG.jsonschemavalidation;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import java.io.File;

public class prog1
{
    @Test
    public void JSValidation(){
        RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com/posts/2")
                .when().get().then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\kavya\\Documents\\REST Assured_API Testing\\REST_Assured_Programs\\src\\test\\java\\TestNG\\jsonschemavalidation\\schema.json")));

        /*  what ever the response that is coming from above mentioned URL will be compared to "schema.json" file.
        if both are same then TC will pass

        Logon to -- https://jsonschema.net/login
        Copy any valid response and submit, it ill generate json schema.
        Copy the schema and come to intelliJ and create file "schema.json" and paste the schema
         */
    }
}
