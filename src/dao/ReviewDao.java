package dao;

import java.util.List;

import util.JDBCUtil;
import vo.ReviewVo;

public class ReviewDao {
	private static ReviewDao instance = null;

	private ReviewDao() {

	}

	public static ReviewDao getInstance() {

		if (instance == null) {
			instance = new ReviewDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<ReviewVo> myReviewList(List<Object> param){
		String sql = "SELECT R.*\r\n" + 
				"    FROM REVIEW R, BOOK B, MEMBER M\r\n" + 
				"    WHERE R.BOOK_NO = B.BOOK_NO AND M.MEM_NO = R.MEM_NO AND R.REVIEW_BLIND = 'N' AND M.MEM_ID = ?\r\n" + 
				"    ORDER BY B.BOOK_NAME ASC";
		return jdbc.selectList(sql, param, ReviewVo.class);
	}

	public int reviewInsert(List<Object> param) {
		String sql = "INSERT INTO REVIEW(REVIEW_NO, REVIEW_STAR, REVIEW_CONTENT,  BOOK_NO, MEM_NO)\r\n" + 
				"SELECT SEQ_REVIEW.NEXTVAL, ?, ?, BOOK_NO , MEM_NO\r\n" + 
				"        FROM(SELECT MEMBER.MEM_NO, BOOK.BOOK_NO\r\n" + 
				"        FROM MEMBER, BOOK, BOOKRENT\r\n" + 
				"        WHERE MEM_ID = ?\r\n" + 
				"        AND BOOK_NAME = ?\r\n" + 
				"        AND BOOK.BOOK_NO = BOOKRENT.BOOK_NO)";
		return jdbc.update(sql, param);
		
	}
	public int reviewDelete(List<Object> param) {
		String sql = "DELETE\r\n" + 
				"    FROM REVIEW\r\n" + 
				"    WHERE REVIEW_NO = ?";
		return jdbc.update(sql, param);
	}

	public void reviewUpdate(List<Object> param) {
		String sql = "UPDATE REVIEW\r\n" + 
				"    SET REVIEW_STAR = ?, REVIEW_CONTENT = ?\r\n" + 
				"    WHERE REVIEW_NO = ? AND REVIEW_BLIND = 'N'";
		jdbc.update(sql, param);
		
	}

	public List<ReviewVo> myReviewList() {
		String sql = "select * from review";
		return jdbc.selectList(sql, ReviewVo.class);
	}
	
}
