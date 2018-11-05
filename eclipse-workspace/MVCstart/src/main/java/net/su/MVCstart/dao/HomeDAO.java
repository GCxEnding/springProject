package net.su.MVCstart.dao;

 import java.util.List;

import net.su.MVCstart.domain.HomeVO;
import net.su.MVCstart.domain.searchVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDAO extends SqlSessionDaoSupport{	// DBconnection처럼 작동
	
	public List<HomeVO> selectList(searchVO vo){
		System.out.println("=== dao select list =====");
		return getSqlSession().selectList("mapper.selectList", vo);
	}
	public List<HomeVO> selectList1(searchVO vo){
		System.out.println("=== dao select111 list =====");
		return getSqlSession().selectList("mapper.selectList1", vo);
	}
	public List<HomeVO> selectList2(searchVO vo){
		System.out.println("=== dao select22222 list =====");
		return getSqlSession().selectList("mapper.selectList2", vo);
	}
	public List<HomeVO> selectList3(searchVO vo){
		System.out.println("=== dao select3333 list =====");
		return getSqlSession().selectList("mapper.selectList3", vo);
	}
	public List<HomeVO> selectall(searchVO vo){
		System.out.println("=== dao selectall list =====");
		return getSqlSession().selectList("mapper.selectall", vo);
	}
	public List<HomeVO> selectallw(searchVO vo){
		System.out.println("=== dao selectallw list =====");
		return getSqlSession().selectList("mapper.selectallw", vo);
	}
	public List<HomeVO> selectallt(searchVO vo){
		System.out.println("=== dao selectallt list =====");
		return getSqlSession().selectList("mapper.selectallt", vo);
	}
	public List<HomeVO> selectallc(searchVO vo){
		System.out.println("=== dao selectallc list =====");
		return getSqlSession().selectList("mapper.selectallc", vo);
	}
	public void insert_db(HomeVO homeVO)
	{
		System.out.println("=== dao insert_db =====");
		getSqlSession().insert("mapper.insert_db", homeVO);
		System.out.println("====== after insert_db ======");
	}
	public HomeVO dtl_select(int num)
	{
		System.out.println("=== dao select ===");
		return getSqlSession().selectOne("mapper.dtl_select", num);
	}
	public void update_db(HomeVO homeVO)
	{
		System.out.println("=== dao update_db =====");
		getSqlSession().update("mapper.update_db", homeVO);
		System.out.println("====== after update_db ======");
	}
	public void delete_list(int num)
	{
		System.out.println("=== dao delete_list =====");
		getSqlSession().delete("mapper.delete_list", num);
	}
	public void update_hit(int num)
	{
		System.out.println("=== dao update_hit ===");
		getSqlSession().update("mapper.update_hit", num);
	}
	public void reply_insert(HomeVO homeVO)
	{
		System.out.println("** dao reply_insert **");
		getSqlSession().insert("mapper.reply_insert", homeVO);
		System.out.println("***");
	}
	public int reply_select(HomeVO homeVO)
	{
		System.out.println("=== dao reply_select ===");
		int num_order = getSqlSession().selectOne("mapper.reply_select", homeVO);
		System.out.println(num_order+": dddddddddddddddddddddddddddddd");

		return num_order;
	}
	public void reply_update(HomeVO homeVO)
	{
		System.out.println("=== dao reply_update ===");
		getSqlSession().insert("mapper.reply_update", homeVO);
		System.out.println();
	}
}