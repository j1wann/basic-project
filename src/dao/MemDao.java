package dao;

import java.util.List;

import util.JDBCUtil;
import vo.MemberVo;

public class MemDao {
	private static MemDao instance = null;

	private MemDao() {

	}

	public static MemDao getInstance() {

		if (instance == null) {
			instance = new MemDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public MemberVo loginCheck(List<Object> param){
		String sql = "select *\r\n" + 
				"from MEMBER\r\n" + 
				"where mem_id = ? and\r\n" + 
				"mem_pass = ?";
		
		return jdbc.selectOne(sql, param, MemberVo.class);
		
	}

	public int memSign(List<Object> param) {
		String sql = "insert into member\r\n" + 
				"values('M'||TO_CHAR(SYSDATE, 'YYMM' )||LPAD(SEQ_MEM.NEXTVAL, 4, 0), ?, ?, ?, ?, ?, ?, SYSDATE)";
		return jdbc.update(sql, param);
	}

	public MemberVo getInfo(List<Object> param) {
		String sql = "select * from MEMBER where MEM_ID = ?";
		return jdbc.selectOne(sql, param, MemberVo.class);
	}

	public int nameUpdate(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
				"SET MEM_NAME = ?\r\n" + 
				"where MEM_ID = ?";
		return jdbc.update(sql, param);
	}

	public int addrUpdate(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
				"SET MEM_ADDR = ?\r\n" + 
				"where MEM_ID = ?";
		return jdbc.update(sql, param);
	}

	public int telUpdate(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
				"SET MEM_TEL = ?\r\n" + 
				"where MEM_ID = ?";
		return jdbc.update(sql, param);
	}

	public int passUpdate(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
				"SET MEM_PASS = ?\r\n" + 
				"where MEM_ID = ?";
		return jdbc.update(sql, param);
	}

	public MemberVo findId(List<Object> param) {
		String sql = "select *\r\n" + 
				"    from member\r\n" + 
				"    where mem_name = ? and mem_tel = ?";
		return jdbc.selectOne(sql, param, MemberVo.class);
	}
	
	public List<MemberVo> memberList(){
		String sql = "select * from member";
		return jdbc.selectList(sql, MemberVo.class);
	}

	public MemberVo findPass(List<Object> param) {
		String sql = "select * from member where mem_id = ? and mem_regno = ?";
		return jdbc.selectOne(sql, param, MemberVo.class);
	}
}
