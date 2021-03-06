package JavaTestingFinal.Exam.Backend.Presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import JavaTestingFinal.Exam.Backend.Businesslayer.ProjectService;
import JavaTestingFinal.Exam.Entites.User;

public class ProjectController implements IProjectController{
	
	private ProjectService projectService;
	public ProjectController() {
		projectService = new ProjectService();
	}
	@Override
	public List<User> getListEmANDMa(int proid)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		return projectService.getListEmANDMa(proid);
	}
	@Override
	public List<User> getListManagerInProject() throws ClassNotFoundException, IOException, SQLException {
		
		return projectService.getListManagerInProject();
	}
	@Override
	public User Login(String email, String password)
			throws Exception {
		
		return projectService.Login(email, password);
	}



}
