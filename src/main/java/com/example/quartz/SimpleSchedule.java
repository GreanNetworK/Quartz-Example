package com.example.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Hello world!
 *
 */
public class SimpleSchedule 
{
    public static void main( String[] args ) throws SchedulerException
    {
        JobDetail job = JobBuilder
                .newJob(SimpleJob.class)
                .withIdentity("SimpleJob")
                .build();
        
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("SimpleJob")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .build();
        
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job,trigger);
    }
}
