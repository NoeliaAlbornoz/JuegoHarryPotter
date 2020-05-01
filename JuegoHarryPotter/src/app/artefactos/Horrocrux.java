package app.artefactos;

import app.IReliquiaMuerte;

public class Horrocrux extends Artefacto implements IReliquiaMuerte {

    @Override
    public boolean esReliquiaMuerte() {
        
        return false;
    }

}