package selenium_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon_SampleTest {

	public static void main(String[] args) {

		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\soft\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver(options);

		// Launch Website
		driver.navigate().to("https://www.Amazon.in");

		// Maximize the browser
		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Scroll down the webpage by 5000 pixels
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 5000)");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");

		driver.findElement(By.id("nav-search-submit-button")).click();

		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();

		driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-none\"]")).click();

		driver.findElement(By.xpath("///a[@id=\"bylineInfo\"]")).click();

		driver.findElement(By.xpath("//input[@class=\"SearchInput__input__IGt2m\"]")).sendKeys("ipad");

	}
}
