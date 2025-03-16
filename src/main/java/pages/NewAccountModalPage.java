package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class NewAccountModalPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @FindBy(xpath = "//*[@name = 'SaveEdit']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@name = 'SaveAndNew']")
    public WebElement saveAndNewButton;

    @FindBy(xpath = "//*[@name = 'CancelEdit']")
    public WebElement cancelButton;

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public NewAccountModalPage openPage(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-container")));
        return this;
    }

    public void createNewAccount(Account account) {
        new Input(driver, "Account Name").writeTextToInput(account.getAccountName());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new Input(driver, "Website").writeTextToInput(account.getWebSite());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new Dropdown(driver, "Type").accountSelectOption(account.getType());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new Input(driver, "Description").writeTextToTextArea(account.getDescription());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new Input(driver, "Phone").writeTextToInput(account.getPhone());
        new Button(driver).clickButton(saveButton);
    }
}
