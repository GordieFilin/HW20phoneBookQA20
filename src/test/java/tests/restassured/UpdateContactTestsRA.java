package tests.restassured;

import org.testng.annotations.Test;

public class UpdateContactTestsRA extends BaseRA{

    @Test
    public void UpdateContactTests() {
        softAssert.assertEquals(contactsService.getStatusCodeResponseUpdateContact(updateContact(), token), 200);
        softAssert.assertTrue(contactsService.getMessagePositiveResponseUpdateContact(updateContact(), token)
                .contains("Contact was updated"));
        softAssert.assertAll();
    }
//    @Test
//    public void messagePositiveUpdateContact() {
//        System.out.println(contactsService.getMessagePositiveResponseUpdateContact(updateContact(), token));
//        softAssert.assertTrue(contactsService.getMessagePositiveResponseUpdateContact(updateContact(), token)
//              .contains("Contact was updated"));
//
//        softAssert.assertAll();
//    }
}
