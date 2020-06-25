package app;

public class App {

    //Cada vez que en el juego aparece un ENTER presionar una, dos, o tres veces.

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) throws Exception {

        JuegoHP juego = new JuegoHP();

        juego.inicializarJuego();

    }
    
}


