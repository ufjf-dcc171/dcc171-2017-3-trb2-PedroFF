package trabalho01_dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class JanelaMesa extends JFrame {

    static int numMesas = 1;
    private int numPedidos = 0;
    private final List<Mesa> mesas;
    private final JList<Mesa> lstMesas = new JList<>(new DefaultListModel<>());
    private final JList<Pedido> lstPedidos = new JList<>(new DefaultListModel<>());
    private final JButton criaMesa = new JButton("Cria mesa");
    private final JButton excluiMesa = new JButton("Exclui Mesa");
    private final JButton criaPedido = new JButton("Cria Pedido");
    private final JButton excluiPedido = new JButton("Fechar Pedido");
    private final JButton addItem = new JButton("Adiciona Item");
    private final JButton excluiItem = new JButton("Exclui Item");

    public JanelaMesa(List<Mesa> sampleData) {
        super("Mesas");
        setMinimumSize(new Dimension(700, 300));
        this.mesas = sampleData;
        lstMesas.setModel(new MesaListModel(mesas));
        add(new JScrollPane(lstMesas), BorderLayout.WEST);
        add(new JScrollPane(lstPedidos), BorderLayout.CENTER);
        JPanel botoes = new JPanel(new GridLayout(1, 6));
        botoes.add(criaMesa);
        botoes.add(excluiMesa);
        botoes.add(criaPedido);
        botoes.add(excluiPedido);
        botoes.add(addItem);
        botoes.add(excluiItem);
        add(botoes, BorderLayout.SOUTH);

        lstMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstMesas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Mesa selecionada = lstMesas.getSelectedValue();
                if (selecionada != null) {
                    System.out.println(selecionada);
                    lstPedidos.setModel(new PedidoListModel(selecionada.getPedidos()));
                } else {
                    lstPedidos.setModel(new DefaultListModel<>());
                }

            }
        });

        criaMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mesa t = new Mesa(numMesas);
                mesas.add(t);
                lstMesas.updateUI();
                numMesas++;

            }
        });

        excluiMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstMesas.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma mesa", "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
                mesas.remove(lstMesas.getSelectedValue());
                lstMesas.clearSelection();
                lstMesas.updateUI();
            }
        });

        criaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        excluiPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstPedidos.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um Pedido", "ERRO!", JOptionPane.ERROR_MESSAGE);;
                }
                lstPedidos.getSelectedValue().setConta(false);
                lstPedidos.getSelectedValue().setHoraFechamento(LocalTime.now());
                lstPedidos.updateUI();
            }
        });

        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void adicionaPedido(Pedido p) {
        lstMesas.getSelectedValue().getPedidos().add(p);
        lstMesas.updateUI();
        lstPedidos.updateUI();

    }

}
