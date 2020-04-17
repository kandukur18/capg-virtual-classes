package com.capg.demo.healthcaresystemhome.model;

public class DiagnosticTest {
//fields 
 String testId;
 String testName;

 //Constructors
public DiagnosticTest() {
	super();
}

public DiagnosticTest(String testId, String testName) {
	super();
	this.testId = testId;
	this.testName = testName;
}

//Getter setter methods
public String getTestId() {
	return testId;
}

public void setTestId(String testId) {
	this.testId = testId;
}

public String getTestName() {
	return testName;
}

public void setTestName(String testName) {
	this.testName = testName;
}

//toString method
@Override
public String toString() {
	return "DiagnosticTest [testId=" + testId + ", testName=" + testName + "]";
}
	
}
