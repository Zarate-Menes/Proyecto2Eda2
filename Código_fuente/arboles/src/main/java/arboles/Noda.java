/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
package arboles;

public class Noda {
    int valor;
    Noda izq;
    Noda der;
    int altura;

    // Constructor por defecto
    public Noda() {
        this.altura = 1; // Altura inicial para un nuevo nodo
    }

    // Constructor con valor inicial
    public Noda(int valor) {
        this.valor = valor;
        this.altura = 1; // Altura inicial para un nuevo nodo
        this.izq = null;
        this.der = null;
    }

    // Constructor con valor y nodos hijos
    public Noda(int valor, Noda izq, Noda der) {
        this.valor = valor;
        this.izq = izq;
        this.der = der;
        this.altura = 1; // Altura inicial para un nuevo nodo
    }

    // Métodos setter
    public void setIzq(Noda izq) {
        this.izq = izq;
    }

    public void setDer(Noda der) {
        this.der = der;
    }

    // Métodos getter (opcional)
    public Noda getIzq() {
        return izq;
    }

    public Noda getDer() {
        return der;
    }

    public int getValor() {
        return valor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
