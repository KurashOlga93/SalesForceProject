package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {

    WebDriver driver;
    String label;

    private static final String DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//button";
    private static final String DROPDOWN_OPTION_XPATH = "//*[contains(@title, '%s')]";
    private static final String ACCOUNT_NAME_DROPDOWN_OPTION_XPATH = "//*[contains(text(), 'Account Name')]/ancestor::*[contains(@slot, 'inputField')]";
    private static final String ACCOUNT_SELECT_ACCOUNT_XPATH =
            "//label[contains(text(),'Account Name')]/ancestor::lightning-grouped-combobox[contains(@class,'slds-form-element')]//*[@title='%s']";


    public Dropdown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void accountSelectOption(String option) {
        driver.findElement(By.xpath(String.format(DROPDOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(DROPDOWN_OPTION_XPATH, option))).click();
    }

    public void selectAccountNameFromDropdown(String option) {
        driver.findElement(By.xpath(String.format(ACCOUNT_NAME_DROPDOWN_OPTION_XPATH, label))).click();
    }

    public void contactSelectAccount(String option) {
        new Input(driver, "Account Name").writeTextInDropdownField(option);
        driver.findElement(By.xpath(String.format(ACCOUNT_SELECT_ACCOUNT_XPATH,option))).click();
    }
}
