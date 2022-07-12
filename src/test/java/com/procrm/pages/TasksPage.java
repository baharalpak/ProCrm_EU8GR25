package com.procrm.pages;

import com.procrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TasksPage{

    public TasksPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Tasks']")
    public WebElement tasksModuleButton;

    @FindBy(xpath = "//span[.='All']")
    public WebElement allTabButton;

    @FindBy(xpath = "(//input[@class='main-grid-checkbox main-grid-row-checkbox main-grid-check-all'])[1]")
    public WebElement allTasks;

    @FindBy(xpath = "//div[@class='main-ui-square-item'][1]")
    public WebElement inProgressBox;

    //@FindBy(xpath = "//span[.='Tasks:']")
    //public WebElement tasks;

    @FindBy(xpath = "//span[.='There are no tasks requiring immediate attention']")
    public WebElement noTask;

    @FindBy(xpath = "//span[.='Ongoing']")
    public WebElement ongoingButton;

    @FindBy(xpath = "(//div[@class='main-ui-square-item'])[2]")
    public WebElement ongoingBox;

    @FindBy(id = "tasks-buttonAdd")
    public WebElement newTaskButton;

    @FindBy(xpath = "//button[@class='ui-btn ui-btn-success']")
    public WebElement addTaskButton;

    @FindBy(xpath = "//a[@class='task-view-button edit ui-btn ui-btn-link']")
    public WebElement editTaskButton;

    @FindBy(xpath = "//button[@class='ui-btn ui-btn-success']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//span[@title='Close']")
    public WebElement closeButton;

    @FindBy(xpath = "//iframe[@class='side-panel-iframe']")
    public WebElement iframeNewTask;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    public WebElement taskNameField;

    @FindBy(xpath = "//table[@id='TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_table']//tr//td[3]")
    public List<WebElement> tasksNames;

    @FindBy(xpath = "(((//tr[@class='main-grid-row main-grid-row-body'])//td)[3]/span/a)")
    public WebElement newTask;

    @FindBy(xpath = "(//span[.='Test'])[1]")
    public WebElement newCreatedTaskMarketing;


}
