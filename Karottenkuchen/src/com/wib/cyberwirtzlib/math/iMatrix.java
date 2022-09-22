package com.wib.cyberwirtzlib.math;

import java.util.List;

public interface iMatrix {

    public iMatrix transpose();

    public Object getCell(int row, int column);

    public Object[][] getArray();

    public int getRowSize();

    public int getFirstColumnSize();

    public List<Integer> getAllColumnSizes();

}
