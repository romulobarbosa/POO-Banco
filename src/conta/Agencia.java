package conta;
import java.util.ArrayList;

import conta.Corrente;
import conta.Poupanca;
import conta.Especial;

import execao.ExcecaoContaExistente;
import execao.ExcecaoContaInexistente;
import execao.ExcecaoFaltaEspaco;

/**
 * Agencia
 * 
 * @author romulo
 */
public class Agencia { 

/**
 * Constante para representar uma conta corrente.
 */
	static final byte CORRENTE = 1;

/**
 * Constante para representar uma conta especial.
 */
	static final byte POUPANCA = 2;
	
/**
 * Constante para representar uma poupança.
 */
	static final byte ESPECIAL = 3;
	
/**
 * Número máximo de contas
 */
	private static final byte MAX_CONTAS = 20;
	
/**
 * Lista das contas da agência
 */
	public static ArrayList<Conta> contas = new ArrayList<Conta>();
	
/**
 * Contrutor da classe agência
 */
	public Agencia() {}
	
/**
 * 
 * @param numero
 * @return conta
 * @throws ExcecaoContaInexistente
 */
	private Conta getConta(int numero) throws ExcecaoContaInexistente {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNumero() == numero) {
				return contas.get(i);
			}
		}
		
		throw new ExcecaoContaInexistente("A conta informada nao existe.");
	}
	

/**
 * Método de criação da conta. O limite só tem sentido quando a conta é especial. Do contrário, ele e ignorado.
 * 
 * @param numero O número da conta.
 * @param proprietario O proprietário da conta.
 * @param saldo O saldo inicial da conta.
 * @param tipo O tipo da conta.
 * @param limite O limite de crédito para a conta do tipo ESPECIAL.
 * @throws ExcecaoFaltaEspaco Se o número máximo de contas já houver sido cadastrado.
 * @throws ExcecaoContaExistente Se o número da conta informado como parâmetro já existe na agência.
 */
	public void criarConta(int numero, String proprietario, float saldo, byte tipo, float limite) throws ExcecaoFaltaEspaco, ExcecaoContaExistente {
		if (contas.size() >= MAX_CONTAS) {
			throw new ExcecaoFaltaEspaco("Numero maximo de contas ja cadastrado.");
		}
		
		if (this.getConta(numero) != null) {
			throw new ExcecaoContaExistente("Número de conta já existe.");
		}
		
		switch (tipo) {
			case 1:
				contas.add(new Corrente(numero, proprietario, saldo));				
				break;
			case 2:
				contas.add(new Poupanca(numero, proprietario, saldo));				
				break;
			case 3:
				contas.add(new Especial(numero, proprietario, saldo, limite));				
				break;
		}
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
				return "O valor de saque nao pode ser maior que o saldo da conta. Saque máximo de " + getSaldo(numero);
		}
		
		return "Saque efetuado com sucesso. Saldo atual: "+ getSaldo(numero);
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
 * Pega o saldo de uma conta
 * 	
 * @param numero
 * @return
 */
	public static float getSaldo(int numero) {
		return getConta(numero).getSaldo();
	}
}