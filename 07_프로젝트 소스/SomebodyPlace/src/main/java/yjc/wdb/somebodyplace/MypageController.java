package yjc.wdb.somebodyplace;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.javassist.SerialVersionUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yjc.wdb.somebodyplace.bean.Issue;
import yjc.wdb.somebodyplace.bean.Member;
import yjc.wdb.somebodyplace.service.MemberService;

@Controller
public class MypageController {
	
	@Inject
	private MemberService service;
	
	@RequestMapping(value="myPage", method=RequestMethod.GET)
	public String mypage(Model model){
		model.addAttribute("cont", "mypage/mypage.jsp");
		return "index";
	}
	
	@RequestMapping(value="modifyForm", method=RequestMethod.GET)
	public String modifyForm(Model model){
		model.addAttribute("cont", "mypage/modifyForm.jsp");
		return "index";
	}
	
	@RequestMapping(value="orderList", method=RequestMethod.GET)
	public String orderlist(Model model,String member_code) throws Exception{
		int member_code2=Integer.parseInt(member_code);
	
		
		List<Member> list =service.orderlist(member_code2);
		model.addAttribute("orderlist",list);
		model.addAttribute("cont", "mypage/orderList.jsp");
		return "index";
	}
	
	@RequestMapping(value="cart", method=RequestMethod.GET)
	public String cart(Model model){
		model.addAttribute("cont", "mypage/cart.jsp");
		return "index";
	}
	
	@RequestMapping(value="wishlist", method=RequestMethod.GET)
	public String wishlist(Model model){
		model.addAttribute("cont", "mypage/wishlist.jsp");
		return "index";
	}
	
	@RequestMapping(value="favorites", method=RequestMethod.GET)
	public String fovorties(Model model){
		model.addAttribute("cont", "mypage/favorites.jsp");
		return "index";
	}
	
	@RequestMapping(value="interestSetting", method=RequestMethod.GET)
	public String interestSetting(Model model){
		model.addAttribute("cont", "mypage/interestSetting.jsp");
		return "index";
	}
}
