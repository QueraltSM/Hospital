public class Doctor implements Comparable<Doctor> {
    private int codEmpleado, nHorasExtras, nConsulta;
    private String fechaIngreso, especialidad, nombre;

    public Doctor(String nombre, int codEmpleado, int nHorasExtras, String fechaIngreso, String especialidad, int nConsulta) {
        this.nombre = nombre;
        this.codEmpleado = codEmpleado;
        this.nHorasExtras = nHorasExtras;
        this.fechaIngreso = fechaIngreso;
        this.especialidad = especialidad;
        this.nConsulta = nConsulta;
    }

    public String toString(){
        return nombre;
    }


    public String getEspecialidad() {
        return especialidad;
    }


    /**
     * Método compareTo(Doctor d)
     * Orden en función de especialdiad. En caso de ser la misma, alfabéticamente.
     *
     * */

    public int compareTo(Doctor d){
        if (d.getEspecialidad().compareTo(getEspecialidad())<0) {
            return 1;
        } else if (d.getEspecialidad().compareTo(getEspecialidad())>0) {
            return -1;
        }
        if (d.toString().compareTo(toString()) < 0) {
            return 1;
        } else if (d.toString().compareTo(toString()) > 0) {
            return -1;
        }
        return 0;
    }


}
