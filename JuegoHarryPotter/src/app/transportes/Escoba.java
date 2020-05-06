package app.transportes;

import app.IEsMagico;

public class Escoba extends Transporte implements IEsMagico{

    @Override
    public boolean esInvisibleAMuggles() {
        return getVelocidad() < 160;
    }

    @Override
    public boolean esInvisible() {
        return getVelocidad() >= 160;
    }

}