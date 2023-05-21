package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;//driver ilk defa burada oluşturuluyor.Static objeler class ilk defa çalıştı-
    //rıldığında bir kere oluşturulur. Bu driver'a class levelda bir değer atanmamış. Class level'daki bir
    //variable'a değer atanmazsa Java buna int ise sıfır, boolean olursa false, char olursa hiçlik,non-
    // primitive olursa null olarak işaretler. Burada da bir değer verilmediği için başta null değeri
    //atıyor.
    private Driver(){
        /* Singleton pattern kullanilarak istenmeyen yontemlerle
           driver objesine erisilmesini engelledik

           Constructor'i private yaparak bu class'dan obje olusturularak
           class uyelerinin kullanilmasinin onune gectik

         */
    }

    public static WebDriver getDriver(){
        //"C:\Users\hasba\OneDrive\Masaüstü\SELENIUM\day14\image (2).png"
        // Aşağıda null değer atayarak her defasında chromedriver atamasının önüne geçmek istedik.

        String istenenBrowser = ConfigReader.getProperty("browser");
        // chrome, firefox, safari, edge


        if(driver == null){//Daha önce bir chromedriver atanıp atanmadığını kontrol edecek.Atanmamışsa
            //yani null ise aşağı geçecek ve yeni bir chromedriver atayıp aşağıdaki ayarları yapacak.

            switch (istenenBrowser){
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver= new SafariDriver();
                    break;

                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;//Eğer driver ==null değilse, yani driver'a chromedrive değeri atanmışsa, method
        //çağrıldığında driver return edecektir. Artık her çalıştırmada driver == null ise aşağısındaki
        //işlemleri yapacak. DEğilse varoln driveri, yani chromedriver'ı return edecek.
    }


    public static void closeDriver(){

        if (driver != null){
            driver.close();
            driver=null;
        }
    }

    public static void quitDriver(){

        if (driver != null){
            driver.quit();
            driver=null;
        }
    }
}