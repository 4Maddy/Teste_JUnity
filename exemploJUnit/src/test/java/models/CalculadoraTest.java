package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private final Calculadora calculadoraSobTeste = new Calculadora();

    //1 Forma
    @Test
    void deveSomarNumerosInteiros() {

        //Dado
        int a = 1;
        int b = 2;
        int saidaEsperada = 3;

        //Quando
        int resultado = calculadoraSobTeste.somar(a,b);

        //Então
        assertEquals(saidaEsperada, resultado);

    }

    //2 Forma
    @ParameterizedTest
    @CsvSource ({"1, 2, 3","2, 1, 4","-1, -1, -2"})
    void deveSomarNumerosInteiros(int a, int b, int saidaEsperada){
        int resultado = calculadoraSobTeste.somar(a,b);
        assertEquals(saidaEsperada,resultado);
    }

    //3 Forma (Teste de mensagem de erro)
    @Test
    void deveLancarExcecaoAritmeticaQuandoDividirPoZero(){

        //Dado
        double a = 4.5;
        double b = 0.0;

        //Quando
        Exception excecao = assertThrows(ArithmeticException.class,
                () -> calculadoraSobTeste.dividir(a,b));

        //Entao
        assertEquals("impossivel dividir por zero",
            excecao.getMessage());
    }

    //4 Forma
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -2, -1, 0, 1, 2, Integer.MAX_VALUE})
    void deveRetornarFalsoSeUmNumeroInteiroForImpar(int numero){

        boolean eNumeroPar = calculadoraSobTeste.ePar(numero);
        assertFalse(eNumeroPar);
    }

}