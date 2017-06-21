public class ConsultaMedica {
    private Doctor d;
    private Paciente p;
    private String fecha, hora, lugar;

    public ConsultaMedica(Doctor d, Paciente p, String fecha, String hora, String lugar) {
        this.d = d;
        this.p = p;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }
}
