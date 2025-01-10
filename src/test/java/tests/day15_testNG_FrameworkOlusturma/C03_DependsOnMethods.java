package tests.day15_testNG_FrameworkOlusturma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_DependsOnMethods {

    // 3 test method'u olusturup asagidaki gorevleri gerceklestirin

    // 1- testotomasyonu sayfasina gidip url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip, urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan phone bulundugunu test edin

    /*
        b testinde dependsOnMethods = "a" yaziyorsa
        a calisip passed olmadikca b calismaz.
        a calismaz veya calisip failder olursa b method'u ignore edilir ve calistirilmaz.
     */

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void anasayfaTesti(){

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);

    }

    @Test (dependsOnMethods = "anasayfaTesti")
    public void phoneAramaTesti(){

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);

    }

    @Test (dependsOnMethods = "phoneAramaTesti")
    public void arunIsimTesti(){

        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();

        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']")).getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

    }


}
