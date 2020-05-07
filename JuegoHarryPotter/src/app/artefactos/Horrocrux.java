package app.artefactos;

import app.IReliquiaMuerte;

public class Horrocrux extends Artefacto implements IReliquiaMuerte {

    public Horrocrux(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esReliquiaMuerte() {

        return false;
    }

    @Override
    public boolean esInvisibleAMuggles() {
        return this.getPoder().getNivelDePoder() == 4;
    }

    @Override
    public boolean esInvisible() {
        return this.getPoder().getNivelDePoder() != 4;
    }

}