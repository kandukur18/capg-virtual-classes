package com.capg.demo.healthcaresystemhome.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.capg.demo.healthcaresystemhome.model.Appointment;
import com.capg.demo.healthcaresystemhome.model.DiagnosticCenter;
import com.capg.demo.healthcaresystemhome.model.DiagnosticTest;
import com.capg.demo.healthcaresystemhome.model.User;

public class DaoImplementation implements DaoInterface {

	public static Random rand=new Random();
	public static HashMap<String,User> userList=new HashMap<String,User>();
	public static HashMap<String,String> adminList=new HashMap<String,String>();	
	public static List<DiagnosticCenter> centerList=new ArrayList<DiagnosticCenter>();
	
	public static int appointmentIndex;
	public static int appointmentValue;
	public static DiagnosticCenter center;
	
	
	public DaoImplementation() {
		super();
		adminList.put("Nagireddymani","1111");
		adminList.put("Ashritha","2222");
		adminList.put("Ravali","3333");
		
		DiagnosticCenter center=new DiagnosticCenter();
		center.setCenterId("101");
		center.setCenterName("Narsapur");
		
		DiagnosticTest test1=new DiagnosticTest();
		test1.setTestId("1");
		test1.setTestName("Blood Pressure");
		DiagnosticTest test2=new DiagnosticTest();
		test2.setTestId("2");
		test2.setTestName("Blood Sugar");
		DiagnosticTest test3=new DiagnosticTest();
		test3.setTestId("3");
		test3.setTestName("Blood Group");
		center.setListOfTests(Arrays.asList(test1,test2,test3));
		
		User user=new User();
		user.setUserId("111");
		user.setUserName("Manikanta");
		user.setUserPassword("atnakinaM1");
		user.setContactNo(9505411992L);
		user.setEmailId("nagireddymani080@gmail.com");
		DaoImplementation.userList.put(user.getUserName(),user);
		
		Appointment appointment1=new Appointment();
		appointment1.setAppointmentId(111L);
		appointment1.setUser(user);
		appointment1.setDateTime(new Date());
		appointment1.setTest(test1);
		Appointment appointment2=new Appointment();
		appointment2.setAppointmentId(112L);
		appointment2.setUser(user);
		appointment2.setDateTime(new Date());
		appointment2.setTest(test2);
		center.setAppointmentList(Arrays.asList(appointment1,appointment2));
		
		DaoImplementation.centerList.add(center);
		
		DiagnosticCenter center1=new DiagnosticCenter();
		center1.setCenterId("102");
		center1.setCenterName("Hyderabad");
		center1.setListOfTests(Arrays.asList(test1,test2,test3));
		center1.setAppointmentList(Arrays.asList(appointment1,appointment2));
		
		DaoImplementation.centerList.add(center1);
		
	}

	public String addCenter(DiagnosticCenter center) {
		center.setCenterId(Integer.toString(rand.nextInt(200)));
		centerList.add(center);
		return center.getCenterId();
	}
	public boolean removeCenter(DiagnosticCenter center) {
		
		if(centerList.contains(center))
		{
			centerList.remove(center);
			return true;
		}
		else
		{
			return false;
		}
	}

	public String addDiagnosticTest(DiagnosticTest test) {
		
		test.setTestId(Integer.toString(rand.nextInt(20)));
		List<DiagnosticTest> testList1=new ArrayList<DiagnosticTest>();
		testList1.add(test);
		List<DiagnosticTest> testList2=center.getListOfTests();
		testList1.addAll(testList2);
		center.setListOfTests(testList1);
		return test.getTestId();
	}
	
	public boolean removeDiagnosticTest(DiagnosticTest test) {
		
		if(center.getListOfTests().contains(test))
		{   
//			List<DiagnosticTest> testList=center.getListOfTests();
//			testList.remove(1);
//			center.setListOfTests(testList);
			List<DiagnosticTest> testList1=Arrays.asList(test);
			List<DiagnosticTest> testList2=center.getListOfTests();
//			System.out.println(testList1);
//			System.out.println(testList2);
//			testList2.remove(testList1);
			System.out.println(testList2.remove(test));
//			System.out.println(testList1);
//			System.out.println(testList2);
		    System.out.println(center.getListOfTests());
			return true;
		}
		else
			return false;
	}

	public boolean approveAppointment() {
		if(center.getAppointmentList().get(appointmentIndex).getApproved().equals(false))
		{
			if(appointmentValue==1)
			{
				center.getAppointmentList().get(appointmentIndex).setApproved(true);
			}
			else if(appointmentValue==0)
			{
				center.getAppointmentList().get(appointmentIndex).setApproved(false);
			}
			else
			{
				System.err.println("InValid Option");
			}
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public Long makeAppointment(User user, DiagnosticCenter center, DiagnosticTest test, Date dateTime) {
		Appointment appointment=new Appointment();
		appointment.setUser(user);
		appointment.setAppointmentId((long) rand.nextInt(10000000));
		appointment.setTest(test);
		appointment.setDateTime(dateTime);
        center.setAppointmentList(Arrays.asList(appointment));
		return appointment.getAppointmentId();
	}

	public String register(User user) {
		user.setUserId(Integer.toString(Math.abs(rand.nextInt(1000))));
		userList.put(user.getUserName(),user);
		return user.getUserId();
	}

	
	
}
