package com.company;

public class Main {

    public static void main(String[] args) {
        Complex c = new Complex();
        c.re = 1;
        c.im = 1;
        Complex e = new Complex();
        e.re = 5;
        e.im = 2;
        Complex s = Complex.pow(e,5 );
       Complex.showTrigonomForm(c);
       Complex.showExpForm(c);
    }
}
