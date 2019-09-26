package RegisterPackage;
import customerPak.Customer;


public class Register
{
	
	Customer  cus=new Customer();

	
	
	public Register(String firstName, String middleName, String lastName, String phoneNo, String proofType,
			String proofID) 
	{
		cus.setFirstName(firstName);
		cus.setMiddleName(middleName);
		cus.setLastName(lastName);
		cus.setPhoneNo(phoneNo);
		cus.setProofType(proofType);
		cus.setProofID(proofID);
		this.Display();
	}

	public Register() 
	{
		// TODO Auto-generated constructor stub
	}

	public void Display()
	{
		System.out.println("First Name  : "+""+cus.getFirstName());
		System.out.println("Middle Name :"+""+cus.getMiddleName());
		System.out.println("Last Name   :"+""+cus.getLastName());
		System.out.println("Phone Number :"+""+cus.getPhoneNo());
		System.out.println("Proof Type   :"+""+cus.getProofType());
		System.out.println("ProofID       :"+""+cus.getProofID());
		
	}

	public void UpdatePhoneNo(int custid, String upmail, String[] emaiIDs, int epos)
	{
		for(int i=0;i<epos;i++)
		{
			if(i==custid-1)
			{
				System.out.println("old mail id:"+""+emaiIDs[i]);
		        emaiIDs[i]=upmail;
		    	System.out.println("updated mail id:"+""+emaiIDs[i]);
			}
		}
		
	}


	public void DisplayCustList(int[] custRegIDArray, String[] custArray, int epos) 
	{
		
		System.out.println("The registered customers are");
		System.out.println("Customer ID                Customer name");
		 for(int k=0;k<epos;k++)
		 {
			 System.out.println(custRegIDArray[k]+"                             "+custArray[k]);			
	     }
		
	}

}
