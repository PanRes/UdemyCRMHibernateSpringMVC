package gr.pr.udemy.crm.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private int id;
	
	@Basic
	@Column(name = "first_name", length = 45)
	private String firstName;
	
	@Basic
	@Column(name = "last_name", length = 45)
	private String lastName;
	
	@Basic
	@Column(name = "email", length = 45)
	private String email;
	
	public Customer() {
	}
	
	public Customer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Customer)) return false;
		
		Customer customer = (Customer) o;
		
		if (getId() != customer.getId()) return false;
		if (getFirstName() != null ? !getFirstName().equals(customer.getFirstName()) : customer.getFirstName() != null)
			return false;
		if (getLastName() != null ? !getLastName().equals(customer.getLastName()) : customer.getLastName() != null)
			return false;
		return getEmail() != null ? getEmail().equals(customer.getEmail()) : customer.getEmail() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
		result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
		result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
