
package vista.componentesGraficos;

import vista.componentesGraficos.TabBarra;
import vista.formularios.Entrada;
import vista.formularios.AdminUsuarios;
import vista.formularios.Inventario;
import vista.formularios.Salida;
import vista.formularios.Vender;
import vista.formularios.PanelConfiguracion;
import vista.formularios.Resumen;
import vista.formularios.AdminReportes;

import modelo.usuarios.Usuario;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.swing.AvatarIcon;

/**
 *
 * @author Joel
 */
public class BarraLateralDesplegable extends SimpleDrawerBuilder{
  
  

        private Runnable logoutHandler; // Un Runnable para manejar el logout

    public void setLogoutHandler(Runnable logoutHandler) {
        this.logoutHandler = logoutHandler;
    }



    //
    
  

    @Override
    public SimpleHeaderData getSimpleHeaderData() {

        
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/Media/GIV22.png"),90,90,999))
                .setTitle("Gestion de Inventario y Ventas")
                .setDescription("GIV TEAM")
                
                
                ;
        
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        
         String userRole = Usuario.getRol(); // Obtén el rol actualizado
        String menus[][] = {
           
            {"Resumen"},
            {"Vender"},
            {"Inventario", "Entrada", "Salida"},

            {"Configuracion", "Administrador de Usuarios","Administrador de Reportes", "Personalización", "Manual de Usuario"},

            {"Cerrar Sesión"}}
                      
                      ;
        
        
        String icons[] = {
            "grafica.svg",
            "carrito.svg",
            "caja.svg",
          
            "puntosotros.svg",
            "salir.svg"
        
        
        
        
        
        };

        return new SimpleMenuOption()
                .setMenus(menus)
                .setIcons(icons)
                .setBaseIconPath("media")
                .setIconScale(0.20f)
                
                .addMenuEvent(new MenuEvent(){
                    @Override
                    public void selected(MenuAction action, int index, int subIndex){
                        if(index==1){
                        TabBarra.getInstance().showForm(new Vender());
                        
                        }else if(index==0){
                        TabBarra.getInstance().showForm(new Resumen());
                        
                        
                        }else if(index==2 && subIndex == 0){
                        TabBarra.getInstance().showForm(new Inventario());
                        
                        
                        }else if(index==2 && subIndex==1){
                        TabBarra.getInstance().showForm( new Entrada());
                        
                        
                        }else if(index==2 && subIndex == 2){
                        TabBarra.getInstance().showForm(new Salida());
                        
                        
                        }else if(index==3 && subIndex == 1){
                        TabBarra.getInstance().showForm(new AdminUsuarios());
                        
                        
                        }else if(index==3 && subIndex == 2){
                        TabBarra.getInstance().showForm(new AdminReportes());
                        
                        
                        }else if(index==3 && subIndex == 3){
                        TabBarra.getInstance().showForm(new PanelConfiguracion());
                        
                        
                        }else if(index==3 && subIndex == 4){
                    
                    
                    }else if (index == 4 && logoutHandler != null) {
                        // Llama al método de logout en MenuDashboard
                        logoutHandler.run();
                    }
                        
                        
                        
                        
                        
                        
                        System.out.println("Menu Selected " + index + " " + subIndex);
                    
                    }
                
                
                })
                .setMenuValidation(new MenuValidation() {
                         @Override
                    public boolean menuValidation(int index, int subIndex) {
                        
                        /*    if ("admin".equals(userRole)) {
                        // Los administradores tienen acceso completo
                        TabBarra.getInstance().showForm(new Resumen());
                        return true;
                        } else if ("cajero".equals(userRole)) {
                        // Restricciones específicas para cajero
                        if (index == 0 || index == 2 || (index == 3 && subIndex == 1) || (index == 3 && subIndex == 2)) {
                        
                        return false;
                        }
                        
                        }*/
                        return true;
                    }
                });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
   
    
    return new SimpleFooterData()
                .setTitle("GIV")
                .setDescription("Version 3.0.22")
            
            
            ;
    
    }
    


    
}
