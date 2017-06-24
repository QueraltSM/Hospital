import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private Administracion administracion = new Administracion();
    private Doctor d1 = new Doctor("Víctor Huertas", 629, 4, "10/10/2003", "Nefrología", 332);
    private Doctor d2 = new Doctor("Miriam Cruz", 777, 0, "29/03/2017", "Nefrología", 900);
    private Doctor d3 = new Doctor("Horacio Fernández", 21, 0, "02/02/2004", "Cirujía", 201);
    private Doctor d4 = new Doctor("Alba Santana", 113, 6, "30/05/1995", "Podología", 212);
    private Doctor d5 = new Doctor("Sergio Bertini", 113, 10, "15/07/1998", "Radiología", 2);
    private Paciente p1 = new Paciente("1234567L", "María Velázquez");

    private JRadioButton doctores = new JRadioButton("Doctores");
    private JRadioButton pacientes = new JRadioButton("Pacientes");
    private ButtonGroup bg = new ButtonGroup();

    private JTextField cod = new JTextField(5);
    private JButton buscar = new JButton("Buscar");




    private JLabel foto = new JLabel();

    private JButton contrataDoctor = new JButton("Contratar Doctor");
    private JButton registrarPaciente = new JButton("Registrar Paciente");
    private JButton crearConsulta = new JButton("Nueva consulta");
    private JButton verHistorial = new JButton("Ver historial de consultas");

    private JTextArea text = new JTextArea(20, 20);


    public GUI(){
        initAdministracion();
        foto.setIcon(new ImageIcon("src/photo.png"));
        setTitle("Hospital");
        setVisible(true);
        setResizable(false);
        setSize(600, 530);
        setLocationRelativeTo(null);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,1));
        add(p, BorderLayout.EAST);
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2,1));
        JPanel p3 = new JPanel();
        p3.add(contrataDoctor, BorderLayout.NORTH);
        p3.add(registrarPaciente, BorderLayout.SOUTH);
        JPanel p7 = new JPanel();
        p7.add(crearConsulta, BorderLayout.NORTH);
        p7.add(verHistorial, BorderLayout.SOUTH);
        JPanel p6 = new JPanel();
        p6.setLayout(new GridLayout(2, 1));
        p6.add(p3);
        p6.add(p7);
        p2.add(p6);
        JPanel p8 = new JPanel();
        p8.setLayout(new GridLayout(1,4));
        p8.add(new JPanel());
        p8.add(foto);
        p.add(p2);
        p.add(p8);


        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,2));
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        p5.add(pacientes, BorderLayout.WEST);
        p5.add(doctores, BorderLayout.EAST);
        bg.add(pacientes);
        bg.add(doctores);
        p4.add(p5, BorderLayout.NORTH);
        p4.add(text, BorderLayout.CENTER);
        JPanel aux = new JPanel();
        aux.setLayout(new FlowLayout());
        aux.add(new JLabel("Código:"));
        aux.add(cod);
        aux.add(buscar);

        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(administracion.listaPacientes(Integer.parseInt(cod.getText())));
            }
        });


        p4.add(aux);
        p1.add(p4);
        p1.add(p);
        add(p1);

        text.setEditable(false);

        pacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(administracion.getTodosPacientes());
            }
        });

        doctores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(administracion.getTodosDoctores());
            }
        });


        contrataDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContrataDoctorGUI(new JFrame()).setVisible(true);
            }
        });


        registrarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistraPacienteGUI(new JFrame()).setVisible(true);
            }
        });

        crearConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NuevaConsultaGUI(new JFrame()).setVisible(true);
            }
        });


        verHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HistorialClinicoGUI(new JFrame()).setVisible(true);
            }
        });

    }

    public void initAdministracion() {
        administracion.contrataDoctor(d1);
        administracion.registrarPaciente(p1);
        administracion.registrarCita(d1, p1, "", "");
        administracion.contrataDoctor(d3);

    }


}
