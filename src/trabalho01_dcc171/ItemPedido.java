
package trabalho01_dcc171;


public class ItemPedido {
    private Item item;
    private int quantidade;

    public ItemPedido() {
    }

    public ItemPedido(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return    "Item: "+ item + " || Quantidade: " + quantidade +" ";
        
    }
    
    
}
