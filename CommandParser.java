


class CommandParser {
    private final ComponentManager componentManager = new ComponentManager();
    private final Exporter exporter = new Exporter(componentManager);

    public boolean parse(String command) {
        switch (command) {
            case "add label":
            case "add button":
            case "add textfield":
                componentManager.addComponent(command.split(" ")[1]);
                return true;
            case "preview":
                componentManager.displayPreview();
                return true;
            case "edit preview":
                componentManager.editPreview();
                return true;
            case "save preview":
                componentManager.savePreview();
                return true;
            case "export code":
                exporter.exportToCode();
                return true;
            case "help":
                displayHelp();
                return true;
            case "exit":
                System.out.println("Merci d'avoir utilisé SwingMano. Au revoir !");
                System.exit(0);
                return true;
            default:
                return false;
        }
    }

    private void displayHelp() {
        System.out.println("\nCommandes disponibles :");
        System.out.println("  add label       - Ajouter un label");
        System.out.println("  add button      - Ajouter un bouton");
        System.out.println("  add textfield   - Ajouter un champ de texte");
        System.out.println("  preview         - Afficher l'aperçu actuel");
        System.out.println("  edit preview    - Modifier la disposition ou le contenu des éléments");
        System.out.println("  save preview    - Sauvegarder l'aperçu actuel");
        System.out.println("  export code     - Exporter les composants en fichier source Java");
        System.out.println("  help            - Afficher cette aide");
        System.out.println("  exit            - Quitter l'application\n");
    }
}
