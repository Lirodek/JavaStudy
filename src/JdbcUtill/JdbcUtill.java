package JdbcUtill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtill {
	public static Connection getConnection() {
		String protocol = "jdbc:mariadb://";
		String ip = "127.0.0.1";
		String port = "3306";
		String db = "Lirodek";
		String url = String.format("%s%s:%s/%s", protocol, ip, port, db);
		String user = "Lirodek0106";
		String password = "Lirodek";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
