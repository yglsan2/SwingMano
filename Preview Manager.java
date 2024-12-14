import javax.swing.*;
import java.util.*;

class PreviewManager {
    public static void displayPreview(List<JComponent> components) {
        if (components.isEmpty()) {
            System.out.println("Aucun composant n'a encore été ajouté.");
        } else {
            JFrame previewFrame = new JFrame("Aperçu de l'Interface");
            previewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            previewFrame.setLayout(new FlowLayout());

            for (JComponent component : components) {
                previewFrame.add(component);
            }

            previewFrame.pack();
            previewFrame.setVisible(true);
            System.out.println("\n--- Aperçu affiché ---");
        }
    }
}

