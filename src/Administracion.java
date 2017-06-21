import java.util.*;
public class Administracion {
    private ArrayList<Doctor> doctores = new ArrayList<Doctor>();
    private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

    public Administracion() {}

    public boolean contrataDoctor(Doctor d) {
        if (doctores.contains(d)) return false;
        doctores.add(d);
        return true;
    }

    public boolean registrarPaciente(Paciente p) {
        if (pacientes.contains(p)) return false;
        pacientes.add(p);
        return true;
    }

    /**
     * Método listaDoctores()
     * Lista los datos de los médicos ordenados por especialidad.
     * */

    public List<Doctor> listaDoctores() {
        Collections.sort(doctores);
        return doctores;
    }

    //  Registrar los datos de una cita médica.
    public void registrarCita() {

    }

    // Listar los datos (nombres y apellidos) de los pacientes atendidos por un médico determinado (ingresando su código).
    public void listaPacientes() {

    }




}
