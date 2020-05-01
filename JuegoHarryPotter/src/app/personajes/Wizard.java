package app.personajes;

import java.util.ArrayList;
import java.util.List;

import app.IHaceMagia;
import app.artefactos.Artefacto;
import app.poderes.Hechizo;
import app.poderes.Poder;
import app.transportes.Escoba;
public class Wizard extends Persona implements IHaceMagia{

    private int energiaMagica;
    private List<Hechizo> hechizos = new ArrayList<>();
    private Escoba escoba;
    private Poder poderInicial;
    private Artefacto artefacto;
    private boolean magoOscuro;

    public int getEnergiaMagica() {
        return energiaMagica;
    }

    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public Escoba getEscoba() {
        return escoba;
    }

    public void setEscoba(Escoba escoba) {
        this.escoba = escoba;
    }

    public Poder getPoderInicial() {
        return poderInicial;
    }

    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    }

    public Artefacto getArtefacto() {
        return artefacto;
    }

    public void setArtefacto(Artefacto artefacto) {
        this.artefacto = artefacto;
    }

    public boolean isMagoOscuro() {
        return magoOscuro;
    }

    public void setMagoOscuro(boolean magoOscuro) {
        this.magoOscuro = magoOscuro;
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
        this.energiaMagica -= hechizo.getEnergiaMagica();
        int energiaRestante = hechizo.getEnergiaMagica() - hechizo.getEnergiaMagica();
        hechizo.setEnergiaMagica(energiaRestante);
        int saludRestante = personaje.getSalud() - hechizo.getNivelDanio();
        personaje.setSalud(saludRestante);

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {
        // TODO Auto-generated method stub

    }

}