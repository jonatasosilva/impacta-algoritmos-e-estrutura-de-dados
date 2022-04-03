package listaligada;

public class NoRef {

    No inicio, fim;

    private boolean listaTemMaisDeUmItem() {
        return this.inicio != this.fim;
    }

    private boolean listaEstaVazia() {
        return this.inicio == null && this.fim == null;
    }

    private boolean listaTemSomenteUmItem() {
        return !listaEstaVazia() && (this.inicio == this.fim);
    }

    public void insereInicio(int info) {
        No novoItem = new No(info);

        if (listaEstaVazia()) {
            this.inicio = novoItem;
            this.fim = novoItem;
        } else {
            novoItem.proximo = this.inicio;
            this.inicio = novoItem;
        }
    }

    public void removeInicio() {
        if (listaTemMaisDeUmItem()) {
            System.out.println("Removendo o item " + this.inicio.info);
            this.inicio = this.inicio.proximo;
        } else if (listaTemSomenteUmItem()) {
            System.out.println("Removendo o item " + this.inicio.info);
            this.inicio = null;
            this.fim = null;
        } else {
            System.out.println("Lista vazia");
        }
    }

    public void insereFim(int info) {
        No novoItem = new No(info);

        if (listaEstaVazia()) {
            this.inicio = novoItem;
            this.fim = novoItem;
        } else {
            No fimAtual = this.fim;
            fimAtual.proximo = novoItem;
            this.fim = novoItem;
        }
    }

    private No obtemPenultimoItem() {
        No item = this.inicio;
        while (item.proximo != this.fim) {
            item = item.proximo;
        }
        return item;
    }

    public void removeFim() {
        if (listaTemMaisDeUmItem()) {
            System.out.println("Removendo o item " + this.fim.info);
            No penultimoItem = obtemPenultimoItem();
            penultimoItem.proximo = null;
            this.fim = penultimoItem;
        } else if (listaTemSomenteUmItem()) {
            System.out.println("Removendo o item " + this.fim.info);
            this.inicio = null;
            this.fim = null;
        } else {
            System.out.println("Lista vazia");
        }
    }

    private No localizaItemPorValor(int valor) {
    	No aux = this.inicio;
    	while (aux != null) {
    		if (aux.info == valor) {
    			return aux;
    		}
    		aux = aux.proximo;
    	}
    	return null;
    }

    public No[] insereItemDepoisDoValor(int valorNovoItem, int valorItemDesejado) {
    	No novoItem = new No(valorNovoItem);
    	No itemDesejado = this.localizaItemPorValor(valorItemDesejado);
    	No aux = itemDesejado.proximo;
    	
    	itemDesejado.proximo = novoItem;
    	novoItem.proximo = aux;

        return new No[] {novoItem, itemDesejado};
    }
    
    public void insereItemAntesDoValor(int valorNovoItem, int valorItemDesejado) {
    	No[] items = insereItemDepoisDoValor(valorNovoItem, valorItemDesejado);
        No novoItem = items[0];
        No itemDesejado = items[1];
    	
    	int auxValor = itemDesejado.info;
    	itemDesejado.info = novoItem.info;
    	novoItem.info = auxValor;
    }

    private boolean itemEstaNoMeio(No item) {
        return item != null && this.inicio != item && this.fim != item;
    }

    public void removeMeio(int info) {
        No item = localizaItemPorValor(info);
        if (itemEstaNoMeio(item)) {
            No proximoItem = item.proximo;
            item.info = proximoItem.info;
            item.proximo = proximoItem.proximo;
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
