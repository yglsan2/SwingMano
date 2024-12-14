
import java.util.Scanner;

class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private final CommandParser commandParser = new CommandParser();

    public void run() {
        String command;
        while (true) {
            System.out.print("> ");
            command = scanner.nextLine().trim().toLowerCase();

            if (!commandParser.parse(command)) {
                System.out.println("Commande inconnue. Tapez 'help' pour voir la liste des commandes disponibles.");
            }
        }
    }
}

