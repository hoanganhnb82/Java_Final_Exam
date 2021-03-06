package JavaTestingFinal.Exam.Entites;

public class Manager extends User  {
	private int ExpInYear;

	public Manager(int iD, String fullName, String email, String password, int expInYear) {
		super(iD, fullName, email, password, Role.Manager);
		ExpInYear = expInYear;
	}

	public int getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}


	
}
