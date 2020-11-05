package jpmcInterviewSolution.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import jpmcInterviewSolution.ProjectUtility.DataContainer;
import jpmcInterviewSolution.ProjectUtility.Environment;

public class GoogleSearchPage {
	WebDriver driver;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	WebElement txtbx_SearchField;

	@FindBy(xpath = "//input[@name='btnK']")
	WebElement button_GoogleSearch;

	@FindBy(xpath = "//h3[@class=\"LC20lb DKV0Md\"]")
	private List<WebElement> link_SearchResult;

	@FindBy(xpath = "//cite[1]")
	WebElement link_SearchLinkSite;

	public void navigateToURL() {
		driver.navigate().to(Environment.GoogleDotComURL);
	}

	public void searchForContent() {
		DataContainer d = DataContainer.getDataInstace();
		String newsHeading = d.getData();
		System.out.println(newsHeading + "##############################################################");
		txtbx_SearchField.sendKeys(newsHeading + Keys.ENTER);
	}

	public void verifyTheFirstLinkIsFromTheGaurdian() {
		String actualSiteName = link_SearchLinkSite.getText();
		System.out.println(actualSiteName);
		Assert.assertTrue(actualSiteName.contains("www.theguardian.com"));
	}

	public void verifyTheLinkOtherThanGaurdianIsAMatch(int percentage) {
		DataContainer d = DataContainer.getDataInstace();
		String newsHeading = d.getData();
		String[] words = newsHeading.split("([\\W\\s]+)");
		// get the site which is not from the gaurdian
		boolean siteIndexNotFound = true;
		int index = 1;
		while (siteIndexNotFound) {
			WebElement element = driver.findElement(By.xpath("//cite[" + index + "]"));
			if (element.getText().contains("thegaurdian")) {
				index = index + 1;
			} else {
				siteIndexNotFound = false;
			}
		}

		// get the text of that link
		String contentFromOtherSite = link_SearchResult.get(index).getText();
		// verify the words are 50% match
		int matchCounter = 0;
		for (String eachWord : words) {
			if (contentFromOtherSite.contains(eachWord)) {
				matchCounter = matchCounter + 1;
			}
		}

		Assert.assertTrue(matchCounter > (percentage / 100) * words.length);

	}
}
