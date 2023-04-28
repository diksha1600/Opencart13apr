package testCases;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;

import testBase.BaseClass;

public class TC_001_Acc_Reg_In_Multipal_Browser extends BaseClass {
	public Logger logger; //for logger
	
		public WebDriver driver;
		
		@BeforeClass
		@Parameters("browser")
		public void setUp(String br) {
			logger = LogManager.getLogger(this.getClass());
			
//			lunch right browser based on parameters
			if(br.equals("chrome")) {
				driver = new ChromeDriver();
			}
			else if(br.equals("edge")) {
				driver = new EdgeDriver();
			}
			else {
				driver = new ChromeDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://localhost/opencart/upload");
			driver.manage().window().maximize();
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
		
		public String randomeString() {
			String generatedString = RandomStringUtils.randomAlphabetic(5);
			return (generatedString);
		}

		public String randomeNumber() {
			String generatedString2 = RandomStringUtils.randomNumeric(10);
			return (generatedString2);
		}
		
		public String randomAlphaNumeric() {
			String st = RandomStringUtils.randomAlphabetic(4);
			String num = RandomStringUtils.randomNumeric(3);
			
			return (st+"@"+num);
		}
}
