package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import objectRepository.OR;

public class PageObjectModel extends OR{
	
	public static WebDriver driver;
	
	public PageObjectModel(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
