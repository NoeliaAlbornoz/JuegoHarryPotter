package app;

import app.artefactos.Artefacto;
import app.personajes.Personaje;
import app.poderes.Hechizo;
import app.poderes.Poder;

public interface IHaceMagia {

    int getEnergiaMagica();

    void setEnergiaMagica(int energiaMagica);

    Poder getPoderInicial();

    void setPoder(Poder poder);

    Artefacto getArtefacto();

    void aprender(Hechizo h);

    void atacar(Personaje personaje, Hechizo hechizo);

    void atacar(Personaje personaje, String hechizo);

}