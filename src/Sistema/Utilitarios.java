package Sistema;
public class Utilitarios {

	public static void p(String linha){
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

}
