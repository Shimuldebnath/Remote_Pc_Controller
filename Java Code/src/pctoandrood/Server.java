package pctoandrood;


import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.File;

import javax.swing.*;

public class Server {

	/* Object declaration */
	
	private static ServerSocket serverSocket;
	private static Socket clientSocket;
	private static InputStreamReader inputStreamReader;
	private static BufferedReader bufferedReader;
	private static String message,db;
	private static Robot robot;	
	static int key=1;
	static String a="rundll32.exe PowrProf.dll,SetSuspendState";
	static String b= "rundll32.exe powrprof.dll,SetSuspendState 0,1,0";
	static String c="Rundll32.exe User32.dll,LockWorkStation";
	
	
   
	public static void main(String[] args)  {
		
		try {         
			
			
		       // String[] command = {"cmd.exe", "/C", "Start", "G:\\Users\\myshortcut.lnk"};
			Process p1 =  Runtime.getRuntime().exec("cmd /c start \"\" \"D:\\Users\\myshortcutss.lnk\"");
		        Process p =  Runtime.getRuntime().exec("cmd /c start \"\" \"D:\\Users\\myshortcut.lnk\"");   
		       
		    } catch (IOException ex) {
		    } 
        
		try {
			robot = new Robot();
			//keyboardmanager = new KeyboardManager();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			serverSocket = new ServerSocket(4444); // Server socket
 
		} catch (IOException e) {
		System.out.println("Could not listen on port: 4444");
		}
 
	  System.out.println("Server started. Listening to the port 4444");
		clientSocket = new Socket();
 
		while (true) {
			try {
                int flag=0;
				clientSocket = serverSocket.accept(); 
				System.out.println("Connection acepted");// accept the client connection
				inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
				bufferedReader = new BufferedReader(inputStreamReader); // get the client message
				message = bufferedReader.readLine();
				
				PrintWriter writer = new PrintWriter("test.bat", "UTF-8");
		
				
			    System.out.println(message);
			    if(message==null)
					message="cls";
			    
					else if(message.substring(0, 1).equals("?"))
					{
					db =message.substring(1);
					message = "cls";
					}
			    
			    /*Volume Up and Down */
			     
					else if(message.equals("up"))
					{
						flag=1;
					writer.println("/*");
					writer.println("cscript /e:jscript \"%~f0\" */");
					message = "var shl = new ActiveXObject(\"WScript.Shell\");for (var i=0; i<2; i++) {shl.SendKeys(String.fromCharCode(0xAF));}";
					writer.println(message);
					}
			    
					else if(message.equals("down"))
					{
						flag=1;
					writer.println("/*");
					writer.println("cscript /e:jscript \"%~f0\" */");
					message = "var shl = new ActiveXObject(\"WScript.Shell\");for (var i=0; i<2; i++) {shl.SendKeys(String.fromCharCode(0xAE));}";
					writer.println(message);
					}
			    
			    /* Volume up and Down */
			    
			    /* Turn off Wifi Hotspot */ 
					else if(message.equals("disconnect"))
					{
						flag=1;
						try {         
							
							
						       // String[] command = {"cmd.exe", "/C", "Start", "G:\\Users\\myshortcut.lnk"};
						        Process p =  Runtime.getRuntime().exec("cmd /c start \"\" \"G:\\Users\\myshortcuts.lnk\"");   
						       
						    } catch (IOException ex) {
						    } 
				        
					}
					else if(message.equalsIgnoreCase("hello"))
					{
						robot.keyPress(KeyEvent.VK_1);
						robot.keyRelease(KeyEvent.VK_1);
						
						
					}
			    
			    
			    /* Power options control */
					else if(message.equalsIgnoreCase("Sleep"))
			 		{
						flag=1;
						writer.println("Rundll32.exe powrprof.dll,SetSuspendState Sleep");	
					}
					else if(message.equalsIgnoreCase("Shut"))
			 		{
						flag=1;
						writer.println("shutdown.exe /s /t 00 ");
					}
					else if(message.equalsIgnoreCase("Restart"))
			 		{
						flag=1;
						writer.println("shutdown.exe /r /t 00");
					}
			    
					else if(message.equalsIgnoreCase("lock"))
			 		{
						flag=1;
						writer.println("Rundll32.exe User32.dll,LockWorkStation");
					}
			    /*power options control*/
				
			    
			    /* Application control */
					else if(message.equalsIgnoreCase("Idm"))
					{
						flag=1;
						writer.println("start IDMan");
					}
					else if(message.equalsIgnoreCase("Bit"))
					{
						flag=1;
						writer.println("start BitTorrent");
					}
					else if(message.equalsIgnoreCase("Control"))
					{
						flag=1;
						writer.println("start controlpanel");
					}
					else if(message.equalsIgnoreCase("Chrome"))
					{
						flag=1;
						writer.println("start chrome");
					}
					else if(message.equalsIgnoreCase("Calculator"))
					{
						flag=1;
						writer.println("start calc");
					}
					else if(message.equalsIgnoreCase("Notepad"))
					{
						flag=1;
						writer.println("start notepad");
					}
					else if(message.equalsIgnoreCase("cmd"))
					{
						flag=1;
						writer.println("start cmd");
					}
					else if(message.equalsIgnoreCase("Km"))
					{
						flag=1;
						writer.println("start KMPlayer");
					}
			    
			    /* Application Controls */
			    
			    /* Website Control */
			    
					else if(message.equalsIgnoreCase("facebook"))
					{
						flag=1;
						writer.println("start chrome facebook.com");
					}
			    
					else if(message.equalsIgnoreCase("twtr"))
					{
						flag=1;
						writer.println("start chrome twitter.com");
					}
			    
					else if(message.equalsIgnoreCase("dailym"))
					{
						flag=1;
						writer.println("start chrome dailymotion.com");
					}
			    
					else if(message.equalsIgnoreCase("youtube"))
					{
						flag=1;
						writer.println("start chrome youtube.com");
					}
			    
					else if(message.equalsIgnoreCase("goal"))
					{
						flag=1;
						writer.println("start chrome goal.com");
					}
			    
					else if(message.equalsIgnoreCase("cricinfo"))
					{
						flag=1;
						writer.println("start chrome espncricinfo.com");
					}
			    
					else if(message.equalsIgnoreCase("google"))
					{
						flag=1;
						writer.println("start chrome google.com");
					}
			    
					else if(message.equalsIgnoreCase("instragram"))
					{
						flag=1;
						writer.println("start chrome instragram.com");
					}
			    
			    /* Website Control */
				
			    
			    /* Keyboard */
			    
				else if(message.equalsIgnoreCase("One"))
				{
					robot.keyPress(KeyEvent.VK_1);
					robot.keyRelease(KeyEvent.VK_1);
					
					
				}
				else if(message.equalsIgnoreCase("AltF4"))
				{
					robot.keyPress(KeyEvent.VK_ALT);
					robot.keyPress(KeyEvent.VK_F4);
					
					robot.keyRelease(KeyEvent.VK_ALT);
					robot.keyRelease(KeyEvent.VK_F4);
				}
			    
				else if(message.equalsIgnoreCase("Two"))
				{
					robot.keyPress(KeyEvent.VK_2);
					robot.keyRelease(KeyEvent.VK_2);
				}
				else if(message.equalsIgnoreCase("Three"))
				{
					robot.keyPress(KeyEvent.VK_3);
					robot.keyRelease(KeyEvent.VK_3);
				}
				else if(message.equalsIgnoreCase("Four"))
				{
					robot.keyPress(KeyEvent.VK_4);
					robot.keyRelease(KeyEvent.VK_4);
				}
				else if(message.equalsIgnoreCase("Five"))
				{
					robot.keyPress(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_5);
				}
				else if(message.equalsIgnoreCase("Six"))
				{
					robot.keyPress(KeyEvent.VK_6);
					robot.keyRelease(KeyEvent.VK_6);
				}
				else if(message.equalsIgnoreCase("Seven"))
				{
					robot.keyPress(KeyEvent.VK_7);
					robot.keyRelease(KeyEvent.VK_7);
				}
				else if(message.equalsIgnoreCase("Eight"))
				{
					robot.keyPress(KeyEvent.VK_8);
					robot.keyRelease(KeyEvent.VK_8);
				}
				else if(message.equalsIgnoreCase("Nine"))
				{
					robot.keyPress(KeyEvent.VK_9);
					robot.keyRelease(KeyEvent.VK_9);
				}
				else if(message.equalsIgnoreCase("Zero"))
				{
					robot.keyPress(KeyEvent.VK_0);
					robot.keyRelease(KeyEvent.VK_0);
				}
				else if(message.equalsIgnoreCase("Q"))
				{
					robot.keyPress(KeyEvent.VK_Q);
					robot.keyRelease(KeyEvent.VK_Q);
				}
				else if(message.equalsIgnoreCase("W"))
				{
					robot.keyPress(KeyEvent.VK_W);
					robot.keyRelease(KeyEvent.VK_W);
				}
				else if(message.equalsIgnoreCase("E"))
				{
					robot.keyPress(KeyEvent.VK_E);
					robot.keyRelease(KeyEvent.VK_E);
				}
				else if(message.equalsIgnoreCase("R"))
				{
					robot.keyPress(KeyEvent.VK_R);
					robot.keyRelease(KeyEvent.VK_R);
				}
				else if(message.equalsIgnoreCase("T"))
				{
					robot.keyPress(KeyEvent.VK_T);
					robot.keyRelease(KeyEvent.VK_T);
				}
				else if(message.equalsIgnoreCase("Y"))
				{
					robot.keyPress(KeyEvent.VK_Y);
					robot.keyRelease(KeyEvent.VK_Y);
				}
				else if(message.equalsIgnoreCase("U"))
				{
					robot.keyPress(KeyEvent.VK_U);
					robot.keyRelease(KeyEvent.VK_U);
				}
				else if(message.equalsIgnoreCase("I"))
				{
					robot.keyPress(KeyEvent.VK_I);
					robot.keyRelease(KeyEvent.VK_I);
				}
				else if(message.equalsIgnoreCase("O"))
				{
					robot.keyPress(KeyEvent.VK_O);
					robot.keyRelease(KeyEvent.VK_O);
				}
			    
				else if(message.equalsIgnoreCase("P"))
				{
					robot.keyPress(KeyEvent.VK_P);
					robot.keyRelease(KeyEvent.VK_P);
				}
				else if(message.equalsIgnoreCase("A"))
				{
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_A);
				}
				else if(message.equalsIgnoreCase("S"))
				{
					robot.keyPress(KeyEvent.VK_S);
					robot.keyRelease(KeyEvent.VK_S);
				}
				else if(message.equalsIgnoreCase("D"))
				{
					robot.keyPress(KeyEvent.VK_D);
					robot.keyRelease(KeyEvent.VK_D);
				}
				else if(message.equalsIgnoreCase("F"))
				{
					robot.keyPress(KeyEvent.VK_F);
					robot.keyRelease(KeyEvent.VK_F);
				}
				else if(message.equalsIgnoreCase("G"))
				{
					robot.keyPress(KeyEvent.VK_G);
					robot.keyRelease(KeyEvent.VK_G);
				}
				else if(message.equalsIgnoreCase("H"))
				{
					robot.keyPress(KeyEvent.VK_H);
					robot.keyRelease(KeyEvent.VK_H);
				}
				else if(message.equalsIgnoreCase("J"))
				{
					robot.keyPress(KeyEvent.VK_J);
					robot.keyRelease(KeyEvent.VK_J);
				}
				else if(message.equalsIgnoreCase("K"))
				{
					robot.keyPress(KeyEvent.VK_K);
					robot.keyRelease(KeyEvent.VK_K);
				}
				else if(message.equalsIgnoreCase("L"))
				{
					robot.keyPress(KeyEvent.VK_L);
					robot.keyRelease(KeyEvent.VK_L);
				}
				else if(message.equalsIgnoreCase("Z"))
				{
					robot.keyPress(KeyEvent.VK_Z);
					robot.keyRelease(KeyEvent.VK_Z);
				}
				else if(message.equalsIgnoreCase("X"))
				{
					robot.keyPress(KeyEvent.VK_X);
					robot.keyRelease(KeyEvent.VK_X);
				}
				else if(message.equalsIgnoreCase("C"))
				{
					robot.keyPress(KeyEvent.VK_C);
					robot.keyRelease(KeyEvent.VK_C);
				}
				else if(message.equalsIgnoreCase("V"))
				{
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_V);
				}
				else if(message.equalsIgnoreCase("B"))
				{
					robot.keyPress(KeyEvent.VK_B);
					robot.keyRelease(KeyEvent.VK_B);
				}
				else if(message.equalsIgnoreCase("N"))
				{
					robot.keyPress(KeyEvent.VK_N);
					robot.keyRelease(KeyEvent.VK_N);
				}
				else if(message.equalsIgnoreCase("M"))
				{
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
				}
				else if(message.equalsIgnoreCase("backspace"))
				{
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				}
				else if(message.equalsIgnoreCase("obak"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_1);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_1);
				}
			    
				else if(message.equalsIgnoreCase("onbut"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_6);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_6);
				}
			    
				else if(message.equalsIgnoreCase("leftbracket"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_9);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_9);
				}
			    
			    
				else if(message.equalsIgnoreCase("rightbracket"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_0);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_0);
				}
			    
				else if(message.equalsIgnoreCase("lessthan"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_COMMA);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_COMMA);
				}
				else if(message.equalsIgnoreCase("duifota"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_SEMICOLON);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_SEMICOLON);
				}
			    
				else if(message.equalsIgnoreCase("coma"))
				{
					robot.keyPress(KeyEvent.VK_COMMA);
					robot.keyRelease(KeyEvent.VK_COMMA);
				}
				else if(message.equalsIgnoreCase("Question"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_SLASH);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_SLASH);
				}
			    
				else if(message.equalsIgnoreCase("Tab"))
				{
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyRelease(KeyEvent.VK_TAB);
				}
				else if(message.equalsIgnoreCase("Enter"))
				{
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
				}
				else if(message.equalsIgnoreCase("CapsLock"))
				{
					robot.keyPress(KeyEvent.VK_CAPS_LOCK);
					robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
				}
				else if(message.equalsIgnoreCase("Shift"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_SHIFT);
				}
				else if(message.equalsIgnoreCase("Ctrl"))
				{
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_CONTROL);
				}
				else if(message.equalsIgnoreCase("Alt"))
				{
					robot.keyPress(KeyEvent.VK_ALT);
					robot.keyRelease(KeyEvent.VK_ALT);
				}
				else if(message.equalsIgnoreCase("space"))
				{
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
				}
				/*else if(message.equalsIgnoreCase("Esc"))
				{
					robot.keyPress(KeyEvent.VK_ESCAPE);
					robot.keyRelease(KeyEvent.VK_ESCAPE);
				}*/
				
				else if(message.equalsIgnoreCase("LeftArrow"))
				{
					robot.keyPress(KeyEvent.VK_LEFT);
					robot.keyRelease(KeyEvent.VK_LEFT);		
				}
				else if(message.equalsIgnoreCase("RightArrow"))
				{
					robot.keyPress(KeyEvent.VK_RIGHT);
					robot.keyRelease(KeyEvent.VK_RIGHT);	
				}
				else if(message.equalsIgnoreCase("UpArrow"))
				{
					robot.keyPress(KeyEvent.VK_UP);
					robot.keyRelease(KeyEvent.VK_UP);	
				}
				else if(message.equalsIgnoreCase("DownArrow")){
					robot.keyPress(KeyEvent.VK_DOWN);
					robot.keyRelease(KeyEvent.VK_DOWN);							
				}
				else if(message.equalsIgnoreCase("Hash"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_3);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_3);	
				}
				else if(message.equalsIgnoreCase("Dollar"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_4);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_4);	
				}
				else if(message.equalsIgnoreCase("Percentage"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_5);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_5);	
				}
				else if(message.equalsIgnoreCase("Attherate"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_2);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_2);	
				}
				else if(message.equalsIgnoreCase("Asterics"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_8);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_8);	
				}
				else if(message.equalsIgnoreCase("Plus"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_EQUALS);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_EQUALS);	
				}
				else if(message.equalsIgnoreCase("Minus"))
				{
					robot.keyPress(KeyEvent.VK_MINUS);
					robot.keyRelease(KeyEvent.VK_MINUS);	
				}
				else if(message.equalsIgnoreCase("Equal"))
				{
					robot.keyPress(KeyEvent.VK_EQUALS);
					robot.keyRelease(KeyEvent.VK_EQUALS);	
				}
				else if(message.equalsIgnoreCase("Slash"))
				{
					robot.keyPress(KeyEvent.VK_SLASH);
					robot.keyRelease(KeyEvent.VK_SLASH);	
				}
				else if(message.equalsIgnoreCase("Semicolon"))
				{
					robot.keyPress(KeyEvent.VK_SEMICOLON);
					robot.keyRelease(KeyEvent.VK_SEMICOLON);	
				}
				else if(message.equalsIgnoreCase("f5"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_F5);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_F5);	
				}
				else if(message.equalsIgnoreCase("escape"))
				{
					robot.keyPress(KeyEvent.VK_ESCAPE);
					robot.keyRelease(KeyEvent.VK_ESCAPE);	
				}
			    
				
			    
			    
			    
			    
			   
			    
			    
			    
				else if(message.equalsIgnoreCase("Ctrl+V"))
				{
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_V);
				}
			    
				else if(message.equalsIgnoreCase("Ctrl+Z"))
				{
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_Z);
					
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_Z);
				}
			    
				else if(message.equalsIgnoreCase("Delete"))
				{
					robot.keyPress(KeyEvent.VK_DELETE);
					robot.keyRelease(KeyEvent.VK_DELETE);
				}
			    
				else if(message.equalsIgnoreCase("Shift+Delete"))
				{
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_DELETE);
					
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_DELETE);
				}
			    
				else if(message.equalsIgnoreCase("Ctrl+S"))
				{
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_S);
					
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_S);
				}
			    
				else if(message.equalsIgnoreCase("Ctrl+A"))
				{
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
				}
			    
				else if(message.equalsIgnoreCase("Ctrl+X"))
				{
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_X);
					
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_X);
				}
			    
				else if(message.equalsIgnoreCase("Ctrl+C"))
				{
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_C);
					
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_C);
				}
				
			    /* Keyboard */
			    
			    /* Mouse Pad */
				
				else if(message.contains(",") && !(message.equalsIgnoreCase(a)) && !(message.equalsIgnoreCase(b)) && !(message.equalsIgnoreCase(c)))
				{
					float movex=Float.parseFloat(message.split(",")[0]);
					float movey=Float.parseFloat(message.split(",")[1]);
	 			Point point = MouseInfo.getPointerInfo().getLocation(); 
					float nowx=point.x;
					float nowy=point.y;
					robot.mouseMove((int)(nowx+movex),(int)(nowy+movey));
					
				} 
			
				else if(message.contains("MOUSE_LEFT_CLICK")){
					
					robot.mousePress(InputEvent.BUTTON1_MASK);
					
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
					
				}
				else if(message.contains("MOUSE_RIGHT_CLICK"))
				{
					robot.mousePress(InputEvent.BUTTON3_MASK);
					robot.mouseRelease(InputEvent.BUTTON3_MASK);
					
				}
			    
			    /* Mouse Pad */
			    
			    
				//writer.println(message);
				writer.close();
				try{
					Process p = Runtime.getRuntime()
						.exec("rundll32 url.dll,FileProtocolHandler test.bat");
					p.waitFor();
					} catch(Exception e){
			//		System.out.println("operation is failed.");
					}
		
				if (flag==1)
				{
		    	try {
				   Thread.sleep(1000);
		    		;
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
				}
				try{
					File file = new File("test.bat");
					if(file.delete()){
				
					}else{
					//		System.out.println("Delete operation is failed.");
						}
					}catch(Exception e){
							e.printStackTrace(); 
					}
				
				inputStreamReader.close();
				clientSocket.close();
				
			} catch (IOException ex) {
			//	System.out.println("Problem in message reading");
			}
		}    
		       
		   
	}
	
	
}
