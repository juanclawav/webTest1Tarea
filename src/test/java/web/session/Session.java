package web.session;

import web.factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class Session {

    private static Session session;

    private WebDriver browser;

    private Session(){
        browser = FactoryBrowser.make("chrome").create();
        browser.manage().window().maximize();
    }
    public static Session getInstance(){
        if(session == null)
            session = new Session();
        return session;
    }

    public WebDriver getBrowser() {
        return browser;
    }
    public void goTo(String url) {
        browser.get(url);
    }

    public void closeSession(){
        browser.quit();
        session = null;
    }
}
