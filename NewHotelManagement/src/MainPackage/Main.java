package MainPackage;

import RegisterPackage.Register;
import BookingPackage.Booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
 
	public static int CustID=0;
	public static int RoomID=0;
	static int bookedRoomsID[]=new int[25];
	public static int DateBook[]=new int[100];
	public static int custRegIDArray[]=new int[100];
	static String EmaiIDs[]=new String[25];
	public static String custArray[]=new String[100];

	
	
	
	public static void main(String[] args) throws IOException
	{
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  Scanner  sc=new Scanner(System.in);
	  
	
	  Register reg = null;
	  Booking buk=null;
	  
	    String FirstName;
		String MiddleName;
		String LastName;
		String Email;
		String PhoneNo;
		String proofType;
		String proofID;
		
		String RegStr;
		int epos=0;
		int pos=0;
		do {
		System.out.println("ENTER MENU");
		System.out.println("1.Register  2.Book   3.Check Status  4.Update Email");
		System.out.println(" 5.All Bookings      6.Allcustomers   7.exit");
		int choice;
	    choice=sc.nextInt();
		
		switch(choice) 
		{
		case 1:
		do
		{
		System.out.println("Enter the firstname");
		FirstName=br.readLine();
		System.out.println("Enter the middlename");
		MiddleName=br.readLine();
		System.out.println("Enter Last name");
		LastName=br.readLine();
		System.out.println("Enter Phone Number");
		PhoneNo=br.readLine();
		System.out.println("Enter Proof Type");
		proofType=br.readLine();
		System.out.println("Enter proofID");
		proofID=br.readLine();
		
		 reg=new Register(FirstName,MiddleName,LastName,PhoneNo,proofType,proofID);
		
		
		System.out.println("Thank you for the Registration......Your CustomerID is" +""+ ++CustID);
		EmaiIDs[epos]=PhoneNo;
		custArray[epos]=FirstName;
		custRegIDArray[epos]=CustID;
		epos++;
		System.out.println("Do you want to continue registration (y/n)?");
		RegStr=br.readLine();
		}while(RegStr.equalsIgnoreCase("yes"));

		  break;
		  
		case 2:
			String ac;
			String cot;
			String cable;
			String wifi;
			String laundry;
			int date;
			
			System.out.println("Enter your customer ID");
			int checkID=sc.nextInt();
			for(int i=0;i<CustID;i++)
			{
				if(custRegIDArray[i]==checkID)
				{
				   System.out.println("Please choose the services required.");
				   System.out.println("Which room you want AC/non-AC  (AC/nAC)");
					ac=br.readLine();
					System.out.println("Cot(Single/Double)");
					cot=br.readLine();
					System.out.println("With cable connection/without cable connection(C/nC)");
					cable=br.readLine();
					System.out.println("Wi-Fi needed or not(W/nW)");
					wifi=br.readLine();
					System.out.println("Laundry service needed or not(L/nL)");
					laundry=br.readLine();
					System.out.println("Enter the date of booking");
					date=sc.nextInt();

					 buk=new Booking(ac,cot,cable,wifi,laundry,date);
										
					buk.CalculateCharge();
					buk.servicesRoom();
					buk.servicesHotel();
					
					 System.out.println("Do you want to proceed?");
					  String strroom=br.readLine();
					  if(strroom.equalsIgnoreCase("Yes"))
					  {
						 
						  System.out.println("Thank you for booking. Your room number is"+""+(++RoomID));
						  bookedRoomsID[pos]=RoomID;
						  DateBook[pos]=date;
						  pos++;
						  
					  }
					  else
					  if(strroom.equalsIgnoreCase("no"))
					  {
						  System.out.println("Visit Again");  
					  }
				}
				else
					System.out.println("Registered users are allowed");
			}			
			break;
		case 3:
			System.out.println("Enter The room No");
		     int roomNo=sc.nextInt();
		    // Booking buk=new Booking();
		     buk.checkStatus(roomNo,bookedRoomsID,pos);	     
			break;
		case 4:
			System.out.println("Enter the CustomerID");
			int custid=sc.nextInt();
			System.out.println("Enter New PhoneNo");
			String upmail=br.readLine();
			
			reg.UpdatePhoneNo(custid,upmail,EmaiIDs,epos);
			
			break;
			
		case 6:
			
			reg.DisplayCustList(custRegIDArray,custArray,epos);
			break;
			
		case 5:
			System.out.println("Enter the start date");
			int strDate=sc.nextInt();
			System.out.println("Enter the end date");
			int endDate=sc.nextInt();
			buk.AllBookList(strDate,endDate,DateBook,pos,custRegIDArray,bookedRoomsID);
			break;
		case 7:
		       System.exit(0);
			break;
		}
		
		}while(true);
		
		
	}

}
