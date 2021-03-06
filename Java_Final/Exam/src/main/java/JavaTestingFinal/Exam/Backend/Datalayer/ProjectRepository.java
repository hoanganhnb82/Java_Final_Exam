package JavaTestingFinal.Exam.Backend.Datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaTestingFinal.Exam.Backend.Utils.JdbcUtils;
import JavaTestingFinal.Exam.Entites.Employee;
import JavaTestingFinal.Exam.Entites.Manager;
import JavaTestingFinal.Exam.Entites.User;


public class ProjectRepository implements IProjectRepository {
	private Connection connection;
	private JdbcUtils jdbcUtils;
	
	public ProjectRepository() {
		
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public List<User> getListEmANDMa(int proid) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException{
		List<User> lst = new ArrayList<>();
		connection = jdbcUtils.connect();
		String sql = "SELECT t1.IDManager,t1.IDEmployee, ManName, EmpName, ManEmail, EmEmail, EmPassword, ManPassword, t1.ProjectID, ProSkill, ExpInYear "+
					 "FROM Project t1 " +
					 "JOIN Manager t2 ON t1.IDManager=t2.IDManager "+
					 "JOIN Employee t3 ON t1.IDEmployee=t3.IDEmployee "+
					 "WHERE t1.ProjectID= ?";
		PreparedStatement pre = connection.prepareStatement(sql);
		pre.setInt(1, proid);
		ResultSet res = pre.executeQuery();
		boolean ok = false;
		while(res.next()) {
			int idem = res.getInt("IDEmployee");
			int idman = res.getInt("IDManager");
			
			String manName = res.getString("ManName");
			String empName = res.getString("EmpName");
			String manEmail = res.getString("ManEmail");
			String emEmail = res.getString("EmEmail");
			String emPassword = res.getString("EmPassword");
			String manPassword = res.getString("ManPassword");
			
			int projectID = res.getInt("ProjectID");
			String projectSkill = res.getString("ProSkill");
			int exp = res.getInt("ExpInYear");
			
			User x = new Manager(idman,manName,manEmail,manPassword,exp);
			User y = new Employee(idem,empName,emEmail,emPassword,projectID,projectSkill);
			lst.add(y);
			
			while(!ok) {
				lst.add(x);
				ok=true;
			}
			
		}
		jdbcUtils.disconnect();
		return lst;
	}

	@Override
	public List<User> getListManagerInProject() throws ClassNotFoundException, IOException, SQLException {
		List<User> lst = new ArrayList<>();
		connection = jdbcUtils.connect();
		String sql = "SELECT DISTINCT t1.IDManager, ManName, ManEmail, ManPassword, ExpInYear "+
					 "FROM Project t1 " +
					 "JOIN Manager t2 ON t1.IDManager=t2.IDManager ";
		Statement statement = connection.createStatement();
	
		ResultSet res = statement.executeQuery(sql);
		while(res.next()) {
			
			int idman = res.getInt("IDManager");
			String manName = res.getString("ManName");
			String manEmail = res.getString("ManEmail");
			String manPassword = res.getString("ManPassword");
			int exp = res.getInt("ExpInYear");
			
			User x = new Manager(idman,manName,manEmail,manPassword,exp);
			lst.add(x);
		}
		jdbcUtils.disconnect();
		return lst;
	}

	@SuppressWarnings("unused")
	@Override
	public User Login(String email, String password) 
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException,Exception {
		User x = null;
		connection = jdbcUtils.connect();
		String sql1 = "SELECT DISTINCT t1.IDManager, ManName, ManEmail, ManPassword,  ExpInYear "+
				 	 "FROM Project t1 "+
				 	 "JOIN Manager t2 ON t1.IDManager=t2.IDManager "+
				 	 "WHERE ManEmail like ? AND ManPassword like ? ";
		
		String sql2 = "SELECT DISTINCT t1.IDEmployee, EmpName, EmEmail, EmPassword, t1.ProjectID, ProSkill "+
					  "FROM Project t1 "+
					  "JOIN Employee t2 ON t1.IDEmployee=t2.IDEmployee "+
					  "WHERE EmEmail like ? AND EmPassword like ? ";
		
		PreparedStatement pre1 = connection.prepareStatement(sql1);
		
		pre1.setString(1, email);
		pre1.setString(2, password);
		
		ResultSet res1 = pre1.executeQuery();
		
		if(res1.next()) {
			int idman = res1.getInt("IDManager");
			String manName = res1.getString("ManName");
			String manPassword = res1.getString("ManPassword");
			int exp = res1.getInt("ExpInYear");
			String manEmail = res1.getString("ManEmail");
			x = new Manager(idman,manName,manEmail,manPassword,exp);
			System.out.println("Dang nhap thanh cong duoi tai khoan Manager!");
		}
		PreparedStatement pre2 = connection.prepareStatement(sql2);
		pre2.setString(1, email);
		pre2.setString(2, password);
		ResultSet res2 = pre2.executeQuery();
		if(res2.next()) {
			int idem = res2.getInt("IDEmployee");
			String empName = res2.getString("EmpName");
			String emEmail = res2.getString("EmEmail");
			String emPassword = res2.getString("EmPassword");
			int projectID = res2.getInt("ProjectID");
			String projectSkill = res2.getString("ProSkill");
			x = new Employee(idem,empName,emEmail,emPassword,projectID,projectSkill);
			System.out.println("Dang nhap thanh cong duoi tai khoan Employee!");
		}
		if(x==null)
			throw new Exception("Tai khoan hoac mat khau sai!");

	
		jdbcUtils.disconnect();
		return x;
	}

}
