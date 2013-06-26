package geral;
public class Utilitarios {

	public static void pl(String linha){
		System.out.println(linha);
	}
	
	public String t(int num){
		String linha = "";
		while (num > 0){
			linha += "=";
			num--;
		}
		return linha;
	}
	
	public static void p(String linha){
		System.out.print(linha);
	}

}
