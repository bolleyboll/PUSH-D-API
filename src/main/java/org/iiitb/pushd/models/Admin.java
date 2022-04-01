package org.iiitb.pushd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admins")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	@Column(name = "adminID", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminID;

	@Id
	@Column(name = "username", unique = true, length = 20, nullable = false)
	private String username;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "email", length = 100, unique = true, nullable = false)
	private String email;

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", username=" + username + "]";
	}
}
