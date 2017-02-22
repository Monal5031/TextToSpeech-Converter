/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTS;

/**
 *
 * @author Monal
 */
import com.sun.speech.freetts.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Formatter;
import org.w3c.dom.events.EventException;
public class speak  {    
	private static final String VOICENAME = "kevin16";  
	private Formatter x;
	
	public speak()  {  
	System.out.println("Enter the complete path of your file which you want to hear.\nDon't Forget to add the file name");
	}  
	
	public void checkFile(String path){
		try
		{
		x=new Formatter(path);
		x.close();
		}
	catch(FileNotFoundException e)
		{
		System.out.println("File Path is not valid");
		}
	}
	
	public String readFile(String path){
		StringBuffer content=new StringBuffer("");
		System.out.println(content);
            try (Scanner in = new Scanner(path)) {
                while (in.hasNext())
                {
                    String s = in.next();
                    content.append(s);
                }
            }
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
		
	}  
