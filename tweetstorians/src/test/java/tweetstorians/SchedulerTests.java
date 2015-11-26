package tweetstorians;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerTests {

	@Test
	public void test() throws SchedulerException, InterruptedException, IOException {
       	JobDetail job = new JobDetail();
    	job.setName("dummyJobName");
    	job.setJobClass(TwitterJob.class);
    	
    	//configure the scheduler time
    	SimpleTrigger trigger = new SimpleTrigger();
    	trigger.setName("dummyTriggerName");
    	GregorianCalendar c = new GregorianCalendar();
    	c.set(2015,11,24,14,40);
    	GregorianCalendar d = new GregorianCalendar();
    	d.setTimeInMillis(System.currentTimeMillis());
    	System.out.println(d.getTime());
    	trigger.setStartTime(c.getTime());
    	//new Date(2015,11,24,13,29);
    	//new Date()
    	
    	trigger.setNextFireTime(c.getTime());
    	
    	
    	//schedule it
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(job, trigger);


    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	in.readLine();

    }

}
