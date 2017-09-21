
package trabalho01_dcc171;

import java.util.List;

/*
Essa classe representará as mesas do estabelecimento sem levar em consideração a
quantidade de pessoas na mesa, ou quantas pessoas cabem na mesa.
 */
public class Mesa {
    private String numMesa; //essa variável vai controlar o fluxo de mesas.
    
    private List<Pedido> pedidos; // essa lista vai controlar os pedidos por mesa.
    //Durante uma noite, são pessoas diferentes que passam pelas mesas.
    
    private int geradorID; // ele controlará o número de pedidos de cada mesa. 
    
    public Mesa(String numMesa) {
        this.numMesa = numMesa;
    }

    public String getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(String numMesa) {
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

    public int getGeradorID() {
        return geradorID;
    }

    public void setGeradorID(int geradorID) {
        this.geradorID = geradorID;
    }
    
    
    
}
