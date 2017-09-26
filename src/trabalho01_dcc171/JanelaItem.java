package trabalho01_dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

class JanelaItem extends JFrame{
    private JTextFieldNumeros quantidade1 = new JTextFieldNumeros();
    private JTextFieldNumeros quantidade2 = new JTextFieldNumeros();
    private JTextFieldNumeros quantidade3 = new JTextFieldNumeros();
    private JTextFieldNumeros quantidade4 = new JTextFieldNumeros();
    private JTextFieldNumeros quantidade5 = new JTextFieldNumeros();
    private JTextFieldNumeros quantidade6 = new JTextFieldNumeros();
    //private JComboBox box = new JComboBox();
    private final JLabel item1 = new JLabel("Refri Lata R$ 6,00");
    private final JLabel item2 = new JLabel( "RedBull R$ 12,00");   
    private final JLabel item3 = new JLabel( "Smirnoff ICE R$ 8,00"); 
    private final JLabel item4 = new JLabel("Skol Beats R$ 9,00"); 
    private final JLabel item5 = new JLabel("Vodka Orloff R$ 50,00"); 
    private final JLabel item6 = new JLabel("Combo Vodka + Energético R$ 70,00");  
         

    public JanelaItem() throws HeadlessException {
        super("Adiciona Itens ao Pedido");
        setMinimumSize(new Dimension(300, 400));
        //DefaultComboBoxModel model = new DefaultComboBoxModel(nomeItens);
        //box.setModel(model);
        JPanel organiza = new JPanel(new GridLayout(6, 2));
        //organiza.add(box);
        //organiza.add(quantidade);
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
       
        add(organiza, BorderLayout.CENTER);
        
    }
    
    
}
