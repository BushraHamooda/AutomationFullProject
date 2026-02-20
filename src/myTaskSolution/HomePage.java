package myTaskSolution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.sql.Driver;
import java.util.List;
import java.util.Random;

public class HomePage extends TestData{

	

	@BeforeTest
	public void mySetup() throws InterruptedException {
		SetUpMyTest();
	
	}

	@Test(priority=1 ,enabled=true)
	public void Signup() throws InterruptedException {

		WebElement LoginAndSignUpButton = driver.findElement(By.linkText("Login or register"));
		LoginAndSignUpButton.click();
		//to press continue button
		
		WebElement countineButtonBeforeSignup  =driver.findElement(By.xpath("//button[@title='Continue']"));
		countineButtonBeforeSignup.click();
		
		//------------- you are inside the signup page----------

		//Elements
		WebElement firstNameInputField = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement lastNameInputField = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement emailInput = driver.findElement(By.id("AccountFrm_email"));
		WebElement addressInput = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement countryDropDown = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StateDropDown = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement cityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement postalInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement loginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement confirmPasswordInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement conditionsAndTermsChickBox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement countinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
		
        //Action
		firstNameInputField.sendKeys(randomFirstNames);
		lastNameInputField.sendKeys(randomlastNames);
		emailInput.sendKeys(theEmail);
		addressInput.sendKeys("Amman");
		Select countrySelect = new Select(countryDropDown);
		countrySelect.selectByValue("108");
		Thread.sleep(5000);
		int randomState = rand.nextInt(StateDropDown.findElements(By.tagName("option")).size());
		Select SelectForStateDropDown = new Select(StateDropDown);
		SelectForStateDropDown.selectByIndex(randomState);
		cityInput.sendKeys("RandomCity");
		postalInput.sendKeys("RandomPostal");
		loginNameInput.sendKeys(LoginName);
		passwordInput.sendKeys(passwordAndConfirm);
		confirmPasswordInput.sendKeys(passwordAndConfirm);
		conditionsAndTermsChickBox.click();
		countinueButton.click();
		
		//Assertion
		Assert.assertEquals(driver.getCurrentUrl().contains("sucsess"),true);
		 Assert.assertEquals(driver.getPageSource().contains("Congratulations"),true);
		 Assert.assertEquals(driver.getCurrentUrl().contains("sucsess"),true);
		 WebElement welcomMessageArea =driver.findElement(By.id("customernav"));
		 Assert.assertEquals(welcomMessageArea.getText().contains(randomlastNames),true);

	}
	@Test(priority=2 ,enabled=true)
	public void Logout() {
		driver.navigate().to(logoutLink);
		
		WebElement contentPanelLogoutMessage = driver.findElement(By.xpath("//div[@class='contentpanel']"));
		boolean ActuallLogoutValue =contentPanelLogoutMessage.getText().contains(ExpectedLogoutMessage);
		//Assertion
		Assert.assertEquals(ActuallLogoutValue, ExpectedLogoutValue);
		
	}
	
	@Test(priority=3,enabled=true)
     public void Login () {
		
		WebElement LoginAndSignUpButton = driver.findElement(By.linkText("Login or register"));
		LoginAndSignUpButton.click();
		
		//elements
		WebElement LoginInputField= driver.findElement(By.id("loginFrm_loginname"));
		WebElement PasswordInputField= driver.findElement(By.id("loginFrm_password"));
		WebElement LoginButton = driver.findElement(By.xpath("//button[@title='Login']"));
       //action
		LoginInputField.sendKeys(LoginName);
		PasswordInputField.sendKeys(passwordAndConfirm);
		LoginButton.click();
		
		//Assertion
		WebElement WelcomeMessageArea = driver.findElement(By.id("customernav"));
		Assert.assertEquals(WelcomeMessageArea.getText().contains(randomFirstNames),true);
	}
	@Test(priority=4)
	public void addRandomeItem() {  
		driver.navigate().to("https://automationteststore.com/");
		int totalItem =		driver.findElements(By.className("prdocutname")).size();
        int randommItem= rand.nextInt(totalItem);
		driver.findElements(By.className("prdocutname")).get(randommItem).click();
		 
		if (driver.getCurrentUrl().contains("product_id=116")) {

		    driver.findElement(By.id("option344747")).click();

		}

		driver.findElement(By.className("productpagecart")).click();
	}
	
	
		@Test(priority=5)
		public void checkoutProcess() {
			
			WebElement CheckoutButton =driver.findElement(By.id("cart_checkout1"));
			CheckoutButton.click();
			
			WebElement ConfirmOrderButton = driver.findElement(By.id("checkout_btn"));
			ConfirmOrderButton.click();
			//assert
            String ActuallValue= driver.findElement(By.className("heading1")).getText();
			String ExpectedValue = "YOUR ORDER HAS BEEN PROCESSED!";
				
             Assert.assertEquals(ActuallValue, ExpectedValue);
			
		}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
