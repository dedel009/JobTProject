package com.jobT.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jobT.web.DTO.board;
import com.jobT.web.DTO.member;
import com.jobT.web.connection.ConnectionProvider;
import com.jobT.web.connection.jdbcUtil;

public class jobtService {
	private static jobtService instance = new jobtService();
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	public static jobtService getInstance() {
		return instance;
	}

	// 회원가입 관련 메소드
	public int createMember(member member) {
		int result = 0;
		try {
			String sql = "insert into member(id, password, name, nickname) values(?, ?, ?, ?)";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPassword());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getNickname());
			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return result;
	
	}
	
	public int idCheck(String id) { // id 중복체크
		int result = 0;
		try {
			String sql = "select count(id) as count from member where id=?";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				String count = rs.getString("count");
				result = Integer.parseInt(count);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return result;
	}

	// update 관련 메소드
	public int detailUpdate(String title, String content, String num) {
		int result = 0;
		try {
			String sql = "update board set title=?, content=? where num = ?";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setString(3, num);

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return result;
	}

	// delete 관련 메소드
	public int detailDelete(String num) {
		int result = 0;
		try {
			String sql = "update board set flag = 'F' where num = ?";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, num);
			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return result;
	}

	// detail 관련 메소드
	public board getDetail(String num) {
		board board = null;

		try {
			String sql = "select * from board where num = ?";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, num);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String db_num = rs.getString("NUM");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Date regdate = rs.getTimestamp("REGDATE");
				String nickname = rs.getString("NICKNAME");

				board = new board(Integer.parseInt(db_num), title, content, regdate, nickname);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}

		return board;
	}

	// insert관련 메소드
	public int insertList(String title, String content, String nickname) {

		int result = 0;
		try {
			String sql = "insert into board (title, content, nickname) values(?, ?, ?)";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setString(3, nickname);
			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}

		return result;
	}

	// login 관련 메소드
	public String getNickname(String id) { // 세션에 등록할 nickname 가져오는 메소드
		String nickname = "";
		try {
			String sql = "select nickname from member where id = ?";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				nickname = rs.getString("nickname");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return nickname;
	}

	public int login(String id, String pass) {
		try {
			String sql = "select password from member where id = ?";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("password").equals(pass)) { // id와 password가 같으면
					return 1;
				} else { // 다르면
					return 0;
				}
			}
			return -1; // 접속오류
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return -2; // db오류
	}

	// board관련 메소드
	public List<board> getList() {
		List<board> list = new ArrayList<board>();
		String sql = "select * from board where flag ='Y'";
		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("NUM");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Date regdate = rs.getTimestamp("REGDATE");
				String nickname = rs.getString("NICKNAME");

				board board = new board(num, title, content, regdate, nickname);
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return list;
	}

}
