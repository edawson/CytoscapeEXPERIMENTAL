/*
 * Created on Oct 6, 2006
 *
 */
package org.reactome.CS.FIModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.reactome.funcInt.Interaction;
import org.reactome.funcInt.Protein;

public class FIListTableModel extends AbstractTableModel {
    private String[] colNames = new String[] {"DB_ID", "FirstProtein", "Second Protein"};
    // displayed interactions
    private List<Interaction> interactions;
    // Used for sorting: default is dbId, the first column
    private int sortingCol = 0;
    
    public FIListTableModel() {
    }
    
    public void sort(int sortingCol) {
        if (this.sortingCol == sortingCol)
            return;
        this.sortingCol = sortingCol;
        Comparator<Interaction> sorter = getSorter(sortingCol);
        Collections.sort(interactions, sorter);
        fireTableDataChanged();
    }
    
    private Comparator<Interaction> getSorter(int col) {
        Comparator<Interaction> comparator = null;
        if (col == 0) {
            comparator = new Comparator<Interaction>() {
                public int compare(Interaction int1,
                                   Interaction int2) {
                    long dbId1 = int1.getDbId();
                    long dbId2 = int2.getDbId();
                    return (int)(dbId1 - dbId2);
                }
            };
        }
        else if (col == 1) {
            comparator = new Comparator<Interaction>() {
                public int compare(Interaction int1,
                                   Interaction int2) {
                    Protein protein1 = int1.getFirstProtein();
                    Protein protein2 = int2.getFirstProtein();
                    return protein1.getPrimaryAccession().compareTo(protein2.getPrimaryAccession());
                }
            };
        }
        else if (col == 2) {
            comparator = new Comparator<Interaction>() {
                public int compare(Interaction int1,
                                   Interaction int2) {
                    Protein protein1 = int1.getSecondProtein();
                    Protein protein2 = int2.getSecondProtein();
                    return protein1.getPrimaryAccession().compareTo(protein2.getPrimaryAccession());
                }
            };
        }
        return comparator;
    }
    
    public Interaction getInteraction(int index) {
        return interactions.get(index);
    }
    
    public void setInteractions(List<Interaction> newInts) {
        if (interactions == null)
            interactions = new ArrayList<Interaction>();
        else
            interactions.clear();
        if (newInts != null)
            interactions.addAll(newInts);
        // Need to sorting
        Comparator<Interaction> sorter = getSorter(this.sortingCol);
        Collections.sort(interactions, sorter);
        fireTableDataChanged();
    }
    
    public int getColumnCount() {
        return colNames.length;
    }
    
    public int getRowCount() {
        return interactions == null ? 0 : interactions.size();
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Interaction tmp = interactions.get(rowIndex);
        switch (columnIndex) {
            case 0 :
                return tmp.getDbId();
            case 1 :
                return tmp.getFirstProtein().getPrimaryAccession();
            case 2 :
                return tmp.getSecondProtein().getPrimaryAccession();
        }
        return null;
    }
    
}
