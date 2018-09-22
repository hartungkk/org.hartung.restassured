package Controllers;

import Models.PetModel;
import Models.PetNotFoundModel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class PetController {
    private final static String apiKey = "lklllkklklklkllk";
    private RequestSpecification requestSpecification;
    private PetModel pet;


    public PetController(PetModel testPet) {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", apiKey)
                .setBaseUri("http://petstore.swagger.io")
                .setBasePath("/v2/pet")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(15000L))
                .build();
        defaultParser = Parser.JSON;
        this.pet = testPet;
    }

    public PetModel addNewPet() {
        return given(requestSpecification)
                .body(pet)
                .post().as(PetModel.class);
    }

    public void deletePet() {
        given(requestSpecification)
                .delete(String.valueOf(pet.getId()));
    }

    public PetModel updatePet() {
        return given(requestSpecification)
                .body(pet)
                .put().as(PetModel.class);
    }



    public Object getPet() {
        Response response = given(requestSpecification).get(String.valueOf(pet.getId()));
        if (response.statusCode() == 200) {
            return response.as(PetModel.class);
        } else {
            return response.as(PetNotFoundModel.class);
        }
    }


}
