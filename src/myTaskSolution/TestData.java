package myTaskSolution;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {

	String MyWebsite = "https://automationteststore.com/";

	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	String passwordAndConfirm = "AsD1234hgv@";
	String logoutLink="https://automationteststore.com/index.php?rt=account/logout";

	String[] femaleNames = { "Amina", "Fatima", "Noor", "Layla", "Mariam", "Hana", "Yasmin", "Salma", "Zahra",
	"Rania" };

    String[] maleNames = { "Ahmad", "AbdAlrhamn", "Khaled", "Yousef",};

	int randomindex = rand.nextInt(femaleNames.length);
	int randomindex2 = rand.nextInt(maleNames.length);

	String randomFirstNames = femaleNames[randomindex];
	String randomlastNames = maleNames[randomindex2];

	int randomEmailNumber = rand.nextInt(5478);
	int randomEmailNumber2 = rand.nextInt(978);
	String theEmail = randomFirstNames + randomlastNames + randomEmailNumber + randomEmailNumber2 + "@gmail.com";
	int randomCountryIndex = rand.nextInt(1, 20);

	String ExpectedLogoutMessage="You have been logged off your accoun";
	boolean ExpectedLogoutValue=true;
	String LoginName= randomFirstNames + randomlastNames + randomEmailNumber + randomEmailNumber2;

public void SetUpMyTest() {
	driver.get(MyWebsite);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));// ejbari aktbo

	
}
	
	
	
	
	
	
	
	
	
}
