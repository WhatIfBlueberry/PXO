package com.wib.cyberwirtzlib.cyberwirtzimpltest;

import com.wib.cyberwirtzlib.cyberwirtzimpl.ComplexCyberWirtz;
import com.wib.cyberwirtzlib.cyberwirtzimpl.CyberWirtz;
import com.wib.cyberwirtzlib.math.matrix.ComplexMatrix;
import com.wib.cyberwirtzlib.math.ComplexNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ComplexCyberWirtzTest {

    //Complex Numbers
    private ComplexNumber c1 = new ComplexNumber(1, 2);
    private ComplexNumber c2 = new ComplexNumber(3, 4);
    private ComplexNumber c3 = new ComplexNumber(4, 2);
    private ComplexNumber c4 = new ComplexNumber(1, 1);

    // ComplexNumber Arrays
    private ComplexNumber[][] first = new ComplexNumber[][]{{c1, c2}, {c3, c4}};
    private ComplexNumber[][] second = new ComplexNumber[][]{{c3, c1}, {c2, c4}};
    private ComplexNumber[][] third = new ComplexNumber[][]{{c2,c3}, {c4, c1}};

    // ComplexNumber Matrices
    private ComplexMatrix a = new ComplexMatrix(first);
    private ComplexMatrix b = new ComplexMatrix(second);
    private ComplexMatrix c = new ComplexMatrix(third);

    // Algorithms
    private CyberWirtz complex = new ComplexCyberWirtz();


    // --------- SOLUTIONS --------
    // == Complex ==
    // a + b
    ComplexNumber one = new ComplexNumber(5,4);
    ComplexNumber two = new ComplexNumber(4,6);
    ComplexNumber three = new ComplexNumber(7,6);
    ComplexNumber four = new ComplexNumber(2,2);
    ComplexMatrix firstMatrix = new ComplexMatrix(new ComplexNumber[][] {{one, two}, {three, four}});

    // a + b + c

    ComplexNumber one1 = new ComplexNumber(8,8);
    ComplexNumber two2 = new ComplexNumber(8,8);
    ComplexNumber three3 = new ComplexNumber(8,7);
    ComplexNumber four4 = new ComplexNumber(3,4);
    ComplexMatrix secondMatrix = new ComplexMatrix(new ComplexNumber[][] {{one1, two2}, {three3, four4}});

    // a * b

    ComplexNumber one11 = new ComplexNumber(-7,34);
    ComplexNumber two22 = new ComplexNumber(-4,11);
    ComplexNumber three33 = new ComplexNumber(11,23);
    ComplexNumber four44 = new ComplexNumber(0,12);
    ComplexMatrix thirdMatrix = new ComplexMatrix(new ComplexNumber[][] {{one11, two22}, {three33, four44}});

    // a * b * c

    ComplexNumber one111 = new ComplexNumber(-172.0,81.0);
    ComplexNumber two222 = new ComplexNumber(-122.0,125.0);
    ComplexNumber three333 = new ComplexNumber(-71.0,125.0);
    ComplexNumber four444 = new ComplexNumber(-26.0,126.0);
    ComplexMatrix fourthMatrix = new ComplexMatrix(new ComplexNumber[][] {{one111, two222}, {three333, four444}});

    // a * 3.2

    ComplexNumber one1111 = new ComplexNumber(3.2,6.4);
    ComplexNumber two2222 = new ComplexNumber(9.6,12.8);
    ComplexNumber three3333 = new ComplexNumber(12.8,6.4);
    ComplexNumber four4444 = new ComplexNumber(3.2,3.2);
    ComplexMatrix fifthMatrix = new ComplexMatrix(new ComplexNumber[][] {{one1111, two2222}, {three3333, four4444}});

    @Test
    void add() {
        ComplexNumber[][] actual = (ComplexNumber[][]) complex.add(a,b).getArray();
        ComplexNumber[][] expected = firstMatrix.getArray();
        for (int i = 0; i < a.getFirstColumnSize(); i++) {
            for (int j = 0; j < a.getRowSize(); j++) {
                Assertions.assertTrue(actual[i][j].equals(expected[i][j]));
            }
        }
    }

    @Test
    void addMany() {
        ComplexNumber[][] actual = (ComplexNumber[][]) complex.add(a,b,c).getArray();
        ComplexNumber[][] expected = secondMatrix.getArray();
        for (int i = 0; i < a.getFirstColumnSize(); i++) {
            for (int j = 0; j < a.getRowSize(); j++) {
                Assertions.assertTrue(actual[i][j].equals(expected[i][j]));
            }
        }

    }

    @Test
    void multiply() {
        ComplexNumber[][] actual = (ComplexNumber[][]) complex.multiply(a,b).getArray();
        ComplexNumber[][] expected = thirdMatrix.getArray();
        for (int i = 0; i < thirdMatrix.getFirstColumnSize(); i++) {
            for (int j = 0; j < thirdMatrix.getRowSize(); j++) {
                Assertions.assertTrue(actual[i][j].equals(expected[i][j]));
            }
        }
    }

    @Test
    void multiplyMany() {
        ComplexNumber[][] actual = (ComplexNumber[][]) complex.multiply(a,b,c).getArray();
        ComplexNumber[][] expected = fourthMatrix.getArray();
        for (int i = 0; i < fourthMatrix.getFirstColumnSize(); i++) {
            for (int j = 0; j < fourthMatrix.getRowSize(); j++) {
                Assertions.assertTrue(actual[i][j].equals(expected[i][j]));
            }
        }
    }

    @Test
    void multiplyScalar() {
        ComplexNumber[][] actual = (ComplexNumber[][]) complex.multiply(3.2, a).getArray();
        ComplexNumber[][] expected = fifthMatrix.getArray();
        for (int i = 0; i < fifthMatrix.getFirstColumnSize(); i++) {
            for (int j = 0; j < fifthMatrix.getRowSize(); j++) {
                Assertions.assertTrue(actual[i][j].equals(expected[i][j]));
            }
        }
    }



    @Test
    void calculateExpectedValue() {

    }
}