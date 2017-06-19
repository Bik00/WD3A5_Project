package yjc.wdb.somebodyplace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {
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
	public String orderlist(Model model){
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
