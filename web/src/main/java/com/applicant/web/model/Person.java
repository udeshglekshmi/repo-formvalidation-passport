/**
* Create a web form(Applicant signup in passport website) 
*/ 
package com.applicant.web.model; 

import jakarta.persistence.*; 
import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity 
@Table(name="user_signup")
public class Person { 

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id; // Changed 'Id' to lowercase 'id' (Java naming convention)

	@NotBlank(message = "First name is required")
	@Column(nullable = false)
	private String firstname;

	@NotBlank(message = "Surname is required")
	@Column(nullable = false) 
	private String surname; 

	@NotBlank(message = "Gender is required")
	@Column(nullable = false)
	private String gender; 

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Column(nullable = false, unique = true)  
	private String email;

	@NotBlank(message = "Password is required")
	@Column(nullable = false) 
	private String password; // Should be hashed before storing in DB

	@Transient
	private String confirmPassword; // Won't be stored in DB

	@NotBlank(message = "Login ID is required")
	@Column(nullable = false, unique = true)  
	private String loginId; 

	@NotNull(message = "Date of birth is required")
	@Past(message = "Date of birth must be in the past")
	@Column(nullable = false) 
	// From Java 8+ @Temporal does not need to annotate with LocalDate
	private LocalDate dateOfBirth; 

	// Default Constructor
	public Person() {
	}

	// Parameterized Constructor
	public Person(long id, String firstname, String surname, String gender, String email, String password, String confirmPassword, String loginId, LocalDate dateOfBirth) {
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.loginId = loginId;
		this.dateOfBirth = dateOfBirth;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	// toString() Method
	@Override
	public String toString() {  
		
		return String.format(
        "Person{id=%d, firstname='%s', surname='%s', gender='%s', email='%s', loginId='%s', dateOfBirth=%tF}",
        id, firstname, surname, gender, email, loginId, dateOfBirth
    	); 
	}
}
