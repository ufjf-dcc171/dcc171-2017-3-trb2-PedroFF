package trabalho02_dcc171;

import java.util.ArrayList;
import java.util.List;

class Item {

    private String nome;
    private double preco;
    
    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Item() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static List<Item> getSampleData() {
        
        Item item1 = new Item(" 1 - Refri Lata", 6.00);
        Item item2 = new Item(" 2 - RedBull", 12.00);
        Item item3 = new Item(" 3 - Smirnoff ICE", 8.00);
        Item item4 = new Item(" 4 - Skol Beats", 9.00);
        Item item5 = new Item(" 5 - Vodka Orloff", 50.00);
        Item item6 = new Item(" 6 - Combo Vodka + Energético", 70.00);
        List<Item> itens = new ArrayList<>();
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        
        return itens;
    }

}
