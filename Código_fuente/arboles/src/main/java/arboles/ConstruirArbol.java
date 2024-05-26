package arboles;

import java.util.StringTokenizer;
import java.util.Stack;

public class ConstruirArbol {

    public Nodo construccionArbol(String expresion){

        StringTokenizer tokenizer = new StringTokenizer(expresion, "()+-*/ ", true);
        Stack<Nodo> nodos = new Stack<>();
        Stack<String> operadores = new Stack<>();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (token.isEmpty()) continue;

            if (esOperador(token)) {
                while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(token)) {
                    nodos.push(construirSubarbol(nodos, operadores.pop()));
                }
                operadores.push(token);
            } else if (token.equals("(")) {
                operadores.push(token);
            } else if (token.equals(")")) {
                while (!operadores.peek().equals("(")) {
                    nodos.push(construirSubarbol(nodos, operadores.pop()));
                }
                operadores.pop(); // Quitar el "(" de la pila
            } else {
                nodos.push(new Nodo(token));
            }
        }

        while (!operadores.isEmpty()) {
            nodos.push(construirSubarbol(nodos, operadores.pop()));
        }

        return nodos.pop();
    }


    // Método para construir un subárbol a partir de nodos y un operador
    private Nodo construirSubarbol(Stack<Nodo> nodos, String operador) {
        Nodo derecho = nodos.pop();
        Nodo izquierdo = nodos.pop();
        return new Nodo(operador, izquierdo, derecho);
    }


    // Método para verificar si un token es un operador
    private boolean esOperador(String token) {
        return "+-*/".contains(token);
    }


    // Método para obtener la precedencia de un operador
    private int precedencia(String operador) {
        switch (operador) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }


    
    public int resolverExpresion(Nodo raiz) {
        if (raiz == null) {
            throw new IllegalArgumentException("El nodo raíz es nulo");
        }

        return evaluarExpresionRecursivamente(raiz);
    }


    
    private int evaluarExpresionRecursivamente(Nodo nodo) {
        if (nodo == null) {
            throw new IllegalArgumentException("El nodo es nulo");
        }

        if (nodo.nIzq == null && nodo.nDer == null) {
            // Si es una hoja, devolvemos su valor (convertido a entero)
            return Integer.parseInt(nodo.value);
        }

        // Evaluamos recursivamente las expresiones de los hijos izquierdo y derecho
        int izquierdo = evaluarExpresionRecursivamente(nodo.nIzq);
        int derecho = evaluarExpresionRecursivamente(nodo.nDer);

        // Realizamos la operación correspondiente según el operador del nodo actual
        switch (nodo.value) {
            case "+":
                return izquierdo + derecho;
            case "-":
                return izquierdo - derecho;
            case "*":
                return izquierdo * derecho;
            case "/":
                if (derecho == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return izquierdo / derecho;
            default:
                throw new IllegalArgumentException("Operador no válido: " + nodo.value);
        }
    }
}

