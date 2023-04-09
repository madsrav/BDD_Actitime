package com.act.Objectrepo;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.act_generic.BaseClass;
import com.act_generic.WebDriverUtilities;

public class TaskPage {


	@FindBy(xpath = "//div[@class='addNewButton']")
	private WebElement ClickDropDownAddNew;

	@FindBy(xpath = "//div[@class='item createNewCustomer']")
	private WebElement ClickNewCus;

	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement EnterName;

	@FindBy(xpath = "//div[@class='comboboxButton']")
	private WebElement ClickDropDown;

	@FindBy(xpath = "(//div[text()='Big Bang Company'])[5]")
	private WebElement ClickProjectFromExisting;

	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement ClickOnCreateCus;

	@FindBy(xpath = "(//input[@placeholder='Start typing name ...'])[1]")
	private WebElement VerifyName;
	
	@FindBy(xpath = "//div[@class='itemsContainer']//span")
	private List<WebElement> finalName;

	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getClickDropDownAddNew() {
		return ClickDropDownAddNew;
	}

	public WebElement getClickNewCus() {
		return ClickNewCus;
	}

	public WebElement getEnterName() {
		return EnterName;
	}

	public WebElement getClickDropDown() {
		return ClickDropDown;
	}

	public WebElement getClickProjectFromExisting() {
		return ClickProjectFromExisting;
	}

	public WebElement getClickOnCreateCus() {
		return ClickOnCreateCus;
	}

	public WebElement getVerifyName() {
		return VerifyName;
	}

	public List<WebElement> getFinalName() {
		return finalName;
	}

	public void TaskPageName(WebDriver driver, String name) {
		
		getEnterName().sendKeys(name);
		getClickDropDown().click();
		WebDriverUtilities webDriverUtilities = new WebDriverUtilities();
		webDriverUtilities.jsClick(driver, getClickProjectFromExisting());
	//	getClickProjectFromExisting().click();
		getClickOnCreateCus().click();
		getVerifyName().sendKeys(name);
	}

}
