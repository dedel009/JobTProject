package com.jobT.web.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jobT.web.DTO.commentDTO;
import com.jobT.web.DTO.imgBoard;
import com.jobT.web.connection.ConnectionProvider;
import com.jobT.web.connection.jdbcUtil;

public class imgContentDAO {
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private static imgContentDAO instance = new imgContentDAO();
	
	public static imgContentDAO getInstance() {
		return instance;
	}
	
	public float getAvgScore(String id) {
		float avg_result = 0;
		String sql = "select avg(score) as avg from imgcomment where id = ?";
		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				avg_result = rs.getFloat("avg");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		
		return avg_result;
	}
	
	public int insertComment(commentDTO cd) {
		int result = 0;
		String sql = "insert into imgcomment (id, comment, score, userID) values(?, ?, ?, ?)";
		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cd.getId());
			psmt.setString(2, cd.getComment());
			psmt.setInt(3, cd.getScore());
			psmt.setString(4, cd.getUserID());
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
	
	
	public int getCommentCount(String id) {
		int count = 0;
		String sql = "select count(wid) as count from imgcomment where id = ?";
		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		
		return count;
	}
	
	public List<commentDTO> getCommentList(String id) {
		List<commentDTO> list = new ArrayList<commentDTO>();
		String sql = "select * from imgcomment where id = ?";
		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				int wid = rs.getInt("wid");
				String id_db = rs.getString("id");
				String comment = rs.getString("comment");
				int score = rs.getInt("score");
				Date regdate = rs.getTimestamp("regdate");
				String userID = rs.getString("userID");
				String delFlag = rs.getString("delFlag");
				commentDTO cd = new commentDTO(wid, id_db, comment, score, regdate, userID, delFlag);
				list.add(cd);
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
	
	public imgBoard getImgDetail(String id) {
		imgBoard ib = new imgBoard();
		String sql = "select * from imgcontent where id = ?";
		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				String id_db = rs.getString("id");
				String name = rs.getString("name");
				String content = rs.getString("content");
				String category = rs.getString("category");
				int price = rs.getInt("price");
				Date regdate = rs.getTimestamp("regdate");
				String delFlag = rs.getString("delFlag");
				String path = rs.getString("path");

				ib = new imgBoard(id_db, name, content, category, price, regdate, delFlag, path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return ib;
	}
	
	public List<imgBoard> getImgList(){
		List<imgBoard> list = new ArrayList<imgBoard>();
		String sql = "select * from imgcontent";
		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String content = rs.getString("content");
				String category = rs.getString("category");
				int price = rs.getInt("price");
				Date regdate = rs.getTimestamp("regdate");
				String delFlag = rs.getString("delFlag");
				String path = rs.getString("path");

				imgBoard ib = new imgBoard(id, name, content, category, price, regdate, delFlag, path);
				list.add(ib);
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
