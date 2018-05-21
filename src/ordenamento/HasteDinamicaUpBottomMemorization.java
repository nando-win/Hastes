package ordenamento;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HasteDinamicaUpBottomMemorization {

    public static int MemorizedCutRod(int n, int[] preco) {
        int[] r = new int[n + 1];
        for (int i = 0; i < n; i++) {
            r[i] = Integer.MIN_VALUE;
        }

        return MemorizedCutRodAux(n, preco, r);
    }

    public static int MemorizedCutRodAux(int n, int[] preco, int[] r) {
        int q;

        if (r[n] >= 0) {
            return r[n];
        }
        if (n == 0) {
            q = 0;

        } else {
            q = Integer.MIN_VALUE;

            for (int i = 1; i < n; i++) {
                q = Math.max(q, preco[i] + MemorizedCutRodAux(n - i, preco, r));
            }
        }
        r[n] = q;

        return q;
    }

    public static void executar() throws FileNotFoundException {

        System.out.println("Entre com o diretorio do arquivo TXT:");

        Scanner sc = new Scanner(System.in);
        String arquivo = sc.nextLine();

        File file = new File(arquivo);//Leitura do arquivo TXT
        Scanner scan = null;

        ArrayList<Integer> vetorAux = new ArrayList<>();//Vetor Auxiliar

        scan = new Scanner(file);

        while (scan.hasNextLine()) {//Separação de Linhas e Colunas
            String[] campos = scan.nextLine().split("\\s+");
            vetorAux.add(Integer.parseInt(campos[1]));
        }

        int[] vetor = new int[vetorAux.size()];//Vetor Principal

        for (int i = 0; i < vetorAux.size(); i++) {//Passando Variaveis do vetor auxiliar para vetor principal
            vetor[i] = vetorAux.get(i);
        }

        int num = MemorizedCutRod(vetorAux.size(), vetor);//Executando algoritimo
        System.out.println("Melhor valor possivel: " + num);//Mostrando o resultado final

    }

}
