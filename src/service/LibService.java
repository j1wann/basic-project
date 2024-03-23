package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.LibDao;
import vo.BookVo;

public class LibService {
	private static LibService instance = null;

	private LibService() {

	}

	public static LibService getInstance() {

		if (instance == null) {
			instance = new LibService();
		}
		return instance;
	}
	
	LibDao dao = LibDao.getInstance();
	
	public List<BookVo> titleSearch(List<Object> param){
		return dao.titleSearch(param);
	}

	public List<BookVo> typeSearch(List<Object> param) {
		return dao.typeSearch(param);
	}
	public List<BookVo> bookList(){
		return dao.bookList();
	}
	
}
