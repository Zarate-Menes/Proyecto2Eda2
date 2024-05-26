package arboles;

import java.util.Scanner;

public class Menus {
    
    private ArbolBBBalanceado arbol = new ArbolBBBalanceado();
    private static Scanner scanner = new Scanner(System.in);

    public void mostrarMenuPrincipal() {
        BorrarPantalla();
        System.out.println("\n\n**** Menú Principal ****");
        System.out.println("1. Árbol AVL");
        System.out.println("2. Árbol Red-Black");
        System.out.println("3. Árbol de Expresión Aritmética");
        System.out.println("0. Salir");

        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1:
                mostrarMenuArbolAVL();
                break;
            case 2:
                mostrarMenuArbolRedBlack();
                break;
            case 3:
                mostrarMenuArbolExpresion();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void mostrarMenuArbolAVL() {
        BorrarPantalla();
        System.out.println("\n\n**** Menú Árbol AVL ****");
        System.out.println("1. Agregar clave");
        System.out.println("2. Buscar un valor");
        System.out.println("3. Mostrar recorrido en inorden");
        System.out.println("4. Mostrar recorrido en preorden");
        System.out.println("5. Mostrar recorrido en postorden");
        System.out.println("6. Eliminar valor");
        System.out.println("0. Regresar al menú principal");

        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Implementar la lógica para cada opción del menú AVL
        switch (opcion) {
            case 1:
                insertarValor();
                break;
            case 2:
                buscarValor();
                break;
            case 3:
                mostrarInorden();
                break;
            case 4:
                mostrarPreorden();
                break;
            case 5:
                mostrarPostorden();
                break;
            case 6:
                eliminarValor();
                break;
            case 0:
                mostrarMenuPrincipal();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }


    private void mostrarMenuArbolRedBlack() {
        RedBlackTree tree = new RedBlackTree();
        while (true) {
            BorrarPantalla();
            System.out.println("\n\n**** Menú Árbol Red-Black ****");
            System.out.println("1. Agregar clave");
            System.out.println("2. Eliminar clave");
            System.out.println("3. Mostrar árbol");
            System.out.println("0. Regresar al menú principal");

            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave a agregar: ");
                    int claveAgregar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    tree.insert(claveAgregar);
                    System.out.println("Clave agregada correctamente.");
                    esperarTecla();
                    break;
                case 2:
                    System.out.print("Ingrese la clave a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    tree.deleteNode(claveEliminar);
                    System.out.println("Clave eliminada correctamente.");
                    esperarTecla();
                    break;
                case 3:
                    tree.printTree();
                    esperarTecla();
                    break;
                case 0:
                    mostrarMenuPrincipal();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    esperarTecla();
            }
        }
    }

    private void mostrarMenuArbolExpresion() {
        BorrarPantalla();
        System.out.println("\n\n**** Menú Árbol de Expresión Aritmética ****");
        System.out.println("1. Ingresar expresión");
        System.out.println("2. Mostrar árbol");
        System.out.println("3. Resolver");
        System.out.println("0. Regresar al menú principal");

        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Implementar la lógica para cada opción del menú Expresión
        switch (opcion) {
            case 1:
                // Ingresar expresión aritmética
                break;
            case 2:
                // Mostrar el árbol de expresión
                break;
            case 3:
                break;
            case 0:
                mostrarMenuPrincipal();
                break;
            default:
                System.out.println("Opción no válida.");
        
        }
    }

    private static void BorrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void esperarTecla() {
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    private void insertarValor() {
        System.out.print("Ingresa el valor a insertar: ");
        int valor = scanner.nextInt();
        arbol.insertar(valor);
        System.out.println("Valor insertado.");
    }

    private void buscarValor() {
        System.out.print("Ingresa el valor a buscar: ");
        int valor = scanner.nextInt();
        boolean encontrado = arbol.buscar(valor);
        if (encontrado) {
            System.out.println("Valor encontrado en el árbol.");
        } else {
            System.out.println("Valor no encontrado en el árbol.");
        }
    }

    private  void mostrarInorden() {
        System.out.println("Recorrido en inorden:");
        inordenRecursivo(arbol.root);
        System.out.println();
    }

    private void inordenRecursivo(Noda nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izq);
            System.out.print(nodo.valor + " ");
            inordenRecursivo(nodo.der);
        }
    }

    private void mostrarPreorden() {
        System.out.println("Recorrido en preorden:");
        preordenRecursivo(arbol.root);
        System.out.println();
    }

    private void preordenRecursivo(Noda nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preordenRecursivo(nodo.izq);
            preordenRecursivo(nodo.der);
        }
    }

    private void mostrarPostorden() {
        System.out.println("Recorrido en postorden:");
        postordenRecursivo(arbol.root);
        System.out.println();
    }

    private void postordenRecursivo(Noda nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.izq);
            postordenRecursivo(nodo.der);
            System.out.print(nodo.valor + " ");
        }
    }

    private void eliminarValor() {
        System.out.print("Ingresa el valor a eliminar: ");
        int valor = scanner.nextInt();
        arbol.eliminar(valor);
        System.out.println("Valor eliminado.");
    }

    
}

    
