package app.personajes;

import java.util.ArrayList;
import java.util.List;

import app.IHaceMagia;
import app.artefactos.Artefacto;
import app.poderes.Hechizo;
import app.poderes.Poder;
import app.transportes.Escoba;

public class Wizard extends Persona implements IHaceMagia {

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

        this.hechizos.add(h);

        System.out.println("Has aprendido el hechizo " + h.getNombre());

    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {

        this.confirmarHechizoOscuro(hechizo);

        this.disminuirEnergiaMagica(energiaMagica, hechizo);

        personaje.disminuirSalud(hechizo, artefacto);

        this.aumentarSaludConCuracion(hechizo, artefacto);

        this.atacar(personaje, hechizo.getNombre());

        System.out.println("Tu artefacto " + artefacto.getNombre() + " genera un daño adicional de "
                + this.utilizarDanioDeArtefacto(hechizo, artefacto) + " puntos. ");

        System.out.println("Tu artefacto " + artefacto.getNombre() + " genera una curación adicional de "
                + this.utilizarCuracionDeArtefacto(hechizo, artefacto) + " puntos. ");

    }

    public void aumentarSaludConCuracion(Hechizo hechizo, Artefacto artefacto) {

        int saludAumentada = this.getSalud() + hechizo.getNivelCuracion()
                + this.utilizarCuracionDeArtefacto(hechizo, artefacto);

        this.setSalud(saludAumentada);

    }

    public void confirmarHechizoOscuro(Hechizo hechizo) {

        if (hechizo.isEsOscuro()) {

            int nuevoDanio = hechizo.getNivelDanio() * 2;
            hechizo.setNivelDanio(nuevoDanio);

            int nuevoCuracion = hechizo.getNivelCuracion() * 2;
            hechizo.setNivelCuracion(nuevoCuracion);

            this.magoOscuro = true;

            hechizo.setEsOscuro(false);

            System.out.println("Sectumsempra es un hechizo oscuro. Su daño y curación se multiplican por 2."
                    + this.getNombre() + " es ahora un mago oscuro.");

        }

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

}