package com.wib.cyberwirtzlib.math;

/**
 * partial credit to:
 * <a href="https://stackoverflow.com/questions/55777103/java-matrix-of-complex-numbers">source</a>
 */
public class ComplexNumber {

    public final double real;
    public final double img;

    public ComplexNumber(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public ComplexNumber addComp(ComplexNumber num) {
        ComplexNumber num1 = new ComplexNumber(real + num.real, img + num.img);
        return num1;
    }

    public ComplexNumber subtractComp(ComplexNumber num) {
        ComplexNumber num1 = new ComplexNumber(real - num.real, img - num.img);
        return num1;
    }

    public ComplexNumber multiplyComp(ComplexNumber num) {
        ComplexNumber num1 = new ComplexNumber(getRealRounded(num), getImgRounded(num));
        return num1;
    }

    private double getImgRounded(ComplexNumber num) {
        double value = real * num.img + img * num.real;
        return (double)Math.round(value * 100000d) / 100000d;
    }

    private double getRealRounded(ComplexNumber num) {
        double value = real * num.real - img * num.img;
        return (double)Math.round(value * 100000d) / 100000d;
    }

    public boolean equals(ComplexNumber num) {
        ComplexNumber num1 = new ComplexNumber(real, img);
        if (num.real == num1.real && num.img == num1.img) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        if (img > 0) {
            return real + " + " + Math.abs(img) + "i";
        }
        if (img < 0) {
            return real + " - " + Math.abs(img) + "i";
        }
        if (real == 0) {
            return img + "i";
        }
        if (img == 0) {
            return real + "";
        }
        return null;
    }

}
