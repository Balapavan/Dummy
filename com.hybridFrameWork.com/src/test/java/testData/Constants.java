package testData;

import udf.UDF;
import utilityHelpers.DirectoryHealper;
import utilityHelpers.PropertyFileR_W;

public class Constants {

	public static final String WORKDIR=System.getProperty("user.dir");
	public static final String PROPFILEPATH=WORKDIR+"\\Env.properties";
	
	public static final String CURRENTMILLISECONDS=System.currentTimeMillis()+"";
	
	/*** Web Driver Paths and Declarations ***/
	public static final String CHROMEDRIVERKEY="webdriver.chrome.driver";
	public static final String CHROMEDRIVERPATH=WORKDIR+"\\chromedriver.exe";
	public static final String FIREFOXDRIVERKEY="webdriver.geko.driver";
	public static final String FIREFOXDRIVERPATH=WORKDIR+"\\chromedriver.exe";
	
	/*** Excels File paths ****/
	public static final String SOURCETESTCASESSHEETPATH=WORKDIR+"\\src\\test\\java\\testData\\TestCases.xls";
	public static String TESTDATSHEETPATH=WORKDIR+"\\src\\test\\java\\testData\\TestData_"+PropertyFileR_W.getPropValue(PROPFILEPATH, "Env")+".xls";
	
	public static final String TESTDATASHEETNAME_LOGIN="testdata";
	
	
	/** Output folder paths ***/ 
	public static String DATEWISEPATH=DirectoryHealper.makeDirectory("E:\\SeleniumTestResults\\"+UDF.CurrentDate());
	public static  String OUTPUTFOLDER=DirectoryHealper.makeDirectory(DATEWISEPATH+"\\"+CURRENTMILLISECONDS);
	public static String LOGGERSFOLDER=DirectoryHealper.makeDirectory(OUTPUTFOLDER+"\\Logs");
	public static String SCREENSHORTS=DirectoryHealper.makeDirectory(OUTPUTFOLDER+"\\Screenshorts");
	
	
	public static  String TESTCASESSHEETPATH=OUTPUTFOLDER+"\\TestCases_"+CURRENTMILLISECONDS+".xlsx";
	
}
