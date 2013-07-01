package geral;
public class Utilitarios {

	public void pl(String linha){
		System.out.println(linha);
	}
	
	public String t(int num, String caractere){
		String result = "";
		
		while (num != 0){
			result += caractere;
			num--;
		}
		
		return result;
	}
	
	public void p(String linha){
		System.out.print(linha);
	}
}
