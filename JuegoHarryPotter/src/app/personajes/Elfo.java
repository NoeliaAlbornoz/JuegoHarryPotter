package app.personajes;

import java.util.List;

import app.IHaceMagia;
import app.artefactos.Artefacto;
import app.poderes.Hechizo;
import app.poderes.Poder;

public class Elfo extends Criatura implements IHaceMagia {

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

    @Override
    public Poder getPoderInicial() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPoder(Poder poder) {
        // TODO Auto-generated method stub

    }

    @Override
    public void aprender(Hechizo h) {
        // TODO Auto-generated method stub

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {
        // TODO Auto-generated method stub

    }

}