/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02_dcc171;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Pedro
 */
class GeradorItemPedido {
 private File arq;
    
    private Pedido pedido;

    public GeradorItemPedido(Pedido pedido) {
        this.pedido = pedido;
        arq =new File("Dados\\Generator", "GeneratorItemPedido "+this.pedido.getDescricao()+this.pedido.getMesa().toString()+" .txt");
    }
    

    public File getArq() {
        
        return arq;
    }

    public Integer getIDItemPedido() throws FileNotFoundException, IOException {
        if (!this.getArq().exists()) {
            this.getArq().createNewFile();
        }
        FileReader fr = new FileReader(this.getArq());
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        Integer id;
        try {
            id = Integer.parseInt(s);
            br.close();
            fr.close();
            this.addIDItemPedido(id);
        } catch (NumberFormatException ex) {
            br.close();
            fr.close();
            this.addIDItemPedido(1);
            id = 1;
        }
        return id;
    }

    public void addIDItemPedido(Integer id) throws IOException {
        id++;
        if (!this.getArq().exists()) {
            this.getArq().createNewFile();
        }
        FileWriter fw = new FileWriter(this.getArq());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(id.toString());
        bw.close();
        fw.close();

    }
}

