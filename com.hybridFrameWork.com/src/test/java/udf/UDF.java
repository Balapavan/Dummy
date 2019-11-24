package udf;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import page.PageObjectModel;

public class UDF extends PageObjectModel{

	public UDF(WebDriver driver) {
		super(driver);
		
	} 

	public static String CurrentDate()
	{
		Date d =new Date();
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
		String setDate=format.format(d);
		System.out.println("Date===="+setDate);
		return setDate;
	}
}
