package tweetstorians;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import com.google.common.collect.Lists;
import com.twitter.hbc.core.endpoint.StatusesSampleEndpoint;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;

/**
 * Class to establish a twitter connection based on the given properties in the twitter.properties file 
 * (not part of the git project)
 * @author jhermes
 *
 */
public class TwitterConnection {
	
	
	
	
	private Properties getAccess() {

		Properties prop = new Properties();
		InputStream input = null;
		try {

			input = new FileInputStream("twitter.properties");
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}
	
	

	public void run() throws InterruptedException, TwitterException {
		
		Properties prop = getAccess();

		String consumerKey = prop.getProperty("consumerKey");
		String consumerSecret = prop.getProperty("consumerSecret");
		String token = prop.getProperty("token");
		String tokenSecret = prop.getProperty("tokenSecret");
		// Create an appropriately sized blocking queue
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10000);

		
		Authentication auth = new OAuth1(consumerKey, consumerSecret, token,
				tokenSecret);
		
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(token, tokenSecret));
	    
		GregorianCalendar d = new GregorianCalendar();
    	d.setTimeInMillis(System.currentTimeMillis());
		
	    Status status = twitter.updateStatus("[Automatic tweet] Scheduled to " + d.getTime());
	    System.out.println("Successfully updated the status to [" + status.getText() + "].");
	    
	    
	}

}
