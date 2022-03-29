public class Specialist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer specID;
	private String username;
	private String password;
	private String name;
	private String email;

	public Specialist() {
	}

	public Specialist(Integer specID, String username, String password, String name, String email) {
		this.specID = specID;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public Integer getSpecID() {
		return specID;
	}

	public void setSpecID(Integer specID) {
		this.specID = specID;
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
		return "Specialist [email=" + email + ", name=" + name + ", password=" + password + ", specID=" + specID
				+ ", username=" + username + "]";
	}

	
	

	


	

	

	

	

	

	

	

	

	

	

	

