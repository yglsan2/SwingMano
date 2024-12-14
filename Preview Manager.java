

import javax.swing.*;
import java.util.List;

class PreviewManager {
    public static void displayPreview(List<JComponent> components) {
        if (components.isEmpty()) {
            System.out.println("Aucun composant n'a encore été ajouté.");
        } else {
            System.out.println("\n--- Aperçu actuel ---");
            for (int i = 0; i < components.size(); i++) {
                JComponent component = components.get(i);
                if (component instanceof JLabel) {
                    System.out.println((i + 1) + ". Label: " + component.getToolTipText());
                } else if (component instanceof JButton) {
                    System.out.println((i + 1) + ". Bouton: " + component.getToolTipText());
                } else if (component instanceof JTextField) {
                    System.out.println((i + 1) + ". Champ de texte: " + component.getToolTipText());
                } else if (component instanceof JTable) {
                    System.out.println((i + 1) + ". Table: " + ((JTable) component).getRowCount() + " lignes");
                } else if (component instanceof JComboBox) {
                    System.out.println((i + 1) + ". Menu déroulant: " + component.getToolTipText());
                } else if (component instanceof JCheckBox) {
                    System.out.println((i + 1) + ". Case à cocher: " + component.getToolTipText());
                } else if (component instanceof JRadioButton) {
                    System.out.println((i + 1) + ". Bouton radio: " + component.getToolTipText());
                } else if (component instanceof JTextArea) {
                    System.out.println((i + 1) + ". Zone de texte: " + component.getToolTipText());
                }
            }
            System.out.println("--------------------\n");
        }
    }
}
