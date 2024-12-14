

import javax.swing.*;

class ComponentFactory {
    public JComponent createComponent(String type) {
        return switch (type.toLowerCase()) {
            case "label" -> new JLabel("Mon Label");
            case "button" -> new JButton("Mon Bouton");
            case "textfield" -> new JTextField("Mon Texte");
            default -> null;
        };
    }
}








