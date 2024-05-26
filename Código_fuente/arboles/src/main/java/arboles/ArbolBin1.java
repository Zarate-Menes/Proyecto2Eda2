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
import java.util.LinkedList;
import java.util.Queue;

public class ArbolBin1 {
    Noda root;
    
    public ArbolBin1() {
        root = null;
    }
    
    public ArbolBin1(int val) {
        root = new Noda(val);
    }
    
    public ArbolBin1(Noda root) {
        this.root = root;
    }
    
    public void add(Noda padre, Noda hijo, int lado) {
        if (lado == 0)
            padre.setIzq(hijo);
        else
            padre.setDer(hijo);
    }
    
    protected void visit(Noda n) {
        System.out.print(n.valor + " ");
    }
    
    public void breadthFirst() {
        Noda r = root;
        Queue<Noda> queue = new LinkedList<>();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = queue.poll();
                visit(r);
                if (r.izq != null)
                    queue.add(r.izq);
                if (r.der != null)
                    queue.add(r.der);
            }
        }
    }
    
    // Método para eliminar un nodo del árbol binario
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
    
    // Método para buscar un valor en el árbol binario
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
        
        return buscarRecursivo(nodo.izq, valor) || buscarRecursivo(nodo.der, valor);
    }
}
