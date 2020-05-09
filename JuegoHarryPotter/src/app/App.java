package app;

public class App {
    public static void main(String[] args) throws Exception {

        JuegoHP juego = new JuegoHP();

        bannerLogoBienvenida();

        juego.inicializarJuego();
        
        juego.start();

        bannerDespedida();

    }

    public static void bannerLogoBienvenida() {

        System.out.println();
        System.out.println("***************************************************************************************************************");
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
        System.out.println("***************************************************************************************************************");
        System.out.println("\n                                             ¡¡¡BIENVENIDOS!!!                                             \n");
    
        System.out.println("Harry Potter y el Torneo de las Cuatro Casas es un juego de pelea por turnos desarrollado en modo historia.");
        System.out.println("Toma el Expreso de Hogwarts para llegar a tiempo a clases, aprende hechizos para el combate y gana la Copa de la Casa.");
        System.out.println("Al finalizar, Dumbledore te dará una sorpresa.\n");

        System.out.println("REGLAS DE JUEGO: ");
        System.out.println("1. Inicias con 90 puntos de salud y 120 puntos de energía mágica.");
        System.out.println("2. El dado mágico te permite obtener números del 0 al 10.");
        System.out.println("3. Un hechizo oscuro te convertirá automáticamente en un mago oscuro y el nivel de daño/curación del hechizo se multiplicará por 2 (1 sola vez).");
        System.out.println("4. Dentro de los artefactos que podrían tocarle a tu personaje, algunos son Reliquias de la Muerte y te harán ganar 1 punto de daño adicional.");
        System.out.println("5. El juego termina cuando uno de los personajes está muerto. \n");

        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
        
    }
    
    
    public static void bannerDespedida() {
    
        System.out.println();
        System.out.println("**************************************************************************************");
        System.out.println();
        System.out.println(" *    *   ***   ****   ****   *    *     *****   *****   *****   ***** *****   ****   ");
        System.out.println(" *    *  *   *  *   *  *   *   *  *      *    *  *   *     *       *   *       *   *  ");
        System.out.println(" ******  *****  ****   ****     *        *****   *   *     *       *   ****    ****   ");
        System.out.println(" *    *  *   *  *   *  *   *    *        *       *   *     *       *   *       *   *  ");
        System.out.println(" *    *  *   *  *    * *    *   *        *       *****     *       *   *****   *    * ");
        System.out.println();
        System.out.println("**************************************************************************************");
        System.out.println();
    }

    
}


