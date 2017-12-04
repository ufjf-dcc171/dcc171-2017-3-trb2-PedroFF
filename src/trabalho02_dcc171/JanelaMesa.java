package trabalho02_dcc171;

import java.time.LocalTime;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JanelaMesa extends javax.swing.JFrame {

    private int numMesas = 1;
    private int numPedidos = 1;
    private final List<Mesa> mesas;
    private final JList<Mesa> lstMesas = new JList<>(new DefaultListModel<>());
    private final JList<Pedido> lstPedidos = new JList<>(new DefaultListModel<>());
    private JanelaItem janelaItem;
    private JanelaCardapio janelaCardapio;

    public JanelaMesa(List<Mesa> sampleData) {
        initComponents();
        this.mesas = sampleData;
        lstMesas.setModel(new MesaListModel(mesas));
        lstMesas.setModel(new MesaListModel(mesas));
        janelaItem = new JanelaItem(this);
        janelaCardapio = new JanelaCardapio(this);

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
                    descricaoPedido.setText(lstPedidos.getSelectedValue().imprimeFinal(lstPedidos.getSelectedValue()));
                    descricaoPedido.updateUI();
                    lstPedidos.updateUI();
                } else {
                    return;
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollMesas = new javax.swing.JScrollPane(lstMesas);
        scrollPedidos = new javax.swing.JScrollPane(lstPedidos);
        jScrollPane3 = new javax.swing.JScrollPane();
        descricaoPedido = new javax.swing.JTextArea();
        btnCriaMesa = new javax.swing.JButton();
        btnExcluiMesa = new javax.swing.JButton();
        btnCriaPedido = new javax.swing.JButton();
        btnFechaPedido = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        btnCardapio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(572, 500));

        descricaoPedido.setColumns(20);
        descricaoPedido.setRows(5);
        jScrollPane3.setViewportView(descricaoPedido);

        btnCriaMesa.setText("Criar Mesa");
        btnCriaMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriaMesaActionPerformed(evt);
            }
        });

        btnExcluiMesa.setText("Excluir Mesa");
        btnExcluiMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiMesaActionPerformed(evt);
            }
        });

        btnCriaPedido.setText("Criar Pedido");
        btnCriaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriaPedidoActionPerformed(evt);
            }
        });

        btnFechaPedido.setText("Fechar Pedido");
        btnFechaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaPedidoActionPerformed(evt);
            }
        });

        btnAddItem.setText("Adicionar Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnCardapio.setText("Cardápio");
        btnCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardapioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnCriaMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluiMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCriaPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechaPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCardapio))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPedidos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(scrollMesas, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriaMesa)
                    .addComponent(btnExcluiMesa)
                    .addComponent(btnCriaPedido)
                    .addComponent(btnFechaPedido)
                    .addComponent(btnAddItem)
                    .addComponent(btnCardapio)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriaMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriaMesaActionPerformed

        Mesa t = new Mesa(numMesas);
        mesas.add(t);
        lstMesas.updateUI();
        numMesas++;
    }//GEN-LAST:event_btnCriaMesaActionPerformed

    private void btnExcluiMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiMesaActionPerformed
        if (lstMesas.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma mesa", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }

        for (Pedido p : lstMesas.getSelectedValue().getPedidos()) {
            if (p.isConta() == true) {
                JOptionPane.showMessageDialog(null, "Existem pedidos em aberto. Feche-os", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
            return;
        }
        mesas.remove(lstMesas.getSelectedValue());
        lstMesas.clearSelection();
        lstMesas.updateUI();
    }//GEN-LAST:event_btnExcluiMesaActionPerformed

    private void btnCriaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriaPedidoActionPerformed
        if (lstMesas.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma mesa", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }

        Pedido p = new Pedido(numPedidos);
        lstMesas.getSelectedValue().getPedidos().add(p);
        lstPedidos.updateUI();
        lstMesas.updateUI();
        numPedidos++;
    }//GEN-LAST:event_btnCriaPedidoActionPerformed

    private void btnFechaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaPedidoActionPerformed
        if (lstPedidos.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um Pedido", "ERRO!", JOptionPane.ERROR_MESSAGE);;
        }
        lstPedidos.getSelectedValue().setConta(false);
        lstPedidos.getSelectedValue().getDescricao().append("\n" + " TOTAL FINAL: " + lstPedidos.getSelectedValue().getValorFinal());
        descricaoPedido.setText(lstPedidos.getSelectedValue().imprimeFinal(lstPedidos.getSelectedValue()));
        lstPedidos.getSelectedValue().setHoraFechamento(LocalTime.now());
        lstPedidos.updateUI();
    }//GEN-LAST:event_btnFechaPedidoActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        if (lstPedidos.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um Pedido", "ERRO!", JOptionPane.ERROR_MESSAGE);;
            return;
        } else if (lstPedidos.getSelectedValue().isConta() == false) {
            return;
        }

        janelaItem.setVisible(true);
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardapioActionPerformed
        janelaCardapio.setVisible(true);
    }//GEN-LAST:event_btnCardapioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCardapio;
    private javax.swing.JButton btnCriaMesa;
    private javax.swing.JButton btnCriaPedido;
    private javax.swing.JButton btnExcluiMesa;
    private javax.swing.JButton btnFechaPedido;
    private javax.swing.JTextArea descricaoPedido;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane scrollMesas;
    private javax.swing.JScrollPane scrollPedidos;
    // End of variables declaration//GEN-END:variables

    void gravarproduto(String nome,int qtd ,double preco) {
       lstPedidos.getSelectedValue().getDescricao().append("\n").append(nome).append(": " + "R$").append(preco).append("\n").append("Quantidade: ").append(qtd).append("\n");
       descricaoPedido.setText(lstPedidos.getSelectedValue().imprimeFinal(lstPedidos.getSelectedValue()));
    }
    void recebetotal( double total){
        lstPedidos.getSelectedValue().getDescricao().append("\n").append("Total parcial: ").append(total + lstPedidos.getSelectedValue().getValorFinal()).append("\n");
        descricaoPedido.setText(lstPedidos.getSelectedValue().imprimeFinal(lstPedidos.getSelectedValue()));
        lstPedidos.getSelectedValue().acrescentaFinal(total, lstPedidos.getSelectedValue());
    }
}
