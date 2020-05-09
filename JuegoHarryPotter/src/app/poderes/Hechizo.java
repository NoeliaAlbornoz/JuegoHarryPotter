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

    public Hechizo() {

    }

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

        if (artefacto instanceof Horrocrux) {
            Horrocrux horri = (Horrocrux) artefacto;
            if (horri.esReliquiaMuerte()) {

            } else {
                danioReliquia = 0;
                System.out.print("\nTu artefacto no es una Reliquia de la Muerte. No ganas puntos adicionales.\n");

            }

        }

        System.out.print("\nPuntos adicionales de daño por Reliquia de la Muerte " + danioReliquia + "\n");

        int danioTotal = this.nivelDanio + this.activarDanioDeArtefacto(artefacto) + danioReliquia
                - this.curarEnemigo(personaje);

        personaje.decrementarSalud(danioTotal);

    }

    public int curarEnemigo(Personaje personaje) {
        if (personaje instanceof Wizard) {
            Wizard wizi = (Wizard) personaje;

            return this.activarCuracionDeArtefacto(wizi.getArtefacto().getAmplificadorDeCuracion());

        }
        return 0;
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

    }

    public void curar(Elfo elfo) {

        int saludAumentada = this.nivelCuracion
                + this.activarCuracionDeArtefacto(elfo.getArtefacto().getAmplificadorDeCuracion());

        elfo.aumentarSalud(saludAumentada);
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