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
    public ArbolBBBalanceado(Noda root) {
        super(root);
    }
    
    @Override
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
    
    // Método para eliminar una clave del árbol
    public void eliminar(int valor) {
        root = eliminarRecursivo(root, valor);
    }
    
    private Noda eliminarRecursivo(Noda nodo, int valor) {
        if (nodo == null) {
            return null;
        }
        
        if (valor < nodo.valor) {
            nodo.izq = eliminarRecursivo(nodo.izq, valor);
        } else if (valor > nodo.valor) {
            nodo.der = eliminarRecursivo(nodo.der, valor);
        } else {
            // Nodo encontrado, realizar la eliminación
            if (nodo.izq == null || nodo.der == null) {
                // Caso 1: Nodo hoja o con un solo hijo
                Noda temp = null;
                if (temp == nodo.izq) {
                    temp = nodo.der;
                } else {
                    temp = nodo.izq;
                }
                
                // No hay hijos
                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else { // Un hijo
                    nodo = temp; // Copiar el contenido del hijo no nulo
                }
            } else {
                // Caso 2: Nodo con dos hijos
                // Obtener el sucesor del nodo
                Noda sucesor = encontrarSucesor(nodo.der);
                
                // Copiar el valor del sucesor al nodo actual
                nodo.valor = sucesor.valor;
                
                // Eliminar el sucesor
                nodo.der = eliminarRecursivo(nodo.der, sucesor.valor);
            }
        }
        
        // Si el árbol tenía solo un nodo, devolverlo
        if (nodo == null) {
            return null;
        }
        
        // Actualizar la altura del nodo actual
        nodo.altura = 1 + Math.max(altura(nodo.izq), altura(nodo.der));
        
        // Obtener el factor de balanceo de este nodo
        int balance = obtenerBalance(nodo);
        
        // Caso 1: Rotación simple a la derecha
        if (balance > 1 && obtenerBalance(nodo.izq) >= 0) {
            return rotarDerecha(nodo);
        }
        
        // Caso 2: Rotación simple a la izquierda
        if (balance < -1 && obtenerBalance(nodo.der) <= 0) {
            return rotarIzquierda(nodo);
        }
        
        // Caso 3: Rotación doble izquierda-derecha
        if (balance > 1 && obtenerBalance(nodo.izq) < 0) {
            nodo.izq = rotarIzquierda(nodo.izq);
            return rotarDerecha(nodo);
        }
        
        // Caso 4: Rotación doble derecha-izquierda
        if (balance < -1 && obtenerBalance(nodo.der) > 0) {
            nodo.der = rotarDerecha(nodo.der);
            return rotarIzquierda(nodo);
        }
        
        return nodo;
    }
    
    private Noda encontrarSucesor(Noda nodo) {
        Noda actual = nodo;
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual;
    }
    
    private int altura(Noda nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }
    
    private int obtenerBalance(Noda nodo) {
        return (nodo == null) ? 0 : altura(nodo.izq) - altura(nodo.der);
    }
    
    private Noda rotarDerecha(Noda y) {
        Noda x = y.izq;
        Noda T2 = x.der;
        
        // Realizar la rotación
        x.der = y;
        y.izq = T2;
        
        // Actualizar alturas
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        
        // Retornar la nueva raíz
        return x;
    }
    
    private Noda rotarIzquierda(Noda x) {
        Noda y = x.der;
        Noda T2 = y.izq;
        
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

