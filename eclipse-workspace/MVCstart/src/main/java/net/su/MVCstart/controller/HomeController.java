package net.su.MVCstart.controller;

import java.util.List;

import javax.annotation.Resource;

import net.su.MVCstart.domain.HomeVO;
import net.su.MVCstart.domain.ReVO;
import net.su.MVCstart.service.HomeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	@Resource
	private HomeService homeService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private String search_box = null;
	private String word = null;
	
	@RequestMapping(value = "/")	// "/"의 의미는 인터넷 치는 주소와 같은 의미
	//method = RequestMethod.GET는 get방식을 의미함
	public String home(Model model, @ModelAttribute("search_box") String search_box, @ModelAttribute("word") String word, @ModelAttribute("pgnum") String pgnum)throws Exception{// 값을 SELECT하는 메소드
		System.out.println("===========controller list===========");
		List<HomeVO> all = homeService.selectall(search_box, word);
		int pgcount = 0;
		int tot = (int)Math.ceil(all.size());
		System.out.println(tot+": tot 글번호 위한 tot");
		if(pgnum.equals(""))
		{
			 pgnum =  "1";
		}
		pgcount = (int)Math.ceil(all.size()/(double)20);
		List<HomeVO> list = homeService.selectList(search_box, word, pgnum);
		model.addAttribute("list", list);				//list 뿌려주며 나중에 for문에서 반복함
		model.addAttribute("pgcount", pgcount);
		model.addAttribute("pgnum", pgnum);
		model.addAttribute("search_box",search_box);
		model.addAttribute("word",word);
		model.addAttribute("tot",tot);
		return "home";	//home.jsp로 이동하겠다
	}
	@RequestMapping(value = "/detail.do")				// 값을 INSERT하는 메소드
	public String detail_view(Model model) {
		System.out.println("==========detail로 넘어왔습니다==============");
		return "detail";	//detail.jsp로 이동하겠다
	}
	@RequestMapping(value = "/insert.do")				// 값을 INSERT하는 메소드
	public String detail_insert(Model model, @ModelAttribute("vo") HomeVO homeVO)throws Exception {
		System.out.println("=======detail_insert로 왔습니다========");
		homeService.insert_db(homeVO);
		return "redirect:/";
	}
	@RequestMapping(value="/dtlselect.do")				// 상세보기
	public String dtlselect(Model model, @RequestParam(value = "num", required = false) int num, @RequestParam(value = "pgnum", required = false) String pgnum, @ModelAttribute("search_box") String search_box, @ModelAttribute("word") String word) {
		homeService.update_hit(num);					// 조회수 hit 증가
		HomeVO dtl = homeService.select_detail(num);	// 게시글 디비 가져옴
		List<ReVO> re = homeService.get_comment(num);	// 댓글 디비 가져옴
		
		model.addAttribute("re", re);
		model.addAttribute("dtl", dtl);
		model.addAttribute("pgnum", pgnum);
		model.addAttribute("search_box", search_box);
		model.addAttribute("word", word);
		return "detail_select";
	}
	@RequestMapping(value="/update.do")
	public String update(Model model, @RequestParam(value = "num", required = false) int num){
		HomeVO dtl1 = homeService.select_detail(num);
		model.addAttribute("dtl1", dtl1);
		return "update";
	}
	@RequestMapping(value = "/update_db.do")		// 게시판 UPDATE하는 메소드
	public String update_db(Model model, @ModelAttribute("vo") HomeVO homeVO)throws Exception {
		System.out.println("HomeController의 update_db 작동"+homeVO.getContents());
		homeService.update_db(homeVO);
		return "redirect:/";
	}
	@RequestMapping(value = "/delete_list.do", method = RequestMethod.GET)	// 값을 DELETE하는 메소드
	public String delete_list(Model model, @RequestParam(value = "num", required = false) int num, @ModelAttribute("search_box") String search_box, @ModelAttribute("word") String word, @ModelAttribute("pgnum") String pgnum){		
		homeService.delete_list(num);
		int fk = num;
		List<HomeVO> all = homeService.selectall(search_box, word);
		int pgcount = 0;
		int tot = (int)Math.ceil(all.size());
		if(pgnum.equals(""))
		{
			 pgnum =  "1";
		}
		pgcount = (int)Math.ceil(all.size()/(double)20);
		homeService.comment_fkdlt(fk);				// 게시글 삭제할 때 해당 댓글 함께 삭제
		System.out.println("=== delete controller ====");
		System.out.println(search_box+": search_box");
		System.out.println(word+": word");
		List<HomeVO> list = homeService.selectList(search_box, word, pgnum);
		model.addAttribute("list", list);
		model.addAttribute("pgcount", pgcount);
		model.addAttribute("tot", tot);
		return "home";	//home.jsp로 이동하겠다
	}
	@RequestMapping(value = "/comment.do")		// 댓글 INSERT IN MYSQL & SELECT FROM MYSQL
	public String comment(Model model, @ModelAttribute("vo") ReVO reVO)throws Exception {
		System.out.println("======= comment insert ========");
		int num = reVO.getFk();
		System.out.println(num+":fk를 말합니다 comment");
		homeService.comment(reVO);
		List<ReVO> re = homeService.get_comment(num);	// 댓글 디비 가져옴
		HomeVO dtl = homeService.select_detail(num);
		model.addAttribute("dtl", dtl);
		model.addAttribute("re", re);
		return "detail_select";
	}
	@RequestMapping(value = "/comment_delete.do")		// 댓글 DELETE
	public String comment_delete(Model model, @RequestParam(value = "re_num", required = false) int re_num, @RequestParam(value = "num", required = false) int num)throws Exception {
		System.out.println("======= comment DELETE ========");
		System.out.println(re_num +":re_num");
		homeService.comment_delete(re_num);				// 댓글 DELETE
		List<ReVO> re = homeService.get_comment(num);	// 댓글 SELECT
		HomeVO dtl = homeService.select_detail(num);
		model.addAttribute("dtl", dtl);
		model.addAttribute("re", re);
		return "detail_select";
	}
	@RequestMapping(value="/reply.do")		// 상세보기.jsp에서 답글.jsp로 값을 보내는 controller
	public String reply(Model model, @RequestParam(value = "num", required = false) int num, @RequestParam(value = "fk", required = false) int fk, @RequestParam(value = "num_order", required = false) int num_order, @RequestParam(value = "deps", required = false) String deps) {
		System.out.println("=== 답글 reply.controller ====");
		System.out.println();
		model.addAttribute("num", num);
		model.addAttribute("fk", fk);
		model.addAttribute("deps", deps);
		model.addAttribute("num_order", num_order);
		return "reply_detail";
	}
	@RequestMapping(value="/reply_insert.do")		// 상세보기.jsp에서 답글.jsp로 값을 보내는 controller
	public String reply_insert(Model model, @ModelAttribute("vo") HomeVO homeVO)throws Exception {
		System.out.println("=== 답글 reply_insert.controller ====");
		System.out.println(homeVO.getFk()+": 부모fk");
		System.out.println(homeVO.getNum_order()+": 부모num_order");
		System.out.println(homeVO.getDeps()+": 부모deps");
		System.out.println(homeVO.getName()+": insert name");
		System.out.println(homeVO.getTitle()+": insert title");
		System.out.println(homeVO.getContents()+": insert contents");
		System.out.println();
		homeService.reply_insert(homeVO);
		return "redirect:/";
	}
}