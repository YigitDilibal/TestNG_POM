package utilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.time.Duration;


public class TestBaseCross {
    // Crossbrowser calisacak class'lar icin
    // .xml'den gonderilen calisacakBrowser parametresini yakalayip
    // o browser'a uygun bir driver olusturup
    // Class'in kullanmasina hazir hale getirecek


    protected WebDriver driver;
    protected String browserName;

    @Parameters("kullanilacakBrowser")
    @BeforeMethod
    public void setUp(@Optional String kullanilacakBrowser){

        browserName = kullanilacakBrowser; // Tarayıcı bilgisini sakla
        driver= DriverCross.getDriver(kullanilacakBrowser);

    }


    @AfterMethod
    public void tearDown(){

        DriverCross.quitDriver();

    }
}