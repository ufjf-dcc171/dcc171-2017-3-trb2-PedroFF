
package trabalho02_dcc171;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class GeradorMesa {
     private static final File arq = new File("Dados\\Gerador", "GeradorMesa.txt");

    public static File getArq() {
        return arq;
    }

    public static Integer getIDMesa() throws FileNotFoundException, IOException {
        if (!GeradorMesa.getArq().exists()) {
            GeradorMesa.getArq().createNewFile();
        }
        FileReader fr = new FileReader(GeradorMesa.getArq());
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        Integer id;
        try {
            id = Integer.parseInt(s);
            br.close();
            fr.close();
            GeradorMesa.addIDMesa(id);
        } catch (NumberFormatException ex) {
            br.close();
            fr.close();
            GeradorMesa.addIDMesa(1);
            id = 1;
        }
        return id;
    }

    public static void addIDMesa(Integer id) throws IOException {
        id++;
        if (!GeradorMesa.getArq().exists()) {
            GeradorMesa.getArq().createNewFile();
        }
        FileWriter fw = new FileWriter(GeradorMesa.getArq());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(id.toString());
        bw.close();
        fw.close();

    }
}
