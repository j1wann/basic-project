package view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import service.LibService;
import service.MemService;
import vo.BookVo;
import vo.MemberVo;

public class Print {
	LibService libService = LibService.getInstance();
	MemService memService = MemService.getInstance();

	public void printBookList() {
		List<BookVo> booklist = libService.bookList();
		for (BookVo book : booklist) {
			System.out.println(book);
		}
	}
	
	public void printMemberList() {
		List<MemberVo> memList= memService.memberList();
		for (MemberVo member : memList) {
			System.out.println(member);
		}
	}
	
	public void printline() {
		System.out.println("\n\n\n");
	}
	
	public void printRoom() { 
		System.out.println("1. 08:00 ~10:00" );
		System.out.println("2. 10:00 ~12:00" );
		System.out.println("3. 12:00 ~14:00" );
		System.out.println("4. 14:00 ~16:00" );
		System.out.println("5. 16:00 ~18:00" );
		System.out.println("6. 18:00 ~20:00" );
		System.out.println("7. 20:00 ~22:00" );
	}
	
}

