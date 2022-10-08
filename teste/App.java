package teste;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import arvores.ArvoreAvlOrdenada;
import arvores.ArvoreRubroNegraOrdenada;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output.csv")));

        int n = 1000;
        int repeticoes = 1;

        writer.write("N;AvoreAVL-Ordenada;AvoreRubroNegra-Ordenada;\n");

        for (int i = 1; i <= n; i++) { 
            int somaAVLOrdenada = 0;
            int somaRubroNegraOrdenada = 0;
            
            for (int j = 0; j < repeticoes; j++) {

                ArvoreAvlOrdenada.vetorOrdenado(i);
                ArvoreRubroNegraOrdenada.vetorOrdenado(i);
                
                somaAVLOrdenada += ArvoreAvlOrdenada.count;
                somaRubroNegraOrdenada += ArvoreRubroNegraOrdenada.count;

            }
            
            writer.write(i + ";" + 
                (somaAVLOrdenada ) + ";" + (somaRubroNegraOrdenada) + ";" + 
                "\n");

            
            ArvoreAvlOrdenada.count = 0;
            ArvoreRubroNegraOrdenada.count = 0;
        }

        writer.close();
    }
}
