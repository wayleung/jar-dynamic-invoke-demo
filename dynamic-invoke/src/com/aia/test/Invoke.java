package com.aia.test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aia.dto.Case;
import com.aia.dto.Detail;
import com.aia.dto.Summary;


/**
 * 
 * @author Way Liang asnphxw
 *
 * @date Jul 4, 2018 
 *
 * @description:
 *
 */
public class Invoke {
 

	//@SuppressWarnings({ "unchecked", "resource", "rawtypes" })
	public static void main(String[] args) throws Exception {
		/*Scanner scanner = new Scanner(System.in);
		flag = scanner.nextInt();
		if (flag == 1) {
			softPath = "file:D:"+File.separator+"jar"+File.separator+"demo1.jar";
		} else {
			softPath = "file:D:"+File.separator+"jar"+File.separator+"demo2.jar";
		}
		URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL(softPath)},Thread.currentThread().getContextClassLoader());
		Class demo = classLoader.loadClass("com.aia.test.Test");
		Object object = demo.newInstance();
		//System.out.println(demo.getMethod("welcome",String.class).invoke(object,new Object[]{"way"}));
		System.out.println(demo.getMethod("welcome",String.class).invoke(object,"way"));*/
		

		String	jarPath = "file:D:"+File.separator+"jar"+File.separator+"freemarkerutil.jar";

		URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL(jarPath)},Thread.currentThread().getContextClassLoader());
		Class demo = classLoader.loadClass("com.aia.util.FreemarkerUtil");
		Object object = demo.newInstance();
		
		
		
		//System.out.println(demo.getMethod("welcome",String.class).invoke(object,new Object[]{"way"}));
		//System.out.println(demo.getMethod("welcome",String.class).invoke(object,"way"));
		
		Summary summary = new Summary("2018-07-04 13:42:00", "2018-07-04 13:42:00", "2", "6", "6", "6","6", "0.6", "0.7");
		
		Case google = new Case("google", "SUCCESS", "20s", "0", "10");
		Case yahoo = new Case("yahoo", "SUCCESS", "20s", "0", "10");
		Case sina = new Case("sina", "Fail", "20s", "0", "10");
		Case alibaba = new Case("alibaba", "Fail", "20s", "0", "10");	
		List<Case> cases = new ArrayList<Case>();
		cases.add(google);
		cases.add(yahoo);
		cases.add(sina);
		cases.add(alibaba);
		
		summary.setCases(cases);
		
		demo.getMethod("generateSummaryHtml",String.class,Summary.class).invoke(object,"", summary);
		
		List<Detail> details = new ArrayList<Detail>();
		details.add(new Detail("1","description", "SUCCESS", "message"));
		details.add(new Detail("2","description2", "SUCCESS", "message2"));
		
		google.setDetails(details);
		yahoo.setDetails(details);
		sina.setDetails(details);
		alibaba.setDetails(details);
		
		demo.getMethod("generateCaseHtml",String.class,Case.class).invoke(object,"",  google);
		demo.getMethod("generateCaseHtml",String.class,Case.class).invoke(object,"",  yahoo);
		demo.getMethod("generateCaseHtml",String.class,Case.class).invoke(object,"",  sina);
		demo.getMethod("generateCaseHtml",String.class,Case.class).invoke(object,"",  alibaba);
		
		
		
		Class demo1 = classLoader.loadClass("com.aia.util.InvokeTest");
		Object object1 = demo1.newInstance();
		boolean flag =  (boolean) demo1.getMethod("invokeSelenium",WebDriver.class,WebElement.class).invoke(object1, null,null);
		System.out.println(flag);
		
/*		Class demo2 = classLoader.loadClass("com.aia.util.InvokeTest");
		Object object2 = demo2.newInstance();
		Object object3 = demo2.getMethod("invokeVoid",String.class).invoke(object2, "way");
		System.out.println(object3);*/
		
		invokeFromJar(jarPath, "com.aia.util.InvokeTest", "invokeVoid", "way");
	}
	
	
	/**
	 * 
	 * @param jarPath   jar包位置
	 * @param fullClassName    要调用的类 全类名  包括包名
	 * @param methodName		要调用的方法名
	 * @param args     方法的参数
	 * @return
	 * @throws MalformedURLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static Object invokeFromJar(String	jarPath,String fullClassName,String methodName,Object... args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL(jarPath)},Thread.currentThread().getContextClassLoader());
		Class klass = classLoader.loadClass(fullClassName);
		Object instance = klass.newInstance();
		Class[] argClass =  new Class[args.length];
		for (int i=0;i<args.length;i++) {
			if(args[i]==null){
				argClass[i] = null;
			}else{
				argClass[i] = args[i].getClass();
			}
			
		}
		Object object3 = klass.getMethod(methodName,argClass).invoke(instance, args);
		System.out.println(object3);
		
		return null;
		
	}
	
}
