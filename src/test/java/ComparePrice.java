import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComparePrice {
	public static void main(String args[]) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vio\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().fullscreen();
		WebElement searchText = driver.findElement(By.id("twotabsearchtextbox"));
		searchText.sendKeys("iPhone XR (64GB) - Yellow.");
		searchText.sendKeys(Keys.ENTER);
		String getAmazonPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		String IntgetAmazonPrice = getAmazonPrice.replaceAll(",", "");
		System.out.println(IntgetAmazonPrice);
		int getAmazonActualPrice = Integer.parseInt(IntgetAmazonPrice);
		driver.navigate().to("https://www.flipkart.com/.");
		WebElement crossSign = driver.findElement(By.xpath("//button[contains(.,'✕')]"));
		if(crossSign.isDisplayed()) {
			crossSign.click();
		}
		WebElement searchTextflipcart = driver.findElement(By.name("q"));
		searchTextflipcart.sendKeys("iPhone XR (64GB) - Yellow.");
		searchTextflipcart.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String getFlipkartPrice = driver.findElement(By.xpath("//div[@class='_1vC4OE _2rQ-NK']")).getText();
		String getFlipKartActualPrice = getFlipkartPrice.split("₹")[1];
		String intgetFlipKartActualPrice = getFlipKartActualPrice.replaceAll(",", "");
		System.out.println(intgetFlipKartActualPrice);
		int getFlipKartActualIntPrice = Integer.parseInt(intgetFlipKartActualPrice);
		if(getAmazonActualPrice>=getFlipKartActualIntPrice) {
			System.out.println("The lesser price of Iphone is on Flipkart with price : "+getFlipKartActualIntPrice);
		}
		else {
			System.out.println("The lesser price of Iphone is on Amazon with price :  "+getAmazonActualPrice);
		}
		driver.close();


	}}


