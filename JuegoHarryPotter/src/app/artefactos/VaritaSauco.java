package app.artefactos;

import app.IReliquiaMuerte;

public class VaritaSauco extends Varita implements IReliquiaMuerte {

    public VaritaSauco(String nombre) {
        super(nombre);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean esReliquiaMuerte() {
      
        return true;
    }

    @Override
    public boolean esInvisibleAMuggles(){
        return false;
    }

    @Override
    public boolean esInvisible(){
        return true;
    }

}