package geral;
public class Utilitarios {

	public void pl(String linha){
		System.out.println(linha);
	}
	
	public String t(int num, String caractere){
		while (num > 0){
			caractere += "=";
			num--;
		}
		return caractere;
	}
	
	public void p(String linha){
		System.out.print(linha);
	}
}
