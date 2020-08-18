package ScreenShot_Pag;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import BaseClass.Base;

public class ScreenShot extends Base{
	
	public static String getScreenShot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenShot/"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			System.out.println("Capture failed"+e.getMessage());
		}
		return path;
	}

}
