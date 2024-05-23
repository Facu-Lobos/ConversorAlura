import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Conversor convertir = new Conversor();
        int opcion=0;
        double cantidad=0;
        String mensaje= """
                    *************************************************
                    **INGRESE EL TIPO DE MONEDA QUE DESEA CONVERTIR**
                    ************\tLAS OPCIONES SON\t*************
                    
                    1. Dólar =>> Peso Argentino
                    2. Peso Argentino =>> Dólar
                    3. Dólar =>> Real Brasileño
                    4. Real Brasileño =>> Dólar
                    5. Dólar =>> Peso Colombiano
                    6. Peso Colombiano =>> Dólar
                    7. Salir
                    
                    ************************************************
                    """;
        System.out.println("                ***BIENVENIDO***");
        while (opcion != 7){
            System.out.println(mensaje);
            try{
                opcion = Integer.valueOf(lectura.nextLine());
                switch(opcion){
                    case 1:
                        System.out.println("Ingrese el monto a convertir");
                        cantidad = Double.valueOf(lectura.nextLine());
                        ConversorRecord conversorDeUsdAArs = convertir.conexionConversion("USD","ARS", cantidad);
                        System.out.println(" ");
                        System.out.println("Cotización actualizada: ");
                        System.out.println("Moneda Base: \t\t\t\t\t"+ conversorDeUsdAArs.base_code() + " = 1 to " + conversorDeUsdAArs.target_code() + " = " + conversorDeUsdAArs.conversion_rate() );
                        System.out.println("Cantidad de "+conversorDeUsdAArs.base_code()+" a convertir: \t"+ cantidad);
                        System.out.println("-----------------------------------------------");
                        System.out.println("Cantidad Convertida de "+ conversorDeUsdAArs.target_code()+": \t"+ conversorDeUsdAArs.conversion_result());
                        convertir.setTotalConvertido(conversorDeUsdAArs);
                        convertir.registrarConversion("USD","ARS",cantidad);
                        System.out.println(" ");
                        System.out.println("************************************************");
                        System.out.println(" ");
                        break;

                    case 2:
                        System.out.println("Ingrese el monto a convertir");
                        cantidad = Double.valueOf(lectura.nextLine());
                        ConversorRecord conversorDeArsAUsd = convertir.conexionConversion("ARS","USD", cantidad);
                        System.out.println(" ");
                        System.out.println("Cotización actualizada: ");
                        System.out.println("Moneda Base: \t\t\t\t\t"+ conversorDeArsAUsd.base_code() +" = 1 to " + conversorDeArsAUsd.target_code() + " = " + conversorDeArsAUsd.conversion_rate());
                        System.out.println("Cantidad de "+ conversorDeArsAUsd.base_code() + "a convertir: \t"+ cantidad);
                        System.out.println("Cantidad Convertida de "+ conversorDeArsAUsd.target_code()+ ": \t"+ conversorDeArsAUsd.conversion_result());
                        convertir.setTotalConvertido(conversorDeArsAUsd);
                        convertir.registrarConversion("ARS","USD",cantidad);
                        System.out.println(" ");
                        System.out.println("************************************************");
                        System.out.println(" ");
                        break;
                    case 3:
                        System.out.println("Ingrese el monto a convertir");
                        cantidad = Double.valueOf(lectura.nextLine());
                        ConversorRecord conversorDeUsdABrl = convertir.conexionConversion("USD","BRL", cantidad);
                        System.out.println(" ");
                        System.out.println("Cotización actualizada: ");
                        System.out.println("Moneda Base: \t\t\t\t\t"+ conversorDeUsdABrl.base_code()+" = 1 to " + conversorDeUsdABrl.target_code() + " = " + conversorDeUsdABrl.conversion_rate());
                        System.out.println("Cantidad de "+ conversorDeUsdABrl.base_code() +" a convertir: \t"+ cantidad);
                        System.out.println("Cantidad de "+ conversorDeUsdABrl.target_code() + " Convertida: \t"+ conversorDeUsdABrl.conversion_result());
                        convertir.setTotalConvertido(conversorDeUsdABrl);
                        convertir.registrarConversion("USD","BRL",cantidad);
                        System.out.println(" ");
                        System.out.println("************************************************");
                        System.out.println(" ");
                        break;

                    case 4:
                        System.out.println("Ingrese el monto a convertir");
                        cantidad = Double.valueOf(lectura.nextLine());
                        ConversorRecord conversorDeBrlAUsd = convertir.conexionConversion("BRL","USD", cantidad);
                        System.out.println(" ");
                        System.out.println("Cotización actualizada: ");
                        System.out.println("Moneda Base: \t\t\t\t\t"+ conversorDeBrlAUsd.base_code() +" = 1 to "+ conversorDeBrlAUsd.target_code() + " = " + conversorDeBrlAUsd.conversion_rate());
                        System.out.println("Cantidad de " + conversorDeBrlAUsd.base_code() +" a convertir: \t"+ cantidad);
                        System.out.println("Cantidad de "+ conversorDeBrlAUsd.target_code() + " Convertida: \t"+ conversorDeBrlAUsd.conversion_result());
                        convertir.setTotalConvertido(conversorDeBrlAUsd);
                        convertir.registrarConversion("BRL","USD",cantidad);
                        System.out.println(" ");
                        System.out.println("************************************************");
                        System.out.println(" ");
                        break;

                    case 5:
                        System.out.println("Ingrese el monto a convertir");
                        cantidad = Double.valueOf(lectura.nextLine());
                        ConversorRecord conversorDeUsdACop = convertir.conexionConversion("USD","COP", cantidad);
                        System.out.println(" ");
                        System.out.println("Cotización actualizada: ");
                        System.out.println("Moneda Base: \t\t\t\t\t"+ conversorDeUsdACop.base_code() + " = 1 to " + conversorDeUsdACop.target_code() + " = " + conversorDeUsdACop.conversion_rate());
                        System.out.println("Cantidad de "+ conversorDeUsdACop.base_code() +" a convertir: \t"+ cantidad);
                        System.out.println("Cantidad de "+ conversorDeUsdACop.target_code() +" Convertida: \t"+ conversorDeUsdACop.conversion_result());
                        convertir.setTotalConvertido(conversorDeUsdACop);
                        convertir.registrarConversion("USD","COP",cantidad);
                        System.out.println(" ");
                        System.out.println("************************************************");
                        System.out.println(" ");
                        break;

                    case 6:
                        System.out.println("Ingrese el monto a convertir");
                        cantidad = Double.valueOf(lectura.nextLine());
                        ConversorRecord conversorDeCopAUsd = convertir.conexionConversion("COP","USD", cantidad);
                        System.out.println(" ");
                        System.out.println("Cotización actualizada: ");
                        System.out.println("Moneda Base: \t\t\t\t\t"+ conversorDeCopAUsd.base_code() + " = 1 to "+ conversorDeCopAUsd.target_code() + " = " + conversorDeCopAUsd.conversion_rate());
                        System.out.println("Cantidad de "+ conversorDeCopAUsd.base_code() + " a convertir: \t"+ cantidad);
                        System.out.println("Cantidad de "+ conversorDeCopAUsd.target_code() + " Convertida: \t"+ conversorDeCopAUsd.conversion_result());
                        convertir.setTotalConvertido(conversorDeCopAUsd);
                        convertir.registrarConversion("COP","USD",cantidad);
                        System.out.println(" ");
                        System.out.println("************************************************");
                        System.out.println(" ");
                        break;

                    case 7:
                        System.out.println("Gracias por haber utilizado nuestro servicio." +
                                "\n\t**Hasta la próxima**");
                        break;

                    default:
                        System.out.println("Ingrese una opción válida");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Opción inválida...Ingrese un numero entero por favor.");
            }

        }
        System.out.println("************************************************************************************" +
                "\n\t\t\t\t**El historial de conversion es**\n");
        System.out.println(convertir.toString()+"" +
                "\n************************************************************************************");

    }

}
