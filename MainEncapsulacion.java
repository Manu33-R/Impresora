import java.util.Scanner;

public class MainEncapsulacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int canttoner = -1;
        int cantpag = 0;
        int addtoner = -1;
        int pagimp = -1;
        int opcion = 0;




        while (canttoner < 0 || canttoner > 100) {//Valor de toner inicial
            try {
                System.out.println("Introduce la cantidad inicial de toner (0-100): ");
                canttoner = sc.nextInt();
            }catch (Exception e){
                System.out.println("Error cantidad de toner inicial incorrecta.");
                sc.next();
            }
        }

        Impresora impresora1 = new Impresora(canttoner,cantpag,true);
        Impresora impresora2 = new Impresora(canttoner,cantpag,false);
        System.out.println("Impresora con impresion doble cara: " + impresora1.toString());
        System.out.println("Impresora sin impresion doble cara: " + impresora2.toString());

        while (opcion != 3){
            opcion = 0;
            if (impresora1.getToner() == -1){
                System.out.println("Toner excedido.");
                opcion=3;
            }else {
                try {
                    System.out.println("¿Que quieres hacer?\n" +
                            "1. Añadir toner.\n" +
                            "2. Imprimir páginas/hojas.\n" +
                            "3. Salir.");
                    opcion = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Error, opcion incorrecta.");
                    sc.next();
                }

                switch (opcion) {
                    case 1://Añadir toner
                        boolean toner = true;
                        while (toner) {
                            try {
                                System.out.println("¿Cuanta cantidad de toner quieres añadir? (0-100)");
                                addtoner = sc.nextInt();
                                toner = false;
                            } catch (Exception e) {
                                System.out.println("Error, cantidad de toner incorrecta.");
                                sc.next();
                            }
                        }
                        impresora1.addToner(addtoner);
                        impresora2.addToner(addtoner);
                        break;
                    case 2://Imprimir paginas
                        boolean imprimir = true;
                        while (imprimir) {
                            try {
                                System.out.println("¿Cuantas páginas quieres imprimir?");
                                pagimp = sc.nextInt();
                                imprimir = false;
                            } catch (Exception e) {
                                System.out.println("Error, cantidad de páginas incorrecta.");
                                sc.next();
                            }
                        }
                        impresora1.impPag(pagimp);
                        impresora2.impPag(pagimp);
                        break;
                    case 3://Salir de la impresora
                        System.out.println("Saliendo de la impresora.");
                }
                if (opcion == 1 || opcion == 2 || opcion == 3)
                    System.out.println("Impresora con impresion doble cara: " + impresora1.toString());
                System.out.println("Impresora sin impresion doble cara: " + impresora2.toString());
            }
        }
    }
}
