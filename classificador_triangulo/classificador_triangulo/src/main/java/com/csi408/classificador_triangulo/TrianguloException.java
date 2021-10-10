package com.csi408.classificador_triangulo;

public class TrianguloException extends Exception {
    
    @Override
    public String getMessage() {
        return "Estas dimensões não formam um triângulo!";
    }
}
