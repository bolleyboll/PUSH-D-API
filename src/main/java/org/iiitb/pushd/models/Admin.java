import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "admins")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminID;
	private String username;
	private String password;
	private String name;
	private String email;

	public Admin() {
	}

	public Admin(Integer adminID, String username, String password, String name, String email) {
		this.adminID = adminID;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public Integer getAdminID() {
		return adminID;
	}

	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
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

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", username=" + username + "]";
	}
}
