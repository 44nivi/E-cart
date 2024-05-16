package selenium_sample;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Simple {
    public static WebDriver driver;
	public static void main(String[] args) throws AWTException, InterruptedException {
    	
        System.setProperty("webdriver.gecko.driver","C:\\soft\\geckodriver.exe");
driver= new FirefoxDriver();
driver.get("https://www.amazon.in/Apple-iPhone-Plus-128GB-Purple/dp/B0BDJMSBXY/ref=sr_1_1_sspa?crid=2U93CU0SZVJW8&keywords=iphone&qid=1677564244&sprefix=iphone%2Caps%2C255&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.xpath("//a[@id=\"bylineInfo\"]")).click();
}
}
