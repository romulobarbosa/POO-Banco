import java.util.ArrayList;

/**
 * Agencia
 * 
 * @author romulo
 */
public class Agencia { 
	
/**
 * Número máximo de contas
 */
	private static byte MAX_CONTAS = 20;
	
/**
 * Lista das contas da agência
 */
	public static ArrayList<Conta> contas = new ArrayList(20);
	
/**
 * Contrutor da classe agência
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
		if (contas.size() >= MAX_CONTAS) {
			return "Numero maximo de contas ja cadastrado no sistema.";
		}
			
		if (saldo < 0 ) {
			return "Impossível cadastrar valor negativo como saldo.";
		}
		
		contas.add(new Conta(numero, proprietario, saldo));
		
		return "Conta cadastrada com sucesso.";
	}	
}