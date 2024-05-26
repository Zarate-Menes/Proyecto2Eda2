/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose11
 */ 

public class ArbolBinBusq {
    protected Noda root;

    public ArbolBinBusq() {
        root = null;
    }

    public ArbolBinBusq(int val) {
        root = new Noda(val);
    }

    public ArbolBinBusq(Noda root) {
        this.root = root;
    }

    public void insertar(int valor) {
        root = insertarRecursivo(root, valor);
    }

    private Noda insertarRecursivo(Noda nodo, int valor) {
        if (nodo == null) {
            return new Noda(valor);
        }

        if (valor < nodo.valor) {
            nodo.izq = insertarRecursivo(nodo.izq, valor);
        } else if (valor > nodo.valor) {
            nodo.der = insertarRecursivo(nodo.der, valor);
        }

        return nodo;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(root, valor);
    }

    private boolean buscarRecursivo(Noda nodo, int valor) {
        if (nodo == null) {
            return false;
        }

        if (valor == nodo.valor) {
            return true;
        }

        if (valor < nodo.valor) {
            return buscarRecursivo(nodo.izq, valor);
        } else {
            return buscarRecursivo(nodo.der, valor);
        }
    }

    // Método para eliminar un nodo del árbol binario de búsqueda
    public void eliminar(int valor) {
        root = eliminarRecursivo(root, valor);
    }

    private Noda eliminarRecursivo(Noda nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        if (valor == nodo.valor) {
            // Caso 1: Nodo hoja (sin hijos)
            if (nodo.izq == null && nodo.der == null) {
                return null;
            }
            // Caso 2: Nodo con un solo hijo
            if (nodo.izq == null) {
                return nodo.der;
            }
            if (nodo.der == null) {
                return nodo.izq;
            }
            // Caso 3: Nodo con dos hijos
            int minimoValor = encontrarMinimoValor(nodo.der);
            nodo.valor = minimoValor;
            nodo.der = eliminarRecursivo(nodo.der, minimoValor);
            return nodo;
        }

        if (valor < nodo.valor) {
            nodo.izq = eliminarRecursivo(nodo.izq, valor);
            return nodo;
        }

        nodo.der = eliminarRecursivo(nodo.der, valor);
        return nodo;
    }

    private int encontrarMinimoValor(Noda nodo) {
        return nodo.izq == null ? nodo.valor : encontrarMinimoValor(nodo.izq);
    }
}

