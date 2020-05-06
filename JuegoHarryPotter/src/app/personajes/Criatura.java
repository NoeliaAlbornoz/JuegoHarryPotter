package app.personajes;

import app.IEsMagico;

public abstract class Criatura extends Personaje implements IEsMagico{

    public Criatura(String nombre, int salud) {
        super(nombre, salud);
    }

    @Override
    public boolean esInvisibleAMuggles() {
        return getEdad()  >= 2 && getEdad() < 5;
    }

    @Override
    public boolean esInvisible() {
       
        return getEdad() >= 5 && getEdad() <= 10;
    }

}