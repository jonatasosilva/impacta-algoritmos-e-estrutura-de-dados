package listaligadasimples;

public class ListaLigadaSimples {

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

    private No localizaItemPorInfo(int info) {
    	No aux = this.inicio;
    	while (aux != null) {
    		if (aux.info == info) {
    			return aux;
    		}
    		aux = aux.proximo;
    	}
    	return null;
    }

    public void insereMeio(int infoNovoItem, int infoItemEspecifico) {
    	No novoItem = new No(infoNovoItem);
    	No itemEspecifico = this.localizaItemPorInfo(infoItemEspecifico);
    	No aux = itemEspecifico.proximo;
    	
    	itemEspecifico.proximo = novoItem;
    	novoItem.proximo = aux;
    }

    private boolean itemEstaNoMeio(No item) {
        return item != null && this.inicio != item && this.fim != item;
    }

    public void removeMeio(int info) {
        No item = localizaItemPorInfo(info);
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
