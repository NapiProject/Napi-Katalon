import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

String strCheckValue = ""

WebUI.openBrowser("saucedemo.com")

WebUI.maximizeWindow()

WebUI.waitForElementClickable(findTestObject('Object Repository/WEB/Login/btn-signIn'), GlobalVariable.maxDelay, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/WEB/Login/txt-username'), iUsername)

WebUI.setText(findTestObject('Object Repository/WEB/Login/txt-password'), iPassword)

WebUI.click(findTestObject('Object Repository/WEB/Login/btn-SignIn'))

if (iScenario == "Valid Data") {
	WebUI.waitForElementClickable(findTestObject('Object Repository/WEB/Login/lbl-Product'), GlobalVariable.maxDelay, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.markPassed("Scenario " + iScenario + " OK!")
	WebUI.closeBrowser()
}

else if (iScenario == "Invalid Data") {
	WebUI.waitForElementClickable(findTestObject('Object Repository/WEB/Login/lbl-errMessage'), GlobalVariable.maxDelay, FailureHandling.STOP_ON_FAILURE)
	strCheckValue = WebUI.getText(findTestObject('Object Repository/WEB/Login/lbl-errMessage'), FailureHandling.STOP_ON_FAILURE)
	WebUI.closeBrowser()
	
	if (strCheckValue == "Epic sadface: Username and password do not match any user in this service") {
		KeywordUtil.markPassed("Scenario " + iScenario + " OK!")
	} 
	else {
		KeywordUtil.markFailedAndStop(iScenario + " is failed!")
	} 
}

else if (iScenario == "Username Null") {
	WebUI.waitForElementClickable(findTestObject('Object Repository/WEB/Login/lbl-errMessage'), GlobalVariable.maxDelay, FailureHandling.STOP_ON_FAILURE)
	strCheckValue = WebUI.getText(findTestObject('Object Repository/WEB/Login/lbl-errMessage'), FailureHandling.STOP_ON_FAILURE)
	WebUI.closeBrowser()
	
	if (strCheckValue == "Epic sadface: Username is required") {
		KeywordUtil.markPassed("Scenario " + iScenario + " OK!")
	}
	else {
		KeywordUtil.markFailedAndStop(iScenario + " is failed!")
	}
}

else if (iScenario == "Password Null") {
	WebUI.waitForElementClickable(findTestObject('Object Repository/WEB/Login/lbl-errMessage'), GlobalVariable.maxDelay, FailureHandling.STOP_ON_FAILURE)
	strCheckValue = WebUI.getText(findTestObject('Object Repository/WEB/Login/lbl-errMessage'), FailureHandling.STOP_ON_FAILURE)
	WebUI.closeBrowser()
	
	if (strCheckValue == "Epic sadface: Password is required") {
		KeywordUtil.markPassed("Scenario " + iScenario + " OK!")
	}
	else {
		KeywordUtil.markFailedAndStop(iScenario + " is failed!")
	}
}

else {
	WebUI.closeBrowser()
	KeywordUtil.markFailedAndStop("undefined scenario!")
}