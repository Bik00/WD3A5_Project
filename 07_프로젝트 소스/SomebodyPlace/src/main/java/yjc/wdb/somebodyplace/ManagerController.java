package yjc.wdb.somebodyplace;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yjc.wdb.somebodyplace.bean.Board;
import yjc.wdb.somebodyplace.service.BoardService;
import yjc.wdb.somebodyplace.service.PlaceService;
import yjc.wdb.somebodyplace.service.ProductService;

@Controller
public class ManagerController {
	
	@Inject
	private PlaceService placeservice;
	@Inject
	private BoardService boardservice;
	@Inject
	private ProductService productservice;
	
	// 플레이스 관리 페이지 메인
	@RequestMapping(value="placeManager", method=RequestMethod.GET)
	public String mypage(Model model, @ModelAttribute("member_code") String member_code){
		model.addAttribute("placeMPage", "placeManagerStats.jsp");
		model.addAttribute("placePage", "../manager/placeManager.jsp");
		model.addAttribute("cont", "place/place.jsp");
		model.addAttribute("place_logo",PlaceController.place_logo);
		model.addAttribute("place_name",	PlaceController.place_name);
		return "index";
	}
	
	// 플레이스 수정
	@RequestMapping(value="placemodify", method=RequestMethod.GET)
	public String placemodify(Model model){
		model.addAttribute("placeMPage", "modifyPlace.jsp");
		model.addAttribute("placePage", "../manager/placeManager.jsp");
		model.addAttribute("cont", "place/place.jsp");
		model.addAttribute("place_logo",PlaceController.place_logo);
		model.addAttribute("place_name",PlaceController.place_name);
		return "index";
	}
	
	// 신청내역
	@RequestMapping(value="requestList", method=RequestMethod.GET)
	public String requestList(Model model){
		model.addAttribute("placeMPage", "requestList.jsp");
		model.addAttribute("placePage", "../manager/placeManager.jsp");
		model.addAttribute("cont", "place/place.jsp");
		model.addAttribute("place_logo",PlaceController.place_logo);
		model.addAttribute("place_name",PlaceController.place_name);
		return "index";
	}
	
	// 사업자 등록
	@RequestMapping(value="addBusiness", method=RequestMethod.GET)
	public String 	addBusiness(Model model){
		model.addAttribute("placeMPage", "addBusiness.jsp");
		model.addAttribute("placePage", "../manager/placeManager.jsp");
		model.addAttribute("cont", "place/place.jsp");
		model.addAttribute("place_logo",PlaceController.place_logo);
		model.addAttribute("place_name",PlaceController.place_name);
		return "index";
	}
	
	// 카테고리 설정
	@RequestMapping(value="categorySetting", method=RequestMethod.GET)
	public String 	categorySetting(Model model) throws Exception{
		model.addAttribute("placeMPage", "categorySetting.jsp");
		model.addAttribute("placePage", "../manager/placeManager.jsp");
		model.addAttribute("cont", "place/place.jsp");
		model.addAttribute("place_logo",PlaceController.place_logo);
		model.addAttribute("place_name",PlaceController.place_name);
		// 회원코드로 플레이스 코드 찾기 
		int place_code = placeservice.getPlaceCode(MemberController.member_code);
		// 플레이스 코드로 게시판 리스트 불러오기
		model.addAttribute("BoardList", boardservice.selectBoardList(place_code));
		model.addAttribute("place_code", place_code);
		return "index";
	}
	@RequestMapping(value="categoryChange", method=RequestMethod.POST)
	public String categoryChange(Model model, int[] del_code, int[] board_code, String[] board_name, int place_code) throws Exception {
		model.addAttribute("placePage", "placeHome.jsp");
		model.addAttribute("cont", "place/place.jsp");
		
		Board board = new Board();
		if(board_code != null && board_name !=null){
			for(int i=0; i<board_code.length; i++){
				board.setBoard_code(board_code[i]);
				board.setBoard_name(board_name[i]);
				board.setPlace_code(place_code);
				if(board_code[i] == 0){
					boardservice.insertBoard(board);
				}else {
					boardservice.updateBoard(board);
				}
			}
		}
		if(del_code != null){
			for(int i=0; i<del_code.length; i++){
				if(del_code[i] != 0){
					boardservice.deleteBoard(del_code[i]);
				}
			}
		}
		// 현재 회원의 플레이스 카테고리 리스트
		place_code = placeservice.getPlaceCode(MemberController.member_code);
		model.addAttribute("BoardList", boardservice.selectBoardList(place_code));
		// 현재 회원의 플레이스 로고와 플레이스 명
		model.addAttribute("place_logo",PlaceController.place_logo);
		model.addAttribute("place_name",PlaceController.place_name);
		// 현재 회원의 상품 리스트
		model.addAttribute("ProductList", productservice.selectProductList(place_code));
		return "index";
	}
	// 정산 관리
	@RequestMapping(value="currentBudget", method=RequestMethod.GET)
	public String 	currentBudget(Model model){
		model.addAttribute("placeMPage", "currentBudget.jsp");
		model.addAttribute("placePage", "../manager/placeManager.jsp");
		model.addAttribute("cont", "place/place.jsp");
		model.addAttribute("place_logo",PlaceController.place_logo);
		model.addAttribute("place_name",PlaceController.place_name);
		return "index";
	}
	
	
}
