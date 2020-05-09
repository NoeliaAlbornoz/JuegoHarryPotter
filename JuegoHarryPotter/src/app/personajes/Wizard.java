package app.personajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app.IHaceMagia;
import app.Minijuego;
import app.artefactos.Artefacto;
import app.poderes.Hechizo;
import app.poderes.Poder;
import app.poderes.SectumSempra;
import app.transportes.Escoba;

public class Wizard extends Persona implements IHaceMagia {

    public Random rand = new Random(System.nanoTime());

    private int energiaMagica;
    private List<Hechizo> hechizos = new ArrayList<>();
    private Escoba escoba;
    private Poder poderInicial;
    private Artefacto artefacto;
    private boolean magoOscuro;

    public Wizard(String nombre, int salud, int energiaMagica) {
        super(nombre, salud);
        this.energiaMagica = energiaMagica;

    }

    public int getEnergiaMagica() {
        return energiaMagica;
    }

    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public Escoba getEscoba() {
        return escoba;
    }

    public void setEscoba(Escoba escoba) {
        this.escoba = escoba;
    }

    public Poder getPoderInicial() {
        return poderInicial;
    }

    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    }

    public Artefacto getArtefacto() {
        return artefacto;
    }

    public void setArtefacto(Artefacto artefacto) {
        this.artefacto = artefacto;
    }

    public boolean isMagoOscuro() {
        return magoOscuro;
    }

    public void setMagoOscuro(boolean magoOscuro) {
        this.magoOscuro = magoOscuro;
    }

    @Override
    public void setPoder(Poder poder) {

        this.artefacto.setPoder(poder);

    }

    @Override
    public void aprender(Hechizo h) {

        this.hechizos.add(h);

        System.out.println("Has aprendido el hechizo " + h.getNombre());

    }

    public void jugarMinijuegos(Hechizo hechizo, Wizard wizard) {

        Random rand = new Random(System.nanoTime());

        int numero1 = rand.nextInt(100);
        int numero2 = rand.nextInt(100);

        Minijuego minijuego = hechizo.getMinijuego();

        minijuego.mostrarConsignaGeneral();

        minijuego.iniciarMinijuegos(hechizo, numero1, numero2, wizard);

    }

    public void mostrarMensajeDeMiniJuegos() {
        System.out
                .println("Al profesor Flitwick no le gustará esto! Restas un punto de energia mágica. \nEnergía Mágica "
                        + this.energiaMagica);

    }

    public void mostrarEnergiaMagica() {

        System.out
                .println("Tu calificación en esta clase es una +S. Sumas un punto de energia mágica. \nEnergía Mágica "
                        + this.energiaMagica);

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {

        if (this.energiaMagica <= 0) {
            return;
        }

        hechizo = this.confirmarHechizoOscuro(personaje, hechizo);

        System.out.print(
                hechizo.getNombre() + " te ha consumido " + hechizo.getEnergiaMagica() + " puntos de energía mágica.");

        this.decrementarEnergiaMagica(hechizo.getEnergiaMagica());

        hechizo.disminuirSalud(personaje, artefacto);

    }

    public Hechizo confirmarHechizoOscuro(Personaje personaje, Hechizo hechizo) {

        if (hechizo.isEsOscuro() && this.magoOscuro == false) {

            SectumSempra s = new SectumSempra();

            Hechizo h1 = this.hechizos.get(1);

            h1 = s;

            h1.setNivelDanio(hechizo.multiplicarDanioHechizoOscuro());

            h1.setNivelCuracion(hechizo.multiplicarCuracionHechizoOscuro());

            this.magoOscuro = true;

            h1.setEsOscuro(false);

            this.atacar(personaje, hechizo.getNombre());

            System.out.println("Sectumsempra es un hechizo oscuro. Su daño y curación se multiplican por 2. "
                    + this.getNombre() + " es ahora un mago oscuro.");

            return h1;

        }

        this.atacar(personaje, hechizo.getNombre());

        return hechizo;

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {

        System.out.println(this.getNombre() + " ha atacado con " + hechizo);

    }

    public int decrementarEnergiaMagica(int decremento) {

        if (decremento >= this.energiaMagica) {

            return this.energiaMagica = 0;

        }
        return this.energiaMagica -= decremento;

    }

    public int incrementarEnergiaMagica(int incremento) {

        if (this.energiaMagica + incremento >= 150) {

            return this.energiaMagica = 150;

        }
        return this.energiaMagica += incremento;

    }

}