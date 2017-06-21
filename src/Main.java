public class Main {
    private static Administracion administracion = new Administracion();
    private static Doctor d1 = new Doctor("Víctor Huertas", 629, 4, "10/10/2003", "Nefrología", 332);
    private static Doctor d2 = new Doctor("Miriam Cruz", 777, 0, "29/03/2017", "Nefrología", 900);
    private static Paciente p1 = new Paciente("1234567L", "María Velázquez");



    public static void main(String[] args) {
        administracion.contrataDoctor(d1);
        administracion.contrataDoctor(d2);

        administracion.registrarPaciente(p1);

        System.out.print(administracion.listaDoctores());


    }


}
