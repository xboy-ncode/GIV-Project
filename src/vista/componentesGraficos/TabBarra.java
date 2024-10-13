package vista.componentesGraficos;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import raven.drawer.Drawer;


public class TabBarra {

  private static TabBarra instance;
    private JMenuBar menuBar;
    private PanelTabbed panelTabbed;
    private JPanel body;
    private formularioPropiedades temp;
    private final int LIMIT = -1; // -1 for unlimit
    private final boolean REMOVE_WHEN_LIMIT = false;

    public static TabBarra getInstance() {
        if (instance == null) {
            instance = new TabBarra();
        }
        return instance;
    }

    public void install(JFrame frame, JPanel body) {
        this.body = body;
        menuBar = new JMenuBar();
        menuBar.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderColor:$TitlePane.background;"
                + "border:0,0,0,0");
        panelTabbed = new PanelTabbed();
        panelTabbed.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$TitlePane.background");
        menuBar.add(createDrawerButton());
        menuBar.add(createScroll(panelTabbed));
        frame.setJMenuBar(menuBar);
    }

    public void removeAllTabbed() {
        panelTabbed.removeAll();
        panelTabbed.repaint();
        panelTabbed.revalidate();
        body.removeAll();
        body.revalidate();
        body.repaint();
    }

    public void showTabbed(boolean show) {
        menuBar.setVisible(show);
        if (!show) {
            
            Drawer.getInstance().closeDrawer();
        }
    }

    private JButton createDrawerButton() {
        JButton cmd = new JButton(new FlatSVGIcon("media/menu.svg", 0.25f));
        cmd.addActionListener((ae) -> {
            Drawer.getInstance().showDrawer();
            
            
            /* if (!Drawer.getInstance().isShowing()) {
            cmd.setIcon(new FlatSVGIcon("Media/cerrar.svg", 0.25f)); // Cambia a "cerrar.svg" cuando se abre el drawer
            Drawer.getInstance().showDrawer();
            } else {
            cmd.setIcon(new FlatSVGIcon("Media/menu.svg", 0.25f)); // Cambia a "menu.svg" cuando se cierra el drawer
            Drawer.getInstance().closeDrawer();
            
            
            }*/
        });
        cmd.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "background:null;"
                + "arc:5");
        return cmd;
    }

    private JScrollPane createScroll(Component com) {
        JScrollPane scroll = new JScrollPane(com);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll.getHorizontalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "width:0");
        scroll.getHorizontalScrollBar().setUnitIncrement(10);
        scroll.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:0,0,0,0");
        return scroll;
    }

    public boolean addTab(String title, formularioPropiedades component) {
        if (LIMIT != -1 && panelTabbed.getComponentCount() >= LIMIT) {
            if (REMOVE_WHEN_LIMIT) {
                panelTabbed.remove(0);
            } else {
                return false;
            }
        }
        TabbedItem item = new TabbedItem(title, component);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showForm(item.getComponent());
            }
        });
        panelTabbed.addTab(item);
        showForm(component);
        item.setSelected(true);
        return true;
    }

    public void removeTab(TabbedItem tab) {
        if (tab.getComponent().formClose()) {
            if (tab.isSelected()) {
                body.removeAll();
                body.revalidate();
                body.repaint();
            }
            panelTabbed.remove(tab);
            panelTabbed.revalidate();
            panelTabbed.repaint();
        }
    }

    public void removeTabAt(int index) {
        Component com = panelTabbed.getComponent(index);
        if (com instanceof TabbedItem) {
            removeTab((TabbedItem) com);
        }
    }

    public void removeTab(formularioPropiedades tab) {
        for (Component com : panelTabbed.getComponents()) {
            if (com instanceof TabbedItem) {
                formularioPropiedades form = ((TabbedItem) com).getComponent();
                if (form == tab) {
                    removeTab((TabbedItem) com);
                }
            }
        }
    }

    public String[] getTabName() {
        List<String> list = new ArrayList<>();
        for (Component com : panelTabbed.getComponents()) {
            if (com instanceof TabbedItem) {
                String name = ((TabbedItem) com).getTabbedName();
                list.add(name);
            }
        }
        String[] arr = new String[list.size()];
        list.toArray(arr);
        return arr;
    }

    public int getTabSelectedIndex() {
        for (Component com : panelTabbed.getComponents()) {
            if (com instanceof TabbedItem) {
                if (((TabbedItem) com).isSelected()) {
                    return panelTabbed.getComponentZOrder(com);
                }
            }
        }
        return -1;
    }

    public void showForm(formularioPropiedades component) {
        body.removeAll();
        body.add(component);
        body.repaint();
        body.revalidate();
        panelTabbed.repaint();
        panelTabbed.revalidate();
        component.formOpen();
        temp = component;
    }
}
