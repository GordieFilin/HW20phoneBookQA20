package tests.restassured;

import api.ContactsService;
import api.UserApi;
import dto.NewContactDto;
import dto.UpdateContactDTO;
import dto.UserDtoLombok;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import utils.RandomUtils;

public class BaseRA {
    SoftAssert softAssert = new SoftAssert();
    UserApi userApi = new UserApi();
    ContactsService contactsService = new ContactsService();
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoidGVzdHFhMjBAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE3MDEzNDAyMzEsImlhdCI6MTcwMDc0MDIzMX0.Zt4Vz1trLtBRqqAh550tsSItTgHbS8rt_G6iM-kMMpE";
    RandomUtils randomUtils = new RandomUtils();
    String email = randomUtils.generateEmail(7);

    UserDtoLombok user = UserDtoLombok.builder()
            .username("testqa20@gmail.com")
            .password("123456Aa$")
            .build();
    UserDtoLombok userReg = UserDtoLombok.builder()
            .username(email)
            .password("123456Aa$")
            .build();

//    @BeforeSuite
//    public void preCondApiRA() {
//        token = userApi.getTokenFromLoginResponse(user);
//    }

    public NewContactDto createNewContact() {
        String phoneNumber = randomUtils.generateStringDigits(12);
        NewContactDto contact1 = NewContactDto.builder()
                .address("sjdfkbwi")
                .description("bdfigyeg")
                .email("sjdfnsjhb@mail.com")
                .id("0")
                .lastName("sjkdbfh")
                .name("nbsefdj")
                .phone(phoneNumber)
                .build();
        return contact1;
    }
    public UpdateContactDTO updateContact() {
        String phoneNumber = randomUtils.generateStringDigits(12);
        UpdateContactDTO contactUpd = UpdateContactDTO.builder()
                .address("sjdfkbwi")
                .description("bdfigyeg")
                .email("sjdfnsjhb@mail.com")
                .id("4e6c1e9c-d89e-407e-a981-8ab23a4e1a76")
                .lastName("sjkdbfh")
                .name("nbsefdj")
                .phone(phoneNumber)
                .build();
        return contactUpd;
    }
}
