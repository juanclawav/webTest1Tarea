package testSuite.tareasWebUI.todoistPages;

import controls.Button;
import org.openqa.selenium.By;

public class MainPage {
    public Button loginButton = new Button(By.xpath("//li//a[@href=\"/auth/login\"]"));

    public void loginMobile() {
         Button navBtn = new Button(By.xpath("//button[@class='Z2j5FoeQ_umI7vX0SmxF zA288Pg0ZRE8YcTi8CRc AisLsJaE_AWnIhDlnTUV yJmXDmy7f2C2dFexmqOR mM3grCr5NP0yUQ2zKXcN']"));
         navBtn.click();
         Button loginBtn = new Button(By.xpath("//a[@class='Z2j5FoeQ_umI7vX0SmxF RoZJQRuSAywd550zWiXo DLF4ip7391hTQFmMhXrA AisLsJaE_AWnIhDlnTUV pJ5lpFCDv2hmsZmokGiV o9DYmt4xfLaImiVzI9dQ']"));
         loginBtn.click();
    }
}