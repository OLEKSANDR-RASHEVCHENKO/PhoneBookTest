package E2E.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EdinContactForm extends ContactsPageInfo{
    public EdinContactForm(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@class='btn btn-secondary cancel-btn-ec']")
    WebElement cancelButton;
    @FindBy(xpath = "//button[@class='btn btn-primary submit-btn-ec']")
    WebElement saveButton;

    @FindBy(xpath = "//input[@name='input-ec-firstName']")
    WebElement firstNameInput;
    @FindBy(xpath = "//input[@name='input-ec-lastName']")
    WebElement lastNameInput;
    @FindBy(xpath = "//textarea[@name='input-ec-description']")
    WebElement descriptionInput;

    public void setFirstNameInput(String firstName){
        setInput(firstNameInput,firstName);
    }
    public void setLastNameInput(String lastName){
        setInput(lastNameInput,lastName);
    }
    public void setDescriptionInput(String description){
        setInput(descriptionInput,description);
    }
    public void saveChanges() throws InterruptedException {
        Assert.assertTrue(isElementDisplayed(saveButton),"Save contact button is not visible");
        saveButton.click();
        Thread.sleep(2000);
        Assert.assertFalse(isElementDisplayed(descriptionInput),"Edit Contact form was opened");
    }
}
