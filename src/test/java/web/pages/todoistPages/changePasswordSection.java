package web.pages.todoistPages;

import web.controls.Button;
import web.controls.TextBox;
import org.openqa.selenium.By;

public class changePasswordSection {
    public TextBox oldPasswordTextBox = new TextBox(By.xpath("//form//input[@autocomplete='off']"));
    public TextBox newPasswordTextBox = new TextBox(By.xpath("//form//span[text()='New password']//ancestor::span/following-sibling::div//input"));
    public TextBox repeatNewPasswordTextBox = new TextBox(By.xpath("//form//span[text()='Confirm new password']//ancestor::span/following-sibling::div//input"));
    public Button changePasswordButton = new Button(By.xpath("//button[@type='submit']"));

}
