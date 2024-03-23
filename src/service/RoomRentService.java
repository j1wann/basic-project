package service;

import java.util.List;

import dao.RoomRentDao;
import vo.RoomRentVo;

public class RoomRentService {
	private static RoomRentService instance = null;

	private RoomRentService() {

	}

	public static RoomRentService getInstance() {

		if (instance == null) {
			instance = new RoomRentService();
		}
		return instance;
	}
	RoomRentDao roomRentDao = RoomRentDao.getInstance();
	
	public List<RoomRentVo> roomRentList(){
		return roomRentDao.roomRentList();
	}
	public void roomRent(List<Object> param) {
		roomRentDao.roomRent(param);
	}
}
