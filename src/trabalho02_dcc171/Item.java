package trabalho02_dcc171;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Item {

    private String nome;
    private double preco;
    private int id;
    private static int gencodigo = 0;
    
    private static final File arq = new File("Dados", "Itens.txt");
    
    public Item(String nome, double preco) {
        this.id = criarCodigo();
        this.nome = nome;
        this.preco = preco;
    }
    
    public Item(Integer id, String descricao, Double valor) {
        this.id = id;
        this.nome = descricao;
        setPreco(valor);
    }

    public Item() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public static int criarCodigo() {
        int cod = gencodigo;
        gencodigo++;
        return cod;
    }

        public String ToSerial() {
        return this.getId() + ";" + this.getNome() + ";" + this.getPreco();
    }

    public static Item ToObject(String s) {
        String[] array = s.split(";");
        Integer id = Integer.parseInt(array[0]);
        String descricao = array[1];
        Double valor = Double.parseDouble(array[2]);
        Item i = new Item(id, descricao, valor);
        return i;

    }
    
    public Item clonar() {
        Item p = new Item();
        p.setId(this.id);
        p.setNome(this.nome);
        p.setPreco(this.preco);
        return p;
    }

    @Override
    public String toString() {
        return nome + " Valor: R$ " + preco;
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
