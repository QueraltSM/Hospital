public class ConsultaMedica {
    private Doctor d;
    private Paciente p;
    private String fecha;
    private String hora;

    public ConsultaMedica(Doctor d, Paciente p, String fecha, String hora) {
        this.d = d;
        this.p = p;
        this.fecha = fecha;
        this.hora = hora;
        d.setPaciente(p);
        p.setConsulta(d, fecha, hora);
    }

    public String getFecha() {
        return this.fecha;
    }

    public String getHora() {
        return this.hora;
    }

    public boolean equals(ConsultaMedica c) {
        return c.getFecha().equals(this.getFecha()) && c.getHora().equals(this.getHora());
    }

    public Doctor getDoctor() {
        return this.d;
    }

    public Paciente getPaciente() {
        return this.p;
    }

    public String toString() {
        return "Dr " + this.d.getNombre() + " atenderá al paciente " + this.p.getNombre();
    }
}
