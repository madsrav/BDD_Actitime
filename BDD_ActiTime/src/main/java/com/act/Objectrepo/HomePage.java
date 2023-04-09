package com.act.Objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(name="username")
	private WebElement username;
	@FindBy(name="pwd")
	private WebElement password;
	@FindBy(name="remember")
	private WebElement Keepmeloggedin;
	@FindBy(id="loginButton")
	private WebElement ClickLogin;
	@FindBy(id="container_tasks")
	private WebElement ClickTasksModule;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getClickTasksModule() {
		return ClickTasksModule;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getKeepmeloggedin() {
		return Keepmeloggedin;
	}

	public WebElement getClickLogin() {
		return ClickLogin;
	}
	
	
}
