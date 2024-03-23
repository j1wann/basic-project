package vo;

public class RoomVo {
	private int room_no;
	private String room_name;
	private String room_type;
	private int room_floor;
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public int getRoom_floor() {
		return room_floor;
	}
	public void setRoom_floor(int room_floor) {
		this.room_floor = room_floor;
	}
	
	@Override
	public String toString() {
		return "RoomVo [room_no=" + room_no + ", room_name=" + room_name + ", room_type=" + room_type + ", room_floor="
				+ room_floor + "]";
	}
	
	
}
