package com.jetbrains.core;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;


/**
 * Created by lenart on 16. 03. 2017.
 */
public class TimerData implements org.quartz.Job {


    SchedulerFactory sf = new StdSchedulerFactory();
    Scheduler sched = sf.getScheduler();


    public TimerData() throws SchedulerException, InterruptedException {
        sched.scheduleJob(job, trigger);
        sched.start();
        Thread.sleep(90L * 1000L);
        sched.shutdown(true);
    }
    // define the job and tie it to our HelloJob class
    JobDetail job = newJob(TimerData.class)
            .withIdentity("job1", "group1")
            .build();
    // compute a time that is on the next round minute
    Date runTime = evenMinuteDate(new Date());

    // Trigger the job to run on the next round minute
    Trigger trigger = newTrigger()
            .withIdentity("trigger1", "group1")
            .startAt(runTime)
            .build();

    // Tell quartz to schedule the job using our trigger


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // Say Hello to the World and display the date/time
        System.out.println("Hello World! - " + new Date());

        try {
            FillData.povni();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
