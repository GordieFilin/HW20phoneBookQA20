package api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import dto.MessageResponseDTO;
import dto.NewContactDto;
import dto.UpdateContactDTO;

public class ContactsService extends BaseApi{
    Response responseAddNewContact = null;
    Response responseDeleteOneContact = null;
    Response responseUpdateContact = null;

    // ------------------------------------------ responseAddNewContact

    private Response getResponseAddNewContact(NewContactDto newContactDto, String token) {
        responseAddNewContact = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(newContactDto)
                .when()
                .post(baseUrl + "/v1/contacts");
        return responseAddNewContact;
    }

    private Response getResponseUpdateContact(UpdateContactDTO updateContactDTO, String token){
        responseUpdateContact = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(updateContactDTO)
                .when()
                .put(baseUrl + "/v1/contacts");
        return responseUpdateContact;
    }

    public void setResponseAddNewContactNull() {
        responseAddNewContact = null;
    }

    public int getStatusCodeResponseAddNewContact(NewContactDto contactDto, String token) {
        if(responseAddNewContact == null) {
            responseAddNewContact = getResponseAddNewContact(contactDto, token);
        }
        return responseAddNewContact.getStatusCode();
    }

    public String getMessagePositiveResponseAddNewContact(NewContactDto contactDto, String token) {
        if(responseAddNewContact == null) {
            responseAddNewContact = getResponseAddNewContact(contactDto, token);
        }
        return responseAddNewContact.getBody().as(MessageResponseDTO.class).getMessage();
    }

    public int getStatusCodeResponseUpdateContact(UpdateContactDTO updateContactDTO, String token) {
        if(responseUpdateContact == null) {
            responseUpdateContact = getResponseUpdateContact(updateContactDTO, token);
        }
        return responseUpdateContact.getStatusCode();
    }

    public String getMessagePositiveResponseUpdateContact(UpdateContactDTO updateContactDTO, String token) {
        if(responseUpdateContact == null) {
            responseUpdateContact = getResponseUpdateContact(updateContactDTO, token);
        }
        return responseUpdateContact.getBody().as(MessageResponseDTO.class).getMessage();
    }

    //-----------------------------------------------------------------------------------------

    // ----------------------------------
}
