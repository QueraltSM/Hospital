import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NuevaConsultaGUI extends JDialog {
    private JTextField nombreDoctor = new JTextField(10);
    private JTextField nombrePaciente = new JTextField(10);
    private JTextField fecha = new JTextField(10);
    private JTextField hora = new JTextField(10);
    private JButton registrar = new JButton("Registrar cita");
    private JButton cancelar = new JButton("Cancelar");

    public NuevaConsultaGUI(JFrame f) {
        super(f, "Nueva Consulta");
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 1));
        JPanel aux1 = new JPanel();
        aux1.add(this.nombreDoctor, "Center");
        JPanel aux2 = new JPanel();
        aux2.add(this.nombrePaciente, "Center");
        JPanel aux3 = new JPanel();
        aux3.add(this.fecha, "Center");
        JPanel aux4 = new JPanel();
        aux4.add(this.hora, "Center");
        p1.add(aux1);
        p1.add(aux2);
        p1.add(aux3);
        p1.add(aux4);
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(this.registrar);
        p2.add(this.cancelar);
        this.registrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Iterator var2 = GUI.getAdministracion().listaDoctores().iterator();

                while(true) {
                    Doctor i;
                    do {
                        if(!var2.hasNext()) {
                            return;
                        }

                        i = (Doctor)var2.next();
                    } while(!i.getNombre().equals(NuevaConsultaGUI.this.nombreDoctor.getText()));

                    Iterator var4 = GUI.getAdministracion().listaPacientes().iterator();

                    while(var4.hasNext()) {
                        Paciente j = (Paciente)var4.next();
                        if(j.getNombre().equals(NuevaConsultaGUI.this.nombrePaciente.getText())) {
                            if(GUI.getAdministracion().registrarCita(i, j, NuevaConsultaGUI.this.fecha.getText(), NuevaConsultaGUI.this.hora.getText())) {
                                JOptionPane.showMessageDialog(NuevaConsultaGUI.this, "Se ha registrado la cita");
                            } else {
                                JOptionPane.showMessageDialog(NuevaConsultaGUI.this, "No se ha registrado cita");
                            }
                        }
                    }
                }
            }
        });
        this.cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NuevaConsultaGUI.this.nombreDoctor.setText("");
                NuevaConsultaGUI.this.nombrePaciente.setText("");
                NuevaConsultaGUI.this.hora.setText("");
                NuevaConsultaGUI.this.fecha.setText("");
            }
        });
        this.add(p1, "North");
        this.add(p2, "Center");
        this.setVisible(true);
        this.setSize(200, 300);
        this.setLocationRelativeTo(f);
    }
}
