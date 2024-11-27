/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

/**
 *
 * @author Santiago Uribe Burgos 20241220720
 */
public final class Auto extends Vehiculo {
    private final boolean tieneRadio;
    private final boolean tieneNavegador;

    
    public Auto(String placa, String marca, double precio, int cilindraje, boolean tieneRadio, boolean tieneNavegador) {
        super(placa, marca, precio, cilindraje); 
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;

        
        if (cilindraje > 2499) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.2);
        }
        
        
        calcularImpuestoCirculacion();
    }

    @Override
    public void calcularImpuestoCirculacion() {
        double impuestoBase = getPrecio() * 0.02; 

        
        if (tieneRadio) {
            impuestoBase += getPrecio() * 0.01;
        }
        if (tieneNavegador) {
            impuestoBase += getPrecio() * 0.02;
        }

        
        setCuotaMesGaraje(impuestoBase);
    }
}

