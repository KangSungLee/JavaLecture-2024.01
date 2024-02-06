package mysql.sec05_message;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MessageDao {
	private String connStr;
	private String user;
	private String password;
	private Connection conn;

	public MessageDao() {
		String path = "C:/Workspace/Java/lesson/src/mysql/mysql.properties";
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(path));
			String host = prop.getProperty("host");
			String port = prop.getProperty("port");
			String database = prop.getProperty("database");
			this.connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
			this.user = prop.getProperty("user");
			this.password = prop.getProperty("password");
			this.conn = DriverManager.getConnection(connStr, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Message getMessageByMid(int mid) {
		String sql = "select * from message where mid=?";
		Message msg = new Message();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				msg.setMid(rs.getInt(1));
				msg.setContent(rs.getString(2));
				msg.setWriter(rs.getString(3));
				String modTime = rs.getString(4);	// 2024-02-06T16:45:00.5
				msg.setModTime(LocalDateTime.parse(modTime.replace(" ", "T")));
//				String timeStr = rs.getString(4);
//	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//	            LocalDateTime modTime = LocalDateTime.parse(timeStr, formatter);
//	            msg.setModTime(modTime);
				msg.setIsDeleted(rs.getInt(5));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public List<Message> getMessageListByWriter(String writer) {
		String sql = "SELECT * FROM message WHERE writer like ? and isDeleted=0";
		List<Message> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
//				String timeStr = rs.getString(4);
//	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//	            LocalDateTime modTime = LocalDateTime.parse(timeStr, formatter);
				list.add(new Message(rs.getInt(1), rs.getString(2), rs.getString(3), LocalDateTime.parse(rs.getString(4).replace(" ", "T")), rs.getInt(5)));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertMessage(Message msg) {
		String sql ="insert into message values(default, ?, ?, default, default)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, msg.getContent());
			pstmt.setString(2, msg.getWriter());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateMessage(Message msg) {
		String sql ="update message set content=?, writer=?, modTime=now() where mid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, msg.getContent());
			pstmt.setString(2, msg.getWriter());
			pstmt.setInt(3, msg.getMid());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMessage(int mid) {
		String sql ="update message set isDeleted=1 where mid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
