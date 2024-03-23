package dao;

import java.util.List;

import util.JDBCUtil;
import vo.AdminVo;
import vo.MemberVo;

public class AdminDao {
	private static AdminDao instance = null;

	private AdminDao() {

	}

	public static AdminDao getInstance() {

		if (instance == null) {
			instance = new AdminDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public AdminVo loginCheck(List<Object> param){
		String sql = "select *\r\n" + 
				"from ADMIN\r\n" + 
				"where ad_id = ? and\r\n" + 
				"ad_pass = ?";
		
		return jdbc.selectOne(sql, param, AdminVo.class);
		
	}
	public void bookUpdate(int sel, List<Object> param) {
		String sql = "UPDATE BOOK "
					+ " SET";
		if(sel==1 || sel==2) {
			sql+=" BOOK_NAME = ? ";
			if(sel ==1) sql+= ",";
		}
		if(sel==1 || sel==3) {
			sql+=" BOOK_TYPE = ? ";
			if(sel ==1) sql+= ",";
		}
		if(sel==1 || sel==4) {
			sql+=" BOOK_QTY = ? ";
		}
		sql+= " WHERE BOOK_NO = ? ";
		jdbc.update(sql, param);
	}

	public void bookInsert(List<Object> param) {
		String sql = "INSERT INTO BOOK (BOOK_NO, BOOK_NAME, BOOK_TYPE, BOOK_QTY) \r\n" + 
				"    VALUES('B'||?||LPAD(SEQ_BOOK.NEXTVAL, 4, 0), ?, ?, ?)";
		jdbc.update(sql, param);
	}

	public void bookDelete(List<Object> param) {
		String sql = "DELETE \r\n" + 
				"    FROM BOOK\r\n" + 
				"    WHERE BOOK_NO = ?";
		jdbc.update(sql, param);
		
	}

	public List<MemberVo> memberSearch(List<Object> param) {
		String sql = "SELECT MEM_NO, MEM_NAME, MEM_ID, MEM_PASS, MEM_TEL, MEM_ADDR, MEM_REGNO, MEM_DATE\r\n" + 
				"    FROM MEMBER\r\n" + 
				"    WHERE MEM_NAME LIKE '%'||?||'%'";
		return jdbc.selectList(sql, param, MemberVo.class);
	}
	
	public void memberUpdate(int sel, List<Object> param) {
		String sql = "UPDATE MEMBER "
					+ " SET";
		if(sel==1 || sel==2) {
			sql+=" MEM_PASS = ? ";
			if(sel ==1) sql+= ",";
		}
		if(sel==1 || sel==3) {
			sql+=" MEM_TEL = ? ";
			if(sel ==1) sql+= ",";
		}
		if(sel==1 || sel==4) {
			sql+=" MEM_ADDR = ? ";
			if(sel ==1) sql+= ",";
		}
		if(sel==1 || sel==5) {
			sql+=" MEM_NAME = ? ";
		}
		sql+= " WHERE MEM_ID = ? ";
		jdbc.update(sql, param);
	}

	public void memberDelete(List<Object> param) {
		String sql = "DELETE\r\n" + 
				"    FROM MEMBER\r\n" + 
				"    WHERE MEM_ID = ?";
		jdbc.update(sql, param);
	}

	public int reviewBlind(List<Object> param) {
		String sql = "UPDATE REVIEW\r\n" + 
				"SET REVIEW_BLIND = 'Y'\r\n" + 
				"WHERE REVIEW_NO = ?";
		return jdbc.update(sql, param);
		
	}
}
