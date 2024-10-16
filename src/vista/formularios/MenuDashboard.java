/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.formularios;


import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;
import vista.componentesGraficos.BarraLateralDesplegable;
import vista.componentesGraficos.TabBarra;

/**
 *
 * @author Joel
 */
public class MenuDashboard extends javax.swing.JFrame {
    private BarraLateralDesplegable barraLateralDesplegable;
    /**
     * Creates new form MenuDashboard
     */
 
   
   
public MenuDashboard() {
    GlassPanePopup.install(this);
    
    // Guarda la instancia de BarraLateralDesplegable en un campo
    barraLateralDesplegable = new BarraLateralDesplegable();
    
    // Usa la instancia en Drawer
    Drawer.getInstance().setDrawerBuilder(barraLateralDesplegable);
    // Inicializa los componentes del JFrame o JPanel
    initComponents();
     setExtendedState(this.MAXIMIZED_BOTH);
    
    // Instala la barra de pestañas en el cuerpo del frame
    TabBarra.getInstance().install(this, body);
            // Configura la acción adicional para el índice 4
        barraLateralDesplegable.setLogoutHandler(this::logoutAction);
        TabBarra.getInstance().showForm(new Resumen());

}
    public BarraLateralDesplegable getBarraLateralDesplegable() {
        return barraLateralDesplegable;
    }
    
    private void logoutAction() {
        // Aquí defines la lógica para cerrar la sesión
        this.dispose(); // Cierra el formulario actual
        login l = new login(); // Muestra el formulario de login
        l.setVisible(true);
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    // End of variables declaration//GEN-END:variables
}
