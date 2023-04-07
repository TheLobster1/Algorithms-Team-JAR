import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIPanel extends JPanel {
    private JButton runButton;
    private JToggleButton linkedListToggle;
    private JToggleButton arrayListToggle;
    private JToggleButton anotherListToggle;
    private JToggleButton bubbleSortToggle;
    private JToggleButton anotherSortToggle;
    private JToggleButton binarySearchToggle;
    private JToggleButton anotherSearchToggle;
    private JTextArea resultsBox;
    private JTextArea resultTimeBox;
    public GUIPanel() {
        this.setupUI();
    }
    private void setupUI() {
        this.setLayout(new BorderLayout(0, 10));
        this.setBackground(Color.decode("#121212"));

        JLabel titleLabel = new JLabel();
        titleLabel.setFont(this.getFont());
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(0);
        titleLabel.setText("Algorithms Sorting and Searching");
        titleLabel.setVerticalAlignment(1);
        titleLabel.setVerticalTextPosition(1);
        titleLabel.setBorder(new CompoundBorder(titleLabel.getBorder(), new EmptyBorder(10, 10, 10, 10)));
        this.add(titleLabel, "North");

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new GridLayout(1, 3));
        this.add(selectionPanel);

        JPanel listTypeSelector = new JPanel();
        listTypeSelector.setLayout(new GridLayout(3, 1));
        selectionPanel.add(listTypeSelector);

        JPanel algoSelector = new JPanel();
        algoSelector.setLayout(new GridLayout(5, 1));
        selectionPanel.add(algoSelector);

        resultsBox = new JTextArea(3, 1);
        resultsBox.setLocation(100, 100);
        resultsBox.setSize(50, 50);
        resultsBox.setText("HELLO THERE");
        resultsBox.setEnabled(true);
        resultsBox.setBackground(Color.decode("#121010"));
        resultsBox.setForeground(Color.white);
        selectionPanel.add(resultsBox);

        //create buttons and add listeners
        linkedListToggle = new JToggleButton();
        linkedListToggle.setText("Linked List");
        linkedListToggle.addActionListener(e -> {
            if(linkedListToggle.isSelected()) {
                resetLists();
                linkedListToggle.setSelected(true);
            }
        });
        listTypeSelector.add(linkedListToggle);

        arrayListToggle = new JToggleButton();
        arrayListToggle.setText("ArrayList");
        arrayListToggle.addActionListener(e -> {
            if(arrayListToggle.isSelected()) {
                resetLists();
                arrayListToggle.setSelected(true);
            }
        });
        listTypeSelector.add(arrayListToggle);

        anotherListToggle = new JToggleButton();
        anotherListToggle.setText("IDK");
        anotherListToggle.addActionListener(e -> {
            if(anotherListToggle.isSelected()) {
                resetLists();
                anotherListToggle.setSelected(true);
            }
        });
        listTypeSelector.add(anotherListToggle);

        bubbleSortToggle = new JToggleButton();
        bubbleSortToggle.setText("Bubble Sort");
        bubbleSortToggle.addActionListener(e -> {
            if(bubbleSortToggle.isSelected()) {
                resetAlgorithms();
                bubbleSortToggle.setSelected(true);
            }
        });
        algoSelector.add(bubbleSortToggle);

        anotherSortToggle = new JToggleButton();
        anotherSortToggle.setText("SORTING YAY");
        anotherSortToggle.addActionListener(e -> {
            if(anotherSortToggle.isSelected()) {
                resetAlgorithms();
                anotherSortToggle.setSelected(true);
            }
        });
        algoSelector.add(anotherSortToggle);

        binarySearchToggle = new JToggleButton();
        binarySearchToggle.setText("Binary Search");
        binarySearchToggle.addActionListener(e -> {
            if(binarySearchToggle.isSelected()) {
                resetAlgorithms();
                binarySearchToggle.setSelected(true);
            }
        });
        algoSelector.add(binarySearchToggle);

        anotherSearchToggle = new JToggleButton();
        anotherSearchToggle.setText("More searching...");
        anotherSearchToggle.addActionListener(e -> {
            if(anotherSearchToggle.isSelected()) {
                resetAlgorithms();
                anotherSearchToggle.setSelected(true);
            }
        });
        algoSelector.add(anotherSearchToggle);

        runButton = new JButton("Run");
        runButton.addActionListener((e -> {
            if(linkedListToggle.isSelected() || arrayListToggle.isSelected() || anotherListToggle.isSelected()) {
                if(bubbleSortToggle.isSelected() || anotherSortToggle.isSelected() || binarySearchToggle.isSelected() || anotherSearchToggle.isSelected()) {
                    if(linkedListToggle.isSelected()) {
                        //TODO
                    }
                    if(arrayListToggle.isSelected()) {
                        //TODO
                    }
                    if(anotherListToggle.isSelected()) {
                        //TODO
                    }
                    if(bubbleSortToggle.isSelected()) {
                        //TODO
                    }
                    if(anotherSortToggle.isSelected()) {
                        //TODO
                    }
                    if(binarySearchToggle.isSelected()) {
                        //TODO
                    }
                    if(anotherSearchToggle.isSelected()) {
                        //TODO
                    }
                    return;
                }
            }

        }));
        algoSelector.add(runButton);

    }
    public Font getFont() { return new Font("Arial", 1, 24);}
    public Dimension getPreferredSize() { return new Dimension(800, 600); }
    private void resetLists() {
        linkedListToggle.setSelected(false);
        arrayListToggle.setSelected(false);
        anotherListToggle.setSelected(false);
    }
    private void resetAlgorithms() {
        bubbleSortToggle.setSelected(false);
        anotherSortToggle.setSelected(false);
        binarySearchToggle.setSelected(false);
        anotherSearchToggle.setSelected(false);
    }

    public void setText(String results) {
        resultsBox.setText(results);
    }
}
