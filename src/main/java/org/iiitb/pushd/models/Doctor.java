import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer doctorID;
	private String username;
	private String password;
	private String name;
	private String email;
	private String specID;


	public Doctor() {
	}
	
	public Doctor(Integer doctorID, String username, String password, String name, String email, String specID) {
		this.doctorID = doctorID;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.specID = specID;
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

	public String getSpecID() {
		return specID;
	}

	public void setSpecID(String specID) {
		this.specID = specID;
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

	@Override
	public String toString() {
		return "Doctor [doctorID=" + doctorID + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", specID=" + specID + ", username=" + username + "]";
	}

	

}
