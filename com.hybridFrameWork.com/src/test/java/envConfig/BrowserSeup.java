package envConfig;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.bcel.classfile.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import listners.ExtendReports;
import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;
import okhttp3.internal.platform.ConscryptPlatform;
import testData.Constants;
import utilityHelpers.DirectoryHealper;
import utilityHelpers.ExcelReader_Writer;
import utilityHelpers.PropertyFileR_W;

public class BrowserSeup extends ExtendReports{
	
	public static String strBrowser;
	
	@BeforeSuite
	public static void readyTolaunch() throws IOException
	{
		DirectoryHealper.copyFilesToOtherLocation(Constants.SOURCETESTCASESSHEETPATH, Constants.TESTCASESSHEETPATH);
		System.out.println(Constants.LOGGERSFOLDER);
		setBrowser();
	}

	@AfterSuite
	public static void didFinish() {
		terminateDriverInstance();
	}
	
	
	public static void setBrowser() throws FileNotFoundException, IOException{
		String setUrl=getURL();
		if(setUrl== null || setUrl.isEmpty()) {
			System.out.println("Received Invalid URL hence terminating Scripts...setUrl: "+setUrl);
			return;
		}
		strBrowser=PropertyFileR_W.getPropValue(Constants.PROPFILEPATH, "Browser");
		if(strBrowser.toLowerCase().contentEquals("ff")) {
			setFirefoxBrowser();
		}
		else {
			setChromeBrowser();
		}
		System.out.println("[setBrowser] ULR: "+setUrl);
		driver.get(setUrl);
	}

	
	
	public static void setChromeBrowser(){
		
		System.setProperty(Constants.CHROMEDRIVERKEY,Constants.CHROMEDRIVERPATH);
		driver=new ChromeDriver();
	}
	
	public static void setFirefoxBrowser(){
		
		System.setProperty(Constants.FIREFOXDRIVERKEY,Constants.FIREFOXDRIVERPATH);
		driver=new FirefoxDriver();
	}

	public static void terminateDriverInstance(){
		try {
			driver.quit();
			switch (strBrowser) {
			case "gc":
				Runtime.getRuntime().exec("Taskkill /IM Chromedriver.exe /f");
				System.out.println("[terminateDriverInstance] Done for Chrome");
				break;
			case "ff":
				Runtime.getRuntime().exec("Taskkill /IM geckodriver.exe /f");
				System.out.println("[terminateDriverInstance] Done for FireFox");
				break;
			default:
				System.out.println("[terminateDriverInstance] Default not received termination request.");
				break;
			}	
		} catch (Exception e) {
			System.out.println("[terminateDriverInstance] Failed "+e.getStackTrace());
		}
		
	}
	
	public static String getURL() 
	{	
		try {
			return ExcelReader_Writer.getTestDataFromExcel(Constants.TESTDATASHEETNAME_LOGIN, 1, 1);
		} catch (Exception e) {
			System.out.println("[getURL] Failed Reason: "+e.getMessage());
			return null;
		}
				
	}
	
	
	
}
