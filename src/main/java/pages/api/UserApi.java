package pages.api;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static pages.api.UrlApi.baseApi;

public class UserApi {
    public static Response deleteUser(String accessToken){
        return given()
                .spec(baseApi())
                .header("Authorization", accessToken)
                .when()
                .delete(UrlForApi.urlDelete);
    }
    static public Response loginUser(String email, String password){
        DataForUser dataForUser = new DataForUser(email, password);
        return given()
                .spec(baseApi())
                .header("Content-type", "application/json")
                .and()
                .body(dataForUser)
                .when()
                .post(UrlForApi.urlLoginUser);
    }
    public static Response createCourier(String name , String email , String password){
        DataForRegistration dataForRegistration = new DataForRegistration(name, email, password);
        return given()
                .spec(baseApi())
                .header("Content-type", "application/json")
                .and()
                .body(dataForRegistration)
                .when()
                .post(UrlForApi.urlCreate);
    }
}
