package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOne {
	public static void main(String[] args) throws InterruptedException {
		
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://demowebshop.tricentis.com/books");
	driver.findElement(By.id("products-orderby")).click();
	WebElement parentEle=driver.findElement(By.xpath("//*[contains(@value,'https://demowebshop.tricentis.com/books?orderby')]"));//products-orderby
	WebElement childEle=parentEle.findElement(By.xpath("//*[contains(text(),'Price: High to Low')]"));
	childEle.click();
	Thread.sleep(2000);
	}
}
