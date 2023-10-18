package web.pages.todoistPages;

import org.openqa.selenium.By;
import web.controls.Button;
import web.controls.TextBox;

public class AddProjectPopup {
    TextBox projectNameTb = new TextBox(By.xpath("//input[@id='edit_project_modal_field_name']"));
    Button submitBtn = new Button(By.xpath("//button[@type='submit']"));

}
