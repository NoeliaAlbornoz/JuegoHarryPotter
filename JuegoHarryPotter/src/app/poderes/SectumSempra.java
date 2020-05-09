package app.poderes;

import app.Minijuego;

public class SectumSempra extends HechizoAtaque {

    public SectumSempra(){
        this.setNombre("Sectumsempra");
        this.setDescripcion("La maldición Sectumsempra genera cortes profundos en la víctima");
        this.setEnergiaMagica(6);
        this.setNivelDanio(6);
        this.setNivelCuracion(1);
        this.setEsOscuro(true);

        Minijuego minijuego = new Minijuego("Resta Mágica.");
        minijuego.setDescripcion("Si resuelves con exito la resta, ganas un punto de energía mágica. Si fallas, lo pierdes y aprendes el hechizo con dificultades.");
        this.setMinijuego(minijuego);

    }

    public SectumSempra(String nombre) {
        super(nombre);
    }

}