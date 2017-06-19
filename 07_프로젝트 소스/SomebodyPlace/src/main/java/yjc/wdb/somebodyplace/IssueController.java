package yjc.wdb.somebodyplace;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import yjc.wdb.somebodyplace.bean.Issue;
import yjc.wdb.somebodyplace.bean.Member;
import yjc.wdb.somebodyplace.service.IssueService;
import yjc.wdb.somebodyplace.service.MemberService;


@Controller
public class IssueController {
	
	@Inject
	private IssueService service;
	
	@Inject
	private MemberService service2;
	
	@RequestMapping(value="issue", method=RequestMethod.GET)
	public String issue(Model model) throws Exception{
		
		List<Issue> list = service.listAll();
		model.addAttribute("list", list);
		model.addAttribute("cont", "issue/issue.jsp");
		return "index";
	}
	
	
	@RequestMapping(value="missue", method=RequestMethod.GET)
	public String missue(Model model) throws Exception{
		
		List<Issue> list = service.listAll();
		model.addAttribute("list", list);
	
		return "/issue/issue";
	}
	
	
	@RequestMapping(value="addIssue", method=RequestMethod.GET)
	public String modifyForm(Model model){
		model.addAttribute("cont", "issue/addIssue.jsp");
		return "index";
	}
	
	
	@RequestMapping(value="m_addIssue", method=RequestMethod.GET)
	public String m_addIssue(Model model){
		
		return "issue/addIssue";
	}
	
	@RequestMapping(value="maddIssue", method=RequestMethod.GET)
	public String mmodifyForm(Model model){
	
		
		return "/issue/addIssue";
	}
	
	@RequestMapping(value="deleteIssue", method=RequestMethod.GET)
	public String deleteIssue(Model model,Issue issue,int issue_code) throws Exception{
		System.out.println(issue.getIssue_code());
		System.out.print(issue_code);
		
		service.remove(issue_code);
		
		
		
		
		List<Issue> list = service.listAll();
		model.addAttribute("list", list);
		model.addAttribute("cont", "issue/issue.jsp");
		return "index";
	}
	

	@RequestMapping(value="searchIssue", method=RequestMethod.POST)	
	public String searchIssue(Issue issue, RedirectAttributes rttr,HttpServletRequest req,Model model,String search_keyword,String keyword) throws Exception{
		
		
		System.out.println("��Ʈ�ѷ�"+issue.getSearch_keyword());
		System.out.println("��Ʈ�ѷ�"+issue.getKeyword());
		
		List<Issue> list2 = service.searchlistAll(issue.getSearch_keyword());
		
		System.out.print(list2);
		model.addAttribute("list", list2);
		model.addAttribute("search_keyword",issue.getSearch_keyword());
		
		model.addAttribute("cont", "issue/issue.jsp");
		return "index";
	}
	
	
	
	
	@RequestMapping(value="createIssue", method=RequestMethod.POST)	
	public String postBoardForm(Issue issue, RedirectAttributes rttr,Model model,String roadAddrPart1,HttpSession session) throws Exception{
		
		 System.out.println(issue.getMember_code());
		 System.out.println(issue.getHashtag());
		 //�ɹ��ڵ�� �г����� �˾Ƴ� 
		 String nickname = service2.read(issue.getMember_code());
		 model.addAttribute("member_nickname",nickname);
		 
		  System.out.println("content:" +issue.getIssue_content());
	      System.out.println("img:" + issue.getIssue_img());
	      System.out.println("�ѱ��ּ�" + issue.getAddress());
	      System.out.println("����"+issue.getLat());
	      System.out.println("�浵"+issue.getLng());
	      System.out.println("�ݰ�"+issue.getRadius());
	 
	      
	   //�̽� DB�� ����ϰ� list�� ���� 
		service.regist(issue);
		List<Issue> list = service.listAll();
		System.out.print(list);
		model.addAttribute("list", list);
		
		//���⼭���� �̽��˸� �����°�!!!
		
		//�Խñ��� ����,�浵,�ݰ��� ������ memberlist�� ���� 
		List<Member> memberlist = service2.listAll(issue.getLat(),issue.getLng(),issue.getRadius());
	
		model.addAttribute("memberlist", memberlist);
		
		session.setAttribute("pushMemberlist",memberlist);
	
	
		model.addAttribute("cont", "issue/issue.jsp");
		return "index";
	}
   


}
