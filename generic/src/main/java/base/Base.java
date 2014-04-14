package base;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gufran on 4/11/14.
 */
public class Base {

    private static final String Timeouts = null;
    public WebDriver wd = null;

    @BeforeClass
    public void setUp() throws Exception {
        //System.setProperty("WebDriver.chrome.driver", "C:/Users/Gufran/Desktop/Documents/PeoplenTech Documents/Class Notes(03-29-14) on Selenium-JAVA/chromedriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.navigate().to("http://www.cnn.com");
        wd.manage().window().maximize();

    }
    @AfterClass
    public void sleep(int seconds) throws InterruptedException{
        Thread.sleep(seconds * 1000);
    }

    public void navigateBack(){
        wd.navigate().back();
    }
    public void ClickOnId(String locator) {
        wd.findElement(By.id(locator)).click();

    }

    public void ClickByCss(String locator){
        wd.findElement(By.cssSelector(locator)).click();
    }

    public void typeByCss(String locator, String value){
        wd.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public WebElement getWebElementByCss(String locator){
        WebElement element =wd.findElement(By.cssSelector(locator));
        return element;
    }

    public List<WebElement> getWebElementsByCss(String locator1, String locator2){
        List<WebElement> elementList = wd.findElement(By.cssSelector(locator1)).findElements(By.cssSelector(locator2));
        return elementList;
    }


    public String getElementText(String locator){
        String st = getWebElementByCss(locator).getText();
        return st;
    }

    public List<String> getListOfString(String locator1, String locator2){
        List<WebElement> elementList = getWebElementsByCss(locator1,locator2);
        List<String> list = new ArrayList<String>();
        for(WebElement element: elementList){
            list.add(element.getText());

        }
        return list;
    }


}




