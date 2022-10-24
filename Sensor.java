package visualStudio;

import java.util.ArrayList;

public class Sensor {

    public static Sensor[] sensores = new Sensor[8];
    public static int tamaño = 8;
    public static int posAnadir = 0;

    private String tipo;
    private double valor;

    // instanciamos los setters

    public void setTipo(String tip) {
        this.tipo = tip;
    }

    public void setValor(double val) {
        this.valor = val;
    }

    public void setTamaño(int tam) {
        tamaño = tam;
    }

    public void setSensores(Sensor[] sensores) {
        Sensor.sensores = sensores;
    }

    public void setPosAnadir(int PosA) {
        posAnadir = PosA;
    }

    // luego instanciamos los getters

    public String getTipo() {
        return this.tipo;
    }

    public double getValor() {
        return this.valor;
    }

    public int getTamaño() {
        return tamaño;
    }

    public static Sensor[] getSensores() {
        return sensores;
    }

    public int getPosAnadir() {
        return posAnadir;
    }

    public Sensor() {

    }

    public Sensor(String t, double v) {
        this.tipo = t;
        this.valor = v;

    }

    public String toString() {
        return "| Su Sensor de tipo: " + tipo + " y de un valor de: " + valor + "|";
    }

    public static String toStringSensores() {
        String texto = "Datos de los sensores guardados hasta el momento: " + "\n";

        for (int num = 0, posSen = 1; num < Sensor.posAnadir; num++, posSen++) {
            texto = texto + posSen + Sensor.sensores[num].toString() + "\n";

        }
        return texto;
    }

    public static int CantidadSensores() {
        return posAnadir;
    }

    public void GenaraciondeListaSensores(Sensor s) {
        sensores[posAnadir] = s;
        posAnadir++;
    }

    public static Sensor[] Sensorestemperaturaordenados() {
        ArrayList<Sensor> Senstemp = new ArrayList<>();
        for (int num = 0; num < posAnadir; num++) {
            if (sensores[num].getTipo().equalsIgnoreCase("temperatura")) {
                Senstemp.add(sensores[num]);
            }
        }
        Sensor[] convertidorsensores = new Sensor[Senstemp.size()];
        for (int num = 0; num < convertidorsensores.length; num++) {
            convertidorsensores[num] = Senstemp.get(num);

        }
        for (int num = 0; num < convertidorsensores.length; num++) {
            for (int num2 = 0; num2 < convertidorsensores.length - 1; num2++) {
                if (convertidorsensores[num2].getValor() > convertidorsensores[num2 + 1].getValor()) {
                    Sensor sen = convertidorsensores[num2];
                    convertidorsensores[num2] = convertidorsensores[num2 + 1];
                    convertidorsensores[num2 + 1] = sen;
                }
            }

        }
        return convertidorsensores;
    }

    public static String toStringListaSensores(Sensor s[]) {
        int posSensor = 1;
        String texto = "Listado de Sensores tipo temperatura ordenados por valor" + "\n";
        for (int num = 0; num < s.length; num++) {
            texto = texto + posSensor + s[num].toString() + "\n";
            posSensor++;
        }
        return texto;
    }

}
