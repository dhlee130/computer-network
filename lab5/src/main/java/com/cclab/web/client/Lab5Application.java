package com.cclab.web.client;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab5Application {
	
	private static final Logger logger = LoggerFactory.getLogger(Lab5Application.class);
	
	public static void main(String[] args) {
		logger.info("hello");
		System.out.println("hello");
		
		try {
			
		String host; 
        host = "127.0.0.1"; //컴퓨터 인터넷주소
        
        String sender = new String("leedaehyun@naver.com");
        String recepient = new String("object1602@gmail.com");
        
        
        
        System.out.println("\n=================================================");
        System.out.println("SMTP ----------------------- COMPUTER NETWORK LAB 5");
        System.out.println("=================================================");
        

        Socket t = new Socket(host, 25); 
        BufferedReader in = new BufferedReader(new InputStreamReader(t.getInputStream())); 
        PrintWriter out = new PrintWriter(new OutputStreamWriter(t.getOutputStream()), true);
        
        String line=in.readLine();
        if (!line.startsWith("220")) throw new Exception("SMTP서버가 아닙니다:"+line);
        System.out.println("S : " + line);
        
        out.println("HELO gmail.com");
        System.out.println("C : HELO gmail.com");
        line = in.readLine();
        if (!line.startsWith("250")) throw new Exception("Error in HELO:"+line);
        System.out.println("S : " + line);

        out.println("MAIL FROM: <" + sender + ">");
        System.out.println("C : MAIL FROM: <" + sender + ">");
        line = in.readLine();
        if (!line.startsWith("250")) throw new Exception("Error in MAIL FROM:"+line);
        System.out.println("S : " + line);
        
        out.println("RCPT TO: <" + recepient + ">");
        System.out.println("C : RCPT TO: <" + recepient + ">");
        line = in.readLine();
        if (!line.startsWith("250")) throw new Exception("Error in RCPT TO:"+line);
        System.out.println("S : " + line);
        
        out.println("DATA");
        System.out.println("C : DATA");
        out.println("From: <" + sender + ">");
        System.out.println("C : From: <" + sender + ">");
        out.println("Subject: 20143085");
        System.out.println("C : Subject: 20143085");
        out.println("To: <" + recepient + ">");
        System.out.println("C : To: <" + recepient + ">");
        out.println("lab5 20143085 leedaehyun");
        System.out.println("C : lab5 20143085 leedaehyun");
        out.println(".");
        System.out.println("C : .");
        line = in.readLine();
        System.out.println("S : " + line);
        
        System.out.println("\n=================================================");
        System.out.println("------------Finish sending E-mail-----------------");
        System.out.println("=================================================");
        
		} catch (Exception e) { 
		      System.out.println("Error: " + e); 
	 }
	}
}
