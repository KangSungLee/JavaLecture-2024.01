package mysql.sec01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Ex01_Select {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world",
					// jdbc:myspl:(프로토콜) localhost(로컬호스트) 3306(포트번호) world(DB파일이름)
					// 포트번호는 자바나 톰켓같은 프로그램에 따라 다르다
						"hmuser", "hmpass"
					);
			stmt = conn.createStatement();
			String sql = "select * from city where countrycode='KOR' limit 10";
			
			// Select 실행후 결과를 ResultSet에 받기
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");	// rs.getInt("ID") sql은 1번부터
				String name = rs.getString(2);
				String countryCode = rs.getString(3);
				String district = rs.getString(4);
				int population = rs.getInt(5);
				System.out.println(id + ", " + name + ", " + countryCode + ", " + district + ", " + population);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
