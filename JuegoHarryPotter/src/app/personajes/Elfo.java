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

    @Override
    public void setPoder(Poder poder) {

    }

    @Override
    public void aprender(Hechizo h) {

        this.aumentarEnergiaMagicaElfo();

        this.hechizos.add(h);

        System.out.println("Has aprendido el hechizo " + h.getNombre());

    }

    public void aumentarEnergiaMagicaElfo() {

        System.out.println(
                "Puedes saber la edad de tu elfo al tirar el dado mágico. Si su edad es mayor o igual a 2 pero menor a 5, ganas 1 punto de energía mágica.\n");
        System.out.println(
                "Si su edad es mayor o igual a 5 pero menor o igual a 10, ganas 3 puntos de energía mágica.\n");

        this.setEdad(this.tirarDado());

        if (this.esInvisibleAMuggles()) {

            this.energiaMagica++;

            System.out.println("Tu elfo tiene " + this.getEdad() + " años. Su energía mágica es de  "
                    + this.getEnergiaMagica() + " puntos.");

        } else if (this.esInvisible()) {

            this.energiaMagica += 3;

            System.out.println("Tu elfo tiene " + this.getEdad() + " años. Su energía mágica es de  "
                    + this.getEnergiaMagica() + " puntos.");

        } else {

            System.out.println("Tu elfo es demasiado joven para poder aumentar su energía mágica.");
        }

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {

        hechizo.disminuirEnergiaMagica(energiaMagica);

        hechizo.disminuirSalud(personaje, artefacto);

        this.atacar(personaje, hechizo.getNombre());
    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {

        System.out.println("Has atacado con " + hechizo);

        System.out.println("Te quedan " + this.energiaMagica + " puntos de energía mágica.");

    }

    public void disminuirEnergiaMagica(int energiaMagica, Hechizo hechizo) {

        int energiaMagicaResultante = this.energiaMagica - hechizo.getEnergiaMagica();

        this.setEnergiaMagica(energiaMagicaResultante);

    }

    public Poder getPoderInicial() {
        return poderInicial;
    }

    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    }

}