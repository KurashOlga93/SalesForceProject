package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void createAccountTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setDescription("nothing");
        account.setPhone("80296546637");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);
        softAssert.assertEquals(accountListPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        softAssert.assertEquals(accountListPage.getExistPhoneNumberByAccountName(account.getAccountName()), account.getPhone());
    }

    @Test
    public void AccountCardTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Analyst");
        account.setDescription("nothing");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL)
                        .clickOnAccountName(account.getAccountName());
        softAssert.assertEquals(accountCardPage.getFieldValueByName(account.getAccountName()), account.getAccountName());
        softAssert.assertEquals(accountCardPage.getFieldValueByName(account.getWebSite()), account.getWebSite());
        softAssert.assertEquals(accountCardPage.getFieldValueByName(account.getType()), account.getType());
        softAssert.assertEquals(accountCardPage.getFieldValueByName(account.getDescription()), account.getDescription());
    }
}