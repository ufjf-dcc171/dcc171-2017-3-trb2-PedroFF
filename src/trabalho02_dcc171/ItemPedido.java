package trabalho02_dcc171;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;

public class ItemPedido {

    private Item item;

    private int quantidade;

    private int id;

    private Pedido pedido;

    private PedidoDAO pedidodao;

    private File arq;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    public ItemPedido(Integer id_pedido, Item produto, int quantidade) throws IOException {
        // pedidodao = new PedidoDao();
        Pedido ped = pedidodao.listar(id_pedido);
        this.pedido = ped;
        this.id = this.pedido.criaCodigoItemPedido();
        this.item = produto;
        this.quantidade = quantidade;
        this.arq = criaArquivo(pedido);

    }

    public ItemPedido(Pedido pedido, Item produto, int quantidade) throws IOException {
        this.pedido = pedido;
        this.id = this.pedido.criaCodigoItemPedido();
        this.item = produto;
        this.quantidade = quantidade;
        this.arq = criaArquivo(pedido);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "\nItem: " + item + " || Quantidade: " + quantidade + " \n";

    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getValorTotal() {
        double n = 0;
        n = item.getPreco() * quantidade;

        return n;
    }

    public String ToSerial() {
        return this.getPedido().getNumPedido() + ";" + this.getItem().ToSerial() + ";" + this.getQuantidade() + ";";
    }

    public static ItemPedido ToObject(String s, Pedido pedido) throws IOException {
        String[] array = s.split(";");
        if (pedido.getNumPedido() == Integer.parseInt(array[0])) {
            Item i = (Item) Item.ToObject(array[1] + ";" + array[2] + ";" + array[3]);
            Integer quantidade = Integer.parseInt(array[4]);
            ItemPedido IP = new ItemPedido(pedido, i, quantidade);
            return IP;
        } else {
            throw new IOException();
        }

    }

    public static File criaArquivo(Pedido pedido) {
        return new File("Dados\\ItensPedidos", "ItemPedido " + pedido.getDescricaoPedido()+ pedido.getMesa().toString() + ".txt");
    }

}
