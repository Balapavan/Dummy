package utilityHelpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class DirectoryHealper {
	
	
	/** To Create Directory in Required path ***/
	public static String makeDirectory(String strDirectory) {
		File fis=new File(strDirectory);
		if(!fis.exists()) {
			boolean isMakeDirectory=fis.mkdir();
			if(!isMakeDirectory) {
					return null;
			}
			System.out.println("[makeDirectory] Created Succfully for "+strDirectory);
			return strDirectory;
		}
		else if(fis.exists()) {
			System.out.println("[makeDirectory] Already Exist hence ignore "+strDirectory);
			return strDirectory;
		}
		return null;
	}

	/** Copy file from one location to other location ***/
	public static void copyFilesToOtherLocation(String strSourcePath,String strDestination) throws IOException {
		File fisSource=new File(strSourcePath);
		File fisDestination=new File(strDestination);
		FileUtils.copyFile(fisSource, fisDestination);
		System.out.println("[copyFilesToOtherLocation] Completed .");
	}
	
	/** Check Directory Exist or not **/
	public static boolean isDirectoryExist(String strDirpath) {
		
		return new File(strDirpath).exists();
	}
	
	/**
	 * @author BALA PAVAN S
	 * @Date 
	 */
}
