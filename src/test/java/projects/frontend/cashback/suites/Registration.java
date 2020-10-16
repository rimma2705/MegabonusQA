package projects.frontend.cashback.suites;

import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import projects.frontend.cashback.helpers.TestBaseCashback;
import projects.frontend.cashback.pages.RegisterPage;

import java.util.Random;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class Registration extends TestBaseCashback {

    final Random myRandom = new Random();
    RegisterPage registerPage = new RegisterPage();

    public String textEmailRandom = "test" + String.valueOf(myRandom.nextInt()) + "@megabonus.com";
    public String textPassword = "123123123";


    //======  РЕГИСТРАЦИЯ  =========

    @Test(groups = {"web3"},priority = 4, description="Положительный сценарий.")
    @Story("Регистрация.")
    public void registerTrue() throws Exception {
        open(registerPage.registerURL);
        registerPage.register(textEmailRandom, textPassword);
        sleep(5000);
        $(registerPage.registerForm).should(disappear);
    }

    @Test(groups = {"web3"},priority = 5, description="Отрицательный сценарий: Некорректная почта.")
    @Story("Регистрация.")
    public void registerFalseEmail() throws Exception {
        open(registerPage.registerURL);
        registerPage.register(textEmailRandom + "@", textPassword);
        $(registerPage.textErrorEmail).shouldHave(text("Неверный формат email"));
    }

    @Test(groups = {"web2"},priority = 1, description="Отрицательный сценарий: Некорректный пароль.")
    @Story("Регистрация.")
    public void registerFalsePassword() throws Exception {
        open(registerPage.registerURL);
        System.out.println("1");
        registerPage.register(textEmailRandom, "123");
        $(registerPage.textErrorPassword).shouldHave(text(" за надежные пароли — минимум 8 символов"));
    }
}