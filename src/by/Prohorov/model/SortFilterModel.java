package by.Prohorov.model;

import java.util.Arrays;
import java.util.Comparator;

import javax.faces.model.DataModel;


public class SortFilterModel<E> extends DataModel<E>{
    private DataModel<E> model;
    private Integer[] rows;

    public SortFilterModel(E[] users) {
        setWrappedData(users);
    }

    public SortFilterModel(DataModel<E> model) {
        this.model = model;
        initializeRows();
    }

    private E getData(int row) {
        int originalIndex = model.getRowIndex();
        model.setRowIndex(row);
        E thisRowData = model.getRowData();
        model.setRowIndex(originalIndex);
        return thisRowData;
    }

    public void sortBy(final Comparator<E> dataComp) {
        Comparator<Integer> rowComp =new
        Comparator<Integer>() {
            @Override
            public int compare(Integer r1, Integer r2) {
                E e1 = getData(r1);
                E e2 = getData(r2);
                return dataComp.compare(e1, e2);
                }
        };
        Arrays.sort(rows, rowComp);
    }

    public void setRowIndex(int rowIndex) {
        if (0 <= rowIndex && rowIndex < rows.length)
            model.setRowIndex(rows[rowIndex]);
        else
            model.setRowIndex(rowIndex);
    }

    public boolean isRowAvailable() {
        return model.isRowAvailable();
    }

    public int getRowCount() {
        return model.getRowCount();
    }

    public E getRowData() {
        return model.getRowData();
    }

    public int getRowIndex() {
        return model.getRowIndex();
    }

    public Object getWrappedData() {
        return model.getWrappedData();
    }

    public void setWrappedData(Object data) {
        model.setWrappedData(data);
        initializeRows();
    }

    private void initializeRows() {
        int rowCount = model.getRowCount();
        if (rowCount != -1) {
            rows = new Integer[rowCount];
            for(int i = 0; i < rowCount; ++i)
                rows[i] = i;
        }
    }
}
