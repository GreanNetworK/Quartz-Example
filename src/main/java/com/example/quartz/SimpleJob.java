/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author wjirawong
 */
public class SimpleJob implements Job {

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.out.println("doing simple job.");
    }
}
