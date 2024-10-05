public class Contact {
	private String firstName, middleName, lastName;
	private String address, birthday ,sex, emailAddress;
	private String number;
	
	public Contact(String firstName, String middleName, String lastName, String address, String birthday, String sex, 
			String emailAddress, String number) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.birthday = birthday;
		this.sex = sex;
		this.emailAddress = emailAddress;
		this.number = number;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getSex() {
		return sex;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getNumber() {
		return number;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}

