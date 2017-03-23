package com.jetbrains.core;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;

/**
 * Created by lenart on 21. 03. 2017.
 */
public class MainJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext)
            throws JobExecutionException {

        // Simulate job execution for 5 seconds...
        System.out.println("Executing job in background...");
        try {
            FillData.povni();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done executing job.");

    }

}