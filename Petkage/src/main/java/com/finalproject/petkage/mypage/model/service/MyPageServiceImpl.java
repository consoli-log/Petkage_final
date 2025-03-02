package com.finalproject.petkage.mypage.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalproject.petkage.common.util.PageInfo;
import com.finalproject.petkage.market.model.vo.PayItems;
import com.finalproject.petkage.market.model.vo.Payment;
import com.finalproject.petkage.market.model.vo.Product;
import com.finalproject.petkage.mypage.model.mapper.MyPageMapper;
import com.finalproject.petkage.mypage.model.vo.Calendar;
import com.finalproject.petkage.review.model.vo.Review;
import com.finalproject.petkage.wherego.model.vo.Heart;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageMapper mypagemapper;
	
	@Override
	public int getOrderAllCount() {
		
		return mypagemapper.getOrderAllCount();
	}

	@Override
	public List<Payment> getOrderList(PageInfo pageInfo, int no) {
		
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
        int limit = pageInfo.getListLimit();
        RowBounds rowBounds = new RowBounds(offset, limit);
        
        return mypagemapper.getOrderList(rowBounds, no);
	}
	
	@Override
	public int getWhReviewAllCount() {
		
		return mypagemapper.getWhReviewAllCount();
	}

	@Override
	public List<Review> getWhReviewList(PageInfo pageInfo, int no) {
		
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
        int limit = pageInfo.getListLimit();
        RowBounds rowBounds = new RowBounds(offset, limit);
        
        return mypagemapper.getWhReviewList(rowBounds, no);
	}
	
	@Override
	public int getPdReviewAllCount() {
		
		return mypagemapper.getPdReviewAllCount();
	}

	@Override
	public List<Payment> getPdReviewList(PageInfo pageInfo, int no) {
		
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
        int limit = pageInfo.getListLimit();
        RowBounds rowBounds = new RowBounds(offset, limit);
        
        return mypagemapper.getPdReviewList(rowBounds, no);
	}
	
	@Override
	@Transactional
	public int pdreview_fupload(Review review) {

		int result = 0;
		result = mypagemapper.pdreview_fupload(review);
		
		return result;
	}
	
	@Override
	public PayItems getPayNoName(int payItemNo) {
		
		return mypagemapper.getPayNoName(payItemNo);
	}
	
	@Override
	public Product findRwProductByNo(int proNo) {
		
		return mypagemapper.selectRwProductByNo(proNo);
	}
	
	@Override
	public PayItems findPayItemsByNo(int payItemNo) {
		
		return mypagemapper.selectPayItemsByNo(payItemNo);
	}
	
	@Override
	public int getHeartAllCount() {
		
		return mypagemapper.getWhReviewAllCount();
	}
	
	@Override
	public List<Heart> getHeartList(PageInfo pageInfo, int no) {
	
	int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
    int limit = pageInfo.getListLimit();
    RowBounds rowBounds = new RowBounds(offset, limit);
    
    return mypagemapper.getHeartList(rowBounds, no);
}

	// 캘린더 축제 리스트
    @Override
    public List<Calendar> getListFestivalCalendar() {
        
        return mypagemapper.getListFestivalCalendar();
    }


}
