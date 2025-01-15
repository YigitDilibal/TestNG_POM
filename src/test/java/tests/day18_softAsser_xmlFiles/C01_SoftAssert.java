package tests.day18_softAsser_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SoftAssert {

    /*
        SoftAssert'in tek negatif tarafi
        tum raporlamayi assertAll() kullandigimiz satir icin yapmasidir

        verilen hata raporundan kac assertion'un failed oldugunu anlayabiliriz
        ama hangi assertion'larin failed oldugunu anlayamayiz

        Bu negatif durumu gidermek icin softAssert kullandigimizda
        hatanin hangi assertion'dan kaynaklandigini anlayabilecegimiz bir mesaj ekleyebiliriz

     */


    @Test (groups = {"E2E"})
    public void aramaTesti(){
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Url'in testotomasyonu icerdigini dogrulayin
        SoftAssert softAssert = new SoftAssert();

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrlIcerik),"url istenen icerigi barindirmiyor");

        // belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("aranacakKelime") + Keys.ENTER);

        // urun bulunabildigini dogrulayin
        int actualBulunanUrunSayisi = testotomasyonuPage.bulunanUrunElementleriList
                .size();
        softAssert.assertTrue(actualBulunanUrunSayisi > 0 , "aranan urun sayfada bulunamadi");

        // ilk urunu tiklayin
        testotomasyonuPage.bulunanUrunElementleriList
                .get(0)
                .click();

        // acilan sayfada urun isminde case sensitive olmadan
        // belirlenmis aranacakKelime'nin bulundugunu dogrulayin
        String expectedUrunIsimIcerigi = ConfigReader.getProperty("aranacakKelime");
        String actualUrunIsmi = testotomasyonuPage.urunSayfasindakiIsimElementi
                .getText()
                .toLowerCase();
        softAssert.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi),"urun ismi belirlenen kelimeyi icermiyor");

        softAssert.assertAll();
        Driver.quitDriver();
    }


}
