package arboles;

import java.util.Scanner;

public class Menus {

    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuPrincipal() {
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

    private static void mostrarMenuArbolAVL() {
        BorrarPantalla();
        System.out.println("\n\n**** Menú Árbol AVL ****");
        System.out.println("1. Agregar clave");
        System.out.println("2. Buscar un valor");
        System.out.println("3. Eliminar clave");
        System.out.println("4. Mostrar árbol");
        System.out.println("0. Regresar al menú principal");

        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Implementar la lógica para cada opción del menú AVL
        switch (opcion) {
            case 1:
                // Agregar clave al árbol AVL
                break;
            case 2:
                // Buscar un valor en el árbol AVL
                break;
            case 3:
                // Eliminar clave del árbol AVL
                break;
            case 4:
                // Mostrar el árbol AVL
                break;
            case 0:
                mostrarMenuPrincipal();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }


    private static void mostrarMenuArbolRedBlack() {
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

    private static void mostrarMenuArbolExpresion() {
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
                // Resolver la expresión aritmética
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

    
}

    