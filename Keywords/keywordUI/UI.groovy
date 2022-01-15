package keywordUI

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class UI {
	
	@Keyword
	public static void ScreenShot (String iName) {
		Date date = new Date()
		DateFormat dateFormat = new SimpleDateFormat('dd-MMMM-yyyy-HH-mm')
		String formattedDate= dateFormat.format(date)
		String[] splitDate = formattedDate.split("-")
		String Folder = splitDate[0] + ' ' + splitDate[1] + ' ' + splitDate[2] + '/'
		String Time = splitDate[3] + '.' + splitDate[4] + ' - '
	
		String currentFolder = RunConfiguration.getProjectDir() + '/Screenshot/' + Folder + Time + iName + ".jpeg"
		WebUI.takeScreenshot(currentFolder)

	}
}