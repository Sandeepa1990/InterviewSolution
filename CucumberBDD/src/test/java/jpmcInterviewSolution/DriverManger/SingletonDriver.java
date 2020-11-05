package jpmcInterviewSolution.DriverManger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {
	private static SingletonDriver driverInstance = null;
	public WebDriver driver;

	private SingletonDriver() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Interview\\CucumberBDD\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	public static SingletonDriver getInstanceOfSingletonDriver() {

		if (driverInstance == null) {
			synchronized (SingletonDriver.class) {
				if (driverInstance == null) {

					driverInstance = new SingletonDriver();
				}
			}
		}
		return driverInstance;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
