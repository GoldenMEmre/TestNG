package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    static WebDriver driver;//driver ilk defa burada oluşturuluyor.Static objeler class ilk defa çalıştı-
    //rıldığında bir kere oluşturulur. Bu driver'a class levelda bir değer atanmamış. Class level'daki bir
    //variable'a değer atanmazsa Java buna int ise sıfır, boolean olursa false, char olursa hiçlik,non-
    // primitive olursa null olarak işaretler. Burada da bir değer verilmediği için başta null değeri
    //atıyor.
    public static WebDriver getDriver() {
    //"C:\Users\hasba\OneDrive\Masaüstü\SELENIUM\day14\image (2).png"
    // Aşağıda null değer atayarak her defasında chromedriver atamasının önüne geçmek istedik.
        if (driver == null) {//Daha önce bir chromedriver atanıp atanmadığını kontrol edecek.Atanmamışsa
        //yani null ise aşağı geçecek ve yeni bir chromedriver atayıp aşağıdaki ayarları yapacak.
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();// Artık burada driver'ın değeri ChromeDriver oldu.
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;//Eğer driver ==null değilse, yani driver'a chromedrive değeri atanmışsa, method
        //çağrıldığında driver return edecektir. Artık her çalıştırmada driver == null ise aşağısındaki
        //işlemleri yapacak. DEğilse varoln driveri, yani chromedriver'ı return edecek.
    }


    public static void closeDriver() {
        driver.close();
    }
}
