package projects.frontend.cashback.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseCashback {
    public String paramURL = "";   // "dev"   "stage"  ""

    @BeforeMethod(alwaysRun = true)
    public void start(){
        Configuration.browser = System.getProperty("selenide.browser", "opera");
        // "chrome", "firefox", "legacy_firefox", "ie", "htmlunit", "opera", "safari", "edge"
        Configuration.startMaximized = true;
        Selenide.clearBrowserCookies();
       //  Selenide.clearBrowserLocalStorage();  ошибка

    }

    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }

}
