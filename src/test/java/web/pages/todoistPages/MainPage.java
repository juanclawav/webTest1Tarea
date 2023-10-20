package web.pages.todoistPages;

import web.controls.Button;
import org.openqa.selenium.By;

public class MainPage {
        public Button startForFreeButton = new Button(By.xpath("//a[@href='/auth/signup']"));
        public Button enterLoginButton = new Button(By.xpath("//a[@href='/auth/login']"));
}