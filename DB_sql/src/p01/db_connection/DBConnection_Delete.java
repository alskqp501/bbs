package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection_Delete {

	public static void main(String[] args) {
		// DELETE goodsinfo  where code = '10005';

		 
		 Connection conn = null;
			Statement stmt = null;
			try {
				//Class.forName("java.lang.String);
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
				
					conn = DriverManager.getConnection(ur1,"javalink","javalink");
					stmt = conn.createStatement();
					
					String query = "DELETE goodsinfo  where code = '10005'";
					int	resulte = stmt.executeUpdate(query);
					if(resulte > 0) {
						System.out.println("데이터가 삭제되었습니다.");
					}else {
						System.out.println("데이터가 입력되지 않았습니다.");
					}
					
			} catch (ClassNotFoundException e) {
				System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");
			
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("정상종료"); // 항상 실행 
			try {
				conn.close();
			} catch (SQLException e) {
				
			}

	}

}
