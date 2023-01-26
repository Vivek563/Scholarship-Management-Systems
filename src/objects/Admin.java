package objects;



public class Admin extends User{
	
	
	public Admin(int ucid, String email, String password, String name) {
		super(ucid, email, password, name);
	}
	
	@Override
	public String toString() {
		return getUCID()+","+getEmail()+","+getPassword()+","+getName();
	}
	
}
