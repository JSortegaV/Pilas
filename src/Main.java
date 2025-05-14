import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        // Menu principal
        while(!salir){
            System.out.println("Bienvenido al inventario.");
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1- Insertar un artículo.");
            System.out.println("2- Mostrar los articulos");
            System.out.println("3- Salir");

            System.out.println("Ingrese su opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Inventario.registrarArticulo();
                    break;
                case 2:
                    Inventario.mostrar();
                    break;
                case 3:
                    salir = true;
                    break;
            }
            if (!salir) {
                System.out.println("\nPresione Enter para continuar...");
                sc.nextLine();
            }
        }
        sc.close();
        System.out.println("Programa finalizado.");
    }
}


