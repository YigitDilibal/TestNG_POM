package tests.day17_testDatalariniDinamikYapma;

import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DinamikNegativeLoginTesti {

    @Test
    public void gecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        // - gecerli email, gecersiz password girin

        testotomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin

        testotomasyonuPage.loginSayfasiSubmitButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(testotomasyonuPage.loginSayfasiSubmitButonu.isDisplayed());

        //6-sayfayi kapatin

        Driver.quitDriver();
    }
    @Test
    public void gecersizEmailTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        // - gecersiz email, gecerli password girin

        testotomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //4- Login butonuna basarak login olmayi deneyin

        testotomasyonuPage.loginSayfasiSubmitButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(testotomasyonuPage.loginSayfasiSubmitButonu.isDisplayed());

        //6-sayfayi kapatin

        Driver.quitDriver();
    }
    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        // - gecersiz email, gecersiz password girin

        testotomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin

        testotomasyonuPage.loginSayfasiSubmitButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(testotomasyonuPage.loginSayfasiSubmitButonu.isDisplayed());

        //6-sayfayi kapatin

        Driver.quitDriver();
    }


}
