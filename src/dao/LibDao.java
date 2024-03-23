package dao;

import java.util.List;

import util.JDBCUtil;
import vo.BookVo;

public class LibDao {
	private static LibDao instance = null;

	private LibDao() {

	}

	public static LibDao getInstance() {

		if (instance == null) {
			instance = new LibDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<BookVo> titleSearch(List<Object> param){
		String sql = "SELECT BOOK_NO , BOOK_NAME , BOOK_TYPE , BOOK_QTY \r\n" + 
				"    FROM BOOK\r\n" + 
				"    WHERE BOOK_NAME LIKE  '%'||?||'%' ";
		
		return jdbc.selectList(sql, param, BookVo.class);
	}

	public List<BookVo> typeSearch(List<Object> param) {
		String sql = "SELECT BOOK_NO , BOOK_NAME , BOOK_TYPE , BOOK_QTY \r\n" + 
				"    FROM BOOK\r\n" + 
				"    WHERE BOOK_TYPE LIKE  '%'||?||'%' ";
		
		return jdbc.selectList(sql, param, BookVo.class);
	}
	
	public List<BookVo> bookList(){
		String sql =  "select * from book";
		return jdbc.selectList(sql, BookVo.class);
	}
	
}
