package mpj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignOn 
{

	public static void main(String[] args) throws InterruptedException 
	{
// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kulta\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver wd = new ChromeDriver();
			wd.get("https://www.facebook.com");
			//wd.findElement(By.id("email")).sendKeys("abc@gmail.com");
			//wd.findElement(By.id("pass")).sendKeys("Abc@123");
			wd.findElement(By.name("login")).click();
	}
}
