package app.personajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app.IHaceMagia;
import app.artefactos.Artefacto;
import app.poderes.Hechizo;
import app.poderes.Poder;
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
        

    }

    @Override
    public void aprender(Hechizo h) {

        this.jugarMinijuegos(h);

        this.hechizos.add(h);

        System.out.println("Has aprendido el hechizo " + h.getNombre());

    }

    private void jugarMinijuegos(Hechizo hechizo) {

        Random rand = new Random(System.nanoTime());

        int numero1 = rand.nextInt(100);
        int numero2 = rand.nextInt(100);

        System.out.println(
                        "Resuelve el acertijo para obtener tu recompensa y aprender correctamente el hechizo.");

        switch (hechizo.getNombre()) {

            case "Wingwardum Leviosa":

                System.out.print("Resolver: " + numero1 + "+" + numero2 + "= ");

                int resultado = Teclado.nextInt();

                if (resultado == numero1 + numero2) {

                    this.energiaMagica++;

                    this.mostrarEnergiaMagica();

                } else {

                    this.energiaMagica--;

                    System.out.println(
                            "Al profesor Flitwick de Encantamientos no le gustará esto! Restas un punto de energia mágica. \nEnergía Mágica "
                                    + this.energiaMagica);

                }

                break;

            case "Sectumsempra":

                System.out.print("Resolver: " + numero1 + "-" + numero2 + "= ");

                resultado = Teclado.nextInt();

                if (resultado == numero1 - numero2) {

                    this.energiaMagica++;

                    this.mostrarEnergiaMagica();

                } else {

                    this.energiaMagica--;

                    System.out.println(
                            "Al profesor Snape de Defensa contra las Artes Oscuras no le gustará esto! Restas un punto de energia mágica. \nEnergía Mágica "
                                    + this.energiaMagica);

                }

                break;

            case "Vulnera Sanentur":

                System.out.print("Resolver: " + numero1 + " * " + numero2 + "= ");

                resultado = Teclado.nextInt();

                if (resultado == numero1 * numero2) {

                    this.energiaMagica++;

                    this.mostrarEnergiaMagica();

                } else {

                    --this.energiaMagica;

                    System.out.println(
                            "Al profesor Snape de Defensa contra las Artes Oscuras no le gustará esto! Restas un punto de energia mágica. \nEnergía Mágica "
                                    + this.energiaMagica);

                }

                break;

            case "Cavelnimicum":

                int numero3 = rand.nextInt(100);

                System.out.print("Resolver: " + numero1 + " * " + numero2 + " + " + numero3 + "= ");

                resultado = Teclado.nextInt();

                if (resultado == numero1 * numero2 + numero3) {

                    this.energiaMagica++;

                    this.mostrarEnergiaMagica();

                } else {

                    this.energiaMagica--;

                    System.out.println(
                            "A la profesora McGonagall de Transformaciones no le gustará esto! Restas un punto de energia mágica. \nEnergía Mágica "
                                    + this.energiaMagica);

                }

                break;

        }

    }

    public void mostrarEnergiaMagica(){

        System.out.println(
                            "Tu calificación en esta clase es una +S. Sumas un punto de energia mágica. \nEnergía Mágica "
                                    + this.energiaMagica);

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {

        if(this.energiaMagica <= 0){
            return;
        }
         
        this.confirmarHechizoOscuro(hechizo);

        hechizo.disminuirEnergiaMagica(energiaMagica);

        hechizo.disminuirSalud(personaje, artefacto);

        this.atacar(personaje, hechizo.getNombre());

    }

    public void confirmarHechizoOscuro(Hechizo hechizo) {

        if (hechizo.isEsOscuro() && this.magoOscuro == false) {

            int nuevoDanio = hechizo.getNivelDanio() * 2;
            hechizo.setNivelDanio(nuevoDanio);

            int nuevoCuracion = hechizo.getNivelCuracion() * 2;
            hechizo.setNivelCuracion(nuevoCuracion);

            this.magoOscuro = true;

            hechizo.setEsOscuro(false);

            System.out.println("Sectumsempra es un hechizo oscuro. Su daño y curación se multiplican por 2."
                    + this.getNombre() + " es ahora un mago oscuro.");

        }

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {

        System.out.println("Has atacado con " + hechizo);

        System.out.println("Te quedan " + this.energiaMagica + " puntos de energía mágica.");

    }

    public int decrementarEnergiaMagica(int decremento) {

        if (decremento >= this.energiaMagica) {

            return 0;

        }
        return this.energiaMagica -= decremento;
        
    }

    public int incrementarEnergiaMagica(int incremento) {

        if (this.energiaMagica + incremento >= 100) {

            return 150;

        }
        return this.energiaMagica += incremento;

    }

}