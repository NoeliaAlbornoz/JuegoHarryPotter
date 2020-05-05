package app.personajes;

import app.IEsMagico;

public abstract class Criatura extends Personaje implements IEsMagico{

    @Override
    public boolean esInvisibleAMuggles() {
       
        return false;
    }

    @Override
    public boolean esInvisible() {
       
        return false;
    }

}