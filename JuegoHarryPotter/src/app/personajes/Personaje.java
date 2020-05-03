package app.personajes;

public abstract class Personaje {

    private String nombre;
    private int salud;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public  boolean estaVivo(){
        return salud > 0 ;
    }

    public void disminuirSalud(int danio){

        int saludRestante = this.getSalud() - danio;

        this.setSalud(saludRestante);

    }

}