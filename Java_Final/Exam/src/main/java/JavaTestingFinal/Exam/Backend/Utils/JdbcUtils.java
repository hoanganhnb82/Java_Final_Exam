package JavaTestingFinal.Exam.Backend.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	private Connection connection;


	public void connectForTesting()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {

		String url = "jdbc:mysql://localhost:3306/FinalTestingJava?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "hoangdaika01";

		// Step 1: register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connect success!");
	}

	/**
	 * This method is used for connecting to database.
	 * 
	 */
	public Connection connect()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {

		String url = "jdbc:mysql://localhost:3306/FinalTestingJava?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "hoangdaika01";

		// Step 1: register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");


		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);

		return connection;
	}

	/**
	 * This method is used for closing database.
	 * 
	 */
	public void disconnect() throws SQLException {
		connection.close();
	}
}
