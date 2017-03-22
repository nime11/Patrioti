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
        try {
            System.out.println("Executing job in background...");
            FillData.povni();
            System.out.println("Done executing job.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}