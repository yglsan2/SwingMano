
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class CommandParser {
    private final ComponentManager componentManager = new ComponentManager();
    private final Exporter exporter = new Exporter(componentManager);

    public boolean parse(String command) {
        String[] parts = command.split(" ", 2);  // Divise la commande et son argument
        if (parts.length < 2) {
            return false;
        }
        String action = parts[0];
        String argument = parts[1].trim();

        switch (action) {
            case "#label":
                componentManager.addLabel(argument);
                return true;
            case "#button":
                componentManager.addButton(argument);
                return true;
            case "#textfield":
                componentManager.addTextField(argument);
                return true;
            case "#table":
                componentManager.addTable(Integer.parseInt(argument));
                return true;
            case "#combobox":
                componentManager.addComboBox(argument.split(","));
                return true;
            case "#checkbox":
                componentManager.addCheckBox(argument);
                return true;
            case "#radiobutton":
                componentManager.addRadioButton(argument);
                return true;
            case "#textarea":
                componentManager.addTextArea(argument);
                return true;
            case "#preview":
                componentManager.displayPreview();
                return true;
            case "#quit":
                System.out.println("Merci d'avoir utilisé SwingMano. A bientôt");
                System.exit(0);
                return true;
            default:
                return false;
        }
    }
}
