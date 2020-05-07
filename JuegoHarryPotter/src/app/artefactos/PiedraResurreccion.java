package app.artefactos;

import app.IReliquiaMuerte;

public class PiedraResurreccion extends Artefacto implements IReliquiaMuerte{

    public PiedraResurreccion(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

    @Override
    public boolean esInvisibleAMuggles(){
        return this.getPoder().getNivelDePoder() < 2;
    }

    @Override
    public boolean esInvisible(){
        return this.getPoder().getNivelDePoder() > 5;
    }

}