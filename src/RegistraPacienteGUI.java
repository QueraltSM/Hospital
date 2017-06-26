import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistraPacienteGUI extends JDialog {
    private JTextField nombre = new JTextField(10);
    private JTextField dni = new JTextField(8);
    private JButton registrar = new JButton("Registrar paciente");
    private JButton cancelar = new JButton("Cancelar");

    public RegistraPacienteGUI(JFrame f) {
        super(f, "Registrar Paciente");
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 1));
        JPanel p3 = new JPanel();
        p1.add(p3);
        p3.add(this.nombre);
        JPanel p4 = new JPanel();
        p1.add(p4);
        p4.add(this.dni);
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(this.registrar);
        p2.add(this.cancelar);
        this.registrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(GUI.getAdministracion().registrarPaciente(new Paciente(RegistraPacienteGUI.this.dni.getText(), RegistraPacienteGUI.this.nombre.getText()))) {
                    JOptionPane.showMessageDialog(RegistraPacienteGUI.this, "Paciente registrado");
                } else {
                    JOptionPane.showMessageDialog(RegistraPacienteGUI.this, "Paciente no registrado");
                }

            }
        });
        this.cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistraPacienteGUI.this.nombre.setText("");
                RegistraPacienteGUI.this.dni.setText("");
            }
        });
        this.add(p1, "North");
        this.add(p2, "Center");
        this.setVisible(true);
        this.setSize(200, 250);
        this.setLocationRelativeTo(f);
    }
}
