package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import app.artefactos.CapaInvisibilidad;
import app.artefactos.Horrocrux;
import app.artefactos.PiedraResurreccion;
import app.artefactos.VaritaSauco;
import app.personajes.Elfo;
import app.personajes.Muggle;
import app.personajes.Personaje;
import app.personajes.Wizard;
import app.poderes.Cavelnimicum;
import app.poderes.Hechizo;
import app.poderes.Poder;
import app.poderes.SectumSempra;
import app.poderes.VulneraSanentur;
import app.poderes.WingwardumLeviosa;
import app.transportes.Escoba;
import app.transportes.TrenExpresoHowards;

public class JuegoHP {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static Scanner Teclado = new Scanner(System.in);
    public static Random rand = new Random(System.nanoTime());
    public List<Personaje> personajes = new ArrayList<>();
    public List<Hechizo> hechizos = new ArrayList<>();

    public void inicializarJuego() {

        this.inicializarPersonajes();

        this.inicializarHechizos();

    }

    public void start() {

        bannerTorneo();

        System.out.println(ANSI_CYAN + "JUGADOR 1 \n" + ANSI_RESET);

        Personaje jugador1 = this.seleccionarPersonaje();

       this.iniciarPrimeraEtapa(jugador1);

        System.out.println(ANSI_CYAN + "JUGADOR 2 \n" + ANSI_RESET);

        Personaje jugador2 = this.seleccionarPersonaje();

        this.iniciarPrimeraEtapa(jugador2);

        bannerViajeTren();

        this.arrancarTren(jugador1, jugador2);

        bannerHowarts();

        int jugada = 1;

        while (jugada < 9) { //podía dinamizarse comparando los size de las listas de hechizos

            if (jugada % 2 != 0) { //otra forma era con boolean

                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------\n");

                bannerJugador1(jugador1);

                bannerAprenderHechizos();

                this.iniciarAprendizajeDeHechizos(jugador1);

            } else {

                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------\n");

                bannerJugador2(jugador2);

                bannerAprenderHechizos();

                this.iniciarAprendizajeDeHechizos(jugador2);
            }

            jugada++;

        }

        bannerComienzaBatalla();

        jugada = 1;

        while (jugador1.estaVivo() && jugador2.estaVivo()) {

            if (jugada % 2 != 0) {

                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------\n");

                bannerJugador1(jugador1);

                this.mostrarPropiedadesJugador(jugador1, jugador2);

                bannerAtacarConHechizos();

                this.iniciarAtaqueConHechizos(jugador1, jugador2);

            } else {

                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------\n");

                bannerJugador2(jugador2);

                this.mostrarPropiedadesJugador(jugador1, jugador2);

                bannerAtacarConHechizos();

                this.iniciarAtaqueConHechizos(jugador2, jugador1);

            }

            jugada++;

        }

        if (jugador1.estaVivo()) {

            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------\n");

            this.mostrarPropiedadesJugador(jugador1, jugador2);

            this.mostrarMensajeGanador(jugador1);

            this.reclamarPremio(jugador1);

        } else {

            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------\n");

            this.mostrarPropiedadesJugador(jugador1, jugador2);

            this.mostrarMensajeGanador(jugador2);

            this.reclamarPremio(jugador2);

        }

    }

    public void iniciarPrimeraEtapa(Personaje jugador){

        this.mostrarPoderInicial(jugador);

        this.comprarEscoba(jugador);

        this.molestarAlMuggle(jugador);
    }

    private void reclamarPremio(Personaje personaje) {

        System.out.println(ANSI_BLUE + "\nDumbledore" + ANSI_RESET + " te entrega un premio especial: ENTER");
        Teclado.nextLine();
        Teclado.nextLine();

        if (personaje.esWizard()) {
            this.mostrarPocion();
            System.out.println("¡Úsala bien! ¡Buena Suerte!");

        } else if (personaje.esElfo()) {
            Elfo elfi = (Elfo) personaje;
            if (elfi.getArtefacto().getPoder().getNivelDePoder() >= 50) {
                System.out.println("!Canjeaste tus puntos de poder! El profesor te obsequia 2 premios.\n");
                this.mostrarPocion();
            } else {
                System.out.println("No alcanzaste la cantidad de puntos necesaria para reclamar otro premio.");
            }

            System.out.println("¡Un calcetín mágico!");
            System.out.println("¡Eres un elfo libre! ¡Buena suerte!");

        }

    }

    public void mostrarPocion() {

        System.out.println(ANSI_RED + "FELIX FELICIS: " + ANSI_RESET
                + "Suerte Líquida. Poción que hace al bebedor un ser afortunado durante un cierto tiempo, en el cual todo aquello que intente o emprenda tendrá un resultado exitoso.");

    }

    private void bannerHowarts() {

        System.out.println(ANSI_GREEN
                + "\n***************************************************************************************************************************");
        System.out.println(
                "\n                                             ¡¡¡Bienvenido a Howarts!!!                                             \n");
        System.out.println(
                "***************************************************************************************************************************"
                        + ANSI_RESET);
        System.out.println(
                "\nPrepárate para la clase de Encantamientos del profesor Flitwick, en la que aprenderás todos los hechizos que usarás en el Torneo.");
    }

    private void bannerTorneo() {

        System.out.println("¡Este año escolar deberás prepararte para participar en el Torneo de las Cuatro Casas!");
        System.out.println(ANSI_GREEN + "\n***La aventura comienza...***\n" + ANSI_RESET);

    }

    private void bannerViajeTren() {
        System.out.println(ANSI_YELLOW
                + "Luego de realizar tus compras escolares en el Callejón Diagon, debes dirigirte a la plataforma 9 3/4 para tomar el tren que te llevará al Colegio Hogwarts de Magia y Hechicería.\n"
                + ANSI_RESET);
    }

    private void bannerComienzaBatalla() {
        System.out.println(ANSI_GREEN
                + "\n***************************************************************************************************************************");
        System.out.println(
                "\n                                             ¡¡¡COMIENZA EL DUELO!!!                                             \n");
        System.out.println(
                "***************************************************************************************************************************"
                        + ANSI_RESET);
    }

    public void mostrarPropiedadesJugador(Personaje jugador1, Personaje jugador2) {

        System.out.print(ANSI_YELLOW + jugador1.getNombre() + ANSI_RESET + ANSI_GREEN + " Salud " + ANSI_RESET
                + jugador1.getSalud() + " | ");

        System.out.println(ANSI_YELLOW + jugador2.getNombre() + ANSI_RESET + ANSI_GREEN + " Salud " + ANSI_RESET
                + jugador2.getSalud());

    }

    public void molestarAlMuggle(Personaje jugador) {

        Muggle muggle = new Muggle("Dudley Dursley", 50);
        muggle.setEdad(17);

        if (jugador.esElfo()) {

            Elfo elfi = (Elfo) jugador;

            bannerCasaDursley();

            muggle.decrementarSalud(2);

            jugador.aumentarSalud(2);

            System.out.println(ANSI_BLUE + elfi.getNombre() + ANSI_RESET
                    + " es demasiado travieso y ha molestado con un hechizo a " + ANSI_BLUE + muggle.getNombre()
                    + ANSI_RESET + " a quien le roba 2 puntos de salud.");
            System.out.println(ANSI_GREEN + "Salud " + ANSI_RESET + elfi.getSalud() + "\n");

        }

    }

    public void bannerCasaDursley() {
        System.out.println(ANSI_YELLOW
                + "Los elfos han escuchado sobre la pedantería de una familia de muggles, los Dursley, quienes odian a los seres mágicos. Antes de tomar el tren a Howarts, tu elfo se divierte infiltrándose en le casa de los Dursley y les juega una mala pasada.\n"
                + ANSI_RESET);
    }

    public Personaje seleccionarPersonaje() {

        int i = 0;

        System.out.println(ANSI_YELLOW + "Elegir personaje: \n" + ANSI_RESET);

        for (Personaje per : this.personajes) {
            System.out.println(" " + (++i) + "-" + per.getNombre());
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

    public void aprenderSegunPersonaje(Personaje jugadorAprendiz, Hechizo h) {

        if (jugadorAprendiz.esWizard()) {
            Wizard wizard = (Wizard) jugadorAprendiz;
            wizard.jugarMinijuegos(h, wizard);
            wizard.aprender(h);

        } else if (jugadorAprendiz.esElfo()) {
            Elfo elfo = (Elfo) jugadorAprendiz;
            this.mostrarEnergiaMagicaElfo(elfo);
            elfo.aprender(h);

        }

    }

    public Hechizo seleccionarHechizoParaPelear(Personaje jugadorAtacante) {

        if (jugadorAtacante.esWizard()) {
            return this.seleccionarHechizoWizard(jugadorAtacante);
        } else if (jugadorAtacante.esElfo()) {
            return this.seleccionarHechizoElfo(jugadorAtacante);
        }
        return null;
    }

    public Hechizo seleccionarHechizoWizard(Personaje jugadorAtacante) {

        int i = 0;
        Wizard wizi = null;
        if (jugadorAtacante.esWizard()) {
            wizi = (Wizard) jugadorAtacante;
            for (Hechizo hechizo : wizi.getHechizos()) {
                System.out.println((++i) + "-" + hechizo.getNombre());
            }

        }
        System.out.println();

        i = Teclado.nextInt();

        return wizi.getHechizos().get(--i);

    }

    public Hechizo seleccionarHechizoElfo(Personaje personaje) {

        int i = 0;
        Elfo elfi = null;
        if (personaje.esElfo()) {
            elfi = (Elfo) personaje;
            for (Hechizo hechizo : elfi.getHechizos()) {
                System.out.println((++i) + "-" + hechizo.getNombre());
            }
        }
        System.out.println();

        i = Teclado.nextInt();

        return elfi.getHechizos().get(--i);

    }

    public void iniciarAprendizajeDeHechizos(Personaje jugador) {

        Hechizo hechizo = this.seleccionarHechizo();
        bannerBonus();
        this.aprenderSegunPersonaje(jugador, hechizo);
    }

    public void iniciarAtaqueConHechizos(Personaje jugadorAtacante, Personaje jugadorAtacado) {

        if (jugadorAtacante.esWizard()) {
            Wizard wizard = (Wizard) jugadorAtacante;
            Hechizo hechizo = this.seleccionarHechizoParaPelear(jugadorAtacante);
            this.mostrarEnergiaMagicaWizard(wizard);
            this.verificarEnergiaMagicaWizard(wizard, jugadorAtacado, hechizo);
            this.mostrarResultadosWizard(wizard, hechizo);
        }

        else if (jugadorAtacante.esElfo()) {
            Elfo elfo = (Elfo) jugadorAtacante;
            Hechizo hechizo = this.seleccionarHechizoParaPelear(jugadorAtacante);
            this.mostrarEnergiaMagicaElfo(elfo);
            this.verificarEnergiaMagicaElfo(elfo, jugadorAtacado, hechizo);
            hechizo.curar(elfo);
            this.mostrarResultadosElfo(elfo, hechizo);
        }

    }

    public void verificarEnergiaMagicaWizard(Wizard wizard, Personaje jugadorAtacado, Hechizo hechizo) {

        if (wizard.getEnergiaMagica() > 0) {
            wizard.atacar(jugadorAtacado, hechizo);
        } else {
            System.out.println("No tienes suficiente Energía Mágica para atacar.");
        }

    }

    public void verificarEnergiaMagicaElfo(Elfo elfo, Personaje jugadorAtacado, Hechizo hechizo) {

        if (elfo.getEnergiaMagica() > 0) {
            elfo.atacar(jugadorAtacado, hechizo);
        } else {
            System.out.println("No tienes suficiente Energía Mágica para atacar.");
        }

    }

    private void mostrarEnergiaMagicaWizard(Wizard wizard) {
        System.out.println(ANSI_CYAN + "Energía Mágica " + ANSI_RESET + wizard.getEnergiaMagica());
    }

    private void mostrarEnergiaMagicaElfo(Elfo elfo) {
        System.out.println(ANSI_CYAN + "Energía Mágica " + elfo.getEnergiaMagica() + ANSI_RESET);
    }

    private void mostrarResultadosWizard(Wizard wizard, Hechizo hechizo) {

        System.out.println("\n" + ANSI_PURPLE + hechizo.getNombre() + ": " + ANSI_RESET);
        System.out.println("Daño " + hechizo.getNivelDanio());
        System.out.println("Curación " + hechizo.getNivelCuracion());
        System.out.println("Energía Mágica " + hechizo.getEnergiaMagica() + "\n");

        System.out.println("Tu Artefacto: \n");
        System.out.println(ANSI_RED + wizard.getArtefacto().getNombre() + ANSI_RESET);
        System.out.println("Daño " + hechizo.activarDanioDeArtefacto(wizard.getArtefacto()));
        System.out.println("Curación "
                + hechizo.activarCuracionDeArtefacto(wizard.getArtefacto().getAmplificadorDeCuracion()) + "\n");
        System.out.println(ANSI_GREEN + "Salud restante: " + ANSI_RESET + wizard.getSalud());
        System.out.println(ANSI_CYAN + "Energía mágica restante: " + ANSI_RESET + wizard.getEnergiaMagica());

    }

    private void mostrarResultadosElfo(Elfo elfo, Hechizo hechizo) {

        System.out.println("\n" + ANSI_PURPLE + hechizo.getNombre() + ": " + ANSI_RESET);
        System.out.println("Daño " + hechizo.getNivelDanio());
        System.out.println("Curación " + hechizo.getNivelCuracion());
        System.out.println("Energía Mágica " + hechizo.getEnergiaMagica() + "\n");

        System.out.println("Tu Artefacto: \n");
        System.out.println(ANSI_RED + elfo.getArtefacto().getNombre() + ANSI_RESET);
        System.out.println("Daño " + hechizo.activarDanioDeArtefacto(elfo.getArtefacto()));
        System.out.println("Curación "
                + hechizo.activarCuracionDeArtefacto(elfo.getArtefacto().getAmplificadorDeCuracion()) + "\n");

        System.out.println(ANSI_GREEN + "Salud restante: " + ANSI_RESET + elfo.getSalud());
        System.out.println(ANSI_CYAN + "Energía mágica restante: " + ANSI_RESET + elfo.getEnergiaMagica());
    }

    public void iniciarMiniJuego(Personaje jugador, TrenExpresoHowards tren) {

        int dado = jugador.tirarDado();

        System.out.println("Has sacado un " + ANSI_YELLOW + dado + ANSI_RESET + ".");

        Teclado.nextLine();
        Teclado.nextLine();

        tren.setVelocidad(dado);

        if (tren.esInvisibleAMuggles()) {

            jugador.aumentarSalud(tren.getAmplificadorDeSalud());

            this.mostrarMensajeGanadorSalud(jugador);

        } else if (tren.esInvisible()) {

            jugador.aumentarSalud(tren.getAmplificadorDeSalud() + 1);

            this.mostrarMensajeGanadorSalud(jugador);

        } else {

            this.mostrarMensajePerdedorSalud(jugador);

        }

    }

    public void mostrarMensajeGanadorSalud(Personaje jugador) {

        System.out.println("Genial, " + jugador.getNombre() + "!!!");
        System.out.println(ANSI_GREEN + "Salud " + jugador.getSalud() + ANSI_RESET);

    }

    public void mostrarMensajePerdedorSalud(Personaje personaje) {

        System.out.print(ANSI_YELLOW + "Mala suerte, " + personaje.getNombre() + "." + ANSI_RESET
                + " Tu salud aún es de " + personaje.getSalud() + " puntos.\n");

    }

    public void arrancarTren(Personaje jugador1, Personaje jugador2) {

        TrenExpresoHowards tren = null;

        tren = this.crearTrenExpresoHowards();

        bannerJugador1(jugador1);

        this.iniciarMiniJuego(jugador1, tren);

        bannerJugador2(jugador2);

        this.iniciarMiniJuego(jugador2, tren);

    }

    public TrenExpresoHowards crearTrenExpresoHowards() {

        TrenExpresoHowards tren = new TrenExpresoHowards();

        tren.setNombre("Tren Expreso Hogwarts.");

        tren.setDescripcion(
                "Tira el dado mágico. Si sacas un 5 o número menor, el tren será invisible frente a muggles y ganas 1 puntos de salud. Si sacas un 10, el tren aumentará tanto su velocidad que será invisible también ante magos oscuros que quieran interceptarlo. Ganarás 2 puntos de salud.");

        tren.setAmplificadorDeSalud(1);

        System.out.print(ANSI_YELLOW + tren.getNombre() + ANSI_RESET + " " + tren.getDescripcion() + "\n");

        return tren;

    }

    public void comprarEscoba(Personaje jugador) {

        Escoba escoba = null;
        int opcion = 0;

        escoba = this.crearEscobaNueva(escoba);

        if (jugador.esWizard()) {
            Wizard wizi = (Wizard) jugador;

            opcion = wizi.seleccionarOpcionComprar(opcion, wizi);

            if (opcion == 1) {

                if (escoba.esInvisible()) {

                    wizi.decrementarSalud(2);

                    wizi.incrementarEnergiaMagica(2);

                    wizi.setEscoba(escoba);

                    this.mostrarMensajeDeCompra(wizi);

                } else if (escoba.esInvisibleAMuggles()) {

                    wizi.decrementarSalud(1);

                    wizi.incrementarEnergiaMagica(2);

                    wizi.setEscoba(escoba);

                    this.mostrarMensajeDeCompra(wizi);

                }
            }

        }

        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------\n");

    }

    public Escoba crearEscobaNueva(Escoba escoba) {

        escoba = new Escoba();
        escoba.setNombre("Saeta de Fuego.");
        escoba.setDescripcion(
                "Escoba de nivel internacional, fue lanzada en 1993 y con el tiempo, acabó siendo utilizada en los equipos internacionales búlgaro e irlandés de Quidditch.");
        escoba.setVelocidad(150);
        escoba.setAmplificadorDeSalud(3);

        return escoba;
    }

    public void mostrarMensajeDeCompra(Wizard wizi) {

        System.out.print(ANSI_GREEN + "\nSalud " + ANSI_RESET + wizi.getSalud() + " | ");
        System.out.println(ANSI_GREEN + "Energía Mágica " + ANSI_RESET + wizi.getEnergiaMagica() + "\n");
        System.out.println("\nCompraste la escoba: \n");
        System.out.println(
                ANSI_YELLOW + wizi.getEscoba().getNombre() + ANSI_RESET + " " + wizi.getEscoba().getDescripcion());

    }

    private void mostrarPoderInicial(Personaje jugador) {

        if (jugador.esWizard()) {
            Wizard wizi = (Wizard) jugador;

            System.out.println("\n" + ANSI_BLUE + jugador.getNombre() + ANSI_RESET + "\n");
            System.out.println(ANSI_PURPLE + "Poder " + ANSI_RESET + wizi.getPoderInicial().getNombre() + ". "
                    + wizi.getPoderInicial().getDescripcion());
            System.out.println(ANSI_GREEN + "Salud " + ANSI_RESET + wizi.getSalud());
            System.out.println(ANSI_CYAN + "Energía Mágica " + ANSI_RESET + wizi.getEnergiaMagica());
            System.out.println(ANSI_RED + "Artefacto " + ANSI_RESET + wizi.getArtefacto().getNombre());
            System.out.println(
                    ANSI_RED + "Poder de Artefacto " + ANSI_RESET + wizi.getArtefacto().getPoder().getNombre() + "\n");

        } else if (jugador.esElfo()) {
            Elfo elfi = (Elfo) jugador;

            System.out.println("\n" + ANSI_BLUE + jugador.getNombre() + ANSI_RESET + "\n");
            System.out.println(ANSI_PURPLE + "Poder " + ANSI_RESET + elfi.getPoderInicial().getNombre() + ". "
                    + elfi.getPoderInicial().getDescripcion());
            System.out.println(ANSI_GREEN + "Salud " + ANSI_RESET + elfi.getSalud());
            System.out.println(ANSI_CYAN + "Energía Mágica " + ANSI_RESET + elfi.getEnergiaMagica());
            System.out.println(ANSI_RED + "Artefacto " + ANSI_RESET + elfi.getArtefacto().getNombre());
            System.out.println(
                    ANSI_RED + "Poder de Artefacto " + ANSI_RESET + elfi.getArtefacto().getPoder().getNombre() + "\n");

        }

    }

    public void mostrarMensajeGanador(Personaje jugador) {

        System.out
                .println(ANSI_PURPLE + "\n!!!" + ANSI_RESET + "Felicidades" + ANSI_PURPLE + "!!!" + ANSI_RESET + "\n");
        System.out.println("El " + ANSI_PURPLE + "Sombrero Seleccionador" + ANSI_RESET + " grita enérgico: ");
        System.out.println(ANSI_BLUE + jugador.getNombre() + ANSI_RESET + " ha ganado la " + ANSI_YELLOW
                + "Copa de la Casa " + jugador.getCasaHowarts() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Salud restante: " + jugador.getSalud() + ANSI_RESET);

    }

    public static void bannerAprenderHechizos() {

        System.out.println(ANSI_YELLOW + "\n Debes aprender tus hechizos en el siguiente orden:\n");
        System.out.println("Elegir hechizo: " + ANSI_RESET);

    }

    public static void bannerAtacarConHechizos() {

        System.out.println("\nDebes elegir un hechizo para atacar a tu oponente (el nivel de daño y curación de cada hechizo cambiarán mágicamente al azar en cada elección): \n");

    }

    public void bannerJugador1(Personaje personaje) {

        System.out.println(ANSI_BLUE + "\nJUGADOR 1 " + ANSI_RESET + personaje.getNombre() + "\n");

    }

    public void bannerJugador2(Personaje personaje) {

        System.out.println(ANSI_BLUE + "\nJUGADOR 2 " + ANSI_RESET + personaje.getNombre() + "\n");

    }

    public void bannerBonus() {

        System.out.println(ANSI_PURPLE + "\n***BONUS***\n" + ANSI_RESET);
    }

    public void inicializarPersonajes() {

        Wizard wizard = new Wizard("Harry Potter", 90, 120);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        Poder poderInicial = new Poder("Parse Tongue.");
        poderInicial
                .setDescripcion("El Parsel es la legua de las serpientes y de aquellos que pueden hablar con ellas.");
        wizard.setPoderInicial(poderInicial);

        Escoba escoba = new Escoba();
        escoba.setNombre("Nimbus 2000.");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora.");
        wizard.setEscoba(escoba);

        Poder poder = new Poder("Parse Tongue.");
        poder.setDescripcion("El Parsel es la legua de las serpientes y de aquellos que pueden hablar con ellas.");
        poder.setNivelDePoder(2);

        Horrocrux horrocrux = new Horrocrux("Horrocrux");
        horrocrux.setAmplificadorDeDanio(0.5);
        horrocrux.setAmplificadorDeCuracion(0.5);
        horrocrux.setPoder(poder);
        wizard.setArtefacto(horrocrux);

        wizard.setCasaHowarts("Gryffindor");

        this.personajes.add(wizard);

        wizard = new Wizard("Ron Weasley", 90, 120);
        wizard.setEdad(18);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis.");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro.");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre("Nimbus 2000.");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora.");
        wizard.setEscoba(escoba);

        poder = new Poder("Parse Tongue.");
        poder.setDescripcion("El Parsel es la legua de las serpientes y de aquellos que pueden hablar con ellas.");
        poder.setNivelDePoder(2);

        PiedraResurreccion piedraResurreccion = new PiedraResurreccion("Piedra de Resurrección");
        piedraResurreccion.setAmplificadorDeDanio(0.3);
        piedraResurreccion.setAmplificadorDeCuracion(0.5);
        piedraResurreccion.setPoder(poder);
        wizard.setArtefacto(piedraResurreccion);

        wizard.setCasaHowarts("Gryffindor");

        this.personajes.add(wizard);

        wizard = new Wizard("Hermione Granger", 90, 130);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis.");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro.");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre("Nimbus 2000.");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora.");
        wizard.setEscoba(escoba);

        poder = new Poder("Invisibilidad.");
        poder.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás.");
        poder.setNivelDePoder(3);

        VaritaSauco varitaSauco = new VaritaSauco("Varita de Sauco");
        varitaSauco.setAmplificadorDeDanio(0.3);
        varitaSauco.setAmplificadorDeCuracion(0.5);
        varitaSauco.setPoder(poder);
        wizard.setArtefacto(varitaSauco);

        wizard.setCasaHowarts("Gryffindor");

        this.personajes.add(wizard);

        wizard = new Wizard("Ginny Weasley", 90, 120);
        wizard.setEdad(16);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Invisibilidad.");
        poderInicial.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás.");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre("Nimbus 2000.");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora.");
        wizard.setEscoba(escoba);

        poder = new Poder("Parse Tongue.");
        poder.setDescripcion("El Parsel es la legua de las serpientes y de aquellos que pueden hablar con ellas.");
        poder.setNivelDePoder(3);

        piedraResurreccion = new PiedraResurreccion("Piedra de Resurrección");
        piedraResurreccion.setAmplificadorDeDanio(0.3);
        piedraResurreccion.setAmplificadorDeCuracion(0.5);
        piedraResurreccion.setPoder(poder);
        wizard.setArtefacto(piedraResurreccion);

        wizard.setCasaHowarts("Gryffindor");

        this.personajes.add(wizard);

        wizard = new Wizard("Draco Malfoy", 90, 120);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis.");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro.");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre("Nimbus 2000.");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora.");
        wizard.setEscoba(escoba);

        poder = new Poder("Parse Tongue.");
        poder.setDescripcion("El Parse es la legua de las serpientes y de aquellos que pueden hablar con ellas.");
        poder.setNivelDePoder(2);

        horrocrux = new Horrocrux("Horrocrux");
        horrocrux.setAmplificadorDeDanio(0.5);
        horrocrux.setAmplificadorDeCuracion(0.5);
        horrocrux.setPoder(poder);
        wizard.setArtefacto(horrocrux);

        wizard.setCasaHowarts("Slytherin");

        this.personajes.add(wizard);

        wizard = new Wizard("Luna Lovegood", 90, 120);
        wizard.setEdad(16);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis.");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro.");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre("Nimbus 2000.");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora.");
        wizard.setEscoba(escoba);

        poder = new Poder("Invisibilidad.");
        poder.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás.");
        poder.setNivelDePoder(3);

        CapaInvisibilidad capaInvisibilidad = new CapaInvisibilidad("Capa de Invisibilidad");
        capaInvisibilidad.setAmplificadorDeDanio(0.5);
        capaInvisibilidad.setAmplificadorDeCuracion(0.5);
        capaInvisibilidad.setPoder(poder);
        wizard.setArtefacto(capaInvisibilidad);

        wizard.setCasaHowarts("Ravenclaw");

        this.personajes.add(wizard);

        wizard = new Wizard("Neville Longbottom", 90, 120);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis.");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro.");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre("Nimbus 2000.");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora.");
        wizard.setEscoba(escoba);

        poder = new Poder("Parse Tongue.");
        poder.setDescripcion("El Parse es la legua de las serpientes y de aquellos que pueden hablar con ellas.");
        poder.setNivelDePoder(2);

        horrocrux = new Horrocrux("Horrocrux");
        horrocrux.setAmplificadorDeDanio(0.5);
        horrocrux.setAmplificadorDeCuracion(0.5);
        horrocrux.setPoder(poder);
        wizard.setArtefacto(horrocrux);

        wizard.setCasaHowarts("Gryffindor");

        this.personajes.add(wizard);

        wizard = new Wizard("Cedric Diggory", 90, 130);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis.");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro.");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre("Nimbus 2001.");
        escoba.setDescripcion("La Nimbus 2001 se usa para jugar al Quidditch y es mas rápida que la escoba barredora.");
        wizard.setEscoba(escoba);

        poder = new Poder("Metamorfosis.");
        poder.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro.");
        poder.setNivelDePoder(1);

        capaInvisibilidad = new CapaInvisibilidad("Capa de invisibilidad");
        capaInvisibilidad.setAmplificadorDeDanio(0.5);
        capaInvisibilidad.setAmplificadorDeCuracion(0.5);
        capaInvisibilidad.setPoder(poder);
        wizard.setArtefacto(capaInvisibilidad);

        wizard.setCasaHowarts("Hufflepuff");

        this.personajes.add(wizard);

        Elfo elfo = new Elfo("Winky", 90, 120);
        elfo.setEdad(30);

        poderInicial = new Poder("Invisibilidad.");
        poderInicial.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás.");
        elfo.setPoderInicial(poderInicial);

        poder = new Poder("Invisibilidad.");
        poder.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás.");
        poder.setNivelDePoder(1);

        varitaSauco = new VaritaSauco("Varita de Sauco");
        varitaSauco.setAmplificadorDeDanio(0.3);
        varitaSauco.setAmplificadorDeCuracion(0.5);
        varitaSauco.setPoder(poder);
        elfo.setArtefacto(varitaSauco);

        elfo.setCasaHowarts("Hufflepuff");

        this.personajes.add(elfo);

        elfo = new Elfo("Dobby", 90, 120);
        elfo.setEdad(15);

        poderInicial = new Poder("Invisibilidad.");
        poderInicial.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás.");
        elfo.setPoderInicial(poderInicial);

        poder = new Poder("Invisibilidad.");
        poder.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás.");
        poder.setNivelDePoder(4);

        horrocrux = new Horrocrux("Horrocrux");
        horrocrux.setAmplificadorDeDanio(0.5);
        horrocrux.setAmplificadorDeCuracion(0.5);
        horrocrux.setPoder(poder);
        elfo.setArtefacto(horrocrux);

        elfo.setCasaHowarts("Gryffindor");

        this.personajes.add(elfo);

        elfo = new Elfo("Kreacher", 90, 120);
        elfo.setEdad(15);

        poderInicial = new Poder("Invisibilidad.");
        poderInicial.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás.");
        elfo.setPoderInicial(poderInicial);

        poder = new Poder("Invisibilidad.");
        poder.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás.");
        poder.setNivelDePoder(3);

        horrocrux = new Horrocrux("Horrocrux");
        horrocrux.setAmplificadorDeDanio(0.5);
        horrocrux.setAmplificadorDeCuracion(0.5);
        horrocrux.setPoder(poder);
        elfo.setArtefacto(horrocrux);

        elfo.setCasaHowarts("Slytherin");

        this.personajes.add(elfo);

        elfo = new Elfo("Hokey", 90, 120);
        elfo.setEdad(15);

        poderInicial = new Poder("Invisibilidad.");
        poderInicial.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás.");
        elfo.setPoderInicial(poderInicial);

        poder = new Poder("Metamorfosis.");
        poder.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro.");
        poder.setNivelDePoder(2);

        piedraResurreccion = new PiedraResurreccion("Piedra de Resurrección.");
        horrocrux.setAmplificadorDeDanio(0.5);
        horrocrux.setAmplificadorDeCuracion(0.5);
        horrocrux.setPoder(poder);
        elfo.setArtefacto(horrocrux);

        elfo.setCasaHowarts("Ravenclaw");

        this.personajes.add(elfo);

    }

    public void inicializarHechizos() {

        WingwardumLeviosa wingwardumLeviosa = new WingwardumLeviosa("Wingwardum Leviosa");
        wingwardumLeviosa
                .setDescripcion("Wingwardum Leviosa es un hechizo que permite levitar objetos o pequeños seres vivos.");
        wingwardumLeviosa.setEnergiaMagica(3);
        wingwardumLeviosa.setNivelDanio(3);
        wingwardumLeviosa.setNivelCuracion(1);
        wingwardumLeviosa.setEsOscuro(false);

        Minijuego minijuego = new Minijuego("Suma Mágica.");
        minijuego.setDescripcion(
                "Si resuelves con éxito la suma, ganas un punto de energía mágica. Si fallas, lo pierdes, y aprendes el hechizo con dificultades.");
        wingwardumLeviosa.setMinijuego(minijuego);

        this.hechizos.add(wingwardumLeviosa);

        SectumSempra sectumsempra = new SectumSempra("Sectumsempra");
        sectumsempra.setDescripcion("La maldición Sectumsempra genera cortes profundos en la víctima.");
        sectumsempra.setEnergiaMagica(6);
        sectumsempra.setNivelDanio(6);
        sectumsempra.setNivelCuracion(1);
        sectumsempra.setEsOscuro(true);

        minijuego = new Minijuego("Resta Mágica.");
        minijuego.setDescripcion(
                "Si resuelves con éxito la resta, ganas un punto de energía mágica. Si fallas, lo pierdes, y aprendes el hechizo con dificultades.");
        sectumsempra.setMinijuego(minijuego);

        this.hechizos.add(sectumsempra);

        VulneraSanentur vulnerasanentur = new VulneraSanentur("Vulnera Sanentur");
        vulnerasanentur
                .setDescripcion("Hechizo sanador que corresponde al contrahechizo de la maldición sectumsempra.");
        vulnerasanentur.setEnergiaMagica(1);
        vulnerasanentur.setNivelDanio(1);
        vulnerasanentur.setNivelCuracion(4);
        vulnerasanentur.setEsOscuro(false);

        minijuego = new Minijuego("Multiplicación Mágica.");
        minijuego.setDescripcion(
                "Si resuelves con éxito la multiplicación, ganas un punto de energía mágica. Si fallas, lo pierdes, y aprendes el hechizo con dificultades.");
        vulnerasanentur.setMinijuego(minijuego);

        this.hechizos.add(vulnerasanentur);

        Cavelnimicum cavelnimicum = new Cavelnimicum("Cavelnimicum");
        cavelnimicum.setDescripcion("Hechizo de protección, mantiene alejado a los enemigos.");
        cavelnimicum.setEnergiaMagica(3);
        cavelnimicum.setNivelDanio(3);
        cavelnimicum.setNivelCuracion(1);
        cavelnimicum.setEsOscuro(false);

        minijuego = new Minijuego("Combinación Mágica.");
        minijuego.setDescripcion(
                "Si resuelves con éxito el cálculo combinado, ganas un punto de energía mágica. Si fallas, lo pierdes, y aprendes el hechizo con dificultades.");
        cavelnimicum.setMinijuego(minijuego);

        this.hechizos.add(cavelnimicum);
    }

}
