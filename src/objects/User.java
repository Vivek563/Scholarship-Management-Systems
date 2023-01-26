package objects;



public class User {
	
	
	private String name;
	private String email;
	private String password;
	private int ucid;
	
	
	public User(int ucid, String email, String password, String name) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.ucid = ucid;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUCID() {
		return ucid;
	}

}
