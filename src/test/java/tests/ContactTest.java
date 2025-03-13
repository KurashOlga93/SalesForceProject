package tests;

import objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

    @Test
    public void createContactTest() {
        Contact contact = new Contact();
        contact.setSalutation("Ms.");
        contact.setContactName("Laura");
        contact.setContactLastName("Roy");
        contact.setAccountContactName("account7");
        contact.setDescription("Contact description");
        contact.setContactPhone("123456789");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newContactModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactListPage.openPage(CONTACT_LIST_URL);
        Assert.assertEquals(contactListPage.getExistContactName(contact.getAccountContactName()), contact.getAccountContactName());
        Assert.assertEquals(contactListPage.getExistPhoneNumberByContactName(contact.getAccountContactName()), contact.getContactPhone());
    }
}
