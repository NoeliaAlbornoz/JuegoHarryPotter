package app.transportes;

import app.IEsMagico;

public class TrenExpresoHowards extends Transporte implements IEsMagico{

    @Override
    public boolean esInvisibleAMuggles() {

        return getVelocidad() <= 5;
    }

    @Override
    public boolean esInvisible() {

        return getVelocidad() == 10;
    }

}