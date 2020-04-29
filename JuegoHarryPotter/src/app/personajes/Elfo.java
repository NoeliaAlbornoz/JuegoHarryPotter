package app.personajes;

import java.util.List;

import app.artefactos.Artefacto;
import app.poderes.Hechizo;

public class Elfo extends Criatura {
    private int energiaMagica;
    private Artefacto artefacto;
    private List<Hechizo> hechizos;

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

}