package PersonAadharDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;

	@Column(unique = true, nullable = false)
	private long phone;

	@OneToOne(mappedBy = "person")
	@JoinColumn(name = "Aadhar_Id")
	private Aadhar aadhar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Aadhar getAadhar() {
		return aadhar;
	}

	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}

}
