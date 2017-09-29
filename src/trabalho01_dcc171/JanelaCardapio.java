/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01_dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pedrofreitas
 */
class JanelaCardapio extends JFrame {

    private final JLabel item1 = new JLabel(" 1 - Refri Lata R$ 6,00");
    private final JLabel item2 = new JLabel(" 2 - RedBull R$ 12,00");
    private final JLabel item3 = new JLabel(" 3 - Smirnoff ICE R$ 8,00");
    private final JLabel item4 = new JLabel(" 4 - Skol Beats R$ 9,00");
    private final JLabel item5 = new JLabel(" 5 - Vodka Orloff R$ 50,00");
    private final JLabel item6 = new JLabel(" 6 - Combo Vodka + Energético R$ 70,00");
    private JButton btnConfirma = new JButton("OK");
    
    JanelaMesa mesa;
    
    public JanelaCardapio(JanelaMesa j) throws HeadlessException {
        super("Cardápio");
        this.mesa = j;
        setMinimumSize(new Dimension(600, 200));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel organiza = new JPanel(new GridLayout(6,1));
        JPanel botoes = new JPanel(new GridLayout(1, 1));
        botoes.add(btnConfirma);
        
        organiza.add(item1);
        organiza.add(item2);
        organiza.add(item3);
        organiza.add(item4);
        organiza.add(item5);
        organiza.add(item6);
        
        add(organiza, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);
        
        btnConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        

    }

}
