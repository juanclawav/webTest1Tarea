package web.testSuite.tareasWebUI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class todoistPasswordChangeTest extends testBaseTodoist {

    String oldPassword = "qwerty12345678901234";
    String newPassword = "qwerty12345";

    @Test
    public void verifyChangePasswordTest() throws InterruptedException {
        mainTodoistPage.loginButton.click();
        Thread.sleep(5000);
        loginPage.emailTextBox.setText("juanclaapi@test.com");
        loginPage.passwordTextBox.setText(oldPassword);
        loginPage.loginButton.click();
        Thread.sleep(10000);
        workspace.profileButton.click();
        workspace.settingsButton.click();
        Thread.sleep(5000);
        settingsOverlay.changePasswordButton.click();
        Thread.sleep(5000);
        changePasswordSection.oldPasswordTextBox.setText(oldPassword);
        changePasswordSection.newPasswordTextBox.setText(newPassword);
        changePasswordSection.repeatNewPasswordTextBox.setText(newPassword);
        changePasswordSection.changePasswordButton.click();
        Thread.sleep(5000);
        settingsOverlay.exitSettingsButton.click();
        workspace.profileButton.click();
        workspace.logoutButton.click();
        Thread.sleep(5000);
        mainTodoistPage.loginButton.click();
        Thread.sleep(5000);
        loginPage.emailTextBox.setText("juanclaapi@test.com");
        loginPage.passwordTextBox.setText(newPassword);
        loginPage.loginButton.click();
        Thread.sleep(10000);

        Assertions.assertTrue(workspace.profileButton.isControlDisplayed(), "ERROR!! No se pudo iniciar sesion con la nueva contrasena");

    }

}