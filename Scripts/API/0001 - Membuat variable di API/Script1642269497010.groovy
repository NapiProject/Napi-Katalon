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
import groovy.json.JsonSlurper

/*
 * 1. Membuat variable di API
 * 2. Lokasi API ada di 'Object repository -> API -> Variable API'
 * 3. jsonSlurper untuk parse JSON response
 */

String strUsername = '628321546454'
String strPassword = 'aaaaaaaaaa1'

def response = WS.sendRequest(findTestObject('API/Variable API',
	[('varUsername') : strUsername, //varUsername harus sama dengan variable di API
	 ('varPassword') : strPassword])) //varPassword harus sama dengan variable di API


def jsonSlurper = new JsonSlurper()
jsonMessage = jsonSlurper.parseText(response.getResponseBodyContent())
WebUI.comment(jsonMessage.message)

