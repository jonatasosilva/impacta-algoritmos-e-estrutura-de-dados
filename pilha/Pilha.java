package pilha;

public class Pilha {
    
    No inicio, fim;

    private boolean pilhaTemMaisDeUmItem() {
        return this.inicio != this.fim;
    }

    private boolean pilhaEstaVazia() {
        return this.inicio == null && this.fim == null;
    }

    private boolean pilhaTemSomenteUmItem() {
        return !pilhaEstaVazia() && (this.inicio == this.fim);
    }

    public void insere(int info) {
        No novoItem = new No(info);

        if (pilhaEstaVazia()) {
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
        if (pilhaTemMaisDeUmItem()) {
            System.out.println("Removendo o item " + this.fim.info);
            No penultimoItem = this.fim.anterior;
            penultimoItem.proximo = null;
            this.fim = penultimoItem;
        } else if (pilhaTemSomenteUmItem()) {
            System.out.println("Removendo o item " + this.fim.info);
            this.inicio = null;
            this.fim = null;
        } else {
            System.out.println("Pilha vazia");
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
