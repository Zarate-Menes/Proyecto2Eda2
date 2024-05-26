package arboles;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al proyecto 2 de EDA II\n");
        try {
            Thread.sleep(2000); // Pausar por 2000 milisegundos (2 segundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Menus menu = new Menus();
        menu.mostrarMenuPrincipal();
    }


}
