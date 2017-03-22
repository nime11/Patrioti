package com.jetbrains.UI;


import com.jetbrains.core.Calc;
import com.jetbrains.core.Progres;
import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.HorizontalLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lenart on 26. 02. 2017.
 */
public class MuProgresGraphLayout extends HorizontalLayout {

    public MuProgresGraphLayout(){

        ArrayList<Progres> progArry= Calc.Napr();

        Chart chartPMoc = new Chart(ChartType.BAR);
        chartPMoc.setWidth("400px");
        chartPMoc.setHeight("350px");

        // Modify the default configuration a bit
        com.vaadin.addon.charts.model.Configuration confPMoc = chartPMoc.getConfiguration();
        confPMoc.setTitle("Napredk moči");
        confPMoc.setSubTitle("The bigger they are the harder they hit :P");
        confPMoc.getLegend().setEnabled(false); // Disable legend

        //The data

        BeanItemContainer<Progres> containerPMoc =new BeanItemContainer<Progres>(Progres.class);
        containerPMoc.addAll(progArry);
        containerPMoc.sort(new String[] { "moč" }, new boolean[] { false });

        // Wrap the container in a data series
        ContainerDataSeries seriesPMoc = new ContainerDataSeries(containerPMoc);

        //seriesPMoc.setNamePropertyId("ime");
        seriesPMoc.setYPropertyId("moč");
        confPMoc.addSeries(seriesPMoc);

        // Set the category labels on the axis correspondingly
        XAxis xaxisPMoc = new XAxis();
        String namesPMoc[] = new String[11];
        List<Progres> listPMoc = containerPMoc.getItemIds();
        for (int i=0; i<11; i++)
            namesPMoc[i] = listPMoc.get(i).getIme();
        xaxisPMoc.setCategories(namesPMoc);
        xaxisPMoc.setTitle("Igralci");
        xaxisPMoc.setMax(9);
        confPMoc.addxAxis(xaxisPMoc);

        // Set the Y axis title
        YAxis yaxisPMoc = new YAxis();
        yaxisPMoc.setTitle("Moč");
        confPMoc.addyAxis(yaxisPMoc);

        addComponent(chartPMoc);

        //prog total
        Chart chartPtotal = new Chart(ChartType.BAR);
        chartPtotal.setWidth("400px");
        chartPtotal.setHeight("350px");

        // Modify the default configuration a bit
        com.vaadin.addon.charts.model.Configuration confPtotal = chartPtotal.getConfiguration();
        confPtotal.setTitle("Napredk v skupni škodi");
        confPtotal.setSubTitle("The bigger they are the harder they hit :P");
        confPtotal.getLegend().setEnabled(false); // Disable legend

        // The data
        BeanItemContainer<Progres> containerPtotal =new BeanItemContainer<Progres>(Progres.class);
        containerPtotal.addAll(progArry);
        containerPtotal.sort(new String[] { "totaldmg" }, new boolean[] { false });

        // Wrap the container in a data series
        ContainerDataSeries seriesPtotal = new ContainerDataSeries(containerPtotal);

        //seriesPtotal.setNamePropertyId("ime");
        seriesPtotal.setYPropertyId("totaldmg");
        confPtotal.addSeries(seriesPtotal);

        // Set the category labels on the axis correspondingly
        XAxis xaxisPtotal = new XAxis();
        String namesPtotal[] = new String[11];
        List<Progres> listPtotal = containerPtotal.getItemIds();
        for (int i=0; i<11; i++){
            namesPtotal[i] = listPtotal.get(i).getIme();
        }
        xaxisPtotal.setCategories(namesPtotal);
        xaxisPtotal.setTitle("Igralci");
        xaxisPtotal.setMax(9);
        confPtotal.addxAxis(xaxisPtotal);

        // Set the Y axis title
        YAxis yaxisPtotal = new YAxis();
        yaxisPtotal.setTitle("totaldmg");
        confPtotal.addyAxis(yaxisPtotal);

        addComponent(chartPtotal);

        //prog iteligenca
        Chart chartPitel = new Chart(ChartType.BAR);
        chartPitel.setWidth("400px");
        chartPitel.setHeight("350px");

        // Modify the default configuration a bit
        com.vaadin.addon.charts.model.Configuration confPitel = chartPitel.getConfiguration();
        confPitel.setTitle("Napredk v  iteligenci");
        confPitel.setSubTitle("The bigger they are the harder they hit :P");
        confPitel.getLegend().setEnabled(false); // Disable legend

        // The data
        BeanItemContainer<Progres> containerPitel =new BeanItemContainer<Progres>(Progres.class);
        containerPitel.addAll(progArry);
        containerPitel.sort(new String[] { "inteligenca" }, new boolean[] { false });

        // Wrap the container in a data series
        ContainerDataSeries seriesPitel = new ContainerDataSeries(containerPitel);

        //seriesPitel.setNamePropertyId("ime");
        seriesPitel.setYPropertyId("inteligenca");
        confPitel.addSeries(seriesPitel);

        // Set the category labels on the axis correspondingly
        XAxis xaxisPitel = new XAxis();
        String namesPitel[] = new String[11];
        List<Progres> listPitel = containerPitel.getItemIds();
        for (int i=0; i<11; i++){
            namesPitel[i] = listPitel.get(i).getIme();
        }
        xaxisPitel.setCategories(namesPitel);
        xaxisPitel.setTitle("Igralci");
        xaxisPitel.setMax(9);
        confPitel.addxAxis(xaxisPitel);

        // Set the Y axis title
        YAxis yaxisPitel = new YAxis();
        yaxisPitel.setTitle("inteligenca");
        confPitel.addyAxis(yaxisPitel);

        addComponent(chartPitel);

        //prog morski rank
        Chart chartPmrank = new Chart(ChartType.BAR);
        chartPmrank.setWidth("400px");
        chartPmrank.setHeight("350px");

        // Modify the default configuration a bit
        com.vaadin.addon.charts.model.Configuration confPmrank = chartPmrank.getConfiguration();
        confPmrank.setTitle("Napredk v  morskem ranku");
        confPmrank.setSubTitle("The bigger they are the harder they hit :P");
        confPmrank.getLegend().setEnabled(false); // Disable legend

        // The data
        BeanItemContainer<Progres> containerPmrank =new BeanItemContainer<Progres>(Progres.class);
        containerPmrank.addAll(progArry);
        containerPmrank.sort(new String[] { "morski_rank" }, new boolean[] { false });

        // Wrap the container in a data series
        ContainerDataSeries seriesPmrank = new ContainerDataSeries(containerPmrank);

        //seriesPitel.setNamePropertyId("ime");
        seriesPmrank.setYPropertyId("morski_rank");
        confPmrank.addSeries(seriesPmrank);

        // Set the category labels on the axis correspondingly
        XAxis xaxisPmrank = new XAxis();
        String namesPmrank[] = new String[11];
        List<Progres> listPmrank = containerPmrank.getItemIds();
        for (int i=0; i<11; i++){
            namesPmrank[i] = listPmrank.get(i).getIme();
        }

        xaxisPmrank.setCategories(namesPmrank);
        xaxisPmrank.setTitle("Igralci");
        xaxisPmrank.setMax(9);
        confPmrank.addxAxis(xaxisPmrank);

        // Set the Y axis title
        YAxis yaxisPmrank = new YAxis();
        yaxisPmrank.setTitle("morski rank");
        confPmrank.addyAxis(yaxisPmrank);

        addComponent(chartPmrank);

    }
}
