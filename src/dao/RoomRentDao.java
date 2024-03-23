package dao;

import java.util.List;

import util.JDBCUtil;
import vo.RoomRentVo;

public class RoomRentDao {
	private static RoomRentDao instance = null;

	private RoomRentDao() {

	}

	public static RoomRentDao getInstance() {

		if (instance == null) {
			instance = new RoomRentDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<RoomRentVo> roomRentList() {
		String sql = " SELECT R.RRENT_NO, TO_CHAR(R.RRENT_RENDATE, 'YYYY.MM.DD') RRENT_RENDATE, R.RRT_NO, T.RRT_TIME, R.ROOM_NO, M.MEM_ID\r\n" + 
				"    FROM ROOMRENT R, MEMBER M , RRENTTIME T\r\n" + 
				"    WHERE R.MEM_NO = M.MEM_NO \r\n" + 
				"    AND R.RRT_NO = T.RRT_NO\r\n";
		return jdbc.selectList(sql, RoomRentVo.class);
	}

	public void roomRent(List<Object> param) {
		String sql = "INSERT INTO ROOMRENT(RRENT_NO, RRENT_RENDATE, RRT_NO, ROOM_NO, MEM_NO)\r\n" + 
				"SELECT SEQ_ROOMRENT.NEXTVAL, TO_DATE(?, 'YYYY/MM/DD'), ?, ?, MEM_NO\r\n" + 
				"FROM( SELECT MEM_NO\r\n" + 
				"FROM MEMBER\r\n" + 
				"WHERE MEM_ID= ?)";
		jdbc.update(sql, param);
		
	}
}
