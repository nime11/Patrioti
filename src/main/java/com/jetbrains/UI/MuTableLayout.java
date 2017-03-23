package com.jetbrains.UI;

import com.jetbrains.core.Clan;
import com.jetbrains.core.GetData;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.vaadin.gridutil.cell.GridCellFilter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lenart on 27. 02. 2017.
 */
public class MuTableLayout extends HorizontalLayout implements View{

    public static void main (String[] args) {
        MuTableLayout muTableLayout= new MuTableLayout();
    }
        Date dans = new Date();
        Calendar c = Calendar.getInstance();


        public  MuTableLayout(){
            c.setTime(dans);
            c.add(Calendar.DATE, -1);
            java.sql.Date yesterday = new java.sql.Date( c.getTime().getTime());

            ArrayList<Clan> clanArrayList = GetData.GetArry(yesterday);
            final BeanItemContainer<Clan> ds = new BeanItemContainer<Clan>(Clan.class);
            ds.addAll(clanArrayList);
            Object[] pids = ds.getContainerPropertyIds().toArray();


            Grid grid = new Grid("IGRALCI", ds);
            grid.setWidth("100%");

            //names for hader
            grid.removeColumn("avatar");
            grid.removeColumn("dhit");
            grid.removeColumn("energija");
            grid.removeColumn("mDmg1hit");
            grid.removeColumn("nazadje_viden");



            grid.setColumnOrder("id", "ime", "moč",
                    "kopnsk_rank", "krank","kDmg1hit","inteligenca","morsk_rank","mrank","totaldmg");


            Grid.HeaderRow mainHeader = grid.getDefaultHeaderRow();
            mainHeader.getCell("kopnsk_rank").setText("Kopenski rank");
            mainHeader.getCell("morsk_rank").setText("Morski rank");
            mainHeader.getCell("totaldmg").setText("Skupna škoda");
            mainHeader.getCell("krank").setText("Kopenski rank");
            mainHeader.getCell("mrank").setText("Morski rank");
            mainHeader.getCell("kDmg1hit").setText("Enkaraten kopenski udar");


            //Grup by
            Grid.HeaderRow groupingHeader = grid.prependHeaderRow();
            Grid.HeaderCell namesCell = groupingHeader.join(
                    groupingHeader.getCell("id"),
                    groupingHeader.getCell("ime"));
            namesCell.setHtml("Igralec");
            Grid.HeaderCell land = groupingHeader.join(
                    groupingHeader.getCell("moč"),
                    groupingHeader.getCell("kopnsk_rank"),
                    groupingHeader.getCell("krank"),
                    groupingHeader.getCell("kDmg1hit"));
            land.setHtml("Land Battles");
            Grid.HeaderCell naval = groupingHeader.join(
                    groupingHeader.getCell("inteligenca"),
                    groupingHeader.getCell("morsk_rank"),
                    groupingHeader.getCell("mrank"));
            naval.setHtml("Naval Battles");

            //filters
            final GridCellFilter filter = new GridCellFilter(grid);
            filter.setNumberFilter("id");

            // simple filters
            filter.setTextFilter("ime", true, false);
            filter.setNumberFilter("inteligenca", "smallest", "biggest");
            filter.setNumberFilter("krank" ,"smallest", "biggest");
            filter.setNumberFilter("mrank", "smallest", "biggest");
            filter.setNumberFilter("kDmg1hit", "smallest", "biggest");
            filter.setNumberFilter("moč", "smallest", "biggest");
            filter.setNumberFilter("totaldmg", "smallest", "biggest");


            // Freeze two first columns
            grid.setFrozenColumnCount(2);
            setWidth("100%");
            addComponent(grid);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Welcome to Clani");
    }
}
