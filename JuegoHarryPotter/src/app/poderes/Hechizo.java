package app.poderes;

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

        int saludDisminuida = 1;

        if (artefacto instanceof Horrocrux) { //Refactorizar??
            saludDisminuida = 0;

        } else {

            System.out.println("\nTu artefacto es una Reliquia de la Muerte. Tu enemigo pierde un punto de salud.\n");

        }

        int saludRestante = personaje.getSalud()
                - (this.nivelDanio + this.activarDanioDeArtefacto(artefacto) - saludDisminuida);

        personaje.setSalud(saludRestante);

        System.out.println("Tu artefacto " + artefacto.getNombre() + " genera un daño adicional de "
                + this.activarDanioDeArtefacto(artefacto) + " puntos. ");

    }

    public int activarDanioDeArtefacto(Artefacto artefacto) {
        return (int) (this.nivelDanio * artefacto.getAmplificadorDeDanio());

    }

    public int activarCuracionDeArtefacto(double amplificadorDeCuracion) {
        return (int) (this.nivelCuracion * amplificadorDeCuracion);

    }

    public void curar(Wizard wizard) {

        int saludAumentada = wizard.getSalud() + this.nivelCuracion
                + this.activarCuracionDeArtefacto(wizard.getArtefacto().getAmplificadorDeCuracion());

        wizard.setSalud(saludAumentada);

        System.out.println("Tu artefacto " + wizard.getArtefacto().getNombre() + " genera una curación adicional de "
                + this.activarCuracionDeArtefacto(wizard.getArtefacto().getAmplificadorDeCuracion()) + " puntos. ");

    }

    public void curar(Elfo elfo) {

        int saludAumentada = elfo.getSalud() + this.nivelCuracion
                + this.activarCuracionDeArtefacto(elfo.getArtefacto().getAmplificadorDeCuracion());

        elfo.setSalud(saludAumentada);

        System.out.println("Tu artefacto " + elfo.getArtefacto().getNombre() + " genera una curación adicional de "
                + this.activarCuracionDeArtefacto(elfo.getArtefacto().getAmplificadorDeCuracion()) + " puntos. ");

    }

}