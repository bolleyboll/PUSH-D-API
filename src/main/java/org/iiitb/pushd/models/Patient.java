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
@Table(name = "patients")
public class Patient {
	@Column(name = "adminID", unique = true, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientID;

	@Id
	@Column(name = "username", unique = true, length = 20, nullable = false)
	private String username;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "email", length = 100, unique = true, nullable = false)
	private String email;

	@JoinColumn(name = "doctorID")
	@ManyToOne
	private Doctor doctor;

	public Patient() {
	}

	public Patient(Integer patientID, String username, String password, String name, String email, Doctor doctor) {
		this.patientID = patientID;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.doctor = doctor;
	}

	public Integer getPatientID() {
		return patientID;
	}

	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Patient [doctor=" + doctor + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", patientID=" + patientID + ", username=" + username + "]";
	}

	
}