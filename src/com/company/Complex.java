package com.company;

import java.util.Objects;

public class Complex {
    private double real, imaginary;

    public Complex(Complex z){
        this.real = z.getReal();
        this.imaginary = z.getImaginary();
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(String z){
    }

    public Complex(){
        this.real = 0;
        this.imaginary = 0;
    }

    //геттеры и сеттеры
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }


//-------------------умножение, деление, сложение, вычитание
    public void sum(Complex z){
        this.real += z.getReal();
        this.imaginary += z.getImaginary();
    }
    public void sub(Complex z){
        this.real -= z.getReal();
        this.imaginary -= z.getImaginary();
    }
    public void multy(Complex z){
        this.real = real * z.getReal() - imaginary * z.getImaginary();
        this.imaginary = real*z.getImaginary() + imaginary*z.getReal();
    }
    public void div(Complex z){
        this.real = (this.real*z.getReal()+this.imaginary*z.getImaginary()) / (z.getReal()*z.getReal()+z.getImaginary()*z.getImaginary());
        this.imaginary = (this.imaginary*z.getReal()-this.real*z.getImaginary()) / (z.getReal()*z.getReal()+z.getImaginary()*z.getImaginary());
    }


    //-----------absolute, conjugate, equals, negative, toString
    public double abs(){
        return Math.sqrt(this.imaginary*this.imaginary+this.real*this.real);
    }

    public Complex conj(){
        return new Complex(this.real, -this.imaginary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.real, real) == 0 && Double.compare(complex.imaginary, imaginary) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }

    public Complex neg(){
        return new Complex(-this.real, -this.imaginary);
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }

    public boolean checkReal(){
        return this.imaginary == 0;
    }
    public boolean checkImaginary(){
        return this.real == 0 && this.imaginary != 0;
    }
}
