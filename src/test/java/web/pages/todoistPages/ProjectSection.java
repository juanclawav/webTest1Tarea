package web.pages.todoistPages;

import web.controls.Button;
import web.controls.TextBox;
import org.openqa.selenium.By;

public class ProjectSection {
    public Button projectsButton = new Button(By.xpath("//a[@href='/app/projects']"));
    public Button addProjectButton = new Button(By.xpath("//button[@aria-label='Add project']"));
    public TextBox nameInput = new TextBox(By.xpath("//input[@name='name']"));
    public Button addButton = new Button(By.xpath("//button[span[text()='Add']]"));

}
