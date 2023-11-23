package api;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import dto.AuthResponseDTO;
import dto.UserDtoLombok;

import static com.jayway.restassured.RestAssured.given;

public class UserApi extends BaseApi {

    Response responseLogin = null;
    Response responseReg = null;

    private Response loginRequest(UserDtoLombok user) {
        System.out.println("----------------------- loginRequest method run");
        responseLogin = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(baseUrl + "/v1/user/login/usernamepassword")
                .thenReturn();
        return responseLogin;
    }
    private Response regRequest(UserDtoLombok userReg) {
        System.out.println("----------------------- RegRequest method run");
        responseReg = given()
                .contentType(ContentType.JSON)
                .body(userReg)
                .when()
                .post(baseUrl + "/v1/user/registration/usernamepassword")
                .thenReturn();
        return responseReg;
    }

    public void setResponseLoginNull() {
        responseLogin = null;
    }

    public void setResponseRegNull(){
        responseReg = null;
    }

    public int getStatusCodeResponseLogin(UserDtoLombok user) {
        if(responseLogin == null) {
            responseLogin = loginRequest(user);
        }
        System.out.println(responseLogin);
        return responseLogin.getStatusCode();
    }

    public int getStatusCodeResponseReg(UserDtoLombok userReg) {
        if(responseReg == null) {
            responseReg = regRequest(userReg);
        }
        System.out.println(responseReg);
        return responseReg.getStatusCode();
    }



    public String getTokenFromLoginResponse(UserDtoLombok user) {
        if(responseLogin == null) {
            responseLogin = loginRequest(user);
        }
        return responseLogin.getBody().as(AuthResponseDTO.class).getToken();
    }

    public String getTokenFromRegResponse(UserDtoLombok userReg) {
        if(responseReg == null) {
            responseReg = regRequest(userReg);
        }
        return responseReg.getBody().as(AuthResponseDTO.class).getToken();
    }


}
