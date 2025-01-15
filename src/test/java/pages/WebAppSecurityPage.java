package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebAppSecurityPage {

public WebAppSecurityPage(){
    PageFactory.initElements(Driver.getDriver(),this);
}

    @FindBy(id = "signin_button")
    public WebElement AnasayfaSigninButonu;

    @FindBy(name = "user_login")
    public WebElement SigninSayfasiUsernameKutusu;

    @FindBy(id = "user_password")
    public WebElement SigninSayfasiPasswordKutusu;

    @FindBy(name = "submit")
    public WebElement SigninSayfasiSigninButonu;

    @FindBy(xpath = "//*[@class='icon-user']")
    public WebElement AnasayfaUserIcon;

    @FindBy(id = "onlineBankingMenu")
    public WebElement AnasayfaOnlineBankingSekmesi;

    @FindBy(id = "pay_bills_link")
    public WebElement OnlineBankingsekmesiPayBillsButonu;

    @FindBy(xpath = "//*[.='Purchase Foreign Currency']")
    public WebElement PayBillsSayfasiPurchaseForeignCurrencyButonu;

    @FindBy(id = "pc_currency")
    public WebElement PayBillsSayfasiPfcDropdownMenu;

    @FindBy(xpath = "(//*[@class='help-block'])[2]")
    public WebElement PayBillsSayfasiPfcHelpBlock;





}
