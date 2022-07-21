package com.procrm.step_definitions;

import com.procrm.pages.TasksPage_Scrum889;
import com.procrm.utilities.BrowserUtilities;
import com.procrm.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Map;

public class TasksSCRUM889 {
    TasksPage_Scrum889 tasksPage_scrum889=new TasksPage_Scrum889();
    Calendar calendar=Calendar.getInstance();
    String expectedTitle="";
    @When("Fills {string} details")
    public void fills_details(String string,DataTable dataTable){
        Map<String,String> map=dataTable.asMap(String.class,String.class);

        BrowserUtilities.sleep(2);
        Driver.getDriver().switchTo().frame(tasksPage_scrum889.iframeNewTask);
        BrowserUtilities.sleep(2);
        tasksPage_scrum889.highPriority.click();
        tasksPage_scrum889.taskTitle.sendKeys(map.get("title"));
        expectedTitle=map.get("title");
        Driver.getDriver().switchTo().parentFrame();

        /*BrowserUtilities.sleep(1);
        Driver.getDriver().switchTo().frame(tasksPage_scrum889.iframeBody);
        tasksPage_scrum889.body.sendKeys("This event will be start "); */

        int hour=LocalTime.now().getHour();
        int minute=LocalTime.now().getMinute();
        tasksPage_scrum889.deadline.click();

        hour=(hour>=12)? hour-=12:hour;

        BrowserUtilities.sleep(2);
        tasksPage_scrum889.timeHours.clear();
        tasksPage_scrum889.timeHours.sendKeys(""+hour);
        tasksPage_scrum889.timeMinutes.sendKeys(""+minute);

        tasksPage_scrum889.PM.click();
        tasksPage_scrum889.calendar.click();

        tasksPage_scrum889.addMention.click();
        BrowserUtilities.sleep(2);
        tasksPage_scrum889.addMentionPerson.click();

        }



    @Then("User should be able to display new task created on My Tasks Page")
    public void User_should_be_able_to_display_new_task_created_on_my_tasks_page() {
        Assert.assertEquals(tasksPage_scrum889.newTask.getText(),expectedTitle);

    }

    @When("User clicks time tracking and send {int} Hours {int} Minutes")
    public void user_clicks_time_tracking_and_send_hours_minutes(Integer hours, Integer minutes) {
        BrowserUtilities.sleep(2);
        tasksPage_scrum889.moreButton.click();
        tasksPage_scrum889.timeTracking.click();
        tasksPage_scrum889.timeTrackingHours.sendKeys(""+hours);
        tasksPage_scrum889.timeTrackingMinutes.sendKeys(""+minutes);

    }

    @When("User add dependant tasks")
    public void user_add_dependant_tasks() {
        BrowserUtilities.sleep(2);
       // tasksPage_scrum889.dependantTasks.click();
       // tasksPage_scrum889.addDependentTask.click();;

    }
    @When("edit {string} details")
    public void edit_details(String string,DataTable dataTable) {
        Map<String,String> map=dataTable.asMap(String.class,String.class);
        tasksPage_scrum889.observers.click();
        BrowserUtilities.sleep(3);

    }
    @Then("HR user should be able to see {string} which is edited on My Tasks Page")
    public void hr_user_should_be_able_to_see_which_is_edited_on_my_tasks_page(String editedTaskName) {
        Assert.assertTrue(tasksPage_scrum889.newTask.getText().toLowerCase().contains("test"));
    }


}
