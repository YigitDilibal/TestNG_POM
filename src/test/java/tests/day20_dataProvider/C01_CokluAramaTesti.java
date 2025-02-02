package tests.day20_dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_CokluAramaTesti {

    // testotomasyonu anasayfaya gidip
    // bir liste olarak verilen urunleri
    // tek tek aratin ve her urunun sayfada bulunabildigini test edin


    @Test
    public void cokluAramaTesti(){

        List<String> aranacakUrunList = new ArrayList<>(Arrays.asList("phone", "dress", "java", "samsung", "nutella", "apple", "cokoprens"));

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        SoftAssert softAssert = new SoftAssert();

        for (String each: aranacakUrunList){

            testotomasyonuPage.aramaKutusu.sendKeys(each, Keys.ENTER);

            softAssert.assertTrue(!testotomasyonuPage.bulunanUrunElementleriList.isEmpty()
                    ,each+"icin sonuc bulunamadi");


        }

        softAssert.assertAll();
        Driver.quitDriver();

    }







}
