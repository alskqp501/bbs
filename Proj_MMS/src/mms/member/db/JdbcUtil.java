package mms.member.db;

//1. DB관련 공통 기능 클래스 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	// 클래스가 로딩될 때 단 한번 호출되는 영역
	// Class.forName : 특정 클래스를 메모리로 로딩하는 메소드
	Connection con = null;
	Statement stmt = null;

	static { // 항상 메모리에 잇음
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버가 없습니다. ");
			}
		}

	public static Connection getConnection() {

		// 디비 작업에 필요한 Connection 객체를 생성해 주는 메소드
		String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(ur1, "javalink", "javalink");
			System.out.println("Connection Success!!!");
		} catch (SQLException e) {
	
		}
	}

	public static void close(Connection con) {

		try {

			con.close();

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

	}

	// transaction 처리 메소드
	public static void commit(Connection con) {
		try {
			con.commit(); //insert, update, delete 정상적으로 입력된 후 수행 
		} catch (SQLException e) {
			
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback(); //insert, update, delete 정상적으로 입력된 후 수행 
		} catch (SQLException e) {
			
		}
	}

}
