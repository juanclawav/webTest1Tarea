package web.pages.todoistPages;

import web.controls.Button;
import org.openqa.selenium.By;
import web.controls.TextBox;

public class SettingsOverlay {
    public Button changePasswordButton = new Button(By.xpath("//a[@href=\"/app/settings/account/password\"]"));
    public TextBox accountNameTextBox = new TextBox(By.xpath("//input[@name='name']"));
    public Button exitSettingsButton = new Button(By.xpath("//button[@aria-label='Close settings']"));
    public Button submitBtn = new Button(By.xpath("//button[@type='submit']"));
    public Button deleteAccountBtn = new Button(By.xpath("//a[@aria-describedby='delete-account-info']"));

}
