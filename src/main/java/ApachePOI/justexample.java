package ApachePOI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class justexample {

    static WebDriver driver;
    static WebDriverWait wait = new WebDriverWait(driver,5);
    @BeforeClass
    public static void beforeClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(8,TimeUnit.SECONDS);
        driver.get("https://secure2.homedepot.com/account/view/logon/redirect/%252Faccount%252Fview%252Fprofile");
    }

    @DataProvider()
    public Iterator<Object[]> getDatafromProvider() throws IOException {
        ArrayList<Object[]> obj =justGetExcel.getDataFromExcel();
        return obj.iterator();
    }
    @Test(dataProvider ="getDatafromProvider")
    public void homeDepotLogIn(String string, String string1) throws InterruptedException {
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.id("signinEmail"));
        email.clear();
        email.sendKeys(string+"@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.clear();
        password.sendKeys(string1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Sign In')]"))).click();
    }
    @AfterClass
    public static void closeChrome(){
        driver.quit();
    }
}
