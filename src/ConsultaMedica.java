public class ConsultaMedica {
    private Doctor d;
    private Paciente p;
    private String fecha, hora;

    public ConsultaMedica(Doctor d, Paciente p, String fecha, String hora) {
        this.d = d;
        this.p = p;
        this.fecha = fecha;
        this.hora = hora;
        d.setPaciente(p);
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public boolean equals(ConsultaMedica c) {
        return c.getDoctor().equals(getDoctor()) && c.getPaciente().equals(getPaciente()) &&
                c.getFecha().equals(getFecha()) && c.getHora().equals(getHora());
     }

    public Doctor getDoctor(){
        return d;
    }

    public Paciente getPaciente() {
        return p;
    }
    public String toString() {
        return "Dr " + d.getNombre() + " atenderá al paciente " + p.getNombre();
    }

}
