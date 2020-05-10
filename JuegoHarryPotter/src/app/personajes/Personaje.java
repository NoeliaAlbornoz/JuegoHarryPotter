package app.personajes;

import java.util.Random;
import java.util.Scanner;

public abstract class Personaje {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static Scanner Teclado = new Scanner(System.in);

    private String nombre;
    private int salud;
    private int edad;
    private String casaHowarts;

    public Personaje(String nombre, int salud) {
        this.nombre = nombre;
        this.salud = salud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCasaHowarts() {
        return casaHowarts;
    }

    public void setCasaHowarts(String casaHowarts) {
        this.casaHowarts = casaHowarts;
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    public int tirarDado() {

        System.out.println(ANSI_PURPLE + "Dado mágico:" + ANSI_RESET + "(ENTER)");

        Random rand = new Random(System.nanoTime());

        Teclado.nextLine();

        return rand.nextInt(10);

    }

    public int decrementarSalud(int danio) {

        if (danio >= this.salud) {

            return this.salud = 0;

        }
        return this.salud -= danio;

    }

    public int aumentarSalud(int curacion) {

        if (this.salud + curacion >= 100) {

            return this.salud = 100;

        }
        return this.salud += curacion;

    }

    public boolean esWizard() {

        return this instanceof Wizard;
        
    }

    public boolean esElfo() {

        return this instanceof Elfo;
    }

}