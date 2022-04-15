package fila;

public class Fila {
    
    No inicio, fim;

    private boolean filaTemMaisDeUmItem() {
        return this.inicio != this.fim;
    }

    private boolean filaEstaVazia() {
        return this.inicio == null && this.fim == null;
    }

    private boolean filaTemSomenteUmItem() {
        return !filaEstaVazia() && (this.inicio == this.fim);
    }

    public void insere(int info) {
        No novoItem = new No(info);

        if (filaEstaVazia()) {
            this.inicio = novoItem;
            this.fim = novoItem;
        } else {
            No fimAtual = this.fim;
            fimAtual.proximo = novoItem;
            novoItem.anterior = fimAtual;
            this.fim = novoItem;
        }
    }

    public void remove() {
        if (filaTemMaisDeUmItem()) {
            System.out.println("Removendo o item " + this.inicio.info);
            this.inicio = this.inicio.proximo;
            this.inicio.anterior = null;
        } else if (filaTemSomenteUmItem()) {
            System.out.println("Removendo o item " + this.inicio.info);
            this.inicio = null;
            this.fim = null;
        } else {
            System.out.println("Fila vazia");
        }
    }

    public void imprime() {
        No aux = this.inicio;
        while (aux != null) {
            System.out.println("aux.info " + aux.info);
            aux = aux.proximo;
        }
    }

}
