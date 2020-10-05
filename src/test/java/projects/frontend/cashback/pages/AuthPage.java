package projects.frontend.cashback.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    public String paramURL = "dev";
    public String authURL = "https://auth." + paramURL + "megabonus.com";

    By authForm = By.id("auth");
    By email = By.id("auth-form-email");
    By password = By.id("auth-form-password");
    By login = By.xpath("//*[@class=\"enter-button login-gaym\"]");


    public void setEmail(String strEmail){
        $(email).val(strEmail);
    }

    public void setPassword(String strPassword){
        $(password).val(strPassword);
    }

    public void clickLogin(){
        $(login).click();
    }

    public void login (String Email, String Password){
        this.setEmail(Email);
        this.setPassword(Password);
        this.clickLogin();
    }

}

