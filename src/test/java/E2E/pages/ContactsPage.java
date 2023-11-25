package E2E.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='collapse navbar-collapse']")
    WebElement header;
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

    public boolean confirmLogin() {
        return header.isDisplayed();
    }

    public AddContactDialog openAddContactDialog(){
        addContactButton.click();
        return new AddContactDialog(driver);
    }
    public void openDeleteDialog(){
        deleteButton.click();
    }
    public void setSearchInputField(String contactValue){
        searchInputField.sendKeys(contactValue);
    }
}