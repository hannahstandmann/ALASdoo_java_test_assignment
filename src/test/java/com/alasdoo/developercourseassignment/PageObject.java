package com.alasdoo.developercourseassignment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PageObject {
    @FindBy(tagName = "h6")
    private WebElement title;
    @FindBy(css ="a.MuiButtonBase-root")
    private List<WebElement> menu;

    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String pageTitle(){
        return title.getText();
    }

    public List<String> pageManu(){

        return menu.stream()
                .map(menuItem -> menuItem.getText())
                .collect(Collectors.toList());
    }
    public List<WebElement> getMenu(){
        return menu;
    }
}
