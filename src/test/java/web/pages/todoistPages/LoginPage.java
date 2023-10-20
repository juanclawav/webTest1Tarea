package web.pages.todoistPages;


import web.controls.Button;
import web.controls.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public TextBox emailInput = new TextBox(By.xpath("//input[@placeholder='Enter your email...']"));
    public TextBox passwordInput = new TextBox(By.xpath("//input[@placeholder='Enter your password...']"));
    public Button logInButton = new Button(By.xpath("//button[@type='submit']"));
}
