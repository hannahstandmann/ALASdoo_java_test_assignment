package com.alasdoo.developercourseassignment.pagetests;

import com.alasdoo.developercourseassignment.FunctionalTest;
import com.alasdoo.developercourseassignment.pages.StudentPage;
import com.alasdoo.developercourseassignment.pages.TableContainerPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentsTest extends FunctionalTest {

    @Value( "${student-page.grid-titles}" )
    private String[] gridTitles;

    @Value( "${student-page.title}" )
    private String pageTitle;

    private StudentPage entrance;
    @BeforeEach
    public void initializePage(){
        driver.get("http://localhost:3000");
        entrance = new StudentPage(driver);
    }
    @Test
    public void gridPageInitialized(){
        assertEquals(pageTitle, entrance.pageTitle());
        assertTrue(entrance.getGrid().isDisplayed());
        assertIterableEquals(Arrays.asList(gridTitles), entrance.getGridTitles());
        assertTrue(entrance.getEditButton().isDisplayed());
        assertTrue(entrance.getPaginationActions().get(0).isDisplayed());
        assertTrue(entrance.getPaginationActions().get(1).isDisplayed());
        assertTrue(entrance.getPaginationInfo().getText().contains("of"));
    }
}
