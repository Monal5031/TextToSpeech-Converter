import java.io.*;
import java.util.*;
import java.util.Formatter;
import org.w3c.dom.events.EventException;
import com.sun.speech.freetts.*;
public class speak  {    
	private static final String VOICENAME = "kevin8";  
	private Formatter x;
	
	public speak()  {  
	System.out.println("Enter the complete path of your file which you want to hear.\nDon't Forget to add the file name");
	}  
	
	public void checkFile(String path){
		try
		{
		x=new Formatter("C:\\Users\\Monal\\Desktop\\test.txt");
		x.close();
		}
	catch(Exception e)
		{
		System.out.println("File Path is not valid");
		}
	}
	
	public String readFile(String path){
		StringBuffer content=new StringBuffer("");
		System.out.println(content);
		Scanner in = new Scanner("C:\\Users\\Monal\\Desktop\\test.txt");
		while (in.hasNext()) 
		{
			String s = in.next();
			content.append(s); 
		}
	in.close();
		in.close();
		return new String(content);
		
	}
	
	public void talk(String s){
		Voice voice;   
		VoiceManager vm = VoiceManager.getInstance();   
		voice = vm.getVoice(VOICENAME);   
		voice.allocate();  
		try   {
		
			voice.speak(s);
			}// END OF TRY   
		catch(EventException e1)   {
			throw new EventException((short) 0, "Not a Valid Text");
			}// END OF CATCH  
	}
	
	
	public static void main(String[] args)throws Exception  {   
		speak talk = new speak(); 
		Scanner br = new Scanner(System.in);
		String path = br.nextLine();
		System.out.println("path is:"+path);
		talk.checkFile(path);
		String s=talk.readFile(path);
		System.out.println("Text is:"+s);
		System.out.println("File has been read. Do you wish to hear it? 1-->yes 0-->no");
		int passer=Integer.parseInt(br.nextLine());
		if(passer==1)
			talk.talk(s);
		br.close();
	}     
		
	}// END OF CLASS﻿