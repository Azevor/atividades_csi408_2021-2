package com.csi408.classificador_triangulo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

public class TesteClassificadorTriangulo {
    ClassificadorTriangulo classificador = new ClassificadorTriangulo();
    private static Random gerador = new Random();

    @Test
    public void testeClassificadorInvalido() {
        double[] medidas = null;

        for(int i = 0; i < 100000; i++) {
            medidas = gerarArestasInvalidas();
            double a = medidas[0];
            double b = medidas[1];
            double c = medidas[2];
            assertEquals(0, classificador.classifica(a, b, c));
        }
    }

    @Test
    public void testeClassificadorRetangulo() {
        double[] medidas = null;

        for(int i = 0; i < 100000; i++) {
            medidas = gerarRetangulo();
            double a = medidas[0];
            double b = medidas[1];
            double c = medidas[2];
            assertEquals(1, classificador.classifica(a, b, c));
        }
    }

    @Test
    public void testeClassificadorEquilatero() {
        double[] medidas = null;

        for(int i = 0; i < 100000; i++) {
            medidas = gerarEquilatero();
            double a = medidas[0];
            double b = medidas[1];
            double c = medidas[2];
            assertEquals(3, classificador.classifica(a, b, c));
        }
    }

    @Test
    public void testeClassificadorIsoceles() {
        double[] medidas = null;
        
        for(int i = 0; i < 100000; i++) {
            medidas = gerarIsoceles();
            double a = medidas[0];
            double b = medidas[1];
            double c = medidas[2];
            assertEquals(2, classificador.classifica(a, b, c));
        }
    }

    @Test
    public void testeClassificadorEscaleno() {
        double[] medidas = null;

        for(int i = 0; i < 100000; i++) {
            medidas = gerarEscaleno();
            double a = medidas[0];
            double b = medidas[1];
            double c = medidas[2];
            assertEquals(4, classificador.classifica(a, b, c));
        }
    }

    //-------------- Métodos para gerar números aleatórios para cada classificação:

    private double[] gerarArestasInvalidas() {
        double a = gerador.nextDouble() * 100 + 1;
        double b = gerador.nextDouble() * 100 + 1;
        double c = 0.0;
        boolean sortBool = gerador.nextBoolean();
        if(sortBool) {
            c = a + b + 0.1;
        } else {
            c = Math.abs(a - b) - 0.1;
        }
        double medidas[] = {a, b, c};
        return medidas;
    }

    private double[] gerarRetangulo() {
        double cat1 = gerador.nextDouble() * 100 + 1;
        double cat2 = gerador.nextDouble() * 100 + 1;
        double hip = Math.sqrt(Math.pow(cat1, 2) + Math.pow(cat2, 2));
        double medidas[] = {cat1, cat2, hip};
        return medidas;
    }

    private double[] gerarEquilatero() {
        double aresta1 = gerador.nextDouble() * 100 + 1;
        double aresta2 = gerador.nextDouble() * (2 * aresta1 - 1) + 1;
        double medidas[] = {aresta1, aresta1, aresta2};
        return medidas;
    }

    private double[] gerarIsoceles() {
        double aresta = gerador.nextDouble() * 100 + 1;
        double medidas[] = {aresta, aresta, aresta};
        return medidas;
    }

    private double[] gerarEscaleno() {
        double aresta1 = gerador.nextDouble() * 100 + 1;
        double aresta2 = gerador.nextDouble() * 100 + 1;
        // Caso duas arestas tenham medidas muito próximas, gerar uma nova aresta
        if(Math.abs(aresta1 - aresta2) < 1.0) {
            aresta2 = (aresta1 + aresta2) / 4 * 3;
        }
        // Aresta 3 precisa ter medida válida (mínimo e máximo para fechar um triângulo)
        // nextDouble() * (máximo - mínimo) + mínimo;
        double aresta3 = gerador.nextDouble() * 
                        ((aresta1 + aresta2 - 1) - (Math.abs(aresta1 - aresta2) + 1)) + 
                            (Math.abs(aresta1 - aresta2) + 1);
        double medidas[] = {aresta1, aresta2, aresta3};
        return medidas;
    }
}
