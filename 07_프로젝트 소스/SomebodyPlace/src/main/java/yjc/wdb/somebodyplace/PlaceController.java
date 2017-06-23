package yjc.wdb.somebodyplace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import yjc.wdb.somebodyplace.bean.Board;
import yjc.wdb.somebodyplace.bean.Detail;
import yjc.wdb.somebodyplace.bean.Member;
import yjc.wdb.somebodyplace.bean.Option;
import yjc.wdb.somebodyplace.bean.Place;
import yjc.wdb.somebodyplace.bean.Post;
import yjc.wdb.somebodyplace.bean.PostContent;
import yjc.wdb.somebodyplace.bean.Product;
import yjc.wdb.somebodyplace.bean.Request;
import yjc.wdb.somebodyplace.service.BoardService;
import yjc.wdb.somebodyplace.service.CateService;
import yjc.wdb.somebodyplace.service.DetailService;
import yjc.wdb.somebodyplace.service.MemberService;
import yjc.wdb.somebodyplace.service.OptionService;
import yjc.wdb.somebodyplace.service.PlaceService;
import yjc.wdb.somebodyplace.service.PostContentService;
import yjc.wdb.somebodyplace.service.PostService;
import yjc.wdb.somebodyplace.service.ProductService;
import yjc.wdb.somebodyplace.service.RequestService;

@Controller
public class PlaceController {
	@Inject
	private PostService postservice;
	@Inject
	private ProductService productservice;
	@Inject
	private PostContentService postcontentservice;
	@Inject
	private OptionService optionservice;
	@Inject
	private DetailService detailservice;
	@Inject
	private CateService cateservice;
	@Inject
	private PlaceService placeservice;
	@Inject
	private MemberService memberservice;
	@Inject
	private BoardService boardservice;
	@Inject
	private RequestService requestservice;
	
	public static String place_name ;
	public static String place_logo ;
	public static int place_code;
	public static String memberEmail;		// 주소로 접속한 email 정보
	public static int member_code_for_email;	// 이메일로 알아낸 회원코드
	
	@RequestMapping(value="placeHome", method=RequestMethod.GET)
	public String placeHome(Model model,@RequestParam(defaultValue="0") int board_code) throws Exception{
		model.addAttribute("placePage", "placeHome.jsp");
		model.addAttribute("cont", "place/place.jsp");
		
		// 현재 회원의 플레이스 로고, 플레이스 명
		model.addAttribute("place_logo",place_logo);
		model.addAttribute("place_name",place_name);
		
		// 현재 회원의 플레이스 카테고리 리스트
		place_code = placeservice.getPlaceCode(MemberController.member_code);
		model.addAttribute("BoardList", boardservice.selectBoardList(place_code));
		
		if(board_code == 0){
			// 현재 회원의 상품 리스트
			model.addAttribute("ProductList", productservice.selectProductList(place_code));
		}else {
			List<Integer> product_code = postservice.selectProductCode(board_code);
			JSONArray pArray = new JSONArray();
			for(int i=0; i<product_code.size(); i++){
				JSONObject pjson = new JSONObject();
				Product pro = productservice.selectProduct(product_code.get(i));
				pjson.put("product_code", pro.getProduct_code());
				pjson.put("product_name", pro.getProduct_name());
				pjson.put("product_img", pro.getProduct_img());
				pjson.put("product_explanation", pro.getProduct_explanation());
				pjson.put("product_price", pro.getProduct_price());
				pArray.add(pjson);
			}
			model.addAttribute("ProductList", pArray);
		}
		
		return "index";
	}
	@RequestMapping(value="place", method=RequestMethod.GET)
	public String place(Place place,Model model,@ModelAttribute("member_code") int member_code,@ModelAttribute("member_email") String member_email){
		
		try {
			model.addAttribute("McateList", cateservice.McateList());  // 메인 카테고리 리스트
			model.addAttribute("DcateList", cateservice.DcateList());	// 세부 카테고리 리스트
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		try {
			placeservice.makechoice(member_code);
			 
			place_logo= placeservice.searchlogo(member_code);
			model.addAttribute("place_logo",place_logo);
			
			place_name = placeservice.read(member_email);	
			model.addAttribute("place_name",place_name);
			
			String categori1=placeservice.searchcategori1(member_code);
			model.addAttribute("mcate_code",categori1);
			
			String categori2=placeservice.searchcategori2(member_code);
			
			List<Request> request_list = requestservice.readMyPlaceRequestList(member_code);
			System.out.println(request_list);
			model.addAttribute("request_list", request_list);

			
			model.addAttribute("dcate_code",categori2);
			model.addAttribute("placeMPage", "placeManagerStats.jsp");
			model.addAttribute("placePage", "../manager/placeManager.jsp");
			model.addAttribute("cont", "place/place.jsp");
			
			
			return "index";
		} catch (Exception e) {
			
			
			model.addAttribute("PlaceX",3);
			model.addAttribute("cont", "place/placeAddForm.jsp");
			return "index";
		}
	}
	
	@RequestMapping(value="postForm", method=RequestMethod.GET)
	public String postForm(Model model) throws Exception{
		model.addAttribute("placePage", "postForm.jsp");
		model.addAttribute("cont", "place/place.jsp");
		model.addAttribute("place_logo", place_logo);
		model.addAttribute("place_name", place_name);
		model.addAttribute("McateList", cateservice.McateList());	// 메인 카테고리 리스트
		model.addAttribute("DcateList", cateservice.DcateList());	// 세부 카테고리 리스트
		// 현재 회원의 플레이스 카테고리 리스트
		place_code = placeservice.getPlaceCode(MemberController.member_code);
		List<Board> board = boardservice.selectBoardList(place_code);
		model.addAttribute("BoardList", board);
		// 플레이스 카테고리 중 첫번째 카테고리의 코드
		Board minboardcode = Collections.min(board, new BoardCodeAsc());
		model.addAttribute("minBoardCode", minboardcode.getBoard_code());
		// 현재 회원의 플레이스 코드
		model.addAttribute("placeCode", place_code);
		
		return "index";
	}
	
	// 게시판 코드 오름차순 정렬
	class BoardCodeAsc implements Comparator<Board> {
	    @Override
	    public int compare(Board b1, Board b2) {
	        return b1.getBoard_code() < b2.getBoard_code() ? -1 : b1.getBoard_code() > b2.getBoard_code() ? 1:0;      
	    }
	}

	@RequestMapping(value="addPost", method=RequestMethod.POST)
	public String addPost(Model model, String[] content, String[] option_name 
			, Post post, Product product, String[] detail_name, int[] additional_price
			, int[] detailLength) throws Exception{
		model.addAttribute("placePage", "placeHome.jsp");
		model.addAttribute("cont", "place/place.jsp");
		productservice.insert(product);		//플레이스코드, 상품명, 상품이미지, 가격, 설명 insert
		postservice.insert(post);	// 게시판코드, 상품코드, 해시태그, 메인카테, 세부카테 insert
		if(content != null) {
			PostContent postcontent = new PostContent();
			for(String postcon : content){
				postcontent.setContent(postcon);
				postcontentservice.insert(postcontent);	// 게시글코드, 게시글 내용 insert
			}
		}
		if(option_name != null && detail_name != null){
			Option option = new Option();
			Detail detail = new Detail();
			int j = 0;	// detailLength (각 옵션별 세부옵션 개수) 의 인덱스 
			int index = 0; // 세부옵션명과 추가가격의 인덱스 (배열 크기만큼 계속 증가시켜야하기때문) i를 사용하면 반복문 돌때마다 0으로 초기화하기때문에 안됨
			for(String optionName : option_name){
				option.setOption_name(optionName);
				optionservice.insert(option);		// 상품코드, 옵션명 insert    
				int optionCode = optionservice.selectOptionCode();	// 가장 마지막에 넣은 옵션코드를 읽어옴
				detail.setOption_code(optionCode);	// 세부옵션 테이블에 참조되는 옵션코드
				for(int i=0; i<detailLength[j]; i++){	
					// 각 옵션별 세부옵션 개수만큼 반복하면서 데이터를 집어넣음
					// ex) 옵션명 : 사이즈 , 세부옵션 : S, M, L 이면
					// 사이즈 코드 동일에 S, M, L 따로 insert 해야함
					detail.setDetail_name(detail_name[index]);
					detail.setAdditional_price(additional_price[index]);
					detailservice.insert(detail);		// 옵션코드, 세부옵션명, 추가가격 insert
					if(index < detail_name.length)
						index++;
				}
				if(j < detailLength.length){
					j++;
				}
			}
		}
		// 현재 회원의 플레이스 카테고리 리스트
		place_code = placeservice.getPlaceCode(MemberController.member_code);
		model.addAttribute("BoardList", boardservice.selectBoardList(place_code));
		// 현재 회원의 플레이스 로고와 플레이스 명
		model.addAttribute("place_logo",place_logo);
		model.addAttribute("place_name",place_name);
		// 현재 회원의 상품 리스트
		model.addAttribute("ProductList", productservice.selectProductList(place_code));
		return "index";
	}
	
	@RequestMapping(value="placeMain", method=RequestMethod.GET)
	public String placeMain(Model model){
		model.addAttribute("cont", "place/placeMain.jsp");
		
		return "index";
	}
	
	// 플레이스 생성 폼
	@RequestMapping(value="placeAddForm", method=RequestMethod.GET)
	public String placeAddForm(Model model) throws Exception{
		model.addAttribute("cont", "place/placeAddForm.jsp");
		model.addAttribute("McateList", cateservice.McateList());	// 메인 카테고리 리스트
		model.addAttribute("DcateList", cateservice.DcateList());	// 세부 카테고리 리스트
		return "index";
	}
	
	// 플레이스 생성
	@RequestMapping(value="create", method=RequestMethod.POST)	
	public String postBoardForm(Board board, Place place, RedirectAttributes rttr,Model model) throws Exception{
		placeservice.regist(place);
		
		boardservice.insertInit(board);
		
		model.addAttribute("place_name",place.getPlace_name());
		model.addAttribute("place_logo",place.getPlace_logo());
		model.addAttribute("mcate_code", place.getMcate_code());
		model.addAttribute("dcate_code", place.getDcate_code());
		model.addAttribute("placeMPage", "placeManagerStats.jsp");
		model.addAttribute("placePage", "../manager/placeManager.jsp");
		model.addAttribute("cont", "place/place.jsp");
		place_name = place.getPlace_name();
		return "index";
	}
   
	@RequestMapping("/{member_email}")
	public String page(@PathVariable String member_email,Model model,Place place) throws Exception {
		memberEmail = member_email;
		member_code_for_email= memberservice.read2(memberEmail+".com");
		
		String place_logo= placeservice.searchlogo(member_code_for_email);
		model.addAttribute("place_logo",place_logo);
		
		String place_name = placeservice.read(memberEmail+".com");	
		model.addAttribute("place_name",place_name);
		
		String categori1=placeservice.searchcategori1(member_code_for_email);
		model.addAttribute("mcate_code",categori1);
		
		String categori2=placeservice.searchcategori2(member_code_for_email);
		model.addAttribute("dcate_code",categori2);
		
		model.addAttribute("placePage", "placeHome.jsp");
		model.addAttribute("cont", "place/place.jsp");
		// 현재 플레이스의 플레이스 카테고리 리스트
		place_code = placeservice.getPlaceCode(member_code_for_email);
		model.addAttribute("BoardList", boardservice.selectBoardList(place_code));

		// 현재 플레이스의 상품 리스트
		model.addAttribute("ProductList", productservice.selectProductList(place_code));
		
		return "index";
	}
	
	// 게시글 폼화면
	@RequestMapping(value="postDefault")
	public String postDefault(Model model, int product_code) throws Exception{
		//상품클릭시 위에 플레이스명 그대로 가져오기
		
		model.addAttribute("placePage", "postDefault.jsp");
		model.addAttribute("cont", "place/place.jsp");
		model.addAttribute("product_code",product_code); //광민

		// 상품 정보 가져오기
		Product product = productservice.selectProduct(product_code);
		model.addAttribute("product", product);
		//타입 가져오기(광민)
		String type=postservice.searchType(product_code);
		model.addAttribute("type",type);
		// 옵션 정보 가져오기
		List<Option> option = optionservice.selectOption(product_code);
		model.addAttribute("option", option);
		// 세부옵션 정보 가져오기
		JSONArray detailArray = new JSONArray();
		for(int i=0; i<option.size(); i++){
			 List<Detail> detail = detailservice.selectDetail(option.get(i).getOption_code());
			 for(int j=0; j<detail.size(); j++){
				 JSONObject detailJson = new JSONObject();
				 detailJson.put("detail_code", detail.get(j).getDetail_code());
				 detailJson.put("detail_name", detail.get(j).getDetail_name());
				 detailJson.put("option_code", detail.get(j).getOption_code());
				 detailJson.put("add_price", detail.get(j).getAdditional_price());
				 detailArray.add(detailJson);
			 }
		}
		model.addAttribute("detailArray", detailArray);
		// 게시글 내용 정보 가져오기
		int post_code = postservice.selectPostCode(product_code);
		List<PostContent> post_content = postcontentservice.selectPostContent(post_code);
		model.addAttribute("postContent", post_content);
		// 게시글의 플레이스 정보 가져오기
		model.addAttribute("place_logo", product.getPlace_logo());
		model.addAttribute("place_name", product.getPlace_name());
		
		// 현재 로그인한 회원의 코드
		model.addAttribute("member_code", MemberController.member_code);
		
		return "index";
	}
	
	//신청하기 버튼 클릭시 
	@RequestMapping(value="postRequest", method=RequestMethod.POST)
	public String postRequest(Model model, HttpServletRequest req,Post post) throws Exception{
	
	
		int product_code = Integer.parseInt(req.getParameter("product_code"));
		int member_code = Integer.parseInt(req.getParameter("member_code"));
		//여기서부터 광민 
		String type2=req.getParameter("type");
		String type[]=type2.split(",");
		for(int k=0; k<type.length;k++){
			System.out.println(type[k]);
		}
		model.addAttribute("type",type);
		//광민
		String[] detail_code = req.getParameterValues("detail_code");
		List<Detail> detail_info = new ArrayList<Detail>();
		
		for(int k = 0; k<detail_code.length;k++) {
			Detail detail = productservice.selectDetailInfo(Integer.parseInt(detail_code[k]));
			detail_info.add(k, detail);
		}

		model.addAttribute("detail_info", detail_info);
		model.addAttribute("product_price", Integer.parseInt(req.getParameter("product_price")));
		model.addAttribute("product_Total", Integer.parseInt(req.getParameter("product_Total")));
		model.addAttribute("type", type);
		
		model.addAttribute("placePage", "postRequest.jsp");
		model.addAttribute("cont", "place/place.jsp");
		
		// 상품 정보 가져오기
		Product product = productservice.selectProduct(product_code);
		model.addAttribute("product", product);
		// 옵션 정보 가져오기
		List<Option> option = optionservice.selectOption(product_code);
		model.addAttribute("option", option);
		// 세부옵션 정보 가져오기
		JSONArray detailArray = new JSONArray();
		for(int i=0; i<option.size(); i++){
			 List<Detail> detail = detailservice.selectDetail(option.get(i).getOption_code());
			 for(int j=0; j<detail.size(); j++){
				 JSONObject detailJson = new JSONObject();
				 detailJson.put("detail_code", detail.get(j).getDetail_code());
				 detailJson.put("detail_name", detail.get(j).getDetail_name());
				 detailJson.put("option_code", detail.get(j).getOption_code());
				 detailJson.put("add_price", detail.get(j).getAdditional_price());
				 detailArray.add(detailJson);
			 }
		}
		model.addAttribute("detailArray", detailArray);
		// 게시글 내용 정보 가져오기
	
		// 게시글의 플레이스 정보 가져오기
		model.addAttribute("place_logo", product.getPlace_logo());
		model.addAttribute("place_name", product.getPlace_name());
		
		return "index";
	}
	
	
	
	//결제하기 버튼 클릭시 
	@RequestMapping(value="moneysuccess", method=RequestMethod.POST)
	public String moneysuccess(Model model, Member member, HttpServletRequest req,String request_type) throws Exception{
	
		// 총가격
		int total_price = Integer.parseInt(req.getParameter("productTotalPrice"));
		
		//회원 db업데이트!! 
		memberservice.requestupdate(member);
		
		int a= member.getMember_code();
		//신청 테이블 인설트 
		requestservice.insertRequest(a);
		
		Request request = new Request();
		int product_code = Integer.parseInt(req.getParameter("productCodeNum"));
		System.out.print("선택한타입"+request_type);
		request.setRequest_type(request_type);
		request.setProduct_code(product_code);
		request.setRequest_code(requestservice.readRequestCode(a));
		request.setRequest_list_totalprice(total_price);
		
		requestservice.insertRequestList(request);
		request.setRequest_list_code(requestservice.readRequestListCode(request.getRequest_code()));

		
		String[] detail_code = req.getParameterValues("detailCodeNum");
		for(int k = 0; k<detail_code.length;k++) {
			System.out.println(detail_code[k]);
			request.setDetail_code(Integer.parseInt(detail_code[k]));
			requestservice.insertRequestOption(request);
		}
		
	    model.addAttribute("cont", "main.jsp");
	    return "index";
	}
}
