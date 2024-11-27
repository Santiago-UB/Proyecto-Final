/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;
/**
 *
 * @author Santiago Uribe Burgos 20241220720
 */
public class GestionParqueaderosException extends Exception {
    public GestionParqueaderosException(String message) {
        super(message);
    }

    
    public static class CapacidadExcedidaException extends GestionParqueaderosException {
        public CapacidadExcedidaException(String message) {
            super(message);
        }
    }

    
    public static class NumeroMaximoCamionesException extends GestionParqueaderosException {
        public NumeroMaximoCamionesException(String message) {
            super(message);
        }
    }

    
    public static class NumeroMaximoMotosException extends GestionParqueaderosException {
        public NumeroMaximoMotosException(String message) {
            super(message);
        }
    }

    
    public static class VehiculoYaRegistradoException extends GestionParqueaderosException {
        public VehiculoYaRegistradoException(String message) {
            super(message);
        }
    }

    
    public static class VehiculoNoEncontradoException extends GestionParqueaderosException {
        public VehiculoNoEncontradoException(String message) {
            super(message);
        }
    }
}
