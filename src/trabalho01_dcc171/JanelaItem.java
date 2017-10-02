package trabalho01_dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class JanelaItem extends JFrame {

    private JTextField quantidade1 = new JTextFieldNumeros();
    private JTextField quantidade2 = new JTextFieldNumeros();
    private JTextField quantidade3 = new JTextFieldNumeros();
    private JTextField quantidade4 = new JTextFieldNumeros();
    private JTextField quantidade5 = new JTextFieldNumeros();
    private JTextField quantidade6 = new JTextFieldNumeros();

    private final JLabel item1 = new JLabel(" 1 - Refri Lata R$ 6,00");
    private final JLabel item2 = new JLabel(" 2 - RedBull R$ 12,00");
    private final JLabel item3 = new JLabel(" 3 - Smirnoff ICE R$ 8,00");
    private final JLabel item4 = new JLabel(" 4 - Skol Beats R$ 9,00");
    private final JLabel item5 = new JLabel(" 5 - Vodka Orloff R$ 50,00");
    private final JLabel item6 = new JLabel(" 6 - Combo Vodka + Energético R$ 70,00");
    private final JLabel valtotal = new JLabel(" TOTAL Parcial: ");

    private JButton btnConfirma = new JButton("Confirma");
    private JButton btnCancela = new JButton("Cancela");

    JanelaMesa mesa;

    private List<Item> itens = new ArrayList<>();
    private List<ItemPedido> itemPedido = new ArrayList<>();

    private double total = 0;
    private StringBuilder detalhes;

    public JanelaItem(JanelaMesa j) throws HeadlessException {
        super("Adiciona Itens ao Pedido");
        setMinimumSize(new Dimension(600, 200));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.mesa = j;

        Item i1 = new Item(" Refri Lata ", 6.0);
        Item i2 = new Item(" RedBull ", 12.0);
        Item i3 = new Item(" Smirnoff ICE ", 8.0);
        Item i4 = new Item(" Skol Beats ", 9.0);
        Item i5 = new Item(" Vodka Orloff ", 50.0);
        Item i6 = new Item(" Compo Vodka + Energético ", 70.0);

        itens.add(i1);
        itens.add(i2);
        itens.add(i3);
        itens.add(i4);
        itens.add(i5);
        itens.add(i6);

        JPanel organiza = new JPanel(new GridLayout(7, 2));
        JPanel botoes = new JPanel(new GridLayout(1, 2));
        botoes.add(btnConfirma);
        botoes.add(btnCancela);

        quantidade1.setText("0");
        quantidade2.setText("0");
        quantidade3.setText("0");
        quantidade4.setText("0");
        quantidade5.setText("0");
        quantidade6.setText("0");

        organiza.add(item1);
        organiza.add(quantidade1);
        organiza.add(item2);
        organiza.add(quantidade2);
        organiza.add(item3);
        organiza.add(quantidade3);
        organiza.add(item4);
        organiza.add(quantidade4);
        organiza.add(item5);
        organiza.add(quantidade5);
        organiza.add(item6);
        organiza.add(quantidade6);
        organiza.add(valtotal);

        add(organiza, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        btnCancela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        for (int i = 0; i < 6; i++) {
            ItemPedido p = new ItemPedido();
            itemPedido.add(i, p);
        }

        btnConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                total += ((Integer.parseInt(quantidade1.getText()))) * (itens.get(0).getPreco());
                itemPedido.get(0).setNome(itens.get(0).getNome());
                itemPedido.get(0).setQuantidade(Integer.parseInt(quantidade1.getText()));

                total += ((Integer.parseInt(quantidade2.getText()))) * (itens.get(1).getPreco());
                itemPedido.get(1).setNome(itens.get(1).getNome());
                itemPedido.get(1).setQuantidade(Integer.parseInt(quantidade2.getText()));

                total += ((Integer.parseInt(quantidade3.getText()))) * (itens.get(2).getPreco());
                itemPedido.get(2).setNome(itens.get(2).getNome());
                itemPedido.get(2).setQuantidade(Integer.parseInt(quantidade3.getText()));

                total += ((Integer.parseInt(quantidade4.getText()))) * (itens.get(3).getPreco());
                itemPedido.get(3).setNome(itens.get(3).getNome());
                itemPedido.get(3).setQuantidade(Integer.parseInt(quantidade4.getText()));

                total += ((Integer.parseInt(quantidade5.getText()))) * (itens.get(4).getPreco());
                itemPedido.get(4).setNome(itens.get(4).getNome());
                itemPedido.get(4).setQuantidade(Integer.parseInt(quantidade5.getText()));

                total += ((Integer.parseInt(quantidade6.getText()))) * (itens.get(5).getPreco());
                itemPedido.get(5).setNome(itens.get(5).getNome());
                itemPedido.get(5).setQuantidade(Integer.parseInt(quantidade6.getText()));

                valtotal.setText(" " + total);

                mesa.enviaTotal(itemPedido, valtotal.getText());
                setVisible(false);
                quantidade1.setText("0");
                quantidade2.setText("0");
                quantidade3.setText("0");
                quantidade4.setText("0");
                quantidade5.setText("0");
                quantidade6.setText("0");
                valtotal.setText("");
                total = 0;
            }
        });
    }

    public JanelaMesa getMesa() {
        return mesa;
    }

    public void setMesa(JanelaMesa mesa) {
        this.mesa = mesa;
    }

}
