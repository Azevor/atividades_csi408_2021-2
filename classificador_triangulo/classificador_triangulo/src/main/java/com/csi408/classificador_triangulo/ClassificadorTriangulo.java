package com.csi408.classificador_triangulo;

import java.text.DecimalFormat;

/**
 * Classificador de tipo de triângulo
 * Tipos de triângulo:
 * - Retângulo;
 * - Equilátero;
 * - Isóceles;
 * - Escaleno
 */
public class ClassificadorTriangulo {
    private static DecimalFormat df = new DecimalFormat("#.#######");
    private String a;
    private String b;
    private String c;

    /**
     * Verifica se é triângulo retângulo.
     * @param a
     * @param b
     * @param c
     * @return Boolean
     */
    private Boolean ehTrianguloRetangulo(double a, double b, double c) {
        String hip_a = df.format(Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2)));
        String hip_b = df.format(Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2)));
        String hip_c = df.format(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));

        if (hip_a.equals(this.a) || hip_b.equals(this.b) || hip_c.equals(this.c)) {
            return true;
        }
        return false;
    }

    /**
     * Verifica se é triângulo equilátero.
     * @param a
     * @param b
     * @param c
     * @return Boolean
     */
    private Boolean ehTrianguloEquilatero() {
        if (this.a.equals(this.b) && this.a.equals(this.c) && this.b.equals(this.c)) {
            return true;
        }
        return false;
    }

    /**
     * Verifica se é triângulo isóceles.
     * @param a
     * @param b
     * @param c
     * @return Boolean
     */
    private Boolean ehTrianguloIsoceles() {
        if (this.a.equals(this.b) && !this.a.equals(this.c)) {
            return true;
        }
        if (this.b.equals(this.c) && !this.b.equals(this.a)) {
            return true;
        }
        if (this.c.equals(this.a) && !this.a.equals(this.b)) {
            return true;
        }
        return false;
    }    

    /**
     * Verifica se é triângulo escaleno.
     * @param a
     * @param b
     * @param c
     * @return Boolean
     */
    private Boolean ehTrianguloEscaleno() {
        if (!this.a.equals(this.b) && !this.a.equals(this.c) && !this.b.equals(this.c)) {
            return true;
        }
        return false;
    }

    /**
     * Obtém o tipo de triângulo com base nas medidas.
     * @param a
     * @param b
     * @param c
     * @return int
     */
    private int tipoTriangulo(double a, double b, double c) {
        if (ehTrianguloRetangulo(a, b, c)) {
            return 1;
        }
        if (ehTrianguloEquilatero()) {
            return 2;
        }
        if (ehTrianguloIsoceles()) {
            return 3;
        }
        if (ehTrianguloEscaleno()) {
            return 4;
        }
        return 0;
    }

    /**
     * Verifica se as medidas dos lados formam um triângulo.
     * @param a
     * @param b
     * @param c
     * @return Boolean
     */
    private Boolean formaTriangulo(double a, double b, double c) {
        if (a > Math.abs(b-c) && a < b+c)
            return true;
        if (b > Math.abs(a-c) && b < a+c)
            return true;
        if (c > Math.abs(a-b) && c < a+b)
            return true;
        return false;
    }

    /**
     * Caso os parâmetros formem um triângulo, classifica seu tipo.
     * @param a
     * @param b
     * @param c
     * @retur int:
     *      0 = não forma triângulo
     *      1 = triângulo retângulo
     *      2 = triângulo equiláterlo
     *      3 = triângulo isóceles
     *      4 = triângulo escaleno
     * @throws TipoTrianguloExceptions
     */
    public int classifica(double a, double b, double c) {
        this.a = df.format(a);
        this.b = df.format(b);
        this.c = df.format(c);
        
        if (a <= 0.0 || b <= 0.0 || c <= 0.0 || !formaTriangulo(a, b, c)) {
            try {
                throw new TrianguloException();
            } catch (TrianguloException e) {
                System.err.println(e.getMessage());
            }
        } else {
            return tipoTriangulo(a, b, c);
        }
        return 0;
    }
}
