package vo;

public class BookVo {
	private String book_no;
	private String book_name;
	private String book_type;
	private int book_qty;
	public String getBook_no() {
		return book_no;
	}
	public void setBook_no(String book_no) {
		this.book_no = book_no;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_type() {
		return book_type;
	}
	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
	public int getBook_qty() {
		return book_qty;
	}
	public void setBook_qty(int book_qty) {
		this.book_qty = book_qty;
	}
	@Override
	public String toString() {
		String padBookName = String.format("%-15s", book_name);
		String padBookNo = String.format("%-9s", book_no);
		return "┌────────────────┬──────────────────────────────┬───────────────────────┬───────────────┐ " + "\n"
			 + "│도서 번호=\t"+ padBookNo +"│ 도서명="+ padBookName +"\t\t│ 도서 종류=" + book_type +"\t\t"+ "│ 도서 재고=" + book_qty +"\t│" +"\n"
			 + "└────────────────┴──────────────────────────────┴───────────────────────┴───────────────┘";
	}

}
