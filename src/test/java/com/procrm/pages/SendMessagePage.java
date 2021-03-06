package com.procrm.pages;

import com.procrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMessagePage {

    public SendMessagePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "feed-add-post-form-tab-message")
    public WebElement messageButton;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement messageTitleIframe;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageTitleBox;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-video']")
    public WebElement insertVideoIcon;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']")
    public WebElement linkIcon;

    @FindBy(xpath = "//input[@placeholder='Link URL']")
    public WebElement linkInsertBox;

    @FindBy(xpath = "//input[@placeholder='YouTube or Vimeo video URL']")
    public WebElement videoSourceBox;

    @FindBy(xpath = "//span[@class='bxhtmled-video-error']")
    public WebElement videoNotAddedError;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "(//button[@class='ui-btn ui-btn-lg ui-btn-primary'])[1]")
    public WebElement sendButton;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-quote']")
    public WebElement commaIcon;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement quoteBoxIframe;

    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    public WebElement quoteBox;

    @FindBy(id = "bx-b-mention-blogPostForm")
    public WebElement addMentionIcon;

    @FindBy(xpath = "//a[@class='bx-finder-box-tab bx-lm-tab-department']")
    public WebElement employeesAndDepartments;

    @FindBy(xpath = "//span[@class='popup-window-close-icon']")
    public WebElement closeButton;

    @FindBy(xpath = "(//a[@href='javascript:void(0)'])[1]")
    public WebElement moreRecipientLink;

    @FindBy(xpath = "//a[.='Add more']")
    public WebElement addMoreLink;

    @FindBy(xpath = "//span[.='The message title is not specified']")
    public WebElement mandatoryMessageTitleError;

    @FindBy(xpath = "(//input[@type='text'])[5]")
    public WebElement addEmployeeContainer;

    @FindBy(xpath = "(//span[@title='Upload files'])[1]")
    public WebElement uploadFilesIcon;

    @FindBy(xpath = "(//input[@class='diskuf-fileUploader wd-test-file-light-inp '])[1]")
    public WebElement filePictureUploadContainer;

    @FindBy(xpath = "//a[.='My Drive / Uploaded files']")
    public WebElement myDriveUploadedFiles;

}