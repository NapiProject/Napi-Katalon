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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

String strChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" //value untuk random huruf
String strNumber = "0123456789" //value untuk random angka

//Proses membuat random huruf
Random randChar = new Random()
StringBuilder sbChar = new StringBuilder()
  	for (int i=1; i<10; i++) {
		  sbChar.append(strChar.charAt(randChar.nextInt(strChar.length())));
		  }

//Proses membuat random angka
Random randNumber = new Random()
StringBuilder sbNumber = new StringBuilder()
  	for (int i=1; i<5; i++) {
		  sbNumber.append(strNumber.charAt(randNumber.nextInt(strNumber.length())));
		  }
	  
	  
WebUI.comment("Napi " + sbChar)
WebUI.comment("Napi " + sbNumber)