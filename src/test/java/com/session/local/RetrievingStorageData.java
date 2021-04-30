package com.session.local;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.Test;

public class RetrievingStorageData {

	@Test
	public void LocalStorage() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com/");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		//WITHOUT JAVASCRIPT

		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
		LocalStorage localStorage = webStorage.getLocalStorage();
		System.out.println("without javascript WZRK_G : " + localStorage.getItem("WZRK_G"));
		System.out.println("without javascript WZRK_L: " + localStorage.getItem("WZRK_L"));
		System.out.println("without javascript WZRK_META: " + localStorage.getItem("WZRK_META"));

		//WITH JAVASCRIPT
		System.out.println("Using JavaScript");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String WZRK_G = (String) js.executeScript(String.format("return window.localStorage.getItem('%s');", "WZRK_G"));
		String WZRK_L = (String) js.executeScript(String.format("return window.localStorage.getItem('%s');", "WZRK_L"));
		String WZRK_META = (String) js
				.executeScript(String.format("return window.localStorage.getItem('%s');", "WZRK_META"));

		System.out.println("Retrieving Data of Local Storage of BookMyShow");
		System.out.println("WZRK_G :" + WZRK_G);
		System.out.println("WZRK_L :" + WZRK_L);
		System.out.println("WZRK_META :" + WZRK_META);
		driver.quit();
	}

	@Test
	public void SessionStorage() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com/");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		//WITHOUT JAVASCRIPT
		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
		SessionStorage sessionStorage = webStorage.getSessionStorage();
		System.out.println("Without JavaScript clickstream_source : " + sessionStorage.getItem("clickstream_source"));
		
		// WITH JAVASCRIPT
		System.out.println("Using JavaScript");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String clickstream_source = (String) js
				.executeScript(String.format("return window.sessionStorage.getItem('%s');", "clickstream_source"));

		System.out.println("Retrieving Data of Session Storage of BookMyShow");
		System.out.println("clickstream_source :" + clickstream_source);
		driver.quit();
	}
}
