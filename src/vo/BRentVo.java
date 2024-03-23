package vo;

public class BRentVo {
	private int brent_no;
	private String book_no;
	private String book_name;
	private String brent_rendate;
	private String brent_predate;
	private String brent_enddate;
	private String mem_id;
	
	
	
	public String getBook_no() {
		return book_no;
	}
	public void setBook_no(String book_no) {
		this.book_no = book_no;
	}
	public int getBrent_no() {
		return brent_no;
	}
	public void setBrent_no(int brent_no) {
		this.brent_no = brent_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBrent_rendate() {
		return brent_rendate;
	}
	public void setBrent_rendate(String brent_rendate) {
		this.brent_rendate = brent_rendate;
	}
	public String getBrent_predate() {
		return brent_predate;
	}
	public void setBrent_predate(String brent_predate) {
		this.brent_predate = brent_predate;
	}
	
	public String getBrent_enddate() {
		return brent_enddate;
	}
	public void setBrent_enddate(String brent_enddate) {
		this.brent_enddate = brent_enddate;
	}
	@Override
	public String toString() {
		String padBookName = String.format("%-10s", book_name);
		if(brent_enddate == null) {
	         return "┌───────────────┬───────────────┬───────────────────────┬───────────────────────────────┬───────────────────────────────┬───────────────────────┐\n"
	         	  + "│ 상태 : 대여 중 \t│ 대여 번호 : " + brent_no + "\t│ 도서 명 : " + padBookName + "\t│ 대여 일 : " + brent_rendate + "\t│ 반납 예정일 : " + brent_predate + "\t│ 회원 ID : " + mem_id + "\t\t│\n"
	         	  + "└───────────────┴───────────────┴───────────────────────┴───────────────────────────────┴───────────────────────────────┴───────────────────────┘";
	    }else {
	         return "┌───────────────┬───────────────┬───────────────────────┬───────────────────────────────┬───────────────────────┐\n"
	         	  + "│상태 : 반납 완료 \t│ 대여 번호 : " + brent_no + "\t│ 도서 명 : " + padBookName +  "\t│ 반납일 : " + brent_enddate + "\t│ 회원 ID : " + mem_id + "\t\t│\n"
	         	  + "└───────────────┴───────────────┴───────────────────────┴───────────────────────────────┴───────────────────────┘";
	    }
	}
}
