package E2E.pages;

import E2E.enums.ContactInfoTabs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactsPageInfo extends ContactsPage{
    public ContactsPageInfo(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='contact-first-name']")
    WebElement firstNameField;
    @FindBy(xpath = "//div[@id='contact-last-name']")
    WebElement lastNameField;
    @FindBy(xpath = "//div[@id='contact-description']")
    WebElement descriptionField;
    @FindBy(xpath = "//button[@id='btn-edit-contact']")
    WebElement editButton;

    public void openTab(ContactInfoTabs tab){
        driver.findElement(By.xpath("//*[@id='ngb-nav-"+tab.value+"]")).click();
    }
    public String getFirstName(){
        return firstNameField.getText();}
    public String getLastName(){
        return lastNameField.getText();
    }
    public String getDescription(){
        return descriptionField.getText();
    }
    public EdinContactForm openEditContactsForm(){
        editButton.click();
        Assert.assertFalse(isElementDisplayed(firstNameField),"Edit contacts form was not opened");
        return new EdinContactForm(driver);
    }


}
