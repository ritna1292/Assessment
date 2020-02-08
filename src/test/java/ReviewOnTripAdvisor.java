import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ReviewOnTripAdvisor {
	static WebDriver driver = null;
	@SuppressWarnings("static-access")
	public static void main(String[] args) {


		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vio\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.tripadvisor.in/");
			//driver.manage().window().fullscreen();
			if(driver.findElement(By.xpath("(//span[contains(.,'Search')])[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//div[@title='Search']")).click();
				WebElement searchText = driver.findElement(By.xpath("//input[@id='mainSearch']"));
				searchText.sendKeys("Club Mahindra");
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);				
				searchText.sendKeys(Keys.DOWN, Keys.RETURN);
				if(driver.findElement(By.xpath("//span[contains(.,'Club Mahindra Madikeri, Coorg')]")).isDisplayed()) {
					driver.findElement(By.xpath("//span[contains(.,'Club Mahindra Madikeri, Coorg')]")).click();
				}
			}
			else {
				driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Club Mahindra");
				driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.DOWN, Keys.RETURN);
			}
			/*WebElement searchIcon = driver.findElement(By.xpath("//div[@title='Search']"));
			searchIcon.click();*/
			/*WebElement searchText = driver.findElement(By.xpath("//input[@id='mainSearch']"));
			searchText.sendKeys("Club Mahindra");
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			searchText.sendKeys(Keys.DOWN, Keys.RETURN);*/
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			String parentwindow = driver.getWindowHandle();
			for(String childwin : driver.getWindowHandles()){
				driver.switchTo().window(childwin);
			}
			WebElement writeReviewTextBtn = driver.findElement(By.xpath("//a[contains(.,'Write a review')]"));
			writeReviewTextBtn.click();
			//TODO
			//setRating("5");
			/*
			 * Actions action = new Actions(driver); WebElement hoverElement =
			 * driver.findElement(By.id("bubble_rating"));
			 * action.moveToElement(hoverElement).moveToElement(driver.findElement(By.id(
			 * "bubble_rating"))).click().build().perform();
			 */
			for(String childwin1 : driver.getWindowHandles()){
				driver.switchTo().window(childwin1);
			}
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement reviewTitle = driver.findElement(By.id("ReviewTitle"));
			reviewTitle.click();
			reviewTitle.sendKeys("Review title");
			WebElement reviewText = driver.findElement(By.id("ReviewText"));
			reviewText.click();
			reviewText.sendKeys("Ambiance is very good and apart from that services are awesome...if you are planning to have a good stay please go ahead ....you are going to enjoyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy............!!!!!!!!!");
			WebElement submitreview = driver.findElement(By.id("noFraud"));
			submitreview.click();
			//driver.findElement(By.id("SUBMIT")).click();



			/*
			 * WebElement selectFirstHotel =
			 * driver.findElement(By.xpath("//span[@class='poi-name primaryText'])[1]"));
			 * selectFirstHotel.click();
			 */
		}catch(Exception e) {
			System.out.println("in catch block");
			driver.close();
		}}

	private static void setRating(String star) {
		//new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@id='qid10']/option[1]"))).perform();
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@class='question rating bigRating labelAndInput required  ']/child::label/following-sibling::div/child::span"))).perform();
		driver.findElement(By.xpath("//*[@id='qid10']/option[6]")).click();

	}}

