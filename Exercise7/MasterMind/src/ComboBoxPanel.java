import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxPanel {

    JPanel comboBPanel;
    JComboBox<String> C1, C2, C3, C4;

    public ComboBoxPanel() {

        comboBPanel = new JPanel();

        String[] options = {"?", "Blue", "Green", "Red", "Yellow", "Pink", "Orange"};

        C1 = new JComboBox<String>(options);
        C2 = new JComboBox<String>(options);
        C3 = new JComboBox<String>(options);
        C4 = new JComboBox<String>(options);

        comboBPanel.setLayout(null);

        C1.setBounds(0,10,45,30);
        comboBPanel.add(C1);

        C2.setBounds(55,10,45,30);
        comboBPanel.add(C2);

        C3.setBounds(115,10,45,30);
        comboBPanel.add(C3);

        C4.setBounds(175,10,45,30);
        comboBPanel.add(C4);

    }

    public void resetValue() {
        this.C1.setSelectedIndex(0);
        this.C2.setSelectedIndex(0);
        this.C3.setSelectedIndex(0);
        this.C4.setSelectedIndex(0);
    }
}
