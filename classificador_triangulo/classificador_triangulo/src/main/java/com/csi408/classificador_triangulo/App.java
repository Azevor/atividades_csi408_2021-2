package com.csi408.classificador_triangulo;

public class App {

    public static void main(String[] args) {
        int pos;
        String[] tipoTriangulo = {"", "Triângulo retângulo", 
                "Triângulo Equilátero", "Triângulo Isóceles", "Triângulo escaleno"};
        
        ClassificadorTriangulo classificador = new ClassificadorTriangulo();

        pos = classificador.classifica(6.156, 8.981, 16.165);
        System.out.println("Tipo:");
        System.out.println(pos);
        System.out.println(tipoTriangulo[pos]);

        pos = classificador.classifica(3.0, 4.0, 5.0);
        System.out.println("Tipo:");
        System.out.println(pos);
        System.out.println(tipoTriangulo[pos]);

        pos = classificador.classifica(8.44, 8.44, 8.44);
        System.out.println("Tipo:");
        System.out.println(pos);
        System.out.println(tipoTriangulo[pos]);

        pos = classificador.classifica(8.44, 8.44, 12.0);
        System.out.println("Tipo:");
        System.out.println(pos);
        System.out.println(tipoTriangulo[pos]);

        pos = classificador.classifica(6.843, 8.711, 5.5);
        System.out.println("Tipo:");
        System.out.println(pos);
        System.out.println(tipoTriangulo[pos]);
    }
}
