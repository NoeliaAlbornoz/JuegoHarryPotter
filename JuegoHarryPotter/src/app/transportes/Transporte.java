package app.transportes;

public class Transporte {

    private String nombre;
    private String descripcion;
    private int velocidad;
    private int amplificadorDeSalud;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAmplificadorDeSalud() {
        return amplificadorDeSalud;
    }

    public void setAmplificadorDeSalud(int amplificadorDeSalud) {
        this.amplificadorDeSalud = amplificadorDeSalud;
    }

}