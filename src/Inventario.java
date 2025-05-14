import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventario {
    private static final Scanner sc = new Scanner(System.in);
    private static Nodo cima; //ultimo articulo agregado

    //Creacion del nodo
    static class Nodo{
        public Articulo articulo;
        public Nodo siguiente;

		public Nodo(Articulo articulo){
            this.articulo = articulo;
            this.siguiente = null;
        }
    }

    //Verifica si la lista esta vacia
    public static boolean estaVacia() {
        return cima == null; // si la cima esta vacia retorna un NULL
    }

    // Funcion para apilar
    public static void apilar(Articulo articulo) {
       Nodo nuevoNodo = new Nodo(articulo);
       nuevoNodo.siguiente = cima; // cada vez que se cree un nuevo nodo estara en la cima, reemplazando el anterior.
       cima = nuevoNodo;
    }

    // funcion doble para quitar el elemento y mostrarlo.
    public static Articulo desapilar() {
        Articulo articulo = cima.articulo;  // Guardamos el dato de la cima
        cima = cima.siguiente; // Movemos la cima al siguiente nodo
        return articulo;
    }

    private static int codigo = 0; // contador para generar un codigo unico automatico

    // NO ME VAYA A PEGAR UN COSCORRON POR EL WHILE EXTRA (son para evitar los errores.)
    //Funcion para registrar los datos del articulo.
    public static void registrarArticulo(){
        do {
            int resp = 0;
            boolean respvalida = false;
            while (!respvalida){
                System.out.println("Desea agregar un nuevo articulo? (1: Sí, 0: No)");
                try{
                    resp = sc.nextInt();
                    respvalida = true;
                }catch (InputMismatchException e){
                    System.out.println("Error: Ingrese un número valido (1 o 0).");
                    sc.nextLine();
                }
            }
            sc.nextLine();

            if (resp != 1) break; // condicion para salir del bucle
            codigo ++; // incrementara cada vez que se genere un nuevo articulo

            //Informacion del articulo.
            System.out.println("Codigo #" + codigo);

            System.out.println("Nombre: ");
            String nombre = sc.nextLine();

            System.out.println("Detalle: ");
            String detalle = sc.nextLine();

            float precio = 0;
            boolean precioValido = false;
            while (!precioValido) {
                System.out.print("Precio: ");
                try { //Try-catch usado para ingresar un valor valido.
                    precio = Float.parseFloat(sc.nextLine());
                    precioValido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Ingrese un número válido.");
                }
            }

            //Crea el articulo.
            apilar(new Articulo(codigo, nombre, detalle, precio));
            System.out.println("\nArticulo ingresado: " + "Codigo:" + codigo + " Nombre: " + nombre + " Detalle: " + detalle + " Precio $" + precio);

        } while(true);
    }
    // Funcion para imprimir la lista de articulos.
    public static void mostrar(){
        if (estaVacia()) {
            System.out.println("La Lista de articulos está vacía");
            registrarArticulo(); // En caso que este vacia la lista envia la funcion de registrar un articulo
        }else{
            System.out.println("Lista de articulos (orden LIFO): ");
            while (!estaVacia()) {
            Articulo articulo = desapilar(); // Desapila y obtiene el artículo
                System.out.println("Código: " + articulo.getCodigo() + " Nombre: " + articulo.getNombre() + " Detalle: " + articulo.getDetalle() + " Precio: $" + articulo.getPrecio());

            }
        }
    }
}


