package com.vladimirkomlev.qualitylabchallenge.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class BasePage {
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected WebDriverWait wait;

    protected WebElement waitForElementPresent(String locator, String errorMessage) {
        By by = this.getLocatorByString(locator);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private By getLocatorByString(String locatorWithType) {
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        switch (byType) {
            case "xpath":
                return xpath(locator);
            case "id":
                return id(locator);
            case "css":
                return cssSelector(locator);
            default:
                throw new IllegalArgumentException("Could not get type of locator. Locator: " + locator);
        }
    }

    protected WebElement waitForElementAndClick(String locator, String errorMessage) {
        WebElement element = waitForElementPresent(locator, errorMessage);
        element.click();
        return element;
    }


    protected WebElement waitElementAndSendKeys(String locator, String value, String errorMessage) {
        WebElement element = waitForElementPresent(locator, errorMessage);
        element.sendKeys(value);
        return element;
    }
}
