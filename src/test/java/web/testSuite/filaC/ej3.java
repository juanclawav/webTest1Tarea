package web.testSuite.filaC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;
public class ej3 extends testBaseTodoist {
    //    3) 15% Web UI > Update the name account (settings>account)(Todoist)
    private final Random rnd = new Random();

    @Test
    public void testing() throws InterruptedException {
        login();
        updateName();
    }

    private void updateName() throws InterruptedException {
        String randomName = "Name" + rnd.nextInt();

        appPage.profileButton.click();
        Thread.sleep(8000);
        appPage.settingsButton.click();
        Thread.sleep(5000);

        settingsPage.nameInput.clearSetText(randomName);
        settingsPage.updateButton.click();
        Thread.sleep(5000);

        settingsPage.closeSettingsButton.click();
        Thread.sleep(8000);

        Assertions.assertTrue(appPage.getProfileName(randomName).isControlDisplayed(),
                "Error: No se cambio el nombre");
    }

}