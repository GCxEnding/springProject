package net.su.MVCstart.dao;

import java.util.List;

import net.su.MVCstart.domain.ReVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ReDAO  extends SqlSessionDaoSupport{
	public void comment(ReVO reVO)
	{
		System.out.println("=== dao comment ===");
		System.out.println(reVO.getFk()+":fk");
		System.out.println(reVO.getRe_num()+":re_num");
		System.out.println(reVO.getRe_name()+":re_name");
		System.out.println(reVO.getRe_contents()+":re_contents");
		getSqlSession().insert("re_mapper.comment", reVO);
	}
	public List<ReVO> get_comment(int num)
	{
		List<ReVO> re = getSqlSession().selectList("re_mapper.get_selectList", num);
		return re;
	}
	public void comment_delete(int re_num)
	{
		getSqlSession().delete("re_mapper.delete", re_num);
	}
	public void comment_fkdlt(int fk)
	{
		getSqlSession().delete("re_mapper.fkdlt", fk);
	}
}