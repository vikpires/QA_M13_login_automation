import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }
   
    // Criando formulário de login
    @Test
    public void testLogin() {
        loginForm("tomsmith", "SuperSecretPassword!");
        clickLoginButton();
        checkLogin();
    }

    // Preencher o campo "Username" e "Password"
    private void loginForm(String username, String password) {
        WebElement userField = driver.findElement(By.id("username"));
        userField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    // Clicar no botão "Login"
    private void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\'login\']/button"));
        loginButton.click();
    }

    // Checar se o texto “You logged into a secure area!” é visível na tela
    private void checkLogin() {
        if (driver.getPageSource().contains("You logged into a secure area!")) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Falha no login!");
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
