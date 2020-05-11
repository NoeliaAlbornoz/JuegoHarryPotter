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

        bannerLogoBienvenida();

        juego.inicializarJuego();
        
        juego.start();

        bannerDespedida();

    }

    public static void bannerLogoBienvenida() {

        System.out.println();
        System.out.println(ANSI_YELLOW + "***************************************************************************************************************");
        System.out.println("*                                                                                                             *");
        System.out.println("*                                                     ******    **                                            *");
        System.out.println("*                                                      ***** *    ***                                         *");
        System.out.println("*  *****     *****                                      ****      ***                                         *");
        System.out.println("*    ***     ***                    *****        *      ****      ***                  *                      *");
        System.out.println("*    ***     ***                    *      *    *       ****      ***          *       *                      *");
        System.out.println("*    ***     ***    *****   *****   *       *  *         ***  *   **           *     *****      * *           *");
        System.out.println("*    ***********        *   *       *        *       *******   *             *****     *       *   *          *");
        System.out.println("*    ***     ***    *****   *            *   *          ****         *  *      *       *       *****          *");
        System.out.println("*    ***     ***    *   *   *              *              **        *    *     *       *       *       *****  *");
        System.out.println("*    ***     ***    *****                              *****        *    *     *       * *      * *    *      *");
        System.out.println("*  *****     *****                                       ***        *    *     *       * *             *      *");
        System.out.println("*                                                         **         *  *      * *      *              *      *");
        System.out.println("*                                                          *                   * *                            *");
        System.out.println("*                                                                                                             *");
        System.out.println("***************************************************************************************************************" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "\n                                             ¡¡¡" + ANSI_RESET  + "BIENVENIDOS" + ANSI_PURPLE + "!!!                                             \n" + ANSI_RESET);
    
        System.out.println(ANSI_GREEN + " Harry Potter y el Torneo de las Cuatro Casas" + ANSI_RESET + " es un juego de pelea por turnos desarrollado en modo historia.");
        System.out.println("Toma el Expreso de Hogwarts para llegar a tiempo a clases, aprende hechizos para el combate y gana la Copa de la Casa.");
        System.out.println("Al finalizar, Dumbledore te dará una sorpresa.\n");

        System.out.println(ANSI_RED + "REGLAS DE JUEGO: " + ANSI_RESET);
        System.out.println("1. Inicias con 90 puntos de salud y 120 puntos de energía mágica.");
        System.out.println("2. El dado mágico te permite obtener números del 0 al 10.");
        System.out.println("3. Un hechizo oscuro te convertirá automáticamente en un mago oscuro y el nivel de daño/curación del hechizo se multiplicará por 2 (1 sola vez).");
        System.out.println("4. Algunos artefactos son Reliquias de la Muerte y te harán ganar 1 punto de daño adicional.");
        System.out.println("5. Tú y tu oponente no pueden seleccionar el mismo personaje.");
        System.out.println("6. Debes aprender tus hechizos en orden cronológico.");
        System.out.println("7. Algunos personajes acumularán puntos de poder para reclamar un premio especial al final del juego (debes tener más de 50).");
        System.out.println("8. El juego termina cuando uno de los personajes está muerto. \n");

        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
        
    }
    
    
    public static void bannerDespedida() {
    
        System.out.println();
        System.out.println(ANSI_YELLOW + "**************************************************************************************");
        System.out.println();
        System.out.println(" *    *   ***   ****   ****   *    *     *****   *****   *****   ***** *****   ****   ");
        System.out.println(" *    *  *   *  *   *  *   *   *  *      *    *  *   *     *       *   *       *   *  ");
        System.out.println(" ******  *****  ****   ****     *        *****   *   *     *       *   ****    ****   ");
        System.out.println(" *    *  *   *  *   *  *   *    *        *       *   *     *       *   *       *   *  ");
        System.out.println(" *    *  *   *  *    * *    *   *        *       *****     *       *   *****   *    * ");
        System.out.println();
        System.out.println("**************************************************************************************" + ANSI_RESET);
        System.out.println();
    }

    
}


