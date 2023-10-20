package web.testSuite.filaA;


import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import web.testSuite.tareasWebUI.testBaseTodoly;

public class ej3 extends testBaseTodoly {
    private final Random rnd = new Random();

    @Test
    public void testing() {
        createUser();
        createProject();
    }

    private void createUser() {
        String randomEmail = "juanito" + rnd.nextInt() + "@gmail.com";
        String randomPassword = "pass" + rnd.nextInt();

        mainPage.signupBtn.click();
        signupPopup.nameTb.setText("Juan Claudio");
        signupPopup.emailTb.setText(randomEmail);
        signupPopup.pwTb.setText(randomPassword);

        signupPopup.termCb.click();
        signupPopup.signupBtn.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "Error: No se pudo crear la cuenta");
    }

    private void createProject(){
        String randomProjectName = "Project " + rnd.nextInt();

        menuSection.addNewProjectBtn.click();
        menuSection.projectNameTb.setText(randomProjectName);
        menuSection.addProjectBtn.click();

        Assertions.assertTrue(menuSection.selectProjectButton(randomProjectName).isControlDisplayed(),
                "Error: No se pudo crear el projecto");
    }
}
