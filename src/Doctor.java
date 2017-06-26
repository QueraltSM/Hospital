import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Doctor implements Comparable<Doctor> {
    private int codEmpleado;
    private int nHorasExtras;
    private int nConsulta;
    private String fechaIngreso;
    private String especialidad;
    private String nombre;
    private ArrayList<Paciente> pacientes = new ArrayList();

    public Doctor(String nombre, int codEmpleado, String especialidad, int nConsulta) {
        this.nombre = nombre;
        this.codEmpleado = codEmpleado;
        this.especialidad = especialidad;
        this.nConsulta = nConsulta;
    }

    public Doctor(String nombre, int codEmpleado, int nHorasExtras, String fechaIngreso, String especialidad, int nConsulta) {
        this.nombre = nombre;
        this.codEmpleado = codEmpleado;
        this.nHorasExtras = nHorasExtras;
        this.fechaIngreso = fechaIngreso;
        this.especialidad = especialidad;
        this.nConsulta = nConsulta;
    }

    public void setPaciente(Paciente p) {
        Iterator var2 = this.pacientes.iterator();

        Paciente i;
        do {
            if(!var2.hasNext()) {
                this.pacientes.add(p);
                return;
            }

            i = (Paciente)var2.next();
        } while(!i.equals(p));

    }

    public String toString() {
        return this.nombre;
    }

    public int getCod() {
        return this.codEmpleado;
    }

    public List<Paciente> getPacientesAtendidos() {
        return this.pacientes;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public int compareTo(Doctor d) {
        return Administracion.getOrden() == 0?
            (d.getEspecialidad().compareTo(this.getEspecialidad()) < 0?
             1:(d.getEspecialidad().compareTo(this.getEspecialidad()) > 0?-1:
                (d.toString().compareTo(this.toString()) < 0?1:(d.toString().compareTo(this.toString())
                     > 0?-1:0)))):(Administracion.getOrden() == 1?(d.getCod() < 
                          this.getCod()?1:(d.getCod() == this.getCod()?0:-1)):(Administracion.getOrden() == 
                                2?(d.toString().compareTo(this.toString()) < 0?1:
                                   (d.toString().compareTo(this.toString()) > 0?-1:0)):-2));
    }

    public boolean equals(Doctor d) {
        return d.getCod() == this.getCod();
    }

    public String getNombre() {
        return this.nombre;
    }
}

