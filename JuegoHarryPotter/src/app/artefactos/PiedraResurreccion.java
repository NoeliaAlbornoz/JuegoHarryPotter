package app.artefactos;

import app.IReliquiaMuerte;

public class PiedraResurreccion extends Artefacto implements IReliquiaMuerte{

    public PiedraResurreccion(String nombre) {
        super(nombre);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

    @Override
    public boolean esInvisibleAMuggles(){
        return true;
    }

    @Override
    public boolean esInvisible(){
        return true;
    }

}