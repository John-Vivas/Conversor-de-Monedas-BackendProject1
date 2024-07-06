package filter;

import models.ConsultaAPI;
import models.Money;


import java.util.HashMap;
import java.util.Scanner;

public class ConvertirMoney {
    public void convertidorMoneda(int currencyChoice, Scanner read, ConsultaAPI consulta) {
        // organizo mis variables
        String typeMoney;
        String moneyToChange;
// tipos y eleccion de divisas con switch
        switch (currencyChoice) {
            case 1:
                typeMoney = "COP";
                moneyToChange = "USD";
                System.out.println("Cambio de pesos Colombianos a dolares");
                break;
            case 2:
                typeMoney = "COP";
                moneyToChange = "USD";
                System.out.println("Cambio de dolares  a pesos Colombianos");
                break;
            case 3:
                typeMoney = "BOB";
                moneyToChange = "USD";
                System.out.println("Cambio de Boliviano a dolares");
                break;
            case 4:
                typeMoney = "BOB";
                moneyToChange = "USD";
                System.out.println("Cambio de Dolares a Boliviano ");
                break;
            case 5:
                typeMoney = "BRL";
                moneyToChange = "USD";
                System.out.println("Cambio de Real brasileño a dolares");
                break;
            case 6:
                typeMoney ="BRL" ;
                moneyToChange = "USD";
                System.out.println("Cambio de dolares a Real brasileño");
                break;
            case 7:
                typeMoney = "CLP";
                moneyToChange = "USD";
                System.out.println("Cambio de pesos Chilenos a dolares");
                break;
            case 8:
                typeMoney = "CLP";
                moneyToChange = "USD";
                System.out.println("Cambio de dolares a pesos  Chilenos");
                break;
            case 9:
                typeMoney ="ARS";
                moneyToChange = "USD" ;
                System.out.println("Cambio de pesos Argentinos a dolares");
                break;
            case 10:
                typeMoney = "ARS";
                moneyToChange = "USD";
                System.out.println("Cambio de dolares a  pesos Argentinos");
                break;
            default:

                System.out.println("Opción no encontrada.");
                return;
        }

        try {
            // traigo de mi record money para utilizar la api
            Money money = consulta.busquedaMoneda(typeMoney);
            HashMap<String, Double> conversion = money.conversion_rates();
            if (conversion.containsKey(moneyToChange)) {
                double typeChange = conversion.get(moneyToChange);
                System.out.println("Ingrese la cantidad que desea convertir: ");
                double cantidadMoney = read.nextDouble();
                read.nextLine();

                if (currencyChoice % 2 != 0) {
                    // Convierte de moneda Ingreda a dólares
                    double convierteAmount = cantidadMoney * typeChange;


                    System.out.printf("Cantidad convertida: %.2f %s a dólares: %.2f USD%n", cantidadMoney, typeMoney, convierteAmount);

                    System.out.println("*************************************************************************");
                } else {
                    // Convierte de dólares a moneda escogida
                    double convierteAmount = cantidadMoney /typeChange ;

                    System.out.printf("Cantidad convertida de dólares: %.2f USD a %.2f %s%n", cantidadMoney, convierteAmount, typeMoney);
                    
                    System.out.println("*************************************************************************");
                }
            } else {
                System.out.println("No se encontró la divisa");
            }
        } catch (NumberFormatException e) {
            System.out.println("Divisa no encontrada: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalización de programa");
        }
    }
}
