package com.wib.cyberwirtzlib.math;

import java.util.List;

public interface iMatrix {

    public Matrix transpose();

    public Object manipulate(int row, int column);

    public int getRowSize();

    public int getFirstColumnSize();

    public List<Integer> getAllColumnSizes();

}
