package p2q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VulnerableClass {
	@SuppressWarnings("resource")
	public void vulnerableMethod(String FILENAME){
		while (true) {
		    System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, "
		    		+ "W para escrever em um arquivo>? ");
			
		    String opr= new Scanner(System.in).nextLine();
			
		    if (opr.equals("R")){
				//BufferedReader br = null;
				//FileReader fr = null;
				//estas variáveis tornam o código noncompliant, assim seguem as mudanças:
				try {
/*
					fr = new FileReader(FILENAME);
					br = new BufferedReader(fr);

					br = new BufferedReader(new FileReader(FILENAME));
*/
					String sCurrentLine;
					Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
					Matcher matcher = pattern.matcher(FILENAME);
					if(matcher.find()){
						System.out.println("Erro no nome do arquivo");
					}
					while ((sCurrentLine = new BufferedReader(new FileReader(FILENAME)).readLine()) != null) {
						System.out.println(sCurrentLine);
					}
					//desta forma minimizamos os escopos das variáveis e excluimos variáveis 
					//não utilizadas, o mesmo foi ferito com a variável console acima.

				} catch (IOException e) {

					e.printStackTrace();

				} 
			}
			
			else {
				  BufferedWriter buffWrite;
				  
				  try {
					buffWrite = new BufferedWriter(new FileWriter(FILENAME));
					String linha = "";
					System.out.println("Escreva algo: ");
				    linha = new Scanner(System.in).nextLine();
				    buffWrite.append(linha + "\n");
				     
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
	}
}