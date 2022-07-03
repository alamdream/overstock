package page_objects;

import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Notification extends NavigationBar{
    public static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);
    private static final By NotificationsTitle = By.xpath("//span[@class='notificationCenter_headerTitle_39']");

    public Notification(WebDriver driver) {
        super(driver);
    }

    public Notification validateUserOnNotificationPage(){
        AssertThat.elementAssertions(driver, NotificationsTitle).elementIsDisplayed();
        return this;
    }
}
