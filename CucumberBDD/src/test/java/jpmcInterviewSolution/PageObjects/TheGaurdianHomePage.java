package jpmcInterviewSolution.PageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import jpmcInterviewSolution.ProjectUtility.DataContainer;
import jpmcInterviewSolution.ProjectUtility.Environment;

public class TheGaurdianHomePage extends DataContainer {
	WebDriver driver;

	public TheGaurdianHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//time[@class='fc-date-headline']")
	private WebElement dateTime;

	@FindBy(xpath = "//div[@class=\"fc-item__header\"][1]")
	private WebElement link_firstNews;

	@FindBy(xpath = "//input[@name='btnK']")
	private WebElement button_GoogleSearch;

	public void navigateToTheGaurdianHomePage() {
		driver.navigate().to(Environment.TheGarduianNewsURL);
	}

	public void verifyPublishingDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println();
		Assert.assertEquals(dateTime.getText().toString().toLowerCase(), dtf.format(now).toString().toLowerCase());
	}

	public void verifyThePublsihingDateIsToday() {

	}

	public void verifyTheTimeStampIsThere() {

	}

	public void getTheFirstNewsLinkText() {
		System.out.println("----------------");
		DataContainer d = DataContainer.getDataInstace();
		d.setData(link_firstNews.getText());
		System.out.println(d.getData());
	}
}
