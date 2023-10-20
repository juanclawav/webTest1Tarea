package web.testSuite.filaA;

import web.testSuite.filaC.testBaseTodoist;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ej4 extends testBaseTodoist {
    // 4) 15% Web UI> Create 1 Task (todoist)
    @Test
    public void testing() throws InterruptedException {
        login();
        Thread.sleep(5000);
        createTask();
    }

    private void createTask() throws InterruptedException {
        Random rnd = new Random();
        String randomContent = "Task"+rnd.nextInt();
        Thread.sleep(5000);
        appPage.addTaskButton.click();
        Thread.sleep(5000);
        appPage.taskNameInput.setText(randomContent);
        appPage.addTaskConfirmButton.click();
        Thread.sleep(5000);
        Assertions.assertTrue(appPage.getTaskButton(randomContent).isControlDisplayed(),
                "Error: No se creo la tarea");
    }
}