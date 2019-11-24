package listners;

import java.io.IOException;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.PropertiesFile;

import com.gargoylesoftware.htmlunit.javascript.host.InstallTrigger;

import testData.Constants;
import utilityHelpers.PropertyFileR_W;

public class RetryListner implements IRetryAnalyzer{
		
	
	
	 private int retryCount = 0;
	 
	 private int maxRetryCount=Integer.parseInt(PropertyFileR_W.getPropValue(Constants.PROPFILEPATH, "RetryCount"));
	 				 
	@Override
	  public boolean retry(ITestResult result) {
		 
	    if (retryCount < maxRetryCount) { 	
	      retryCount++;
	      return true;
	    }
	    return false;
	  }
}
