package tests.day15_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C01_PagesIlkTest {

    @Test
    public void amazonTest(){

        // amazon anasayfaya gidelim

        Driver.getDriver().get("https://www.amazon.com");
        // Nutella icin arama yapalim
        // Arama kutusunun locate'i pages sayfasinda
        // POM'de pages sayfasindaki locate'lere erismek icin
        // pages sayfalarindan bir obje olusturulur.
        AmazonPage amazonPage = new AmazonPage();// AmazonPage'den bir obje oluşturmak için mutlaka constructor'u çalıştırmLIYIZ.
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin Nutella icerdigini test edelim
        String expectedicerik = "Nutella";
        String actualAramaSonucyazisi= amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualAramaSonucyazisi.contains(expectedicerik));

        // sayfayi kapatalim
        Driver.closeDriver();
    }
}

