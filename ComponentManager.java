import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class ComponentManager {
    private final List<JComponent> components = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private final ComponentFactory componentFactory = new ComponentFactory();
    private JFrame frame;

    public void addLabel(String text) {
        JLabel label = new JLabel(text);
        components.add(label);
        System.out.println("Label ajouté : " + text);
        addKeyShortcut(label, KeyEvent.VK_L);  // Raccourci clavier 'L' pour Label
    }

    public void addButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(e -> System.out.println("Bouton cliqué : " + text));
        components.add(button);
        System.out.println("Bouton ajouté : " + text);
        addKeyShortcut(button, KeyEvent.VK_B);  // Raccourci clavier 'B' pour Button
    }

    public void addTextField(String label) {
        JTextField textField = new JTextField(label);
        components.add(textField);
        System.out.println("Champ de texte ajouté : " + label);
        addKeyShortcut(textField, KeyEvent.VK_T);  // Raccourci clavier 'T' pour TextField
    }

    public void addTable(int rows) {
        JTable table = new JTable(rows, 3); // Exemple avec 3 colonnes
        components.add(table);
        System.out.println("Table ajoutée avec " + rows + " lignes.");
        addKeyShortcut(table, KeyEvent.VK_TAB);  // Raccourci clavier 'Tab' pour Table
    }

    public void addComboBox(String[] options) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        components.add(comboBox);
        System.out.println("Menu déroulant ajouté avec options : " + String.join(", ", options));
        addKeyShortcut(comboBox, KeyEvent.VK_C);  // Raccourci clavier 'C' pour ComboBox
    }

    public void addCheckBox(String label) {
        JCheckBox checkBox = new JCheckBox(label);
        checkBox.addItemListener(e -> System.out.println("Case à cocher modifiée : " + label));
        components.add(checkBox);
        System.out.println("Case à cocher ajoutée : " + label);
        addKeyShortcut(checkBox, KeyEvent.VK_K);  // Raccourci clavier 'K' pour CheckBox
    }

    public void addRadioButton(String label) {
        JRadioButton radioButton = new JRadioButton(label);
        radioButton.addActionListener(e -> System.out.println("Bouton radio sélectionné : " + label));
        components.add(radioButton);
        System.out.println("Bouton radio ajouté : " + label);
        addKeyShortcut(radioButton, KeyEvent.VK_R);  // Raccourci clavier 'R' pour RadioButton
    }

    public void addTextArea(String label) {
        JTextArea textArea = new JTextArea(label);
        components.add(textArea);
        System.out.println("Zone de texte ajoutée : " + label);
        addKeyShortcut(textArea, KeyEvent.VK_A);  // Raccourci clavier 'A' pour TextArea
    }

    private void addKeyShortcut(JComponent component, int keyCode) {
        InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = component.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0), "componentAction");
        actionMap.put("componentAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Raccourci clavier activé pour " + component.getClass().getSimpleName());
            }
        });
    }

    public void displayPreview() {
        PreviewManager.displayPreview(components);
    }

    public List<JComponent> getComponents() {
        return components;
    }

    public JFrame createFrame() {
        frame = new JFrame("SwingMano");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        for (JComponent component : components) {
            frame.add(component);
        }
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
