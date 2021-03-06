package JavaTestingFinal.Exam.Frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import JavaTestingFinal.Exam.Backend.Presentationlayer.ProjectController;
import JavaTestingFinal.Exam.Backend.Utils.ScannerUtils;
import JavaTestingFinal.Exam.Entites.User;


public class Function {
	private ProjectController projectController;
	
	public Function() {
		projectController = new ProjectController();
	}
	public void getListEmANDMa() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		System.out.println("Moi ban nhap ID du an ma ban muon: ");
		int id = ScannerUtils.inputPositiveInt("Ban phai nhap so nguyen duong!");
		List<User> lst = projectController.getListEmANDMa(id);
		System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password","Role");
		for (User user : lst) {
			System.out.printf("%-15s %-25s %-25s %-25s\n", user.getID(), user.getEmail(), user.getFullName(),
					"*********", user.getRole());
		}
	}
	public void getListManagerInProject() throws ClassNotFoundException, IOException, SQLException {
		List<User> lst = projectController.getListManagerInProject();
		System.out.println("Danh sach cac Manager trong Project:");
		System.out.printf("%-15s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password");
		for (User user : lst) {
			System.out.printf("%-15s %-25s %-25s %-25s\n", user.getID(), user.getEmail(), user.getFullName(),
					"*********");
		}
	}
	public void Login() {
		System.out.println("Moi ban nhap Email:");
		String email = ScannerUtils.inputEmail("Email phai bao gom @gmail.com");
		System.out.println("Moi ban nhap mat khau:");
		String pass = ScannerUtils.inputPassword("Pass phai co do dai tu 6 den 12 ki tu va gom it nhat 1 chu in hoa");
		try {
			User x = projectController.Login(email, pass);
			System.out.println(x);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
