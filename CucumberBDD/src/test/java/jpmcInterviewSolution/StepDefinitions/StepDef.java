package jpmcInterviewSolution.StepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jpmcInterviewSolution.DriverManger.SingletonDriver;
import jpmcInterviewSolution.PageObjects.GoogleSearchPage;
import jpmcInterviewSolution.PageObjects.TheGaurdianHomePage;
import jpmcInterviewSolution.ProjectUtility.DataContainer;

public class StepDef extends DataContainer {
	WebDriver driver;
	GoogleSearchPage googlePage;
	TheGaurdianHomePage theGarudianPage;
	Logger logObject;

	@Given("^Web browser is selected as Chrome$")
	public void web_browser_is_selected_as_chrome() {

		SingletonDriver sc1 = SingletonDriver.getInstanceOfSingletonDriver();
		driver = sc1.getDriver();
		googlePage = new GoogleSearchPage(driver);
		theGarudianPage = new TheGaurdianHomePage(driver);

	}

	@Given("^Jhon is a fake new validator at The Gaurdian$")
	public void jhon_is_a_fake_news_validator_at_the_gaurdian() throws Throwable {
		System.out.println("Jhon is a fake new validator at The Gaurdian");
		logObject.info("Jhon is a fake new validator at The Gaurdian");
	}

	@When("^Jhon navigates to The Gaurdian News home page$")
	public void jhon_navigates_to_then_gaurdian_news_home_page() throws Throwable {
		theGarudianPage.navigateToTheGaurdianHomePage();
	}

	@And("^Picks the first new displayed$")
	public void pick_the_first_news_displayed() {
		theGarudianPage.getTheFirstNewsLinkText();
	}

	@Then("^Jhon checks for the date of publish is today$")
	public void check_for_the_date_of_publish() throws Throwable {
		theGarudianPage.verifyThePublsihingDateIsToday();
	}

	@Given("^Jhon opens up google search engine$")
	public void navigate_to_google_homepage() {
		googlePage.navigateToURL();

	}

	@When("^Searches for the 1st news of the gaurdian$")
	public void search_in_google() {
		googlePage.searchForContent();
	}

	@Then("^Verify the 1st appearing link is from The Gaurdian$")
	public void get_the_source_of_first_link() {
		System.out.println("7");
		googlePage.verifyTheFirstLinkIsFromTheGaurdian();

	}

	@Given("^Jhon picks the search result other than The Gardian$")
	public void validate_the_authenticit_of_the_news() {
		System.out.println("8");

	}

	@When("^Checks the news content$")
	public void get_the_first_news_content() {
		System.out.println("9");
	}

	@Then("^Verify the (.*) of words match to confirm the authenticity$")
	public void step_Ten(int percentage) {
		System.out.println("10");
		googlePage.verifyTheLinkOtherThanGaurdianIsAMatch(percentage);

	}

}
