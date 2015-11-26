package tweetstorians;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import twitter4j.TwitterException;

public class TwitterJob implements Job{
	public void execute(JobExecutionContext context) throws JobExecutionException {
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