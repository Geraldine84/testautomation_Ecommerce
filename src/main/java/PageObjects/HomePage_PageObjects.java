package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object Model (POM) Implementation: Purpose: To separate the
 * page-specific operations into dedicated classes (LoginPage and HomePage),
 * which improves code reusability and maintainability. Benefit: If the UI
 * changes (e.g., element locators), you only need to update it in one place
 * rather than across all test cases.
 * 
 */

// HomePage class implementing Page Object Model for home page and cart functionality
public class HomePage_PageObjects {
	/**
	* Use of WebDriverWait:
	* Purpose: By encapsulating WebDriverWait within each page class, we ensure that the waiting logic is closely tied to the elements it interacts with.
	* Benefit: This makes the code cleaner and more robust against timing issues.
	*/
	private WebDriver driver;
	private WebDriverWait wait;

	
	/**
   	* DRY Principle:
   	* Purpose: The original code had repetitive elements (e.g., WebDriver setup, element locators). By implementing POM, we avoid repetition and encapsulate functionality.
   	* Benefit: This makes the code easier to maintain and reduces the likelihood of bugs.
   	*/
	private By cartIcon = By.id("cartIcon");
	private By cartItem = By.xpath("//div[@class='cart-item']");

	public HomePage_PageObjects(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void addToCart(String productName) {
		By productLink = By.xpath("//a[text()='" + productName + "']");
		driver.findElement(productLink).click();
		By addToCartButton = By.id("addToCart");
		driver.findElement(addToCartButton).click();
		driver.findElement(cartIcon).click();
	}

	public WebElement getCartItem() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
	}
}