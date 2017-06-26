//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame {
    private static Administracion administracion = new Administracion();
    private Doctor d1 = new Doctor("Víctor Huertas", 629, 4, "10/10/2003", "Nefrología", 332);
    private Doctor d2 = new Doctor("Miriam Cruz", 777, 0, "29/03/2017", "Nefrología", 900);
    private Doctor d3 = new Doctor("Horacio Fernández", 921, 0, "02/02/2004", "Cirujía", 201);
    private Doctor d4 = new Doctor("Alba Santana", 113, 6, "30/05/1995", "Podología", 212);
    private Doctor d5 = new Doctor("Sergio Bertini", 113, 10, "15/07/1998", "Radiología", 2);
    private Paciente p1 = new Paciente("1234567L", "María Velázquez");
    private JRadioButton doctores = new JRadioButton("Doctores");
    private JRadioButton pacientes = new JRadioButton("Pacientes");
    private ButtonGroup bg = new ButtonGroup();
    private JTextField cod = new JTextField(5);
    private JButton buscar = new JButton("Buscar");
    private JRadioButton ordenarPorEspecialidad = new JRadioButton("Especialidad");
    private JRadioButton ordenarPorCodigo = new JRadioButton("Código");
    private ButtonGroup bg2 = new ButtonGroup();
    private JLabel foto = new JLabel();
    private JButton contrataDoctor = new JButton("Contratar Doctor");
    private JButton registrarPaciente = new JButton("Registrar Paciente");
    private JButton crearConsulta = new JButton("Nueva consulta");
    private JButton verHistorial = new JButton("Ver historial de consultas");
    private JTextArea text = new JTextArea(20, 20);

    public static Administracion getAdministracion() {
        return administracion;
    }

    public GUI() {
        this.initAdministracion();
        this.foto.setIcon(new ImageIcon("src/photo.png"));
        this.setTitle("Hospital");
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(600, 530);
        this.setLocationRelativeTo((Component)null);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        this.add(p, "East");
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 1));
        JPanel p3 = new JPanel();
        p3.add(this.contrataDoctor, "North");
        p3.add(this.registrarPaciente, "South");
        JPanel p7 = new JPanel();
        p7.add(this.crearConsulta, "North");
        p7.add(this.verHistorial, "South");
        JPanel p6 = new JPanel();
        p6.setLayout(new GridLayout(2, 1));
        p6.add(p3);
        p6.add(p7);
        p2.add(p6);
        JPanel p8 = new JPanel();
        p8.setLayout(new GridLayout(1, 4));
        p8.add(new JPanel());
        p8.add(this.foto);
        p.add(p2);
        p.add(p8);
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        p5.add(this.pacientes, "West");
        p5.add(this.doctores, "East");
        this.bg.add(this.pacientes);
        this.bg.add(this.doctores);
        p4.add(p5, "North");
        p4.add(this.text, "Center");
        administracion.setDoctoresOrdenados(0);
        JPanel p9 = new JPanel();
        p9.setLayout(new FlowLayout());
        p9.add(new JLabel("Doctor:"));
        this.bg2.add(this.ordenarPorCodigo);
        this.bg2.add(this.ordenarPorEspecialidad);
        this.ordenarPorEspecialidad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.administracion.setDoctoresOrdenados(0);
                GUI.this.text.setText(GUI.administracion.getDoctoresOrdenados());
            }
        });
        this.ordenarPorCodigo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.administracion.setDoctoresOrdenados(1);
                GUI.this.text.setText(GUI.administracion.getDoctoresOrdenados());
            }
        });
        p9.add(this.ordenarPorEspecialidad);
        p9.add(this.ordenarPorCodigo);
        p4.add(p9, "South");
        JPanel aux = new JPanel();
        aux.setLayout(new FlowLayout());
        aux.add(new JLabel("Código:"));
        aux.add(this.cod);
        aux.add(this.buscar);
        this.buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.text.setText(GUI.administracion.listaPacientes(Integer.parseInt(GUI.this.cod.getText())));
            }
        });
        p4.add(aux);
        p1.add(p4);
        p1.add(p);
        this.add(p1);
        this.text.setEditable(false);
        this.pacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.text.setText(GUI.administracion.getTodosPacientes());
            }
        });
        this.doctores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.text.setText(GUI.administracion.getTodosDoctores());
            }
        });
        this.contrataDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                (new ContrataDoctorGUI(new JFrame())).setVisible(true);
            }
        });
        this.registrarPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                (new RegistraPacienteGUI(new JFrame())).setVisible(true);
            }
        });
        this.crearConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                (new NuevaConsultaGUI(new JFrame())).setVisible(true);
            }
        });
        this.verHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                (new HistorialClinicoGUI(new JFrame())).setVisible(true);
            }
        });
    }

    public void initAdministracion() {
        administracion.contrataDoctor(this.d1);
        administracion.registrarPaciente(this.p1);
        administracion.registrarCita(this.d1, this.p1, "", "");
        administracion.contrataDoctor(this.d3);
        administracion.registrarCita(this.d3, this.p1, "", "");
    }
}
