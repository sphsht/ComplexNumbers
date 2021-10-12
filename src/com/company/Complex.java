package com.company;

public class Complex {
    double re;
    double im;
    //статические методы применяются к классу
    // не статические - к конкретному элементу, есть сразу доступ к его данным

    public Complex(double r, double i) {
        re=r;
        im=i;
    }

    @Override
    public String toString() {
        String result="";
        if((im>0)&(im!=1)){
            if (re!=0) {
                result=re+"+"+im+"i";
            } else result=im+"i";
        }

        if(im==1){
            if (re!=0) {
                result=re+"+i";
            } else result="i";
        }

        if(im==0){
            if (re!=0) {
                result = re + "";
            } else result =  ""; //приведение типов с помощью пустой строки
        }

        if ((im<0)&(im!=-1)){
            if (re!=0) {
                result=re+"-"+(-1*im)+"i";
            } else result=im+"i";
        }

        if ((im==-1)){
            if (re!=0){
                result=re+"-i";
            } else result="-i";
        }
        return result;

    }


    public static Complex sum(Complex a, Complex b) { // сложение
        Complex c = new Complex(a.re + b.re,a.im + b.im);
        return c;
    }

    public  Complex sum(Complex b) { // не статическое сложение
        Complex c = new Complex(re + b.re,im + b.im);
        return c;
    }

    public static Complex subtr(Complex a, Complex b) { // вычитание
        Complex c = new Complex(a.re - b.re,a.im - b.im);
        return c;
    }

    public Complex subtr(Complex b) { // не статическое вычитание
        Complex c = new Complex(re - b.re,im - b.im);
        return c;
    }

    public static Complex mult(Complex a, Complex b) { // умножение
        Complex c = new Complex(a.re * b.re - a.im * b.im, a.re * b.im + a.im * b.re);
        return c;
    }

    public static Complex div(Complex a, Complex b) { // деление
        Complex c = new Complex((a.re * b.re + a.im * b.im)/(b.re*b.re + b.im*b.im),(a.im * b.re - a.re * b.im)/(b.re*b.re + b.im*b.im));
        return c;
    }

    public static double getAbs (Complex a){ //значение модуля
        double abs;
        abs = Math.sqrt(a.re*a.re + a.im*a.im);
        return abs;
    }

    public static double getArg (Complex a){ //значение аргумента
        double arg;
        arg = Math.atan(a.im/a.re);
        return arg;
    }

    public static Complex pow(Complex a, double n){ //возведение в степень
        Complex c = new Complex(a.re,a.im);
        double arg=Complex.getArg(a);
        double abs=Complex.getAbs(a);
        c.re=Math.pow(abs,n) * Math.cos(n*arg);
        c.im=Math.pow(abs,n) * Math.sin(n*arg);
        return c;
    }

    public static void showTrigonomForm(Complex a){ //вывод тригонометрической формы
        double arg=Complex.getArg(a);
        double abs=Complex.getAbs(a);
        System.out.println(abs + "(cos(" + arg + ") + i*sin("+arg+"))");
    }

    public static void showExpForm(Complex a){ //вывод показательной формы
        double arg=Complex.getArg(a);
        double abs=Complex.getAbs(a);
        System.out.println(abs + "e^(i*" + arg + ")");
    }

}
