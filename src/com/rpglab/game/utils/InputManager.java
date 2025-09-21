package com.rpglab.game.utils;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class InputManager {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readWholeNumber(String mensage, int min, int max) {

        while (true) {
            System.out.print(mensage + " (" + min + " - " + max + ")  > ");
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Entrada vazia. Digite um número.");
                    continue;
                }
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.println("Valor fora do intervalo permitido.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada não disponível.", e);
            }
        }    
    }

    public static String readString(String mensage) {
        System.out.print(mensage);
        return scanner.nextLine().trim(); //next line vai ate o enter e o trim tira os espacos
    } 

    public static boolean readYesNo(String mensage) {
        while (true) {
            System.out.print(mensage + " (s/n): ");
            String entrada = scanner.nextLine().trim().toLowerCase(); //to lowercase para aceitar maiusculas e minusculas
            if (entrada.equals("s")) return true;
            if (entrada.equals("n")) return false;
            System.out.println("Entrada inválida. Digite apenas 's' ou 'n'.");
        }
    }
    
    public static void esperarEnter(String mensage) {
        System.out.print(mensage);
        scanner.nextLine(); // pausa até Enter
    }

    public static void close() {
        scanner.close();
    }
}