package vista.componentesGraficos;


public class ModelData {

    private String date;  // Fecha o día
    private double ingresoDia;
    private double ingresoSemana;
    private double ingresoMes;

    // Constructor que inicializa las variables
    public ModelData(String date, double ingresoDia, double ingresoSemana, double ingresoMes) {
        this.date = date;
        this.ingresoDia = ingresoDia;
        this.ingresoSemana = ingresoSemana;
        this.ingresoMes = ingresoMes;
    }

    // Getters y Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getIngresoDia() {
        return ingresoDia;
    }

    public void setIngresoDia(double ingresoDia) {
        this.ingresoDia = ingresoDia;
    }

    public double getIngresoSemana() {
        return ingresoSemana;
    }

    public void setIngresoSemana(double ingresoSemana) {
        this.ingresoSemana = ingresoSemana;
    }

    public double getIngresoMes() {
        return ingresoMes;
    }

    public void setIngresoMes(double ingresoMes) {
        this.ingresoMes = ingresoMes;
    }
}
