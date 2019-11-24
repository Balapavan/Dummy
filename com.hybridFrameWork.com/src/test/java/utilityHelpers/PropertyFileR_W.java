package utilityHelpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;

public class PropertyFileR_W {
	
	
	public static String getPropValue(String strFilepath,String strKey) {
		try {
			Properties pop=new Properties();
			pop.load(new FileInputStream(strFilepath));
			return pop.get(strKey.toLowerCase()).toString();
		} catch (Exception e) {
			System.out.println("Can't read Property for strFilepath: "+strFilepath+" strKey: "+strKey);
			return null;
		}
	}
	
	public static boolean boolSetProp(String strFilepath,String strKey,String setvalue) throws FileNotFoundException, IOException {
		Properties pop=new Properties();
		pop.load(new FileInputStream(strFilepath));
		pop.setProperty(strKey, setvalue);
		if(pop.get(strKey).equals(setvalue)) {
			return true;
		}
		return false;
	}
}
