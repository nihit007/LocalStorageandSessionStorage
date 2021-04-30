package com.session.local;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RetrievingStorageData {
	

	
	@Test
	public void LocalStorage() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com/");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String clickstream_source = (String) js
				.executeScript(String.format("return window.sessionStorage.getItem('%s');", "clickstream_source"));
		String google_experiment_mod54 = (String) js
				.executeScript(String.format("return window.sessionStorage.getItem('%s');", "yt-remote-session-app"));
		String goog_pem_mod = (String) js
				.executeScript(String.format("return window.sessionStorage.getItem('%s');", "yt-remote-session-name"));

		System.out.println("Retrieving Data of Session Storage of BookMyShow");
		System.out.println("clickstream_source :" + clickstream_source);
		driver.quit();
	}
}
