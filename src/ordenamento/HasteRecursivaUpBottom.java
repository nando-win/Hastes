package ordenamento;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HasteRecursivaUpBottom {//

    public static int cutRod(int n, int[] preco) {
        if (n <= 0) {
            return 0;
        }
        int valMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            valMax = Math.max(valMax, preco[i] + cutRod(n - i - 1, preco));
        }
        return valMax;

    }

    public static void executar() throws FileNotFoundException {

        System.out.println("Entre com o diretorio do arquivo TXT:");

        Scanner ler = new Scanner(System.in);
        String arquivo = ler.nextLine();

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

	        int num = cutRod(vetorAux.size(), vetor);//Executando algoritimo
	        System.out.println("Melhor valor possivel: " + num);//Mostrando o resultado final

    }

}