package com.wib.cyberwirtzlib.cyberwirtzimpltest;

import com.wib.cyberwirtzlib.cyberwirtzimpl.ComplexCyberWirtz;
import com.wib.cyberwirtzlib.cyberwirtzimpl.CyberWirtz;
import com.wib.cyberwirtzlib.cyberwirtzimpl.RealCyberWirtz;
import com.wib.cyberwirtzlib.math.ComplexMatrix;
import com.wib.cyberwirtzlib.math.ComplexNumber;
import com.wib.cyberwirtzlib.math.Matrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class ComplexCyberWirtzTest {

    //Complex Numbers
    private ComplexNumber c1 = new ComplexNumber(1, 2);
    private ComplexNumber c2 = new ComplexNumber(3, 4);
    private ComplexNumber c3 = new ComplexNumber(4, 2);
    private ComplexNumber c4 = new ComplexNumber(1, 1);

    // ComplexNumber Arrays
    private ComplexNumber[][] matrix = new ComplexNumber[][]{{c1, c2}, {c3, c4}};
    private ComplexNumber[][] anotherMatrix = new ComplexNumber[][]{{c3, c1}, {c2, c4}};

    private ComplexNumber[][] thirdMAtrix = new ComplexNumber[][]{{c2,c3}, {c4,c1}};

    // ComplexNumber Matrices
    private ComplexMatrix matrixc2 = new ComplexMatrix(matrix);
    private ComplexMatrix matrixc3 = new ComplexMatrix(anotherMatrix);
    private ComplexMatrix matrixc4 = new ComplexMatrix(thirdMAtrix);

    // Algorithms
    private CyberWirtz complex = new ComplexCyberWirtz();


    // --------- SOLUTIONS --------
    // == Complex ==
    // matrixc2 + matrixc3

    // matrixc2 + matrixc3 + matrixc4

    // matrixc2 * matrixc3

    // matrixc2 * matrixc3 * matrixc4

    // matrixc2 * 3.2

    @BeforeEach
    void setUp() {

    }

    @Test
    void add() {

    }

    @Test
    void multiply() {
    }

    @Test
    void testMultiply() {
    }

    @Test
    void testMultiply1() {
    }

    @Test
    void calculateExpectedValue() {
    }

    @Test
    void validateAddition() {
    }

    @Test
    void validateMultiplication() {
    }

    @Test
    void checkInstance() {
    }
}