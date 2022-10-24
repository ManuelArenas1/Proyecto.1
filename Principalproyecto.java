package visualStudio;
/*Fundamentos de programacion
 * Proyecto 1
 * Miguel Angel Montoya, Manuel Arenas 
 */

import java.util.Scanner;

public class Principalproyecto {
    // los metodos creados aca son utilizados para la resolucion de los puntos 4 y 5
    // y 9

    public static String getVehiculosVerdes() {

        String texto = "Estos son los vehiculos con color verde: " + "\n";
        int vehiverdes = 1;
        for (int num = 0; num < Vehiculo.posAnadir; num++) {
            if (Vehiculo.vehiculos[num].getColor().equalsIgnoreCase("verde")) {
                texto = texto + vehiverdes + Vehiculo.vehiculos[num].toString() + "\n";
                vehiverdes++;
            }
        }
        return texto;
    }

    public static String getModeloAnos2000A2021() {
        String texto = "Estos son los vehiculos que estan entre los años 2000 y 2021: " + "\n";
        int vehiculos = 1;
        for (int num = 0; num < Vehiculo.posAnadir; num++) {
            if (Vehiculo.vehiculos[num].getModelo() >= 2000 && Vehiculo.vehiculos[num].getModelo() <= 2021) {
                texto = texto + vehiculos + Vehiculo.vehiculos[num].toString() + "\n";
                vehiculos++;
            }
        }
        return texto;
    }

    public static String getSensoresTemperatura() {
        String texto = "Estos son los sensores de tipo temperatura: " + "\n";
        int Sensorestemp = 1;
        for (int num = 0; num < Sensor.posAnadir; num++) {
            if (Sensor.sensores[num].getTipo().equalsIgnoreCase("temperatura")) {
                texto = texto + Sensorestemp + Sensor.sensores[num].toString() + "\n";
                Sensorestemp++;
            }
        }
        return texto;
    }

    public static void main(String[] args) {

        mostrarmenu();
    }

    public static void mostrarmenu() {

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("ingrese un numero del 0 al 9 ó el 666");
            boolean continuamos = true;
            int numero = scan.nextInt();

            if (numero == 0) {
                System.out.println("No habilitaste nuestro programa esta vez. Estaremos para ti cunado nos necesites");
                continuamos = false;
            }
            while (continuamos) {
                if (numero == 0) {
                    System.out.println("Has cerrado el programa, gracias por usarnos");
                    continuamos = false;
                    break;
                } else if (numero == 1) {
                    if (Vehiculo.posAnadir < Vehiculo.tamaño) {
                        System.out.println("Ingrese el modelo: ");
                        int mo = scan.nextInt();
                        System.out.println("Ingrese la marca del vehiculo: ");
                        String ma = scan.next();
                        System.out.println("Ingrese el valor comercial: ");
                        double va = scan.nextDouble();
                        System.out.println("Ingrese el color: ");
                        String col = scan.next();
                        Vehiculo vehiculo = new Vehiculo(mo, ma, va, col);
                        vehiculo.GenaraciondeListaVehiculos(vehiculo);
                    }

                    else {
                        System.out.println("Error base de datos llena.");
                    }
                } else if (numero == 2) {
                    System.out.println(Vehiculo.toStringVehiculos());
                } else if (numero == 3) {
                    System.out.println(
                            "Los vehiculos registrados hasta el momento es: " + "\n" + Vehiculo.CantidadDeVehiculos());
                } else if (numero == 4) {
                    System.out.println(Principalproyecto.getVehiculosVerdes()); // se invocan los metodos creados en la
                                                                                // clase principal

                } else if (numero == 5) {
                    System.out.println(Principalproyecto.getModeloAnos2000A2021()); // se invoncan los metodos creados
                                                                                    // en la clase principal
                } else if (numero == 6) {
                    if (Sensor.posAnadir < Sensor.tamaño) {
                        System.out.println("Ingrese el tipo: ");
                        String tipo = scan.next();
                        System.out.println("Ingrese el valor comercial: ");
                        double valor = scan.nextDouble();
                        Sensor sensor = new Sensor(tipo, valor);
                        sensor.GenaraciondeListaSensores(sensor);
                    } else {
                        System.out.println("Error base de datos llena");
                    }
                } else if (numero == 7) {
                    System.out.println(Sensor.toStringSensores());
                } else if (numero == 8) {
                    System.out.println(
                            "Los sensores registrados hasta el momento son: " + "\n" + Sensor.CantidadSensores());
                } else if (numero == 9) {
                    System.out.println(Principalproyecto.getSensoresTemperatura());
                } else if (numero == 666) {
                    Sensor[] sensor = Sensor.Sensorestemperaturaordenados();
                    System.out.println(Sensor.toStringListaSensores(sensor));
                }

                System.out.println("con que numero deseas continuar?");
                numero = scan.nextInt();

            }
        }
    }
}
