/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author wjirawong
 */
public class CronSchedule {

    public static void main(String[] args) throws SchedulerException {
        JobDetail job = JobBuilder
                .newJob(SimpleJob.class)
                .withIdentity("SimpleJob")
                .build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("SimpleJob")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();
        
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
