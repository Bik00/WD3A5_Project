package yjc.wdb.somebodyplace;

import java.util.List;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import yjc.wdb.somebodyplace.service.PlaceService;
import yjc.wdb.somebodyplace.service.ProductService;
import yjc.wdb.somebodyplace.bean.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private ProductService productservice;
	@Inject
	private PlaceService placeservice;
	
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
	   public String main(Model model, @RequestParam(defaultValue="0") int dcate_code) throws Exception{
	      
	   
	      if(dcate_code == 0) {
	      
	         List<Product> list = productservice.selectAllProduct();//광민
	         model.addAttribute("Product", list);   
	      }
	      else if(dcate_code==1||dcate_code==2||dcate_code==3){
	    	  
	    	 List<Place> list = placeservice.MainPlacelist(dcate_code);
	    	 System.out.print(list);
	    	 model.addAttribute("Place", list);  
	         System.out.print("플레이스출력");
	         
	      }
	      else if(dcate_code==7||dcate_code==8){
	    	  
	    	  List<Product> list =productservice.selectProductByDcate(dcate_code);//광민
		         model.addAttribute("BigProduct", list); 
		         System.out.print("큰상품출력");
		         
		      }
	      else {
	         List<Product> list =productservice.selectProductByDcate(dcate_code);//광민
	         model.addAttribute("Product", list);
	      }

	      model.addAttribute("cont", "main.jsp");
	      return "index";
	   }
	   

	@RequestMapping(value="chat", method=RequestMethod.GET)
	public String chat(Model model){
		
		return "chatting";
	}
	
	   @RequestMapping(value="jusoPopup")   
	   public String jusoPopup(){
	      // return �ϸ� view �������� forwarding �ϴ°�
	      return "/issue/jusoPopup";      
	   }
	   
	   @RequestMapping(value="memberjusoPopup")   
	   public String memberjusoPopup(){
	      // return �ϸ� view �������� forwarding �ϴ°�
	      return "/member/jusoPopup";      
	   }
}
