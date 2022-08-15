import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationTest {
    private WebDriver driver;
    private final String BASE_URL = "https://courses.ultimateqa.com/users/sign_up";

    private String validName = "John";
    private String validLastName = "Wick";
    private String validPassword = "1234567890";
    private String validEmail = "wick@killer.sk";

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);

    }

    @Test
    public void registrationCorrectInput() {

        driver.findElement(By.id("user[first_name]")).sendKeys(validName);
        driver.findElement(By.id("user[last_name]")).sendKeys(validLastName);
        driver.findElement(By.id("user[password]")).sendKeys(validPassword);
        driver.findElement(By.name("user[email]")).sendKeys(validEmail);

        driver.findElement(By.xpath("//input[@id='user[terms]']")).click();
        driver.findElement(By.xpath("//input [@value='Sign up']")).click();

        String alredyTaken = driver.findElement(By.xpath("//div/ul/li[@role='alert']")).getText();
        Assert.assertEquals("Email has already been taken", alredyTaken);

    }

    @After
    public void tearDowmn() {
        driver.quit();


    }
}
