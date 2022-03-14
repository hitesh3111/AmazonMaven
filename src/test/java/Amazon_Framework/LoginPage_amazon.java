package Amazon_Framework;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage_amazon extends Base {

	public static void openLoginPage() throws IOException{
	 
	      WebElement signin =driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		  signin.click();
		  driver.findElement(By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")).sendKeys(Config.configfileReader("Username"));
		  click(driver.findElement(By.cssSelector(".a-button-input")));
		  driver.findElement(By.cssSelector(".a-button-input")).click();
		  driver.findElement(By.cssSelector("#ap_password")).sendKeys(Config.configfileReader("Password"));
		  click(driver.findElement(By.cssSelector("#signInSubmit")));
		  validateUsername("Hello, hitesh");
		  checkCart("0");
		  screenshot();
		 
      }
	

	public static void add_Product1() throws IOException {
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(Config.configfileReader("product1"));
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (128GB) - Blue']")).click();
		String mainwindow = driver.getWindowHandle();
		Set<String> abc = driver.getWindowHandles();
		for (String child : abc) {
			if (!mainwindow.endsWith(child)) {
				driver.switchTo().window(child);
				driver.findElement(By.cssSelector("#add-to-cart-button")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				click(driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")));
				//driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();
				checkCart("1");
				screenshot();
			    }
			} 
           }

	
	  public static void add_Product2() throws IOException { 
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(Config.configfileReader("product2"));
	  driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
	  driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
	      String mainwindow = driver.getWindowHandle(); 
		  Set<String> xyz = driver.getWindowHandles();
		  for (String child : xyz)
		  { 
			  if(!mainwindow.endsWith(child)) 
			  {
			   driver.switchTo().window(child);
		       driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
		       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		       driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();
		       
		       checkCart("2");
		       screenshot();
		       } 
			  }
	    
		  }
	 
	}
