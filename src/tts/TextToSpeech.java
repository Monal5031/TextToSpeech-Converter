/*
 * Everyone is welcome to suggest some innovative changes and help build this project a lot better
 */
package TTS;

/*
 * @author Monal
 */
import com.sun.speech.freetts.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.events.EventException;
public class TextToSpeech  {    
	private static final String VOICENAME = "kevin16";  
	private Formatter x;
	
	public TextToSpeech()  {  
	System.out.println("Enter the complete path of your file which you want to hear.\nDon't Forget to add the file name");
	}  
	
	public String readFile(FileReader path){
            StringBuilder content=new StringBuilder("");
            System.out.println(content);
            try (BufferedReader in = new BufferedReader(path)) {
                String line = in.readLine();
                while (line!=null){
                    content.append(line);
                    line = in.readLine();
                }
            } 
            catch (FileNotFoundException ex) {
                Logger.getLogger(TextToSpeech.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TextToSpeech.class.getName()).log(Level.SEVERE, null, ex);
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
		TextToSpeech talk = new TextToSpeech(); 
		Scanner br = new Scanner(System.in);
		String path = br.nextLine();
		
		System.out.println("path is:"+path);
		try{
                    FileReader fp = new FileReader(path);
                        System.out.println("Hooray!! File exists");
                        String s=talk.readFile(fp);
                        System.out.println("File has been read. Do you wish to hear it? 1-->yes 0-->no");
                        int passer=br.nextInt();
                        if(passer==1)
                             talk.talk(s);
                        br.close();
                }
                catch(FileNotFoundException e1){
                    System.out.println("File does not exists");
	}	
    }
}
