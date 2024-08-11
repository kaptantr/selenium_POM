import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class POM {

	public static WebDriver driver = null;
	private static FluentWait<WebDriver> fluentWait;
	private static String url = "https://www.carfax.com/";
	
	// Locators
	private static By linkLogin = By.id("cgh-account-login-button");
	private static By inputUsername = By.id("username");
	private static By inputPassword = By.id("password");
	private static By buttonLogin = By.xpath("//button[@name='action']");
	
	public static void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(15))
						.pollingEvery(Duration.ofSeconds(2))
						.ignoring(NoSuchElementException.class);
		driver.get(url);
	}
	
	public static void wait(int _timeout) {
		try { Thread.sleep(_timeout); } 
		catch (InterruptedException e) { }
	}
	
	public static void tear() {
		driver.quit();
	}

	public static void openLoginPage() {
		fluentWait.until(ExpectedConditions.elementToBeClickable(linkLogin)).click();
		wait(1000);
		//((JavascriptExecutor)driver).executeScript("document.getElementById('cgh-account-login-button').click();");
	}
	
	public static void inputDatasInLoginPage() {
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(inputUsername)).sendKeys("mesut_erol_tr@hotmail.com");
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword)).sendKeys("2494375Mesut..");
		fluentWait.until(ExpectedConditions.elementToBeClickable(buttonLogin)).click();
		wait(1000);
	}
}
