package vo;

public class MemberVo {
	private String mem_no;
	private String mem_id;
	private String mem_pass;
	private String mem_name;
	private String mem_tel;
	private String mem_addr;
	private String mem_regno;
	private String mem_date;
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_regno() {
		return mem_regno;
	}
	public void setMem_regno(String mem_regno) {
		this.mem_regno = mem_regno;
	}
	public String getMem_date() {
		return mem_date;
	}
	public void setMem_date(String mem_date) {
		this.mem_date = mem_date;
	}
	@Override
	public String toString() {
		String padMemId = String.format("%-9s", mem_id);
		String padMemAddr = String.format("%-13s", mem_addr);
		return "┌───────────────────────┬───────────────────────────────┬───────────────────────┬───────────────────────┐\n"+
				   "│ 회원 번호= " + mem_no + "\t│ 회원 ID=" + padMemId + "\t\t│ 회원 PW=" + mem_pass + "\t\t│ 회원 이름=" + mem_name +"\t\t│\n"
					 + "├───────────────────────┼───────────────────────────────┼───────────────────────┼───────────────────────┤\n"
					 + "│ 회원 전화번호= " + mem_tel + "\t│ 회원 주소=" + padMemAddr + "\t\t│ 주민번호=" + mem_regno + "\t│ 가입일" + mem_date +"\t│\n"
					 + "└───────────────────────┴───────────────────────────────┴───────────────────────┴───────────────────────┘" ;
	}
	
	
}
