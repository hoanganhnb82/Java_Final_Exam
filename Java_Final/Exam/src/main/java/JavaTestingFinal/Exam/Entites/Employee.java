package JavaTestingFinal.Exam.Entites;

public class Employee extends User {
	private int projectID;
	private String proSkill;
	public Employee(int iD, String fullName, String email, String password, int projectID, String proSkill) {
		super(iD, fullName, email, password, Role.Employee);
		this.projectID = projectID;
		this.proSkill = proSkill;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getProSkill() {
		return proSkill;
	}
	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
	
}
