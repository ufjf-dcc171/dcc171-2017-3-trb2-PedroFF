/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01_dcc171;

/**
 *
 * @author pedrofreitas
 */
public class ItemPedido {
    private String nome;
    private int quantidade;

    public ItemPedido() {
    }

    public ItemPedido(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return   " Nome: " + nome + "|| Quantidade: " + quantidade +" ";
        
    }
    
    
}
