package app.artefactos;

import app.IReliquiaMuerte;

public class PiedraResurreccion extends Artefacto implements IReliquiaMuerte{

    @Override
    public boolean esReliquiaMuerte() {
    
        return false;
    }

}