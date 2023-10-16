package testSuite.tareasWebUI.todoistPages;


import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public TextBox emailTextBox = new TextBox(By.id("element-0"));
    public TextBox passwordTextBox = new TextBox(By.id("element-3"));
    public Button loginButton = new Button(By.xpath("//button[@type='submit']"));
}
