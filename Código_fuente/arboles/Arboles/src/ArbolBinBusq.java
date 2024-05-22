/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose11
 */ 

public class ArbolBinBusq extends ArbolBin {
    
    public ArbolBinBusq() {
        super();
    }
    
    public ArbolBinBusq(int val) {
        super(val);
    }
    
    public ArbolBinBusq(Nodo root) {
        super(root);
    }
    
    // Método para insertar un valor en el árbol binario de búsqueda
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
        }
        
        return nodo;
    }
    
    // Método para buscar un valor en el árbol binario de búsqueda
    public boolean buscar(int valor) {
        return buscarRecursivo(root, valor);
    }
    
    private boolean buscarRecursivo(Nodo nodo, int valor) {
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
}
