package tweetstorians;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import java.util.Timer;

import org.junit.Test;

public class TwitterTests {

	@Test
	public void test() throws IOException {
		Timer timer = new Timer();
		GregorianCalendar gc= new GregorianCalendar();
		System.out.println(gc.getTime());
		gc.set(2015,10,27,13,41);
		System.out.println(gc.getTime());
		timer.schedule(new TwitterTask(), gc.getTime());
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
    	in.readLine();
    	timer.schedule(new TwitterTask(), gc.getTime());
	}
	
	@Test
	public void testReadString(){
		TwitterConnection tc = new TwitterConnection();
		for(int i=0; i<14; i++)
		System.out.println(tc.getToTweet());
		//System.out.println(tc.getToTweet());
	}
	
	@Test
	public void testTweetLostHisto() throws IOException{
		
		Timer timer = new Timer();
		GregorianCalendar gc= new GregorianCalendar();
		System.out.println(gc.getTime());
		for(int i=0; i<14; i++){
			gc.set(2015,10,28,21,36,i);
			System.out.println(gc.getTime());
			timer.schedule(new TwitterTask(), gc.getTime());
		}
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
    	in.readLine();
    	timer.schedule(new TwitterTask(), gc.getTime());
	}

}
