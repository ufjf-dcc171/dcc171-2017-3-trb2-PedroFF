package trabalho01_dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private final List<Mesa> mesas;
    private final JList<Mesa> lstMesas = new JList<>(new DefaultListModel<>());
    private final JList<Pedido> lstPedidos = new JList<>(new DefaultListModel<>());
    private final JButton criaMesa = new JButton("Cria mesa");
    private final JButton excluiMesa = new JButton("Exclui Mesa");
    private final JButton criaPedido = new JButton("Cria Pedido");
    private final JButton excluiPedido = new JButton("Exclui Pedido");
    private final JButton addItem = new JButton("Adiciona Item");
    private final JButton excluiItem = new JButton("Exclui Item");
    private final JanelaPedido janelaPedido = new JanelaPedido();

    public JanelaMesa(List<Mesa> sampleData) {
        super("Mesas");
        setMinimumSize(new Dimension(900, 300));
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
                String cod = JOptionPane.showInputDialog("Número da nova mesa");
                if (cod != null && !cod.isEmpty()) {
                    Mesa t = new Mesa(cod);
                    mesas.add(t);
                    lstMesas.updateUI();
                }
            }
        });

        excluiMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstMesas.isSelectionEmpty()) {
                    return;
                }
                mesas.remove(lstMesas.getSelectedValue());
                lstMesas.clearSelection();
                lstMesas.updateUI();
            }
        });

        janelaPedido.setJanelaMesa(this);
        criaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                janelaPedido.solicitaNovoPedido();
            }
        });
        
        excluiPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lstPedidos.isSelectionEmpty()){ return; }
                mesas.remove(lstPedidos.getSelectedValue());
                lstPedidos.clearSelection();
                lstPedidos.updateUI();
            }
        });
    }

    public void adicionaPedido(Pedido p) {
        lstMesas.getSelectedValue().getPedidos().add(p);
        lstMesas.updateUI();
        lstPedidos.updateUI();
        janelaPedido.setVisible(false);
    }

}


