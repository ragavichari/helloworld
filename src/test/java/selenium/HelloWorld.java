package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {
public static  void main(String[]args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\general\\eclipse-workspace\\hello-world\\src\\test\\resources\\drivers\\chromedriver.exe");
	WebDriver ChromeDriver = new ChromeDriver();
	ChromeDriver.get("https://amazon.com");
}
}
