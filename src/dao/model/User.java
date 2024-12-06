package dao.model;

public class User {
	private String firstName;
	private String lastName;
	private int age;
	private String country;
	private String city;
	private String username;
	private final String email;
	private String password;
	private String phoneNumber;
	
	public User(
		String firstName, String lastName, int age, String country, String city,
		String username, String email, String password, String phoneNumber
	) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.country = country;
		this.city = city;
		this.username = username;
		this.email = email.toLowerCase();
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return ("""
		User {
			firstName: '%s',
			lastName: '%s',
			age: %d,
			country: '%s',
			city: '%s',
			username: '%s',
			email: '%s',
			phoneNumber: '%s'
		}""").formatted(firstName, lastName, age, country, city,
			username, email, phoneNumber
		);
	}
}