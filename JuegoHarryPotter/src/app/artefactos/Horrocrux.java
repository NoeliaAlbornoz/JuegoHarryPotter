package app.artefactos;

import app.IReliquiaMuerte;

public class Horrocrux extends Artefacto implements IReliquiaMuerte {

    public Horrocrux(String nombre) {
        super(nombre);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean esReliquiaMuerte() {
        
        return false;
    }

    @Override
    public boolean esInvisibleAMuggles(){
        return false;
    }

    @Override
    public boolean esInvisible(){
        return false;
    }

}