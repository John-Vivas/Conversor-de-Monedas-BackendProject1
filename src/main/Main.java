package main;


import filter.ConvertirMoney;
import models.ConsultaAPI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsultaAPI consulta = new ConsultaAPI();
        Scanner read = new Scanner(System.in);
        ConvertirMoney convertidor = new ConvertirMoney();

        while (true) {
            showMenu();
            try {
                int currencyChoice = read.nextInt();
                read.nextLine();

                if (currencyChoice == 11) {
                    System.out.println("Saliendo...");
                    break;
                }

                if (currencyChoice < 1 || currencyChoice > 10) {
                    System.out.println("Opción incorrecta. Por favor, ingrese del 1 al 11.");
                    continue;
                }
        // leo mi archivo ConvertidorMoney para ejecucion
                convertidor.convertidorMoneda(currencyChoice, read, consulta);
            }catch (InputMismatchException e){
                System.out.println("Error debes ingresar un numero entre 1 al 11. NO OTRO CARACTER :)");
                read.nextLine();
            }

        }
        read.close();
    }
    // funcion menu para hacer mas legible el codigo
    private static void showMenu() {
        System.out.println(
                "1- COP - Peso colombiano a --> dolar \n" +
                        "2- USD - dolar a--> Peso colombiano \n\n" +
                        "3- BOB - Boliviano boliviano a --> dolar \n" +
                        "4- USD - dolar a --> Boliviano boliviano \n\n" +
                        "5- BRL - Real brasileño a --> dolar \n" +
                        "6- USD - dolar a --> Real brasileño \n\n" +
                        "7- CLP - Peso chileno a --> dolar \n" +
                        "8- USD - dolar a --> Peso chileno \n\n" +
                        "9- ARS - Peso argentino a --> dolar \n" +
                        "10- USD - dolar a --> Peso argentino \n\n" +
                        "11- Salir"
        );
        System.out.println("Escoge la divisa a convertir: ");
        System.out.println("______________________________");
    }
}
