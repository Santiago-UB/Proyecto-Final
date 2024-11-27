/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

/**
 *
 * @author Santiago Uribe Burgos 20241220720
 */
public final class Moto extends proyecto.pkgfinal.Vehiculo {
    private final boolean tieneSidecar;

    public Moto(String placa, String marca, double precio, int cilindraje, boolean tieneSidecar) {
        super(placa, marca, precio, cilindraje);
        this.tieneSidecar = tieneSidecar;
        if (tieneSidecar) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.5);
            calcularImpuestoCirculacion();
        }
    }

    @Override
    public void calcularImpuestoCirculacion() {
        double impuestoBase = getPrecio() * 0.02;
        if (tieneSidecar) impuestoBase *= 1.1;
        super.setCuotaMesGaraje(impuestoBase);
    }
}