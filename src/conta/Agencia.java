package conta;

import java.util.ArrayList;
import conta.Corrente;
import conta.Poupanca;
import conta.Especial;
import geral.Utilitarios;
import execao.ExcecaoContaExistente;
import execao.ExcecaoContaInexistente;
import execao.ExcecaoFaltaEspaco;
import execao.ExcecaoTipoConta;
import execao.ExcecaoValorNegativo;

/**
 * Agencia
 * 
 * @author romulo
 */
public class Agencia { 

/**
 * Utilitários
 */
	private Utilitarios u = new Utilitarios();

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
 * Método de cancelamento da conta.
 * @param numero
 */
	public void cancelarConta(int numero) {		
		contas.remove(this.getConta(numero));
	}

/**
 * Método que realiza a listagem das contas cadastradas. Não há cobrança de tarifas na execução deste método.
 * 
 * @return
 */
	public String listarContas() {
		String listaDeContas = "";
		
		for (int i = 0; i < contas.size(); i++) {
			listaDeContas += contas.get(i).listarDados();
			listaDeContas += u.t(24, "=");
		}
		
		return listaDeContas;
	}
	
/**
 * Consulta os dados de uma conta. Pode haver cobrança de tarifas na execução deste método, dependendo do tipo da conta e do número de consultas realizadas.
 * 
 * @param numero
 * @return
 */
	public String consultarConta(int numero) {
		Conta conta = this.getConta(numero);
		
		if (conta.getTipoConta() == "Poupanca") {
			conta.getSaldo();
		}
		
		return conta.listarDados();
	}
	
/**
 * Aplica um reajuste a uma conta de poupança.
 * 
 * @param numero
 * @param taxa
 * @throws ExcecaoTipoConta
 */
	public void reajustarPoupanca(int numero, float taxa) throws ExcecaoTipoConta {
		Poupanca conta = (Poupanca) this.getConta(numero);
		
		if (conta.getTipoConta() != "Poupanca")
			throw new ExcecaoTipoConta("A conta informada nao e' uma POUPANCA.");
		
		conta.reajustar(taxa);
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