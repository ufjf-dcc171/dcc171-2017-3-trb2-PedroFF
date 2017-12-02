package trabalho02_dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaItem extends javax.swing.JFrame {

    private List<Item> itens;
    private List<JLabel> jlabels = new ArrayList<>();
    private List<JLabel> jprecos = new ArrayList<>();
    private List<JTextField> jtexts = new ArrayList<>();
    JanelaMesa mesa;
    private final JButton btnConfirma = new JButton("Confirma");
    private final JButton btnCancela = new JButton("Cancela");

    public JanelaItem(JanelaMesa mesa) throws HeadlessException {
        super("Adiciona Itens ao Pedido");

        setMinimumSize(new Dimension(600, 200));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.mesa = mesa;
        itens = Item.getSampleData();
        for (Item item : itens) {

            jlabels.add(new JLabel(item.getNome() + ":"));
            jprecos.add(new JLabel("R$" + item.getPreco()));
            jtexts.add(new JTextField("0"));
        }
        JPanel organiza = new JPanel(new GridLayout(7, 3));
        JPanel botoes = new JPanel(new GridLayout(1, 2));

        for (int i = 0; i < jtexts.size(); i++) {

            organiza.add(jlabels.get(i));
            organiza.add(jprecos.get(i));
            organiza.add(jtexts.get(i));
        }

        botoes.add(btnConfirma);
        botoes.add(btnCancela);

        this.add(organiza, BorderLayout.CENTER);
        this.add(botoes, BorderLayout.SOUTH);

        btnCancela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qtd = 0;
                int i = 0;
                double total = 0;
                for (; i < jtexts.size(); i++) {
                    qtd = Integer.parseInt(jtexts.get(i).getText());
                    if (qtd > 0) {
                        total += itens.get(i).getPreco() * qtd;
                        mesa.gravarproduto(itens.get(i).getNome(), qtd, itens.get(i).getPreco());
                    }
                }
                mesa.recebetotal(total);
                setVisible(false);
                for (JTextField text : jtexts) {

                    text.setText("0");
                }
            }
        });
    }
}
