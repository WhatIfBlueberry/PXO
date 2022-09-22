package com.wib.cyberwirtzlib.cyberwirtzimpltest;

import com.wib.cyberwirtzlib.cyberwirtzimpl.CyberWirtz;
import com.wib.cyberwirtzlib.cyberwirtzimpl.RealCyberWirtz;
import com.wib.cyberwirtzlib.math.Matrix;

import static org.junit.jupiter.api.Assertions.*;

class RealCyberWirtzTest {

    // Double Arrays
    private Double[][] a = {{1.0, 2.0}, {5.0, 6.0}};
    private Double[][] b = {{1.0, 2.0}, {5.0, 6.0}};
    private Double[][] c = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 3.0, 7.0}};
    private Double[][] d = {{1.0, 2.0, 2.0, 4.0}, {5.0, 4.0, 7.0, 1.0}};
    private Double[][] f = {{1.0, 3.0, 2.0, 4.0}, {5.0, 4.0, 7.0, 1.0}};

    // Double Matrices
    private Matrix m1 = new Matrix(a);
    private Matrix m2 = new Matrix(b);
    private Matrix m3 = new Matrix(c);
    private Matrix m4 = new Matrix(d);
    private Matrix m5 = new Matrix(f);

    // Algorithms
    private CyberWirtz real = new RealCyberWirtz();

    // --------- SOLUTIONS --------
    // == Real ==
    // a + b

    // a + b + c + d + f

    // a * b

    // a * b * c * d * f

    // a * 3.2

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void multiply() {
    }

    @org.junit.jupiter.api.Test
    void testMultiply() {
    }

    @org.junit.jupiter.api.Test
    void calculateExpectedValue() {
    }

    @org.junit.jupiter.api.Test
    void validateAddition() {
    }

    @org.junit.jupiter.api.Test
    void validateMultiplication() {
    }

    @org.junit.jupiter.api.Test
    void checkInstance() {
    }
}