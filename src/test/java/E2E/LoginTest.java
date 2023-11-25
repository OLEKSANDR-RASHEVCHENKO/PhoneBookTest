package E2E;

import E2E.pages.ContactsPage;
import E2E.pages.LoginPage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    LoginPage loginPage;
    ContactsPage contactsPage;

    @Test
    public void userCanLogin(){
        String email = "newtest@gmail.com";
        String password = "newtest@gmail.com";

        loginPage=new LoginPage(app.driver);
        loginPage.login(email,password);
        contactsPage = new ContactsPage(app.driver);
        Assert.assertTrue(contactsPage.confirmLogin(),"User was logged");
    }
    @Test
    public void userCannotLoginWithInvalidEmail(){
        String email ="newTest@gmail.com";
        String password ="newtest@gmail.com";
        loginPage = new LoginPage(app.driver);
        loginPage.login(email,password);

        contactsPage=new ContactsPage(app.driver);
        Assert.assertTrue(contactsPage.confirmLogin(),"User wasn't logged");
    }
    @Test
    public void userCannotLoginWithInvalidPassword(){
        String email ="newtest@gmail.com";
        String password ="newTest@gmail.com";
        loginPage=new LoginPage(app.driver);
        loginPage.login(email,password);

        contactsPage=new ContactsPage(app.driver);
        Assert.assertFalse(contactsPage.confirmLogin(),"User wasn't logged");
    }

}
