package cl.hakalab.projectBaseWeb.utils;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cl.hakalab.projectBaseWeb.flow.BaseFlow;
import cucumber.api.Scenario;

public class GenericMethod {

	
	public static void scrollElement( WebElement element) throws InterruptedException {
		((JavascriptExecutor) BaseFlow.driver).executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(1000);
	}
	
	public static void focusElement( WebElement element) throws Exception {
		Thread.sleep(1000);
		((JavascriptExecutor) BaseFlow.driver).executeScript("arguments[0].focus();", element);
		Thread.sleep(1000);
	}
	
	public static void focus(WebElement element) throws Exception {
		Thread.sleep(1000);
		new Actions(BaseFlow.driver).moveToElement(element).perform(); 
		Thread.sleep(1000);
	}

	public static void clickElement(WebElement element) throws Exception {
		((JavascriptExecutor) BaseFlow.driver).executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(500);
		((JavascriptExecutor) BaseFlow.driver).executeScript("arguments[0].click();", element);
		Thread.sleep(500);
	}
	
	
	public static String getDate() {
		 Calendar fecha = new GregorianCalendar();
	        //Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
	        //Usando el método get y el parámetro correspondiente.
	        Integer annio = fecha.get(Calendar.YEAR);
	        Integer mes = fecha.get(Calendar.MONTH)+1;
	        Integer dia = fecha.get(Calendar.DAY_OF_MONTH);
	        Integer hora = fecha.get(Calendar.HOUR_OF_DAY);
	        Integer minuto = fecha.get(Calendar.MINUTE);
	        Integer segundo = fecha.get(Calendar.SECOND);
	        String anio = String.valueOf(annio)+String.valueOf(mes)+String.valueOf(dia);
	        String horaTotal = String.valueOf(hora)+String.valueOf(minuto)+String.valueOf(segundo); 
	        return anio+"_"+horaTotal;
	}
	
	public static WebElement implicityWait(Integer timeoutInSeconds,By element)throws Exception{
    	WebElement elemento = null;
    	try {
    		WebDriverWait wait = new WebDriverWait(BaseFlow.driver, timeoutInSeconds); 
        	elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}catch (Exception e) {
			System.out.println(e);
		}
    	return elemento;
    }
	
	public static Boolean isElementVisible(Integer timeoutInSeconds,By element)throws Exception{
    	Boolean valid = false;
		WebElement elemento = BaseFlow.driver.findElements(element).get(0);
    	try {
    		WebDriverWait wait = new WebDriverWait(BaseFlow.driver, timeoutInSeconds); 
        	elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        	valid = elemento!=null?true:false;
		}catch (Exception e) {
			System.out.println(e);
		}
    	return valid;
    }
	
	
	 public static WebElement waitForClickeable(Integer timeoutInSeconds,WebElement element)throws Exception{
    	WebElement elemento = null;
    	try {
    		WebDriverWait wait = new WebDriverWait(BaseFlow.driver, timeoutInSeconds); 
        	elemento = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch (Exception e) {
			System.out.println(e);
		}
    	return elemento;
    }
	 
	 public static WebElement waitForClickeable(Integer timeoutInSeconds,By element)throws Exception{
    	WebElement elemento = null;
    	try {
    		WebDriverWait wait = new WebDriverWait(BaseFlow.driver, timeoutInSeconds); 
        	elemento = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch (Exception e) {
			System.out.println(e);
		}
    	return elemento;
	 }
	 
	 public static Boolean existElement(By element) throws InterruptedException { 
    	boolean isPresent = false; 
    	for (int i = 0; i < 1; i++) {
    	 try { 
    		 	if (BaseFlow.driver.findElement(element) != null) 
    		 	{ 
    		 		isPresent = true; 
    		 		break; 
    	 		} 
     		} catch (Exception e) { // 
     			Thread.sleep(500); 
    		} 
    	} 
    	return isPresent;
 	}
	
	 public static void screenShotForScenario(Scenario scenario) throws Exception {
		if(scenario.getStatus().equals("failed")){
			File sourcePath = ((TakesScreenshot) BaseFlow.driver).getScreenshotAs(OutputType.FILE);
			String folderPath = System.getProperty("user.dir")+"/ReporteHTML/Screenshot/";
			File folder = new File(folderPath);
			DeleteFileIfExist(folder);
			folder.mkdir();
			File destinationPath = new File(folderPath + scenario.getName() + ".png");
			Files.copy(sourcePath, destinationPath);
			Reporter.addScreenCaptureFromPath(destinationPath.toString(),scenario.getName());	
		}
	}
	 
	 private static void DeleteFileIfExist(File file) {
		    if (!file.exists()) {
		    	file.delete();
		    } 
		}
	 
}