package JavaTestingFinal.Exam.Backend.Presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import JavaTestingFinal.Exam.Entites.User;

public interface IProjectController {
	public List<User> getListEmANDMa(int proid) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	public List<User> getListManagerInProject() throws ClassNotFoundException, IOException, SQLException;
	public User Login(String email, String password) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException, Exception;

}
