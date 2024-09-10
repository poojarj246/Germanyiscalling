package endtoend;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Germanyiscalling  {
	@Test
	public void successfullogin() throws Throwable {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("Username");
		String PASSWORD = pobj.getProperty("Password");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		//click on login link
		WebElement link= driver.findElement(By.xpath("//a[@href='https://app.germanyiscalling.com/?utm_source=website&utm_medium=website&utm_campaign=navbar_menu']"));
		link.click();

		//enter username
		WebElement Un = driver.findElement(By.name("username"));
		Un.sendKeys(USERNAME);

		// Enter password
		WebElement Ps = driver.findElement(By.name("password"));
		Ps.sendKeys(PASSWORD);

		//click on login button
		WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='submit']"));
		Loginbutton.click();

		driver.navigate().to("navigateurl");
	}

	@Test

	public void unsuccessfullogin() throws Throwable {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String USERNAME1 = pobj.getProperty("Username1");
		String PASSWORD1 = pobj.getProperty("Password1");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		//click on login link
		WebElement link= driver.findElement(By.xpath("//a[@href='https://app.germanyiscalling.com/?utm_source=website&utm_medium=website&utm_campaign=navbar_menu']"));
		link.click();

		//enter username
		WebElement Un = driver.findElement(By.name("username1"));
		Un.sendKeys(USERNAME1);

		// Enter password
		WebElement Ps = driver.findElement(By.name("password1"));
		Ps.sendKeys(PASSWORD1);

		//click on login button
		WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='submit']"));
		Loginbutton.click();

		String expectedvalue="Email: Email already exists.";
		String actualValue=driver.findElement(By.xpath("(//div[@class='alert alert-danger']/ul/li)[0]")).getText();
		if(expectedvalue.equals("actualValue"))
		{
			System.out.println("Error is displayed ");
		}

		String passwordfieldisempty="Password: This field is required.";
		String passwordfieldValue=driver.findElement(By.xpath("(//div[@class='alert alert-danger']/ul/li)[1]")).getText();
		if(passwordfieldisempty.equals("passwordfieldValue"))
		{
			System.out.println("Error is displayed ");
		}

	}

}

