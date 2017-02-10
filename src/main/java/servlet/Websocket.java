package servlet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/ws")

public class Websocket {
	
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	private String comming = "One Guest Comming...";
	private String leaving = "One Guest Leaving...";
	private String hello = "Hello New Guess";
	@OnOpen
    public void onSessionOpened(Session session) throws IOException {  
        System.out.println("onSessionOpened");  
		clients.add(session);
		doBoardcast(comming,session);
		doSingle(hello,session);
        /*for (int i = 0; i < 5; i++) {  
            session.getBasicRemote().sendText(styleString("Test"+i+"...","A"));  
            System.out.println("sending...");             
            try {  
                Thread.currentThread().sleep(500);  
            } catch (InterruptedException e) {}  
        } */
    } 
	
    @OnMessage  
    public void onMessageReceived(String message, Session session) throws IOException {
		System.out.println("Receive Msg : "+message);
		doBoardcast(message,session);
		doSingle(message,session);
    }
	
    @OnClose  
    public void onClose(Session session, CloseReason closeReason){  
        System.out.println("onClose"); 
		doBoardcast(leaving,session);
		clients.remove(session);
    }
	
    @OnError  
    public void onErrorReceived(Throwable t) {  
        System.out.println("onErrorReceived: " + t);  
    }   
	
	private String styleString(String str,String block){
		String s = "<div class='blockA'></div><div class='blockB'></div>";
		if(block == "A"){
			s= "<div class='blockA'><span>"+str+"</span></div><div class='blockB'></div>";
		}else{
			s= "<div class='blockA'></div><div class='blockB'><span>"+str+"</span></div>";
		}
		return s;
	}
	
	private void doBoardcast(String s,Session session){
		try{
			synchronized(clients){
				for(Session client : clients){
					if(!client.equals(session)){
						client.getBasicRemote().sendText(styleString(s,"A"));
					}
				}
			}
		}catch(Exception e){
			System.out.println("Boardcase Err : "+e.toString());
		}
	}
	private void doSingle(String s,Session session){
		try{
			session.getBasicRemote().sendText(styleString(s,"B"));
		}catch(Exception e){
			System.out.println("Single Err : "+e.toString());
		}
	}
	
}
