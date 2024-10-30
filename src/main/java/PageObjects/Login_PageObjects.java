package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

/**
 * Page Object Model (POM) Implementation:
 * Purpose: To separate the page-specific operations into dedicated classes (LoginPage and HomePage), 
 * which improves code reusability and maintainability.
 * Benefit: If the UI changes (e.g., element locators), you only need to update it in one place rather than across all test cases.
 * 
 */

//LoginPage class implementing Page Object Model for the login functionality
public class Login_PageObjects {

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
    private By loginButton = By.id("loginButton");
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submitButton");
    private By accountPage = By.id("accountPage");

    
    public Login_PageObjects(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void login(String username, String password) {
        driver.findElement(loginButton).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public WebElement getAccountPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage));
    }

}
