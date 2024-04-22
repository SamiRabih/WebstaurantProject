package com.webstaurantStore.pages;

import com.webstaurantStore.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class HomePage {
    public HomePage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "searchval")
    public WebElement searchBox;
    @FindBy(xpath = "//div//span[@data-testid ='itemDescription']")
    public List<WebElement> itemsList;
    @FindBy(xpath = "//li[@class='inline-block leading-4 align-top']")
    public List<WebElement> pageLists;
    @FindBy(xpath = "//a[.='View Cart']")
    public WebElement viewCartElement;
    @FindBy(xpath = "//button[.='Empty Cart'][1]")
    public WebElement emptyCartElement1;
    @FindBy(xpath = "//footer[@data-testid='modal-footer']/button[1]")
    public WebElement emptyCartElement2;
    @FindBy(css = ".header-1")
    public WebElement cartEmptyMessage;
    @FindBy(xpath = "//li[@class='inline-block leading-4 align-top rounded-r-md']/a[contains(@aria-label,'go to page')]")
    public WebElement rightArrow;
    @FindBy(xpath = "//a[contains(@aria-label,'last page, page')]")
    public WebElement lastPages;
    @FindBy(xpath = "//input[@gtm-id='AddToCartATC']")
    public WebElement addToCartButton;
    //
    //test
}
