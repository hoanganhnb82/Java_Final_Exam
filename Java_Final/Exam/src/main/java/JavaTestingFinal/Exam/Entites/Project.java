package JavaTestingFinal.Exam.Entites;

public class Project {
	private int projectID;
	private int teamSize;
	private int idManager;
	private int [] idEmployees;
	public Project(int projectID, int teamSize, int idManager, int[] idEmployees) {
		super();
		this.projectID = projectID;
		this.teamSize = teamSize;
		this.idManager = idManager;
		this.idEmployees = idEmployees;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public int getIdManager() {
		return idManager;
	}
	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}
	public int[] getIdEmployees() {
		return idEmployees;
	}
	public void setIdEmployees(int[] idEmployees) {
		this.idEmployees = idEmployees;
	}
	
}
