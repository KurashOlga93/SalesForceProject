package tests;

import objects.Account;
import objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class ContactTest extends BaseTest {

    @Test
    public void createContactTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setDescription("nothing");
        account.setPhone("80296546637");

        Contact contact = new Contact();
        contact.setSalutation("Ms.");
        contact.setContactName("Olga");
        contact.setContactLastName("Svetkova");
        contact.setAccountContactName(account.getAccountName());
        contact.setDescription("Contact description");
        contact.setContactPhone("123456789");
        contact.setContactEmail("olga93@mail.ru");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactListPage.openPage(CONTACT_LIST_URL);
        String contactName = contactListPage.getExistContactName(contact.getContactName());
        String accountName = contactListPage.getExistAccountName(contact.getAccountContactName());
        String contactPhone = contactListPage.getExistPhoneNumberByContactName(contact.getAccountContactName());
        String contactEmail = contactListPage.getExistContactEmail(contact.getAccountContactName());
        softAssert.assertEquals(contactName, contact.getContactName());
        softAssert.assertEquals(accountName, contact.getAccountContactName());
        softAssert.assertEquals(contactPhone, contact.getContactPhone());
        softAssert.assertEquals(contactEmail, contact.getContactEmail());
    }

    @Test
    public void contactCardTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setDescription("nothing");
        account.setPhone("80296546637");

        Contact contact = new Contact();
        contact.setSalutation("Ms.");
        contact.setContactName("Olga");
        contact.setContactLastName("Svetkova");
        contact.setAccountContactName(account.getAccountName());
        contact.setDescription("Contact description");
        contact.setContactPhone("123456789");
        contact.setContactEmail("olga93@mail.ru");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactListPage.openPage(CONTACT_LIST_URL)
                       .clickOnContactName(contact.getContactName());
        softAssert.assertEquals(contactCardPage.getFieldValueByName("Ms. Olga Svetkova"), "Ms. Olga Svetkova");
        softAssert.assertEquals(contactCardPage.getFieldValueByName(contact.getAccountContactName()), contact.getAccountContactName());
        softAssert.assertEquals(contactCardPage.getFieldValueByName(contact.getDescription()), contact.getDescription());
        softAssert.assertEquals(contactCardPage.getFieldValueByName(contact.getContactPhone()), contact.getContactPhone());
        softAssert.assertEquals(contactCardPage.getFieldValueByName(contact.getContactEmail()), contact.getContactEmail());
    }
}