import coversor.alura.operaciones.Api;
import coversor.alura.operaciones.ConversorMoneda;
import coversor.alura.operaciones.HistoialConversor;
import coversor.alura.operaciones.Operacion;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MenuPrincipal {

            public static final String USD = "USD";
            public static final String ARS = "ARS";
            public static final String COP = "COP";
            public static final String BRL = "BRL";
            public static final String CLP = "CLP";

            public static void main(String[] args) throws IOException, InterruptedException {
                Scanner teclado = new Scanner(System.in);
                Api manager = new Api();
                ConversorMoneda conversor = new ConversorMoneda();
                HistoialConversor conversiones = new HistoialConversor();
                Map<Integer, String[]> monedas = new HashMap<Integer, String[]>();
                monedas.put(1, new String[] { USD, ARS });
                monedas.put(2, new String[] { ARS, USD });
                monedas.put(3, new String[] { USD, BRL });
                monedas.put(4, new String[] { BRL, USD });
                monedas.put(5, new String[] { USD, COP });
                monedas.put(6, new String[] { COP, USD });
                monedas.put(7, new String[] { USD, CLP });
                monedas.put(8, new String[] { CLP, USD });

                int opcion = 1;
                while (opcion != 0) {
                    double valorAConvertir;
                    mostrarMensaje("*********************************");
                    mostrarMensaje("¡Bienvenido al conversor de monedas!\n" + "1) Dólar a peso argentino\n"
                            + "2) Peso argentino a dólar\n" + "3) Dólar a real brasileño\n" + "4) Real brasileño a dólar\n"
                            + "5) Dólar a peso colombiano\n" + "6) Peso colombiano a dólar\n" + "7) Dólar a peso chileno\n"
                            + "8) Peso chileno a dólar\n" + "9) Ver historial de conversiones\n" + "0) Salir\n"
                            + "Elija una opción valida:");
                    mostrarMensaje("*********************************");
                    opcion = teclado.nextInt();
                    if (monedas.containsKey(opcion)) {
                        mostrarMensaje("Ingresá el valor que deseas convertir:");
                        String[] codigos = monedas.get(opcion);
                        try {
                            valorAConvertir = teclado.nextDouble();
                            var moneda = manager.realizarSolicitud(codigos[0], codigos[1]);
                            double resultado = conversor.convertir(moneda.conversion_rate(), valorAConvertir);
                            mostrarMensaje("El valor " + valorAConvertir + " " + moneda.base_code()
                                    + " corresponde al valor final de: " + resultado + " " + moneda.target_code());
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                            Operacion operacion = new Operacion(valorAConvertir, resultado, moneda.base_code(),
                                    moneda.target_code(), LocalDateTime.now().format(format));
                            conversiones.guardar(operacion);
                        } catch (InputMismatchException e) {
                            System.out.println("Solo se permiten valores decimales con coma");
                            teclado.nextLine();
                        } catch (Exception e) {
                            System.out.println("No fue posible realizar la solicitud");
                        }
                    } else if (opcion == 9) {
                        mostrarMensaje(conversiones.getOperaciones().toString());
                    }
                }
                System.out.println("Saliste. ¡Hasta luego!");

            }

            private static void mostrarMensaje(String mensaje) {
                System.out.println(mensaje);
            }
        }

