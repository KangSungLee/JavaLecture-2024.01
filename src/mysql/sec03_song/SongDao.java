package mysql.sec03_song;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SongDao {
	private String connStr;
	private String user;
	private String password;
	private Connection conn;

	public SongDao() {
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

//	private Connection myConnection() { // 내부함수
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(connStr, user, password);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}

	public Song getSongById(int sid) {
		String sql = "select * from song where sid=?";
		Song song = new Song();
		try {
			// 파라메터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			
			// SQL 실행 후 결과를 ResultSet에 받기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				song.setSid(rs.getInt(1));
				song.setTitle(rs.getString(2));
				song.setLyrics(rs.getString(3));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return song;
	}

	public Song getSongByTitle(String title) {
		String sql = "select * from song where title like ?"; // 1번째
		Song song = null;
		try {
			// 파라메터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%"); // %별빛% - 제목에 별빛 검색

			// Select 실행하고 결과를 ResultSet으로 받기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return song;
	}
	
	public List<Song> getSongListAll() {
		String sql = "select * from song";
		List<Song> list = new ArrayList<Song>();
		try {
			Statement stmt = conn.createStatement(); // 조건값이 없을때
			// Select 실행하고 결과를 ResultSet으로 받기
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
//				Song song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
//				list.add(song);
				list.add(new Song(rs.getInt(1), rs.getString(2), rs.getString(3))); // 한줄
			}
			rs.close(); stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertSong(Song song) {
		String sql = "insert into song values(default, ?, ?)";
		try {
			// 파라메타 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, song.getTitle());
			pstmt.setString(2, song.getLyrics());

			// SQL 실행
			pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSong(Song song) {
		String sql = "UPDATE song SET title=?, lyrics=? where sid=?";
		try {
			// 파라메타 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, song.getTitle());
			pstmt.setString(2, song.getLyrics());
			pstmt.setInt(3, song.getSid());

			// SQL 실행
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSong(int sid) {
		String sql = "DELETE FROM song WHERE sid=?";
		try {
			// 파라메타 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);

			// SQL 실행
			pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
