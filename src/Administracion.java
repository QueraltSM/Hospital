import java.util.*;
public class Administracion {
    private ArrayList<Doctor> doctores = new ArrayList<Doctor>();
    private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    private ArrayList<ConsultaMedica> consultas = new ArrayList<>();

    public Administracion() {}

    public boolean contrataDoctor(Doctor d) {
        for (Doctor i : doctores) {
            if (i.equals(d)) return false;
        }

        doctores.add(d);
        return true;
    }

    public boolean registrarPaciente(Paciente p) {
        for (Paciente i : pacientes) {
            if (i.equals(p)) return false;
        }

        pacientes.add(p);
        return true;
    }



    public List<Doctor> listaDoctores() {
        Collections.sort(doctores);
        return doctores;
    }


    public boolean registrarCita(Doctor d, Paciente p, String fecha, String hora) {
        for (ConsultaMedica i : consultas) {
            if (i.equals(new ConsultaMedica(d, p, fecha, hora))) return false;
        }

        if (check(d, p)) { // comprobamos que el doctor esté contratado y el paciente registrado
            consultas.add(new ConsultaMedica(d, p, fecha, hora));
            return true;
        }

        return false;
    }

    private boolean check(Doctor d, Paciente p) {
        boolean r1 =  false;
        boolean r2 = false;

        for (Doctor i : doctores) {
            if (i.equals(d)) r1 = true;
        }

        for (Paciente i : pacientes) {
            if (i.equals(p)) r2 = true;
        }

        if (r1 && r2) return true;
        return false;
    }


    public List<String> listaPacientes(int codDoctor) {
        List<String> res = new LinkedList<>();
        for (ConsultaMedica i : consultas) {
            if (i.getDoctor().getCod() == codDoctor) {
                for (Paciente j : i.getDoctor().getPacientesAtendidos()) {
                    res.add(j.toString());
                }
            }
        }
        return res;
    }
}
