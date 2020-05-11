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

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";


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

        System.out.println("Has aprendido el hechizo " + ANSI_RED + h.getNombre() + ANSI_RESET);

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

        System.out.println("Al profesor Flitwick no le gustará esto! Restas un punto de energia mágica.");

        System.out.println(ANSI_CYAN + "Energía Mágica " + this.energiaMagica + ANSI_RESET);

    }

    public void mostrarEnergiaMagica() {

        System.out.println("Tu calificación en esta clase es una +S. Sumas un punto de energia mágica.");

        System.out.println(ANSI_CYAN + "Energía Mágica " + this.energiaMagica + ANSI_RESET);

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {

        hechizo = this.confirmarHechizoOscuro(personaje, hechizo);

        hechizo.curar(this);

        hechizo.curarEnemigo(personaje);

        this.decrementarEnergiaMagica(hechizo.getEnergiaMagica());

        hechizo.disminuirSalud(personaje, artefacto);

    }

    public Hechizo confirmarHechizoOscuro(Personaje personaje, Hechizo hechizo) {

        if (hechizo.isEsOscuro() && this.magoOscuro == false) {

            SectumSempra h1 = new SectumSempra();

            h1.setNivelDanio(hechizo.multiplicarDanioHechizoOscuro());

            h1.setNivelCuracion(hechizo.multiplicarCuracionHechizoOscuro());

            this.magoOscuro = true;

            h1.setEsOscuro(false);

            this.atacar(personaje, hechizo.getNombre());

            this.mostrarMensajeHechizoOscuro(h1);

            return h1;

        }

        this.atacar(personaje, hechizo.getNombre());

        System.out.println(ANSI_YELLOW + hechizo.getNombre() + ANSI_RESET + " te ha consumido "
                + hechizo.getEnergiaMagica() + " puntos de Energía Mágica.");

        hechizo.setNivelDanio(rand.nextInt(10));

        hechizo.setNivelCuracion(rand.nextInt(5));

        return hechizo;

    }

    public void mostrarMensajeHechizoOscuro(Hechizo h1) {

        System.out.print(ANSI_RED + "\nSectumsempra" + ANSI_RESET
                + " es un hechizo oscuro. Su daño y curación se multiplican por 2 (única vez).");
        System.out.println(ANSI_RED + " Daño " + ANSI_RESET + h1.getNivelDanio() + ANSI_RED + " Curación " + ANSI_RESET
                + h1.getNivelCuracion());
        System.out.println(ANSI_BLUE + this.getNombre() + ANSI_RESET + " es ahora un mago oscuro.");
        System.out.print(ANSI_RED + "Daño artefacto " + ANSI_RESET + h1.activarDanioDeArtefacto(this.artefacto));
        System.out.println(ANSI_RED + " Curación artefacto " + ANSI_RESET 
                + h1.activarCuracionDeArtefacto(this.artefacto.getAmplificadorDeCuracion())+ "\n");
        System.out.println(ANSI_YELLOW + h1.getNombre() + ANSI_RESET + " te ha consumido " + h1.getEnergiaMagica()
                + " puntos de Energía Mágica.");

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {

        System.out.println("\n" + ANSI_BLUE + this.getNombre() + ANSI_RESET + " ha atacado con " + ANSI_BLUE + hechizo
                + ANSI_RESET + "\n");

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

    public int seleccionarOpcionComprar(int opcion, Wizard wizard) {

        System.out.println(ANSI_YELLOW + "¡Bienvenido al Callejón Diagon!" + ANSI_RESET
                + " Tienes que cambiar tu escoba vieja por una nueva.");
        System.out.println("Gastarás puntos de salud pero ganarás energía mágica.");
        System.out.println("¿Deseas comprar una escoba nueva?" + ANSI_YELLOW + " 1)Sí 2)No" + ANSI_RESET);

        return Teclado.nextInt();

    }

}