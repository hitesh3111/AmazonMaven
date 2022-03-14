package Amazon_Framework;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class Base {
	static WebDriver driver;

	public static void browserInvoke() throws Exception {
		System.setProperty("webdriver.chrome.driver","F:\\Downloads\\automation\\Newfolder\\chrome98\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Config.configfileReader("amazon_Url"));
	}
	
	public static void click(WebElement Xpath)
	{
		Xpath.click();
	}
	
	public static void validateUsername(String ExpectedName)
	{
		 String Username= driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).getText();
		 if (Username.equals(ExpectedName)) {
				System.out.println("Username " +ExpectedName+ " Validated Successfully");
			} else {
				System.out.println("Incorrect Username");
			}
	}
	
    public static void checkCart(String ExpectedVal)
    {
		String CartValue = driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
		if (CartValue.equals(ExpectedVal)) {
			System.out.println("Cart Value is " +ExpectedVal+ " Validated Successfully");
		} else {
			System.out.println("Validation failed");
		}
    }
	
	public static void screenshot() throws IOException
	{
		String fileWithpath="F:\\SEED\\AutomationKunalSir\\Framework\\Screenshot\\";
        Date d= new Date();
        String FileName=d.toString().replace(":", "").replace(" ", "") +".jpg";
        File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File(fileWithpath + FileName));
	}

}
