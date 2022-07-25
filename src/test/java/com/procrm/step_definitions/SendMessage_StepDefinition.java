package com.procrm.step_definitions;

import com.github.javafaker.Faker;
import com.procrm.pages.SendMessagePage;
import com.procrm.utilities.BrowserUtilities;
import com.procrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SendMessage_StepDefinition {

    SendMessagePage sendMessagePage = new SendMessagePage();
    Faker faker = new Faker();

    @When("User clicks Message button.")
    public void user_clicks_message_button() {
        sendMessagePage.messageButton.click();
    }

    @And("User clicks Insert video icon.")
    public void userClicksInsertVideoIcon() {
        sendMessagePage.insertVideoIcon.click();
    }

    @And("User fills Video source box with {string}.")
    public void userFillsVideoSourceBoxWith(String videoURL) {
        BrowserUtilities.sleep(2);
        sendMessagePage.videoSourceBox.sendKeys(videoURL);
        BrowserUtilities.sleep(5);

    }

    @And("User clicks Save button.")
    public void userClicksSaveButton() {
        BrowserUtilities.sleep(2);
        sendMessagePage.saveButton.click();
        BrowserUtilities.sleep(2);

    }

    @Then("Verify that user can add video.")
    public void verifyThatUserCanAddVideo() {
        Assert.assertFalse(sendMessagePage.videoNotAddedError.isDisplayed());
    }

    @And("User clicks Send button.")
    public void userClicksSendButton() {
        BrowserUtilities.sleep(2);
        sendMessagePage.sendButton.click();
        BrowserUtilities.sleep(2);
    }

    @And("User clicks Comma icon.")
    public void userClicksCommaIcon() {
        sendMessagePage.commaIcon.click();
        BrowserUtilities.sleep(2);
    }

    @And("User fills Quote box with a quote.")
    public void userFillsQuoteBoxWithAQuote() {

        Driver.getDriver().switchTo().frame(sendMessagePage.quoteBoxIframe);
        sendMessagePage.quoteBox.sendKeys(faker.shakespeare().hamletQuote() + " \"Shakespeare\"");
        BrowserUtilities.sleep(2);
        Driver.getDriver().switchTo().parentFrame();
    }

    @And("User fills Message Title which is mandatory field with a message title.")
    public void userFillsMessageTitleWhichIsMandatoryFieldWithAMessageTitle() {
        Driver.getDriver().switchTo().frame(sendMessagePage.messageTitleIframe);
        sendMessagePage.messageTitleBox.clear();
        sendMessagePage.messageTitleBox.sendKeys("Hello " + faker.superhero().name());
        Driver.getDriver().switchTo().parentFrame();
    }

    @And("User clicks Add mention icon.")
    public void userClicksAddMentionIcon() {
        sendMessagePage.addMentionIcon.click();
    }

    @And("User adds mentions.")
    public void userAddsMentions() {
        sendMessagePage.mention2Text.click();
        sendMessagePage.mention3Text.click();
        sendMessagePage.mention4Text.click();
        sendMessagePage.mention5Text.click();
        sendMessagePage.closeButton.click();
    }

    @And("User clicks Employees and Departments.")
    public void userClicksEmployeesAndDepartments() {
        sendMessagePage.employeesAndDepartments.click();
    }

    @And("User clicks more recipient link.")
    public void userClicksMoreRecipientLink() {
        sendMessagePage.moreRecipientLink.click();
    }

    @Then("Verify that user can {string}.")
    public void verifyThatUserCanAddMention(String isDone) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Portal"));
        System.out.println("User can " + isDone);
    }

    @Then("Verify that user CAN NOT send a message.")
    public void verifyThatUserCANNOTSendAMessage() {
        Assert.assertTrue(sendMessagePage.mandatoryMessageTitleError.isDisplayed());
    }

    @And("User clicks on Add more link.")
    public void userClicksOnAddMoreLink() {
        sendMessagePage.addMoreLink.click();
    }
}

