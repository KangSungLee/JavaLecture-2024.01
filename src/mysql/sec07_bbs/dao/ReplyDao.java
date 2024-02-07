package mysql.sec07_bbs.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mysql.sec07_bbs.entity.Reply;

public class ReplyDao {
	private String connStr;
	private String user;
	private String password;
	private Connection conn;
	
	public ReplyDao() {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Reply getReply(int rid) {
		String sql = "select * from reply where rid=?";
		Reply reply = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rid);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				reply = new Reply(rs.getInt(1), rs.getString(2), LocalDateTime.parse(rs.getString(3).replace(" ", "T")), 
						rs.getString(4), rs.getInt(5));
			}
			rs.close(); pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reply;

	}
	
	public List<Reply> getReplyList(int bid) {
		String sql = "select * from reply where bid=?";
		List<Reply> list = new ArrayList<Reply>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getString(2), LocalDateTime.parse(rs.getString(3).replace(" ", "T")), 
						rs.getString(4), rs.getInt(5));
				list.add(reply);
			}
			rs.close(); pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertReply(Reply reply) {
		String sql = "insert users values (default, ?, default, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reply.getComment());
			pstmt.setString(2, reply.getUid());
			pstmt.setInt(3, reply.getBid());		
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
