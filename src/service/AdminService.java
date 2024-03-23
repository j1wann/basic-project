package service;

import java.util.List;

import dao.AdminDao;
import vo.AdminVo;
import vo.MemberVo;

public class AdminService {
	private static AdminService instance = null;

	private AdminService() {

	}

	public static AdminService getInstance() {

		if (instance == null) {
			instance = new AdminService();
		}
		return instance;
	}
	AdminDao adminDao = AdminDao.getInstance();
	
	public AdminVo loginCheck(List<Object> param) {
		return adminDao.loginCheck(param);		
	}
	
public void bookUpdate(int sel, List<Object> param) {
		
		adminDao.bookUpdate(sel, param);
	}

	public void bookInsert(List<Object> param) {

		adminDao.bookInsert(param);
		
	}

	public void bookDelete(List<Object> param) {
		
		adminDao.bookDelete(param);
	}

	public List<MemberVo> memberSearch(List<Object> param) {
		
		return adminDao.memberSearch(param);
	}
	
	public void memberUpdate(int sel, List<Object> param) {
		
		adminDao.memberUpdate(sel, param);
	}

	public void memberDelete(List<Object> param) {
		
		adminDao.memberDelete(param);
	}
	
	public int reviewBlind(List<Object> param) {
		return adminDao.reviewBlind(param);
	}
	
}
