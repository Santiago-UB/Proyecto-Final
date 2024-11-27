/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

/**
 *
 * @author Santiago Uribe Burgos 20241220720
 */
public class Vehiculo {
    private String placa;
    private final String marca;
    private final double precio;
    private final int cilindraje;
    private double impuestoCirculacion;
    private double cuotaMesGaraje;
    private static final double CUOTA_DEFAULT = 100.0;

    public Vehiculo(String placa, String marca, double precio, int cilindraje) {
        this.placa = placa;
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.cuotaMesGaraje = CUOTA_DEFAULT;
        calcularImpuestoCirculacion();
    }

    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = precio * 0.02;
    }

    public boolean matricular(String matricula) {
        if (matricula.length() == 6) {
            this.placa = matricula;
            return true;
        }
        return false;
    }

    
    public String getMatricula() { return placa; }
    public void setCuotaMesGaraje(double cuotaMesGaraje) {
        if (cuotaMesGaraje >= 0) this.cuotaMesGaraje = cuotaMesGaraje;
    }
    public double getCuotaMesGaraje() { return cuotaMesGaraje; }
    public double getImpuestoCirculacion() { return impuestoCirculacion; }
    public double getPrecio() { return precio; }
}
