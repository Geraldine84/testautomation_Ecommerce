package TestCases.Regression;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage_PageObjects;
import PageObjects.Login_PageObjects;

public class ECommerceTests {
	    private WebDriver driver;
	    private WebDriverWait wait;
	    	
		/**
		*  Constants for URLs:
		* Purpose: Using a constant (BASE_URL) for the base URL makes it easier to manage if the base URL changes.
		* Benefit: This ensures consistency and simplifies changes.
		* 
		*/   	
	    private static final String BASE_URL = "https://www.example-ecommerce-site.com";
	    
	    public ECommerceTests(WebDriver driver, WebDriverWait wait) {
	        this.driver = driver;
	        this.wait = wait;
	    }

	    @BeforeClass
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get(BASE_URL);
	    }

	    @Test
	    public void testLogin() {
	    	Login_PageObjects loginPage = new Login_PageObjects(driver, wait);
	        loginPage.login("user", "pass");
	        WebElement accountPage = loginPage.getAccountPage();
	        
	        /**
	    	* Assertions:
	    	* Purpose: Assertions are tied to the actions in the test, enhancing readability and understanding of test expectations.
	    	* Benefit: Makes the tests self-explanatory.
	    	*/
	        assert accountPage.isDisplayed();
	    }

	    @Test
	    public void testAddToCart() {
	    	HomePage_PageObjects homePage = new HomePage_PageObjects(driver, wait);
	        homePage.addToCart("Product");
	        WebElement cartItem = homePage.getCartItem();
	        
	        /**
	    	* Assertions:
	    	* Purpose: Assertions are tied to the actions in the test, enhancing readability and understanding of test expectations.
	    	* Benefit: Makes the tests self-explanatory.
	    	*/
	        assert cartItem.isDisplayed();
	    }

	    
	    /**
		* WebDriver Cleanup:
		* Purpose: The tearDown() method checks if driver is not null before calling quit(), which adds a safety check.
		* Benefit: Prevents potential NullPointerException if the driver setup fails.
		*/ 
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
}