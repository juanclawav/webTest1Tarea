package web.pages.todoistPages;

import org.openqa.selenium.By;
import web.controls.Button;
import web.controls.TextBox;

public class registerPage {
    TextBox emailTextBox = new TextBox(By.xpath("//input[@type='email']"));
    TextBox pwTextBox = new TextBox(By.xpath("//input[@type='password']"));
    Button registerBtn = new Button(By.xpath("//button[@type='submit']"));
    TextBox accountNameTb = new TextBox(By.xpath("//input[@placeholder='E.g. Jane Doist']"));
    Button submitNameBtn = new Button(By.xpath("//span[text()='Continue']/parent::button"));
    Button markPersonalBtn = new Button(By.xpath("//button[@aria-label='Personal']"));
    Button launchBtn = new Button(By.xpath("//button[@aria-label='Launch Todoist']"));


}
