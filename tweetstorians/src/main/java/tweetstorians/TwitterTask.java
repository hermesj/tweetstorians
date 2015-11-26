package tweetstorians;

import java.util.TimerTask;

import twitter4j.TwitterException;

public class TwitterTask extends TimerTask {

	@Override
	public void run() {
		TwitterConnection tc = new TwitterConnection();
		try {
			tc.run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
