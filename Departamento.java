package Empresa;
/*En cada sede hay varios departamentos (Ventas, RR.HH. y Producción) */

import java.util.Arrays;

public class Departamento {
    private String nombre;
    private Empleado [] empleados = new Empleado[1];

    public Departamento(String nombre){
        this.nombre = nombre;
    }
    public Departamento(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public void setEmpleado(Empleado empleado) {
        empleados[0] = empleado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Departamento: ").append(nombre).append("\n");
        sb.append("Empleados:\n");
        for (Empleado emp : empleados) {
            if (emp != null) {
                sb.append(emp.toString()).append("\n");
            }
        }
        return sb.toString();
    }


}

