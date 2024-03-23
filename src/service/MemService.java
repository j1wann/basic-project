package service;

import java.util.ArrayList;
import java.util.List;

import controller.MainController;
import dao.MemDao;
import vo.MemberVo;

public class MemService {
	private static MemService instance = null;

	private MemService() {

	}

	public static MemService getInstance() {

		if (instance == null) {
			instance = new MemService();
		}
		return instance;
	}

	MemDao memDao = MemDao.getInstance();

	public MemberVo loginCheck(List<Object> param) {
		return memDao.loginCheck(param);
	}

	public int memSign(List<Object> param) {
		return memDao.memSign(param);
	}

	public MemberVo getInfo() {
		List<Object> list = new ArrayList();
		list.add(MainController.sessionStorage.get("id"));
		return memDao.getInfo(list);
	}

	public boolean nameUpdate(List<Object> param) {

		if (((String) param.get(0)).length() > 15) {
			System.out.println(((String) param.get(0)).length());
			return false;
		} else if (memDao.nameUpdate(param) == 1) {
			return true;
		} else
			return false;
	}

	public boolean addrUpdate(List<Object> param) {
		if (memDao.addrUpdate(param) == 1)
			return true;
		else
			return false;

	}

	public boolean telUpdate(List<Object> param) {
		if (memDao.telUpdate(param) == 1)
			return true;
		else
			return false;
	}

	public boolean passUpdate(List<Object> param) {
		if (memDao.passUpdate(param) == 1)
			return true;
		else
			return false;
	}
	public MemberVo findId(List<Object> param) {
		return memDao.findId(param);
	}
	public List<MemberVo> memberList(){
		return memDao.memberList();
	}

	public MemberVo findPass(List<Object> param) {
		// TODO Auto-generated method stub
		return memDao.findPass(param);
	}
}
