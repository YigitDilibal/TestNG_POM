package tests.day18_softAsser_xmlFiles;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebAppSecurityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_SoftAssert {

    @Test (groups = {"smoke", "E2E", "regression"})
    public void test01(){

        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("wasUrl"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin

        String expectedTitle = "Zero - Personal Banking - Loans - Credit Cards";
        String actualTitle = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(expectedTitle,actualTitle,"S:31");


        // 3. Sign in butonuna basin

        WebAppSecurityPage webAppSecurityPage = new WebAppSecurityPage();
        webAppSecurityPage.AnasayfaSigninButonu.click();

        // 4. Login kutusuna “username” yazin
        webAppSecurityPage.SigninSayfasiUsernameKutusu.sendKeys("username");

        // 5. Password kutusuna “password” yazin
        webAppSecurityPage.SigninSayfasiPasswordKutusu.sendKeys("password");

        // 6. Sign in tusuna basin
        webAppSecurityPage.SigninSayfasiSigninButonu.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(webAppSecurityPage.AnasayfaUserIcon.isDisplayed(),"S:52");

        // 9. Online banking menusunu tiklayin
        webAppSecurityPage.AnasayfaOnlineBankingSekmesi.click();

        //10. Pay Bills sayfasina gidin
        webAppSecurityPage.OnlineBankingsekmesiPayBillsButonu.click();

        //11. “Purchase Foreign Currency” tusuna basin
        webAppSecurityPage.PayBillsSayfasiPurchaseForeignCurrencyButonu.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(webAppSecurityPage.PayBillsSayfasiPfcDropdownMenu.isEnabled(),"S:64");

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select selectCurrency = new Select(webAppSecurityPage.PayBillsSayfasiPfcDropdownMenu);
        selectCurrency.selectByIndex(6);

        //14. "Eurozone (euro)" secildigini dogrulayin

        String actualSelectedOption= selectCurrency.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSelectedOption,"Eurozone (euro)","S:74");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.

        List<WebElement> currencyDdmList = selectCurrency.getOptions();

        softAssert.assertEquals(16,currencyDdmList.size(),"S:80");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin

        List<String> stringCurrencyList = ReusableMethods.stringListeDonustur(currencyDdmList);

        softAssert.assertTrue(stringCurrencyList.contains("Canada (dollar)"),"S:86");


        //17. Sayfayi kapatin

        ReusableMethods.bekle(2);
        softAssert.assertAll();
        Driver.quitDriver();


    }


}
