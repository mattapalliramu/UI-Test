package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeamNames 
{
	
	public static WebDriver driver;
	public static String url = "https://www.bbc.co.uk/sport/football/scores-fixtures";
	public static String data1;
	
	@Given("^user should able to launch the application$")
	public void user_should_able_to_launch_the_application() {
	    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get(url);
	}

	@When("^user is in sport page$")
	public void user_is_in_sport_page() {
		if(driver.findElement(By.linkText("Sport")).isDisplayed())
		{
			System.out.println("User should see Sports Page");
		}  
	}

	@Then("^user able to see today matches$")
	public void user_able_to_see_today_matches() {
		
	 String data = driver.findElement(By.xpath("//*[@id=\"sp-timeline-current-dates\"]/li")).getText(); 
	
	 if(!data.isEmpty())
	 {
		 System.out.println(data);
	 }else
	 {
		 System.out.println("No matches Today");
	 }
	 
	}

	@Then("^user should see all team names$")
	public void user_should_see_all_team_names() {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		data1= driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/div[3]/div/div/span/div")).getText();
		System.out.println(data1);
			   
	}

	@Then("^user should see message if no matches today$")
	public void user_should_see_message_if_no_matches_today() {	
		if(!data1.isEmpty())
		 {
			 System.out.println("Today Matches are their");
		 }else
		 {
			 System.out.println("No matches Today");
		 }
	}
	

	@Then("^user should search for sports news as \"([^\"]*)\"$")
	public void user_should_search_for_sports_news_as(String search) {
	    driver.findElement(By.xpath("//*[@id=\"orb-search-q\"]")).sendKeys(search);
	    
	}
	
	@Then("^user should click enter$")
	public void user_should_click_enter(){
		driver.findElement(By.xpath("//*[@id=\"orb-search-button\"]")).click(); 
	}
	
	@Then("^user should see sports news page$")
	public void user_should_see_sports_news_page() {
		String expurl = driver.getCurrentUrl();
		   if(!url.contains(expurl))
		   {
			   System.out.println("Sports News page is displayed");
		   }
	}
	
	@Then("^user should able to get first and last news headings$")
	public void user_should_able_to_get_first_and_last_news_headings()  {
	   String firstheading =  driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div[3]/div/div/ul/li[1]/div/div/div[1]/div[1]/a")).getText();
	   System.out.println(firstheading);
	   String lastheading =driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div[3]/div/div/ul/li[10]/div/div/div[1]/div[1]/a")).getText();
	   System.out.println(lastheading);
	}

	@Then("^User able to click on Sign in$")
	public void user_able_to_click_on_Sign_in()  {
	   
		driver.findElement(By.id("idcta-link")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("^User should give Email as  \"([^\"]*)\" and password as\"([^\"]*)\"$")
	public void user_should_give_Email_as_and_password_as(String email, String password)  {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"user-identifier-input\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"password-input\"]")).sendKeys(password);    
	}

	@Then("^User should click on Sign in$")
	public void user_should_click_on_Sign_in()  {
	    driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();
	    
	    
	}

	@Then("^user should get error message$")
	public void user_should_get_error_message() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String emailerrmsg = driver.findElement(By.xpath("//*[@id=\"form-message-username\"]/p")).getText();
	    if(!emailerrmsg.isEmpty())
	    {
	    	System.out.println("Invalid Email Id");
	    }
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    String pwderrmsg = driver.findElement(By.xpath("//*[@id=\"form-message-password\"]/p")).getText();
	    if(!pwderrmsg.isEmpty())
	    {
	    	System.out.println("Invalid Password");
	    }
	}
	
	@Then("^user able to close the application$")
	public void user_able_to_close_the_application() throws Throwable {
	
		driver.close();
	}
	

}
