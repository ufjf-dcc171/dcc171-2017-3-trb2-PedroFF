package trabalho02_dcc171;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class Pedido {

    private LocalTime horaAbertura;

    private LocalTime horaFechamento;

    private int numPedido = 0;

    private List<Item> itens;

    private boolean conta; // enquanto for true, podem ser adicionados mais itens ao pedido.

    private double valorFinal;

    private static File arquivo;

    private Mesa mesa;

    private String descricaoPedido;

    private MesaDAO mesaDao;
    private GeradorItemPedido gerador;
    ItemPedidoDAO itempedidodao;
    private List<ItemPedido> itensPedidos;
    private Iterable<ItemPedido> itemPedido;


    public Pedido(int id, String descricao, Integer idmesa, LocalTime hora_abertura, boolean fechado) throws IOException {
        this.numPedido = id;
        this.descricaoPedido = descricao;
        mesaDao = new MesaDAO();
        Mesa mesa = mesaDao.listar(idmesa);
        this.mesa = mesa;
        this.horaAbertura = hora_abertura;
        this.conta = fechado;
        arquivo = criaArquivo(mesa);
        this.itempedidodao = new ItemPedidoDAO(this);
        this.itensPedidos = itempedidodao.getItemPedidos();
    }

    public Pedido(int id, String descricao, Integer idmesa, LocalTime hora_abertura, LocalTime hora_fechamento, boolean fechado) throws IOException {
        this.numPedido = id;
        this.descricaoPedido = descricao;
        mesaDao = new MesaDAO();
        Mesa mesa = mesaDao.listar(idmesa);
        this.mesa = mesa;
        this.horaAbertura = hora_abertura;
        this.horaFechamento = hora_fechamento;
        this.conta = fechado;
        arquivo = criaArquivo(mesa);
        this.itempedidodao = new ItemPedidoDAO(this);
        this.itensPedidos = itempedidodao.getItemPedidos();
    }

    public Pedido(Mesa mesa, LocalTime hora_abertura) throws IOException {
        this.mesa = mesa;
        this.horaAbertura = hora_abertura;
        this.numPedido = this.mesa.criaCodPedido();
        this.conta = true;
        this.descricaoPedido = "Pedido " + numPedido;
        arquivo = criaArquivo(mesa);
        this.itempedidodao = new ItemPedidoDAO(this);
    }
    
    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
        
    }

    public Mesa getMesa() {
        return mesa;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public boolean isConta() {
        return conta;
    }

    public void setConta(boolean conta) {
        this.conta = conta;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setHoraFechamento(LocalTime horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public Double getValorTotal() {
        for (ItemPedido item : itensPedidos) {
            valorFinal += item.getValorTotal();
        }
        double n = 0;
        n = valorFinal;

        return n;
    }

    @Override
    public String toString() {
        if(horaFechamento == null){
        return "\nID: " + this.numPedido + "\n Descrição:" + this.descricaoPedido + "\n Mesa: " + this.mesa + "\n Hora de Abertura: " + this.horaAbertura.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
        } else{
            return "\nID: " + this.numPedido + "\n Descrição:" + this.descricaoPedido + "\n Mesa: " + this.mesa + "\n Hora de Abertura: " + this.horaAbertura.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))+ "\n Hora de Fechamento: "+ this.horaFechamento.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
        }
    }

    public static File criaArquivo(Mesa mesa) {
        return new File("Dados\\Pedidos", "Pedido " + mesa.toString() + ".txt");
    }

    public static Pedido ToObject(String s) throws IOException {
        String[] array = s.split(";");
        Pedido p;
        Integer id = Integer.parseInt(array[0]);
        Integer id_mesa = Integer.parseInt(array[1]);
        String descricao = array[2];
        LocalTime horaAbertura = LocalTime.parse(array[3]);
        if ("NULO".equals(array[4])) {
            p = new Pedido(id, descricao, id_mesa, horaAbertura, false);
            return p;
        }
        LocalTime horaFechamento = LocalTime.parse(array[4]);
        p = new Pedido(id, descricao, id_mesa, horaAbertura, horaFechamento, true);
        return p;

    }

    public String ToSerial() {
        String fechamento = this.getHoraFechamento() != null ? this.getHoraFechamento().toString() : "NULO";
        return this.getNumPedido() + ";" + this.getMesa().getNumMesa() + ";" + this.getDescricaoPedido() + ";" + this.getHoraAbertura() + ";" + fechamento;
    }

    public int criaCodigoItemPedido() throws IOException {
        gerador = new GeradorItemPedido(this);
        int cod = gerador.getIDItemPedido();
        gerador.addIDItemPedido(cod);
        return cod;
    }

    void setValorTotal(Double total) {
      this.valorFinal = total;
    }

}
