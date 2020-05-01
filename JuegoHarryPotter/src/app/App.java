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


