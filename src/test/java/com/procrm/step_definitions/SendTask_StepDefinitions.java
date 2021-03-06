package com.procrm.step_definitions;

import com.procrm.pages.BasePage;
import com.procrm.pages.sendTaskPage;
import com.procrm.utilities.BrowserUtilities;
import com.procrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SendTask_StepDefinitions {

    sendTaskPage sendTaskPage = new sendTaskPage();

    @When("User clicks on Tasks module.")
    public void user_clicks_on_tasks_module() {

        sendTaskPage.tasksModuleButton.click();
    }

    @Given("{string} user is on Home Page.")
    public void userIsOnHomePage(String userType) {

        switch (userType.toLowerCase()) {
            case "hr":
                BasePage.loginAsHR();
                break;
            case "helpdesk":
                BasePage.loginAsHelpDesk();
                break;
            case "marketing":
                BasePage.loginAsMarketing();
                break;
        }
    }

    @Then("User should be able to display All Tasks.")
    public void user_should_be_able_to_display() {

        Assert.assertTrue(sendTaskPage.inProgressBox.isDisplayed());
    }

    @Then("User should be able to see Ongoing Tasks.")
    public void userShouldBeAbleToSeeOngoingTasks() {

        Assert.assertTrue(sendTaskPage.ongoingBox.isDisplayed());
    }

    @And("User clicks {string} button.")
    public void clicksButton(String buttonType) {

        switch (buttonType.toLowerCase()){
            case "all":
                sendTaskPage.allTabButton.click();
                break;
            case "ongoing":
                sendTaskPage.ongoingButton.click();
                break;
            case "new task":
                sendTaskPage.newTaskButton.click();
                break;
            case "add task":
                sendTaskPage.addTaskButton.click();
                Driver.getDriver().switchTo().parentFrame();
                break;
            case "edit":

                BrowserUtilities.sleep(2);
                Driver.getDriver().switchTo().frame(sendTaskPage.iframeNewTask);

                BrowserUtilities.sleep(4);
                sendTaskPage.editTaskButton.click();
                break;
            case "save changes":
                sendTaskPage.saveChangesButton.click();
                Driver.getDriver().switchTo().parentFrame();
                break;
            case "close":
                sendTaskPage.closeButton.click();
                break;
        }
        BrowserUtilities.sleep(3);
    }

    @And("User fills in Task Name which is mandatory field with {string}.")
    public void userFillsInTaskNameWhichIsMandatoryFieldWith(String text) {

        Driver.getDriver().switchTo().frame(sendTaskPage.iframeNewTask);

        sendTaskPage.taskNameField.sendKeys(text);
    }

    @Then("{string} user should be able to display new task created on My Tasks Page.")
    public void userShouldBeAbleToDisplayNewTaskCreatedOnMyTasksPage(String userType) {

        if (userType.toLowerCase().equals("hr")){

            BrowserUtilities.sleep(3);

            Assert.assertEquals("Task has been created", sendTaskPage.popupNewTask.getText());

        }
    }

    @Then("{string} user CAN NOT BE ABLE TO display new task created.")
    public void userCANNOTBEABLETODisplayNewTaskCreated(String userType) {

        if (userType.equalsIgnoreCase("marketing") || userType.equalsIgnoreCase("helpdesk")){
            Assert.assertFalse(sendTaskPage.popupNewTask.isDisplayed());
        }
    }

    @And("{string} user clicks on the last created task.")
    public void userClicksOnTheLastCreatedTask(String userType) {

        if (userType.equalsIgnoreCase("hr")){

            sendTaskPage.newTask.click();
        }
    }


    @And("{string} user edits the Task Name as {string} and clicks Save Changes button.")
    public void userEditsTheTaskNameAsAndClicksSaveChangesButton(String userType, String newTaskName) {

        if (userType.equalsIgnoreCase("hr")){

            BrowserUtilities.sleep(3);
            sendTaskPage.taskNameField.click();
            sendTaskPage.taskNameField.clear();
            sendTaskPage.taskNameField.sendKeys(newTaskName);
            sendTaskPage.saveChangesButton.click();
            BrowserUtilities.sleep(2);

            Driver.getDriver().switchTo().parentFrame();
            sendTaskPage.closeButton.click();
        }
    }

    @Then("HR user should be able to see {string} which is edited on My Tasks Page.")
    public void hrUserShouldBeAbleToSeeWhichIsEditedOnMyTasksPage(String editedTaskName) {

        Assert.assertEquals(sendTaskPage.newTask.getText(), editedTaskName);
    }


    @Then("{string} user CAN NOT BE ABLE TO edit task.")
    public void userCANNOTBEABLETOEditTask(String userType) {

        if (userType.equalsIgnoreCase("helpdesk") || userType.equalsIgnoreCase("marketing")){

            Assert.assertTrue(sendTaskPage.editTaskButton.isEnabled());
        }
    }
}
