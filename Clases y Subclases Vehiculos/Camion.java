/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

import proyecto.pkgfinal.GestionParqueaderosException.NumeroMaximoCamionesException;

/**
 *
 * @author Santiago Uribe Burgos 20241220720
 */
public final class Camion extends Vehiculo {
    private int numeroEjes;
    private String tipoCamion;  
    private final double capacidadCarga;

    public Camion(String placa, String marca, double precio, int cilindraje, int numeroEjes, String tipoCamion, double capacidadCarga) throws NumeroMaximoCamionesException {
        super(placa, marca, precio, cilindraje);
        this.capacidadCarga = capacidadCarga;
        
        
        if ("Sencillo".equals(tipoCamion) && numeroEjes == 2) {
            this.tipoCamion = tipoCamion;
            this.numeroEjes = numeroEjes;
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.75);
        } else if ("Doble".equals(tipoCamion) && numeroEjes >= 3 && numeroEjes <= 6) {
            this.tipoCamion = tipoCamion;
            this.numeroEjes = numeroEjes;
            setCuotaMesGaraje(getCuotaMesGaraje() * 2.25);
        } else {
            throw new IllegalArgumentException("Configuración de camión no válida");
        }

        
        calcularImpuestoCirculacion();
        double impuestoBase = getPrecio() * 0.09;
        impuestoBase += (10 * (int) (capacidadCarga / 5));
        this.setCuotaMesGaraje(impuestoBase);
    }

    
    public String getTipoCamion() {
        return this.tipoCamion;
    }

    public class Main {
        public static void main(String[] args) {
            try {
                
                Camion camion1 = new Camion("ABC123", "Volvo", 200000.00, 5000, 2, "Sencillo", 15);
                System.out.println("Tipo de camión: " + camion1.getTipoCamion()); 

                Camion camion2 = new Camion("XYZ789", "Mercedes", 300000.00, 7000, 4, "Doble", 25);
                System.out.println("Tipo de camión: " + camion2.getTipoCamion()); 
            } catch (NumeroMaximoCamionesException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

