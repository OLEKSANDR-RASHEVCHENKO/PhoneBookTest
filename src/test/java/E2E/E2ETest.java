package E2E;

import E2E.pages.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2ETest extends TestBase{
    LoginPage loginPage;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactsPageInfo contactsPageInfo;
    EdinContactForm edinContactForm;
    DeleteContactDialog deleteContactDialog;
    Faker faker = new Faker();
    private void checkContactData(ContactsPageInfo page,String firstName,String lastName,String description){
        String actualFirstName = page.getFirstName();
        String actualLastName = page.getLastName();
        String actualDescription = page.getDescription();
        Assert.assertEquals(actualFirstName,firstName,actualFirstName+ " is not equal " +firstName);
        Assert.assertEquals(actualLastName,lastName,actualLastName+ " is not equal " +lastName);
        Assert.assertEquals(actualDescription,description,actualDescription+ " is not equal " +description);
    }
    @Test
    public void UserCanUseWebsite(){
        String email = "newtest@gmail.com";
        String password = "newtest@gmail.com";

        String firsName = faker.internet().domainName();
        String lastName = faker.internet().url();
        String description = faker.lorem().sentence();

        String editFirsName = faker.internet().uuid();
        String editLastName = faker.internet().uuid();
        String editDescription = faker.internet().uuid();

        loginPage =new LoginPage(app.driver);
        loginPage.login(email,password);

        contactsPage = new ContactsPage(app.driver);
        Assert.assertTrue(contactsPage.confirmLogin());

        addContactDialog = contactsPage.openAddContactDialog();
        addContactDialog.isAddDialogForVisible();
        addContactDialog.setAddContactForm(firsName,lastName,description);
        addContactDialog.saveContact();

        contactsPageInfo = new ContactsPageInfo(app.driver);
        contactsPageInfo.isContactInfoPageVisible();
        checkContactData(contactsPageInfo,firsName,lastName,description);

        edinContactForm = contactsPageInfo.openEditContactsForm();
        edinContactForm.setFirstNameInput(editFirsName);
        edinContactForm.setLastNameInput(editLastName);
        edinContactForm.setDescriptionInput(editDescription);

        checkContactData(contactsPageInfo,editFirsName,editLastName,editDescription);

        contactsPageInfo.openContactsPage();
        contactsPage.filterByContact(editFirsName);
        int actualContactCountRow = contactsPage.getContactCount();
        Assert.assertEquals(actualContactCountRow,1,"Contact count row after filter should be 1 ");








    }
}
