package com.capg.demo.healthcaresystemhome.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



import com.capg.demo.healthcaresystemhome.dao.DaoImplementation;
import com.capg.demo.healthcaresystemhome.dao.DaoInterface;
import com.capg.demo.healthcaresystemhome.exception.InValidOptionException;
import com.capg.demo.healthcaresystemhome.exception.InvalidCenterIdException;
import com.capg.demo.healthcaresystemhome.exception.InvalidTestIdException;
import com.capg.demo.healthcaresystemhome.exception.InvalidUsernameOrPasswordException;
import com.capg.demo.healthcaresystemhome.model.Appointment;
import com.capg.demo.healthcaresystemhome.model.DiagnosticCenter;
import com.capg.demo.healthcaresystemhome.model.DiagnosticTest;
import com.capg.demo.healthcaresystemhome.model.User;
import com.capg.demo.healthcaresystemhome.service.ServiceImplementation;
import com.capg.demo.healthcaresystemhome.service.ServiceInterface;

public class Presentation {
	
   static Scanner scanner;
   static ServiceInterface service=new ServiceImplementation();
	public static void main(String args[])
	{
		while(true) {
		System.out.println("1.Admin");
		System.out.println("2.Customer");
		
		int choose=0;
		boolean inputFlag=false;
		do {
			scanner = new Scanner(System.in);
			System.out.print("\nEnter your Choose : ");
			try {
				
				choose=scanner.nextInt();
				inputFlag=true;
			}
			catch(InputMismatchException ime)
			{
				inputFlag=false;
				System.err.println("input should contain only digits");
			}
		}while(!inputFlag);
		
		switch(choose)
		{
			case 1 :{
				      
				      System.out.print("\nUserName        : ");
				      String userName=scanner.next();
				      System.out.print("Password        : ");
				      String password=scanner.next();
				      if(DaoImplementation.adminList.containsKey(userName) && DaoImplementation.adminList.containsValue(password))
				      {
				      System.out.println("\n1.Add Center");
				      System.out.println("2.Remove Center");
				      System.out.println("3.Add Test");
				      System.out.println("4.Remove Test");
				      System.out.println("5.Approve Appointments");
				      
				      inputFlag=false;
				      do
				      {
				    	  try
			        	  {
			        		  scanner=new Scanner(System.in);
			        		  System.out.print("\nEnter your Choose : ");
			        		  choose=scanner.nextInt();
			        		  inputFlag=true;
			        	  }
			        	  catch(InputMismatchException e)
			        	  { 
			        		  System.err.println("input should contain only digits");
			        	  }
				    	  
				      }while(!inputFlag);
				      switch(choose)
			          {
			          case 1  : addCenter();           break;
			          case 2  : removeCenter();        break;
			          case 3  : addTest();             break;
			          case 4  : removeTest();          break;
			          case 5  : approveAppointment();  break;
			          default : System.err.println("Invalid Option ");
			          } 
				      }
				      else
				      {
				    	  System.err.println("Invalid Username or Password");
				      }
			        } 
                     break;
			case 2 : {
				          System.out.println("\n1.Login");
				          System.out.println("2.Register");
				          System.out.println("3.Download Appointment");
				          
				          inputFlag=false;
				          do {
				        	 
				        	  try
				        	  {
				        		  scanner=new Scanner(System.in);
				        		  System.out.print("\nEnter your Choose : ");
				        		  choose=scanner.nextInt();
				        		  inputFlag=true;
				        	  }
				        	  catch(InputMismatchException e)
				        	  { 
				        		  System.err.println("input should contain only digits");
				        	  }
				          }while(!inputFlag);
				          switch(choose)
				          {
				          case 1 :  Login(); break;
				          case 2 :  Register(); break;
				          case 3 :  DownloadAppointment(); break;
				          default : System.err.println("Invalid Option ");
				          }
				          
			         }
                     break;
              default : System.err.println("Invalid Option ");
		    }//switch
		
				System.out.println("\npress 1 to continue...");
				try {	
				if(scanner.nextInt()==1)
				{
					continue;
				}
				else
				{
					System.out.println("\nProgram Terminated");
					break;
				}
				}
		        catch(InputMismatchException e)
				{
		        	System.out.println("\nProgram Terminated");
		        	break;
				}
		}//while
	}//main
  	
	private static void approveAppointment() {
		
		System.out.println("\nCenter Id "+"\t"+"CenterName");
		System.out.println("_____________________________________");
		for(DiagnosticCenter duplicateCenter:DaoImplementation.centerList)
		{
			System.out.println(duplicateCenter.getCenterId()+"\t\t"+duplicateCenter.getCenterName());
		}
		
		boolean inputFlag=false;
		do 
		{
		System.out.print("\nSelect Center by Id :");
		String centerId=scanner.next();
	
		for(DiagnosticCenter duplicateCenter:DaoImplementation.centerList)
		{
			if(duplicateCenter.getCenterId().equals(centerId))
			{
				DaoImplementation.center=duplicateCenter ;
				inputFlag=true;
				break;
			}
		}
		if (DaoImplementation.center==null)
		{
			System.err.println("Enter Valid Center ID ");
		}
		}while(!inputFlag);
		
		int index=0;
		System.out.println("\nPress 1 to Accept a Appointment \nPress 0 to Reject an Appointment ");
		
		for(Appointment duplicateAppointment:DaoImplementation.center.getAppointmentList())
		{
			DaoImplementation.appointmentIndex=index;
			
			System.out.println("\nAppointment Id : "+duplicateAppointment.getAppointmentId());
			
			inputFlag=false;
			do {
				
				try 
				{
					scanner=new Scanner(System.in);
					System.out.print("\nEnter your Choose(1/0) : ");
					DaoImplementation.appointmentValue=scanner.nextInt();
					if(DaoImplementation.appointmentValue!=1 && DaoImplementation.appointmentValue!=0)
					{
						throw new InValidOptionException();
					}
					inputFlag=true;
				}
				catch(InputMismatchException e) 
				{
					System.err.println("Value must Contain only digits");
				}
				catch(InValidOptionException e)
				{
					System.err.println("option must be 1 or 0");
				}
			}while(!inputFlag);
			
			if(service.approveAppointment())
			{
				if(DaoImplementation.appointmentValue==1)
				System.out.println("Appointment is Accepted");
				else if(DaoImplementation.appointmentValue==0)
			    System.out.println("Appointment is Rejected");
			}
			else
			{
				System.out.println("Appointment is Already Accepted");
			}
			index++;
		}
		
	}


	private static void removeTest() {
		
		
		scanner=new Scanner(System.in);
		int x=1;
		System.out.println("Center ID\t\tCenter Name");
		System.out.println("-------------------------------");
		for(DiagnosticCenter duplicateCenter:DaoImplementation.centerList)
		{
			System.out.println(duplicateCenter.getCenterId()+"\t\t"+duplicateCenter.getCenterName());
			x++;
		}
		boolean inputFlag=false;
		do 
		{
				System.out.print("\nEnter your choose by Id  : ");
				String centerId=scanner.next();
				for(DiagnosticCenter duplicateCenter:DaoImplementation.centerList)
				{
					if(duplicateCenter.getCenterId().equals(centerId))
					{
						DaoImplementation.center=duplicateCenter;
						break;
					}
				}
				if(DaoImplementation.center!=null)
					 inputFlag=true;
				else
					System.err.println("Enter Valid Id ");
		}while(!inputFlag);
		
		if(!DaoImplementation.center.getListOfTests().isEmpty())
		{
					System.out.println("Test ID\t\tTest Name");
					System.out.println("-------------------------------");
					for(DiagnosticTest duplicateTest:DaoImplementation.center.getListOfTests())
					{
						System.out.println(duplicateTest.getTestId()+"\t\t"+duplicateTest.getTestName());
					}
					
					String testId;
					inputFlag=false;
			//		do 
			//		{
			//				System.out.print("\nEnter your choose by Id  : ");
			//			    testId=scanner.next();
			//			    for(DiagnosticTest duplicateTest:center.getListOfTests())
			//			    {
			//			    	if(duplicateTest.getTestId().equals(testId))
			//			    	{
			//						  inputFlag=true;
			//						  break;
			//			    	}
			//			    }
			//		if(!inputFlag)
			//			System.err.print("Enter Valid Id");
			//		}while(!inputFlag);
			//		
			//		for(DiagnosticTest duplicateTest:center.getListOfTests())
			//		{
			//			if(duplicateTest.getTestId().equals(testId))
			//			{
			//				System.out.println("Test with Id : "+service.removeDiagnosticTest(center,duplicateTest)+" added Successfully");
			//				break;
			//			}
			//		}
					
				   System.out.print("\nEnter your choose by Id  : ");
			 	   testId=scanner.next();
			 	    
			 	   DiagnosticTest test=null;
			 	   for(DiagnosticTest duplicateTest:DaoImplementation.center.getListOfTests())
					    {
					    	if(duplicateTest.getTestId().equals(testId))
					    	{
					    		  test=duplicateTest;
								  inputFlag=true;
								  break;
					    	}
					    }
			 	    
			 	    	if(service.removeDiagnosticTest(test ))
						{
							System.out.println("Test removed Successfully");
						}
						else
						{
							System.err.println("Test is not in the List ");
						}	
			 	    
 	    }
		else
		{
			      System.out.println("Test List is Empty");
		}
		
	}

	
	private static void addTest() {
		
		int x=1;
		System.out.println("Center ID\t\tCenter Name");
		System.out.println("-------------------------------");
		for(DiagnosticCenter duplicateCenter:DaoImplementation.centerList)
		{
			System.out.println(duplicateCenter.getCenterId()+"\t\t"+duplicateCenter.getCenterName());
			x++;
		}
		String centerId;
		boolean inputFlag=false;
		do 
		{
				System.out.print("\nEnter your choose by Id  : ");
			    centerId=scanner.next();
			    for(DiagnosticCenter duplicateCenter:DaoImplementation.centerList)
			    {
			    	if(duplicateCenter.getCenterId().equals(centerId))
			    	{
						  inputFlag=true;
						  break;
			    	}
			    }
		if(!inputFlag)
			System.err.print("Enter Valid Id");
		}while(!inputFlag);
	
		DiagnosticTest test=new DiagnosticTest();
		System.out.print("\nTestName    : ");
		String testName=scanner.next();
		test.setTestName(testName);
		for(DiagnosticCenter duplicateCenter:DaoImplementation.centerList)
		{
			if(duplicateCenter.getCenterId().equals(centerId)) 
			{
				DaoImplementation.center=duplicateCenter;
				System.out.println("Test with Id : "+service.addDiagnosticTest(test)+" added Successfully");
			}
		}
	}


	private static void removeCenter() {
		List<DiagnosticCenter> centerList=DaoImplementation.centerList;
		
		System.out.println("Center ID\t\tCenter Name");
		System.out.println("-------------------------------");
		for(DiagnosticCenter duplicateCenter:centerList)
		{
			System.out.println(duplicateCenter.getCenterId()+"\t\t"+duplicateCenter.getCenterName());
		}
		System.out.println("Select Center by Id");
		String centerId=scanner.next();
		DiagnosticCenter center = null;
		for(DiagnosticCenter duplicateCenter:centerList)
		{
	        if(duplicateCenter.getCenterId().equals(centerId))
	        {
	        	center=duplicateCenter;        			
	        }
		}
	
		if(centerList.isEmpty())
		{
			System.err.println("center list is Empty");	
		}
		else
		{
			if(service.removeCenter(center))
			{
				System.out.println("Center removed Successfully");
			}
			else
			{
				System.out.println("Center is not in the List ");
			}
			
		}
		//System.out.println(DaoImplementation.centerList);
		
	}



	private static void addCenter() {
		 DiagnosticCenter center=new DiagnosticCenter();
		 
		 System.out.print("\nCenterName         : ");
		 String centerName=scanner.next();
		 center.setCenterName(centerName);
		 center.setListOfTests(DaoImplementation.centerList.get(0).getListOfTests());
		 System.out.println("Center with Id : "+service.addCenter(center)+" added Succussfully");		 
	}

	public static void Login()
	{
				System.out.println("\nLogin Form");
				System.out.println("----------------------------");
				boolean inputFlag=false;
				String username = null;
				String password = null;
				
				do 
				{
						try {
						scanner =new Scanner(System.in);
						System.out.print("Username   : ");
						username=scanner.next();
						System.out.print("Password   : ");
				        password=scanner.next();
				        if(!(DaoImplementation.userList.containsKey(username) && DaoImplementation.userList.get(username).getUserPassword().equals(password)))
				        {
				        	throw new InvalidUsernameOrPasswordException();
				        	
				        }
				        inputFlag=true;
						}
						catch(InvalidUsernameOrPasswordException i)
						{
							System.err.println("Invalid UserName Or PassWord Exception\n");
						}
				}while(!inputFlag);
		
		        makeAppointment(DaoImplementation.userList.get(username));
	}
	
	
	public static void Register()
	{
			User user=new User();
			boolean inputFlag=false;
			String userName;
			
			do
			{
				System.out.print("Username          : ");
				userName=scanner.next();
				if(service.validateUserName(userName))
				{
					if(!DaoImplementation.userList.containsKey(userName))
					{
					       	user.setUserName(userName);
					       	inputFlag=true;
					}
					else
					{
						System.err.println("Username already Exist");
					}
				}
				else
				{
					System.err.println("Username Conditions...........");
				}	
			}while(!inputFlag);
				
			String userPassword;
			inputFlag=false;
			do
			{
				System.out.print("Password          : ");
				userPassword=scanner.next();
				if(service.validateUserPassword(userPassword))
				{
					   user.setUserPassword(userPassword);;
					   inputFlag=true;
				}
				else
				{
					System.err.println("Password Conditions...........");
				}	
			}while(!inputFlag);
			
			inputFlag=false;
			Long contactNo;
			
			do
			{
				System.out.print("Mobile Number     : ");
				contactNo=scanner.nextLong();
				if(service.validateMobileNumber(contactNo))
				{
		      		user.setContactNo(contactNo);
		      		inputFlag=true;
				}
				else
				{
					System.err.println("Number Conditions...........");
				}
			}while(!inputFlag);
			
			
			inputFlag=false;
			String emailId;
			do 
			{
				System.out.print("Email             : ");
				emailId=scanner.next();
				if(service.validateEmail(emailId))
				{
					user.setEmailId(emailId);
					inputFlag=true;
				}
				else
				{
					System.err.println("Email Conditions.........");
				}
					
				
			}while(!inputFlag);
			
			
			System.out.println(service.register(user)+" registered Succussfully");
			System.out.println(DaoImplementation.userList);
			Login();
		
	}
	
	public static void DownloadAppointment()
	{
		 boolean inputFlag=false;
		 Appointment appointment = null;
		 do 
		 {
			     Long appointmentId = null;
				 System.out.print("\nEnter your Appointment Id          : ");
				 try 
				 {
					 scanner=new Scanner(System.in);
					 appointmentId=scanner.nextLong();
					 List<DiagnosticCenter> centerList=DaoImplementation.centerList;
					 for(DiagnosticCenter center:centerList)
					 {
						 List<Appointment> appointmentList =center.getAppointmentList();
						 for(Appointment duplicateAppointment:appointmentList)
						 {
							 if(duplicateAppointment.getAppointmentId().equals(appointmentId))
							 {
								 appointment=duplicateAppointment;
								 break;
							 }
							 
						 }
					  }
					 if(appointment!=null)
						  inputFlag=true;
					 else
						 System.err.println("Invalid Id");
				 }
				 catch(InputMismatchException e)
				 {
					 System.err.println("Id contains only digits");
					
				 }
				 		 
		 }while(!inputFlag);
		 System.out.println("\n                Appointment Form ");
		 System.out.println("-----------------------------------------------------------------------");
		 System.out.println("Appointment Id                 : "+appointment.getAppointmentId());
		 System.out.println("Test Name                      : "+appointment.getTest().getTestName());
		 System.out.println("Name of Patient                : "+appointment.getUser().getUserName());
		 System.out.println("Mobile Number                  : "+appointment.getUser().getContactNo());
		 System.out.println("Email address                  : "+appointment.getUser().getEmailId());
		 System.out.println("Appointment Date               : "+appointment.getDateTime());
		 boolean flag=appointment.getApproved();
		 if(flag)
			 System.out.println("Appointment Status             : Approved");
		 else 
			 System.out.println("Appointment Status             : Pending");
		 System.out.println("------------------------------------------------------------------------");
		 System.out.println("                     Thank you");
			 
	}
	
	
	public static void makeAppointment(User user) 
	{ 
					System.out.println("\nSelect Diagnostic Center by Id ");
					List<DiagnosticCenter> list=DaoImplementation.centerList;
					int x=1;
					
					System.out.println("\nCenter Id"+"\tCenterName");
					System.out.println("-----------------------------");
					for(DiagnosticCenter center:list)
					{
						System.out.println(x+"."+center.getCenterId()+"\t\t "+center.getCenterName());
					    x++;
					}
			
					
					String centerId = null;
					boolean inputFlag=false;
					DiagnosticCenter center;
					do 
					{
							System.out.print("\nEnter Center Id :");
							centerId=scanner.next();
							center = null;
							for(DiagnosticCenter duplicatecenter:list)
							{
									if(duplicatecenter.getCenterId().equals(centerId))
									{
										center=duplicatecenter;
									}
							}
							try
							{
									if(center!=null)
									{
										  inputFlag=true;
									     
									}
									else
									{
										 throw new InvalidCenterIdException();
										
									}
								
							}
							catch(InvalidCenterIdException e)
							{
								   System.err.print("Invalid Center Id");
							}
					}while(!inputFlag);
					
					
					
					
					System.out.println("\nTestId"+"\t    TestName");
					System.out.println("-------------------------------");
					
					for(DiagnosticTest duplicateTest:center.getListOfTests())
					{
						System.out.println(duplicateTest.getTestId()+"\t\t"+duplicateTest.getTestName());
					}
					
					DiagnosticTest test = null;
					inputFlag=false;
					do
					{
							System.out.println("Enter Test Id");
							String testId=scanner.next();
							for(DiagnosticTest duplicateTest:center.getListOfTests())
							{
									if(duplicateTest.getTestId().contentEquals(testId))
									{
										test=duplicateTest;
									}
									
							}
							try
								{
									if(test!=null)
									{
										inputFlag=true;
									}
									else
									{
										throw new InvalidTestIdException();
									}
							}
							catch(InvalidTestIdException e)
							{
								    System.err.println("Invalid TestId");
							}
							
						
					}while(!inputFlag);
					
					
					System.out.print("\nDate (dd-MM-yyyy) :  ");
					String dateTime=scanner.next();
					
					java.util.Date date = null;
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					try
					{
							date=formatter.parse(dateTime);
					} 
					catch (ParseException e) 
					{
						
							e.printStackTrace();
					}
					System.out.println("\nAppointment "+service.makeAppointment(user,center,test,date)+" made Sucussfully");
					
				}
}
