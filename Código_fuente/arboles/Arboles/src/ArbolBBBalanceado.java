/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose11
 */
public class ArbolBBBalanceado extends ArbolBinBusq {
    
    // Constructor por defecto
    public ArbolBBBalanceado() {
        super();
    }
    
    // Constructor con valor inicial
    public ArbolBBBalanceado(int val) {
        super(val);
    }
    
    // Constructor con nodo raíz
    public ArbolBBBalanceado(Nodo root) {
        super(root);
    }
    
    @Override
    public void insertar(int valor) {
        root = insertarRecursivo(root, valor);
    }
    
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        
        if (valor < nodo.valor) {
            nodo.izq = insertarRecursivo(nodo.izq, valor);
        } else if (valor > nodo.valor) {
            nodo.der = insertarRecursivo(nodo.der, valor);
        } else {
            return nodo; // Valor duplicado no se inserta
        }
        
        // Actualizar la altura del nodo actual
        nodo.altura = 1 + Math.max(altura(nodo.izq), altura(nodo.der));
        
        // Obtener el factor de balanceo de este nodo
        int balance = obtenerBalance(nodo);
        
        // Caso 1: Rotación simple a la derecha
        if (balance > 1 && valor < nodo.izq.valor) {
            return rotarDerecha(nodo);
        }
        
        // Caso 2: Rotación simple a la izquierda
        if (balance < -1 && valor > nodo.der.valor) {
            return rotarIzquierda(nodo);
        }
        
        // Caso 3: Rotación doble izquierda-derecha
        if (balance > 1 && valor > nodo.izq.valor) {
            nodo.izq = rotarIzquierda(nodo.izq);
            return rotarDerecha(nodo);
        }
        
        // Caso 4: Rotación doble derecha-izquierda
        if (balance < -1 && valor < nodo.der.valor) {
            nodo.der = rotarDerecha(nodo.der);
            return rotarIzquierda(nodo);
        }
        
        return nodo;
    }
    
    private int altura(Nodo nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }
    
    private int obtenerBalance(Nodo nodo) {
        return (nodo == null) ? 0 : altura(nodo.izq) - altura(nodo.der);
    }
    
    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izq;
        Nodo T2 = x.der;
        
        // Realizar la rotación
        x.der = y;
        y.izq = T2;
        
        // Actualizar alturas
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        
        // Retornar la nueva raíz
        return x;
    }
    
    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.der;
        Nodo T2 = y.izq;
        
        // Realizar la rotación
        y.izq = x;
        x.der = T2;
        
        // Actualizar alturas
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        
        // Retornar la nueva raíz
        return y;
    }
}

class Nodo {
    int valor;
    Nodo izq, der;
    int altura;
    
    public Nodo(int valor) {
        this.valor = valor;
        this.altura = 1;
    }
}

