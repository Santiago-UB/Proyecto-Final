/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;
/**
 *
 * @author Santiago Uribe Burgos 20241220720
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RedParqueaderos redParqueaderos = new RedParqueaderos();
        boolean continuar = true;

        while (continuar) {
            System.out.println("==== GESTIÓN DE RED DE PARQUEADEROS ====");
            System.out.println("1. Crear un garaje");
            System.out.println("2. Eliminar un garaje");
            System.out.println("3. Actualizar un garaje");
            System.out.println("4. Ingresar un vehículo a un garaje");
            System.out.println("5. Retirar un vehículo de un garaje");
            System.out.println("6. Informe de ocupación (todos o específico)");
            System.out.println("7. Informe de ocupación por tipo de vehículo");
            System.out.println("8. Informe de recaudo mensual");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el departamento: ");
                        String departamento = scanner.nextLine();
                        System.out.print("Ingrese la ciudad: ");
                        String ciudad = scanner.nextLine();
                        System.out.print("Ingrese la dirección: ");
                        String direccion = scanner.nextLine();
                        System.out.print("Ingrese el teléfono: ");
                        String telefono = scanner.nextLine();
                        System.out.print("Ingrese el email: ");
                        String email = scanner.nextLine();
                        System.out.print("Ingrese el nombre del administrador: ");
                        String administrador = scanner.nextLine();
                        System.out.print("Ingrese el número de espacios: ");
                        int numeroEspacios = scanner.nextInt();
                        scanner.nextLine();

                        Garaje nuevoGaraje = new Garaje(departamento, ciudad, direccion, telefono, email, administrador, numeroEspacios) {
                            public int calcularOcupacionPorTipoVehiculo(Vehiculo v) {
                                throw new UnsupportedOperationException("Not supported yet.");
                            }

                            public int calcularOcupacionPorTipoVehiculo(Object v) {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }
                        };
                        redParqueaderos.agregarGaraje(nuevoGaraje);
                        System.out.println("Garaje creado exitosamente.");
                    }
                    case 2 -> {
                        System.out.print("Ingrese la dirección del garaje a eliminar: ");
                        String direccion = scanner.nextLine();
                        redParqueaderos.eliminarGaraje(direccion);
                        System.out.println("Garaje eliminado exitosamente.");
                    }
                    case 3 -> {
                        System.out.print("Ingrese la dirección del garaje a actualizar: ");
                        String direccion = scanner.nextLine();
                        System.out.print("Ingrese el nuevo teléfono: ");
                        String nuevoTelefono = scanner.nextLine();
                        System.out.print("Ingrese el nuevo email: ");
                        String nuevoEmail = scanner.nextLine();
                        System.out.print("Ingrese el nuevo nombre del administrador: ");
                        String nuevoAdministrador = scanner.nextLine();
                        redParqueaderos.actualizarGaraje(direccion, nuevoTelefono, nuevoEmail, nuevoAdministrador);
                        System.out.println("Garaje actualizado exitosamente.");
                    }
                    case 4 -> {
                        System.out.print("Ingrese la dirección del garaje: ");
                        String direccion = scanner.nextLine();
                        System.out.print("Ingrese el tipo de vehículo (Moto, Auto, Camion): ");
                        String tipoVehiculo = scanner.nextLine();
                        System.out.print("Ingrese la placa: ");
                        String placa = scanner.nextLine();
                        System.out.print("Ingrese la marca: ");
                        String marca = scanner.nextLine();
                        System.out.print("Ingrese el precio: ");
                        double precio = scanner.nextDouble();
                        System.out.print("Ingrese el cilindraje: ");
                        int cilindraje = scanner.nextInt();
                        scanner.nextLine();

                        Vehiculo vehiculo = null;
                        if (tipoVehiculo.equalsIgnoreCase("Moto")) {
                            System.out.print("¿Tiene sidecar? (true/false): ");
                            boolean tieneSidecar = scanner.nextBoolean();
                            scanner.nextLine(); 
                            vehiculo = new Moto(placa, marca, precio, cilindraje, tieneSidecar);
                        } else if (tipoVehiculo.equalsIgnoreCase("Auto")) {
                            System.out.print("¿Tiene radio? (true/false): ");
                            boolean tieneRadio = scanner.nextBoolean();
                            System.out.print("¿Tiene navegador? (true/false): ");
                            boolean tieneNavegador = scanner.nextBoolean();
                            scanner.nextLine();
                            vehiculo = new Auto(placa, marca, precio, cilindraje, tieneRadio, tieneNavegador);
                        } else if (tipoVehiculo.equalsIgnoreCase("Camion")) {
                            System.out.print("Ingrese el número de ejes: ");
                            int numeroEjes = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Ingrese el tipo de camión (Sencillo/Doble): ");
                            String tipoCamion = scanner.nextLine();
                            System.out.print("Ingrese la capacidad de carga en toneladas: ");
                            double capacidadCarga = scanner.nextDouble();
                            scanner.nextLine();
                            vehiculo = new Camion(placa, marca, precio, cilindraje, numeroEjes, tipoCamion, capacidadCarga);
                        }

                        if (vehiculo != null) {
                            redParqueaderos.ingresarVehiculo(direccion, vehiculo);
                            System.out.println("Vehículo ingresado exitosamente.");
                        } else {
                            System.out.println("Tipo de vehículo inválido.");
                        }
                    }
                    case 5 -> {
                        System.out.print("Ingrese la dirección del garaje: ");
                        String direccion = scanner.nextLine();
                        System.out.print("Ingrese la placa del vehículo a retirar: ");
                        String placa = scanner.nextLine();
                        redParqueaderos.retirarVehiculo(direccion, placa);
                        System.out.println("Vehículo retirado exitosamente.");
                    }
                    case 6 -> {
                        System.out.print("¿Desea consultar todos los garajes o uno en particular? (todos/uno): ");
                        String consulta = scanner.nextLine();
                        if (consulta.equalsIgnoreCase("todos")) {
                            redParqueaderos.mostrarOcupacionGeneral();
                        } else {
                            System.out.print("Ingrese la dirección del garaje: ");
                            String direccion = scanner.nextLine();
                            redParqueaderos.mostrarOcupacionPorGaraje(direccion);
                        }
                    }
                    case 7 -> {
                        System.out.print("Ingrese el tipo de vehículo (Moto, Auto, Camion): ");
                        String tipoVehiculo = scanner.nextLine();
                        redParqueaderos.mostrarOcupacionPorTipo(tipoVehiculo);
                    }
                    case 8 -> {
                        redParqueaderos.mostrarRecaudoMensual();
                    }
                    case 9 -> {
                        continuar = false;
                        System.out.println("¡Gracias por usar el sistema!");
                    }
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (GestionParqueaderosException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
