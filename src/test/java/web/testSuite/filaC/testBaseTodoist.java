package web.testSuite.filaC;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import web.pages.todoistPages.*;
import web.session.Session;

public class testBaseTodoist {

    public MainPage landingPage = new MainPage();
    public registerPage signUpPage = new registerPage();
    public LoginPage loginPage = new LoginPage();
    public Workspace appPage = new Workspace();
    public SettingsOverlay settingsPage = new SettingsOverlay();
    public ProjectSection projectsSection = new ProjectSection();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
            Session.getInstance().goTo("https://todoist.com/");
    }

    public void login() throws InterruptedException {
        landingPage.enterLoginButton.click();
        Thread.sleep(8000);

        loginPage.emailInput.setText("juanclaapi@test.com");
        loginPage.passwordInput.setText("qwerty12345");

        loginPage.logInButton.click();
        Thread.sleep(5000);

    }
}