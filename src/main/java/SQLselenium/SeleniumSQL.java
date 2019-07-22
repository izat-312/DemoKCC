package SQLselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class SeleniumSQL {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://secure2.homedepot.com/account/view/logon/redirect/%252Faccount%252Fview%252Fprofile");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,3);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/IDSDATA","root","chicago312");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from homedepot");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                WebElement account = driver.findElement(By.id("signinEmail"));
                account.clear();
                account.sendKeys(resultSet.getString("name")+"@gmail.com");
                WebElement password = driver.findElement(By.id("password"));
                password.clear();
                password.sendKeys(resultSet.getString("password"));
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Sign In')]"))).click();
            }

        } catch (SQLException e){

            e.printStackTrace();
        }


        Thread.sleep(10000);
        driver.quit();
    }
}
