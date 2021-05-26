package com.alasdoo.developercourseassignment.pages;

import com.alasdoo.developercourseassignment.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class TableContainerPage extends PageObject {

    @FindBy(css = "button.MuiButtonBase-root.MuiFab-root")
    private WebElement editButton;

    @FindBy(css = "div.MuiDataGrid-mainGridContainer")
    private WebElement grid;

    @FindBy(css ="div.MuiDataGrid-colCellTitle")
    private List<WebElement> gridTitles;

    @FindBy(css = "p.MuiTablePagination-caption")
    private WebElement paginationInfo;

    @FindBy(css = "span.MuiIconButton-label")
    private List<WebElement> paginationActions;

    public TableContainerPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEditButton(){
        return editButton;
    }

    public WebElement getGrid(){
        return grid;
    }

    public WebElement getPaginationInfo(){
        return paginationInfo;
    }

    public List<WebElement> getPaginationActions(){
        return paginationActions;
    }

    public List<String> getGridTitles(){
        return gridTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
