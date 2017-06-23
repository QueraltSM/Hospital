public class Paciente {
    private String dni, nombreApellidos;

    public Paciente(String dni, String nombreApellidos) {
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
    }

    public String getDni() {
        return dni;
    }

    public boolean equals(Paciente p) {
        return p.getDni().equals(getDni());
    }

    public String toString() {
        return nombreApellidos;
    }

    public String getNombre() {
        return nombreApellidos;
    }
}
