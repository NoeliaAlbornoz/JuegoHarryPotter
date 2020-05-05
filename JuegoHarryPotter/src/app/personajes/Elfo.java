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
        
        this.hechizos.add(h);

        System.out.println("Has aprendido el hechizo " + h.getNombre());

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {

        this.disminuirEnergiaMagica(energiaMagica, hechizo);

        personaje.disminuirSalud(hechizo, artefacto);

        this.aumentarSaludConCuracion(hechizo, artefacto);

        this.atacar(personaje, hechizo.getNombre());

        System.out.println("Tu artefacto " + artefacto.getNombre() + " genera un daño adicional de "
                + this.utilizarDanioDeArtefacto(hechizo, artefacto) + " puntos. ");

        System.out.println("Tu artefacto " + artefacto.getNombre() + " genera una curación adicional de "
                + this.utilizarCuracionDeArtefacto(hechizo, artefacto) + " puntos. ");

    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {

        System.out.println("Has atacado con " + hechizo);

        System.out.println("Te quedan " + this.energiaMagica + " puntos de energía mágica.");

    }

    public void aumentarSaludConCuracion(Hechizo hechizo, Artefacto artefacto) {

        int saludAumentada = this.getSalud() + hechizo.getNivelCuracion()
                + this.utilizarCuracionDeArtefacto(hechizo, artefacto);

        this.setSalud(saludAumentada);

    }

    public void disminuirEnergiaMagica(int energiaMagica, Hechizo hechizo) {

        int energiaMagicaResultante = this.energiaMagica - hechizo.getEnergiaMagica();

        this.setEnergiaMagica(energiaMagicaResultante);

    }

}