
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ComponentManager {
    private final List<JComponent> components = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private final ComponentFactory componentFactory = new ComponentFactory();

    public void addComponent(String type) {
        JComponent component = componentFactory.createComponent(type);
        if (component == null) {
            System.out.println("Type de composant non pris en charge.");
            return;
        }

        System.out.print("Entrez une description pour le " + type + " : ");
        String description = scanner.nextLine();
        component.setToolTipText(description);
        components.add(component);
        System.out.println(type + " ajouté avec succès !\n");
    }

    public void displayPreview() {
        PreviewManager.displayPreview(components);
    }

    public void editPreview() {
        if (components.isEmpty()) {
            System.out.println("Aucun composant à éditer. Ajoutez des composants d'abord.");
            return;
        }

        PreviewManager.displayPreview(components);

        System.out.print("Entrez le numéro de l'élément à modifier : ");
        int index;
        try {
            index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= components.size()) {
                System.out.println("Index invalide. Retour au menu principal.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Retour au menu principal.");
            return;
        }

        JComponent component = components.get(index);
        System.out.println("Vous modifiez : [" + component.getClass().getSimpleName() + "] " + component.getToolTipText());
        System.out.print("Voulez-vous vraiment modifier cet élément ? (O/N) : ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("o")) {
            System.out.print("Entrez la nouvelle description : ");
            String newDescription = scanner.nextLine();
            component.setToolTipText(newDescription);
            System.out.println("Modification réussie !\n");
        } else {
            System.out.println("Modification annulée.\n");
        }
    }

    public void savePreview() {
        PreviewManager.savePreview(components);
    }

    public List<JComponent> getComponents() {
        return components;
    }
}
