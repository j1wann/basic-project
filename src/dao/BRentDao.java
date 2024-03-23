package dao;

import java.util.List;

import util.JDBCUtil;
import vo.BRentVo;

public class BRentDao {
	private static BRentDao instance = null;

	private BRentDao() {

	}

	public static BRentDao getInstance() {

		if (instance == null) {
			instance = new BRentDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<BRentVo> myRentList(List<Object> param) {
		String sql = "SELECT R.BRENT_NO, B.BOOK_NO, B.BOOK_NAME, R.BRENT_RENDATE, R.BRENT_PREDATE, R.BRENT_ENDDATE, M.MEM_ID\r\n" + 
				"    FROM BOOK B, BOOKRENT R, MEMBER M\r\n" + 
				"    WHERE B.BOOK_NO = R.BOOK_NO AND R.MEM_NO = M.MEM_NO \r\n" + 
				"    AND M.MEM_ID = ?";
		return jdbc.selectList(sql, param, BRentVo.class);
	}
	
	public List<BRentVo> rentList(){
		String sql = "SELECT R.BRENT_NO, B.BOOK_NO, B.BOOK_NAME, R.BRENT_RENDATE, R.BRENT_PREDATE, R.BRENT_ENDDATE, M.MEM_ID\r\n" + 
				"    FROM BOOK B, BOOKRENT R, MEMBER M\r\n" + 
				"    WHERE B.BOOK_NO = R.BOOK_NO AND R.MEM_NO = M.MEM_NO \r\n";
		return jdbc.selectList(sql, BRentVo.class);
	}

	public void rentEx(List<Object> param) {
		String sql = "UPDATE BOOKRENT\r\n" + 
				"    SET BRENT_PREDATE = BRENT_PREDATE + INTERVAL '7' DAY\r\n" + 
				"    WHERE BRENT_NO= ?";
		jdbc.update(sql, param);
		
	}
	public void bookRent(List<Object> param) {
		String sql = "INSERT INTO BOOKRENT (BRENT_NO, BOOK_NO, MEM_NO)\r\n" + 
				"    SELECT SEQ_BOOKRENT.NEXTVAL, BOOK_NO, MEM_NO\r\n" + 
				"    FROM MEMBER, BOOK\r\n" + 
				"    WHERE MEM_ID = ?\r\n" + 
				"    AND BOOK_NAME = ?";
		jdbc.update(sql, param);
	}
	public void bookReturn(List<Object> param) {
		String sql = "UPDATE BOOKRENT\r\n" + 
				"SET BRENT_ENDDATE = SYSDATE\r\n" + 
				"WHERE (MEM_NO, BOOK_NO)  IN ( SELECT M.MEM_NO, R.BOOK_NO\r\n" + 
				"                                                    FROM MEMBER M, BOOKRENT R, BOOK B\r\n" + 
				"                                                    WHERE M.MEM_NO = R.MEM_NO\r\n" + 
				"                                                    AND R.BOOK_NO = B.BOOK_NO\r\n" + 
				"                                                     AND M.MEM_ID = ?\r\n" + 
				"                                                    AND B.BOOK_NAME = ?\r\n" + 
				")";
		jdbc.update(sql, param);
	}
}
