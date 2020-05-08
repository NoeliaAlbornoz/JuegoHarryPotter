package app.poderes;

import app.Minijuego;
import app.artefactos.Artefacto;
import app.artefactos.Horrocrux;
import app.personajes.Elfo;
import app.personajes.Personaje;
import app.personajes.Wizard;

public abstract class Hechizo extends Poder {

    private boolean esOscuro;
    private int nivelDanio;
    private int nivelCuracion;
    private int energiaMagica;
    private Minijuego minijuego;

    public Hechizo(String nombre) {
        super(nombre);
    }

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

    public int getEnergiaMagica() {
        return energiaMagica;
    }

    public void setEnergiaMagica(int energiaMgica) {
        this.energiaMagica = energiaMgica;
    }

    public void disminuirEnergiaMagica(int energiaMagica) {

        int energiaMagicaResultante = this.energiaMagica - this.energiaMagica;

        this.setEnergiaMagica(energiaMagicaResultante);

    }

    public void disminuirSalud(Personaje personaje, Artefacto artefacto) {

        int danioReliquia = 1;
        int curacionEnemiga = 0;

        if (artefacto instanceof Horrocrux) {
            danioReliquia = 0;

        } else {

            System.out.println("\nTu artefacto es una Reliquia de la Muerte. Incrementa el daño total en un punto.\n");

        }

        if (personaje instanceof Wizard) {
            Wizard wizi = (Wizard) personaje;

            curacionEnemiga = this.activarCuracionDeArtefacto(wizi.getArtefacto().getAmplificadorDeCuracion());

        }

        int danioTotal = this.nivelDanio + this.activarDanioDeArtefacto(artefacto) + danioReliquia - curacionEnemiga;

        personaje.decrementarSalud(danioTotal);

        System.out.println("Tu artefacto " + artefacto.getNombre() + " genera un daño adicional de "
                + this.activarDanioDeArtefacto(artefacto) + " puntos.");

        System.out.println("La curación del artefacto enemigo " + artefacto.getNombre() + " atenúa el ataque en "
                + curacionEnemiga + " puntos.");

    }

    public int activarDanioDeArtefacto(Artefacto artefacto) {
        return (int) (this.nivelDanio * artefacto.getAmplificadorDeDanio());

    }

    public int activarCuracionDeArtefacto(double amplificadorDeCuracion) {
        return (int) (this.nivelCuracion * amplificadorDeCuracion);

    }

    public void curar(Wizard wizard) {

        int saludAumentada = this.nivelCuracion
                + this.activarCuracionDeArtefacto(wizard.getArtefacto().getAmplificadorDeCuracion());

        wizard.aumentarSalud(saludAumentada);

        System.out.println("Tu artefacto " + wizard.getArtefacto().getNombre() + " genera una curación adicional de "
                + this.activarCuracionDeArtefacto(wizard.getArtefacto().getAmplificadorDeCuracion()) + " puntos. ");

    }

    public void curar(Elfo elfo) {

        int saludAumentada = this.nivelCuracion
                + this.activarCuracionDeArtefacto(elfo.getArtefacto().getAmplificadorDeCuracion());

        elfo.aumentarSalud(saludAumentada);

        System.out.println("Tu artefacto " + elfo.getArtefacto().getNombre() + " genera una curación adicional de "
                + this.activarCuracionDeArtefacto(elfo.getArtefacto().getAmplificadorDeCuracion()) + " puntos. ");

    }

    public int multiplicarDanioHechizoOscuro() {

        return this.nivelDanio * 2;

    }

    public int multiplicarCuracionHechizoOscuro() {

        return this.nivelCuracion *= 2;

    }

    public Minijuego getMinijuego() {
        return minijuego;
    }

    public void setMinijuego(Minijuego minijuego) {
        this.minijuego = minijuego;
    }

}