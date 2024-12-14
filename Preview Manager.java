

import javax.swing.*;
import java.util.List;

class PreviewManager {
    public static void displayPreview(List<JComponent> components) {
        if (components.isEmpty()) {
            System.out.println("Aucun composant n'a encore été ajouté. Utilisez les commandes 'add' pour commencer.");
        } else {
            System.out.println("\n--- Aperçu actuel ---");
            for (int i = 0; i < components.size(); i++) {
                JComponent component = components.get(i);
                System.out.println((i + 1) + ". [" + component.getClass().getSimpleName() + "] " + component.getToolTipText());
            }
            System.out.println("--------------------\n");
        }
    }

    public static void savePreview(List<JComponent> components) {
        if (components.isEmpty()) {
            System.out.println("Aucun composant à sauvegarder.");
            return;
        }

        System.out.println("\n--- Aperçu sauvegardé ---");
        for (JComponent component : components) {
            System.out.println("[" + component.getClass().getSimpleName() + "] " + component.getToolTipText());
        }
        System.out.println("--------------------------\n");
        System.out.println("L'aperçu a été sauvegardé avec succès !\n");
    }
}
