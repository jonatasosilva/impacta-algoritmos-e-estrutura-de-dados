package fila;

import java.util.Scanner;

public class UsaFila {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila fila = new Fila();

        int resposta;

        do {
            exibeMenu();
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    System.out.println("Digite o valor do item: ");
                    fila.insere(scanner.nextInt());
                    break;
                case 2:
                    fila.remove();
                    break;
                case 3:
                    fila.imprime();
                    break;
                case 4:
                    break;
            }
        } while (resposta != 4);

        scanner.close();
    }

    public static void exibeMenu() {
        System.out.println("Digite uma opção: ");
        System.out.println("1 - Inserir item na fila");
        System.out.println("2 - Remover item da fila");
        System.out.println("3 - Imprimir lista");
        System.out.println("4 - Sair");
    }

}
