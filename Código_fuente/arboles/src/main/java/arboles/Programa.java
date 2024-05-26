package arboles;

import java.util.Scanner;

public class Programa {

    public void menuArbol() {

        Scanner scan = new Scanner(System.in);
        ConstruirArbol arbol = new ConstruirArbol();
        ArbolBin arbolito = new ArbolBin();

        boolean condition = true;
        String expresion;
        int opcion = 0; 

        Nodo raiz;

        System.out.println("\n\n    ******* Menú *******    \n");
        
        while (condition) {
            System.out.println("1. Ingresar expresión");
            System.out.println("2. Salir\n");
            
            System.out.print("Elige una opción: ");
            opcion = scan.nextInt();
            scan.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    System.out.println("\nIngresa la expresión:");
                    expresion = scan.nextLine();

                    raiz = arbol.construccionArbol(expresion);

                    boolean condition2 = true;

                    while (condition2) {
                        System.out.println("\n1. Ver árbol");
                        System.out.println("2. Evaluar operación");
                        System.err.println("3. Salir\n");

                        System.out.print("¿Qué quieres hacer?: ");
                        int caso = scan.nextInt();
                        scan.nextLine(); // Consumir el salto de línea pendiente

                        switch (caso) {
                            case 1:
                                System.out.println("\n");
                                arbolito.inOrden(raiz);
                                System.out.println("\n");
                                break;
                            case 2:
                                int resultado = arbol.resolverExpresion(raiz);
                                System.err.println("El resultado es: "+ resultado);
                                break;
                            case 3:
                                System.out.println("Saliendo\n");
                                condition2 = false;
                                break;
                            default:
                                System.out.println("Escoge una opción válida");
                                break;
                        }
                    }
                    break;

                case 2:
                    condition = false;
                    break;
            
                default:
                    System.out.println("Ingresa una opción válida");
                    break;
            }
        }
        scan.close();
    }
}



