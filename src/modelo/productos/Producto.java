package modelo.productos;

/**
 *
 * @author Joel
 */
public class Producto {
    private String codigo;
    private String nombre;
    private String precio;
    private String cantidad;
    private String peso;
    private Marca marca;
    private UnidadDeMedicion medida;

    public Producto(String codigo, String nombre, String precio, String cantidad, String peso, Marca marca, UnidadDeMedicion medida) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.peso = peso;
        this.marca = marca;
        this.medida = medida;
    }



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public UnidadDeMedicion getMedida() {
        return medida;
    }

    public void setMedida(UnidadDeMedicion medida) {
        this.medida = medida;
    }

}
