package net.su.MVCstart.service;

import java.util.List;

import net.su.MVCstart.domain.HomeVO;
import net.su.MVCstart.domain.ReVO;


public interface HomeService {
	public List<HomeVO> selectList(String sbx, String word, String pgnum);
	public List<HomeVO> selectall(String sbx, String word);
	public void insert_db(HomeVO homeVO);
	public HomeVO select_detail(int num);
	public void update_db(HomeVO homeVO);
	public void delete_list(int num);
	public void update_hit(int num);
	public void comment(ReVO reVO);
	public List<ReVO> get_comment(int num);
	public void comment_delete(int re_num);
	public void comment_fkdlt(int fk);
	public void reply_insert(HomeVO homeVO);
	
}