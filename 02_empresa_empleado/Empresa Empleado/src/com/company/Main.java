package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcion;

        List<Empresa> empresas = new LinkedList<>();

        do {
            System.out.println("1.Crear nueva empresa.\n" +
                    "2.Añadir empleado a empresa ya existente.\n" +
                    "3.Listado de empresas.\n" +
                    "4.Listado detallado de empresas y empleados.\n" +
                    "5.Salir");
            System.out.print("Escribe: ");
            opcion = Integer.parseInt(br.readLine());


            switch (opcion) {
                case 1:
                    System.out.print("Introduzca el nombre de la empresa: ");
                    String nombreEmpresa = br.readLine();
                    System.out.print("Introduzca el año de creacion de la empresa: ");
                    String anyoCreacion = br.readLine();

                    Empresa e = new Empresa(nombreEmpresa, anyoCreacion);
                    empresas.add(e);
                    break;
                case 2:
                    System.out.println("Selecciona empresa: ");
                    for (int i = 0; i < empresas.size(); i++) {
                        System.out.println(i + " " + empresas.get(i).getNombre());
                    }
                    System.out.println("Numero: ");
                    int seleccion = Integer.parseInt(br.readLine());

                    //Crear empleado

                    System.out.println("Nombre: ");
                    String nombre = br.readLine();
                    System.out.println("Apellidos: ");
                    String apellidos = br.readLine();
                    System.out.println("Fecha de nacimiento: ");
                    String fechaNac = br.readLine();
                    System.out.println("Fecha de contratacion: ");
                    String fechaCon = br.readLine();

                    Empresa empresaSeleccionada = empresas.get(seleccion);

                    Empleado emp = new Empleado(nombre, apellidos, fechaNac, fechaCon);

                    empresaSeleccionada.getEmpleados().add(emp); // 1
                    emp.setEmpresa(empresaSeleccionada);         // 2

                    break;
                case 3:
                    // Listado de empresas

                    for (Empresa ee : empresas) {
                        System.out.println(ee);
                    }

                    break;
                case 4:
                    // Listado detallado de empresas y empleados

                    for (Empresa ee : empresas) {
                        System.out.println(ee);
                        for (Empleado em : ee.getEmpleados()) {
                            System.out.println(em);
                        }
                    }

                    break;
                case 5:
                    System.out.println("Fin");
                    break;
                default:
                    System.out.println("ERROR: De 1 a 5, plis...");
                    break;

            }


        } while (opcion != 5);


    }
}
