/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Joel
 */
public class claseBotones {
    public interface BotonClickListener {
    void onClick();
}
    public static void aparienciaBotonMediano (JPanel panel, JFrame frame, JLabel label, BotonClickListener listener){
        panel.setBackground(new Color(0xCC66FF));
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(100, 40));
        

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(100, 40));
        Font fuentePersonalizada = new Font("Arial Rounded MT Bold", Font.PLAIN, 12);
        
        label.setFont(fuentePersonalizada);
        label.setForeground(Color.WHITE);
        
        
        // Agregar eventos de ratón al JLabel
    label.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(new Color(0xe5b2ff));
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            panel.setBackground(new Color(0xCC66FF));
            label.setCursor(Cursor.getDefaultCursor());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            panel.setBackground(new Color(0x8e47b2));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            panel.setBackground(new Color(0xCC66FF));
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            if (listener != null) {
                listener.onClick();
            }
        }

    });

        panel.add(label, BorderLayout.CENTER);
        
        
        
        
    
    }
    
    public static void aparienciaBotonGrafico (JLabel label, BotonClickListener listener){
         // Colores personalizados
        Color bordeColor = new Color(153, 0, 153);
        Color clicColor = new Color(102, 0, 102);

        

// Agregar eventos de ratón al JLabel
    label.addMouseListener(new MouseAdapter() {
        @Override
public void mouseEntered(MouseEvent e) {
                label.setBorder(new LineBorder(bordeColor, 2, true)); // Borde redondeado
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

        @Override
        public void mouseExited(MouseEvent e) {
                label.setBorder(null); // Quitar el borde al salir
                label.setCursor(Cursor.getDefaultCursor());
            }

                    @Override
            public void mousePressed(MouseEvent e) {
                label.setBorder(new LineBorder(clicColor, 2, true)); // Efecto de clic hundido
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                label.setBorder(null); // Volver a la normalidad después de soltar el clic
            }
            
            
        @Override
        public void mouseClicked(MouseEvent e) {
            if (listener != null) {
                listener.onClick();
            }
        }

    });

    
    }
    
        public static void aparienciaBotonMediano2 (JPanel panel, JFrame frame, JLabel label, BotonClickListener listener){
        panel.setBackground(new Color(0xCC66FF));
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(70, 20));
        

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(70, 20));
        Font fuentePersonalizada = new Font("Arial Rounded MT Bold", Font.PLAIN, 12);
        
        label.setFont(fuentePersonalizada);
        label.setForeground(Color.WHITE);
        
        
        // Agregar eventos de ratón al JLabel
    label.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(new Color(0xe5b2ff));
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            panel.setBackground(new Color(0xCC66FF));
            label.setCursor(Cursor.getDefaultCursor());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            panel.setBackground(new Color(0x8e47b2));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            panel.setBackground(new Color(0xCC66FF));
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            if (listener != null) {
                listener.onClick();
            }
        }

    });

        panel.add(label, BorderLayout.CENTER);
        
        
        
        
    
    }
            public static void aparienciaBotonPequeño (JPanel panel, JFrame frame, JLabel label, BotonClickListener listener){
        panel.setBackground(new Color(0xCC66FF));
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(8, 18));
        

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(8, 18));
        Font fuentePersonalizada = new Font("Arial Black", Font.PLAIN, 12);
        
        label.setFont(fuentePersonalizada);
        label.setForeground(Color.WHITE);
        
        
        // Agregar eventos de ratón al JLabel
    label.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(new Color(0xe5b2ff));
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            panel.setBackground(new Color(0xCC66FF));
            label.setCursor(Cursor.getDefaultCursor());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            panel.setBackground(new Color(0x8e47b2));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            panel.setBackground(new Color(0xCC66FF));
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            if (listener != null) {
                listener.onClick();
            }
        }

    });

        panel.add(label, BorderLayout.CENTER);
        
        
        
        
    
    }
         public static void aparienciaBotonGrande (JPanel panel, JFrame frame, JLabel label, BotonClickListener listener){
        panel.setBackground(new Color(0xCC66FF));
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(84, 32));
        

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(84, 32));
        Font fuentePersonalizada = new Font("Arial Rounded MT Bold", Font.PLAIN, 12);
        
        label.setFont(fuentePersonalizada);
        label.setForeground(Color.WHITE);
        
        
        // Agregar eventos de ratón al JLabel
    label.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(new Color(0xe5b2ff));
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            panel.setBackground(new Color(0xCC66FF));
            label.setCursor(Cursor.getDefaultCursor());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            panel.setBackground(new Color(0x8e47b2));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            panel.setBackground(new Color(0xCC66FF));
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            if (listener != null) {
                listener.onClick();
            }
        }

    });

        panel.add(label, BorderLayout.CENTER);
        
        
        
        
    
    }

}
