package Step;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Steps {

    WebDriver driver;

    @BeforeAll
    public void main_setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Андрей\\OneDrive\\Рабочий стол\\projects java\\testselenium\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp()  throws Throwable{
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.epam.com");
    }


//1
    @When("^I move to \"About\"$")
    public void move_to_the_button_About() throws Throwable
    {
        Actions action1 = new Actions(driver);
        WebElement element1=driver.findElement(By.xpath("//li[@class='top-navigation__item epam']//a[text()=\"About\"]"));
        action1.moveToElement(element1).build().perform();
    }

    @When("^I click on \"Partners\"$")
    public void go_to_the_page_Partners() throws Throwable
    {
        driver.findElement(By.xpath("//li[@class='top-navigation__sub-item']//a[text()=\"Partners\"]")).click();
    }

    @Then("^I see a partners of EPAM$")
    public void	go_to_the_partners_page() throws Throwable
    {
        Assert.assertEquals("https://www.epam.com/about/who-we-are/partners",driver.getCurrentUrl());
    }
    //2
    @When("^I press the search button$")
    public void press_on_search_button() throws Throwable
    {
        driver.findElement(By.xpath("//button[@class='header-search__button header__icon']")).click();
    }

    @When("^I type a \"automation\"$")
    public void search_the_automation() throws Throwable
    {
        driver.findElement(By.name("q")).sendKeys("automation");
        driver.findElement(By.xpath("//button[@class=\"header-search__submit\"]")).click();
    }

    @Then("^I see a list of dishes that have the word \"automation\"$")
    public void	found_automation() throws Throwable
    {
        String result_of_search = driver.findElement(By.xpath("//h2[@class=\"search-results__counter\"]")).getText();
       Assert.assertTrue(result_of_search.contains("results for \"automation\"") || result_of_search.contains("result for \"automation\""));
    }
    //3
    @Given("^I have changed the language of the site to Russian$")
    public void change_language_to_russian() throws Throwable
    {
        driver.findElement(By.xpath("//button[@class=\"location-selector__button\"]")).click();
        driver.findElement(By.xpath("//a[@class=\"location-selector__link\"  and text()=\"Россия \"]")).click();
    }

    @When("^I'm looking for \"Решения и проекты\"$")
    public void go_to_the_Our_work() throws Throwable
    {
        Actions action = new Actions(driver);
        WebElement element=driver.findElement(By.xpath("//a[@class=\"top-navigation__item-link\" and text()=\"Решения и проекты\"]"));
        action.moveToElement(element).build().perform();
    }

    @Then("^I see a list of articles that have the sentense \"Решения и проекты\"$")
    public void	found_list_of_Our_work() throws Throwable
    {
        List<WebElement> list_of_resheniya_i_proecty = driver.findElements(By.xpath("//a[@class=\"top-navigation__item-link\"  and text()=\"Решения и проекты\"]/ancestor::li//li/a"));
        List<String> titles = new ArrayList<String>();
        titles.addAll(Arrays.asList("Банки и финансы","Высокие технологии","Путешествия и гостеприимство","Страхование","Энергетика","Производство","Торговля и дистрибуция","Телекоммуникации и медиа","Медицина и биотехнологии"));
        for (WebElement e: list_of_resheniya_i_proecty) {
            Assert.assertTrue(titles.contains(e.getText()));
        }


    }
    //4
    @Given("^I have changed the language of the site to English$")
    public void change_language_to_english() throws Throwable
    {
        driver.findElement(By.xpath("//button[@class=\"location-selector__button\"]")).click();
        driver.findElement(By.xpath("//a[@class=\"location-selector__link\"  and text()=\"Global \"]")).click();
    }

    @When("^I click on Careers$")
    public void click_on_the_Careers() throws Throwable
    {
        driver.findElement(By.xpath("//a[@class=\"top-navigation__item-link\"  and text()=\"Careers\"]")).click();
    }

    @Then("^I should see article \"Work with us\"$")
    public void	see_article_Work_with_us() throws Throwable
    {
        Assert.assertEquals("Work with Us",driver.getTitle());
    }
    //5
    @Given("^that I'm on the  \"How we do it\"page$")
    public void click_on_the_How_we_do_it() throws Throwable{
        driver.findElement(By.xpath("//a[@class=\"top-navigation__item-link\"  and text()=\"How We Do It\"]")).click();
    }

    @When("^I click on the words \"our own IP\"$")
    public void click_on_our_own_IP_link() throws Throwable
    {
        driver.findElement(By.xpath("//a[text()=\"our own IP\"]")).click();
    }

    @Then("^I go to the SolutionHub page$")
    public void	open_solutionhub() throws Throwable
    {
        Assert.assertEquals("https://solutionshub.epam.com/",driver.getCurrentUrl());
    }
    //6
    @Given("^that I am on the page \"Our work\"$")
    public void click_on_Ourwork() throws Throwable
    {
        driver.findElement(By.xpath("//a[@class=\"top-navigation__item-link\"  and text()=\"Our Work\"]")).click();
    }

    @When("^I click on \"Healthcare\"$")
    public void click_on_healthcare() throws Throwable
    {
        driver.findElement(By.xpath("//li[@class=\"in-page-navigation__item\"]/a[contains(text(),\"Healthcare\")]")).click();
    }

    @When("^I click on \"Learn more\" for UnitedHealthcare$")
    public void click_on_UnitedHealthcare_learn_more() throws Throwable
    {
        Actions action = new Actions(driver);
        WebElement element=driver.findElement(By.xpath("//div[@class=\"rollover-blocks__content\"][1]"));
        action.moveToElement(element).click().build().perform();
        driver.findElement(By.xpath("//li[@class=\"rollover-blocks__block bg-color-white\"]//a[1]")).click();
    }

    @Then("^I go to the solution page for this client$")
    public void	open_solution_customer() throws Throwable
    {
        Assert.assertEquals("https://www.epam.com/our-work/case-studies/unitedhealthcare-advocate4me",driver.getCurrentUrl());
    }
    // 7
    @When("When I click \"About\"")
    public void click_about_link(String string) throws Throwable {
        driver.findElement(By.xpath("//a[@class=\"top-navigation__item-link\"  and text()=\"About\"]")).click();
    }


    @When("I click \"Instagram\" logo")
    public void click_no_istagram_logo() throws Throwable {
        driver.findElement(By.xpath("//a[@data-type=\"instagram-filled\"]")).click();
    }

    @Then("I go to the  instagram page")
    public void check_instagram_url(String string) throws Throwable {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.instagram.com/epamsystems/");
    }
    //8

    @Given("^I am on the Services page$")																			//1
    public void click_services_link() throws Throwable {
        driver.findElement(By.xpath("//a[@class=\"top-navigation__item-link\"  and text()=\"Services\"]")).click();
    }

    @When("I click on \"Epam\"")
    public void click_on_EPAM() throws Throwable{
        driver.findElement(By.xpath("//a[@class=\"header__logo-container\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wrapper")));
    }

    @Then("I go to the main page")
    public void check_going_to_the_main_page() throws Throwable{
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.epam.com/");
        driver.quit();
    }


    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @AfterAll
    public void main_tearDown() {
        driver.quit();
    }
}