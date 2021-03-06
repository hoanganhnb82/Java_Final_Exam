package JavaTestingFinal.Exam.Backend.Businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import JavaTestingFinal.Exam.Backend.Datalayer.ProjectRepository;
import JavaTestingFinal.Exam.Entites.User;

public class ProjectService implements IProjectService{
	private ProjectRepository projectRepository;
	
	public ProjectService() {
		projectRepository = new ProjectRepository();
	}
	@Override
	public List<User> getListEmANDMa(int proid)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return projectRepository.getListEmANDMa(proid);
	}
	@Override
	public List<User> getListManagerInProject() throws ClassNotFoundException, IOException, SQLException {
		
		return projectRepository.getListManagerInProject();
	}
	@Override
	public User Login(String email, String password)
			throws Exception {
		
		return projectRepository.Login(email, password);
	}

	

}
