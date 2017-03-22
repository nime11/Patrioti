package com.jetbrains.UI;



import com.jetbrains.core.MainJob;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;


import static java.util.Objects.requireNonNull;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI{
    ProgresGridLayout progresGridLayout;
    MuTableLayout muTableLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        ProgresGridLayout progresGridLayout= new ProgresGridLayout();
        MuTableLayout muTableLayout = new MuTableLayout();
        MuProgresGraphLayout muProgresGraphLayout = new MuProgresGraphLayout();
        MuGraphLayout muGraphLayout= new MuGraphLayout();

        TabSheet tabsheet = new TabSheet();
        // Create the first tab, specify caption when adding
        Layout tab1 = new VerticalLayout(); // Wrap in a layout
        final Panel panel1 = new Panel();
        panel1.setContent(muTableLayout);

        final Panel panel2 = new Panel();
        panel2.setContent(muGraphLayout);

        tab1.addComponents(panel1,panel2);
        tabsheet.addTab(tab1, "Igralci");

        Layout tab2 = new VerticalLayout(); // Wrap in a layout
        final Panel panel3 = new Panel();
        final Panel panel4 = new Panel();
        panel3.setContent(progresGridLayout);
        panel4.setContent(muProgresGraphLayout);
        tab2.addComponents(panel3,panel4);
        tabsheet.addTab(tab2, "Napredek");

//        Layout tab3 = new VerticalLayout(); // Wrap in a layout
//        tab3.addComponent(muProgresGraphLayout);
//        tabsheet.addTab(tab3, "Grafi");


        setContent(tabsheet);
    }

//    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
//    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
//    public static class MyUIServlet extends VaadinServlet {
//    }

    public static void scheduleMainJob(Scheduler scheduler) throws SchedulerException, ParseException {
        Date d = new Date();
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(new Date()); // sets calendar time/date
        int i=cal.get(Calendar.HOUR_OF_DAY);
        int h=0;
        if(i>=8) {
            h = 24 - i + 8;
        }
        else {
             h = 8-i;
        }
        cal.add(Calendar.HOUR_OF_DAY, h); // adds one hour
        cal.add(Calendar.MINUTE ,2); // adds one hour
        System.out.println("time: "+ cal.getTime());

        requireNonNull(scheduler);

        JobDetail jobDetail =
                newJob(MainJob.class).storeDurably().withIdentity("MAIN_JOB").withDescription("Main Job to Perform").build();

        Trigger trigger =
                newTrigger().forJob(jobDetail).withIdentity("MAIN_JOB_TRIGG").withDescription("Trigger for Main Job")
                        .withSchedule(simpleSchedule().withIntervalInHours(24).repeatForever()).startAt( cal.getTime()).build();

        scheduler.scheduleJob(jobDetail, trigger);
    }




}
