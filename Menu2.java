import java.util.*;

public class Menu2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("MENU");
            System.out.println("1. Calcular factorial de un número");
            System.out.println("2. Calcular potencia de un número");
            System.out.println("3. Calcular media aritmética de una lista de números");
            System.out.println("4. Calcular máximo común divisor de dos números");
            System.out.println("5. Calcular número de combinaciones posibles de n elementos tomados de k en k");
            System.out.println("6. Calcular número de números primos que hay entre 2 y n");
            System.out.println("7. Calcular número de ocurrencias de un elemento en una lista");
            System.out.println("8. Determinar si un número es palíndromo o no");
            System.out.println("9. Salir");
            System.out.println("Ingrese su opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese un número entero positivo: ");
                    int n1 = scanner.nextInt();
                    int factorial = calcularFactorial(n1);
                    System.out.println("El factorial de " + n1 + " es: " + factorial);
                    break;
                case 2:
                    System.out.println("Ingrese la base: ");
                    int base = scanner.nextInt();
                    System.out.println("Ingrese el exponente: ");
                    int exponente = scanner.nextInt();
                    double potencia = calcularPotencia(base, exponente);
                    System.out.println(base + " elevado a " + exponente + " es: " + potencia);
                    break;
                case 3:
                    System.out.println("Ingrese los números separados por coma: ");
                    String numeros = scanner.next();
                    double media = calcularMedia(numeros);
                    System.out.println("La media aritmética de la lista es: " + media);
                    break;
                case 4:
                    System.out.println("Ingrese el primer número: ");
                    int n2 = scanner.nextInt();
                    System.out.println("Ingrese el segundo número: ");
                    int n3 = scanner.nextInt();
                    int mcd = calcularMCD(n2, n3);
                    System.out.println("El máximo común divisor de " + n2 + " y " + n3 + " es: " + mcd);
                    break;
                case 5:
                    System.out.println("Ingrese el número total de elementos: ");
                    int n = scanner.nextInt();
                    System.out.println("Ingrese el número de elementos que se van a tomar: ");
                    int k = scanner.nextInt();
                    int combinaciones = calcularCombinaciones(n, k);
                    System.out.println("El número de combinaciones posibles es: " + combinaciones);
                    break;
                case 6:
                    System.out.println("Ingrese un número entero positivo: ");
                    int n4 = scanner.nextInt();
                    int numerosPrimos = calcularNumerosPrimos(n4);
                    System.out.println("El número de números primos entre 2 y " + n4 + " es: " + numerosPrimos);
                    break;
                case 7:
                    System.out.println("Ingrese los números separados por coma: ");
                    String listaNumeros = scanner.next();
                    System.out.println("Ingrese el número que desea buscar: ");
                    int numeroBuscado = scanner.nextInt();
                    int ocurrencias = calcularOcurrencias(listaNumeros, numeroBuscado);
                    System.out.println("El número " + numeroBuscado + " aparece " + ocurrencias + " veces en la lista.");
                    break;
                case 8:
                    System.out.println("Ingrese un número entero positivo: ");
                    int numero = scanner.nextInt();
                    boolean esPalindromo = verificarPalindromo(numero);
                    if (esPalindromo) {
                        System.out.println("El número " + numero + " es palíndromo.");
                    } else {
                        System.out.println("El número " + numero + " no es palíndromo.");
                    }
                    break;
                case 9:
                    System.out.println("Adiós!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor ingrese una opción válida.");
            }
    
        } while (opcion != 9);
    }
    
    // Función para calcular el factorial de un número entero positivo
    public static int calcularFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calcularFactorial(n-1);
        }
    }
    
    // Función para calcular la potencia de un número entero
    public static double calcularPotencia(int base, int exponente) {
        return Math.pow(base, exponente);
    }
    
    // Función para calcular la media aritmética de una lista de números
    public static double calcularMedia(String numeros) {
        String[] listaNumeros = numeros.split(",");
        int suma = 0;
        for (int i = 0; i < listaNumeros.length; i++) {
            suma += Integer.parseInt(listaNumeros[i]);
        }
        return (double) suma / listaNumeros.length;
    }
    
    // Función para calcular el máximo común divisor de dos números enteros
    public static int calcularMCD(int n1, int n2) {
        int maximo = Math.max(n1, n2);
        int minimo = Math.min(n1, n2);
        int resto = maximo % minimo;
        if (resto == 0) {
            return minimo;
        } else {
            return calcularMCD(minimo, resto);
        }
    }
    
    // Función para calcular el número de combinaciones posibles de n elementos tomados de k en k
    public static int calcularCombinaciones(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return calcularCombinaciones(n-1, k-1) + calcularCombinaciones(n-1, k);
        }
    }
    
    // Función para calcular el número de números primos entre 2 y n
    public static int calcularNumerosPrimos(int n) {
        int contador = 0;
        for (int i = 2; i <= n; i++) {
            if (esPrimo(i)) {
                contador++;
            }
        }
        return contador;
    }
    
    // Función auxiliar para verificar si un número es primo
    public static boolean esPrimo(int numero) {
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // Función para calcular el número de ocurrencias de un elemento en una lista
    public static int calcularOcurrencias(String listaNumeros, int numeroBuscado) {
        String[] lista = listaNumeros.split(",");
        int contador = 0;
        for (int i = 0; i < lista.length; i++) {
            if (Integer.parseInt(lista[i]) == numeroBuscado) {
            contador++;
            }
        }
        return contador;
     }

     // Función para verificar si un número es palíndromo
public static boolean verificarPalindromo(int numero) {
    int numeroInvertido = 0;
    int numeroOriginal = numero;
    while (numero > 0) {
        int digito = numero % 10;
        numeroInvertido = numeroInvertido * 10 + digito;
        numero = numero / 10;
     }
    return numeroOriginal == numeroInvertido;
    }
 }
    
