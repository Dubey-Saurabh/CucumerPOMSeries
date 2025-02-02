package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(String browser) {

		System.out.println("browser value is:" + browser);

		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			tlDriver.set(new ChromeDriver());

		} else {

			if (browser.equals("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new FirefoxDriver());

			} else {

				if (browser.equals("safari")) {
					tlDriver.set(new SafariDriver());

				} else {

					System.out.println("No browser found" + browser);
				}

			}

		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
