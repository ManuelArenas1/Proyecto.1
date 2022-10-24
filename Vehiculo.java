package visualStudio;

public class Vehiculo {
    public static int tamaño = 10;
    public static Vehiculo[] vehiculos = new Vehiculo[tamaño];
    public static int posAnadir = 0;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;

    public Vehiculo() {
    }

    public Vehiculo(int mo, String ma, double va) {
        this(mo, ma, va, "verde");
    }

    public Vehiculo(int mo, String ma, double va, String col) {
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = col;
    }

    // instanciamos los setters
    public void setModelo(int mod) {
        this.modelo = mod;
    }

    public void setMarca(String mar) {
        this.marca = mar;
    }

    public void setValorComercial(double vcm) {
        this.valorComercial = vcm;
    }

    public void setColor(String col) {
        this.color = col;
    }

    public void setPosAnadir(int pa) {
        posAnadir = posAnadir + pa;
    }

    public void setTamaño(int t) {
        tamaño = t;
    }

    // instanciamos los getters

    public int getModelo() {
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public double getValorComercial() {
        return this.valorComercial;
    }

    public String getColor() {
        return this.color;
    }

    public int getTamaño() {
        return tamaño;
    }

    public int getPosAnadir() {
        return posAnadir;
    }

    // realizamos lo siguiente para que nos devuelva la cantidad de vehiculos
    public static int CantidadDeVehiculos() {
        return posAnadir;
    }

    public static String toStringVehiculos() {
        String texto = "Datos de todos los vehiculos guardados" + "\n";
        int posVe = 1;
        for (int num = 0; num < Vehiculo.posAnadir; num++) {
            texto = texto + posVe + vehiculos[num].toString() + "\n";
            posVe++;
        }
        return texto;
    }

    // realizamos el toString el cual nos devuelve los valores internos del carro
    @Override
    public String toString() {
        return "| Vehiculo de modelo: " + modelo + ", marca: " + marca + ", valor comercial: " + valorComercial
                + ", color: " + color + "|" + "\n ";
    }

    public void GenaraciondeListaVehiculos(Vehiculo v) {
        vehiculos[posAnadir] = v;
        posAnadir++;
    }

}
