package trabalho01_dcc171;

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

class JanelaItem extends JFrame{
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
    private final JLabel valtotal = new JLabel(" TOTAL: ");
    
    private JButton btnConfirma = new JButton("Confirma");
    private JButton btnCancela = new JButton("Cancela");
    
    private List<Item> itens = new ArrayList<>();
    private double total = 0;

    public JanelaItem() throws HeadlessException {
        super("Adiciona Itens ao Pedido");
        setMinimumSize(new Dimension(600, 200));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        Item i1 = new Item(" Refri Lata ",5.0);
        Item i2 = new Item(" RedBull ",12.0);
        Item i3 = new Item(" Smirnoff ICE ",8.0);
        Item i4 = new Item(" Skol Beats ",9.0);
        Item i5 = new Item(" Vodka Orloff ",50.0);
        Item i6 = new Item(" Compo Vodka + Energético ",70.0);
        itens.add(i1);
        itens.add(i2);
        itens.add(i3);
        itens.add(i4);
        itens.add(i5);
        itens.add(i6); 
        
        
        JPanel organiza = new JPanel(new GridLayout(7, 2));
        JPanel botoes = new JPanel(new GridLayout(1,2));
        botoes.add(btnConfirma);
        botoes.add(btnCancela);
        
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
        
        btnConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                total += ((Integer.parseInt(quantidade1.getText()))) * (itens.get(0).getPreco());
                total += ((Integer.parseInt(quantidade2.getText()))) * (itens.get(1).getPreco());
                total += ((Integer.parseInt(quantidade3.getText()))) * (itens.get(2).getPreco());
                total += ((Integer.parseInt(quantidade4.getText()))) * (itens.get(3).getPreco());
                total += ((Integer.parseInt(quantidade5.getText()))) * (itens.get(4).getPreco());
                total += ((Integer.parseInt(quantidade6.getText()))) * (itens.get(5).getPreco());
                
                valtotal.setText(" "+ total);
            }
        });
    }
    
    
}
