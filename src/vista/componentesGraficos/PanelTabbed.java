/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.componentesGraficos;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Joel
 */
public class PanelTabbed extends JPanel {
    
        private final ButtonGroup buttonGroup;

    public PanelTabbed() {
        setLayout(new MigLayout("filly,insets 3 10 3 10"));
        buttonGroup = new ButtonGroup();
    }

    public void addTab(JToggleButton item) {
        buttonGroup.add(item);
        add(item);
        repaint();
        revalidate();
    }
    
}
