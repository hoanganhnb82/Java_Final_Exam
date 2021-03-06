package JavaTestingFinal.Exam.Entites;

public class User implements Comparable<User>{
	private int ID;
	private String FullName;
	private String Email;
	private String Password;
	private Role role;
	public User(int iD, String fullName, String email, String password, Role role) {
		super();
		ID = iD;
		FullName = fullName;
		Email = email;
		Password = password;
		this.role = role;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public int compareTo(User o) {
		if(this.getID() == o.getID() && this.getRole().equals(o.getRole())) {
			return 1;
		}
		return 0;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", FullName=" + FullName + ", Email=" + Email + ", Password=" + Password + ", role="
				+ role + "]";
	}
	
	
}
