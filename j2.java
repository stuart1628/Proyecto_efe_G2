import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

class j2 {

    Scanner cliente = new Scanner(System.in);
    private static HashMap<String, String> clientes = new HashMap<>();
    String[] ACER = {"Laptop Acer Aspire 16\" IPS Windows 11 Intel Core i7 12a Gen 16GB 512GB AL16-51P-7984",
            "Laptop Acer Predator Helios Neo 16 16\" Windows 11 Intel Core I9 13a Gen 24 Núcleos 16GB 1TB SSD NVIDIA RTX4060 8GB",
            "Laptop Acer Aspire 15 15.6\" Windows 11 Home Intel Core 5 120U 16GB 512GB A15-51P-57UK",
            "Laptop Acer Nitro V 15 15,6\" Windows 11 Intel Core I5 13a Gen 8 Núcleos 16GB 512GB SSD NVIDIA RTX3050 6GB",
            "Laptop Acer Aspire 3 15,6\" Touch Windows 11 Ryzen 5 Serie 7000 8GB 512GB"};
    Random random = new Random();
    double[] precio = { 2.599, 0.18,6.999,2.299,3.499,2.499};
    double igv, subtotal, totalpagar;
    int[] carrito = new int[ACER.length];
    String correo, contraseña1;
    int opcion, cantidad;

    // Menú principal
    public void MenuPrincipal() {
        System.out.println("---------Bienvenido a La Tia EFE-----------");
        System.out.println(" 1.- Iniciar Sesion");
        System.out.println(" 2.- Crear Cuenta");
        System.out.println(" Seleccione una Opcion:");
        opcion = cliente.nextInt();
        cliente.nextLine();
        // Limpiar el buffer
        switch (opcion) {
            case 1:
                IniciarSesion();
                break;
            case 2:
                CrearCuenta();
                break;

            default:
                System.out.println("Opcion no valida");

        }
    }

    public void IniciarSesion() {
        System.out.println("Iniciar sesión");
        int intentos = 0;
        boolean accesoPermitido = false;

        while (intentos < 3) {
            System.out.println("Ingrese su correo");
            String correoIngresado = cliente.nextLine();
            System.out.println("Ingrese su Contraseña");
            String contraseñaIngresada = cliente.nextLine();

            if (clientes.containsKey(correoIngresado) && clientes.get(correoIngresado).equals(contraseñaIngresada)) {
                System.out.println("--Bienvenido a tienda EFE\uD83C\uDFEA--");
                accesoPermitido = true;
                break;
            } else {
                intentos++;
                System.out.println("Correo o Contraseña incorrecta... " + (3 - intentos));
            }
        }

        if (!accesoPermitido) {
            System.out.println("Espera mil años por favor:");
        }
    }

    public void CrearCuenta() {
        System.out.println("Crear cuenta");

        System.out.print("Nombre: ");
        String nombre = cliente.nextLine();

        System.out.print("Apellido: ");
        String apellido = cliente.nextLine();


        String dni;
        while (true) {
            System.out.print("DNI de 8 dígitos: ");
            dni = cliente.nextLine();
            if (dni.length() == 8 && dni.matches("\\d+")) {
                break;
            } else {
                System.out.println("DNI incorrecto. Intente nuevamente.");
            }
        }

        String numero;
        while (true) {
            System.out.print("Número de celular de 9 dígitos: ");
            numero = cliente.nextLine();
            if (numero.length() == 9 && numero.matches("\\d+")) {
                break;
            } else {
                System.out.println("Número incorrecto");
            }
        }

        while (true) {
            System.out.print("Ingrese un correo con !@gmail.com! ");
            correo = cliente.nextLine();
            if (correo.endsWith("@gmail.com")) {
                break;
            } else {
                System.out.println("Correo incorrecto. Debe contener '@gmail.com'. Intente nuevamente.");
            }
        }

        String contraseñaConfirmada;
        while (true) {
            System.out.print("mínimo 6 caracteres ");
            contraseña1 = cliente.nextLine();
            System.out.print("Confirme la contraseña: ");
            contraseñaConfirmada = cliente.nextLine();
            if (contraseña1.equals(contraseñaConfirmada) && contraseña1.length() >= 6) {
                break;
            } else {
                System.out.println("Intente nuevamente (6)");
            }
        }


        clientes.put(correo, contraseña1);

        System.out.println("Cuenta exitosa. Bienvenido a Tienda Efe " + nombre + ".");

        System.out.println("Catalogo");
        int opciones = cliente.nextInt();
        cliente.nextLine();
        switch (opciones){
            case 1:
                System.out.println("Estilo de vida");
                this.Estilodevida();
                break;
            case 2:
                System.out.println("Añadir mas Compras");
                //this.seguirComprando();
            default:
                System.out.println("opcion no valida");
        }
    }
    public void Estilodevida(){
        boolean seguirComprando = true;
        System.out.println("Seleccione una opcion");
        System.out.println("1.-Trabajo y estudio en casa");
        //System.out.println("2.-Hogareño");
        //System.out.println("3.-Tecnologico");
        //System.out.println("4.-Gamer");
        //System.out.println("5.-Deporte y vida sana");
        //System.out.println("6.-Viajero");
        //System.out.println("7.-Divertido");
        int opcion = cliente.nextInt();
        cliente.nextLine();
        switch (opcion){
            case 1:
                this.Trabajo_y_estudio_en_casa();
                break;
            case 2:
                //this.Hogareño();
                break;
            case 3:
                //this.Tecnologico();
                break;
            case 4:
                //this.Gamer();
                break;
            case 5:
                //this.Deporte_y_vida_sana();
                break;
            case 6:
                // this.Viajero();
                break;
            case 7:
                //this.Divertido();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
    public void Trabajo_y_estudio_en_casa(){
        System.out.println("Seleccione una opcion");
        System.out.println("1.-Laptops");
        System.out.println("2.-All_in_one");
        System.out.println("3.-Impresoras_y_multifuncionales");
        System.out.println("4.-Tablets ");
        System.out.println("5.-Routers_y_repetidores");
        System.out.println("6.-Escritorios");
        System.out.println("7.-Sillas_de_escritorio");
        System.out.println("8.-Accesorios_de_cómputo");
        System.out.println("9.-Útiles_escolares_y_de_oficina");
        int opcion = cliente.nextInt();
        cliente.nextLine();
        switch (opcion){
            case 1:
                this.Laptops();
                break;
            case 2:
                //this.All_in_one();
                break;
            case 3:
                //this.Impresoras_y_multifuncionales();
                break;
            case 4:
                //this.Tablets();
                break;
            case 5:
                //this.Routers_y_repetidores();
                break;
            case 6:
                //this.Escritorios();
                break;
            case 7:
                //this.Sillas_de_escritorio();
                break;
            case 8:
                //this.Accesorios_de_cómputo();
                break;
            case 9:
                //this.Útiles_escolares_y_de_oficina();
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }
    public void Laptops(){
        System.out.println("Elija su Marca");
        System.out.println("1.-ACER");
        System.out.println("2.-ADVANCE");
        System.out.println("3.-APPLE");
        System.out.println("4.-ASUS");
        System.out.println("5.-GIGABYTE");
        System.out.println("6.-HP");
        System.out.println("7.-LENOVA");
        System.out.println("8.-MSI");
        int opcion = cliente.nextInt();
        cliente.nextLine();
        switch (opcion){
            case 1:
                this.ACER();
                break;
            case 2:
                this.ADVANCE();
                break;
            case 3:
                //this.APPLE();
                break;
            case 4:
                //this.ASUS();
                break;
            case 5:
                //this.GIGABYTE();
                break;
            case 6:
                //this.HP();
                break;
            case 7:
                //this.LENOVA();
                break;
            case 8:
                //this.MSI();
                break;
            default:
                System.out.println("opncion no valida");
                break;


        }
    }
    public void ACER(){
        System.out.println("------ LAPTOS DISPONIBLES ------------");
        System.out.println("Seleccione la laptop que desea comprar");
        for (int i = 0; i < ACER.length; i++) {
            System.out.println("Opcion " + (i + 1) + " : " + ACER[i]);
        }
        opcion = cliente.nextInt();
        cliente.nextLine();
        switch (opcion){
            case 1:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad");
                cantidad=cliente.nextInt();
                carrito[0]+=cantidad;
                System.out.println("Ud ha pedido "+carrito[0]);
                System.out.println("¿Desea elegir otro menú más?  1 SI/ 2 NO / 3 Menu Principal");
                opcion=cliente.nextInt();
                cliente.nextLine();
                if(opcion==1)
                {
                    System.out.println("Opcion Invalida");
                }
                else if (opcion==2){
                    this.PagoMenus();
                }
                else if (opcion==3){
                    this.MenuPrincipal();
                }
                else
                {
                    System.out.println("Opcion no válida");
                }

                break;

            case 2:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad");
                cantidad=cliente.nextInt();
                carrito[1]+=cantidad;
                System.out.println("Ud ha pedido "+carrito[1]);
                System.out.println("¿Desea elegir otro menú más?  1 SI/ 2 NO / 3 Menu Principal");
                opcion=cliente.nextInt();
                cliente.nextLine();
                if(opcion==1)
                {
                    System.out.println("Volviendo a la opción de compra");

                }
                else if (opcion==2){
                    this.PagoMenus();
                }
                else if (opcion==3){
                    this.MenuPrincipal();
                }
                else
                {
                    System.out.println("Opcion no válida");
                }

                break;

            case 3:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad");
                cantidad=cliente.nextInt();

                carrito[2]+=cantidad;
                System.out.println("Ud ha pedido "+carrito[2]);
                System.out.println("¿Desea elegir otro menú más?  1 SI/ 2 NO / 3 Menu Principal");
                opcion=cliente.nextInt();
                cliente.nextLine();
                if(opcion==1)
                {
                    System.out.println("Volviendo a la opción de compra");

                }
                else if (opcion==2){
                    this.PagoMenus();
                }
                else if (opcion==3){
                    this.MenuPrincipal();
                }
                else
                {
                    System.out.println("Opcion no válida");
                }


                break;
            case 4:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad");
                cantidad=cliente.nextInt();

                carrito[3]+=cantidad;
                System.out.println("Ud ha pedido "+carrito[2]);
                System.out.println("¿Pago_N");
                opcion=cliente.nextInt();
                cliente.nextLine();
                if(opcion==1)
                {
                    System.out.println("Volviendo a la opción de compra");
                }
                else if (opcion==2){
                    this.PagoMenus();
                }
                else if (opcion==3){
                    this.MenuPrincipal();
                }
                else
                {
                    System.out.println("Opcion no válida");
                }
                break;
            default:
                System.out.println("Opcion no válida");
                this.MenuPrincipal();
                break;
        }
    }

    public void ADVANCE() {
        String[] ADVANCE = {"1.-Laptop Advance Notebook PS5086 15.6\" Intel Core i5 256GB SSD 8GB Gris__ 2,049"};
        double[] precio = {2049};
        System.out.println("------ LAPTOS DISPONIBLES ------------");
        System.out.println("Seleccione la laptop que desea comprar");

        for (int i = 0; i < ADVANCE.length; i++) {
            System.out.println("Opcion " + (i + 1) + " : " + ADVANCE[i]);
        }
        opcion = cliente.nextInt();
        cliente.nextLine();
        int[] carrito = new int[ADVANCE.length];
        switch (opcion) {
            case 1:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad:");
                cantidad = cliente.nextInt();
                carrito[0] += cantidad;
                System.out.println("Ud ha pedido " + carrito[0] + " unidades.");
                System.out.println("no");
                opcion = cliente.nextInt();
                cliente.nextLine();

                if (opcion == 1) {
                    System.out.println("Volviendo a la opción de compra...");
                    this.ADVANCE();
                } else if (opcion == 2) {
                    this.PagoMenus();
                } else if (opcion == 3) {
                    this.MenuPrincipal();
                } else {
                    System.out.println("Opción no válida.");
                    this.MenuPrincipal();
                }
                break;

            default:
                System.out.println("Opción no válida.");
                this.MenuPrincipal();
                break;
        }
    }


    public double PagoMenus() {
        double cantidadtotalmenus=Arrays.stream(carrito).sum();
        double subtotal0= (cantidadtotalmenus*precio[0])+subtotal;
        igv= subtotal0*precio[1];
        subtotal=subtotal0-igv;
        totalpagar=subtotal+igv;
        System.out.println("----BOLETA DE VENTA---------");
        System.out.println(" SUBTOTAL :"+subtotal);
        System.out.println(" IGV :"+igv);
        System.out.println(" TOTAL :"+totalpagar);
        return totalpagar;
    }


    public static void main(String[] args) {
        j2 tienda = new j2();
        tienda.MenuPrincipal();
    }
}
