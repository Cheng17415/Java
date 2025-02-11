package Empresa;
import java.util.Arrays;

public class Sede {
    private String ubicacion;
    private Departamento[] departamento = new Departamento[3];

    public Sede(String ubicacion) {
        this.ubicacion = ubicacion;
        // Initialize each Departamento in the array
        departamento[0] = new Departamento("Ventas");
        departamento[1] = new Departamento("RRHH");
        departamento[2] = new Departamento("Producción");
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Departamento[] getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Sede{" +
                "ubicacion='" + ubicacion + '\'' +
                ", departamento=" + Arrays.toString(departamento) +
                '}';
    }
}