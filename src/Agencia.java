import java.util.ArrayList;

/**
 * Agencia
 * 
 * @author romulo
 */
public class Agencia { 
	
/**
 * N�mero m�ximo de contas
 */
	private byte MAX_CONTAS = 20;
	
/**
 * Lista das contas da ag�ncia
 */
	private ArrayList<Conta> contas;
	
/**
 * Contrutor da classe ag�ncia
 */
	public Agencia() {}
	
/**
 * Cria conta
 * 
 * @param numero
 * @param proprietario
 * @param saldo
 * @return
 */
	public static String criarConta(int numero, String proprietario, float saldo) {
		if (saldo < 0 ) {
			return "Vai se ferra valor negativo";
		}
		
		Conta conta1 = new Conta(001, "Romulo Barbosa", (float) -100.00);
		return "";
	}	
}