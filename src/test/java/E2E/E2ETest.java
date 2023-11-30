package E2E;

import E2E.pages.*;
import com.github.javafaker.Faker;
import org.testng.Assert;

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

}
