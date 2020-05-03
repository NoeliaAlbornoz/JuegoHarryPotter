package app.transportes;

import app.IEsMagico;

public class TrenExpresoHowards extends Transporte implements IEsMagico{

    @Override
    public boolean esInvisibleAMuggles() {

        return getVelocidad() <= 3;
    }

    @Override
    public boolean esInvisible() {

        return getVelocidad() == 10;
    }

}