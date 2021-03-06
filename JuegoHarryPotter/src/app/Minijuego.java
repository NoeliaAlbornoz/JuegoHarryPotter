package app;

import java.util.Random;
import java.util.Scanner;

import app.personajes.Wizard;
import app.poderes.Hechizo;

public class Minijuego {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static Scanner Teclado = new Scanner(System.in);
    public Random rand = new Random(System.nanoTime());

    private String nombre;
    private String descripcion;

    public Minijuego(String nombre) {
        this.nombre = nombre;
    }

    public void iniciarMinijuegos(Hechizo hechizo, int numero1, int numero2, Wizard wizard) {

        int numero3 = rand.nextInt(100);

        switch (hechizo.getNombre()) {

            case "Wingwardum Leviosa":

                this.mostrarConsignaMinijuego(hechizo, wizard);

                System.out.print(numero1 + " + " + numero2 + " = ");

                int resultado = Teclado.nextInt();

                if (resultado == hechizo.getMinijuego().sumar(numero1, numero2)) {

                    wizard.incrementarEnergiaMagica(1);

                    wizard.mostrarEnergiaMagica();

                } else {

                    wizard.decrementarEnergiaMagica(1);

                    wizard.mostrarMensajeDeMiniJuegos();

                }
                break;

            case "Sectumsempra":

                this.mostrarConsignaMinijuego(hechizo, wizard);

                System.out.print(numero1 + " - " + numero2 + " = ");

                resultado = Teclado.nextInt();

                if (resultado == hechizo.getMinijuego().restar(numero1, numero2)) {

                    wizard.incrementarEnergiaMagica(1);

                    wizard.mostrarEnergiaMagica();

                } else {

                    wizard.decrementarEnergiaMagica(1);

                    wizard.mostrarMensajeDeMiniJuegos();

                }

                break;

            case "Vulnera Sanentur":

                this.mostrarConsignaMinijuego(hechizo, wizard);

                System.out.print(numero1 + " x " + numero2 + " = ");

                resultado = Teclado.nextInt();

                if (resultado == hechizo.getMinijuego().multiplicar(numero1, numero2)) {

                    wizard.incrementarEnergiaMagica(1);

                    wizard.mostrarEnergiaMagica();

                } else {

                    wizard.decrementarEnergiaMagica(1);

                    wizard.mostrarMensajeDeMiniJuegos();

                }

                break;

            case "Cavelnimicum":

                this.mostrarConsignaMinijuego(hechizo, wizard);

                System.out.print(numero1 + " x " + numero2 + " + " + numero3 + " = ");

                resultado = Teclado.nextInt();

                if (resultado == hechizo.getMinijuego().calcularCombinado(numero1, numero2, numero3)) {

                    wizard.incrementarEnergiaMagica(1);

                    wizard.mostrarEnergiaMagica();

                } else {

                    wizard.decrementarEnergiaMagica(1);

                    wizard.mostrarMensajeDeMiniJuegos();

                }

                break;

        }

    }

    public void mostrarConsignaGeneral() {

        System.out.println("Para aprender el hechizo debes resolver un cálculo mágico.\n");

    }

    public void mostrarConsignaMinijuego(Hechizo hechizo, Wizard wizard) {

        System.out.println(ANSI_CYAN + "Energía Mágica " + wizard.getEnergiaMagica() + "\n");

        System.out.println(ANSI_RED + hechizo.getMinijuego().getNombre() + ANSI_RESET + " " + hechizo.getMinijuego().getDescripcion());

    }

    public int sumar(int numero1, int numero2) {

        return numero1 + numero2;
    }

    public int restar(int numero1, int numero2) {

        return numero1 - numero2;
    }

    public int multiplicar(int numero1, int numero2) {

        return numero1 * numero2;
    }

    public int calcularCombinado(int numero1, int numero2, int numero3) {

        return numero1 * numero2 + numero3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}