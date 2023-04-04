import javax.swing.*;

public class AlgorithmsGUI {
    private final JPanel panel;

    public AlgorithmsGUI() {
        JFrame frame = new JFrame("JARJAR Algorithms");
        this.panel = new JPanel();
        frame.setDefaultCloseOperation(3);
        frame.getContentPane().add(this.panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
