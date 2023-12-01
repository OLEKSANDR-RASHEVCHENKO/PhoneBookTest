package E2E.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddContactDialog extends BasePage {
    public AddContactDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@role='dialog']")
    WebElement dialog;
    @FindBy(xpath = "//*[@id='form-name']")
    WebElement firstnameInput;

    @FindBy(xpath = "//*[@id='form-lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//*[@id='form-about']")
    WebElement descriptionInput;

    @FindBy(xpath = "//*[@type='reset']")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@role='dialog']//*[@type='submit']")
    WebElement saveButton;
    @FindBy(xpath = "//*[@aria-label='Close']")
    WebElement closeWindowButton;
    @FindBy(xpath = "//*[@id='form-error-firstName']")
    WebElement errorMassage;

    public void setLastNameInput(String lastName) {
        setInput(lastNameInput, lastName);
    }

    public void setFirstNameInput(String firstName) {
        setInput(firstnameInput, firstName);
    }

    public void setDescriptionInput(String description) {
        setInput(descriptionInput, description);
    }

    public void setAddContactForm(String firstName, String lastName, String description) {
        setFirstNameInput(firstName);
        setLastNameInput(lastName);
        setDescriptionInput(description);
    }

    public void saveContact() {
        try {
            saveButton.click();
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }

    public void isAddDialogForVisible(){
        Assert.assertTrue(isElementDisplayed(dialog));
    }

}
