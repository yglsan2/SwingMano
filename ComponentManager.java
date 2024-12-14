import javax.swing.*;
import java.util.*;
class ComponentManager {
    private final List<JComponent> components = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private final ComponentFactory componentFactory = new ComponentFactory();

    public void addLabel(String text) {
        JLabel label = new JLabel(text);
        components.add(label);
        System.out.println("Label ajouté : " + text);
    }

    public void addButton(String text) {
        JButton button = new JButton(text);
        components.add(button);
        System.out.println("Bouton ajouté : " + text);
    }

    public void addTextField(String label) {
        JTextField textField = new JTextField(label);
        components.add(textField);
        System.out.println("Champ de texte ajouté : " + label);
    }

    public void addTable(int rows) {
        JTable table = new JTable(rows, 3); // Exemple avec 3 colonnes
        components.add(table);
        System.out.println("Table ajoutée avec " + rows + " lignes.");
    }

    public void addComboBox(String[] options) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        components.add(comboBox);
        System.out.println("Menu déroulant ajouté avec options : " + String.join(", ", options));
    }

    public void addCheckBox(String label) {
        JCheckBox checkBox = new JCheckBox(label);
        components.add(checkBox);
        System.out.println("Case à cocher ajoutée : " + label);
    }

    public void addRadioButton(String label) {
        JRadioButton radioButton = new JRadioButton(label);
        components.add(radioButton);
        System.out.println("Bouton radio ajouté : " + label);
    }

    public void addTextArea(String label) {
        JTextArea textArea = new JTextArea(label);
        components.add(textArea);
        System.out.println("Zone de texte ajoutée : " + label);
    }

    public void displayPreview() {
        PreviewManager.displayPreview(components);
    }

    public List<JComponent> getComponents() {
        return components;
    }
}
