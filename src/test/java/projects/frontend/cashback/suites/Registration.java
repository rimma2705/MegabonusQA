package projects.frontend.cashback.suites;

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

    //Регистрация. Положительный сценарий

    @Test(groups = {"web2"},priority = 4)
    public void registerTrue() throws Exception {
        open(registerPage.registerURL);

        registerPage.register(textEmailRandom, textPassword);
        sleep(5000);
        $(registerPage.registerForm).should(disappear);
    }


    //Регистрация. Отрицательный сценарий: Не корректная почта
    @Test(groups = {"web2"},priority = 5)
    public void registerFalseEmail() throws Exception {
        open(registerPage.registerURL);
        registerPage.register(textEmailRandom + "@", textPassword);
        $(registerPage.textErrorEmail).shouldHave(text("Неверный формат email"));
    }

    //Регистрация. Отрицательный сценарий: Не коррекнтный пароль
    @Test(groups = {"web"},priority = 6)
    public void registerFalsePassword() throws Exception {
        open(registerPage.registerURL);
        registerPage.register(textEmailRandom, "123");
        $(registerPage.textErrorPassword).shouldHave(text("Мы за надежные пароли — минимум 8 символов"));
    }
}
