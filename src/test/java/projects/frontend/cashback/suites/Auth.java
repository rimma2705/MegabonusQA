package projects.frontend.cashback.suites;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import projects.frontend.cashback.helpers.TestBaseCashback;
import projects.frontend.cashback.pages.AuthPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class Auth extends TestBaseCashback {
    AuthPage authPage = new AuthPage();


    @Test(groups = {"web2"},priority = 2, description="Положительный сценарий.")
    @Story("Авторизация.")
    public void authTrue(){
       open(authPage.authURL);
        System.out.println("2");
        authPage.login("raisa.demenko@yandex.ru", "123123123");
        $(By.xpath("//*[@id=\"auth\"]")).should(disappear);
        sleep(6000);
        $(By.xpath("//*[@class=\"settings-account\"]")).should(appear);
    }

    @Test(groups = {"web"},priority = 3, description="Отрицательный сценарий: Неверный емайл.")
    @Story("Авторизация.")
    public void authFalseEmail() throws Exception {
        open(authPage.authURL);
        System.out.println("3");
        authPage.login("raisa.demenko000@yandex.ru", "123123123");
        sleep(1000);
        $(By.xpath("/html/body/div[1]/section/div/div[2]/div[5]/div[2]/div[2]/div[2]/p")).shouldHave(text("Неверный email или пароль"));
    }

    @Test(groups = {"web"},dependsOnMethods = "authTrue",priority = 6, description="Отрицательный сценарий: Неверный пароль.")
    @Story("Авторизация.")
    public void authFalsePassword() throws Exception {
        open(authPage.authURL);
        System.out.println("6");
        authPage.login("raisa.demenko@yandex.ru", "123123123test");
        sleep(1000);
        $(By.xpath("/html/body/div[1]/section/div/div[2]/div[5]/div[2]/div[2]/div[2]/p")).shouldHave(text("Нверный email или пароль"));
    }
}
