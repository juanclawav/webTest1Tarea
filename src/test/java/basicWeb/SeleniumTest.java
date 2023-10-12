package basicWeb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SeleniumTest {
    ChromeDriver chrome;
    @BeforeEach
    public void openBrowser() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("http://todo.ly/");
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();

        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("jcctapi@jcctapi.com");
        // set password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        // click login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        Thread.sleep(5000);
        Assertions.assertTrue((chrome.findElements(By.xpath("//a[text()='Logout']")).size() == 1),
                "ERROR no se pudo ingresar a la sesion");
        Thread.sleep(5000);
    }

    @Test
    public void verifyCreateProject() throws InterruptedException {

        //click add new project
        chrome.findElement(By.id("Div2")).click();
        //fill new project name textbox
        chrome.findElement(By.id("NewProjNameInput")).sendKeys("TESTpR");
        //click add
        chrome.findElement(By.id("NewProjNameButton")).click();

        Thread.sleep(5000);
        Assertions.assertTrue((chrome.findElements(By.xpath("//td[text()='TESTpR']")).size() >= 1),
                "NO SE CREO EL PROYECTO");
        Thread.sleep(5000);
    }
    @Test
    public void verifyUpdateProject() throws InterruptedException {
        Actions actions = new Actions(chrome);

        actions.moveToElement(chrome.findElement(By.xpath("//td[text()='TESTpR']")));

        //click new project
        chrome.findElement(By.xpath("//td[@class=ProjItemMenu]")).click();
        //click menu
        //click menu
        chrome.findElement(By.className("edit")).click();

        chrome.findElement(By.id("ItemEditTextbox")).sendKeys("nueevopro");


        Thread.sleep(5000);
        Assertions.assertTrue((chrome.findElements(By.xpath("//td[text()='nueevopro']")).size() >= 1),
                "NO SE ACTUALIZO EL PROYECTO");
        Thread.sleep(5000);
    }
    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }

}
