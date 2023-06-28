import javax.swing.*;

public class AlgorithmsGUI {
    private final GUIPanel panel;

    public AlgorithmsGUI() {
        JFrame frame = new JFrame("JARJAR Algorithms");
        this.panel = new GUIPanel();
        frame.setDefaultCloseOperation(3);
        frame.getContentPane().add(this.panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    public void setResults(String results) {
        panel.setText(results);
    }
}
