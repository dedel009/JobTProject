package com.jobT.web.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jobT.web.DTO.board;
import com.jobT.web.DTO.member;
import com.jobT.web.DTO.notice;
import com.jobT.web.connection.ConnectionProvider;
import com.jobT.web.connection.jdbcUtil;

public class jobtService {
	private static jobtService instance = new jobtService();


	public static jobtService getInstance() {
		return instance;
	}
	
	
	// 회원가입 관련 메소드

	public int createNaverMember(String id, String name, String nickname) {
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			String pass  = "1234";
			String category = "N";
			String sql = "insert into member(id, password, name, nickname,category) values(?, ?, ?, ?,?)";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			psmt.setString(3, name);
			psmt.setString(4, nickname);
			psmt.setString(5, category);
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
	
	
	public int createMember(member member) {
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
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
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
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
		Connection conn = null;
		PreparedStatement psmt = null;
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
	public int detailNoticeUpdate(String title, String content, String num) {
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			String sql = "update notice set title=?, content=? where num = ?";
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
		Connection conn = null;
		PreparedStatement psmt = null;
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
	public int detailNoticeDelete(String num) {
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			String sql = "update notice set flag = 'F' where num = ?";
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
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
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
		Connection conn = null;
		PreparedStatement psmt = null;

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
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
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
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
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
	public List<board> getList(int page) {
		List<board> list = new ArrayList<board>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		int start = 1 + (page - 1) * 7; //0 7 14 
		int end = page * 7; // 5 10 15 20 .....
		
		try {
//			 String sql ="	Select * "
//			 			+ "		from (Select @rownum:=@rownum+1 as seq , n.* "
//			 			+ "			from(select * from board where flag='Y' order by regdate desc)n "
//			 			+ "		        Where (@rownum:=0)=0)ns "
//			 			+ "                Where ns.seq between 1 and 10";
			
//			String sql  = "	select * "
//						+ "				 from (select (@rownum := @rownum + 1)seq, board.* "
//						+ "					 from(select * from board "
//						+ "						   where flag='Y'"
//						+ "						   order by regdate desc)board)rnum,"
//						+ "                           (select @rownum := 0)tmp"
//						+ "							 limit ?, 7";
			
			String sql = "select ns.*"
							+ "				 from (select @rownum:=@rownum+1 as seq , n.*"
							+ "						 from(select @rownum:=0)tmp,"
							+ "                         (select * "
							+ "						From board "
							+ "						   where flag='Y' "
							+ "					   order by regdate desc)n)ns "
							+ "				Where ns.seq between ? and ?";
			
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, start);
			psmt.setInt(2, end);
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
	public int getCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(NUM) as count from board where flag = 'Y'";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
			jdbcUtil.close(rs);
		}
		return count;
	}

	public List<board> getSearchList(int page, String field, String query) {	//검색했을 때 리스트
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<board> list = new ArrayList<board>();
		

		//paging 번호
		int start = 1 + (page - 1) * 7; 
		int end = page * 7; 
		
		String sql="";
		//닉네임 으로 검색
		if(field.equals("nickname")) {
			sql 	= "           SELECT rn.* "
					+ "					FROM(SELECT @rownum:=@rownum+1 as rownum , ex.*"
					+ "					   FROM(SELECT @rownum:=0)tmp,"
					+ "                       (SELECT *"
					+ "					  FROM board"
					+ "				    WHERE flag ='Y'"
					+ "					 and nickname like ?)ex)rn"
					+ "                     WHERE rn.rownum between ? and ?;";
		   //TITLE 로 검색
		}else if (field.equals("title")) {
				sql    = "           SELECT rn.* "
						+ "					FROM(SELECT @rownum:=@rownum+1 as rownum , ex.*"
						+ "					   FROM(SELECT @rownum:=0)tmp,"
						+ "                       (SELECT *"
						+ "					  FROM board"
						+ "				    WHERE flag ='Y'"
						+ "					 and title like ?)ex)rn"
						+ "				WHERE rn.rownum between ? and ?";
		}
		
		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+query+"%");
			psmt.setInt(2, start);
			psmt.setInt(3, end);
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

	public int getSearchCount(String field, String query) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;

		
		String sql="";
		//닉네임 으로 검색
		if(field.equals("nickname")) {
			sql 	= "           SELECT count(rn.rownum) as count "
					+ "					FROM(SELECT @rownum:=@rownum+1 as rownum , ex.*"
					+ "					   FROM(SELECT @rownum:=0)tmp,"
					+ "                       (SELECT *"
					+ "					  FROM board"
					+ "				    WHERE flag ='Y'"
					+ "					 and nickname like ?)ex)rn ";
		   //TITLE 로 검색
		}else if (field.equals("title")) {
				sql    = "        SELECT count(rn.rownum) as count "
						+ "					FROM(SELECT @rownum:=@rownum+1 as rownum , ex.*"
						+ "					   FROM(SELECT @rownum:=0)tmp,"
						+ "                       (SELECT *"
						+ "					  FROM board"
						+ "				    WHERE flag ='Y'"
						+ "					 and title like ?)ex)rn ";
		}
		
		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+query+"%");
			rs = psmt.executeQuery();
			
			if (rs.next()) {
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
	public List<notice> getBoardNoticeList(String tag_name) {
		List<notice> list = new ArrayList<notice>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from notice where tag like ?";
			
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+tag_name+"%");
			rs = psmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("NUM");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Date regdate = rs.getTimestamp("REGDATE");
				String nickname = rs.getString("NICKNAME");
				String tag = rs.getString("TAG");

				notice nt = new notice(num, title, content, regdate, nickname, tag);
				list.add(nt);
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
	
	
	//notice 관련 메소드
	public List<notice> getNoticeList(int page) {
		List<notice> list = new ArrayList<notice>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		int start = 1 + (page - 1) * 7; //0 7 14 
		int end = page * 7; // 5 10 15 20 .....
		
		try {
			
			String sql = "select ns.*"
							+ "				 from (select @rownum:=@rownum+1 as seq , n.*"
							+ "						 from(select @rownum:=0)tmp,"
							+ "                         (select * "
							+ "						From notice "
							+ "						   where flag='Y')n)ns "
							+ "				Where ns.seq between ? and ?";
			
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, start);
			psmt.setInt(2, end);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("NUM");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Date regdate = rs.getTimestamp("REGDATE");
				String nickname = rs.getString("NICKNAME");
				String tag = rs.getString("TAG");

				notice nt = new notice(num, title, content, regdate, nickname, tag);
				list.add(nt);
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
	
	public int getNoticeCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(NUM) as count from notice where flag = 'Y'";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
			jdbcUtil.close(rs);
		}
		return count;
	}


	public notice getNoticeDetail(String num) {	//세부 공지사항
		notice nt = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from notice where num = ?";
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
				String tag = rs.getString("TAG");
				nt = new notice(Integer.parseInt(db_num), title, content, regdate, nickname, tag);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}

		return nt;
	}

	//통합검색
	public List<board> getTotalSearch(int page, String query) {
		List<board> list = new ArrayList<board>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		int start = 1 + (page - 1) * 7; //0 7 14 
		int end = page * 7; // 5 10 15 20 .....
		
		try {
			
			String sql = " select ns.*"
					+ "                from (select @rownum:=@rownum+1 as seq , n.*"
					+ "                   from(select @rownum:=0)tmp,"
					+ "                       (select num,title,content,regdate,nickname,tag "
					+ "                                from board where title like ? union "
					+ "                        select num,title,content,regdate,nickname,tag "
					+ "                                 from notice where title like ? order by REGDATE)n)ns "
					+ "                     Where seq between ? and ?";
			
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+query+"%");
			psmt.setString(2, "%"+query+"%");
			psmt.setInt(3, start);
			psmt.setInt(4, end);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("NUM");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Date regdate = rs.getTimestamp("REGDATE");
				String nickname = rs.getString("NICKNAME");
				String tag= rs.getString("TAG");
				
				board board = new board(num, title, content, regdate, nickname, tag);
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


	public int getTotalSearchCount(String query) {
		int count = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			String sql  = "     select count(seq) as count"
						+ "                from (select @rownum:=@rownum+1 as seq , n.*"
						+ "                   from(select @rownum:=0)tmp,"
						+ "                       (select num,title,content,regdate,nickname,tag "
						+ "                             from board where title like ? union "
						+ "                         select num,title,content,regdate,nickname,tag "
						+ "                              from notice where title like ? order by REGDATE)n)ns ";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+query+"%");
			psmt.setString(2, "%"+query+"%");
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
			jdbcUtil.close(rs);
		}
		return count;
	}

}
