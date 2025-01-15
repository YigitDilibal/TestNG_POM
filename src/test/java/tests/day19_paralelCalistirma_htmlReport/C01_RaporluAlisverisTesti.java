package tests.day19_paralelCalistirma_htmlReport;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_RaporluAlisverisTesti extends TestBaseRapor {

    /*
        Bir test method'unun raporlu olmasini istiyorsaniz
        1- extends TestBaseRapor ile
     */



    @Test
    public void alisverisTesti(){
        ExtentTest = extentReports.createTest("Alisveris Testi", "Kullanici istedigi urunun sepete eklendigini test edebilmeli");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici https://www.testotomasyonu.com/ anasayfasina gider");

        //2- belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("aranacakKelime")+ Keys.ENTER);
        extentTest.info("belirlenmis arama kelimesi icin arama yapar");


        // 3- Listelenen sonuclardan ilkini tiklayin

        testotomasyonuPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("Listelenen sonuclardan ilkini tiklar");

        //4- urun ismini kaydedin ve urunu sepete ekleyin
        String urunIsmi = testotomasyonuPage.urunSayfasindakiIsimElementi.getText();
        extentTest.info("Tikladigi urunun ismini kaydeder");

        ReusableMethods.bekle(1);
        ReusableMethods.webElementScreenshot(testotomasyonuPage.urunSayfasindakiIsimElementi);

        testotomasyonuPage.urunSayfasindakiSepeteEkleButonu.click();
        extentTest.info("urunu sepete ekler");

        ReusableMethods.bekle(1);


        //5- your cart linkine tiklayin

        testotomasyonuPage.urunSayfasindakiYourCartButonu.click();
        extentTest.info("your cart linkine tiklar");


        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin

        String sepetUrunIsmi = testotomasyonuPage.yourCartSayfasindakiUrunIsmi.getText();
        ReusableMethods.bekle(1);
        ReusableMethods.webElementScreenshot(testotomasyonuPage.yourCartSayfasindakiUrunIsmi);

        Assert.assertEquals(urunIsmi,sepetUrunIsmi);
        extentTest.pass("kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test eder");


        //7- sayfayi kapatin

        Driver.quitDriver();
        extentTest.info("sayfayi kapatir");


    }


}
