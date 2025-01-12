package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebUniversityPage {

    public WebUniversityPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[.='LOGIN PORTAL']")
    public WebElement anasayfaLoginPortalButonu;

    @FindBy(id = "text")
    public WebElement LoginSayfasiUsernameKutusu;

    @FindBy(id = "password")
    public WebElement LoginSayfasiPasswordKutusu;

    @FindBy(id = "login-button")
    public WebElement LoginSayfasiLoginButonu;





}
