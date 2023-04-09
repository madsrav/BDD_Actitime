package hook;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.act_generic.BaseClass;
import com.act_generic.PropertyFileUtility;
import com.act_generic.WebDriverUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends BaseClass{

	public static final String USERNAME = "kumar_NzcovG";
	public static final String AUTOMATE_KEY = "fQWCKQYT1sKtVN95Mse9";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public boolean isRemote = false;
	BaseClass base;

	public Hook(BaseClass base) {
		this.base = base;
	}

	@Before
	public void setUp() throws IOException {
		base.propertyFileUtility = new PropertyFileUtility();
		base.propertyFileUtility.loadProperty();
		base.webDriverUtilities = new WebDriverUtilities();
		String browser = base.propertyFileUtility.getBrowser();
		String remote = base.propertyFileUtility.getRemote();
		// String browser = System.getProperty("browser");
		if (remote.equals("none")) {
			if (browser.equals("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				base.driver = new ChromeDriver(options);
			} else if (browser.equals("firefox")) {
				base.driver = new FirefoxDriver();
			}
		} else if (remote.equals("ios")) {
			isRemote = true;
//			DesiredCapabilities cap= new DesiredCapabilities();
//			cap.setCapability(CapabilityType.BROWSER_NAME, "Safari");
//			cap.setCapability("browser_Version", "13.1");
//			cap.setCapability("os", "OS X");
//			cap.setCapability("os_version", "Catalina");
//			cap.setCapability("build", "build 1.0");
//			cap.setCapability("name", "My First TesT Run in Cloud");
			MutableCapabilities capabilities = new MutableCapabilities();
			capabilities.setCapability("browserName", "Safari");
			HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
			browserstackOptions.put("os", "OS X");
			browserstackOptions.put("osVersion", "Catalina");
			browserstackOptions.put("browserVersion", "13.0");
			browserstackOptions.put("projectName", "Actitime");
			browserstackOptions.put("buildName", "build 4");
			browserstackOptions.put("sessionName", "BDD_practice");
			browserstackOptions.put("local", "false");
			browserstackOptions.put("debug", "true");
			browserstackOptions.put("networkLogs", "true");
			browserstackOptions.put("seleniumVersion", "4.7.2");
			capabilities.setCapability("bstack:options", browserstackOptions);

			base.driver = new RemoteWebDriver(new URL(URL), capabilities);
		} else if (remote.equals("chrome11")) {
			isRemote = true;
			MutableCapabilities capabilities = new MutableCapabilities();
			capabilities.setCapability("browserName", "Chrome");
			HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
			browserstackOptions.put("os", "Windows");
			browserstackOptions.put("osVersion", "11");
			browserstackOptions.put("browserVersion", "latest");
			browserstackOptions.put("projectName", "Actitime");
			browserstackOptions.put("buildName", "build 4");
			browserstackOptions.put("sessionName", "BDD_practice");
			browserstackOptions.put("local", "false");
			browserstackOptions.put("debug", "true");
			browserstackOptions.put("networkLogs", "true");
			browserstackOptions.put("seleniumVersion", "4.7.2");
			capabilities.setCapability("bstack:options", browserstackOptions);

			base.driver = new RemoteWebDriver(new URL(URL), capabilities);
		}
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(base.propertyFileUtility.getImplicitWait(), TimeUnit.SECONDS);
		base.driver.get(base.propertyFileUtility.getURL());
	}

	@After
	public void teardown(Scenario scenario) {
		JavascriptExecutor jse = (JavascriptExecutor)base.driver;
		if (scenario.isFailed()) {
			if (isRemote) {
				jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"<reason>\"}}");
			}
			byte[] screenshot = base.webDriverUtilities.takescreenShot1(base.driver);
			scenario.attach(screenshot, "image/png", scenario.getName());
		} else if(isRemote) {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\"}}");
		}
		base.driver.quit();
	}

}
