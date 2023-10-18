package web.testSuite.tareasWebUI;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import web.session.Session;
import web.pages.todoistPages.LoginPage;
import web.pages.todoistPages.MainPage;
import web.pages.todoistPages.Workspace;

public class todoistLoginTest {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    Workspace workspacePage = new Workspace();
    String email = "juanclaapi@test.com";
    String password = "asdfgh1234";
    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }

    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://todoist.com/");
    }
    @Test
    public void loginTest() throws InterruptedException {
        if(mainPage.loginButton.isControlDisplayed()) {
            mainPage.loginButton.click();
        }else{
            mainPage.loginMobile();
        }

        Thread.sleep(3000);
        loginPage.emailTextBox.setText(email);
        loginPage.passwordTextBox.setText(password);
        loginPage.loginButton.click();
        Thread.sleep(10000);
        Assertions.assertTrue(workspacePage.profileButton.isControlDisplayed(), "ERROR no se pudo iniciar sesion");
    }
}
