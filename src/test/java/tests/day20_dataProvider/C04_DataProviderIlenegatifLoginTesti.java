package tests.day20_dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Arrays;

public class C04_DataProviderIlenegatifLoginTesti extends TestBaseRapor {


    // Verilen listedeki herbir Email-password ikilisi icin
    // asagidaki testi yapin
    // yigit@kmail.com   125687
    // tugba@tmail.com   345678
    // yusuf@mmail.com   456789
    // sumeyra@smail.com 342321
    // canan@cmail.com 987098

    @DataProvider
    public static Object[][] emailPasswordDataProvideri() {

        String[][] NegatifEmailPasswordArrayi = {{"yigit@kmail.com","125687"}, {"tugba@tmail.com","345678"}
                , {"yusuf@mmail.com","456789"}, {"wise@gmail.com","12345"}, {"sumeyra@smail.com","342321"}, {"canan@cmail.com","987098"}};

        return NegatifEmailPasswordArrayi;

    }


    @Test (dataProvider = "emailPasswordDataProvideri" )
    public void negatifLoginTesti(String[] emailPassword){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin

        extentTest = extentReports.createTest(Arrays.toString(emailPassword) +" Negatif login testi"
                ,"kullanici testotomasyonu giris sayfasinda "
                        + Arrays.toString(emailPassword) + " bilgileriyle ile giris yapmaya calistiginda giris basarisiz olmali.");

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider.");

        //2- account linkine basin

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        extentTest.info("Kullanici account linkine tiklar.");

        //3- email ve password olarak listede verilen degerleri yazin

        testotomasyonuPage.loginSayfasiEmailKutusu.sendKeys(emailPassword[0]);
        extentTest.info("Kullanici email kutusuna " + emailPassword[0] + " degerini girer.");

        testotomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(emailPassword[1]);
        extentTest.info("Kullanici password kutusuna " + emailPassword[1] + " degerini girer.");


        //4- Login butonuna basarak login olmayi deneyin

        testotomasyonuPage.loginSayfasiSubmitButonu.click();
        extentTest.info("Kullanici login butonuna tiklar.");


        //5- Basarili olarak giris yapilamadigini test edin

        ReusableMethods.bekle(1);

        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        extentTest.pass("Gecersiz olan " + Arrays.toString(emailPassword) + " bilgileriyle giris yapilmaya calisildiginda giris yapilamaz.");

        //6-sayfayi kapatin
    }

}