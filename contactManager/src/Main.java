/*Programmer : Mark Angel P. Concina
			   King David P. Bermejo
			   John Cedric S. Vilgera
  Section    : BSIT-2B
*/
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ContactManager contactManager = new ContactManager();
		contactManager.loadContactsFromFile("contact.txt");
		
		while(true) {
			System.out.println("~~~~~~~~~~CONTACT MANAGER~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("[1] Display Contacts");
			System.out.println("[2] Edit Contacts");
			System.out.println("[3] Add Contacts");
			System.out.println("[4] Delete Contacts");
			System.out.println("[5] Search Contacts");
			System.out.println("[0] Exit");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.print("Enter your Choice: ");
			int choice = s.nextInt();
			s.nextLine();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			switch(choice) {
			case 1:
				contactManager.displayContacts();
				break;
			case 2: 
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.print("Enter the Full Name of the contact you want to edit: ");
				String fullName = s.nextLine();
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				contactManager.editContact(fullName);
				break;
			case 3:
				System.out.print("Enter First Name: ");
				String fname = s.nextLine();
				System.out.print("Enter Middle Name: ");
				String mname = s.nextLine();
				System.out.print("Enter Last Name: ");
				String lname = s.nextLine();
				System.out.print("Enter Address: ");
				String address = s.nextLine();
				System.out.print("Enter Birthday: ");
				String birthday = s.nextLine();
				System.out.print("Enter Sex: ");
				String sex = s.nextLine();
				System.out.print("Enter Email Address: ");
				String emailAddress = s.nextLine();
				System.out.print("Enter number: ");
				String number = s.nextLine();
				
				Contact contacts;
				contacts = new Contact(fname, mname, lname, address, birthday, sex, emailAddress, number);
				contactManager.addContact(contacts);
				break;
			case 4:
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.print("Enter the Full Name of the contact you want to delete: ");
				String fullname = s.nextLine();
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				contactManager.deleteContact(fullname);
				break;
			case 5:
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.print("Enter the Full Name of the contact you want to search: ");
				String full_name = s.nextLine();
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				contactManager.searchContact(full_name);
				break;
			case 0:
				System.out.println("Goodbye!");
				return;
			default: 
				System.out.println("Invalid Input!   Please try again!");
				System.out.println();
			}
			contactManager.saveContactsToFile("contact.txt");
		}
	}
}
