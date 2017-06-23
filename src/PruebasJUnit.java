import org.junit.*;
import static org.junit.Assert.*;

public class PruebasJUnit {
    private static Administracion administracion;
    private static Doctor d1, d2, d3, d4, d5;
    private static Paciente p1;


    @Before
    public void inicializa() {
        administracion = new Administracion();
        d1 = new Doctor("Víctor Huertas", 629, 4, "10/10/2003", "Nefrología", 332);
        d2 = new Doctor("Miriam Cruz", 777, 0, "29/03/2017", "Nefrología", 900);
        d3 = new Doctor("Horacio Fernández", 21, 0, "02/02/2004", "Cirujía", 201);
        d4 = new Doctor("Alba Santana", 113, 6, "30/05/1995", "Podología", 212);
        d5 = new Doctor("Sergio Bertini", 113, 10, "15/07/1998", "Radiología", 2);


        p1 = new Paciente("1234567L", "María Velázquez");
        administracion.contrataDoctor(d1);

    }

    @After
    public void finaliza(){
        System.out.print("Test finalizado correctamente.");
    }

    @Test
    public void probandoListaDoctores() {
        administracion.contrataDoctor(d2);
        administracion.contrataDoctor(d3);
        administracion.contrataDoctor(d4);
        assertEquals("[" + d3.toString() + ", " + d2.toString() + ", " + d1.toString() + ", " +
                d4.toString() + "]", administracion.listaDoctores().toString());

        administracion.contrataDoctor(d5);
        assertEquals("Prueba doctores repetidos: " , "[" + d3.toString() + ", " + d2.toString() + ", " + d1.toString() + ", " +
                d4.toString() + "]", administracion.listaDoctores().toString());

    }

    @Test
    public void probandoRegistrarCita() {
        assertEquals("Prueba1", false, administracion.registrarCita(d1, p1, "03/08/2017", "12:30")); // Prueba Paciente no registrado
        administracion.registrarPaciente(p1);
        assertEquals("Prueba2", true, administracion.registrarCita(d1, p1, "03/08/2017", "12:30"));
    }


}
