package vo;

public class RoomRentVo {
	private int rrent_no;
	private String rrent_rendate;
	private int rrt_no;
	private String rrt_time;
	private int room_no;
	private String mem_id;
	public int getRrent_no() {
		return rrent_no;
	}
	public void setRrent_no(int rrent_no) {
		this.rrent_no = rrent_no;
	}
	public String getRrent_rendate() {
		return rrent_rendate;
	}
	public int getRrt_no() {
		return rrt_no;
	}
	public void setRrt_no(int rrt_no) {
		this.rrt_no = rrt_no;
	}
	public void setRrent_rendate(String rrent_rendate) {
		this.rrent_rendate = rrent_rendate;
	}
	public String getRrt_time() {
		return rrt_time;
	}
	public void setRrt_time(String rrt_time) {
		this.rrt_time = rrt_time;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "┌───────────────┬───────────────────────┬───────────────────────┬───────────────┬───────────────┐\n"
				 + "│ 예약 번호=" + rrent_no + "\t│ 예약 날짜=" + rrent_rendate + "\t│ 예약 시간=" + rrt_time + "\t│ 스터디룸 번호=" + room_no + "\t│ 회원 ID=" + mem_id + "\t│\n"
				 + "└───────────────┴───────────────────────┴───────────────────────┴───────────────┴───────────────┘\n";
	}
	
	
	
	
	
}
