package com.aia.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



/**
 * @author Way Liang ASNPHXW
 *
 * @date Jul 5, 2018 
 *
 * @description:
 *
 */
public class InvokeTest {
	
	public static void main(String[] args) {
		invokeSelenium(null,null);
		invokeVoid("way");
	}
	
	public static boolean invokeSelenium(WebDriver driver,WebElement webElement){
		return true;
	}
	
	public static void invokeVoid(String name){
		System.out.println("--void"+name);
	}
}
