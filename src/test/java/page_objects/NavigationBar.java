package page_objects;


import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    public static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);
    public WebDriver driver;
    private final By OverstockLogo = By.xpath("//a[@class='Logo_logoContainer_32']");
    private final By NotificationLink = By.name("Notifications");
    private final By CartLink = By.xpath("//a[@href='/cart']");
    private final By OutdoorLink = By.xpath("//a[text()='Outdoor']");
    private final By SunSailsLink = By.xpath("//a[text()='Sunsails']");
    public NavigationBar(WebDriver driver){
        this.driver = driver;
    }

    // navigate to Home page
    public HomePage navigateToMyHome(){
        ActOn.element(driver, OverstockLogo).click();
        return new HomePage(driver);
    }

    public Notification openNotifications(){
        ActOn.element(driver, NotificationLink).click();
        return new Notification(driver);
    }

    public Cart navigateToCart() throws InterruptedException {
        ActOn.element(driver, CartLink).click();
        Thread.sleep(3000);
        return new Cart(driver);
    }

    public NavigationBar mouseHoverToOutdoor(){
        ActOn.element(driver, OutdoorLink).mouseHover();
        return this;
    }

    public SunSails navigateToSunSails(){
        ActOn.element(driver, SunSailsLink).click();
        return new SunSails(driver);
    }

}
