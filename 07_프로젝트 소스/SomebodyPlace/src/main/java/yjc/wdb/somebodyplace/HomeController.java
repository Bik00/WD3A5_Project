package yjc.wdb.somebodyplace;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String main(Model model){
		model.addAttribute("cont", "main.jsp");
		return "index";
	}
	
	@RequestMapping(value="chat", method=RequestMethod.GET)
	public String chat(Model model){
		
		return "chatting";
	}
	
	   @RequestMapping(value="jusoPopup")   
	   public String jusoPopup(){
	      // return 하면 view 페이지로 forwarding 하는것
	      return "/issue/jusoPopup";      
	   }
	   
	   @RequestMapping(value="memberjusoPopup")   
	   public String memberjusoPopup(){
	      // return 하면 view 페이지로 forwarding 하는것
	      return "/member/jusoPopup";      
	   }
}
