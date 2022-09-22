package com.wib.cyberwirtzlib.cyberwirtzimpltest;

import com.wib.cyberwirtzlib.cyberwirtzimpl.CyberWirtz;
import com.wib.cyberwirtzlib.cyberwirtzimpl.RealCyberWirtz;
import com.wib.cyberwirtzlib.math.matrix.Matrix;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

class RealCyberWirtzTest {

    // Double Arrays
    private Double[][] a = {{1.0, 2.0}, {5.0, 6.0}};
    private Double[][] b = {{1.0, 2.0}, {5.0, 6.0}};
    private Double[][] c = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 3.0, 7.0}};
    private Double[][] d = {{1.0, 2.0, 2.0, 4.0}, {5.0, 4.0, 7.0, 1.0}};
    private Double[][] f = {{1.0, 3.0, 2.0, 4.0}, {5.0, 4.0, 7.0, 1.0}};

    private Double[][] v = {{2.0},{3.0}};

    // Double Matrices
    private Matrix m1 = new Matrix(a);
    private Matrix m2 = new Matrix(b);
    private Matrix m3 = new Matrix(c);
    private Matrix m4 = new Matrix(d);
    private Matrix m5 = new Matrix(f);
    private Matrix v1 = new Matrix(v);

    // Algorithms
    private CyberWirtz real = new RealCyberWirtz();

    // --------- SOLUTIONS --------
    // == Real ==
    // a + b

    // a + b + c + d + f

    // a * b

    // a * b * c * d * f

    // a * 3.2

    @org.junit.jupiter.api.Test
    void add() {
        Assertions.assertTrue(Arrays.deepEquals(real.add(m1,m2).getArray(), new Double[][] {{2.0,4.0},{10.0,12.0}}));
        Assertions.assertFalse(Arrays.deepEquals(real.add(m1,m2).getArray(), new Double[][] {{2.0,4.0},{10.1,12.0}}));
    }

    @org.junit.jupiter.api.Test
    void addMany() {
        Assertions.assertTrue(Arrays.deepEquals(real.add(m3, m4, m5).getArray(), new Double[][] {{3.0,7.0, 7.0, 12.0},{15.0,14.0, 17.0, 9.0}}));
        Assertions.assertFalse(Arrays.deepEquals(real.add(m3, m4, m5).getArray(), new Double[][] {{3.0,7.0, 7.0, 12.1},{15.0,14.0, 17.0, 9.0}}));
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        Assertions.assertTrue(Arrays.deepEquals(real.multiply(m1,m2).getArray(), new Double[][] {{11.0, 14.0}, {35.0, 46.0}}));
        Assertions.assertFalse(Arrays.deepEquals(real.multiply(m1,m2).getArray(), new Double[][] {{11.1, 14.0}, {35.0, 46.0}}));
    }

    @org.junit.jupiter.api.Test
    void multiplyMany() {
       Assertions.assertTrue(Arrays.deepEquals(real.multiply(m3,m4.transpose(), m5).getArray(), new Double[][] {{217.0, 233.0, 320.0, 146.0}, {436.0, 461.0, 641.0, 281.0}}));
       Assertions.assertFalse(Arrays.deepEquals(real.multiply(m3,m4.transpose(), m5).getArray(), new Double[][] {{217.0, 233.0, 320.0, 146.0}, {436.0, 461.1, 641.0, 281.0}}));
    }

    @org.junit.jupiter.api.Test
    void multiplyScalar() {
       Assertions.assertTrue(Arrays.deepEquals(real.multiply(3.2, m1).getArray(), new Double[][] {{3.2, 6.4},{16.0, 19.2}}));
        Assertions.assertFalse(Arrays.deepEquals(real.multiply(3.2, m1).getArray(), new Double[][] {{3.3, 6.4},{16.0, 19.2}}));
    }

    @org.junit.jupiter.api.Test
    void calculateExpectedValue() {
        Assertions.assertEquals(real.calculateExpectedValue(m1,v1), 100.0);
    }
}