package pageObject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import Utilities.Readconfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	Readconfig readconfig = new Readconfig();

	public String baseurl = readconfig.getAppURL();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException, MalformedURLException {

		logger = Logger.getLogger("Lazada.log");
		PropertyConfigurator.configure("Log4j.properties");
		if (br.equals("chrome")) {

			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
					ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*"); 
			driver = WebDriverManager.chromedriver().capabilities(options).avoidShutdownHook().create();
		
			/*
			 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
			 * driver.manage().window().maximize();
			 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			 */
			
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (br.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://member.lazada.com.ph/user/login");
		/*
		 * // driver.manage().deleteAllCookies(); Thread.sleep(3000);
		 * logger.info(driver.getTitle()); logger.info(driver.getCurrentUrl());
		 */
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir") + "/Screenshots/" + testCaseName + ".png");
		FileUtils.copyFile(source, destinationFile);
		logger.info("Screenshot Taken");

	}

}