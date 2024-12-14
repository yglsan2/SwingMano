

import javax.swing.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

class Exporter {
    private final ComponentManager componentManager;

    public Exporter(ComponentManager componentManager) {
        this.componentManager = componentManager;
    }

    public void exportToCode() {
        List<JComponent> components = componentManager.getComponents();
        if (components.isEmpty()) {
            System.out.println("Aucun composant à exporter.");
            return;
        }

        try (PrintWriter writer = new PrintWriter("GeneratedSwingUI.java")) {
            writer.println("import javax.swing.*;");
            writer.println("public class GeneratedSwingUI {");
            writer.println("    public static void main(String[] args) {");
            writer.println("        JFrame frame = new JFrame(\"SwingMano Export\");");
            writer.println("        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);");
            writer.println("        frame.setSize(400, 300);");
            writer.println("        JPanel panel = new JPanel();");

            for (JComponent component : components) {
                if (component instanceof JLabel) {
                    writer.println("        panel.add(new JLabel(\"" + component.getToolTipText() + "\"));");
                } else if (component instanceof JButton) {
                    writer.println("        panel.add(new JButton(\"" + component.getToolTipText() + "\"));");
                } else if (component instanceof JTextField) {
                    writer.println("        panel.add(new JTextField(\"" + component.getToolTipText() + "\", 15));");
                }
            }

            writer.println("        frame.add(panel);");
            writer.println("        frame.setVisible(true);");
            writer.println("    }");
            writer.println("}");

            System.out.println("Code exporté avec succès dans 'GeneratedSwingUI.java'.\n");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'exportation : " + e.getMessage());
        }
    }
}
