package app.personajes;

import java.util.ArrayList;
import java.util.List;

import app.IHaceMagia;
import app.artefactos.Artefacto;
import app.poderes.Hechizo;
import app.poderes.Poder;

public class Elfo extends Criatura implements IHaceMagia {

    private int energiaMagica;
    private Artefacto artefacto;
    private List<Hechizo> hechizos = new ArrayList<>();
    private Poder poderInicial;

    public Elfo(String nombre, int salud, int energiaMagica) {
        super(nombre, salud);
        this.energiaMagica = energiaMagica;

    }

    public int getEnergiaMagica() {
        return energiaMagica;
    }

    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }

    public Artefacto getArtefacto() {
        return artefacto;
    }

    public void setArtefacto(Artefacto artefacto) {
        this.artefacto = artefacto;
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public Poder getPoderInicial() {
        return poderInicial;
    }

    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    }

    @Override
    public void setPoder(Poder poder) {

        poder.setNivelDePoder(3);
        this.artefacto.setPoder(poder);
    }

    @Override
    public void aprender(Hechizo h) {

        this.obtenerEdadMagica();

        this.hechizos.add(h);

        System.out.println("Has aprendido el hechizo " + h.getNombre());

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {

        if (this.energiaMagica <= 0) {
            return;
        }

        hechizo.disminuirEnergiaMagica(energiaMagica);

        hechizo.disminuirSalud(personaje, artefacto);

        this.atacar(personaje, hechizo.getNombre());
    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {

        System.out.print(this.artefacto.getNombre() + this.artefacto.getPoder().getNombre()
                + this.artefacto.getPoder().getNivelDePoder());

        System.out.println("Has atacado con " + hechizo);

        System.out.println("Te quedan " + this.energiaMagica + " puntos de energía mágica.");

    }

    public void mostrarConsignaMinijuego() {

        System.out.println(
                "Puedes saber la edad de tu elfo al tirar el dado mágico. Si su edad es mayor o igual a 2 pero menor a 5, será capaz de invisibilizarse frente a muggles, ganas 1 punto de energía mágica.\n");
        System.out.println(
                "Si su edad es mayor o igual a 5 pero menor o igual a 10, es invisible también a los magos, ganas 3 puntos de energía mágica.\n");

    }

    public void obtenerEdadMagica() {

        this.mostrarConsignaMinijuego();

        this.setEdad(this.tirarDado());

        Teclado.nextLine();

        if (this.esInvisibleAMuggles()) {

            this.incrementarEnergiaMagica(1);

            this.mostrarMensajeEdad();

        } else if (this.esInvisible()) {

            this.incrementarEnergiaMagica(3);

            this.mostrarMensajeEdad();

        } else {

            System.out.println("Tu elfo es demasiado joven para poder aumentar su energía mágica.");
        }

    }

    public void mostrarMensajeEdad() {

        System.out.println(this.getNombre() + " tiene " + this.getEdad() + " años de edad. Su energía mágica es de  "
                + this.getEnergiaMagica() + " puntos.");

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

}