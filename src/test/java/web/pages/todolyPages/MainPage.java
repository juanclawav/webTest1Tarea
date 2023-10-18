package web.pages.todolyPages;

import web.controls.Button;
import org.openqa.selenium.By;

public class MainPage {

    public Button loginButton = new Button(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]"));
    public Button signupBtn = new Button(By.xpath("//div[@class='HPHeaderSignup']//a"));



}
