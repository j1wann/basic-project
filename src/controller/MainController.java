package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.AdminService;
import service.BRentService;
import service.LibService;
import service.MemService;
import service.ReviewService;
import service.RoomRentService;
import util.ScanUtil;
import util.View;
import view.Print;
import vo.AdminVo;
import vo.BRentVo;
import vo.BookVo;
import vo.MemberVo;
import vo.ReviewVo;
import vo.RoomRentVo;

public class MainController extends Print {

	static public Map<String, Object> sessionStorage = new HashMap<>();
	static public MemberVo loginMem = new MemberVo();
	static public int permission = 0; // 1 > 회원, 2 > 관리자

	LibService libService = LibService.getInstance();
	MemService memService = MemService.getInstance();
	AdminService adService = AdminService.getInstance();
	BRentService bookRentService = BRentService.getInstance();
	ReviewService reviewService = ReviewService.getInstance();
	RoomRentService roomRentService = RoomRentService.getInstance();

	public static void main(String[] args) {
		new MainController().start();
	}
	
	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case BOOK_LIST:
				view = bookList();
				break;
			case BOOK_SEARCH:
				view = bookSearch();
				break;
			case ROOM:
				view = room();
				break;
			case LOGIN:
				view = logIn();
				break;
			case FIND_ID:
				view = findId();
				break;
			case FIND_PASS:
				view = findPass();
				break;
			case AD_LOGIN:
				view = adLogin();
				break;
			case AD_HOME:
				view = adHome();
				break;
			case MEM_LOGIN:
				view = memLogin();
				break;
			case MEM_SIGN:
				view = memSign();
				break;
			case MEM_HOME:
				view = memHome();
				break;
			case MY_PAGE:
				view = myPage();
				break;
			case INFO:
				view = info();
				break;
			case PASS_UPDATE:
				view = passUpdate();
				break;
			case TEL_UPDATE:
				view = telUpdate();
				break;
			case ADDR_UPDATE:
				view = addrUpdate();
				break;
			case NAME_UPDATE:
				view = nameUpdate();
				break;
			case BRENT_HISTORY:
				view = bRentHis();
				break;
			case MY_REVIEW:
				view = myReview();
				break;
			case REVIEW_INSERT:
				view = reviewInsert();
				break;
			case REVIEW_DELETE:
				view = reviewDelete();
				break;
			case BRENT_EX:
				view = bookRentEx();
				break;
			case REVIEW_UPDATE:
				view = reviewUpdate();
				break;
			case RRENT_HISTORY:
				view = rRentHis();
				break;
			case LOGOUT:
				view = logOut();
				break;
			case MANAGE:
				view = manage();
				break;
			case BOOK_RENT:
				view = bookRent();
				break;
			case BOOK_RETURN:
				view = bookReturn();
				break;
			case RENT_LIST:
				view = rentList();
				break;
			case MEMBER_MNG:
				view = memberManage();
				break;
			case MEM_SEARCH:
				view = memberSearch();
				break;
			case MEM_UPDATE:
				view = memberUpdate();
				break;
			case MEM_DELETE:
				view = memberDelete();
				break;
			case BOOK_MNG:
				view = bookManage();
				break;
			case BOOK_INSERT:
				view = bookInsert();
				break;
			case BOOK_UPDATE:
				view = bookUpdate();
				break;
			case BOOK_DELETE:
				view = bookDelete();
				break;
			case REVIEW_MNG:
				view = reviewManage();
				break;
			default:
				break;
			}
		}
	}
private View reviewManage() {
		System.out.println("====리뷰 관리====");
		for(ReviewVo vo : reviewService.reviewList()) {
			System.out.println(vo);
		}
		
		System.out.println("1. 리뷰 블라인드");
		System.out.println("2. 관리");
		
		int sel1 = ScanUtil.nextInt("메뉴를 선택해주세요 : ");
		switch(sel1) {
			case 1: 
				break;
			case 2:
				return View.MANAGE;
		}
		
		
		int sel = ScanUtil.nextInt("블라인드 처리할 리뷰 번호를 입력해주세요 : ");
		List<Object> list = new ArrayList();
		list.add(sel);
		
		if(adService.reviewBlind(list) == 1)
			System.out.println("블라인드 처리 완료");
		else
			System.out.println("블라인드 처리 실패");
		
		
		
		return View.MANAGE;
	}

//	private View 
	
	
	private View memberDelete() {
		printline();
		List<MemberVo> memList= memService.memberList();
		for (MemberVo member : memList) {
			System.out.println(member);
		}
		String memId = ScanUtil.nextLine("삭제할 회원ID를 입력해주세요 : ");
		boolean check = true;
		for (MemberVo member : memList) {
			if (member.getMem_id().equals(memId)) {
				check = false;
			}
		}
		if (check) {
			System.out.println("입력한 회원 ID가 존재하지 않습니다.");
			System.out.println("1. 다시 입력하기");
			System.out.println("2. 홈");
			int sel1 = ScanUtil.nextInt("번호를 입력해주세요.");
			if (sel1 == 1)
				return View.MEM_DELETE;
			if (sel1 == 2)
				return View.BOOK_MNG;
		}
		List<Object> param = new ArrayList();
		param.add(memId);
		adService.memberDelete(param);
		System.out.println("회원 삭제 완료!");
		return View.MANAGE;
	}

	private View memberUpdate() { //***회원 수정***
		printline();
		List<MemberVo> memList= memService.memberList();
		for (MemberVo member : memList) {
			System.out.println(member);
		}
		String memId = ScanUtil.nextLine("수정할 회원ID를 입력해주세요 : ");
		boolean check = true;
		for (MemberVo member : memList) {
			if (member.getMem_id().equals(memId)) {
				check = false;
			}
		}
		if (check) {
			System.out.println("입력한 회원 ID가 존재하지 않습니다.");
			System.out.println("1. 다시 입력하기");
			System.out.println("2. 홈");
			int sel1 = ScanUtil.nextInt("번호를 입력해주세요.");
			if (sel1 == 1)
				return View.MEM_UPDATE;
			if (sel1 == 2)
				return View.BOOK_MNG;
		}
		System.out.println("1. 전체");
		System.out.println("2. 비밀번호");
		System.out.println("3. 전화번호");
		System.out.println("4. 주소");
		System.out.println("5. 이름");
		int sel = ScanUtil.nextInt("수정할 내용 선택해주세요 : ");
		List<Object> param = new ArrayList();
		if (sel == 1 || sel == 2) {
			String pass = ScanUtil.nextLine("수정할 회원 비밀번호를 입력해주세요 : ");
			param.add(pass);
		}
		if (sel == 1 || sel == 3) {
			String tel = ScanUtil.nextLine("수정할 회원 전화번호를 입력해주세요 : ");
			param.add(tel);
		}
		if (sel == 1 || sel == 4) {
			String addr = ScanUtil.nextLine("수정할 회원 주소를 입력해주세요 : ");
			param.add(addr);
		}
		if (sel == 1 || sel == 5) {
			String name = ScanUtil.nextLine("수정할 회원 이름을 입력해주세요 : ");
			param.add(name);
		}
		param.add(memId);

		adService.memberUpdate(sel, param);
		printMemberList();
		System.out.println("회원 수정 완료!");
		return View.MANAGE;
	}
		
		
		

	private View memberSearch() { //***회원 검색***
		printline();
		List<MemberVo> memList= memService.memberList();
		for (MemberVo member : memList) {
			System.out.println(member);
		}
		String memName = ScanUtil.nextLine("조회할 회원 이름을 입력해주세요 : ");
		boolean check = true;
		for (MemberVo member : memList) {
			if (member.getMem_name().equals(memName)) {
				check = false;
			}
		}
		if (check) {
			System.out.println("입력한 회원 이름이 존재하지 않습니다.");
			System.out.println("1. 다시 입력하기");
			System.out.println("2. 홈");
			int sel = ScanUtil.nextInt("번호를 입력해주세요.");
			if (sel == 1)
				return View.MEM_SEARCH;
			if (sel == 2)
				return View.BOOK_MNG;
		}
		List<Object> param = new ArrayList();
		param.add(memName);
		List<MemberVo> member = adService.memberSearch(param);
		for (MemberVo mem : member) {
			System.out.println(mem);
		}
		System.out.println("회원정보 조회 완료!");
		return View.MANAGE;
			
	}

	private View memberManage() { //***회원 관리***
		printline();
		System.out.println("=====회원 관리 페이지=====");
		System.out.println("1. 회원 검색");
		System.out.println("2. 회원 수정");
		System.out.println("3. 회원 삭제");
		System.out.println("4. 관리");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEM_SEARCH;
		case 2:
			return View.MEM_UPDATE;
		case 3:
			return View.MEM_DELETE;
		case 4:
			return View.MANAGE;
		default:
			return View.MEMBER_MNG;
		}
	}

	private View bookDelete() { // ***도서 삭제***
		printline();
		List<BookVo> bookList = libService.bookList();
		for (BookVo book : bookList) {
			System.out.println(book);
		}
		System.out.println("※종류코드 (01 언어 /02 소설 /03 사회 /04 과학 /05 문화 /06 시)");
		String bookNo = ScanUtil.nextLine("삭제할 도서번호를 입력해주세요 : ");
		boolean check = true;
		for (BookVo book : bookList) {
			if (book.getBook_no().equals(bookNo)) {
				check = false;
			}
		}
		for(BRentVo vo : bookRentService.rentList()) {
			if(vo.getBook_no().equals(bookNo)) {
				System.out.println("대여중인 도서입니다.");
				return View.BOOK_MNG;
			}
		}
		if (check) {
			System.out.println("입력한 도서번호가 존재하지 않습니다.");
			System.out.println("1. 다시 입력하기");
			System.out.println("2. 홈");
			int sel = ScanUtil.nextInt("번호를 입력해주세요.");
			if (sel == 1)
				return View.BOOK_DELETE;
			if (sel == 2)
				return View.BOOK_MNG;
		}
		List<Object> param = new ArrayList();
		param.add(bookNo);
		adService.bookDelete(param);
		System.out.println("도서 삭제 완료!");
		return View.MANAGE;

	}

	private View bookUpdate() { // ***도서 수정****
		printline();
		List<BookVo> bookList = libService.bookList();
		for (BookVo book : bookList) {
			System.out.println(book);
		}
		System.out.println("※종류코드 (01 언어 /02 소설 /03 사회 /04 과학 /05 문화 /06 시)");

		String bookNo = ScanUtil.nextLine("수정할 도서번호를 입력해주세요 : ");
		boolean check = true;
		for (BookVo book : bookList) {
			if (book.getBook_no().equals(bookNo)) {
				check = false;
			}
		}
		if (check) {
			System.out.println("입력한 도서번호가 존재하지 않습니다.");
			System.out.println("1. 다시 입력하기");
			System.out.println("2. 홈");
			int sel1 = ScanUtil.nextInt("번호를 입력해주세요.");
			if (sel1 == 1)
				return View.BOOK_UPDATE;
			if (sel1 == 2)
				return View.BOOK_MNG;
		}
		System.out.println("1. 전체");
		System.out.println("2. 도서명");
		System.out.println("3. 도서 내용");
		System.out.println("4. 도서 종류");
		int sel = ScanUtil.nextInt("수정할 내용 선택해주세요 : ");
		List<Object> param = new ArrayList();
		if (sel == 1 || sel == 2) {
			String name = ScanUtil.nextLine("수정할 도서명을 입력해주세요 : ");
			param.add(name);
		}
		if (sel == 1 || sel == 3) {
			String type = ScanUtil.nextLine("수정할  도서종류을 입력해주세요 : ");
			param.add(type);
		}
		if (sel == 1 || sel == 4) {
			String qty = ScanUtil.nextLine("수정할 도서재고를 입력해주세요 : ");
			param.add(qty);
		}
		param.add(bookNo);

		adService.bookUpdate(sel, param);
		printBookList();
		System.out.println("도서 수정 완료!");
		return View.MANAGE;

	}

	private View bookInsert() { // ***도서추가***
		printline();
		List<BookVo> bookList = libService.bookList();
		for (BookVo book : bookList) {
			System.out.println(book);
		}
		System.out.println("※종류 (01 언어 /02 소설 /03 사회 /04 과학 /05 문화 /06 시)");

		List<Object> param = new ArrayList();
		String name = ScanUtil.nextLine("추가할 도서명을 입력해주세요  : ");
		System.out.println("ex) 언어");
		String type = ScanUtil.nextLine("추가할 도서 종류를 입력해주세요 : ");
		String typeCode;
		if (type.equals("언어")) {
			typeCode = "01";
		} else if (type.equals("소설")) {
			typeCode = "02";
		} else if (type.equals("사회")) {
			typeCode = "03";
		} else if (type.equals("과학")) {
			typeCode = "04";
		} else if (type.equals("문화")) {
			typeCode = "05";
		} else if (type.equals("시")) {
			typeCode = "06";
		} else {
			System.out.println("잘못된 종류입니다.");
			return View.BOOK_INSERT;
		}
		String qty = ScanUtil.nextLine("추가할 도서 재고를 입력해주세요 : ");
		param.add(typeCode);
		param.add(name);
		param.add(type);
		param.add(qty);
		adService.bookInsert(param);
		printBookList();
		System.out.println("도서 추가 완료!");
		return View.MANAGE;
	}

	private View bookManage() { //***도서 관리***
		printline();
		System.out.println("=====도서 관리 페이지=====");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 수정");
		System.out.println("3. 도서 삭제");
		System.out.println("4. 관리");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.BOOK_INSERT;
		case 2:
			return View.BOOK_UPDATE;
		case 3:
			return View.BOOK_DELETE;
		case 4:
			return View.MANAGE;
		default:
			return View.BOOK_MNG;
		}
	}
	

	private View rentList() {
		printline();
		System.out.println("전체 대여 내역");
		for(BRentVo vo : bookRentService.rentList()) {
			System.out.println(vo);
		}
		
		return View.MANAGE;
	}

	private View bookReturn() {
		printline();
		System.out.println("====도서 반납====");
		System.out.println("\n대여목록");
		for(BRentVo vo : bookRentService.rentList()) {
			System.out.println(vo);
		}
//		List<BRentVo> list = new ArrayList();
//		list = bookRentService.rentList();
		String id = ScanUtil.nextLine("id 입력 : ");
		
		boolean check = true;
		for(BRentVo vo : bookRentService.rentList()) {
			if(vo.getMem_id().equals(id)) {
				check = false;
				break;
			}
		}
		if(check) {
			System.out.println("잘못된 id 입력");
			return View.AD_HOME;
		}
		String title = ScanUtil.nextLine("도서명 입력 : "); 
		for(BRentVo vo : bookRentService.rentList()) {
			if(vo.getBook_name().equals(title) && vo.getMem_id().equals(id)&&vo.getBrent_enddate() == null) {
				List<Object> param = new ArrayList<>();
				param.add(id);
				param.add(title);
				bookRentService.bookReturn(param);
				System.out.println("반납 완료!");
				check = true;
				break;
			}
		}
		if(!check) {
			System.out.println("해당 유저가 빌린 도서가 아닙니다.");
			return View.AD_HOME;
		}

		
		return View.AD_HOME;
	}

	private View bookRent() {
		printline();
		System.out.println("====도서 대여====\n");
		System.out.println("***도서 목록***");
		List<BookVo> list = libService.bookList();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
		
		String title = ScanUtil.nextLine("대여할 도서명을 입력해주세요 : ");
		List<Object> param = new ArrayList();
		boolean check = false;
		for(BookVo vo : list) {
			if(vo.getBook_name().equals(title)) {
				if(vo.getBook_qty() == 0) {
					System.out.println("전부 대여 중입니다.");
					return View.AD_HOME;
				}
				else {
					System.out.println("남은 권 수 : " + vo.getBook_qty());
				}
				check = true;
			}
		}
		if(!check) {
			System.out.println("해당 도서가 검색되지 않습니다.");
			return View.AD_HOME;
		}
		
		
		String id = ScanUtil.nextLine("대여할 회원 ID를 입력해주세요 : ");
		for (MemberVo vo : memService.memberList() ) {
			if (vo.getMem_id().equals(id)) {
				System.out.println(vo.getMem_id() + " : " + vo.getMem_name() + "님");
				check = false;
			}
		}
		if(check) {
			System.out.println("없는 아이디입니다.");
			return View.AD_HOME;
		}
		param.clear();
		param.add(id);
		param.add(title);
		
		bookRentService.bookRent(param);
		
		System.out.println("대여 완료!");
		
		return View.AD_HOME;
	}

	private View manage() {
		printline();
		System.out.println("=====관리 페이지=====");
		System.out.println("1. 회원 관리");
		System.out.println("2. 도서 관리");
		System.out.println("3. 대여 내역");
		System.out.println("4. 리뷰 관리");
		System.out.println("5. 홈");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEMBER_MNG;
		case 2:
			return View.BOOK_MNG;
		case 3:
			return View.RENT_LIST;
		case 4:
			return View.REVIEW_MNG;
		case 5:
			return View.AD_HOME;
		default:
			return View.MANAGE;
		}

	}

	private View logOut() {
		printline();
		sessionStorage.clear();
		permission  = 0;
		System.out.println("로그아웃 되었습니다\n");
		return View.HOME;
	}

	private View findPass() {
		printline();
		System.out.println("====비밀번호 찾기====");
		String id = ScanUtil.nextLine("아이디를 입력해주세요 : ");
		String birth = ScanUtil.nextLine("생년월일을 입력해주세요 : (YYMMDD)");
		String reg = ScanUtil.nextLine("주민번호 뒷자리를 입력해주세요 : ");
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		list.add(birth + "-" + reg);

		MemberVo res = null;

		List<MemberVo> memberList = memService.memberList();
		for (MemberVo vo : memberList) {
			if (list.get(0).equals(vo.getMem_id()) && list.get(1).equals(vo.getMem_regno())) {
				res = memService.findPass(list);
			}
		}

		if (res != null) {
			System.out.println("찾은 비밀번호 : " + res.getMem_pass());
		} else
			System.out.println("입력하신 아이디, 주민번호에 해당하는 아이디가 없습니다.");

		return View.LOGIN;
	}

	private View findId() {
		printline();
		System.out.println("====아이디 찾기====");
		String name = ScanUtil.nextLine("이름을 입력해주세요 : ");
		String tel = ScanUtil.nextLine("전화번호를 입력해주세요 : ");
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		list.add(tel);

		MemberVo res = null;

		List<MemberVo> memberList = memService.memberList();
		for (MemberVo vo : memberList) {
			if (list.get(0).equals(vo.getMem_name()) && list.get(1).equals(vo.getMem_tel())) {
				res = memService.findId(list);
			}
		}

		if (res != null) {
			System.out.println("찾은 아이디 : " + res.getMem_id());
		} else
			System.out.println("입력하신 이름, 전화번호에 해당하는 아이디가 없습니다.");

		return View.LOGIN;
	}

	private View rRentHis() {
		printline();
		System.out.println("스터디룸 예약 현황");
		List<RoomRentVo> list = roomRentService.roomRentList();
		for (RoomRentVo vo : list) {
			if (vo.getMem_id().equals(sessionStorage.get("id")))
				System.out.println(vo);
		}

		return View.MY_PAGE;
	}

	private View reviewUpdate() {
		printline();
		System.out.println("====리뷰 수정====");
		int sel = ScanUtil.nextInt("수정할 리뷰의 리뷰번호(review_num)을 입력해주세요 : ");
		List<ReviewVo> list = reviewService.myReviewList();
		boolean check = true;
		for (ReviewVo vo : list) {
			if (vo.getReview_no() == sel) {
				int star = ScanUtil.nextInt("수정할 별점 점수 : ");
				String content = ScanUtil.nextLine("리뷰를 입력해주세요 : ");
				List<Object> param = new ArrayList<Object>();
				param.add(star);
				param.add(content);
				param.add(sel);

				reviewService.reviewUpdate(param);
				System.out.println("리뷰 수정 완료!");
				check = false;
			}
		}
		if (check)
			System.out.println("잘못된 리뷰번호입니다.");

		return View.MY_REVIEW;
	}

	private View bookRentEx() {
		printline();
		System.out.println("====대여 연장====");
//		int sel = ScanUtil.nextInt("대여번호(brent_no)를 입력해주세요 : ");
		List<BRentVo> list = new ArrayList();
		List<Object> param = new ArrayList<>();
		boolean check = true;
//		list.add(sel);

//		bookRentService.rentEx(list);
		String title = ScanUtil.nextLine("연장할 도서명을 입력해주세요 : ");
		list = bookRentService.myRentList();
		for (BRentVo vo : list) {
			if (vo.getBook_name().equals(title) && vo.getBrent_enddate() == null) {
				param.add(vo.getBrent_no());
				bookRentService.rentEx(param);
				System.out.println("연장 완료!");
				check = false;
			}
		}
		if (check) {
			System.out.println("잘못된 값 입력!");
			return View.BRENT_HISTORY;
		}

		return View.BRENT_HISTORY;
	}

	private View reviewDelete() {
		printline();
		System.out.println("====리뷰 삭제====");
		int delete = ScanUtil.nextInt("삭제할 리뷰 번호(review_no)를 입력해주세요 : ");
		List<Object> list = new ArrayList<>();
		list.add(delete);

		if (reviewService.reviewDelete(list) == 1) {
			System.out.println("삭제 완료!");
		} else
			System.out.println("삭제 실패");

		return View.MY_REVIEW;
	}

	private View reviewInsert() {
		printline();
		//읽은 도서 목록 출력
		
		System.out.println("읽은 도서 목록");
		List<BRentVo> list = new ArrayList<>();
		list = bookRentService.myRentList();
		for (BRentVo vo : list) {
			System.out.println(vo);
		}

		//도서명 받아서 파라미터에 add
		List<Object> param = new ArrayList<>();
		String title = ScanUtil.nextLine("리뷰를 작성할 도서명을 입력해주세요 : ");
		param.add(title);
		boolean check = true;
		//읽은 도서 목록 중에 입력한 도서명과 일치하면 리뷰 작성 시작
		for(BRentVo vo : list) {
			if(vo.getBook_name().equals(title)) {	//일치 검사
				String content = ScanUtil.nextLine("리뷰를 입력해주세요 : ");
				int star = ScanUtil.nextInt("별점을 입력해주세요 (1 ~ 5) : ");
				if (star < 1 || star > 5) {
					System.out.println("잘못된 값 입력!");
					return View.REVIEW_INSERT;
				}
				param.clear();
				param.add(star);
				param.add(content);
				param.add(sessionStorage.get("id"));
				param.add(title);

				if (reviewService.reviewInsert(param) == 1) {
					System.out.println("리뷰 작성 완료!");
					check = false;
				}
				else
					System.out.println("리뷰 작성 실패");
			}
		}
		if(check)
			System.out.println("해당 도서를 검색할 수 없습니다.");
		return View.MY_REVIEW;
	}

	private View myReview() {
		printline();
		System.out.println("====작성한 리뷰 목록====");
		List<ReviewVo> list = reviewService.myReviewList();
		for (ReviewVo vo : list) {
			System.out.println(vo);
		}

		System.out.println("1. 리뷰 작성");
		System.out.println("2. 리뷰 삭제");
		System.out.println("3. 리뷰 수정");
		System.out.println("4. 마이 페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.REVIEW_INSERT;
		case 2:
			return View.REVIEW_DELETE;
		case 3:
			return View.REVIEW_UPDATE;
		case 4:
			return View.MY_PAGE;
		default:
			return View.MY_REVIEW;
		}
	}

	private View bRentHis() {
		printline();
		System.out.println("====대여현황====");
		List<BRentVo> result = bookRentService.myRentList();

		System.out.println("*현재 대여중인 도서*");
		for (BRentVo vo : result) {
			if (vo.getBrent_enddate() == null)
				System.out.println("도서명 : " + vo.getBook_name() + " 대여일 : " + vo.getBrent_rendate() + " 반납예정일 : " + vo.getBrent_predate());
		}

		System.out.println("*반납 완료한 도서*");
		for (BRentVo vo : result) {
			if (vo.getBrent_enddate() != null)
				System.out.println("도서명 : " + vo.getBook_name() + " 반납일 : " + vo.getBrent_enddate());
		}

		System.out.println("1. 대여일 연장(7일)");
		System.out.println("2. 마이페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.BRENT_EX;
		case 2:
			return View.MY_PAGE;
		default:
			return View.BRENT_HISTORY;
		}
	}

	private View nameUpdate() {
		printline();
		String name = ScanUtil.nextLine("이름을 입력해주세요 : ");
		List<Object> list = new ArrayList<>();
		list.add(name);
		list.add(sessionStorage.get("id"));

		if (!memService.nameUpdate(list))
			System.out.println("잘못된 입력입니다.");
		else
			System.out.println("수정 완료!");

		return View.INFO;
	}

	private View addrUpdate() {
		printline();
		String addr = ScanUtil.nextLine("주소를 입력해주세요 : ");
		List<Object> list = new ArrayList<>();
		list.add(addr);
		list.add(sessionStorage.get("id"));

		if (!memService.addrUpdate(list))
			System.out.println("잘못된 입력입니다.");
		else
			System.out.println("수정 완료!");

		return View.INFO;
	}

	private View telUpdate() {
		printline();
		String tel = ScanUtil.nextLine("전화번호를 입력해주세요 : ");
		List<Object> list = new ArrayList<>();
		list.add(tel);
		list.add(sessionStorage.get("id"));

		if (!memService.telUpdate(list))
			System.out.println("잘못된 입력입니다.");
		else
			System.out.println("수정 완료!");

		return View.INFO;
	}

	private View passUpdate() {
		printline();
		String pass = ScanUtil.nextLine("비밀번호를 입력해주세요 : ");
		List<Object> list = new ArrayList<>();
		list.add(pass);
		list.add(sessionStorage.get("id"));

		if (!memService.passUpdate(list))
			System.out.println("잘못된 입력입니다.");
		else
			System.out.println("수정 완료!");

		return View.INFO;
	}

	private View info() {
		printline();
		MemberVo member = memService.getInfo();
		System.out.println(member);
		System.out.println("1. 비밀번호 수정");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 주소 수정");
		System.out.println("4. 이름 수정");
		System.out.println("5. 마이페이지");

		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.PASS_UPDATE;
		case 2:
			return View.TEL_UPDATE;
		case 3:
			return View.ADDR_UPDATE;
		case 4:
			return View.NAME_UPDATE;
		case 5:
			return View.MY_PAGE;
		default:
			return View.INFO;
		}
	}

	private View myPage() {
		printline();
		System.out.println("1. 내 정보");
		System.out.println("2. 대여현황");
		System.out.println("3. 내가 작성한 리뷰");
		System.out.println("4. 스터디룸 예약 현황");
		System.out.println("5. 홈");

		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.INFO;
		case 2:
			return View.BRENT_HISTORY;
		case 3:
			return View.MY_REVIEW;
		case 4:
			return View.RRENT_HISTORY;
		case 5:
			return View.MEM_HOME;
		default:
			return View.MY_PAGE;
		}
	}

	private View adHome() {
		printline();
		System.out.println("====" + sessionStorage.get("id") + "님 접속 중====");
		
		System.out.println("1. 도서검색");
		System.out.println("2. 스터디룸");
		System.out.println("3. 도서반납");
		System.out.println("4. 도서대여");
		System.out.println("5. 관리");
		System.out.println("6. 로그아웃");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.BOOK_SEARCH;
		case 2:
			return View.ROOM;
		case 3:
			return View.BOOK_RETURN;
		case 4:
			return View.BOOK_RENT;
		case 5:
			return View.MANAGE;
		case 6:
			return View.LOGOUT;
		default:
			return View.AD_HOME;
		}
	}

	private View memHome() {
		printline();
		System.out.println("====" + sessionStorage.get("id") + "님 접속 중====");
		System.out.println("1. 도서검색");
		System.out.println("2. 스터디룸");
		System.out.println("3. 마이페이지");
		System.out.println("4. 로그아웃");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.BOOK_SEARCH;
		case 2:
			return View.ROOM;
		case 3:
			return View.MY_PAGE;
		case 4:
			return View.LOGOUT;
		default:
			return View.HOME;
		}
	}

	private View memSign() {
		printline();
		System.out.println("===회원가입===");
		String id = ScanUtil.nextLine("ID를 입력해주세요 : ");

		List<MemberVo> memberList = memService.memberList();

		for (MemberVo vo : memberList) {
			if (vo.getMem_id().equals(id)) {
				System.out.println("중복된 아이디입니다.");
				return View.LOGIN;
			}
		}

		String pass = ScanUtil.nextLine("비밀번호를 입력해주세요 : ");
		String name = ScanUtil.nextLine("이름을 입력해주세요 : ");
		String tel = ScanUtil.nextLine("전화번호를 입력해주세요 : ");
		String addr = ScanUtil.nextLine("주소를 입력해주세요 : ");
		String birth = ScanUtil.nextLine("생년월일을 입력해주세요(YYMMDD) : ");
		String regno = ScanUtil.nextLine("주민번호 뒷자리를 입력해주세요 : ");

		List<Object> list = new ArrayList<>();
		list.add(id);
		list.add(pass);
		list.add(name);
		list.add(tel);
		list.add(addr);
		list.add(birth + "-" + regno);

		if (memService.memSign(list) == 1)
			System.out.println(list.get(0) + "님 회원가입 완료!");
		else
			System.out.println("회원가입 실패");
		return View.LOGIN;
	}

	private View memLogin() {
		printline();
		System.out.println("===회원 로그인===");
		String id = ScanUtil.nextLine("ID : ");
		String pass = ScanUtil.nextLine("pass : ");

		List<Object> list = new ArrayList<>();
		list.add(id);
		list.add(pass);

		MemberVo mem = memService.loginCheck(list);
		if (mem != null) {
			System.out.println(mem.getMem_name() + "님 환영합니다 !");
			sessionStorage.put("id", mem.getMem_id());
			permission = 1;
			return View.MEM_HOME;
		} else {
			System.out.println("로그인 실패");
			return View.LOGIN;
		}

	}

	private View adLogin() {
		printline();
		System.out.println("===관리자 로그인===");
		String id = ScanUtil.nextLine("ID : ");
		String pass = ScanUtil.nextLine("pass : ");

		List<Object> list = new ArrayList<>();
		list.add(id);
		list.add(pass);

		AdminVo ad = adService.loginCheck(list);
		if (ad != null) {
			System.out.println(ad.getAd_name() + "님 환영합니다 !");
			sessionStorage.put("id", ad.getAd_id());
			permission = 2;
			return View.AD_HOME;
		} else {
			System.out.println("로그인 실패");
			return View.LOGIN;
		}

	}

	private View logIn() { // 로그인
		printline();
		System.out.println("===로그인===");
		System.out.println("1. 관리자 로그인");
		System.out.println("2. 회원 로그인");
		System.out.println("3. 회원가입");
		System.out.println("4. 아이디 찾기");
		System.out.println("5. 비밀번호 찾기");
		System.out.println("6. 홈");

		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.AD_LOGIN;
		case 2:
			return View.MEM_LOGIN;
		case 3:
			return View.MEM_SIGN;
		case 4:
			return View.FIND_ID;
		case 5:
			return View.FIND_PASS;
		case 6:
			return View.HOME;
		default:
			return View.LOGIN;
		}
	}

	private View room() { // 스터디룸
		printline();
		if (sessionStorage.isEmpty()) {
			System.out.println("로그인이 필요한 서비스입니다.");
			return View.HOME;
		}
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date date = cal.getTime();
		
		List<RoomRentVo> list = roomRentService.roomRentList();
		
		System.out.println("====예약 현황====");
		for (RoomRentVo vo : list) {
			boolean check = false;
			try {
				if(sdf.parse(vo.getRrent_rendate()).before(sdf.parse(sdf.format(date))))
					check = true;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(!check)
			System.out.println(vo);
		}
		if(permission == 2)
	         return View.AD_HOME;
	      
	      System.out.println("1. 예약하기");
	      System.out.println("2. 홈");
	      
	      int sel1 = ScanUtil.nextInt("메뉴를 선택해주세요 : ");
	      
	      switch(sel1) {
	      case 1:
	         break;
	      case 2:
	         return View.MEM_HOME;
	      }

		System.out.println("*예약일 선택*");
		
		System.out.println("1 : " + sdf.format(date));
		for (int i = 0; i < 6; i++) {
			cal.add(Calendar.DATE, 1);
			date = cal.getTime();
			System.out.print(i + 2 + " : " + sdf.format(date));
			System.out.println();
		}

		int sel = ScanUtil.nextInt("예약일을 선택해주세요 : ");
		cal.add(Calendar.DATE, sel - 7);
		String rentDate = sdf.format(cal.getTime());
		int roomNum = ScanUtil.nextInt("사용하실 룸 번호(ROOM_NO)를 선택해주세요 (1, 2, 4, 5, 7, 8) : ");
		//// 예약시간대 출력
		printRoom();
		int rentTime = ScanUtil.nextInt("사용하실 시간대를 선택해주세요 (1, 2, 3, 4, 5, 6, 7): ");
		for (RoomRentVo vo : list) {
			if (vo.getRrent_rendate().equals(rentDate) && vo.getRoom_no() == roomNum && vo.getRrt_no() == rentTime) {
				System.out.println("이미 예약된 방입니다");
				return View.MEM_HOME;
			}
		}

		List<Object> param = new ArrayList<>();
		param.add(rentDate);
		param.add(rentTime);
		param.add(roomNum);
		param.add(sessionStorage.get("id"));

		roomRentService.roomRent(param);

		System.out.println("예약이 완료되었습니다.");

		return View.MEM_HOME;

	}

	private View bookSearch() { // 도서검색
		printline();
		System.out.println("=====도서 검색=====");
		System.out.println("1. 전체 조회");
		System.out.println("2. 책 이름 검색");
		System.out.println("3. 책 카테고리 검색");
		System.out.println("4. 홈");

		List<Object> list = new ArrayList<>();

		String param = null;
		List<BookVo> res = new ArrayList<>();

		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return bookList();
		case 2: // 이름 검색
			param = ScanUtil.nextLine("책 이름을 입력해주세요 : ");
			list.add(param);

			res = libService.titleSearch(list);
			for (BookVo vo : res)
				System.out.println(vo);
			return View.BOOK_SEARCH;
		case 3: // 카테고리 검색
			param = ScanUtil.nextLine("책 카테고리를 입력해주세요 : ");
			list.add(param);
			res = new ArrayList<>();
			res = libService.typeSearch(list);
			for (BookVo vo : res)
				System.out.println(vo);
			return View.BOOK_SEARCH;
		case 4:
			if (sessionStorage == null)
				return View.HOME;
			else if (permission == 1)
				return View.MEM_HOME;
			else if (permission == 2)
				return View.AD_HOME;
			else
				return View.HOME;
		default:
			return View.BOOK_SEARCH;
		}
	}

	private View bookList() {
		printline();
		System.out.println("====도서 전체 조회  ====");
		List<BookVo> list = libService.bookList();
		for (BookVo book : list) {
			System.out.println(book);
		}
		return View.BOOK_SEARCH;
	}

//  =============홈=============
	private View home() {
		System.out.println(
				" _      _  _                                ___  ___                                    _____              _                    \r\n" + 
				"| |    (_)| |                               |  \\/  |                                   /  ___|            | |                   \r\n" + 
				"| |     _ | |__   _ __   __ _  _ __  _   _  | .  . |  __ _  _ __    __ _   __ _   ___  \\ `--.  _   _  ___ | |_   ___  _ __ ___  \r\n" + 
				"| |    | || '_ \\ | '__| / _` || '__|| | | | | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\  `--. \\| | | |/ __|| __| / _ \\| '_ ` _ \\ \r\n" + 
				"| |____| || |_) || |   | (_| || |   | |_| | | |  | || (_| || | | || (_| || (_| ||  __/ /\\__/ /| |_| |\\__ \\| |_ |  __/| | | | | |\r\n" + 
				"\\_____/|_||_.__/ |_|    \\__,_||_|    \\__, | \\_|  |_/ \\__,_||_| |_| \\__,_| \\__, | \\___| \\____/  \\__, ||___/ \\__| \\___||_| |_| |_|\r\n" + 
				"                                      __/ |                                __/ |                __/ |                           \r\n" + 
				"                                     |___/                                |___/                |___/                            ");
		System.out.println("=====홈=====");
		System.out.println("1. 도서검색");
		System.out.println("2. 스터디룸");
		System.out.println("3. 로그인");

		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.BOOK_SEARCH;
		case 2:
			return View.ROOM;
		case 3:
			return View.LOGIN;
		default:
			return View.HOME;
		}
	}

}