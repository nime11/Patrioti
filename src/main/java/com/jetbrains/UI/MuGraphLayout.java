package com.jetbrains.UI;

import com.jetbrains.core.Clan;
import com.jetbrains.core.GetData;
import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.addon.charts.model.style.Style;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.HorizontalLayout;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by lenart on 21. 03. 2017.
 */
public class MuGraphLayout extends HorizontalLayout {
    Date dans = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    public MuGraphLayout(){
        dans = Date.valueOf("2017-03-19");
        ArrayList<Clan> clanArrayList = GetData.GetArry(dans);

        Chart chartTotaldmg = new Chart(ChartType.PIE);
        chartTotaldmg.setWidth("600px");
        chartTotaldmg.setHeight("400px");

// Modify the default configuration a bit
        Configuration confTotaldmg = chartTotaldmg.getConfiguration();
        confTotaldmg.setTitle("Skupna škoda  igralcel");
        confTotaldmg.setSubTitle("Top 10 razporeditev");
        confTotaldmg.getLegend().setEnabled(false); // Disable legend
        confTotaldmg.setCredits(null);

// Set some plot options
        PlotOptionsPie options = new PlotOptionsPie();
        confTotaldmg.setPlotOptions(options);
        //The data

        BeanItemContainer<Clan> containerTotal =new BeanItemContainer<Clan>(Clan.class);
        containerTotal.addAll(clanArrayList);
        containerTotal.sort(new String[] { "totaldmg" }, new boolean[] { false });
        List<Clan> listTotal = containerTotal.getItemIds(0,10);

        DataSeries seriesTotal = new DataSeries();
        for (int i =0;i<listTotal.size();i++){
            seriesTotal.add(new DataSeriesItem(listTotal.get(i).getIme(),listTotal.get(i).getTotaldmg()));
        }

        confTotaldmg.addSeries(seriesTotal);

        //end

        //new
        Chart chartDif = new Chart(ChartType.PIE);
        chartDif.setWidth("400px");
        chartDif.setHeight("400px");

// Modify the default configuration a bit
        Configuration confDif = chartDif.getConfiguration();
        confDif.setTitle("Razporeditev škode");
        confDif.setSubTitle("razporeditev škode");
        confDif.getLegend().setEnabled(false); // Disable legend
        confDif.setCredits(null);

// Set some plot options
        PlotOptionsPie optionsDif = new PlotOptionsPie();
        optionsDif.setInnerSize("0"); // Non-0 results in a donut
        optionsDif.setSize("75%");  // Default
        optionsDif.setCenter("50%", "50%"); // Default
        confTotaldmg.setPlotOptions(optionsDif);


        //The data
        List<Clan> listAll = containerTotal.getItemIds(10,containerTotal.size());

        DataSeries seriesDif = new DataSeries();

        long top10 =0;
        for (int i =0;i<listTotal.size();i++)
            top10 += listTotal.get(i).totaldmg;

        long all =0;
        for (int x =0;x<listAll.size();x++)
            all += listAll.get(x).totaldmg;

        seriesDif.add(new DataSeriesItem("Top 10",top10));
        seriesDif.add(new DataSeriesItem("Everyone else",all));


        confDif.addSeries(seriesDif);
        confDif.setScrollbar(new Scrollbar());

        //end

        //new
        Chart chart = new Chart();

        Configuration conf = chart.getConfiguration();

        conf.getChart().setZoomType(ZoomType.XY);

        conf.setTitle("Razmerje med močjo in skupno škodo");
        conf.setSubTitle("Source: erevolution.com");

        // A data series as line graph

        List<Clan> listPtotal = containerTotal.getItemIds();

        XAxis x = new XAxis();
        String names[] = new String[11];
        for (int i=0; i<11; i++){
            names[i] = listPtotal.get(i).getIme();
        }
        x.setCategories(names);
        x.setTitle("Igralci");
        x.setMax(9);
        conf.addxAxis(x);


        YAxis primary = new YAxis();
        primary.setTitle("totaldmg");
        Style style = new Style();
        style.setColor(SolidColor.RED);
        primary.getTitle().setStyle(style);
        conf.addyAxis(primary);

        YAxis snd = new YAxis();
        snd.setTitle("Moč");
        snd.setOpposite(true);
        style = new Style();
        style.setColor(new SolidColor("#4572A7"));
        snd.getTitle().setStyle(style);
        conf.addyAxis(snd);


        Legend legend = new Legend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setAlign(HorizontalAlign.LEFT);
        legend.setX(160);
        legend.setVerticalAlign(VerticalAlign.TOP);
        legend.setY(80);
        legend.setFloating(true);
        conf.setLegend(legend);

        ContainerDataSeries seriesPtotal = new ContainerDataSeries(containerTotal);

        seriesPtotal.setPlotOptions(new PlotOptionsColumn());
        seriesPtotal.setName("totaldmg");
        seriesPtotal.setYPropertyId("totaldmg");
        seriesPtotal.setyAxis(1);
        conf.addSeries(seriesPtotal);

        ContainerDataSeries seriesPtotal2 = new ContainerDataSeries(containerTotal);

        PlotOptionsSpline plotOptions = new PlotOptionsSpline();
        seriesPtotal2.setPlotOptions(plotOptions);
        seriesPtotal2.setName("Moč");
        seriesPtotal2.setYPropertyId("moč");
        plotOptions.setColor(SolidColor.RED);
        conf.addSeries(seriesPtotal2);

        addComponent(chart);
        addComponent(chartDif);
        addComponent(chartTotaldmg);
    }





}
