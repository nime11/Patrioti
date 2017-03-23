package com.jetbrains.UI;

import com.jetbrains.core.Calc;
import com.jetbrains.core.Progres;
import com.vaadin.data.util.BeanItemContainer;

import com.vaadin.ui.*;
import com.vaadin.ui.Grid.*;

import org.vaadin.gridutil.cell.CellFilterChangedListener;
import org.vaadin.gridutil.cell.GridCellFilter;


import java.util.ArrayList;


/**
 * Created by lenart on 22. 02. 2017.
 */

public class ProgresGridLayout extends HorizontalLayout  {

   public ProgresGridLayout(){
       ArrayList<Progres> progArry= Calc.Napr();
       progArry.get(0).toString();


       final BeanItemContainer<Progres> ds = new BeanItemContainer<Progres>(Progres.class);
       ds.addAll(progArry);
       Object[] pids = ds.getContainerPropertyIds().toArray();

       Grid grid = new Grid("NAPREDEK IGRALCEV", ds);
       grid.setWidth("100%");

       //names for hader
       HeaderRow mainHeader = grid.getDefaultHeaderRow();
       mainHeader.getCell("kopensk_rank").setText("Kopenski rank");
       mainHeader.getCell("morski_rank").setText("Morski rank");
       mainHeader.getCell("totaldmg").setText("Skupna škoda");


       //Grup by
       HeaderRow groupingHeader = grid.prependHeaderRow();
       HeaderCell namesCell = groupingHeader.join(
               groupingHeader.getCell("id"),
               groupingHeader.getCell("ime"));
       namesCell.setHtml("Igralec");
       HeaderCell yearsCell = groupingHeader.join(
               groupingHeader.getCell("inteligenca"),
               groupingHeader.getCell("kopensk_rank"),
               groupingHeader.getCell("morski_rank"),
               groupingHeader.getCell("moč"),
               groupingHeader.getCell("totaldmg"));
       yearsCell.setHtml("Napredek");

       //filters
       final GridCellFilter filter = new GridCellFilter(grid);
       filter.setNumberFilter("id");

        // simple filters
       filter.setTextFilter("ime", true, false);
       filter.setNumberFilter("inteligenca","smallest", "biggest");
       filter.setNumberFilter("kopensk_rank","smallest", "biggest");
       filter.setNumberFilter("morski_rank","smallest", "biggest");
       filter.setNumberFilter("moč","smallest", "biggest");
       filter.setNumberFilter("totaldmg","smallest", "biggest");



       // Freeze two first columns
       grid.setFrozenColumnCount(2);

       setWidth("100%");
       addComponent(grid);


    }

}