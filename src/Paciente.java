import java.util.ArrayList;
import java.util.Iterator;

public class Paciente implements Comparable<Paciente> {
    private String dni;
    private String nombreApellidos;
    private ArrayList<String> consultas = new ArrayList();

    public Paciente(String dni, String nombreApellidos) {
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
    }

    public String getDni() {
        return this.dni;
    }

    public boolean equals(Paciente p) {
        return p.getDni().equals(this.getDni());
    }

    public String toString() {
        return this.nombreApellidos;
    }

    public String getNombre() {
        return this.nombreApellidos;
    }

    public int compareTo(Paciente p) {
        return p.getNombre().compareTo(this.getNombre()) < 0?1:(p.getNombre().compareTo(this.getNombre()) == 0?0:-1);
    }

    public void setConsulta(Doctor d, String fecha, String hora) {
        Iterator var4 = this.consultas.iterator();

        String i;
        do {
            if(!var4.hasNext()) {
                this.consultas.add("Consulta médica con " + d + "\n" + fecha + " " + hora + "\n");
                return;
            }

            i = (String)var4.next();
        } while(!i.equals("Consulta médica con " + d + "\n" + fecha + " " + hora + "\n"));

    }

    public String getHistorial() {
        String res = "";

        String i;
        for(Iterator var2 = this.consultas.iterator(); var2.hasNext(); res = res + i + "\n") {
            i = (String)var2.next();
        }

        return res;
    }
}
