
package trabalho01_dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;


public class Trabalho01_DCC171 {


    public static void main(String[] args) {
                
        JanelaMesa janela = new JanelaMesa(getSampleData()); 
        janela.setSize(900, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
    
    private static List<Mesa> getSampleData() {
        Pedido p1 = new Pedido();
        
        Mesa m1 = new Mesa("1");
        Mesa m2 = new Mesa("2");
        Mesa m3 = new Mesa("3");
        
        m1.getPedidos().add(p1);
        m2.getPedidos().add(p1);
        m3.getPedidos().add(p1);
        
        List<Mesa> mesas = new ArrayList<>();
        mesas.add(m1);
        mesas.add(m2);
        mesas.add(m3);
        return mesas;
    }
}
