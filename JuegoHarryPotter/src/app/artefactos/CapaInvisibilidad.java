package app.artefactos;

import app.IReliquiaMuerte;

public class CapaInvisibilidad extends Artefacto implements IReliquiaMuerte {

    @Override
    public boolean esReliquiaMuerte() {
        
        return false;
    }

}