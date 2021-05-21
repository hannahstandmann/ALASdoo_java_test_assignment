package com.alasdoo.developercourseassignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends PageObject{
    @FindBy(tagName = "h6")
    private WebElement title;
    @FindBy(css ="#MuiList-root.a")
    private List<WebElement> menu;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String pageTitle(){
        return title.getText();
    }

    public List<String> pageManu(){
        return menu.stream()
                .map(menuItem -> menuItem.getText())
                .collect(Collectors.toList());
    }
}
