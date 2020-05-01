package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.personajes.Personaje;
import app.personajes.Wizard;
import app.poderes.Hechizo;
import app.poderes.Poder;
import app.transportes.Escoba;

public class JuegoHP {

    public static Scanner Teclado = new Scanner(System.in);

    public List<Personaje> personaje = new ArrayList<>();

    public List<Hechizo> hechizos = new ArrayList<>();

    public void inicializarJuego() {
        this.inicializarPersonajes();
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
        this.personaje.add(wizard);

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
        this.personaje.add(wizard);

    }

}