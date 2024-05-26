package arboles;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la practica 2 de EDA II\n");
        try {
            Thread.sleep(2000); // Pausar por 2000 milisegundos (2 segundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Menus menuPrincipal = new Menus();
        menuPrincipal.mostrarMenuPrincipal();
    }


}
