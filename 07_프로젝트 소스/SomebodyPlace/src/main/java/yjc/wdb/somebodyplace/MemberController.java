package yjc.wdb.somebodyplace;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import yjc.wdb.somebodyplace.bean.Member;
import yjc.wdb.somebodyplace.bean.Product;
import yjc.wdb.somebodyplace.service.MemberService;
import yjc.wdb.somebodyplace.service.ProductService;

@SessionAttributes({"member_code", "member_email"})
@Controller
public class MemberController {
	
		@Inject
		private MemberService service;
		@Inject
		private ProductService productservice;
		
		public static int member_code;
		
		@RequestMapping(value="loginForm", method=RequestMethod.GET)
		public String loginForm(Model model){
			model.addAttribute("cont", "member/loginForm.jsp");
			return "index";
		}
		
		@RequestMapping(value="join", method=RequestMethod.GET)
		public String join(Model model, Member member, RedirectAttributes rttr,
				String member_email) throws Exception{
			model.addAttribute("cont", "member/joinForm.jsp");
			return "index";
		}
		
		@RequestMapping(value="join", method=RequestMethod.POST)	
		public String boardFormPost(Member member,  HttpServletRequest req, 
				RedirectAttributes rttr, Model model) throws Exception{
			String email = req.getParameter("email");
			String pw = req.getParameter("pw");
			String nickname = req.getParameter("nickname");
			String birthDate = req.getParameter("birth");
			String gender = req.getParameter("gender");
			String age = req.getParameter("age");
			int age2=Integer.parseInt(age);

			double lat = Double.parseDouble(req.getParameter("lat"));
			double lng = Double.parseDouble(req.getParameter("lng"));

			member.setMember_email(email);
			member.setMember_pw(pw);
			member.setMember_nickname(nickname);
			member.setMember_birth(birthDate);
			member.setMember_lng(lng);	
			member.setMember_lat(lat);
			member.setMember_gender(gender);
			member.setMember_age(age2);
	
			service.regist(member);
			rttr.addFlashAttribute("result", "SUCCESS!!");
			model.addAttribute("cont", "main.jsp");
			return "index";
		}
	
	   @RequestMapping(value="login")
	   public String login( Member member, HttpServletRequest req, Model model,HttpSession session) throws Exception{
		   
	      	    member.setMember_email(req.getParameter("email"));
	      	    member.setMember_pw(req.getParameter("pw"));	      	    
	      	    List<Member> x = service.login(member);
	      	    
	      	    if(x.size() != 0){
//	      	    	System.out.println(x.get(0).getMember_nickname()+", \n "+x.get(0).getMember_email());
	      	    	session.setAttribute("nickname", x.get(0).getMember_nickname());
	      	    	session.setAttribute("code", x.get(0).getMember_code());
	      	    	
	      	     	session.setAttribute("member_nickname", x.get(0).getMember_nickname());
	      	    	session.setAttribute("member_code", x.get(0).getMember_code());
	    	    	
	      	    	// scpark
	      	    	model.addAttribute("member_code", x.get(0).getMember_code());
	      	    	model.addAttribute("member_email", x.get(0).getMember_email());
	      	    	
	      	    	session.setAttribute("member_email", x.get(0).getMember_email());
	      	    	member_code = x.get(0).getMember_code();
	      	    	//로그인시 메인 상품 출력 
	      	       List<Product> list = productservice.selectAllProduct();//광민
	  	         model.addAttribute("Product", list); 
	      	    	
	      	    	model.addAttribute("cont", "main.jsp");
	      	    }else {
	      	    	session.invalidate();
	      	    	
	      	    	model.addAttribute("cont", "member/loginForm.jsp");
	      	    }
	      	    
	      	   
			   return "index";	      
	   }
		   
		@RequestMapping(value="logout")
		public String logout(Model model,HttpSession session){
			
			session.invalidate(); 
					
			model.addAttribute("cont", "main.jsp");
			return "index";
		}
}
