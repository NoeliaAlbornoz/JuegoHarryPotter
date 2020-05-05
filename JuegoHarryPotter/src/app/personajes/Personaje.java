package app.personajes;

import java.util.Random;
import java.util.Scanner;

import app.artefactos.Artefacto;
import app.poderes.Hechizo;

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

    public void disminuirSalud(Hechizo hechizo, Artefacto artefacto) {

        int saludRestante = this.getSalud() - (hechizo.getNivelDanio() + this.utilizarDanioDeArtefacto(hechizo, artefacto));

        this.setSalud(saludRestante);

    }

    public int tirarDado() {
        System.out.print("Dado mágico: ingrese enter para arrojar el dado ");

        Random rand = new Random(System.nanoTime());

        Teclado.nextLine();

        return rand.nextInt(10);

    }

    public int utilizarDanioDeArtefacto(Hechizo hechizo, Artefacto artefacto){
        return (int) (hechizo.getNivelDanio() * artefacto.getAmplificadorDeDanio());
        
    }

    public int utilizarCuracionDeArtefacto(Hechizo hechizo, Artefacto artefacto){
        return (int) (hechizo.getNivelCuracion() * artefacto.getAmplificadorDeCuracion());
    }

}