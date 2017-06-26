import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HistorialClinicoGUI extends JDialog {
    private JTextField paciente = new JTextField(10);
    private JButton buscar = new JButton("Buscar");
    private JTextArea texto = new JTextArea(20, 20);
    private JButton ok = new JButton("OK");

    public HistorialClinicoGUI(JFrame f) {
        super(f, "Historial clínico");
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(this.paciente);
        p1.add(this.buscar);
        JPanel p2 = new JPanel();
        p2.add(this.texto, "Center");
        this.buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(GUI.getAdministracion().getPaciente(HistorialClinicoGUI.this.paciente.getText()) == null) {
                    JOptionPane.showMessageDialog(HistorialClinicoGUI.this, "No se encuentra el paciente");
                } else {
                    HistorialClinicoGUI.this.texto.setText(GUI.getAdministracion().getPaciente(HistorialClinicoGUI.this.paciente.getText()).getHistorial());
                }

            }
        });
        this.add(p1, "North");
        this.add(p2, "Center");
        JPanel pau = new JPanel();
        pau.add(this.ok, "Center");
        this.add(pau, "South");
        this.ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HistorialClinicoGUI.this.dispose();
            }
        });
        this.setVisible(true);
        this.setSize(400, 400);
        this.setLocationRelativeTo(f);
    }
}
