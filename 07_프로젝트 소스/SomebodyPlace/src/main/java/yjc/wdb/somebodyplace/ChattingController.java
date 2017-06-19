package yjc.wdb.somebodyplace;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import yjc.wdb.somebodyplace.bean.Auto;
import yjc.wdb.somebodyplace.bean.Chatting;
import yjc.wdb.somebodyplace.bean.Member;
import yjc.wdb.somebodyplace.service.ChattingService;
import yjc.wdb.somebodyplace.util.MediaUtils;
import yjc.wdb.somebodyplace.util.UploadFileUtils;

@Controller
public class ChattingController {
    
	@Inject
	private ChattingService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ChattingController.class);

	@Resource(name="uploadPath")
	private String uploadPath;
	
	
    @RequestMapping("/chat")
    public String viewChattingPage() {
        return "chatting/chatting";
    }
     
    @RequestMapping("/paint")
    public String viewPaintingPage() {
        return "chatting/paint";
    }
        
    @ResponseBody
    @RequestMapping(value="addChat", method=RequestMethod.POST)	
	public void addChat(Chatting chatting) throws Exception{
		service.registChat(chatting);
	}
    
    @ResponseBody
    @RequestMapping(value="delChat", method=RequestMethod.POST)
    public void delChat(HttpServletRequest req, Chatting chatting) throws Exception {
    	service.delChat(chatting);
    }
    
    @ResponseBody
    @RequestMapping(value="getReceiver", method=RequestMethod.POST)
    public int getReceiver(Member member, HttpServletRequest req, Model model) throws Exception {
    	member.setMember_nickname(req.getParameter("member_nickname"));
    	List<Member> x = service.getReceiver(member);
    	return x.get(0).getMember_code();
    }

    @ResponseBody
    @RequestMapping(value="getRooms", method=RequestMethod.POST)
    public JSONArray getRooms(Chatting chatting, HttpServletRequest req, Model model) throws Exception {
    	chatting.setReceiver(req.getParameter("chat_receiver"));
    	List<Chatting> x = service.getRooms(chatting);
  
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd (HH:mm)");

    	// JSON �������� �ҷ��´�.
    	
    	JSONObject jsonObject = new JSONObject();
    	JSONArray resultArray = new JSONArray();
    	
    	  for(int i=0; i < x.size(); i++){
    		    JSONObject todoInfo = new JSONObject();
    		    todoInfo.put("chat_sender", x.get(i).getChat_sender());
    		    todoInfo.put("sender", x.get(i).getSender());
    		    todoInfo.put("chat_receiver", x.get(i).getChat_receiver());
    		    todoInfo.put("chat_content", x.get(i).getChat_content());
    		    todoInfo.put("chat_time", dateFormat.format(x.get(i).getChat_time()));
    		    resultArray.add(todoInfo);
    		  }
    	return resultArray;
    }
    
    @ResponseBody
    @RequestMapping(value = "getSenderNum", method=RequestMethod.POST)
    public int getSenderNum(Chatting chatting, HttpServletRequest req) throws Exception {
    	chatting.setSender(req.getParameter("sender"));
    	int x =  service.getSenderNum(chatting);
    	
    	return x;
    }
    
    @ResponseBody
    @RequestMapping(value="getReceiverName", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
    public String getReceiverName(Chatting chatting, HttpServletRequest req) throws Exception {
    	chatting.setReceiver(req.getParameter("receiver"));
    	
    	String x = service.getReceiverName(chatting);
    	
    	return x;
    }
    
    @ResponseBody
    @RequestMapping(value="countChatsInRoom", method=RequestMethod.POST)
    public int countChatsInRoom(Chatting chatting, HttpServletRequest req) throws Exception {
    	chatting.setSender(req.getParameter("sender"));
    	chatting.setReceiver(req.getParameter("receiver"));
    	int x = service.countChatsInRoom(chatting);
    	return x;
    }
    
    @ResponseBody
    @RequestMapping(value = "chatList", method=RequestMethod.POST)
    public JSONArray chatList(Chatting chatting, HttpServletRequest req) throws Exception {
    	chatting.setReceiver(req.getParameter("receiver"));
    	chatting.setSender(req.getParameter("sender"));
    	
    	
    	List<Chatting> x = service.chatList(chatting);
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd (HH:mm)");

    	
    	JSONArray resultArray = new JSONArray();
    	
  	  for(int i=0; i < x.size(); i++){
		    JSONObject todoInfo = new JSONObject();
		    todoInfo.put("chat_sender", x.get(i).getChat_sender());
		    todoInfo.put("sender", x.get(i).getSender());
		    todoInfo.put("chat_receiver", x.get(i).getChat_receiver());
		    todoInfo.put("chat_content", x.get(i).getChat_content());
		    todoInfo.put("chat_time", dateFormat.format(x.get(i).getChat_time()));
		    resultArray.add(todoInfo);
		  }
    	
    	return resultArray;
    }
    
    @ResponseBody
    @RequestMapping(value="addDist", method=RequestMethod.POST)	
	public void addDist(HttpServletRequest req, Chatting chatting) throws Exception{
    	chatting.setReceiver(req.getParameter("receiver"));
		service.addDist(chatting);
	}
    
    @ResponseBody
    @RequestMapping(value="readDist", method=RequestMethod.POST)	
	public void readDist(HttpServletRequest req, Chatting chatting) throws Exception{
    	chatting.setReceiver(req.getParameter("receiver"));
		service.readDist(chatting);
	}
    

    
    
    @ResponseBody
    @RequestMapping(value="countDist", method=RequestMethod.POST)	
	public int countDist(HttpServletRequest req, Chatting chatting) throws Exception{
    	chatting.setReceiver(req.getParameter("receiver"));
		int x = service.countDist(chatting);
		
		return x;
	}
    
    @RequestMapping(value="appCountDist", method=RequestMethod.GET)	
    public void appCountDist(HttpServletRequest req, HttpSession session, HttpServletResponse res, Chatting chatting, Model model) throws Exception {

		String callback = req.getParameter("callback");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		req.setCharacterEncoding("utf-8");
		
    	chatting.setReceiver(req.getParameter("receiver"));
		int x = service.countDist(chatting);
		
		map.put("result", x);

		try { 
			result = mapper.writeValueAsString(map);
		}
		catch (JsonGenerationException e) {
			e.printStackTrace();
		}
		catch (JsonMappingException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(callback+"(" + result + ")");
		PrintWriter out = res.getWriter();
		out.write(callback+"(" + result + ")");
	}
    
    
    
    
    @ResponseBody
    @RequestMapping(value="addAutoList", method=RequestMethod.POST)
	public void addAutoList(HttpServletRequest req, Auto auto) throws Exception{
    	auto.setAuto_code(Integer.parseInt(req.getParameter("auto_code")));
    	auto.setAuto_title(req.getParameter("auto_title"));
		service.addAutoList(auto);
	}
    
    @RequestMapping(value="delAutoList", method=RequestMethod.POST)
    public void delAutoList(HttpServletRequest req, Auto auto) throws Exception {
    	auto.setAuto_code(Integer.parseInt(req.getParameter("auto_code")));
    	auto.setAuto_title(req.getParameter("auto_title"));
		service.delAutoList(auto);    	
    }
    
    @ResponseBody
    @RequestMapping(value="readAutoList", method=RequestMethod.GET)
    public JSONArray readAutoList(Auto auto, HttpServletRequest req) throws Exception {
    	auto.setAuto_code(Integer.parseInt(req.getParameter("auto_code")));
    	
    	List<Auto> x = service.readAutoList(auto);
    	
    	JSONArray resultArray = new JSONArray();
    	
    	for(int i=0; i < x.size(); i++){
    		JSONObject todoInfo = new JSONObject();
    		if(x.get(i).getAuto_content()==null) {
    			todoInfo.put("auto_content", "");
    		} else {
    			todoInfo.put("auto_content", x.get(i).getAuto_content());
    		}
		    todoInfo.put("auto_title", x.get(i).getAuto_title());
		    resultArray.add(todoInfo);
		  }
    	return resultArray;
    }
    @ResponseBody
    @RequestMapping(value="addAuto", method=RequestMethod.POST)
    public void addAuto(Auto auto, HttpServletRequest req) throws Exception {
    	auto.setAuto_code(Integer.parseInt(req.getParameter("auto_code")));
    	auto.setAuto_title(req.getParameter("auto_title"));
    	auto.setAuto_content(req.getParameter("auto_content"));
    	
    	if(req.getParameter("auto_content")=="") {
    		auto.setAuto_content(null);
    	}
    	
    	service.addAuto(auto);
    }
    
    @ResponseBody
    @RequestMapping(value="readAuto", method=RequestMethod.POST)
    public JSONArray readAuto(Auto auto, HttpServletRequest req) throws Exception {
       auto.setAuto_title(req.getParameter("auto_title"));
       if(req.getParameter("auto_code")!=null)
       auto.setAuto_code(Integer.parseInt(req.getParameter("auto_code")));
      List<Auto> x = service.readAuto(auto);
      JSONArray resultArray = new JSONArray();
      
      if(x.size()==0) {
          return resultArray;
       }

      else if(x.get(0).getAuto_content()==null) {
         JSONObject todoInfo = new JSONObject();
         todoInfo.put("auto_content", "아직 자동 답변을 입력하지 않았습니다!");
         todoInfo.put("member_nickname", x.get(0).getMember_nickname());
          resultArray.add(todoInfo);
          return resultArray;      
     }
      else {
	      JSONObject todoInfo = new JSONObject();
	      todoInfo.put("auto_content", x.get(0).getAuto_content());
	      todoInfo.put("member_nickname", x.get(0).getMember_nickname());
	      resultArray.add(todoInfo);
	      return resultArray;      
      }
    }
    
    @ResponseBody
	@RequestMapping("displayChatImage")
	public ResponseEntity<byte[]> displayChatImage(String fileName) throws Exception {
		ResponseEntity<byte[]> entity = null;
		
		String ext = fileName.substring(fileName.lastIndexOf(".")+1);
		
		logger.info("ext:"+ext);
		
		MediaType mediaType = MediaUtils.getMediaType(ext);
		logger.info("mediaType:"+mediaType);
		InputStream in = null;
		
		logger.info("File Name : "+fileName);
		
		HttpHeaders headers = new HttpHeaders();
		// uploadPath : resources/upload
		// fileName : /2017/05/18/thumbNail_rose_XXXXXX.jpg
		try {
			in = new FileInputStream(uploadPath + fileName);
			if(mediaType != null) {
				headers.setContentType(mediaType);	
			} else {
				fileName = fileName.substring(fileName.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				String fN = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
				headers.add("Content-Disposition", "attachment; fileName=\""+ fN +"\"");
			}
			
			byte[] data = IOUtils.toByteArray(in);
			entity = new ResponseEntity<byte[]>(data, headers, HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
    
    
    
	@RequestMapping(value="uploadIntoChat", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadIntoChat(MultipartFile file) throws Exception {
		logger.info("originalName:"+file.getOriginalFilename());
		logger.info("size:"+file.getSize());
		logger.info("contentType:"+file.getContentType());
		
		String savedName = UploadFileUtils.uploadFile(file.getOriginalFilename(), uploadPath, file.getBytes());
		
		return new ResponseEntity<>(savedName, HttpStatus.CREATED);
	}  
}