package com.alasdoo.developercourseassignment.pagetests;

import com.alasdoo.developercourseassignment.FunctionalTest;
import com.alasdoo.developercourseassignment.pages.SettingsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SettingsTest extends FunctionalTest {
    private SettingsPage entrance;

    @Value( "${menu.items}" )
    private String[] menuItems;

    @Value( "${page.titles}" )
    private String[] pageTitles;

    @Value( "${settings-page.selector}" )
    private String pageSelector;

    @Value( "${settings-page.explanation}" )
    private String explanationText;

    @Value( "${settings-page.expected-result}" )
    private String resultText;

    @BeforeEach
    public void initializePage(){
        driver.get("http://localhost:3000");
        entrance = new SettingsPage(driver);
    }

    @Test
    public void checkInitialTitle() {
        assertEquals("Student", entrance.pageTitle());
        assertIterableEquals(Arrays.asList(menuItems), entrance.pageManu());
    }

    @Test
    public void checkTitleChange(){
        List<String> titles = entrance.getMenu().stream()
                .map( menuItem -> {
                    menuItem.click();
                    return entrance.pageTitle();
                })
                .collect(Collectors.toList());
        assertIterableEquals(Arrays.asList(pageTitles), titles);
    }

    @Test
    public void checkDataInitialized(){
        entrance.getMenu()
                .stream()
                .filter(menuItem -> pageSelector.equals(menuItem.getText()))
                .findFirst()
                .get()
                .click();
        assertTrue(entrance.getStartButton().isDisplayed());
        assertTrue(entrance.getStartButton().isEnabled());
        assertEquals(entrance.getExplanation().getText(), explanationText);
        entrance.getStartButton().click();
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.MuiTypography-caption")));
        assertEquals(entrance.getResult().getText(), resultText);
        assertFalse(entrance.getStartButton().isEnabled());
    }


}
