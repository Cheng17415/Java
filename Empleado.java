package Empresa;

/*De cada empleado hay que almacenar el código de empleado, DNI, nombre,
    primer apellido, segundo apellido, año de nacimiento (numérico) y si tiene concedida,
        o no, la reducción de la jornada (booleano).*/
public class Empleado {
    private int codEmp;
    private String dNI;
    private String nombre;
    private String ape1;
    private String ape2;
    private int birthYear;
    private boolean redJor;

    public Empleado(int codEmp, String dNI, String nombre, String ape1, String ape2, int birthYear, boolean redJor) {
        this.codEmp = codEmp;
        this.dNI = dNI;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.birthYear = birthYear;
        this.redJor = redJor;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public String getDNI() {
        return dNI;
    }

    public void setDNI(String dNI) {
        this.dNI = dNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String apel1) {
        this.ape1 = apel1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public boolean isRedJor() {
        return redJor;
    }

    public void setRedJor(boolean redJor) {
        this.redJor = redJor;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codEmp=" + codEmp +
                ", dNI='" + dNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apel1='" + ape1 + '\'' +
                ", ape2='" + ape2 + '\'' +
                ", birthYear=" + birthYear +
                ", redJor=" + redJor +
                '}';
    }
}
