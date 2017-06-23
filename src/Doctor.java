import java.util.*;

public class Doctor implements Comparable<Doctor> {
    private int codEmpleado, nHorasExtras, nConsulta;
    private String fechaIngreso, especialidad, nombre;
    private ArrayList<Paciente> pacientes = new ArrayList<>();

    public Doctor(String nombre, int codEmpleado, int nHorasExtras, String fechaIngreso, String especialidad, int nConsulta) {
        this.nombre = nombre;
        this.codEmpleado = codEmpleado;
        this.nHorasExtras = nHorasExtras;
        this.fechaIngreso = fechaIngreso;
        this.especialidad = especialidad;
        this.nConsulta = nConsulta;
    }

    public void setPaciente(Paciente p) {
        if (!pacientes.contains(p)) pacientes.add(p);
    }

    public String toString(){
        return nombre;
    }

    public int getCod() {
        return codEmpleado;
    }


    public List<Paciente> getPacientesAtendidos () {
        return pacientes;
    }

    public String getEspecialidad() {
        return especialidad;
    }


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

    public boolean equals(Doctor d) {
        return d.getCod() == getCod();
    }


    public String getNombre() {
        return nombre;
    }

}
