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
 * Utilit�rios
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
 * Constante para representar uma poupan�a.
 */
	static final byte ESPECIAL = 3;
	
/**
 * N�mero m�ximo de contas
 */
	private static final byte MAX_CONTAS = 20;
	
/**
 * Lista das contas da ag�ncia
 */
	public static ArrayList<Conta> contas = new ArrayList<Conta>();
	
/**
 * Contrutor da classe ag�ncia
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
 * M�todo de cria��o da conta. O limite s� tem sentido quando a conta � especial. Do contr�rio, ele e ignorado.
 * 
 * @param numero O n�mero da conta.
 * @param proprietario O propriet�rio da conta.
 * @param saldo O saldo inicial da conta.
 * @param tipo O tipo da conta.
 * @param limite O limite de cr�dito para a conta do tipo ESPECIAL.
 * @throws ExcecaoFaltaEspaco Se o n�mero m�ximo de contas j� houver sido cadastrado.
 * @throws ExcecaoContaExistente Se o n�mero da conta informado como par�metro j� existe na ag�ncia.
 */
	public void criarConta(int numero, String proprietario, float saldo, byte tipo, float limite) throws ExcecaoFaltaEspaco, ExcecaoContaExistente {
		if (contas.size() >= MAX_CONTAS) {
			throw new ExcecaoFaltaEspaco("Numero maximo de contas ja cadastrado.");
		}
		
		if (this.getConta(numero) != null) {
			throw new ExcecaoContaExistente("N�mero de conta j� existe.");
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
 * M�todo de cancelamento da conta.
 * @param numero
 */
	public void cancelarConta(int numero) {		
		contas.remove(this.getConta(numero));
	}

/**
 * M�todo que realiza a listagem das contas cadastradas. N�o h� cobran�a de tarifas na execu��o deste m�todo.
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
 * Consulta os dados de uma conta. Pode haver cobran�a de tarifas na execu��o deste m�todo, dependendo do tipo da conta e do n�mero de consultas realizadas.
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
 * Aplica um reajuste a uma conta de poupan�a.
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
 * Realiza a cobran�a de tarifa sobre uma conta corrente.
 * 
 * @param numero
 * @throws ExcecaoTipoConta
 */
	public void cobrarTarifa(int numero) throws ExcecaoTipoConta {
		Corrente conta = (Corrente) this.getConta(numero);
		
		if (conta.getTipoConta() == "Poupanca")
			throw new ExcecaoTipoConta("A conta informada e' uma POUPANCA, e nao possui cobranca de tarifa.");
		
		conta.cobrarTarifa();
	}
	
/**
 * Realiza a cobran�a de juros de uma conta especial.
 * 
 * @param numero O n�mero da conta.
 * @throws ExcecaoTipoConta Se a conta informada n�o for uma conta especial.
 */
	public void cobrarJurosContaEspecial(int numero) throws ExcecaoTipoConta {
		Especial conta = (Especial) this.getConta(numero);
		
		if (conta.getTipoConta() != "Especial") {
			throw new ExcecaoTipoConta("A conta informada nao e' uma CONTA ESPECIAL.");
		}
		
		conta.cobrarJuros();
	}
	
/**
 * Realiza o saque em uma conta.
 * 	
 * @param numero O n�mero da conta.
 * @param valor O valor a ser sacado.
 */
	public void sacar(int numero, float valor) {
		this.getConta(numero).sacar(valor);
	}


/**
 * Realiza o dep�sito em uma conta.
 * 	
 * @param numero O n�mero da conta.
 * @param valor O valor a ser depositado.
 */
	public void depositar(int numero, float valor) {
		this.getConta(numero).depositar(valor);
	}
	
/**
 * Pega o saldo de uma conta
 * 	
 * @param numero
 * @return
 */
	public float getSaldo(int numero) {
		return this.getConta(numero).getSaldo();
	}
}