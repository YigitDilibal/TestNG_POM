package tests.day15_testNG_FrameworkOlusturma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_BasicDriverClassKullanimi {


    /*
        TestNG Page Object Model (POM) kullanir

        POM temel olarak test icin ihtiyac duydugumuz
        locate, driver ve test datalarinin dinamik olmasini
        yani tek bir yerden yonetilebilmesini
        ve Test method'larinin bu dinamik yontemle guncellenebilmesine dayanir.

        Ilk olarak driver objesini dinamik yapalim

        POM TestBase Class kullanmak yerine
        Driver class'inda bize WebDriver objesi donduren bir method kullanmayi tercih etmistir.


     */

    @Test
    public void test01(){

        Driver.getDriver().get("https://www.testotomasyonu.com");

        ReusableMethods.bekle(1);

        Driver.getDriver().get("https://www.wisequarter.com");

        ReusableMethods.bekle(1);

        Driver.getDriver().get("https://www.testotomasyonu.com");

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        ReusableMethods.bekle(3);

        Driver.quitDriver();

    }


}
