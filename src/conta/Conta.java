package conta;

import execao.ExcecaoSaqueInvalido;
import execao.ExcecaoValorNegativo;
import geral.Utilitarios;

/**
 * Conta
 * 
 * @author gabriel
 */
public abstract class Conta {
	
/**
 * Utilitários
 */
	private Utilitarios u = new Utilitarios();
	
/**
 * Número da conta
 */
	private int numero;
	
/**
 * Proprietário da conta
 */
	private String proprietario;
	
/**
 * Saldo da conta
 */
	private float saldo;

/**
 * Permissões especiais
 */
	private boolean permissoesEspeciaisHabilitas = false;
	
/**
 * Cria uma nova instância e inicializa atributos.
 * 
 * @param numero
 * @param proprietario
 * @param saldo
 */
	public Conta(int numero, String proprietario, float saldo) {
		this.numero = numero;
		this.proprietario = proprietario;
		this.saldo = saldo;
	}
	
/**
 * Obtém o número da conta.
 * 
 * @return int numero
 */
	public int getNumero() {
		return this.numero;
	}
	
/**
 * Obtém o proprietário da conta.
 * 
 * @return String proprietário
 */
	public String getProprietario() {
		return this.proprietario;
	}
	
/**
 * Obtém o saldo da conta.
 * 
 * @return float saldo
 */
	public float getSaldo() {
		return this.saldo;
	}

/**
 * Lista os dados
 * 
 * @return
 */
	public String listarDados() {
		return "Número: " + this.getNumero() + ", Proprietário: " + this.getProprietario() + ", Saldo: " + this.getSaldo();
	}

/**
 * Realiza o saque na conta
 * 
 * @param valor
 * @throws ExcecaoValorNegativo
 * @throws ExcecaoSaqueInvalido
 */
	public void sacar(float valor) throws ExcecaoValorNegativo, ExcecaoSaqueInvalido {
		verificarCondicoesParaSaque(valor);
		
		this.saldo = this.saldo - valor;
		
		u.pl("Saque realizado com sucesso. Saldo da conta é:" + this.getSaldo());
	}
	
/**
 * Verifica se o valor de saque é valido
 * 
 * @param valor
 * @throws ExcecaoValorNegativo
 * @throws ExcecaoSaqueInvalido
 */
	protected void verificarCondicoesParaSaque(float valor) throws ExcecaoValorNegativo, ExcecaoSaqueInvalido{
		if (valor < 0) {
			throw new ExcecaoValorNegativo("Valor de deposito nao pode ser negativo.");
		}
		
		if (this.getSaldo() < valor) {
			throw new ExcecaoSaqueInvalido("Valor de saque nao pode ser maior que o saldo.");
		}		
	}
	
/**
 * Realiza o depósito na conta.
 * 
 * @param valor
 * @throws ExcecaoValorNegativo 
 */
	public void depositar(float valor) throws ExcecaoValorNegativo {
		if (valor < 0) {
			throw new ExcecaoValorNegativo("Valor de deposito nao pode ser negativo.");
		}
		
		this.saldo = this.saldo + valor;
	}

/**
 * Consulta o estado das permissões especiais
 * 
 * @return boolean permissoesEspeciaisHabilitadas
 */
	protected boolean permissoesEspeciaisHabilitadas() {
		return this.permissoesEspeciaisHabilitas;
	}
	
/**
 * 	Habilita as permissões especiais
 */
	protected void habilitarPermissoesEspeciais() {
		this.permissoesEspeciaisHabilitas = true;
	}

/**
 * Desabilita as permissões especiais
 */
	protected void deshabilitarPermissoesEspeciais() {
		this.permissoesEspeciaisHabilitas = false;
	}
}