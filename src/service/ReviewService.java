package service;

import java.util.ArrayList;
import java.util.List;

import controller.MainController;
import dao.ReviewDao;
import vo.ReviewVo;

public class ReviewService {
	private static ReviewService instance = null;

	private ReviewService() {

	}

	public static ReviewService getInstance() {

		if (instance == null) {
			instance = new ReviewService();
		}
		return instance;
	}
	ReviewDao reviewDao = ReviewDao.getInstance();
	
	public List<ReviewVo> myReviewList(){
		List<Object> list = new ArrayList();
		list.add(MainController.sessionStorage.get("id"));
		return reviewDao.myReviewList(list);
	}
	public int reviewInsert(List<Object> param) {
		return reviewDao.reviewInsert(param);
	}
	public int reviewDelete(List<Object> param) {
		return reviewDao.reviewDelete(param);
	}

	public void reviewUpdate(List<Object> param) {
		reviewDao.reviewUpdate(param);
		
	}
	public List<ReviewVo> reviewList() {
		return reviewDao.myReviewList();
	}
}
