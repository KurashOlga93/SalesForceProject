package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.AccountListPage.ACCOUNT_NAME_FIELD_XPATH;

public class ContactListPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public static final String TABLE_XPATH = "//table";
    public static final String CONTACT_NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains(@title, '%s')]";
    public static final String PHONE_BY_CONTACT_NAME_XPATH = CONTACT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'forceOutputPhone')]";
    public static final String CONTACT_OWNER_BY_ACCOUNT_NAME_XPATH = CONTACT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'uiOutputText')]";
    public static final String CONTACT_EMAIL_FIELD_XPATH = CONTACT_NAME_FIELD_XPATH + "/ancestor::tbody//*[contains(@class, 'emailuiFormattedEmail')]";

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public ContactListPage openPage(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
        return this;
    }

    public String getExistAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, accountName ))).getText();
    }

    public String getExistContactName(String contactName) {
        return driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, contactName ))).getText();
    }

    public String getExistPhoneNumberByContactName(String contactName) {
        return driver.findElement(By.xpath(String.format(PHONE_BY_CONTACT_NAME_XPATH, contactName ))).getText();
    }

    public String getExistContactEmail(String contactName) {
        return driver.findElement(By.xpath(String.format(CONTACT_EMAIL_FIELD_XPATH, contactName ))).getText();
    }

    public ContactCardPage clickOnContactName(String contactName) {
        driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, contactName))).click();
        return new ContactCardPage(driver);
    }
}
