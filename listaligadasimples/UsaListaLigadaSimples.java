package listaligadasimples;

import java.util.Scanner;

class UsaNo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaLigadaSimples lista = new ListaLigadaSimples();

        int resposta;

        do {
            exibeMenu();
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    System.out.println("Digite o valor do item: ");
                    lista.insereInicio(scanner.nextInt());
                    break;
                case 2:
                    lista.removeInicio();
                    break;
                case 3:
                    System.out.println("Digite o valor do item: ");
                    lista.insereFim(scanner.nextInt());
                    break;
                case 4:
                    lista.removeFim();
                    break;
                case 5:
                    System.out.println("Digite o valor do novo item: ");
                    int infoNovoItem = scanner.nextInt();
                    System.out.println("Digite o valor do item específico: ");
                    int infoItemEspecifico = scanner.nextInt();
                    lista.insereMeio(infoNovoItem, infoItemEspecifico);
                    break;
                case 6:
                    System.out.println("Digite o valor do item: ");
                    lista.removeMeio(scanner.nextInt());
                    break;
                case 7:
                    lista.imprime();
                    break;
                case 8:
                    break;
            }
        } while (resposta != 8);

        scanner.close();
    }

    public static void exibeMenu() {
        System.out.println("Digite uma opção: ");
        System.out.println("1 - Inserir item no início da lista");
        System.out.println("2 - Remover item no início da lista");
        System.out.println("3 - Inserir item no final da lista");
        System.out.println("4 - Remover item no final da lista");
        System.out.println("5 - Inserir item no meio da lista");
        System.out.println("6 - Remover item no meio da lista");
        System.out.println("7 - Imprimir lista");
        System.out.println("8 - Sair");
    }

}
