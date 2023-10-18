package web.testSuite.tareasWebUI;


import org.junit.jupiter.api.*;
import web.pages.todolyPages.LoginSection;
import web.pages.todolyPages.MainPage;
import web.pages.todolyPages.MenuSection;
import web.pages.todolyPages.SettingsPage;
import web.session.Session;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class todolyNameUpdateTest {

    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();

    SettingsPage settingsPage = new SettingsPage();

    static Random rand = new Random();
    static String fullName;

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }

    @BeforeEach
    public void open() throws InterruptedException {
        Session.getInstance().getBrowser().get("http://todo.ly/");
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("jcctapi@jcctapi.com");
        loginSection.pwdTextBox.setText("12345");
        loginSection.loginButton.click();
        Thread.sleep(3000);
    }

    @Test
    @Order(1)
    public void updateFullName() throws InterruptedException{
        fullName="JuanClaudioCarrasco";
        menuSection.settingsBtn.click();
        Thread.sleep(1000);
        settingsPage.fullNameInput.clearSetText(fullName);
        settingsPage.okButton.click();
        Thread.sleep(2000);
        menuSection.settingsBtn.click();
        Thread.sleep(1000);
        String result = settingsPage.fullNameInput.getText();
        Assertions.assertEquals(fullName, result, "ERROR: no se pudo cambiar el nombre");
    }
}