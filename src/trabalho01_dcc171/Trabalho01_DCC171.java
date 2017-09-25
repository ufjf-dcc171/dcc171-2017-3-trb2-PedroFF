
package trabalho01_dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;


public class Trabalho01_DCC171 {


    public static void main(String[] args) {
                
        JanelaMesa janela = new JanelaMesa(getSampleData()); 
        janela.setSize(700, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
    
    private static List<Mesa> getSampleData() {
        Pedido p1 = new Pedido();
        
        Mesa m1 = new Mesa(0);
        
        m1.getPedidos().add(p1);
        
        
        List<Mesa> mesas = new ArrayList<>();
        mesas.add(m1);

        return mesas;
    }
}
