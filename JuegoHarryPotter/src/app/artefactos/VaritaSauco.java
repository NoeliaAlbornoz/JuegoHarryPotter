package app.artefactos;

import app.IReliquiaMuerte;

public class VaritaSauco extends Varita implements IReliquiaMuerte {

    public VaritaSauco(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esReliquiaMuerte() {
      
        return true;
    }

    @Override
    public boolean esInvisibleAMuggles(){
        return this.getPoder().getNivelDePoder() == 0;
    }

    @Override
    public boolean esInvisible(){
        return this.getPoder().getNivelDePoder() > 7;
    }

}