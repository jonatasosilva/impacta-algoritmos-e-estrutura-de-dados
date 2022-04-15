package pilha;

import java.util.Scanner;

public class UsaPilha {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha pilha = new Pilha();

        int resposta;

        do {
            exibeMenu();
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    System.out.println("Digite o valor do item: ");
                    pilha.insere(scanner.nextInt());
                    break;
                case 2:
                    pilha.remove();
                    break;
                case 3:
                    pilha.imprime();
                    break;
                case 4:
                    break;
            }
        } while (resposta != 4);

        scanner.close();
    }

    public static void exibeMenu() {
        System.out.println("Digite uma opção: ");
        System.out.println("1 - Inserir item na pilha");
        System.out.println("2 - Remover item da pilha");
        System.out.println("3 - Imprimir lista");
        System.out.println("4 - Sair");
    }

}
