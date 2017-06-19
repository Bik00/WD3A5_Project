package yjc.wdb.somebodyplace;

import java.util.ArrayList;
import java.util.List;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
 
public class EchoHandler extends TextWebSocketHandler{
    private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
    
  
    
    private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
    /**
     * Ŭ���̾�Ʈ ���� ���Ŀ� ����Ǵ� �޼ҵ�
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
      
    
        //List����
        sessionList.add(session);
        //logger.info("{} �����", session.getId());
    }
    /**
     * Ŭ���̾�Ʈ�� �����ϼ����� �޽����� �������� �� ����Ǵ� �޼ҵ�
     */
    @Override
    protected void handleTextMessage(WebSocketSession session,
         
        TextMessage message) throws Exception {

        logger.info("{}�� ���� {} ����", session.getId(), message.getPayload());
        
        //�迭�̸� ���� ���� �ְ�, ���������� �ִ� 2���ӿ�
        /*logger.info("{}�� ���� {}����",new String[] {session.getId(), message.getPayload()});*/
        
        //����Ǿ��ִ� ��� Ŭ���̾�Ʈ�鿡�� �޽����� �����Ѵ� 
        //session.sendMessage(new TextMessage("echo:" + message.getPayload()));


 

        for(WebSocketSession sess : sessionList){
            sess.sendMessage(new TextMessage(message.getPayload()));
        }
        
        /*map���
        Interator<String> sessionIds = sessions.keySet().iterator();
        String sessionId="";
        while(sessionIds.hasNext()){s
            sessionId = sessionIds.next();
            sessions.get(sessionId).sendMessaget(new TextMessage("echo:" + message.getPayload()));
            
        }*/
        
    }
    /**
     * Ŭ���̾�Ʈ�� ������ ������ �� ����Ǵ� �޼ҵ�
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session,
            CloseStatus status) throws Exception {
        //list
        sessionList.remove(session);
        //map
        //sessions.remove(session.getId());
        //logger.info("{} ���� ����", session.getId());
    }
    
}