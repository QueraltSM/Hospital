import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Administracion {
    private ArrayList<Doctor> doctores = new ArrayList();
    private ArrayList<Paciente> pacientes = new ArrayList();
    private ArrayList<ConsultaMedica> consultas = new ArrayList();
    private static int ordered;

    public Administracion() {
    }

    public Paciente getPaciente(String nombre) {
        Iterator var2 = this.pacientes.iterator();

        Paciente i;
        do {
            if(!var2.hasNext()) {
                return null;
            }

            i = (Paciente)var2.next();
        } while(!i.getNombre().equals(nombre));

        return i;
    }

    public boolean contrataDoctor(Doctor d) {
        Iterator var2 = this.doctores.iterator();

        Doctor i;
        do {
            if(!var2.hasNext()) {
                this.doctores.add(d);
                return true;
            }

            i = (Doctor)var2.next();
        } while(!i.equals(d));

        return false;
    }

    public boolean registrarPaciente(Paciente p) {
        Iterator var2 = this.pacientes.iterator();

        Paciente i;
        do {
            if(!var2.hasNext()) {
                this.pacientes.add(p);
                return true;
            }

            i = (Paciente)var2.next();
        } while(!i.equals(p));

        return false;
    }

    public List<Doctor> listaDoctores() {
        Collections.sort(this.doctores);
        return this.doctores;
    }

    public List<Paciente> listaPacientes() {
        Collections.sort(this.pacientes);
        return this.pacientes;
    }

    public String getTodosDoctores() {
        String result = "";

        Doctor i;
        for(Iterator var2 = this.listaDoctores().iterator(); var2.hasNext(); result = result + i.toString() + "\n") {
            i = (Doctor)var2.next();
        }

        return result;
    }

    public String getTodosPacientes() {
        String result = "";

        Paciente i;
        for(Iterator var2 = this.listaPacientes().iterator(); var2.hasNext(); result = result + i.toString() + "\n") {
            i = (Paciente)var2.next();
        }

        return result;
    }

    public boolean registrarCita(Doctor d, Paciente p, String fecha, String hora) {
        Iterator var5 = this.consultas.iterator();

        ConsultaMedica i;
        do {
            if(!var5.hasNext()) {
                if(this.check(d, p)) {
                    this.consultas.add(new ConsultaMedica(d, p, fecha, hora));
                    return true;
                }

                return false;
            }

            i = (ConsultaMedica)var5.next();
        } while(!i.equals(new ConsultaMedica(d, p, fecha, hora)));

        return false;
    }

    private boolean check(Doctor d, Paciente p) {
        boolean r1 = false;
        boolean r2 = false;
        Iterator var5 = this.doctores.iterator();

        while(var5.hasNext()) {
            Doctor i = (Doctor)var5.next();
            if(i.equals(d)) {
                r1 = true;
            }
        }

        var5 = this.pacientes.iterator();

        while(var5.hasNext()) {
            Paciente i1 = (Paciente)var5.next();
            if(i1.equals(p)) {
                r2 = true;
            }
        }

        if(r1 && r2) {
            return true;
        } else {
            return false;
        }
    }

    public List<Doctor> getDoctoresMasPacientes() {
        LinkedList result = new LinkedList();
        this.setDoctoresOrdenados(2);
        Collections.sort(this.doctores);
        TreeMap mapa = new TreeMap();
        ArrayList num = new ArrayList();
        Iterator var4 = this.consultas.iterator();

        while(var4.hasNext()) {
            ConsultaMedica j = (ConsultaMedica)var4.next();
            if(mapa.get(j.getDoctor()) == null) {
                mapa.put(j.getDoctor(), Integer.valueOf(1));
            } else {
                mapa.put(j.getDoctor(), Integer.valueOf(((Integer)mapa.get(j.getDoctor())).intValue() + 1));
            }
        }

        var4 = mapa.entrySet().iterator();

        while(var4.hasNext()) {
            Entry j1 = (Entry)var4.next();
            num.add(j1.getValue());
        }

        Collections.sort(num);
        Collections.reverse(num);
        var4 = num.iterator();

        while(var4.hasNext()) {
            Integer j2 = (Integer)var4.next();
            Iterator var6 = mapa.entrySet().iterator();

            while(var6.hasNext()) {
                Entry entry2 = (Entry)var6.next();
                if(j2.equals(entry2.getValue()) && !result.contains(entry2.getKey())) {
                    result.add(entry2.getKey());
                }
            }
        }

        return result;
    }

    public static int getOrden() {
        return ordered;
    }

    public void setDoctoresOrdenados(int orden) {
        ordered = orden;
    }

    public String getDoctoresOrdenados() {
        Collections.sort(this.doctores);
        String result = "";

        Doctor i;
        for(Iterator var2 = this.listaDoctores().iterator(); var2.hasNext(); result = result + i.toString() + "\n") {
            i = (Doctor)var2.next();
        }

        return result;
    }

    public String listaPacientes(int codDoctor) {
        String res = "";
        Iterator var3 = this.consultas.iterator();

        while(true) {
            ConsultaMedica i;
            do {
                if(!var3.hasNext()) {
                    return res;
                }

                i = (ConsultaMedica)var3.next();
            } while(i.getDoctor().getCod() != codDoctor);

            Paciente j;
            for(Iterator var5 = i.getDoctor().getPacientesAtendidos().iterator(); var5.hasNext(); res = res + j.toString()) {
                j = (Paciente)var5.next();
            }
        }
    }
}
