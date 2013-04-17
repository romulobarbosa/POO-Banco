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
	public static ArrayList<Conta> contas = new ArrayList<Conta>();
	
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
		
		if (getConta(numero) != null) {
			return "Ja existe uma conta com esse numero";
		}
			
		if (saldo < 0 ) {
			return "Impossivel cadastrar valor negativo como saldo.";
		}
		
		contas.add(new Conta(numero, proprietario, saldo));
		
		return "Conta cadastrada com sucesso.";
	}	
	
/**
 * Cancela conta
 * 
 * @param numero
 * @return
 */
	public static String cancelarConta(int numero) {
		Conta conta = getConta(numero);
		
		if (conta == null) {
			return "Conta inexistente.";
		}
		
		contas.remove(conta);
		return "Conta cancelada com sucesso.";
	}

/**
 * Lista todas as contas
 * 
 * @return
 */
	public static String listarContas() {
		String listaDeContas = "";
		
		for (int i = 0; i < contas.size(); i++) {
			listaDeContas += contas.get(i).getNumero() + " - " + contas.get(i).getProprietario() + " - " + contas.get(i).getSaldo() + "\n";
		}
		
		return listaDeContas;
	}
	
/**
 * Saca um valor da conta
 * 	
 * @param numero
 * @param valor
 * @return 
 */
	public static String sacar(int numero, float valor) {
		Conta conta = getConta(numero);
		
		if (conta == null) {
			return "Conta inexistente.";
		}
		
		switch (conta.sacar(valor)) {
			case 1:
				return "O valor de saque nao pode ser negativo.";
			case 2:
				return "O valor de saque nao pode ser maior que o saldo da conta.";
		}
		
		return "Saque efetuado com sucesso.";
	}

/**
 * Deposita um valor na conta
 * 	
 * @param numero
 * @param valor
 * @return
 */
	public static String depositar(int numero, float valor) {
		Conta conta = getConta(numero);
		
		if (conta == null) {
			return "Conta inexistente.";
		}
		
		switch (conta.depositar(valor)) {
			case 1:
				return "O valor de deposito nao pode ser negativo.";
		}
		
		return "Deposito efetuado com sucesso";
	}

/**
 * Pega uma conta na lista de contas
 * 
 * @param numero
 * @return 
 */
	private static Conta getConta(int numero) {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNumero() == numero) {
				return contas.get(i);
			}
		}
		
		return null;
	}
	
}