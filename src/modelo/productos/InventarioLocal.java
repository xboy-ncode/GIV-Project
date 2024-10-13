/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.productos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joel
 */
public class InventarioLocal {
    
      private List<Producto> productos;

    public InventarioLocal() {
        productos = new ArrayList<>();
        cargarProductosEjemplo();
    }

    private void cargarProductosEjemplo() {
        productos.add(new Producto("001", "Producto 1", "10.50", "100", "1kg", new Marca("Marca1"), new UnidadDeMedicion("Unidad1")));
        productos.add(new Producto("002", "Producto 2", "20.00", "150", "0.5kg", new Marca("Marca2"), new UnidadDeMedicion("Unidad2")));
        productos.add(new Producto("003", "Producto 3", "5.75", "200", "2kg", new Marca("Marca3"), new UnidadDeMedicion("Unidad3")));
        productos.add(new Producto("004", "Producto 4", "12.99", "50", "1.5kg", new Marca("Marca4"), new UnidadDeMedicion("Unidad4")));
        productos.add(new Producto("005", "Producto 5", "8.30", "80", "0.75kg", new Marca("Marca5"), new UnidadDeMedicion("Unidad5")));
        productos.add(new Producto("006", "Producto 6", "15.60", "120", "0.9kg", new Marca("Marca6"), new UnidadDeMedicion("Unidad6")));
        productos.add(new Producto("007", "Producto 7", "6.45", "300", "1.2kg", new Marca("Marca7"), new UnidadDeMedicion("Unidad7")));
        productos.add(new Producto("008", "Producto 8", "11.20", "75", "0.65kg", new Marca("Marca8"), new UnidadDeMedicion("Unidad8")));
        productos.add(new Producto("009", "Producto 9", "7.80", "65", "1.1kg", new Marca("Marca9"), new UnidadDeMedicion("Unidad9")));
        productos.add(new Producto("010", "Producto 10", "9.99", "90", "1.8kg", new Marca("Marca10"), new UnidadDeMedicion("Unidad10")));
    }

    public List<Producto> getProductos() {
        return productos;
    }
    
    
    
}
