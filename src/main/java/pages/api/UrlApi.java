package pages.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pages.api.UrlForApi;

public class UrlApi {
    public static RequestSpecification baseApi(){
        return new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(UrlForApi.burgerUrl).build();
    }
}