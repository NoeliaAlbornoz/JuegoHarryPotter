package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.artefactos.Artefacto;
import app.personajes.Elfo;
import app.personajes.Personaje;
import app.personajes.Wizard;
import app.poderes.Hechizo;
import app.poderes.Poder;
import app.transportes.Escoba;
import app.transportes.TrenExpresoHowards;

public class JuegoHP {

    public static Scanner Teclado = new Scanner(System.in);

    public List<Personaje> personajes = new ArrayList<>();

    public List<Hechizo> hechizos = new ArrayList<>();

    public TrenExpresoHowards tren;

    public void inicializarJuego() {

        this.inicializarPersonajes();

        this.inicializarHechizos();

    }

    public void start() {

        bannerJugador1();

        Personaje jugador1 = this.seleccionarPersonaje();

        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------\n");

        bannerJugador2();

        Personaje jugador2 = this.seleccionarPersonaje();

        this.arrancarTren(jugador1, tren, jugador2);

        int jugada = 1;

        while (jugada < 9) {

            if (jugada % 2 != 0) {

                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------\n");

                bannerJugador1();

                System.out.println(jugador1.getNombre());

                bannerAprenderHechizos();

                this.iniciarAprendizajeDeHechizos(jugador1);

            } else {

                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------\n");

                bannerJugador2();

                System.out.println(jugador2.getNombre());

                bannerAprenderHechizos();

                this.iniciarAprendizajeDeHechizos(jugador2);
            }

            jugada++;

        }

        jugada = 1;

        while (jugador1.estaVivo() && jugador2.estaVivo()) {

            if (jugada % 2 != 0) {

                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------\n");

                bannerJugador1();

                this.mostrarPropiedadesJugador(jugador1, jugador2);

                bannerAtacarConHechizos();

                this.iniciarAtaqueConHechizos(jugador1, jugador2);

            } else {

                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------\n");

                bannerJugador2();

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

            System.out.println("\n!!!Felicidades!!! " + jugador1.getNombre()
                    + " ha ganado la Copa de la Casa con una salud restante de " + jugador1.getSalud() + " puntos!");

        } else {

            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------\n");

            this.mostrarPropiedadesJugador(jugador1, jugador2);

            System.out.println("\n!!!Felicidades!!! " + jugador2.getNombre()
                    + " ha ganado la Copa de la Casa con una salud restante de " + jugador2.getSalud() + " puntos!");

        }

    }

    public void mostrarPropiedadesJugador(Personaje jugador1, Personaje jugador2) {

        System.out.print(jugador1.getNombre() + " Salud " + jugador1.getSalud() + " | ");

        System.out.println(jugador2.getNombre() + " Salud " + jugador2.getSalud());

    }

    public void inicializarPersonajes() {

        Wizard wizard = new Wizard();
        wizard.setNombre("Harry Potter");
        wizard.setEnergiaMagica(150);
        wizard.setSalud(100);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        Poder poderInicial = new Poder("Parse Tongue");
        poderInicial.setDescripcion("El Parse es la legua de las serpientes y de aquellos que pueden hablar con ellas");
        wizard.setPoder(poderInicial);

        Escoba escoba = new Escoba();
        escoba.setNombre("Nimbus 2000");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        Poder poder = new Poder("Parse Tongue");
        poder.setDescripcion("El Parse es la legua de las serpientes y de aquellos que pueden hablar con ellas");

        Artefacto artefacto = new Artefacto("Horrocrux");
        artefacto.setAmplificadorDeDanio(0.5);
        artefacto.setAmplificadorDeCuracion(0.5);
        artefacto.setPoder(poder);

        wizard.setArtefacto(artefacto);

        this.personajes.add(wizard);

        wizard = new Wizard();
        wizard.setNombre("Ron Weasley");
        wizard.setEnergiaMagica(150);
        wizard.setSalud(100);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro");
        wizard.setPoder(poderInicial);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2000 ");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        poder = new Poder("Parse Tongue");
        poder.setDescripcion("El Parse es la legua de las serpientes y de aquellos que pueden hablar con ellas");

        artefacto = new Artefacto("Piedra de resurrección");
        artefacto.setAmplificadorDeDanio(0.3);
        artefacto.setAmplificadorDeCuracion(0.5);
        artefacto.setPoder(poder);

        wizard.setArtefacto(artefacto);

        this.personajes.add(wizard);

        wizard = new Wizard();
        wizard.setNombre("Hermione Granger");
        wizard.setEnergiaMagica(150);
        wizard.setSalud(100);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Invisibilidad");
        poderInicial.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás");
        wizard.setPoder(poderInicial);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2000 ");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        this.personajes.add(wizard);

        wizard = new Wizard();
        wizard.setNombre("Ginny Weasley");
        wizard.setEnergiaMagica(150);
        wizard.setSalud(100);
        wizard.setEdad(16);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Invisibilidad");
        poderInicial.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás");
        wizard.setPoder(poderInicial);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2000 ");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        this.personajes.add(wizard);

        wizard = new Wizard();
        wizard.setNombre("Draco Malfoy");
        wizard.setEnergiaMagica(150);
        wizard.setSalud(100);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro");
        wizard.setPoder(poderInicial);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2000 ");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        this.personajes.add(wizard);

        wizard = new Wizard();
        wizard.setNombre("Luna Lovegood");
        wizard.setEnergiaMagica(150);
        wizard.setSalud(100);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro");
        wizard.setPoder(poderInicial);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2000 ");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        this.personajes.add(wizard);

        wizard = new Wizard();
        wizard.setNombre("Nevile Longbottom");
        wizard.setEnergiaMagica(150);
        wizard.setSalud(100);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro");
        wizard.setPoder(poderInicial);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2000 ");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        this.personajes.add(wizard);

    }

    public void inicializarHechizos() {

        Hechizo hechizo = new Hechizo("Wingwardum Leviosa");
        hechizo.setDescripcion("Wingwardum Leviosa es un hechizo que permite levitar objetos o pequeños seres vivos.");
        hechizo.setEnergiaMagica(2);
        hechizo.setNivelDanio(5);
        hechizo.setEsOscuro(false);
        hechizo.setNivelCuracion(2);
    
        this.hechizos.add(hechizo);

        hechizo = new Hechizo("Sectumsempra");
        hechizo.setDescripcion("La maldición Sectumsempra genera cortes profundos en la víctima.");
        hechizo.setEnergiaMagica(7);
        hechizo.setNivelDanio(7);
        hechizo.setEsOscuro(true);
        hechizo.setNivelCuracion(1);

        this.hechizos.add(hechizo);

        hechizo = new Hechizo("VulneraSanentur");
        hechizo.setDescripcion("Hechizo sanador que corresponde al contrahechizo de la maldición sectumsempra.");
        hechizo.setEnergiaMagica(4);
        hechizo.setNivelDanio(2);
        hechizo.setEsOscuro(false);
        hechizo.setNivelCuracion(4);

        this.hechizos.add(hechizo);

        hechizo = new Hechizo("Cavelnimicum");
        hechizo.setDescripcion("Hechizo de protección, mantiene alejado a los enemigos.");
        hechizo.setEnergiaMagica(3);
        hechizo.setNivelDanio(4);
        hechizo.setEsOscuro(false);
        hechizo.setNivelCuracion(3);

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

    public Hechizo seleccionarHechizoParaPelear(Personaje personaje) {

        int i = 0;
        Wizard wizi = null;

        if (personaje instanceof Wizard) {
            wizi = (Wizard) personaje;
            for (Hechizo hechizo : wizi.getHechizos()) {
                System.out.print(" " + (++i) + "-" + hechizo.getNombre());
            }

        }

        System.out.println();

        i = Teclado.nextInt();

        return wizi.getHechizos().get(--i);

    }

    public void atacarSegunPersonaje(Personaje jugador1, Hechizo hechizo, Personaje jugador2) {

        if (jugador1 instanceof Wizard) {
            Wizard wizard = (Wizard) jugador1;
            wizard.atacar(jugador2, hechizo);
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

    public void bannerJugador1() {

        System.out.println("JUGADOR 1 \n");

    }

    public void bannerJugador2() {

        System.out.println("\nJUGADOR 2 \n");

    }

    public void iniciarAprendizajeDeHechizos(Personaje jugador) {

        Hechizo hechizo = this.seleccionarHechizo();

        this.aprenderSegunPersonaje(jugador, hechizo);

    }

    public void iniciarAtaqueConHechizos(Personaje jugadorAtacante, Personaje jugadorAtacado) {

        Hechizo hechizo = this.seleccionarHechizoParaPelear(jugadorAtacante);

        this.atacarSegunPersonaje(jugadorAtacante, hechizo, jugadorAtacado);
    }

    public void iniciarMiniJuego(Personaje jugador, TrenExpresoHowards tren){

        int dado = jugador.tirarDado();

        System.out.print(dado + " ");

        tren.setVelocidad(dado);

        if (tren.esInvisibleAMuggles()) {

            int masSalud = tren.getAmplificadorDeSalud() + 1;

            int saludIncrementada = jugador.getSalud() + masSalud;

            jugador.setSalud(saludIncrementada);

            System.out.print(jugador.getNombre() + " Salud " + jugador.getSalud() + " ");

        } else if (tren.esInvisible()) {

            int masSalud = tren.getAmplificadorDeSalud() + 1;

            int saludIncrementada = jugador.getSalud() + masSalud;

            jugador.setSalud(saludIncrementada);

            System.out.print(jugador.getNombre() + " Salud " + jugador.getSalud() + " ");

        } else {

            System.out.print(" Mala suerte " + jugador.getNombre() + " Salud " + jugador.getSalud() + " ");

        }

    }

    public void arrancarTren(Personaje jugador1, TrenExpresoHowards tren, Personaje jugador2){

        tren = new TrenExpresoHowards();

        tren.setNombre("Tren Expreso Howards. ");

        tren.setDescripcion(
                "Tira el dado mágico. Si sacas un 3 o número menor, el tren será invisible frente a muggles y ganas 1 punto de salud. Si sacas un 10, el tren aumentará tanto su velocidad que será invisible también ante magos oscuros que quieran interceptarlo. Ganarás 2 puntos de salud.\n");

        tren.setAmplificadorDeSalud(1);

        System.out.print(tren.getNombre() + tren.getDescripcion());

        bannerJugador1();

        this.iniciarMiniJuego(jugador1, tren);

        bannerJugador2();

        this.iniciarMiniJuego(jugador2, tren);
        
    }

}
