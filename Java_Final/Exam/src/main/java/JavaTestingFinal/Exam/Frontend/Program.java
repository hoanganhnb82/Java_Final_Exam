package JavaTestingFinal.Exam.Frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;




public class Program {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Function x = new Function();
		x.getListEmANDMa();
		x.getListManagerInProject();
		x.Login();
	}

}
