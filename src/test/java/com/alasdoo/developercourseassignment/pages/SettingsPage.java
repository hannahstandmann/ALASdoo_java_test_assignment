package com.alasdoo.developercourseassignment.pages;

import com.alasdoo.developercourseassignment.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends PageObject {
    @FindBy(linkText = "Settings")
    private WebElement settingsMenu;

    @FindBy(css = "button.MuiButton-root")
    private WebElement startButton;

    @FindBy(css = "p.MuiTypography-root")
    private WebElement explanation;

    @FindBy(css = "span.MuiTypography-caption")
    private WebElement result;

   // private String explanationText = "Inject demo content in the backend. Run this command only once!";

   // private String resultText = "Injected: Students(20), Teachers(20), Courses(20)";

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSettingsMenu(){
        return settingsMenu;
    }

    public WebElement getStartButton(){
        return startButton;
    }

    public WebElement getExplanation(){
        return explanation;
    }

  /*  public String getExplanationText(){
        return explanationText;
    }*/

    public WebElement getResult(){
        return result;
    }

   /* public String getResultText(){
        return resultText;
    }*/
}
