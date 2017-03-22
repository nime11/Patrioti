package com.jetbrains.web;

import com.jetbrains.UI.MyUI;
import org.quartz.SchedulerException;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import java.text.ParseException;

import static com.jetbrains.UI.MyUI.scheduleMainJob;

/**
 * Created by lenart on 22. 03. 2017.
 */
public class LenartQuartzListener extends QuartzInitializerListener {

    @Override
    public void contextInitialized(ServletContextEvent evt) {
        super.contextInitialized(evt);
        // At this point, the default functionality
        // has been executed hence the scheduler has been created!
        ServletContext ctx = evt.getServletContext();
        StdSchedulerFactory factory = (StdSchedulerFactory)
                ctx.getAttribute("org.quartz.impl.StdSchedulerFactory.KEY");
        try {
            scheduleMainJob(factory.getScheduler("LenartScheduler"));
        } catch (SchedulerException e) {
            // properly handle the exception...
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}