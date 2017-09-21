/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01_dcc171;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pedrofreitas
 */
class JanelaPedido extends JFrame {
    
    private final JButton btnOk = new JButton("Criar");
    private JanelaMesa janelaMesa;

    public JanelaPedido() throws HeadlessException {
        super("Criar novo pedido");
        setSize(200, 90);
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel principal = new JPanel(new GridLayout(1, 1));
        add(btnOk, BorderLayout.CENTER);
        
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedido p = new Pedido();
                janelaMesa.adicionaPedido(p);
            }        
        });
    }
    
        public void setJanelaMesa(JanelaMesa janela){
        this.janelaMesa = janela;
    }
        
    void solicitaNovoPedido() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
    
    
