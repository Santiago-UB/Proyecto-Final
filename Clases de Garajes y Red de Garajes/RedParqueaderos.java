/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

import proyecto.pkgfinal.Garaje;
import proyecto.pkgfinal.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Uribe Burgos 20241220720
 */
public class RedParqueaderos {
    private final List<Garaje> garajes;

    public RedParqueaderos() {
        this.garajes = new ArrayList<>();
    }

   
    public void agregarGaraje(Garaje garaje) {
        garajes.add(garaje);
    }

   
    public boolean eliminarGaraje(String nombreAdministrador) {
        return garajes.removeIf(g -> g.getNombreAdministrador().equals(nombreAdministrador));
    }

   
    public Garaje buscarGarajePorAdministrador(String nombreAdministrador) {
        return garajes.stream()
                .filter(g -> g.getNombreAdministrador().equals(nombreAdministrador))
                .findFirst()
                .orElse(null);
    }

  
    public void actualizarGaraje(String direccion, String nuevoTelefono, String nuevoEmail, String nuevoAdministrador) {
        Garaje garaje = garajes.stream()
                .filter(g -> g.getDireccion().equals(direccion))
                .findFirst()
                .orElse(null);

        if (garaje != null) {
            garaje.setTelefono(nuevoTelefono);
            garaje.setEmail(nuevoEmail);
            garaje.setNombreAdministrador(nuevoAdministrador);
        } else {
            System.out.println("Garaje no encontrado con la dirección: " + direccion);
        }
    }

    
    public void retirarVehiculo(String direccion, String placa) {
        Garaje garaje = garajes.stream()
                .filter(g -> g.getDireccion().equals(direccion))
                .findFirst()
                .orElse(null);

        if (garaje != null) {
            if (garaje.retirarVehiculo(placa)) {
                System.out.println("Vehículo con placa " + placa + " retirado exitosamente.");
            } else {
                System.out.println("Vehículo con placa " + placa + " no encontrado en el garaje.");
            }
        } else {
            System.out.println("Garaje no encontrado en la dirección: " + direccion);
        }
    }

    
    public void mostrarOcupacionGeneral() {
        for (Garaje garaje : garajes) {
            System.out.println("Garaje en " + garaje.getDireccion());
            System.out.println("Ocupación: " + garaje.calcularOcupacion() + "/" + garaje.getNumeroEspacios());
        }
    }

    
    public void mostrarOcupacionPorGaraje(String direccion) {
        Garaje garaje = garajes.stream()
                .filter(g -> g.getDireccion().equals(direccion))
                .findFirst()
                .orElse(null);

        if (garaje != null) {
            System.out.println("Garaje en " + direccion);
            System.out.println("Ocupación: " + garaje.calcularOcupacion() + "/" + garaje.getNumeroEspacios());
        } else {
            System.out.println("Garaje no encontrado en la dirección: " + direccion);
        }
    }

    
    public void mostrarOcupacionPorTipo(String tipoVehiculo) {
        for (Garaje garaje : garajes) {
            int ocupacionPorTipo = garaje.calcularOcupacionPorTipoVehiculo(tipoVehiculo);
            System.out.println("Garaje en " + garaje.getDireccion() + " tiene " + ocupacionPorTipo + " vehículos tipo " + tipoVehiculo);
        }
    }

    
    public void mostrarRecaudoMensual() {
    double totalRecaudo = 0;
    for (Garaje garaje : garajes) { 
        totalRecaudo += garaje.calcularRecaudoMensual(); 
    }
    System.out.println("Recaudo mensual total: $" + String.format("%.2f", totalRecaudo)); 
}


    
    public void ingresarVehiculo(String direccion, Vehiculo vehiculo) {
        Garaje garaje = garajes.stream()
                .filter(g -> g.getDireccion().equals(direccion))
                .findFirst()
                .orElse(null);

        if (garaje != null) {
            if (garaje.ingresarVehiculo(vehiculo)) {
                System.out.println("Vehículo ingresado exitosamente en el garaje de " + direccion);
            } else {
                System.out.println("No hay espacio disponible en el garaje de " + direccion);
            }
        } else {
            System.out.println("Garaje no encontrado en la dirección: " + direccion);
        }
    }
}

