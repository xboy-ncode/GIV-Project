package controlador;


import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


/**
 *
 * @author Joel
 */
public class Metodos1 {

 

    //<editor-fold defaultstate="collapsed" desc="Metodos relacionados al carrito">
    public void controlCantidadCarritoMas(JTextField paramTextField) {

        String currentValue = paramTextField.getText();
        int newValue = Integer.parseInt(currentValue) + 1;
        paramTextField.setText(String.valueOf(newValue));

    }

    public void controlCantidadCarritoMenos(JTextField paramTextField) {

        String currentValue = paramTextField.getText();
        int newValue = Integer.parseInt(currentValue) - 1;
        paramTextField.setText(String.valueOf(newValue));

    }

public static void agregarCarritoSumarTotal(JTable paramMainTable, JTable paramCartTable, JTextField paramUnitsCounter, JLabel paramTotalAmountLabel, JTextField buscador) {

    // Obtener el índice de la fila seleccionada en mainTable
    int selectedRow = paramMainTable.getSelectedRow();

    // Verificar si hay una fila seleccionada
    if (selectedRow >= 0) {
        // Obtener los datos de la fila seleccionada en mainTable
        Object data1 = paramMainTable.getValueAt(selectedRow, 1); // obtener el valor de la segunda columna
        String data2 = (String) paramMainTable.getValueAt(selectedRow, 2); // obtener el valor de la tercera columna
        data2 = data2.replace("$", "");//eliminar el símbolo $ para operaciones matemáticas
        String data2symbol = (String) paramMainTable.getValueAt(selectedRow, 2);// obtener el valor de la tercera columna
        int data3 = Integer.parseInt(paramUnitsCounter.getText()); // obtener el valor del campo de texto de las unidades

        // Verificar si la cantidad disponible es mayor que 0
        int availableUnits = Integer.parseInt(paramMainTable.getValueAt(selectedRow, 3).toString());
        
        // Validar si la cantidad deseada es mayor que la cantidad disponible
        if (data3 > availableUnits) {
            JOptionPane.showMessageDialog(null, "No hay suficientes unidades disponibles. La cantidad disponible es: " + availableUnits);
            return; // Salir del método si la validación no pasa
        }

        if (availableUnits > 0) {
            // Restar la cantidad deseada de las unidades disponibles
            availableUnits -= data3;

            // Calcular el subtotal
            BigDecimal price = new BigDecimal(data2);
            BigDecimal subtotal = price.multiply(BigDecimal.valueOf(data3));
            String subtotalSymbol = "$" + subtotal.toString();

            // Crear un objeto Vector con los datos de la fila y el subtotal
            Vector<Object> rowData = new Vector<>();
            rowData.addElement(data1);
            rowData.addElement(data2symbol);
            rowData.addElement(data3);
            rowData.addElement(subtotalSymbol);

            // Agregar la fila a cartTable
            DefaultTableModel cartModel = (DefaultTableModel) paramCartTable.getModel();
            cartModel.addRow(rowData);

            // Operaciones para el monto total
            BigDecimal totalAmount = BigDecimal.ZERO;
            for (int i = 0; i < paramCartTable.getRowCount(); i++) {
                String subtotalRow = (String) paramCartTable.getValueAt(i, 3);
                subtotalRow = subtotalRow.replace("$", "");
                BigDecimal subtotalValue = new BigDecimal(subtotalRow);
                totalAmount = totalAmount.add(subtotalValue);
            }

            // Actualizar la etiqueta de monto total
            paramTotalAmountLabel.setText("$" + totalAmount);

            // Establecer las unidades disponibles actualizadas en la tabla principal
           // paramMainTable.setValueAt(availableUnits, selectedRow, 3);

            // Establecer el contador a 1
            paramUnitsCounter.setText("1");

            // Deseleccionar
            paramMainTable.clearSelection();

            // Limpiar campo de búsqueda
            buscador.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Producto agotado o no disponible");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona un producto antes de agregar al carrito.");
    }
}
    
private static final BigDecimal CONVERSION_RATE = new BigDecimal("40");

public static String convertCurrency(String input) {
    if (input.startsWith("$")) {
        // Remove the "$" sign
        String numericValue = input.substring(1);
        // Convert the string to BigDecimal
        BigDecimal amount = new BigDecimal(numericValue);
        // Multiply by 40
        amount = amount.multiply(CONVERSION_RATE);
        // Format and return the result with "BsS."
        return "BsS." + amount.toString();
    } else if (input.startsWith("BsS.")) {
        // Remove the "BsS." prefix
        String numericValue = input.substring(4);
        // Convert the string to BigDecimal
        BigDecimal amount = new BigDecimal(numericValue);
        // Divide by 40 using RoundingMode.HALF_UP
        amount = amount.divide(CONVERSION_RATE, RoundingMode.HALF_UP);
        // Format and return the result with "$"
        return "$" + amount.toString();
    } else {
        throw new IllegalArgumentException("Invalid currency format");
    }
}
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos relacionados con la base de datos">
    public void insertarALaBD(JTextField paramTextCantidad, JTextField paramTextPrecio, JTextField paramTextNombre, JTextField paramTextCode, JTextField paramTextMarca, JComboBox paramComboBoxUnidadDeMedicion, JTextField paramPeso) {
        String codigo = paramTextCode.getText();
        String nombre = paramTextNombre.getText();
        String nombreMarca = paramTextMarca.getText();
        String pesoString = paramPeso.getText();
        int peso = Integer.parseInt(pesoString);
        String numCant = paramTextCantidad.getText();
        int numCantInt = Integer.parseInt(numCant);

        BigDecimal numPrecio = new BigDecimal(paramTextPrecio.getText());

        String ComboBox_unidad_de_medicionString = (String) paramComboBoxUnidadDeMedicion.getSelectedItem();
        int unidad_de_medicionInt = 0;

        if ("mg".equals(ComboBox_unidad_de_medicionString)) {
            unidad_de_medicionInt = 4;

        } else if ("gr".equals(ComboBox_unidad_de_medicionString)) {
            unidad_de_medicionInt = 1;
        } else if ("lt".equals(ComboBox_unidad_de_medicionString)) {
            unidad_de_medicionInt = 3;
        } else if ("ml".equals(ComboBox_unidad_de_medicionString)) {
            unidad_de_medicionInt = 2;
        }
    int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas insertar este producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
        
        }else{
        
        }
    }




//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodos generales">

    public void actualizarLabel(String texto, JLabel paramLabel) {
        paramLabel.setText(texto);
    }

    public void obtenerComboBox(JComboBox paramComboBox) {
        String opcionSeleccionadaString;

        opcionSeleccionadaString = (String) paramComboBox.getSelectedItem();

    }

    public void updateSoloTotal(JTable paramCartTable, JLabel paramTotalAmountLabel, JTextField paramUnitsCounter) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (int i = 0; i < paramCartTable.getRowCount(); i++) {
            String subtotalRow = (String) paramCartTable.getValueAt(i, 3);
            subtotalRow = subtotalRow.replace("$", "");

            BigDecimal subtotalValue = new BigDecimal(subtotalRow);
            totalAmount = totalAmount.add(subtotalValue);
        }

        // Actualizar la etiqueta de monto total
        paramTotalAmountLabel.setText("$" + String.valueOf(totalAmount));

        //Establecer el contador a 1
        paramUnitsCounter.setText("1");

    }

public void mostrarCarpeta(JTable tabla, String Carpeta, JLabel label){
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
    File folder = new File(Carpeta);
 if (folder.exists() && folder.isDirectory()) {
     model.setRowCount(0);
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Añadir una fila al modelo con el nombre del archivo y su tamaño
                       
                        model.addRow(new Object[]{file.getName(), file.length()});
                        
                    }
                }
            }else{
            label.setText("Carpeta Vacia");
            
            }
        }
}

public void abrirCarpeta(String fileName, String carpeta) {
    File file = new File(carpeta, fileName);  // Construir la ruta completa del archivo
    if (file.exists()) {
        try {
            // Abre el archivo o carpeta en el explorador de Windows
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } else {
        System.out.println("El archivo no existe.");
    }
}

}
    

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodos no usados">


//</editor-fold>

