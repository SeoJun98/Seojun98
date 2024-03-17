package proj.dao;

import db.HJDBC;
import proj.sql.BoardSQL;
import proj.sql.MemberSQL;
import proj.vo.*;

import java.sql.*;
import java.util.*;
import java.util.Date;
public class MemberDao {
	private HJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;

	public MemberDao() {
		db = new HJDBC();
		
	}

	public ArrayList<String> getIdList(){
		ArrayList<String> list = new ArrayList<String>();
		con = db.getCon();
		sql = MemberSQL.getMSQL(MemberSQL.SEL_ALL_ID);
		stmt = db.getStmt(con);

		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				list.add(id);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}

	public ArrayList<MemberVO> getAllMemb(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		con = db.getCon();
		sql = BoardSQL.getSQL(MemberSQL.SEL_ALL_MEMB);
		stmt = db.getStmt(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MemberVO vo = new MemberVO();

				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String id = rs.getString("id");
				Date wdate = rs.getDate("wdate");
				Time wtime = rs.getTime("wdate");
				int views = rs.getInt("views");

				vo.setBno(bno);
				vo.setTitle(title);
				vo.setId(id);
				vo.setWdate(wdate);
				vo.setWtime(wtime);
				vo.setSdate();
				vo.setViews(views);

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}

		// 리스트 반환하고
		return list;
	}

}
