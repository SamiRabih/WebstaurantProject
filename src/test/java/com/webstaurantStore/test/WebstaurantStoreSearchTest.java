package com.webstaurantStore.test;

import com.webstaurantStore.pages.HomePage;
import com.webstaurantStore.utilities.ConfigurationReader;
import com.webstaurantStore.utilities.Driver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.NoSuchElementException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WebstaurantStoreSearchTest {
    HomePage homePage = new HomePage();
    SoftAssertions softAssertions = new SoftAssertions();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeAll
    public static void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @AfterAll
    public static void destroy() {
        Driver.getDriver().close();
    }

    @DisplayName("searching stainless work table and Validate each product has the word Table in title")
    @Test
    @Order(1)
    public void Test1() {

        homePage.searchBox.sendKeys("stainless work table" + Keys.ENTER);

        try {

            for (int i = 0; i <= homePage.pageLists.size(); i++) {

                for (WebElement eachItem : homePage.itemsList) {

                    String linkText = eachItem.getText();

                    softAssertions.assertThat(linkText.contains("Table"));

                    if (!linkText.contains("Table")) {
                        System.out.println("Element does not contain \"Table\" = " + linkText);
                    }
                }
                actions.moveToElement(homePage.rightArrow).click().perform();
            }

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    @DisplayName("adding last element to cart and empty cart")
    @Test
    @Order(2)
    public void test2() {
        List<WebElement> lastPageList = Driver.getDriver().findElements(By.xpath("//span[@data-testid ='itemDescription']"));
        WebElement lastItemOnLIST = lastPageList.get(lastPageList.size() - 1);
        lastItemOnLIST.click();

        homePage.addToCartButton.click();
        homePage.viewCartElement.click();
        homePage.emptyCartElement1.click();
        homePage.emptyCartElement2.click();
        String actualEmptyCartMessage = homePage.cartEmptyMessage.getText();
        Assertions.assertEquals("Your cart is empty.", actualEmptyCartMessage, "Empty cart message verification failed");

    }

}
