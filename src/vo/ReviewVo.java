package vo;

public class ReviewVo {
	private int review_no;
	private int review_star;
	private String review_content;
	private String review_blind;
	private String book_no;
	private String mem_no;
	
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public int getReview_star() {
		return review_star;
	}
	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_blind() {
		return review_blind;
	}
	public void setReview_blind(String review_blind) {
		this.review_blind = review_blind;
	}
	public String getBook_no() {
		return book_no;
	}
	public void setBook_no(String book_no) {
		this.book_no = book_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	@Override
	public String toString() {
		String reviewCon = String.format("%-10s", review_content);
		if(review_blind.equals("Y"))
			reviewCon = String.format("%-70s", review_content);
		
		if(review_blind.equals("Y")) {
			return "┌───────────────┬───────────────────────┬───────────────────────────────────────────────┐\n"
					 + "│ 리뷰 번호= " + review_no + "\t│ 리뷰 별점= " + review_star + "\t\t│ 리뷰 내용= " + "블라인드 처리되었습니다" + "\t\t\t│\n"
					 + "├───────────────┼───────────────────────┼───────────────────────────────────────────────┤\n"
					 + "│ 책 번호= " + book_no + "\t│ 회원 번호= " + mem_no + "\t│" + "  \t\t(악성 리뷰는 차단합니다.) " + "\t\t│\n"
					 + "└───────────────┴───────────────────────┴───────────────────────────────────────────────┘";
		}
		return "┌───────────────┬───────────────────────┬───────────────────────────────────────────────┐\n"
        + "│ 리뷰 번호= " + review_no + "\t│ 리뷰 별점= " + review_star + "\t\t│ 리뷰 내용= " + reviewCon + "\t\t\t\t│\n"
        + "├───────────────┼───────────────────────┼───────────────────────────────────────────────┤\n"
        + "│ 책 번호= " + book_no + "\t│ 회원 번호= " + mem_no + "\t│" + "  \t\t(악성 리뷰는 차단합니다.) " + "\t\t│\n"
        + "└───────────────┴───────────────────────┴───────────────────────────────────────────────┘";
 }
	
}
