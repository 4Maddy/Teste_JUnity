package models;

public class Calculadora {

    public double somar(double a, double b){
        return a + b;
    }

    public int somar(int a, int b){
        return a + b;
    }

    public double subtrair(double a, double b){
        return a - b;
    }

    public double multiplicar(double a, double b){
        return a * b;
    }

    public double dividir(double a, double b){
        if (b == 0)
            throw new ArithmeticException("Impossivel dividir por zero");

        return a / b;
    }

    public boolean ePar(double numero){
        return (numero % 2) == 0;
    }

}
