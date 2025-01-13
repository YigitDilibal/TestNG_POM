package tests.day17_testDatalariniDinamikYapma;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_AlisverisSepetiTesti {

    @Test
    public void alisverisTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("aranacakKelime")+ Keys.ENTER);


        // 3- Listelenen sonuclardan ilkini tiklayin

        testotomasyonuPage.bulunanUrunElementleriList.get(0).click();

        //4- urun ismini kaydedin ve urunu sepete ekleyin
        String urunIsmi = testotomasyonuPage.urunSayfasindakiIsimElementi.getText();
        ReusableMethods.bekle(1);
        ReusableMethods.webElementScreenshot(testotomasyonuPage.urunSayfasindakiIsimElementi);

        testotomasyonuPage.urunSayfasindakiSepeteEkleButonu.click();

        ReusableMethods.bekle(1);


        //5- your cart linkine tiklayin

        testotomasyonuPage.urunSayfasindakiYourCartButonu.click();


        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin

        String sepetUrunIsmi = testotomasyonuPage.yourCartSayfasindakiUrunIsmi.getText();
        ReusableMethods.bekle(1);
        ReusableMethods.webElementScreenshot(testotomasyonuPage.yourCartSayfasindakiUrunIsmi);

        Assert.assertEquals(urunIsmi,sepetUrunIsmi);


        //7- sayfayi kapatin

        Driver.quitDriver();


    }

}
