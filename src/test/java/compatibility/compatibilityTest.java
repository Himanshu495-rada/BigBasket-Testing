package compatibility;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class compatibilityTest {
	String fpath = "C:\\Users\\himan\\eclipse-workspace\\BigBasket_testing\\src\\test\\resources\\object\\objects.property";
	Properties p;
	File f;
	FileInputStream fis;
	WebDriver driver;
	
  @Test(priority=1)
  public void chromeTest() {
	  System.setProperty(p.getProperty("browser"), p.getProperty("chromeDriver"));
	  driver = new ChromeDriver();
	  driver.get(p.getProperty("website"));
	  driver.manage().window().maximize();
	  
	  String title = driver.getTitle();
	  Assert.assertEquals(title, p.getProperty("dashboardTitle"));
  }
  @Test(priority=2)
  public void edgeTest() {
	  System.setProperty(p.getProperty("edgeBrowser"), p.getProperty("edgeDriver"));
	  driver = new EdgeDriver();
	  driver.get(p.getProperty("website"));
	  driver.manage().window().maximize();
	  
	  String title = driver.getTitle();
	  Assert.assertEquals(title, p.getProperty("dashboardTitle"));
  }
  @Test(priority=3)
  public void firefoxTest() {
	  System.setProperty(p.getProperty("firefoxBrowser"), p.getProperty("firefoxDriver"));
	  driver = new FirefoxDriver();
	  driver.get(p.getProperty("website"));
	  driver.manage().window().maximize();
	  
	  String title = driver.getTitle();
	  Assert.assertEquals(title, p.getProperty("dashboardTitle"));
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

  @BeforeTest
  public void beforeTest() throws IOException {
	  f = new File(fpath);
	  fis = new FileInputStream(f);
	  p = new Properties();
	  p.load(fis);
  }

  @AfterTest
  public void afterTest() {
  }

}
