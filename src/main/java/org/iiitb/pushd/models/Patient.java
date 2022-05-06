package org.iiitb.pushd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
	@Column(name = "patientID", unique = true, nullable = false, updatable = false)
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

	@Column(name = "last_login", nullable = false)
	private Date lastLogin;

	@Column(name = "is_active", columnDefinition = "boolean default false")
	private Boolean isActive = false;

	@Column(name = "totalSections", columnDefinition = "varchar(100) default '1, 2, 3, 4, 5'")
	private String totalSections = "1, 2, 3, 4, 5";

	@Column(name = "sectionOrder", columnDefinition = "varchar(100) default '1, 2, 3, 4, 5'")
	private String sectionOrder = "1, 2, 3, 4, 5";

	

	@JoinColumn(name = "doctorID")
	@ManyToOne
	private Doctor doctor;
	
}