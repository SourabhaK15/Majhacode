package mpj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


public class RegForm {
	public String username = "yadneshshah91";  //your LambdaTest username
    public String accesskey = "1234ABCD";      //your LambdaTest access key
    public static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub"; //LambdaTest Hub URL
    boolean status = false;
  
    
    //Setting up capabilities to run our test script
    @Parameters(value= {"browser","version"})
    @BeforeClass
    public void setUp(String browser, String version) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version", version);
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
               
    }
    
    //Opening browser with the given URL and navigate to Registration Page
    @BeforeMethod
    public void openBrowser()
    {
    	driver.manage().deleteAllCookies();
    	
		driver.get("https://www.lambdatest.com/");
        
      //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      // driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        
        WebElement signUpButton = driver.findElement(By.xpath("//a[contains(text(),'Free Signup')]"));
        signUpButton.click(); 
        
    }
}
