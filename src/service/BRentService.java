package service;

import java.util.ArrayList;
import java.util.List;

import controller.MainController;
import dao.BRentDao;
import vo.BRentVo;

public class BRentService {
	private static BRentService instance = null;

	private BRentService() {

	}

	public static BRentService getInstance() {

		if (instance == null) {
			instance = new BRentService();
		}
		return instance;
	}
	BRentDao bookRentDao = BRentDao.getInstance();

	public List<BRentVo> myRentList() {
		List<Object> list = new ArrayList();
		list.add(MainController.sessionStorage.get("id"));
		return bookRentDao.myRentList(list);
	}
	
	public List<BRentVo> rentList(){
		return bookRentDao.rentList();
	}
	
	public void rentEx(List<Object> param) {
		bookRentDao.rentEx(param);
	}
	public void bookRent(List<Object> param) {
		bookRentDao.bookRent(param);
	}
	public void bookReturn(List<Object> param) {
		bookRentDao.bookReturn(param);
	}
	
}
