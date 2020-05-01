package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.personajes.Elfo;
import app.personajes.Personaje;
import app.personajes.Wizard;
import app.poderes.Hechizo;
import app.poderes.Poder;
import app.transportes.Escoba;

public class JuegoHP {

    public static Scanner Teclado = new Scanner(System.in);

    public List<Personaje> personajes = new ArrayList<>();

    public List<Hechizo> hechizos = new ArrayList<>();

    public void inicializarJuego() {

        this.inicializarPersonajes();
        this.inicializarHechizos();

    }

    public void start() {

        Personaje jugador1 = this.seleccionarPersonaje();

        Personaje jugador2 = this.seleccionarPersonaje();

        bannerAprenderHechizos();

        Hechizo h = this.seleccionarHechizo();

        this.aprenderSegunPersonaje(jugador1, h);

    }

    public void inicializarPersonajes() {
        Wizard wizard = new Wizard();
        wizard.setNombre("Harry Potter");
        wizard.setEnergiaMagica(150);
        wizard.setSalud(100);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        Poder poder = new Poder("ParseTongue");
        poder.setDescripcion("El Parse es la legua de las serpientes y de aquellos que pueden hablar con ellas");
        wizard.setPoder(poder);

        Escoba escoba = new Escoba();
        escoba.setNombre("Nimbus 2000");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        this.personajes.add(wizard);

        wizard = new Wizard();
        wizard.setNombre("Ron Weasley");
        wizard.setEnergiaMagica(150);
        wizard.setSalud(100);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poder = new Poder("Metamorfosis");
        poder.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro");
        wizard.setPoder(poder);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2000 ");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        this.personajes.add(wizard);

    }

    public void inicializarHechizos() {

        Hechizo hechizo = new Hechizo("Wingwardum Leviosa");
        hechizo.setDescripcion("Wingwardum Leviosa es un hechizo que permite levitar objetos o pequeños seres vivos.");
        hechizo.setEnergiaMagica(20);
        hechizo.setNivelDanio(20);
        hechizo.setEsOscuro(false);

        this.hechizos.add(hechizo);

        hechizo = new Hechizo("Sectumsempra");
        hechizo.setDescripcion("La maldición Sectumsempra genera cortes profundos en la víctima.");
        hechizo.setEnergiaMagica(50);
        hechizo.setNivelDanio(50);
        hechizo.setEsOscuro(false);

        this.hechizos.add(hechizo);
    }

    public Personaje seleccionarPersonaje() {

        int i = 0;

        System.out.print("Elegir personaje: ");

        for (Personaje per : this.personajes) {
            System.out.print(" " + (++i) + "-" + per.getNombre());
        }

        System.out.println();

        i = Teclado.nextInt();

        return this.personajes.get(--i);

    }

    public Hechizo seleccionarHechizo() {

        int i = 0;

        for (Hechizo hechizo : this.hechizos) {
            System.out.print(" " + (++i) + "-" + hechizo.getNombre());
        }

        System.out.println();

        i = Teclado.nextInt();

        return this.hechizos.get(--i);

    }

    public void aprenderSegunPersonaje(Personaje jugador1, Hechizo h) {

        if (jugador1 instanceof Wizard) {
            Wizard wizard = (Wizard) jugador1;
            wizard.aprender(h);

        } else if (jugador1 instanceof Elfo) {

        } 

    }

    public static void bannerAprenderHechizos() {

        System.out.println("\n Debes aprender tus hechizos. ");
        System.out.println("  ¿Cuál quieres entrenar?: \n");
        System.out.println("Elegir hechizo: ");

    }

    public static void bannerAtacarConHechizos() {

        System.out.println("\nDebes elegir un hechizo para atacar a tu oponente: \n");

    }

}