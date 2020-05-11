package app.poderes;

import app.Minijuego;
import app.artefactos.Artefacto;
import app.artefactos.Horrocrux;
import app.personajes.Elfo;
import app.personajes.Personaje;
import app.personajes.Wizard;

public abstract class Hechizo extends Poder {

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

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

        int danioReliquia = this.verificarSiEsReliquia(artefacto);

        int danioTotal = this.calcularDanioTotal(artefacto, danioReliquia);

        personaje.decrementarSalud(danioTotal);

    }

    public int calcularDanioTotal(Artefacto artefacto, int danioReliquia) {
        return this.nivelDanio + this.activarDanioDeArtefacto(artefacto) + danioReliquia;
    }

    public int verificarSiEsReliquia(Artefacto artefacto) {

        int danioReliquia = 1;

        if (artefacto instanceof Horrocrux) {
            Horrocrux horri = (Horrocrux) artefacto;

            if (horri.esReliquiaMuerte()) {

                System.out.println("Puntos adicionales de daño por Reliquia de la Muerte " + danioReliquia + "\n");
                return danioReliquia = 1;

            } else {

                System.out.println("\nTu artefacto no es una Reliquia de la Muerte. No ganas puntos adicionales.");
                return danioReliquia = 0;

            }

        }

        System.out.println("Puntos adicionales de daño por Reliquia de la Muerte " + danioReliquia + "\n");

        return danioReliquia;

    }

    public void curarEnemigo(Personaje personaje) {

        if (personaje.esWizard()) {
            Wizard wizi = (Wizard) personaje;

            personaje.aumentarSalud(this.activarCuracionDeArtefacto(wizi.getArtefacto().getAmplificadorDeCuracion()));

            System.out.println("\nLa curación del " + ANSI_PURPLE + "artefacto enemigo"  + ANSI_RESET + " atenúa el ataque en " + this.activarCuracionDeArtefacto(wizi.getArtefacto().getAmplificadorDeCuracion()) + " puntos.\n");

        }
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

        return this.nivelCuracion * 2;

    }

    public Minijuego getMinijuego() {
        return minijuego;
    }

    public void setMinijuego(Minijuego minijuego) {
        this.minijuego = minijuego;
    }

}