package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopNavbar extends SuiteCRMTestContext {
    String userButtonid = "usermenucollapsed";
    String profileMenuSelector = "ul[role='menu', aria-labelledby='dropdownMenu2']";

    @Step(name = "Click profile button", description = "Click profile button")
    public void clickProfileButton() {
        WebElement we = driver.findElement(By.id(userButtonid));
        we.click();
        System.out.println();
    }

    @Step(name = "Click profile link", description = "Click profile link")
    public void clickProfileLink() {
        WebElement profileMenu = driver.findElement(By.cssSelector(profileMenuSelector));
        WebElement we = profileMenu.findElement(By.tagName("li"));
        System.out.println();
    }
}
