package tests.day16_PageClassKullanimi;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_WebUniversityTest {

    @Test
    public void test01(){



        //1."https://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("https://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin
        WebUniversityPage webUniversityPage = new WebUniversityPage();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});", webUniversityPage.anasayfaLoginPortalButonu );

        //3."Login Portal" a tiklayin
        webUniversityPage.anasayfaLoginPortalButonu.click();

        //4.Diger window'a gecin
        ReusableMethods.titleIleWindowGecisi("WebDriver | Login Portal");

        //5."username" ve "password" kutularina deger yazdirin
        webUniversityPage.LoginSayfasiUsernameKutusu.sendKeys("yigit");
        webUniversityPage.LoginSayfasiPasswordKutusu.sendKeys("onur");

        //6."login" butonuna basin
        webUniversityPage.LoginSayfasiLoginButonu.click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualAlertYazisi,"validation failed");

        //8.Ok diyerek Popup'i kapatin

        Driver.getDriver().switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        ReusableMethods.urlIleWindowGecisi("https://webdriveruniversity.com/");

        //10.Ilk sayfaya donuldugunu test edin

        Assert.assertTrue(webUniversityPage.anasayfaLoginPortalButonu.isDisplayed());

        Driver.quitDriver();

    }

}
