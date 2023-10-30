import layout.LayoutWebElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.emulation.Emulation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Optional;

@Slf4j
public class GoogleTest {
    private static final int WAIT_FOR_ELEMENT_TIMEOUT = 30;
    private static WebDriver driver;
    private static WebDriverWait webDriverWait;
    private static Actions actions;
    public static void main(String[] args) throws MalformedURLException {


        driver = new ChromeDriver();
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
        actions = new Actions(driver);
        driver.manage().window().maximize();


        driver.navigate().to("https://www.google.com");
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setDeviceMetricsOverride(375,
                667,
                50,
                false,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        var gmail = new LayoutWebElement(driver.findElement(By.linkText("Gmail")));
        var Images = new LayoutWebElement(driver.findElement(By.linkText("Images")));
        var Google_img= new LayoutWebElement( driver.findElement(By.xpath("//img[@alt='Google']")));
        var Search_textfeld= new LayoutWebElement( driver.findElement(By.name("q")));
        var google_search = new LayoutWebElement(driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")));
        var  feeling_lucky= new  LayoutWebElement(driver.findElement(By.xpath("(//input[@class='RNmpXc'])[2]")));

        gmail.height().lessThan(34).validate();
        gmail.width().equal(24).validate();
        gmail.right(Images).validate();

        gmail.assertColor("rgba(0, 0, 0, 0.87)");
        gmail.assertFontSize("13px");
        gmail.assertFontFamily("arial, sans-serif");
        gmail.assertFontWeight("400");
        gmail.assertVerticalAlign("middle");
        gmail.right(Images).equal(15).validate();;


    }
}
