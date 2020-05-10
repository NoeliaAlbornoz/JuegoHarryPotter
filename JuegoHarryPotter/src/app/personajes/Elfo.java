package app.personajes;

import java.util.ArrayList;
import java.util.List;

import app.IHaceMagia;
import app.artefactos.Artefacto;
import app.poderes.Hechizo;
import app.poderes.Poder;

public class Elfo extends Criatura implements IHaceMagia {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private int energiaMagica;
    private Artefacto artefacto;
    private List<Hechizo> hechizos = new ArrayList<>();
    private Poder poderInicial;

    public Elfo(String nombre, int salud, int energiaMagica) {
        super(nombre, salud);
        this.energiaMagica = energiaMagica;

    }

    public int getEnergiaMagica() {
        return energiaMagica;
    }

    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }

    public Artefacto getArtefacto() {
        return artefacto;
    }

    public void setArtefacto(Artefacto artefacto) {
        this.artefacto = artefacto;
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public Poder getPoderInicial() {
        return poderInicial;
    }

    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    }

    @Override
    public void setPoder(Poder poder) {

       poder.setNivelDePoder(this.acumularPuntosCanje(this.artefacto.getPoder().getNivelDePoder())); 

       this.artefacto.setPoder(poder);
        
    }

    @Override
    public void aprender(Hechizo h) {

        this.obtenerEdadMagica();

        this.hechizos.add(h);

        System.out.println("Has aprendido el hechizo " + ANSI_RED + h.getNombre() + ANSI_RESET);

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {

        this.decrementarEnergiaMagica(hechizo.getEnergiaMagica());

        hechizo.disminuirSalud(personaje, artefacto);

        this.atacar(personaje, hechizo.getNombre());
    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {

        this.setPoder(this.artefacto.getPoder());

        System.out.print("Tu artefacto " + ANSI_RED + this.artefacto.getNombre() + ANSI_RESET + " tiene el poder de " + ANSI_PURPLE + this.artefacto.getPoder().getNombre() + ANSI_RESET
                + " que te otorga " + this.artefacto.getPoder().getNivelDePoder()+ " puntos de poder, acumulables para reclamar un premio al final del juego. (No dañan ni curan).\n");

        System.out.println("\n" + ANSI_BLUE + this.getNombre() + ANSI_RESET + " ha atacado con " + ANSI_BLUE + hechizo + ANSI_RESET + "\n");
    }

    public void mostrarConsignaMinijuego() {

        System.out.println("\nPuedes saber la edad de tu elfo al tirar el dado mágico.");
        System.out.println("Si su edad es mayor o igual a 2 pero menor a 5" + ANSI_RESET + " , será capaz de invisibilizarse frente a muggles y ganas 1 punto de energía mágica.");
        System.out.println("Si su edad es mayor o igual a 5 pero menor o igual a 10" + ANSI_RESET + " , es invisible también a los magos y ganas 3 puntos de energía mágica.\n");

    }

    public void obtenerEdadMagica() {

        this.mostrarConsignaMinijuego();

        int dado = this.tirarDado();

        this.setEdad(dado);
        System.out.println("Has sacado un " + ANSI_YELLOW + dado + ANSI_RESET);

        if (this.esInvisibleAMuggles()) {

            this.incrementarEnergiaMagica(1);

            this.mostrarMensajeEdad();

        } else if (this.esInvisible()) {

            this.incrementarEnergiaMagica(3);

            this.mostrarMensajeEdad();

        } else {

            System.out.println("Tu elfo es demasiado joven para poder aumentar su energía mágica.");
        }

    }

    public void mostrarMensajeEdad() {

        System.out.println(ANSI_BLUE + this.getNombre() + ANSI_RESET + " tiene " + this.getEdad() + " años de edad.");

        System.out.println(ANSI_CYAN + "Energía Mágica " + this.getEnergiaMagica() + ANSI_RESET);

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

    public int acumularPuntosCanje(int puntosPoder){

        return puntosPoder += 3;

    }

}