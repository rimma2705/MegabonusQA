package projects.frontend.cashback.pages;

import org.openqa.selenium.By;
import projects.frontend.cashback.helpers.TestBaseCashback;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPage extends TestBaseCashback {

    public String registerURL = "https://auth." + paramURL + "megabonus.com/register";

    public By registerForm = By.id("register");
    public By email = By.id("auth-form-email");
    public By password = By.id("auth-form-password");
    public By register = By.xpath("//*[@class=\"enter-button register-gaym\"]");
    public By agreeConfidential_check = By.xpath("//*[@id=\"register\"]/div/div/div[2]/div[1]/div[3]/label");
    //public By gg = By.xpath("//*[@id='gallery-modal' and @style='display: none;']/div");
    public By modalOnbording  = By.xpath("//*[@id='gallery-modal' and @style='display: block; padding-right: 17px;']/div");
    public By textErrorEmail = By.xpath("//*[@id=\"component-error-text\" and text()= \"Неверный формат email\"]");
    public By textErrorPassword = By.xpath("//*[@id=\"component-error-text\" and text()= \"Мы за надежные пароли — минимум 8 символов\"]");



    public void setEmail(String strEmail){
        $(email).val(strEmail);
    }

    public void setPassword(String strPassword){
        $(password).val(strPassword);
    }

    public void clickAgreeConfidential(){
        $(agreeConfidential_check).click();
    }

    public void clickRegister(){
        $(register).click();
    }

    public void register (String Email, String Password){
        this.setEmail(Email);
        this.setPassword(Password);
        this.clickAgreeConfidential();
        this.clickRegister();
    }
}
