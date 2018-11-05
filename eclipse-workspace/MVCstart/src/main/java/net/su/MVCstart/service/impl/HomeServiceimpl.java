package net.su.MVCstart.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.su.MVCstart.dao.HomeDAO;
import net.su.MVCstart.dao.ReDAO;
import net.su.MVCstart.domain.HomeVO;
import net.su.MVCstart.domain.ReVO;
import net.su.MVCstart.domain.searchVO;
import net.su.MVCstart.service.HomeService;

import org.springframework.stereotype.Service;

@Service
public class HomeServiceimpl implements HomeService {
	
	@Resource
	private HomeDAO homeDAO;
	@Resource
	private ReDAO reDAO;
	
	public List<HomeVO> selectList(String sbx, String word,String pgnum)	// 검색 및 전체 리스트 메소드
	{
		System.out.println("=== svcimpl list ===");
		System.out.println("검색이 돌앗다 서비스 ㄴ리스트트트트");
		searchVO vo = new searchVO();
		int num = Integer.parseInt(pgnum);
		int first = ((num*20)-(20));
		int sec = (num*20);
		vo.setString(sbx);
		vo.setWord(word);
		vo.setFirst(first);
		vo.setSec(sec);
		List<HomeVO> va = null;
		if(word.equals("")){
			System.out.println("null");
			va = homeDAO.selectList(vo);
		}
		else if(sbx.equals("writer")) {
			System.out.println("wirter");
			va = homeDAO.selectList1(vo);
		}
		else if(sbx.equals("title")){
			va = homeDAO.selectList2(vo);
		}
		else if(sbx.equals("contents")) {
			va = homeDAO.selectList3(vo);
		}
		return va;
	}
	public List<HomeVO> selectall(String sbx, String word)	// 페이징 PGCOUNT 위한 메소드
	{
		System.out.println("== svcimpl all ==");
		System.out.println("검색이 돌앗다 셀렉트 올ㄹㄹㄹㄹㄹㄹ");
		searchVO vo = new searchVO();
		vo.setString(sbx);
		vo.setWord(word);
		List<HomeVO> selall = null;
		if(word.equals("")){
			System.out.println("null");
			selall = homeDAO.selectall(vo);
		}
		else if(sbx.equals("writer")) {
			System.out.println("wirter");
			selall = homeDAO.selectallw(vo);
		}
		else if(sbx.equals("title")){
			selall = homeDAO.selectallt(vo);
		}
		else if(sbx.equals("contents")) {
			selall = homeDAO.selectallc(vo);
		}
		return selall;
	}
	public void insert_db(HomeVO homeVO)					// 등록 메소드
	{
		System.out.println("=== svcimpl insert ===");
		homeDAO.insert_db(homeVO);
	}
	
	public HomeVO select_detail(int num)					 // 상세보기 메소드
	{
		System.out.println("==== svcimpl 상세보기 =====");
		HomeVO dtl = homeDAO.dtl_select(num);
		return dtl;
	}
	public void update_db(HomeVO homeVO)					  // 수정 메소드
	{
		System.out.println("=== svcimpl update ==="+homeVO.getContents());
		homeDAO.update_db(homeVO);
	}
	public void delete_list(int num)							// 삭제 메소드
	{
		homeDAO.delete_list(num);
	}
	public void update_hit(int num)								// 조회수 메소드
	{
		homeDAO.update_hit(num);
	}
	public void comment(ReVO reVO)								// 댓글 등록 메소드
	{
		System.out.println("=== svcimpl comment ===");
		reDAO.comment(reVO);
	}
	public List<ReVO> get_comment(int num)						// 댓글 가져오는 메소드
	{
		List<ReVO> re =reDAO.get_comment(num);
		return re;
	}
	public void comment_delete(int re_num)						// 댓글 삭제 메소드
	{
		reDAO.comment_delete(re_num);
	}
	public void comment_fkdlt(int fk)							
	{
		reDAO.comment_fkdlt(fk);
	}
	public void reply_insert(HomeVO homeVO)
	{
		System.out.println("=== svcimpl reply_insert ===");
		int num_order = homeDAO.reply_select(homeVO);
		homeVO.setNum_order(num_order);
		homeDAO.reply_update(homeVO);
		homeDAO.reply_insert(homeVO);
	}
}