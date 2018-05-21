package ordenamento;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AtividadeGulosoInterativo {
    
    public static void activitySelection(int vetorI[],int vetorF[],int vetorId[]){
        int i,j;
        i = 0;
        
        System.out.println("Atividade" + "\t" + "Inicial" + "\t\t" + "Final");
        
        System.out.println(vetorId[0] + "\t\t" + vetorI[0] + "\t\t" + vetorF[0]);
	for(j = 1; j < vetorF.length; j++) {
		if(vetorI[j] >= vetorF[i]) {
                        System.out.println(vetorId[j] + "\t\t" + vetorI[j] + "\t\t" + vetorF[j]);
			i = j;
		}
	}
    }

    public static void executar() throws FileNotFoundException {

        System.out.println("Entre com o diretorio do arquivo TXT:");

        Scanner ler = new Scanner(System.in);
        String arquivo = ler.nextLine();

        File file = new File(arquivo);//Leitura do arquivo TXT
        Scanner scan = null;

        ArrayList<Integer> vetorAux0 = new ArrayList<>();//Vetor Auxiliar id
        ArrayList<Integer> vetorAux1 = new ArrayList<>();//Vetor Auxiliar tempo inicial
        ArrayList<Integer> vetorAux2 = new ArrayList<>();//Vetor Auxiliar tempo final

        scan = new Scanner(file);

        while (scan.hasNextLine()) {//Separação de Linhas e Colunas
            String[] campos = scan.nextLine().split("\\s+");
            vetorAux0.add(Integer.parseInt(campos[0]));
            vetorAux1.add(Integer.parseInt(campos[1]));
            vetorAux2.add(Integer.parseInt(campos[2]));

        }

        int[] vetorId = new int[vetorAux0.size()];//Vetor Principal de ID
        int[] vetorI = new int[vetorAux1.size()];//Vetor Principal de tempo inicial
        int[] vetorF = new int[vetorAux2.size()];//Vetor Principal de tempo final

        for (int i = 0; i < vetorAux1.size(); i++) {//Passando Variaveis do vetor auxiliar para vetor principal
            vetorId[i] = vetorAux0.get(i);
            vetorI[i] = vetorAux1.get(i);
            vetorF[i] = vetorAux2.get(i);
        }
        
        int aux1 = 0,aux2 = 0,aux0 = 0; //Variaveis auxiliares
        
        for (int i = 0; i < vetorF.length; i++) {//Ordenando os vetores
            for (int j = 0; j < vetorF.length; j++) {
                if (vetorF[i] < vetorF[j]) {
                    aux0 = vetorId[i];
                    vetorId[i] = vetorId[j];
                    vetorId[j] = aux0;
                    
                    aux1 = vetorF[i];
                    vetorF[i] = vetorF[j];
                    vetorF[j] = aux1;
                    
                    aux2 = vetorI[i];
                    vetorI[i] = vetorI[j];
                    vetorI[j] = aux2;
                }
            }
        }

        System.out.println();
        
        activitySelection(vetorI, vetorF, vetorId);
    }
}
