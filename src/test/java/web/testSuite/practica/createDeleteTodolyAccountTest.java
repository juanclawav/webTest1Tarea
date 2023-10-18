package web.testSuite.practica;

import org.junit.jupiter.api.Assertions;
import web.testSuite.tareasWebUI.testBaseTodoly;
import org.junit.jupiter.api.Test;

public class createDeleteTodolyAccountTest extends testBaseTodoly {
    String name = "Juan";
    String email = "jcctapi@fffddd.com";
    String password = "123456";
    @Test
    public void createDeleteAccountTest() throws InterruptedException{
        Thread.sleep(5000);
        mainPage.signupBtn.click();
        Thread.sleep(5000);
        signupPopup.nameTb.setText(name);
        signupPopup.emailTb.setText(email);
        signupPopup.pwTb.setText(password);
        signupPopup.termCb.click();
        signupPopup.signupBtn.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),"\"ERROR! no se pudo registrar nuevo usuario\"");

        menuSection.settingsBtn.click();
        settingsPage.accountStgsBtn.click();
        settingsPage.deleteAccountBtn.click();

        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(email);
        loginSection.pwdTextBox.setText(password);
        loginSection.loginButton.click();
        Assertions.assertTrue(loginSection.errorToast.isControlDisplayed(), "\"ERROR!  No se pudo borrar la cuenta\"");
    }
}
