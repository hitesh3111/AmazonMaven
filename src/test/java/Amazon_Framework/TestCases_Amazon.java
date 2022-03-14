package Amazon_Framework;

import java.io.IOException;

import Amazon_Framework.LoginPage_amazon;

public class TestCases_Amazon extends Base {
	
	public static void TC01_UsernameValidation() throws Exception
	 {
		browserInvoke();
		LoginPage_amazon.openLoginPage();
		driver.close();
	 }
	
	public static void TC02_AddtoCart_check() throws Exception
	{
		browserInvoke();
		LoginPage_amazon.openLoginPage();
		LoginPage_amazon.add_Product1();
		driver.quit();
	}
	
	public static void TC03_AddtoCart_check() throws Exception
	{
		browserInvoke();
		LoginPage_amazon.openLoginPage();
		LoginPage_amazon.add_Product2();
        driver.quit();
	}
	
	public static void main(String[] args) throws Exception {
		TC01_UsernameValidation();
		TC02_AddtoCart_check();
		TC03_AddtoCart_check();
		
	}
	

}
