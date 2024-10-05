import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
	private List <Contact> contacts;
	
	public ContactManager() {
		contacts = new ArrayList <Contact>();
	}
	public void addContact(Contact contact) {
		contacts.add(contact);
		System.out.println("Added Successfully");
		System.out.println();
	}
	public int searchByFullName(String fullName) {
		int index = 0;
		for(Contact contact: contacts) {
			String temp = contact.getFirstName()+ " " + contact.getMiddleName() + " " + contact.getLastName();
			if(temp.equalsIgnoreCase(fullName)) {
				index = contacts.indexOf(contact);
				return index;
			}
		}
		return -1;
	}
	public void displaySearchedContact(Contact contact) {
		System.out.println("**************************************");
		System.out.println("Fullname     : " + contact.getFirstName() + " " + contact.getMiddleName() + " " + contact.getLastName());
		System.out.println("Address      : " + contact.getAddress());
		System.out.println("Birthday     : " + contact.getBirthday());
		System.out.println("Sex          : " + contact.getSex());
		System.out.println("Email Address: " + contact.getEmailAddress());
		System.out.println("Number       : " + contact.getNumber());
		System.out.println("**************************************");
		System.out.println();
	}
	public void editContact(String fullName) {
		Scanner s = new Scanner(System.in);
		if(searchByFullName(fullName) == -1) {
			System.out.println("Contact Not Found!");
			System.out.println();
		}
		else {
			int index = searchByFullName(fullName);
			Contact contact = contacts.get(index);
			System.out.println("Contact Found");
			displaySearchedContact(contact);
			
			while(true) {
				System.out.println("[1] Edit First Name: ");
				System.out.println("[2] Edit Middle Name: ");
				System.out.println("[3] Edit Last Name: ");
				System.out.println("[4] Edit Address: ");
				System.out.println("[5] Edit Birthday: ");
				System.out.println("[6] Edit Sex: ");
				System.out.println("[7] Edit Email Address: ");
				System.out.println("[8] Edit Number: ");
				System.out.println("[0] Save");
				
				System.out.print("What do you want to edit? or  Press [0] to save changes: ");
				int option = s.nextInt();
				s.nextLine();
				System.out.println("**************************************");
				
				switch(option) {
				case 1:
					System.out.print("Enter New First Name: ");
					String fname = s.nextLine();
					contact.setFirstName(fname);
					displaySearchedContact(contact);
					break;
				case 2: 
					System.out.print("Enter New Middle Name: ");
					String mname = s.nextLine();
					contact.setMiddleName(mname);
					displaySearchedContact(contact);
					break;
				case 3:
					System.out.print("Enter New Last Name: ");
					String lname = s.nextLine();
					contact.setLastName(lname);
					displaySearchedContact(contact);
					break;
				case 4:
					System.out.print("Enter New Address: ");
					String addr = s.nextLine();
					contact.setAddress(addr);
					displaySearchedContact(contact);
					break;
				case 5:
					System.out.print("Enter New Birthday: ");
					String bday = s.nextLine();
					contact.setBirthday(bday);
					displaySearchedContact(contact);
					break;
				case 6:
					System.out.print("Enter New Sex: ");
					String sex = s.nextLine();
					contact.setSex(sex);
					displaySearchedContact(contact);
					break;
				case 7:
					System.out.print("Enter New Email Address: ");
					String emailAdd = s.nextLine();
					contact.setEmailAddress(emailAdd);
					displaySearchedContact(contact);
					break;
				case 8:
					System.out.print("Enter New Number: ");
					String number = s.nextLine();
					contact.setNumber(number);
					displaySearchedContact(contact);
					break;
				case 0:
					System.out.println("Contact saved successfully");
					return;
				default:
					System.out.println("Invalid Input!  Please try again!");
					System.out.println();
				}
			}
		}
	}
	public void deleteContact(String fullName) {
		if(searchByFullName(fullName) == -1) {
			System.out.println("Contact Not Found!");
			System.out.println();
		}
		else {
			int index = searchByFullName(fullName);
			contacts.remove(index);
			System.out.println("Deleted Sucessfully");
			System.out.println();
		}
	}
	public void displayContacts() {
		if(contacts.isEmpty()) {
			System.out.println("No contact available!");
			System.out.println();
		}
		else {
			int i = 0;
			System.out.println();
			System.out.println("**************************************");
			System.out.println("Here is the List of all Contacts: ");
			for(Contact contact: contacts) {
				System.out.println("**************************************");
				System.out.println(i + 1 + ".");
				System.out.println("Fullname     : " + contact.getFirstName() + " " + contact.getMiddleName() + " " + contact.getLastName());
				System.out.println("Address      : " + contact.getAddress());
				System.out.println("Birthday     : " + contact.getBirthday());
				System.out.println("Sex          : " + contact.getSex());
				System.out.println("Email Address: " + contact.getEmailAddress());
				System.out.println("Number       : " + contact.getNumber());
				System.out.println("**************************************");
				System.out.println();	
				i++;
			}
		}
	}
	public void searchContact(String fullName) {
		if(searchByFullName(fullName)== -1) {
			System.out.println("Contact not found!");
		}
		else {
			int index = searchByFullName(fullName);
			Contact contact = contacts.get(index);
			displaySearchedContact(contact);
		}
	}
	public void saveContactsToFile(String filename) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
	        for (Contact contact : contacts) {
	            writer.println(
	                contact.getFirstName() + "/" +
	                contact.getMiddleName() + "/" +
	                contact.getLastName() + "/" +
	                contact.getAddress() + "/" +
	                contact.getBirthday() + "/" +
	                contact.getSex() + "/" +
	                contact.getEmailAddress() + "/" +
	                contact.getNumber()
	            );
	        }
	    } 
	    catch (IOException e) {
	        System.err.println("Error saving contacts to " + filename);
	        e.printStackTrace();
	    }
	}
	public void loadContactsFromFile(String filename) {
	    try {
	        File file = new File(filename);
	        if (!file.exists()) {
	            file.createNewFile();
	        }

	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split("/");
	                if (parts.length == 8) {
	                    Contact contact = new Contact(
	                        parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]
	                    );
	                    contacts.add(contact);
	                }
	            }
	        }
	    } catch (IOException e) {
	        System.err.println("Error loading contacts from " + filename);
	        e.printStackTrace();
	    }
	}
}
