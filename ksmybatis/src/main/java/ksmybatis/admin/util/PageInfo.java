package ksmybatis.admin.util;

import java.util.List;

import lombok.Data;


@Data
public class PageInfo<T> {
	private List<T> contents;
	private Pageable pageable;
	private int totalRowCount;
	private int currentPage;
	private int lastPage;
	private int startPageNum;
	private int endPageNum;
	
	public PageInfo(List<T> contents, Pageable pageable, int totalRowCount) {
		this.contents = contents;
		this.pageable = pageable;
		this.totalRowCount = totalRowCount;
		pageNumProcess();
	}
	
	private void pageNumProcess() {
		int currentPage = pageable.getCurrentPage();
		int rowPerpage = pageable.getRowPerPage();
		// ex) 총 121개의 행을 한 페이지에 10개씩 -> 총 13page
		// 소수점 절삭이 되지 않기 위해 double형으로 -> ceil(올림) -> 다시 int형으로 절삭
		int lastPage = (int) Math.ceil((double)totalRowCount / rowPerpage);
		
		// 1~10 page 동적페이지 구현(밑에 페이지 목록에서 현재 보여지고 있는 페이지목록이 가운데로오면서 그 페이지를 기준으로 10개만 페이지목록만 보여줌)
		// ex) 현재 보고있는 페이지 : 7페이지 -> 이전 234567891011 다음
		int startPageNum = 1;
		int endPageNum = lastPage < 10 ? lastPage : 10;
		
		if(currentPage > 6 && lastPage > 9) {
			startPageNum = currentPage - 5;
			endPageNum = currentPage + 4;
			if(endPageNum >= lastPage) {
				startPageNum = lastPage - 9;
				endPageNum = lastPage;
			}
		}
		
		this.lastPage = lastPage;
		this.startPageNum = startPageNum;
		this.endPageNum = endPageNum;
		this.currentPage = currentPage;
	}
	
}
