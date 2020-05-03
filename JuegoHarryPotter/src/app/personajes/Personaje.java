package app.personajes;

import java.util.Random;
import java.util.Scanner;

public abstract class Personaje {

    public static Scanner Teclado = new Scanner(System.in);

    private String nombre;
    private int salud;
    private int edad;

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

    public boolean estaVivo() {
        return salud > 0;
    }

    public void disminuirSalud(int danio) {

        int saludRestante = this.getSalud() - danio;

        this.setSalud(saludRestante);

    }

    public int tirarDado() {
        System.out.print("Dado mágico: ");

        Random rand = new Random(System.nanoTime());

        Teclado.nextLine();

        return rand.nextInt(10);

    }

}