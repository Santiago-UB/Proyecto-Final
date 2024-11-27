/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

import java.util.ArrayList;

/**
 *
 * @author Santiago Uribe Burgos 20241220720
 */
public abstract class Garaje implements proyecto.pkgfinal.iGarage {

    private final String departamento;
    private final String ciudad;
    private final String direccion;
    private String telefono;
    private String email;
    private String administrador;
    private final int numeroEspacios;
    private static final double PORCENTAJE_MAX_MOTOS = 0.8;
    private static final double PORCENTAJE_MAX_CAMIONES = 0.1;
    private final ArrayList<Vehiculo> espacios;

    public Garaje(String departamento, String ciudad, String direccion, String telefono, String email, String administrador, int numeroEspacios) {
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.administrador = administrador;
        this.numeroEspacios = numeroEspacios;
        this.espacios = new ArrayList<>();
    }

    @Override
    public double calcularIngresos() {
        return espacios.stream().mapToDouble(Vehiculo::getCuotaMesGaraje).sum();
    }

    public int calcularOcupacionPorTipoVehiculo(String tipoVehiculo) {
        return (int) espacios.stream()
                .filter(v -> v.getClass().getSimpleName().equalsIgnoreCase(tipoVehiculo))
                .count();
    }

    public int buscarVehiculoPorMatricula(String matricula) {
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                return i;
            }
        }
        return -1;
    }

    public boolean alquilarEspacio(Vehiculo vehiculo) throws GestionParqueaderosException.NumeroMaximoCamionesException {
        if (espacios.size() >= numeroEspacios) {
            System.out.println("No hay espacios disponibles.");
            return false;
        }

        if (vehiculo instanceof Moto && calcularOcupacionPorTipoVehiculo("Moto") >= PORCENTAJE_MAX_MOTOS * numeroEspacios) {
            System.out.println("No se pueden alquilar más espacios para motos (80% máximo).");
            return false;
        }

        if (vehiculo instanceof Camion && calcularOcupacionPorTipoVehiculo("Camion") >= PORCENTAJE_MAX_CAMIONES * numeroEspacios) {
            throw new GestionParqueaderosException.NumeroMaximoCamionesException("No se pueden alquilar más espacios para camiones (10% máximo).");
        }

        espacios.add(vehiculo);
        return true;
    }

    public boolean retirarVehiculo(String matricula) {
        return espacios.removeIf(v -> v.getMatricula().equalsIgnoreCase(matricula));
    }

    public double calcularRecaudoMensual() {
        return calcularIngresos();
    }

    public void mostrarDetallesVehiculos() {
        espacios.forEach(v -> System.out.println("Matrícula: " + v.getMatricula() +
                ", Cuota: " + v.getCuotaMesGaraje() +
                ", Tipo: " + v.getClass().getSimpleName()));
    }

    public int plazasDisponibles() {
        return numeroEspacios - espacios.size();
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombreAdministrador() {
        return administrador;
    }

    public void setTelefono(String nuevoTelefono) {
        this.telefono = nuevoTelefono;
    }

    public void setEmail(String nuevoEmail) {
        this.email = nuevoEmail;
    }

    public void setNombreAdministrador(String nuevoAdministrador) {
        this.administrador = nuevoAdministrador;
    }

    public int getNumeroEspacios() {
        return numeroEspacios;
    }

    public String calcularOcupacion() {
        double porcentajeOcupacion = (espacios.size() / (double) numeroEspacios) * 100;
        return String.format("%.2f%% ocupados", porcentajeOcupacion);
    }

    public boolean ingresarVehiculo(Vehiculo vehiculo) {
        if (espacios.size() < numeroEspacios) {
            espacios.add(vehiculo);
            return true;
        }
        return false;
    }
}



