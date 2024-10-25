import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class EFE {
    private Scanner esponja = new Scanner(System.in);
    private String apodo;
    public static boolean registrarse = false;
    public static boolean inicio_sesion = false;
    public static List<String> registro_de_usuarios = new ArrayList<>();
    public static List<String> registro_de_contraseñas = new ArrayList<>();
    private static double totalpagar = 0;
    private static String metodo_de_pago_seleccionado = "";
    private static String detalles_pago = "";

    public static void iniciar_sesion() {
        Scanner grinch = new Scanner(System.in);
        String op;
        String correo_valido, contraseña_valida;
        String registro, contraseña, respuesta;

        System.out.println("PARA COMENZAR A REALIZAR PEDIDOS DEBE: (registrese/inicie sesion)");
        System.out.println("1.- REGISTRARSE");
        System.out.println("2.- INICIAR SESION");
        op = grinch.nextLine();

        switch (op) {
            case "1":
                if (!registrarse) {
                    System.out.println("REGISTRO:");
                    System.out.println("registre su correo electronico:");
                    registro = grinch.nextLine();
                    while (!registro.contains("@gmail.com")) {
                        System.out.println("Correo electrónico inválido, por favor vuelva a intentar :).");
                        registro = grinch.nextLine();
                    }
                    registro_de_usuarios.add(registro);
                    System.out.println("cree su contraseña:");
                    contraseña = grinch.nextLine();
                    registro_de_contraseñas.add(contraseña);

                    System.out.println("INICIAR SESIÓN:");
                    do {
                        System.out.println("Ingrese su correo electrónico");
                        correo_valido = grinch.nextLine();
                        System.out.println("Ingrese su contraseña: ");
                        contraseña_valida = grinch.nextLine();

                        for (int i = 0; i < registro_de_usuarios.size(); i++) {
                            if (correo_valido.equals(registro_de_usuarios.get(i)) && contraseña_valida.equals(registro_de_contraseñas.get(i))) {
                                System.out.println("Inicio de sesión, ¡EXITOSO!");
                                registrarse = true;
                                inicio_sesion = true;
                                break;
                            }
                        }
                        if (!inicio_sesion) {
                            System.out.println("Inicio de sesión, ¡FALLIDO!");
                            System.out.println("Correo o contraseña incorrecta.");
                        }
                    } while (!inicio_sesion);
                }
                break;

            case "2":
                System.out.println("INICIAR SESIÓN:");
                System.out.println("ingrese su correo:");
                correo_valido = grinch.nextLine();
                System.out.println("ingrese su contraseña:");
                contraseña_valida = grinch.nextLine();

                for (int i = 0; i < registro_de_usuarios.size(); i++) {
                    if (correo_valido.equals(registro_de_usuarios.get(i)) && contraseña_valida.equals(registro_de_contraseñas.get(i))) {
                        System.out.println("Inicio de sesión, ¡EXITOSO!");
                        inicio_sesion = true;
                        break;
                    }
                }
                if (!inicio_sesion) {
                    System.out.println("Inicio de sesión, ¡FALLIDO!");
                    System.out.println("Correo o contraseña incorrecta.");
                }
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public void menu() {
        System.out.println("---- EFE ----");
        System.out.println(":::MENU:::");
        System.out.println("¿QUÉ ESTÁS BUSCANDO HOY?");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ELECTROHOGAR/TRANSPORTE/DEPORTE");
        int opcion = esponja.nextInt();
        switch (opcion) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                this.op_tecnologia();
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }
    public String op_tecnologia() {
        String[] RECIEN = {"LICUADORA OSTER $774.00", "LICUADORA BOSCH $555.00", "LICUADORA IMACO $346.00"};
        String[] PERSONAJES = {"CAMISETA DE CRISTIANO $1000.00", "CAMISETA DE MESSI $1210.00", "CAMISETA DE MBAPPE $1150.00"};
        String[] TEC = {"MOTO HONDA CBR190 $13000.00", "MOTO PULSAR NS 200 $11340.00", "MOTO KTM DUKE 200 $15990.00"};
        double[] precio = {774.00, 555.00, 346.00, 1000.00, 1210.00, 1150.00,13000.00,11340.00,15990.00};

        double igv, subtotalTotal;
        int[] carrito = new int[RECIEN.length];
        int[] carrito_PERSONAJES = new int[PERSONAJES.length];
        int[] carrito_ZAPATOS = new int[TEC.length];
        int opcion, cantidad;

        String metodo_de_pago;
        System.out.println("-----------BIENVENIDOS A EFE-----------");
        System.out.println("ENCUENTRA TU STOCK FAVORITO AQUI");
        System.out.println("TENEMOS EN:");
        System.out.println(" 1.- ELECTROHOGAR");
        System.out.println(" 2.- CAMISESTAS");
        System.out.println(" 3.- MOTOS");

        opcion = esponja.nextInt();
        esponja.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Elige una opción:");
                for (int i = 0; i < RECIEN.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + RECIEN[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[0] += cantidad;
                        System.out.println("Ha pedido " + carrito[0] + " de " + RECIEN[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[1] += cantidad;
                        System.out.println("Ha pedido " + carrito[1] + " de " + RECIEN[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[2] += cantidad;
                        System.out.println("Ha pedido " + carrito[2] + " de " + RECIEN[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 2:
                System.out.println("Elige una opción:");
                for (int i = 0; i < PERSONAJES.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + PERSONAJES[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[0] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[0] + " de " + PERSONAJES[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[1] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[1] + " de " + PERSONAJES[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[2] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[2] + " de " + PERSONAJES[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 3:
                System.out.println("Elige una opción:");
                for (int i = 0; i < TEC.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + TEC[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[0] += cantidad;
                        System.out.println("Ha pedido " + carrito[0] + " de " + TEC[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[1] += cantidad;
                        System.out.println("Ha pedido " + carrito[1] + " de " + TEC[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[2] += cantidad;
                        System.out.println("Ha pedido " + carrito[2] + " de " + TEC[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        subtotalTotal = Arrays.stream(carrito).sum() * precio[0] + Arrays.stream(carrito_PERSONAJES).sum() * precio[1] + Arrays.stream(carrito_ZAPATOS).sum() * precio[2];
        igv = subtotalTotal * 0.18;
        totalpagar = subtotalTotal + igv;

        System.out.println("Subtotal XIAMI : S/ " + Arrays.stream(carrito).sum() * precio[0]);
        System.out.println("Subtotal SAMSUMG : S/ " + Arrays.stream(carrito_PERSONAJES).sum() * precio[1]);
        System.out.println("Subtotal IPHONE : S/ " + Arrays.stream(carrito_ZAPATOS).sum() * precio[2]);
        System.out.println("----------------------------------------");
        System.out.println("Subtotal Total: S/ " + subtotalTotal);
        System.out.println("IGV : S/ " + igv);
        System.out.println("Total a pagar: S/ " + totalpagar);

        System.out.println("Seleccione tipo de pago:");
        System.out.println("1. Tarjeta de crédito");
        System.out.println("2. Efectivo");
        System.out.println("3. Factura");
        metodo_de_pago = esponja.nextLine();

        switch (metodo_de_pago) {
            case "1":
                metodo_de_pago_seleccionado = "Tarjeta de crédito";
                metodopago_tarjeta();
                break;
            case "2":
                metodo_de_pago_seleccionado = "Efectivo";
                metodopago_efectivo();
                break;
            case "3":
                metodo_de_pago_seleccionado = "Factura";
                metodopago_factura();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        exportarFactura("TECNOLOGÍA");
        return null;
    }

    static void metodopago_tarjeta() {
        String metodo, fecha, cvv, nombre, confirmar, volver, volverr, menu;
        boolean valida;
        Scanner esponja = new Scanner(System.in);
        do {
            System.out.println("INGRESE EL NOMBRE Y APELLIDO DEL TITULAR DE LA TARJETA");
            nombre = esponja.nextLine();
            System.out.println("INGRESE SU NUMERO DE TARJETA:  (1234 1234 1234 1234)");
            metodo = esponja.nextLine().trim();
            if (metodo.length() != 19 || !metodo.matches("[4-5]\\d{3} \\d{4} \\d{4} \\d{4}")) {
                System.out.println("Ingreso incorrecto, por favor intente de nuevo.");
            }
            break;
        } while (metodo.length() != 19 || !metodo.matches("[4-5]\\d{3} \\d{4} \\d{4} \\d{4}"));
        do {
            System.out.println("INGRESE LA FECHA DE VENCIMIENTO DE SU TARJETA (MM/AAAA):");
            fecha = esponja.nextLine().trim();
            valida = fecha.matches("\\d{2}/\\d{4}");
            if (valida) {
                String[] partes = fecha.split("/");
                int mes = Integer.parseInt(partes[0]);
                int año = Integer.parseInt(partes[1]);
                valida = (año >= 2024 && mes >= 6) && (año <= 2035 && mes <= 12);
            }
            if (!valida) {
                System.out.println("Por favor, SU TARJETA VENCIÓ, VUELVE A INTENTAR O CAMBIE EL METODO DE PAGO.");
            }
            break;
        } while (!valida);
        do {
            System.out.println("INGRESE SU CODIGO (CVV)");
            cvv = esponja.nextLine().trim();
            if (cvv.length() != 3 || !cvv.matches("\\d{3}")) {
                System.out.println("Por favor, CODIGO (CVV) INCORRECTO O NO COINCIDE CON LA TARJETA, VUELVE A INTENTAR.");
            }
            break;
        } while (cvv.length() != 3 || !cvv.matches("\\d{3}"));
        System.out.println("DESEA CONFIRMAR SU METODO DE PAGO:  (SI/NO)");
        confirmar = esponja.nextLine();
        if (confirmar.equals("si") || confirmar.equals("SI")) {
            System.out.println("---------------EFE---------------");
            System.out.println("EFE----------03:30------08/07/2024");
            System.out.println("---------------caja:12---------------");
            System.out.println("-------------------------------------");
            System.out.println("VENTA:");
            detalles_pago = "PAGO FUE REALIZADO CON EXITO\n"
                    + "LA TRANSACCION FUE REALIZADA POR EL TITULAR: " + nombre
                    + "\nMONTO DESCONTADO A LA TARJETA: " + metodo + " -- " + fecha + " -- XXX";
            System.out.println(detalles_pago);
            System.out.println("-------------------------------------");
            System.out.println("-----GRACIAS POR VISITAR EFE-----");
            System.out.println("-------------------------------------");
            System.out.println("DESEA VOLVER AL MENU PRINCIPAL?? (SI/NO)");
            volver = esponja.nextLine();
            if (volver.equals("si") || volver.equals("SI")) {
                System.out.println("MENU");
            }
        } else if (confirmar.equals("no") || confirmar.equals("NO")) {
            System.out.println("SU PAGO SE HA CANCELADO");
            System.out.println("¿DESEA CAMBIAR DE MÉTODO DE PAGO? (SI/NO)");
            volverr = esponja.nextLine();
            if (volverr.equals("si") || volverr.equals("SI")) {
                metodopago_efectivo();}
            if (volverr.equals("si") || volverr.equals("SI")) {
                metodopago_tarjeta();
            } else {
                System.out.println("SU PEDIDO SE HA CANCELADO");
                System.out.println("DESEA VOLVER AL MENU PRINCIPAL?? (SI/NO)");
                menu = esponja.nextLine();
                if (menu.equals("si") || menu.equals("SI")) {
                    System.out.println("MENU");
                } else {
                    System.out.println("GRACIAS POR VISITAR A EFE");
                }
            }
        }
    }
    static void metodopago_efectivo() {
        Scanner esponja = new Scanner(System.in);
        double montoefectivo;
        System.out.println("INGRESE EL MONTO EN EFECTIVO");
        montoefectivo = esponja.nextDouble();
        System.out.println("------------EFE------------");
        System.out.println("EFE-----03:30-----08/07/2024");
        System.out.println("------------caja:12------------");
        System.out.println("-------------------------------");
        System.out.println("VENTA:");
        detalles_pago = "PAGO REALIZADO GRACIAS POR SU COMPRA"
                + "\nMonto entregado en efectivo: " + montoefectivo
                + "\nCambio devuelto: " + (montoefectivo - totalpagar);
        System.out.println(detalles_pago);
        System.out.println("-------------------------------");
        System.out.println("--GRACIAS POR VISITAR EFE--");
        System.out.println("-------------------------------");
    }
    static void metodopago_factura() {
        Scanner esponja = new Scanner(System.in);
        double montoefectivo,dni,ruc;
        String name,dire;
        System.out.println("Ingresar su nombre");
        name= esponja.nextLine();
        System.out.println("Ingresar su dni");
        dni= esponja.nextDouble();
        System.out.println("Ingresar su RUC");
        ruc= esponja.nextDouble();
        System.out.println("Ingresar su direccion");
        dire= esponja.nextLine();
        System.out.println("INGRESE EL MONTO EN EFECTIVO");
        montoefectivo = esponja.nextDouble();
        System.out.println("------------EFE------------");
        System.out.println("  JR   TUMBES   391 - JULIACA  ");
        System.out.println("-------------------------------");
        System.out.println("--fECHA DE EMISION:25/06/2024--");
        System.out.println("Nombre: " +name);
        System.out.println("DNI"+dni);
        System.out.println("RUC: " +ruc);
        System.out.println("Direccion:"+dire);
        System.out.println("Tipo de moneda: NUEVOS SOLES ");
        System.out.println("VENTA:");
        detalles_pago = "PAGO REALIZADO GRACIAS POR SU COMPRA\n"
                + "Monto entregado en efectivo: " + montoefectivo
                + "\nCambio devuelto: " + (montoefectivo - totalpagar);
        System.out.println(detalles_pago);
        System.out.println("-------------------------------");
        System.out.println("--GRACIAS POR VISITAR OSCHSLE--");
    }
    public static void exportarFactura(String categoria) {
        try {
            FileWriter factura = new FileWriter("factura.txt");
            factura.write("--------------EFE--------------\n");
            factura.write("EFE-------03:30-------08/07/2024\n");
            factura.write("--------------caja:12--------------\n");
            factura.write("Numero de perdido    213112515123-1\n");
            factura.write("-----------------------------------\n");
            factura.write("VENTA:\n");
            factura.write("-----------------------------------\n");
            factura.write("Categoría: " + categoria + "\n");
            factura.write("Total a pagar: S/ " + totalpagar + "\n");
            factura.write("Método de pago: " + metodo_de_pago_seleccionado + "\n");
            factura.write(detalles_pago + "\n");
            factura.write("-----------------------------------\n");
            factura.write("Vendedor:\n");
            factura.write("dk1162ef\n");
            factura.write("numero de serie:        11-49616862\n");
            factura.write("cod cajero:                    4230\n");
            factura.write("Nombre de cajero: DimasK.de la Cruz\n");
            factura.write("----------------IZYFAY-------------\n");
            factura.write("ID:                0000151920266314\n");
            factura.write("OECHSLE            JULIACA(1278398)\n");
            factura.write("  JR      TUMBES     391 -  JULIACA\n");
            factura.write("TERM 00614308                B8.652\n");
            factura.write("----GRACIAS POR VISITAR OECHSLE----\n");
            factura.write("-----------------------------------\n");
            factura.close();
            System.out.println("Factura exportada con éxito.");
        } catch (IOException C) {
            System.out.println("Ocurrió un error al exportar la factura.");
            C.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("presione enter");
        EFE frank = new EFE();
        frank.iniciar_sesion();
        frank.menu();
    }
}