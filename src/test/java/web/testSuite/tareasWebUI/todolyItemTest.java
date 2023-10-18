package web.testSuite.tareasWebUI;


import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import web.pages.todolyPages.LoginSection;
import web.pages.todolyPages.MainPage;
import web.pages.todolyPages.MenuSection;
import web.session.Session;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class todolyItemTest {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    static Random rand = new Random();
    static String nameProject;

    static String newItem;
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
    public void createProject() throws InterruptedException {
        nameProject="newProject2";
        menuSection.addNewProjectBtn.click();
        Thread.sleep(2000);
        menuSection.projectNameTb.setText(nameProject);
        Thread.sleep(2000);
        menuSection.addProjectBtn.click();
        Thread.sleep(5000);
        Assertions.assertTrue(menuSection.newestProject(nameProject).isControlDisplayed(), "ERROR no se pudo crear el proyecto");
    }

    @Test
    @Order(2)
    public void createItem() throws InterruptedException{
        newItem = "Tarea WEBUI";
        menuSection.newestProject(nameProject).click();
        Thread.sleep(3000);
        menuSection.addItemTb.setText(newItem);
        menuSection.addItemBtn.click();
        Thread.sleep(3000);
        Assertions.assertTrue(menuSection.newestItem(newItem).isControlDisplayed(), "ERROR no se pudo crear el item");
    }

    @Test
    @Order(3)
    public void updateItem() throws InterruptedException{
        String update = "UPDATED";
        menuSection.newestProject(nameProject).click();
        Thread.sleep(3000);
        menuSection.newestItem(newItem).click();
        menuSection.newItemTb().setText(update+Keys.RETURN);
        Thread.sleep(3000);
        Assertions.assertTrue(menuSection.newestItem(newItem+update).isControlDisplayed(), "ERROR no se pudo actualizar el item");
    }
}