package vo;

public class AdminVo {
	private String ad_no;
	private String ad_id;
	private String ad_pass;
	private String ad_name;
	private String ad_tel;
	private String ad_addr;
	private String ad_birth;
	private String ad_date;
	public String getAd_no() {
		return ad_no;
	}
	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}
	public String getAd_id() {
		return ad_id;
	}
	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_pass() {
		return ad_pass;
	}
	public void setAd_pass(String ad_pass) {
		this.ad_pass = ad_pass;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	public String getAd_tel() {
		return ad_tel;
	}
	public void setAd_tel(String ad_tel) {
		this.ad_tel = ad_tel;
	}
	public String getAd_addr() {
		return ad_addr;
	}
	public void setAd_addr(String ad_addr) {
		this.ad_addr = ad_addr;
	}
	public String getAd_birth() {
		return ad_birth;
	}
	public void setAd_birth(String ad_birth) {
		this.ad_birth = ad_birth;
	}
	public String getAd_date() {
		return ad_date;
	}
	public void setAd_date(String ad_date) {
		this.ad_date = ad_date;
	}
	@Override
	public String toString() {
		return "AdminVo [ad_no=" + ad_no + ", ad_id=" + ad_id + ", ad_pass=" + ad_pass + ", ad_name=" + ad_name
				+ ", ad_tel=" + ad_tel + ", ad_addr=" + ad_addr + ", ad_birth=" + ad_birth + ", ad_date=" + ad_date
				+ "]";
	}
	
	
}
