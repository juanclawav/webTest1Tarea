package pages;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class SettingsPage {
    public TextBox fullNameInput = new TextBox(By.id("FullNameInput"));
    public Button okButton = new Button(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']"));
}