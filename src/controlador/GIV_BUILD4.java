/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import vista.formularios.GeneradorDeReporteEntrada;
import vista.formularios.GeneradorDeReporteSalida;
import vista.formularios.MenuDashboard;
import vista.formularios.login;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Font;
import javax.swing.UIManager;

/**
 *
 * @author Joel
 */
public class GIV_BUILD4 {
 
    /**
     * @param args the command line arguments
     */
    

    
    public static void main(String[] args) {

        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("Vista");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
               
        FlatIntelliJLaf.setup();
 FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            login l = new login();
            //  MenuDashboard md = new MenuDashboard();
            l.setVisible(true);
    
    });
    
}
}
