package trabalho02_dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaCardapio extends javax.swing.JFrame{
    private List<Item> itens;
    private List<JLabel> jlabels = new ArrayList<>();
    private List<JLabel> jprecos = new ArrayList<>();
    private JButton btnConfirma = new JButton("OK");

    JanelaMesa mesa;

    public JanelaCardapio(JanelaMesa mesa){
        super("Cardápio");
        this.mesa = mesa;
        setMinimumSize(new Dimension(600, 200));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        itens = Item.getSampleData();
        for (Item item : itens) {

            jlabels.add(new JLabel(item.getNome()+":"));
            jprecos.add(new JLabel("R$" + item.getPreco()));
        }
        JPanel organiza = new JPanel(new GridLayout(7, 2));
        JPanel botoes = new JPanel(new GridLayout(1, 1));
        
        for (int i = 0; i < jlabels.size(); i++) {

            organiza.add(jlabels.get(i));
            organiza.add(jprecos.get(i));            
        }
        
        botoes.add(btnConfirma);
        
        this.add(organiza, BorderLayout.CENTER);
        this.add(botoes, BorderLayout.SOUTH);
        
        btnConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
    }
    
    
}
