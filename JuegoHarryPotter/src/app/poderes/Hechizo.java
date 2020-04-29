package app.poderes;

public class Hechizo extends Poder {

    private boolean esOscuro;
    private int nivelDanio;
    private int nivelCuracion;
    private int energiaMgica;

    public boolean isEsOscuro() {
        return esOscuro;
    }

    public void setEsOscuro(boolean esOscuro) {
        this.esOscuro = esOscuro;
    }

    public int getNivelDanio() {
        return nivelDanio;
    }

    public void setNivelDanio(int nivelDanio) {
        this.nivelDanio = nivelDanio;
    }

    public int getNivelCuracion() {
        return nivelCuracion;
    }

    public void setNivelCuracion(int nivelCuracion) {
        this.nivelCuracion = nivelCuracion;
    }

    public int getEnergiaMgica() {
        return energiaMgica;
    }

    public void setEnergiaMgica(int energiaMgica) {
        this.energiaMgica = energiaMgica;
    }

}