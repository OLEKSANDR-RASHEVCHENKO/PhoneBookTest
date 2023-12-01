package E2E.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactsPage extends BasePage {

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='collapse navbar-collapse']")
    WebElement header;
    @FindBy(xpath = "//div[@class='collapse navbar-collapse']//*[@href='/']")
    WebElement contactsButton;
    @FindBy(xpath = "//*[@href='contacts']")
    WebElement addContactButton;
    @FindBy(xpath = "//*[text()='Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//*[@id='langSelect']")
    WebElement languageDropdown;
    @FindBy(xpath = "//*[@ng-reflect-router-link='account']")
    WebElement accountButton;
    @FindBy(xpath = "//*[@id='contacts-list']")
    WebElement contactsList;
    @FindBy(xpath = "//*[@formcontrolname='searchInput']")
    WebElement searchInputField;
    @FindBy(xpath = "//*[@src='/assets/icons/trash.svg']")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@type='warning']")
    WebElement noResultsMessage;


    public boolean confirmLogin() {
        return header.isDisplayed();
    }
    public void openContactsPage(){
        contactsButton.click();
    }
    public int getContactCount(){
        return driver.findElements(By.xpath("//*[@id='contacts-list']//*[@class='list-group']")).size();
    }

    public AddContactDialog openAddContactDialog(){
        addContactButton.click();
        return new AddContactDialog(driver);
    }
    public DeleteContactDialog openDeleteDialog(){
        deleteButton.click();
        return new DeleteContactDialog(driver);
    }
    public void filterByContact(String contactValue){
        searchInputField.sendKeys(contactValue);
    }
    public boolean isNoResultMessageDisplayed(){
        return isElementDisplayed(noResultsMessage);
    }

}