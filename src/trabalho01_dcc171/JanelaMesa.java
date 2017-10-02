package trabalho01_dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
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
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class JanelaMesa extends JFrame {

    static int numMesas = 1;
    private int numPedidos = 1;
    private final List<Mesa> mesas;
    private final JList<Mesa> lstMesas = new JList<>(new DefaultListModel<>());
    private final JList<Pedido> lstPedidos = new JList<>(new DefaultListModel<>());
    private final JButton criaMesa = new JButton("Cria mesa");
    private final JButton excluiMesa = new JButton("Exclui Mesa");
    private final JButton criaPedido = new JButton("Cria Pedido");
    private final JButton excluiPedido = new JButton("Fechar Pedido");
    private final JButton addItem = new JButton("Adiciona Item");
    private final JButton cardapio = new JButton("Cardápio");
    private final JTextArea descPedido = new JTextArea(15, 35);
    
    private JanelaItem janela;
    private JanelaCardapio janelaCardapio;

    public JanelaMesa() throws HeadlessException {
        this.mesas = null;
    }

    public JTextArea getDescPedido() {
        return descPedido;
    }
    
    

    public JanelaItem getJanela() {
        return janela;
    }

    public void setJanela(JanelaItem janela) {
        this.janela = janela;
    }
    
    
    
    public JanelaMesa(List<Mesa> sampleData) {
        super("Mesas");
        setMinimumSize(new Dimension(950, 600));
        this.mesas = sampleData;
        lstMesas.setModel(new MesaListModel(mesas));
        janela = new JanelaItem(this);
        janelaCardapio = new JanelaCardapio(this);
        
        add(new JScrollPane(lstMesas), BorderLayout.WEST);
        add(new JScrollPane(lstPedidos), BorderLayout.CENTER);
        add(new JScrollPane (descPedido), BorderLayout.EAST);
        
        JPanel botoes = new JPanel(new GridLayout(1, 6));
        botoes.add(criaMesa);
        botoes.add(excluiMesa);
        botoes.add(criaPedido);
        botoes.add(excluiPedido);
        botoes.add(addItem);
        botoes.add(cardapio);
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
        
        lstPedidos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Pedido p = new Pedido();
                if (p != null) {
                    descPedido.setText(lstPedidos.getSelectedValue().getDescricao().toString());
                    descPedido.updateUI();
                    lstPedidos.updateUI();
                } else {
                    return;
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
                
                for (Pedido p : lstMesas.getSelectedValue().getPedidos()) {
                    if(p.isConta() == true)
                        JOptionPane.showMessageDialog(null, "Existem pedidos em aberto. Feche-os","ERRO!", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                mesas.remove(lstMesas.getSelectedValue());
                lstMesas.clearSelection();
                lstMesas.updateUI();
            }
        });

        criaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstMesas.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma mesa", "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
                
                Pedido p = new Pedido(numPedidos);
                lstMesas.getSelectedValue().getPedidos().add(p);
                lstPedidos.updateUI();
                lstMesas.updateUI();
                numPedidos++;
                
                
                
            }
        });

        excluiPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstPedidos.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um Pedido", "ERRO!", JOptionPane.ERROR_MESSAGE);;
                }
                lstPedidos.getSelectedValue().setConta(false);
                descPedido.setText(lstPedidos.getSelectedValue().imprimeFinal(lstPedidos.getSelectedValue()));
                
                lstPedidos.getSelectedValue().setHoraFechamento(LocalTime.now());
                lstPedidos.updateUI();
            }
        });

        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstPedidos.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um Pedido", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if(lstPedidos.getSelectedValue().isConta() == false)
                    {
                        JOptionPane.showMessageDialog(null, "Este pedido está fechado!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                
                janela.setVisible(true);
                
            }
        });
        
        cardapio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCardapio.setVisible(true);
            }
        });
    }


    void enviaTotal(List<ItemPedido> p ,String text) {
        for (ItemPedido itemPedido : p) {
            lstPedidos.getSelectedValue().getDescricao().append("\n");
            lstPedidos.getSelectedValue().getDescricao().append(itemPedido.toString());
            
            
        }
        
        lstPedidos.getSelectedValue().getDescricao().append("\n");
        lstPedidos.getSelectedValue().getDescricao().append(" Total Parcial: "+text);
        lstPedidos.getSelectedValue().getDescricao().append("\n");
        this.descPedido.setText(lstPedidos.getSelectedValue().getDescricao().toString());
        
        lstPedidos.getSelectedValue().acrescentaFinal(Double.parseDouble(text), lstPedidos.getSelectedValue());
    }

    
    
    
     
}
