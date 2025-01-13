package tests.day17_testDatalariniDinamikYapma;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_SingletonPattern {

    @Test
    public void test01(){

        // testotomasyonu sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        /*
            TestNG POM framework
            WebDriver icin Driver class'indaki getDriver()'unu kullanmamizi ister

            Framework'u hazirlayanlar
            farkli kullanimlarin da onune gecmek icin
            Driver class'inda Singleton Pattern kullanmayi tercih etmislerdir.

         */




        ReusableMethods.bekle(2);
        Driver.quitDriver();


    }


}
