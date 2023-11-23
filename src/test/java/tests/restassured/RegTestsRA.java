package tests.restassured;

import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegTestsRA extends BaseRA{

    @Test
    public void RegStatusCodeTest() {

        // System.out.println("token from base" + token);
        System.out.println(userReg);
        Assert.assertEquals(userApi.getStatusCodeResponseReg(userReg), 200,
                "status code not 200 for Reg test with correct data");
    }

    @Test
    public void testToken() {
        System.out.println("token " + userApi.getTokenFromRegResponse(userReg));
    }

    @Test
    public void negativeReg() {
        userApi.setResponseRegNull();
        UserDtoLombok user1 = UserDtoLombok.builder()
                .username("testqa20@gmail.com")
                .password("123456Aa")
                .build();
        int statusCode = userApi.getStatusCodeResponseReg(user1);
        userApi.setResponseRegNull();
        Assert.assertEquals(statusCode, 400);
    }
}
