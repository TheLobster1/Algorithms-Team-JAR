import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIPanel extends JPanel {
    private JButton runButton;
    private JComboBox sortingSelector;
    private JTextArea resultsBox;
    private JTextArea resultTimeBox;
    public GUIPanel() {
        this.setupUI();
    }
    private void setupUI() {
        this.setLayout(new BorderLayout(0, 10));
        JLabel titleLabel = new JLabel();
        titleLabel.setFont(this.getFont());
        titleLabel.setHorizontalAlignment(0);
        titleLabel.setText("Algorithms Sorting and Searching");
        titleLabel.setVerticalAlignment(1);
        titleLabel.setVerticalTextPosition(1);
        titleLabel.setBorder(new CompoundBorder(titleLabel.getBorder(), new EmptyBorder(10, 10, 10, 10)));
        this.add(titleLabel, "North");
        //create buttons and add listeners
    }
}
