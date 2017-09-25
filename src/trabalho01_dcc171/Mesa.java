
package trabalho01_dcc171;

import java.util.ArrayList;
import java.util.List;

/*
Essa classe representará as mesas do estabelecimento sem levar em consideração a
quantidade de pessoas na mesa, ou quantas pessoas cabem na mesa.
 */
public class Mesa {
    private int numMesa = 1; //essa variável vai controlar o fluxo de mesas.
    private List<Pedido> pedidos; // essa lista vai controlar os pedidos por mesa.
    //Durante uma noite, são pessoas diferentes que passam pelas mesas.

    
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
}
