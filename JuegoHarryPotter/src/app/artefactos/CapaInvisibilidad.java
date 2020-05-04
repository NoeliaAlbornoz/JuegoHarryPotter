package app.artefactos;

import app.IReliquiaMuerte;

public class CapaInvisibilidad extends Artefacto implements IReliquiaMuerte {

    public CapaInvisibilidad(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esReliquiaMuerte() {
        
        return false;
    }

}