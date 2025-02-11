package Empresa;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/*Una empresa tiene que desarrollar un programa para
    el registro de datos de los trabajadores de una compañía.


La empresa tiene varias sedes (Madrid, Barcelona, Valencia y Oviedo)


En cada sede hay varios departamentos (Ventas, RR.HH. y Producción)


De cada empleado hay que almacenar el código de empleado, DNI, nombre,
    primer apellido, segundo apellido, año de nacimiento (numérico) y si tiene concedida,
        o no, la reducción de la jornada (booleano).


Hay que diseñar la estructura que almacenará los datos de la compañía y
    escribir el código que permita comenzar a registrar la información de los empleados*/

public class Principal {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Sede [] sedes = {new Sede("Madrid"),new Sede("Barcelona"),new Sede("Valencia"),new Sede("Oviedo")};
        menuSede(sedes);
    }

    public static void menuSede(Sede [] sedes){
        while(true){
            System.out.println("Bienvenido al sistema. Seleccione el número de la sede quiere entrar");
            System.out.println("1.Madrid   2.Barcelona   3.Valencia   4.Oviedo   0.Salir");
            System.out.println("=========================================================");
            int num = sc.nextInt();
            switch (num){
                case 1:
                    menuDep(sedes[0]);
                    break;
                case 2:
                    menuDep(sedes[1]);
                    break;
                case 3:
                    menuDep(sedes[2]);
                    break;
                case 4:
                    menuDep(sedes[3]);
                    break;
                case 0:
                    System.out.println("Gracias por utilizar el programa");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static void menuDep(Sede sede){
        while(true){
            System.out.println("Has seleccionado la sede de " + sede.getUbicacion());
            System.out.println("Seleccione el número del departamento que quiere entrar");
            System.out.println("1.Ventas   2.RRHH   3.Producción   0.Volver a la selección de sede");
            System.out.println("==================================================================");
            int num = sc.nextInt();
            switch (num){
                case 1:
                    menuEmpleado(sede.getDepartamento()[0]);
                    break;
                case 2:
                    menuEmpleado(sede.getDepartamento()[1]);
                    break;
                case 3:
                    menuEmpleado(sede.getDepartamento()[2]);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static void menuEmpleado(Departamento dep) {

        String DNI,nombreEmpleado,apellidoEmpleado,dosapellidoEmpleado;
        int codigoEmpleado,birthYear;
        boolean reducJornada;

        while (true){
            System.out.println("Seleccione la opción a realizar");
            System.out.println("1.Dar alta empleado   2.Modificar empleado   3.Quitar empleado   4.Ver información de los empleados   0.Salir");
            System.out.println("=============================================================================================================");

            int opcion = sc.nextInt();

            sc.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Has seleccionado dar de alta");
                    System.out.println("Introduzca nuevo código de empleado: ");
                    codigoEmpleado=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduzca DNI de empleado: ");
                    DNI=sc.nextLine().trim();
                    System.out.println("Introduzca nombre de empleado: ");
                    nombreEmpleado=sc.nextLine().trim();
                    System.out.println("Introduzca apellido de empleado: ");
                    apellidoEmpleado=sc.nextLine().trim();
                    System.out.println("Introduzca segundo apellido de empleado: ");
                    dosapellidoEmpleado=sc.nextLine().trim();
                    System.out.println("Introduzca año de nacimiento de empleado: ");
                    birthYear=sc.nextInt();
                    System.out.println("Introduzca si tiene reduccion de jornada:  true\t\tfalse");
                    reducJornada=sc.nextBoolean();
                    boolean bAlta = darAltaEmp(dep,codigoEmpleado, DNI, nombreEmpleado, apellidoEmpleado, dosapellidoEmpleado, birthYear, reducJornada);
                    if(bAlta) {
                        System.out.println("Has agregado al empleado");
                    }
                    else {
                        System.out.println("Ese codigo de empleado ya existe");
                    }
                    break;
                case 2:
                    System.out.println("Has seleccionado modificar");
                    System.out.println("Introduzca el código de empleado a modificar: ");
                    codigoEmpleado=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduzca DNI del nuevo empleado: ");
                    DNI=sc.nextLine().trim();
                    System.out.println("Introduzca nombre del nuevo empleado: ");
                    nombreEmpleado=sc.nextLine().trim();
                    System.out.println("Introduzca apellido del nuevo empleado: ");
                    apellidoEmpleado=sc.nextLine().trim();
                    System.out.println("Introduzca segundo apellido del nuevo empleado: ");
                    dosapellidoEmpleado=sc.nextLine().trim();
                    System.out.println("Introduzca año de nacimiento del nuevo empleado: ");
                    birthYear=sc.nextInt();
                    System.out.println("Introduzca si tiene reduccion del nuevo jornada:  true\t\tfalse");
                    reducJornada=sc.nextBoolean();
                    boolean b=modificarEmp(dep,codigoEmpleado, DNI, nombreEmpleado, apellidoEmpleado, dosapellidoEmpleado, birthYear, reducJornada);
                    if(b){
                        System.out.println("Modificación exitosa");
                    }
                    else{
                        System.out.println("No se ha podido encontrar al empleado");
                    }
                    break;
                case 3:
                    System.out.println("Has seleccionado quitar empleado");
                    System.out.println("Introduzca el código de empleado a quitar: ");
                    codigoEmpleado=sc.nextInt();
                    boolean quitar = quitarEmp(dep,codigoEmpleado);
                    if(quitar){
                        System.out.println("Has borrado al empleado con éxito");
                    }
                    else{
                        System.out.println("No existe empleado con ese ID");
                    }
                    break;
                case 4:
                    System.out.println("Has seleccionado visualizar a los empleados");
                    visualizarEmpleados(dep);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static boolean darAltaEmp(Departamento dep,int codEmp,String dNI,String nombre, String ape1, String ape2, int birthYear, boolean redJor){
        if(existeEmpleado(dep,codEmp)){
            return false;
        }
        Empleado emp = new Empleado(codEmp,dNI,nombre,ape1,ape2,birthYear,redJor);
        if(dep.getEmpleados().length == 1 && cantEmpleados(dep) == 0){
            dep.setEmpleado(emp);
        }
        else{
            Empleado[] emplea2 = Arrays.copyOf(dep.getEmpleados(), dep.getEmpleados().length + 1);
            emplea2[dep.getEmpleados().length] = emp;
            dep.setEmpleados(emplea2);
        }
        return true;
    }
    public static boolean modificarEmp(Departamento dep,int codEmp,String dNI,String nombre, String ape1, String ape2, int birthYear, boolean redJor){
        if(!existeEmpleado(dep,codEmp)){
            return false;
        }
        else{
            for(Empleado empleado : dep.getEmpleados()){
                if (empleado.getCodEmp() == codEmp) {
                    empleado.setDNI(dNI);
                    empleado.setNombre(nombre);
                    empleado.setApe1(ape1);
                    empleado.setApe2(ape2);
                    empleado.setBirthYear(birthYear);
                    empleado.setRedJor(redJor);
                }
            }
        }
        return true;
    }
    public static boolean quitarEmp(Departamento dep, int codEmp){
        if(!existeEmpleado(dep,codEmp)){
            return false;
        }
        int cont = 0;
        for (Empleado empleado : dep.getEmpleados()) {
            if (empleado.getCodEmp() == codEmp && dep.getEmpleados().length == 1) {
                dep.setEmpleados(new Empleado[1]);
                return true;
            }
            else if(empleado.getCodEmp() == codEmp){
                // 2. Copia hasta la 1
                Empleado [] empQuitar = new Empleado[dep.getEmpleados().length-1];
                System.arraycopy(dep.getEmpleados(),0,empQuitar,0,cont);
                if(dep.getEmpleados().length-1!=cont) {
                    System.arraycopy(dep.getEmpleados(), cont + 1, empQuitar, cont, dep.getEmpleados().length - cont + 1);
                }
                dep.setEmpleados(empQuitar);
                return true;
            }
            cont++;
        }
        return false;
    }
    public static void visualizarEmpleados(Departamento dep){
        if(Objects.isNull(dep.getEmpleados()[0])){
            System.out.println("No existen empleados aquí");
        }
        else {
            for (Empleado empleado : dep.getEmpleados()) {
                    System.out.println(empleado.getCodEmp() + "   " + empleado.getDNI() + "   " + empleado.getNombre() + "   " +
                            empleado.getApe1() + "   " + empleado.getApe2() + "   " + empleado.getBirthYear() + "   " + empleado.isRedJor());
            }
        }
    }
    public static boolean existeEmpleado(Departamento dep, int codEmp){
        if(Objects.isNull(dep.getEmpleados()[0])){
            return false;
        }
        else {
            for (Empleado empleado : dep.getEmpleados()) {
                if (empleado.getCodEmp() == codEmp) {
                    return true;
                }
            }
        }
        return false;
    }
    public static int cantEmpleados(Departamento dep){
        int cont = 0;
        if(Objects.isNull(dep.getEmpleados()[0])){
            return cont;
        }
        for(Empleado empleado : dep.getEmpleados()){
            cont ++;
        }
        return cont;
    }
}
