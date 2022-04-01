package org.iiitb.pushd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {
	@Column(name = "doctorID", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer doctorID;

	@Id
	@Column(name = "username", unique = true, length = 20, nullable = false)
	private String username;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "email", length = 100, unique = true, nullable = false)
	private String email;

	@JoinColumn(name = "specID")
	@ManyToOne
	private Specialist specialist;

	public Doctor() {
	}

	public Doctor(Integer doctorID, String username, String password, String name, String email) {
		this.doctorID = doctorID;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public Integer getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(Integer doctorID) {
		this.doctorID = doctorID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Specialist getSpecialist() {
		return specialist;
	}

	public void setSpecialist(Specialist specialist) {
		this.specialist = specialist;
	}

	@Override
	public String toString() {
		return "Doctor [doctorID=" + doctorID + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", specialist=" + specialist + ", username=" + username + "]";
	}
}