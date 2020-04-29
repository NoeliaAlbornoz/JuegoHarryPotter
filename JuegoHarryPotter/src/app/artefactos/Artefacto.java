package app.artefactos;

import app.poderes.Poder;

public class Artefacto {

    private String nombre;
    private double amplificadorDeDanio;
    private double amplificadorDeCuracion;
    private Poder poder;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAmplificadorDeDanio() {
        return amplificadorDeDanio;
    }

    public void setAmplificadorDeDanio(double amplificadorDeDanio) {
        this.amplificadorDeDanio = amplificadorDeDanio;
    }

    public double getAmplificadorDeCuracion() {
        return amplificadorDeCuracion;
    }

    public void setAmplificadorDeCuracion(double amplificadorDeCuracion) {
        this.amplificadorDeCuracion = amplificadorDeCuracion;
    }

    public Poder getPoder() {
        return poder;
    }

    public void setPoder(Poder poder) {
        this.poder = poder;
    }

}