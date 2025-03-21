package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class NewContactModalPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @FindBy(xpath = "//*[contains(text(), 'Account Name')]/ancestor::*[contains(@slot, 'inputField')]")
    public WebElement accountNameDropdown;

    @FindBy(xpath = "//ul[@aria-label='Recent Accounts']//li[2]")
    public WebElement accountDropdownItem;

    @FindBy(xpath = "//*[@name = 'SaveEdit']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@name = 'SaveAndNew']")
    public WebElement saveAndNewButton;

    @FindBy(xpath = "//*[@name = 'CancelEdit']")
    public WebElement cancelButton;

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }

    public NewContactModalPage openPage(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-container")));
        return this;
    }

    public void createNewContact(Contact contact) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new Dropdown(driver, "Salutation").accountSelectOption(contact.getSalutation());
        new Input(driver, "First Name").writeTextToInput(contact.getContactName());
        new Input(driver, "Last Name").writeTextToInput(contact.getContactLastName());
        new Dropdown(driver, "Account Name").contactSelectAccount(contact.getAccountContactName());
        new Input(driver, "Description").writeTextToTextArea(contact.getDescription());
        new Input(driver, "Phone").writeTextToInput(contact.getContactPhone());
        new Input(driver, "Email").writeTextToInput(contact.getContactEmail());
        new Button(driver).clickButton(saveButton);
    }
}
