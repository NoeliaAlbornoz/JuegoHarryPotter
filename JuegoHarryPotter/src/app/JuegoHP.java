package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.artefactos.Artefacto;
import app.personajes.Elfo;
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

    public static Scanner Teclado = new Scanner(System.in);
    public List<Personaje> personajes = new ArrayList<>();
    public List<Hechizo> hechizos = new ArrayList<>();
    public TrenExpresoHowards tren;
    public Escoba escoba;

    public void inicializarJuego() {

        this.inicializarPersonajes();
        this.inicializarHechizos();

    }

    public void start() {

        System.out.println("JUGADOR 1 ");

        Personaje jugador1 = this.seleccionarPersonaje();

        this.mostrarPoderInicial(jugador1);

        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------\n");

        System.out.println("JUGADOR 2 ");

        Personaje jugador2 = this.seleccionarPersonaje();

        this.mostrarPoderInicial(jugador2);

        this.arrancarTren(jugador1, tren, jugador2);

        int jugada = 1;

        while (jugada < 9) {

            if (jugada % 2 != 0) {

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

        jugada = 1;

        while (jugador1.estaVivo() && jugador2.estaVivo()) {

            if (jugada % 2 != 0) {

                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------\n");

                bannerJugador1(jugador1);

                this.mostrarPropiedadesJugador(jugador1, jugador2);

                bannerAtacarConHechizos();

                this.iniciarAtaqueConHechizos(jugador1, jugador2);

                this.comprarEscoba(escoba, jugador1, jugada);

            } else {

                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------\n");

                bannerJugador2(jugador2);

                this.mostrarPropiedadesJugador(jugador1, jugador2);

                bannerAtacarConHechizos();

                this.iniciarAtaqueConHechizos(jugador2, jugador1);

                this.comprarEscoba(escoba, jugador2, jugada);
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

        Wizard wizard = new Wizard("Harry Potter", 90, 130);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        Poder poderInicial = new Poder("Parse Tongue");
        poderInicial.setDescripcion("El Parse es la legua de las serpientes y de aquellos que pueden hablar con ellas");
        wizard.setPoderInicial(poderInicial);

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

        wizard = new Wizard("Ron Weasley", 90, 130);
        wizard.setEdad(18);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro");
        wizard.setPoderInicial(poderInicial);

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

        wizard = new Wizard("Hermione Granger", 90, 130);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2000 ");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        poder = new Poder("Invisibilidad");
        poder.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás");

        artefacto = new Artefacto("Varita de Sauco");
        artefacto.setAmplificadorDeDanio(0.3);
        artefacto.setAmplificadorDeCuracion(0.5);
        artefacto.setPoder(poder);
        wizard.setArtefacto(artefacto);

        this.personajes.add(wizard);

        wizard = new Wizard("Ginny Weasley", 90, 130);
        wizard.setEdad(16);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Invisibilidad");
        poderInicial.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás");
        wizard.setPoderInicial(poderInicial);

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

        wizard = new Wizard("Draco Malfoy", 90, 130);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2000 ");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        poder = new Poder("Parse Tongue");
        poder.setDescripcion("El Parse es la legua de las serpientes y de aquellos que pueden hablar con ellas");

        artefacto = new Artefacto("Horrocrux");
        artefacto.setAmplificadorDeDanio(0.5);
        artefacto.setAmplificadorDeCuracion(0.5);
        artefacto.setPoder(poder);
        wizard.setArtefacto(artefacto);

        this.personajes.add(wizard);

        wizard = new Wizard("Luna Lovegood", 90, 130);
        wizard.setEdad(16);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2000 ");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        poder = new Poder("Invisibilidad");
        poder.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás");

        artefacto = new Artefacto("Capa de Invisibilidad");
        artefacto.setAmplificadorDeDanio(0.5);
        artefacto.setAmplificadorDeCuracion(0.5);
        artefacto.setPoder(poder);
        wizard.setArtefacto(artefacto);

        this.personajes.add(wizard);

        wizard = new Wizard("Neville Longbottom", 90, 130);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2000 ");
        escoba.setDescripcion("La Nimbus 2000 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        poder = new Poder("Parse Tongue");
        poder.setDescripcion("El Parse es la legua de las serpientes y de aquellos que pueden hablar con ellas");

        artefacto = new Artefacto("Horrocrux");
        artefacto.setAmplificadorDeDanio(0.5);
        artefacto.setAmplificadorDeCuracion(0.5);
        artefacto.setPoder(poder);
        wizard.setArtefacto(artefacto);

        wizard = new Wizard("Cedric Diggory", 90, 130);
        wizard.setEdad(17);
        wizard.setMagoOscuro(false);

        poderInicial = new Poder("Metamorfosis");
        poderInicial.setDescripcion("La metamorfosis es un poder usado para la transformación de un animal en otro");
        wizard.setPoderInicial(poderInicial);

        escoba = new Escoba();
        escoba.setNombre(" Nimbus 2001 ");
        escoba.setDescripcion("La Nimbus 2001 se usa para jugar al Quidditch y es mas rápida que la escoba barredora");
        wizard.setEscoba(escoba);

        poder = new Poder("Invisibilidad");
        poder.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás");

        artefacto = new Artefacto("Capa de invisibilidad");
        artefacto.setAmplificadorDeDanio(0.5);
        artefacto.setAmplificadorDeCuracion(0.5);
        artefacto.setPoder(poder);
        wizard.setArtefacto(artefacto);

        this.personajes.add(wizard);

        Elfo elfo = new Elfo("Winky", 92, 145);
        elfo.setEdad(30);

        poderInicial = new Poder("Invisibilidad");
        poderInicial.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás");
        elfo.setPoderInicial(poderInicial);

        poder = new Poder("Invisibilidad");
        poder.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás");

        artefacto = new Artefacto("Varita de Sauco");
        artefacto.setAmplificadorDeDanio(0.3);
        artefacto.setAmplificadorDeCuracion(0.5);
        artefacto.setPoder(poder);
        elfo.setArtefacto(artefacto);

        this.personajes.add(elfo);

        elfo = new Elfo("Dobby", 92, 145);
        elfo.setEdad(15);

        poderInicial = new Poder("Invisibilidad");
        poderInicial.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás");
        elfo.setPoderInicial(poderInicial);

        poder = new Poder("Invisibilidad");
        poder.setDescripcion("La invisibilidad es un poder usado para desaparecer ante la vista de los demás");

        artefacto = new Artefacto("Horrocrux");
        artefacto.setAmplificadorDeDanio(0.5);
        artefacto.setAmplificadorDeCuracion(0.5);
        artefacto.setPoder(poder);
        elfo.setArtefacto(artefacto);

        this.personajes.add(elfo);

    }

    public void inicializarHechizos() {

        WingwardumLeviosa wingwardumLeviosa = new WingwardumLeviosa("Wingwardum Leviosa");
        wingwardumLeviosa
                .setDescripcion("Wingwardum Leviosa es un hechizo que permite levitar objetos o pequeños seres vivos.");
        wingwardumLeviosa.setEnergiaMagica(2);
        wingwardumLeviosa.setNivelDanio(5);
        wingwardumLeviosa.setNivelCuracion(2);
        wingwardumLeviosa.setEsOscuro(false);

        this.hechizos.add(wingwardumLeviosa);

        SectumSempra sectumsempra = new SectumSempra("Sectumsempra");
        sectumsempra.setDescripcion("La maldición Sectumsempra genera cortes profundos en la víctima.");
        sectumsempra.setEnergiaMagica(7);
        sectumsempra.setNivelDanio(7);
        sectumsempra.setNivelCuracion(1);
        sectumsempra.setEsOscuro(true);

        this.hechizos.add(sectumsempra);

        VulneraSanentur vulnerasanentur = new VulneraSanentur("Vulnera Sanentur");
        vulnerasanentur
                .setDescripcion("Hechizo sanador que corresponde al contrahechizo de la maldición sectumsempra.");
        vulnerasanentur.setEnergiaMagica(4);
        vulnerasanentur.setNivelDanio(2);
        vulnerasanentur.setNivelCuracion(4);
        vulnerasanentur.setEsOscuro(false);

        this.hechizos.add(vulnerasanentur);

        Cavelnimicum cavelnimicum = new Cavelnimicum("Cavelnimicum");
        cavelnimicum.setDescripcion("Hechizo de protección, mantiene alejado a los enemigos.");
        cavelnimicum.setEnergiaMagica(3);
        cavelnimicum.setNivelDanio(4);
        cavelnimicum.setNivelCuracion(3);
        cavelnimicum.setEsOscuro(false);

        this.hechizos.add(cavelnimicum);
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

    public void aprenderSegunPersonaje(Personaje jugadorAprendiz, Hechizo h) {

        if (jugadorAprendiz instanceof Wizard) {
            Wizard wizard = (Wizard) jugadorAprendiz;
            wizard.aprender(h);

        } else if (jugadorAprendiz instanceof Elfo) {
            Elfo elfo = (Elfo) jugadorAprendiz;
            elfo.aprender(h);

        }

    }

    public void seleccionarHechizoParaPelear(Personaje personaje) {

        if (personaje instanceof Wizard) {
            this.seleccionarHechizoWizard(personaje);
        } else if (personaje instanceof Elfo) {
            this.seleccionarHechizoElfo(personaje);
        }

    }

    public Hechizo seleccionarHechizoWizard(Personaje personaje) {
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

    public Hechizo seleccionarHechizoElfo(Personaje personaje) {

        int i = 0;
        Elfo elfi = null;
        if (personaje instanceof Elfo) {
            elfi = (Elfo) personaje;
            for (Hechizo hechizo : elfi.getHechizos()) {
                System.out.print(" " + (++i) + "-" + hechizo.getNombre());

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

        if (jugadorAtacante instanceof Wizard) {
            Wizard wizard = (Wizard) jugadorAtacante;
            Hechizo hechizo = this.seleccionarHechizoWizard(jugadorAtacante);
            wizard.atacar(jugadorAtacado, hechizo);
            hechizo.curar(wizard);
        }

        else if (jugadorAtacante instanceof Elfo) {
            Elfo elfo = (Elfo) jugadorAtacante;
            Hechizo hechizo = this.seleccionarHechizoElfo(jugadorAtacante);
            elfo.atacar(jugadorAtacado, hechizo);
            hechizo.curar(elfo);
        }

    }

    public void iniciarMiniJuego(Personaje jugador, TrenExpresoHowards tren) {

        int dado = jugador.tirarDado();

        System.out.print("Has sacado un " + dado);

        tren.setVelocidad(dado);

        if (tren.esInvisibleAMuggles()) {

            int masSalud = tren.getAmplificadorDeSalud();

            int saludIncrementada = jugador.getSalud() + masSalud;

            jugador.setSalud(saludIncrementada);

            System.out.print(", genial " + jugador.getNombre() + "!!! Ahora tu salud es de " + jugador.getSalud()
                    + " puntos. \n");

        } else if (tren.esInvisible()) {

            int masSalud = tren.getAmplificadorDeSalud() + 1;

            int saludIncrementada = jugador.getSalud() + masSalud;

            jugador.setSalud(saludIncrementada);

            System.out.print(". Gran trabajo " + jugador.getNombre() + "!!! Ahora salud es de " + jugador.getSalud()
                    + " puntos. \n");

        } else {

            System.out.print(", mala suerte " + jugador.getNombre() + " tu salud aún es de " + jugador.getSalud()
                    + " puntos. \n ");

        }

    }

    public void arrancarTren(Personaje jugador1, TrenExpresoHowards tren, Personaje jugador2) {

        tren = new TrenExpresoHowards();

        tren.setNombre("\nTren Expreso Howards. ");

        tren.setDescripcion(
                "Tira el dado mágico. Si sacas un 5 o número menor, el tren será invisible frente a muggles y ganas 1 puntos de salud. Si sacas un 10, el tren aumentará tanto su velocidad que será invisible también ante magos oscuros que quieran interceptarlo. Ganarás 2 puntos de salud.\n");

        tren.setAmplificadorDeSalud(1);

        System.out.print(tren.getNombre() + tren.getDescripcion());

        bannerJugador1(jugador1);

        this.iniciarMiniJuego(jugador1, tren);

        bannerJugador2(jugador2);

        this.iniciarMiniJuego(jugador2, tren);

    }

    public void comprarEscoba(Escoba escoba, Personaje jugador, int jugada) {

        int menosSalud = 0;
        int masEnergiaMagica = 0;

        escoba = new Escoba();
        escoba.setNombre("Saeta de Fuego");
        escoba.setDescripcion(
                "Es una escoba de nivel internacional, fue lanzada en 1993 y con el tiempo, acabó siendo utilizada en los equipos internacionales búlgaro e irlandés de quidditch.");
        escoba.setVelocidad(150);
        escoba.setAmplificadorDeSalud(3);

        if (jugador instanceof Wizard) {

            Wizard wizi = (Wizard) jugador;

            if (jugada == 3) {
                System.out.print("Aca adentro va la descripcion");
                int opcion = Teclado.nextInt();

                if (opcion == 1) {

                    if (escoba.esInvisible()) {
                        menosSalud = wizi.getSalud() - 2;
                        wizi.setSalud(menosSalud);

                        masEnergiaMagica = wizi.getEnergiaMagica() + 2;
                        wizi.setEnergiaMagica(masEnergiaMagica);

                        System.out.print(" Has comprado la escoba " + escoba.getNombre()
                                + ", ahora tu energía mágica es de " + wizi.getEnergiaMagica()
                                + " puntos y tu salud es de " + wizi.getSalud() + " puntos. ");

                    } else if (escoba.esInvisibleAMuggles()) {
                        menosSalud = wizi.getSalud() - 1;
                        wizi.setSalud(menosSalud);
                        masEnergiaMagica = wizi.getEnergiaMagica() + 1;
                        wizi.setEnergiaMagica(masEnergiaMagica);

                        System.out.print(" Has comprado la escoba " + escoba.getNombre()
                                + ", ahora tu energía mágica es de " + wizi.getEnergiaMagica()
                                + " puntos y tu salud es de " + wizi.getSalud() + " puntos. ");

                    }
                }

            }
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

    public void bannerJugador1(Personaje personaje) {

        System.out.println("\nJUGADOR 1 " + personaje.getNombre() + "\n");

    }

    public void bannerJugador2(Personaje personaje) {

        System.out.println("\nJUGADOR 2 " + personaje.getNombre() + "\n");

    }

    public void bannerBonus() {

        System.out.println("\n***BONUS***\n");
    }

    private void mostrarPoderInicial(Personaje jugador) {

        if (jugador instanceof Wizard) {
            Wizard wizi = (Wizard) jugador;
            System.out.print("Has seleccionado a " + jugador.getNombre() + ". Ha nacido con el poder de "
                    + wizi.getPoderInicial().getNombre() + ": " + wizi.getPoderInicial().getDescripcion() + "\n");

        } else if (jugador instanceof Elfo) {
            Elfo elfi = (Elfo) jugador;
            System.out.print("Has seleccionado a " + jugador.getNombre() + ". Ha nacido con el poder de "
                    + elfi.getPoderInicial().getNombre() + ": " + elfi.getPoderInicial().getDescripcion() + "\n");

        }
    }

}
