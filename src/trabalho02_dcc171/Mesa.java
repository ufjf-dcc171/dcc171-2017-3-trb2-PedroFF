
package trabalho02_dcc171;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
Essa classe representará as mesas do estabelecimento sem levar em consideração a
quantidade de pessoas na mesa, ou quantas pessoas cabem na mesa.
 */
public class Mesa {
    private int numMesa; //essa variável vai controlar o fluxo de mesas.
    private List<Pedido> pedidos; // essa lista vai controlar os pedidos por mesa.
    //Durante uma noite, são pessoas diferentes que passam pelas mesas.
    private int codigoPedido = 1;
    private String descricaoMesa;
    private static final File arquivo = new File("Dados\\Mesas", "Mesa.txt");
    
    private GeradorDePedido gerador;
    
    public int criaCodPedido() throws IOException {
        gerador = new GeradorDePedido(this);
        int cod = gerador.getIDPedido();
        gerador.addIDPedido(cod);
        return cod;
    }
    
    public Mesa() throws IOException {
        this.numMesa = criaCodigo();
        this.descricaoMesa = "Mesa " + numMesa;
        this.pedidos = new ArrayList<>();
    }

    public Mesa(int id, String descricao) {
        this.numMesa = id;
        this.descricaoMesa = descricao;
        this.pedidos = new ArrayList<>();
    }
    
    
    
    public Mesa(Integer i) {
        this.numMesa = i;
        this.pedidos = new ArrayList<>();
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    @Override
    public String toString() {
        return "Mesa "+ this.numMesa;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public static File getArq(){
        return arquivo;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getDescricaoMesa() {
        return descricaoMesa;
    }

    public void setDescricaoMesa(String descricaoMesa) {
        this.descricaoMesa = descricaoMesa;
    }
    
    
    public static int criaCodigo() throws IOException {
        int cod = GeradorMesa.getIDMesa();
        GeradorMesa.addIDMesa(cod);
        return cod;
    }
        
    public String ToSerial() {
        return this.getNumMesa()+";"+this.getDescricaoMesa();
    }

    public static Mesa ToObject(String s) {
        String[] array = s.split(";");
        Integer id = Integer.parseInt(array[0]);
        String descricao = array[1];
        Mesa mesa = new Mesa(id,descricao);
        return mesa;

    }

}
