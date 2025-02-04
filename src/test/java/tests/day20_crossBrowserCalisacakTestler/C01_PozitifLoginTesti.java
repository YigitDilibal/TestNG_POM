package tests.day20_crossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_PozitifLoginTesti extends TestBaseCross {


    @Test
    public void dinamikPozitifLoginTesti(){
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin

        driver.get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage("cross");
        testotomasyonuPage.accountLinki.click();

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));


        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiSubmitButonu.click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());

        ReusableMethods.bekle(2);

        // 7- logout olun

        testotomasyonuPage.logoutButonu.click();

        // 8- sayfayi kapatin

        ReusableMethods.bekle(2);
        driver.quit();

    }



}
