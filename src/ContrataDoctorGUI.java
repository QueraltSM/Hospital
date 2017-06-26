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

public class ContrataDoctorGUI extends JDialog {
    private JTextField nombre = new JTextField(10);
    private JTextField codigo = new JTextField(10);
    private JTextField especialidad = new JTextField(10);
    private JTextField nConsulta = new JTextField(10);
    private JButton contratar = new JButton("Contratar");
    private JButton cancelar = new JButton("Cancelar");

    public ContrataDoctorGUI(JFrame f) {
        super(f, "Contratar Doctor");
        JPanel aux1 = new JPanel();
        JPanel aux2 = new JPanel();
        aux1.setLayout(new GridLayout(2, 1));
        aux1.add(aux2);
        aux2.setLayout(new GridLayout(6, 1));
        JPanel a1 = new JPanel();
        a1.add(this.nombre, "Center");
        aux2.add(a1);
        JPanel a2 = new JPanel();
        a2.add(this.codigo, "Center");
        aux2.add(a2);
        JPanel a3 = new JPanel();
        a3.add(this.especialidad, "Center");
        aux2.add(a3);
        JPanel a4 = new JPanel();
        a4.add(this.nConsulta, "Center");
        aux2.add(a4);
        JPanel p = new JPanel();
        aux2.add(p);
        JPanel aux3 = new JPanel();
        aux3.setLayout(new FlowLayout());
        aux3.add(this.contratar);
        aux3.add(this.cancelar);
        aux2.add(aux3);
        this.contratar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!ContrataDoctorGUI.this.nombre.getText().equals("") && !ContrataDoctorGUI.this.especialidad.getText().equals("") && !ContrataDoctorGUI.this.codigo.getText().equals("") && !ContrataDoctorGUI.this.nConsulta.getText().equals("")) {
                    if(GUI.getAdministracion().contrataDoctor(new Doctor(ContrataDoctorGUI.this.nombre.getText(), Integer.parseInt(ContrataDoctorGUI.this.codigo.getText()), ContrataDoctorGUI.this.especialidad.getText(), Integer.parseInt(ContrataDoctorGUI.this.nConsulta.getText())))) {
                        JOptionPane.showMessageDialog(ContrataDoctorGUI.this, "Doctor contratado");
                        ContrataDoctorGUI.this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(ContrataDoctorGUI.this, "No se ha contratado a ningún doctor");
                    }
                }

            }
        });
        this.cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ContrataDoctorGUI.this.nombre.setText("");
                ContrataDoctorGUI.this.especialidad.setText("");
                ContrataDoctorGUI.this.codigo.setText("");
                ContrataDoctorGUI.this.nConsulta.setText("");
            }
        });
        this.add(aux1, "North");
        this.setVisible(true);
        this.setSize(400, 300);
        this.setLocationRelativeTo(f);
    }
}
