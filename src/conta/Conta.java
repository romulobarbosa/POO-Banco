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
 * Utilit‡rios
 */
	private Utilitarios u = new Utilitarios();
	
/**
 * Nœmero da conta
 */
	private int numero;
	
/**
 * Propriet‡rio da conta
 */
	private String proprietario;
	
/**
 * Saldo da conta
 */
	private float saldo;

/**
 * Permiss›es especiais
 */
	private boolean permissoesEspeciaisHabilitas = false;
	
/**
 * Contrutor da classe conta
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
 * Retorna o nœmero da conta
 * 
 * @return int numero
 */
	public int getNumero() {
		return this.numero;
	}
	
/**
 * Retorna o nome do propriet‡rio da conta
 * 
 * @return String propriet‡rio
 */
	public String getProprietario() {
		return this.proprietario;
	}
	
/**
 * Retorna o saldo atual da conta
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
		return "Nœmero: " + this.getNumero() + ", Propriet‡rio: " + this.getProprietario() + ", Saldo: " + this.getSaldo();
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
		
		u.pl("Saque realizado com sucesso. Saldo da conta Ž:" + this.getSaldo());
	}
	
/**
 * Verifica se o valor de saque Ž valido
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
 * Deposita um valor na conta
 * 
 * @param valor
 * @return
 * @throws ExcecaoValorNegativo 
 */
	public void depositar(float valor) throws ExcecaoValorNegativo {
		if (valor < 0) {
			throw new ExcecaoValorNegativo("Valor de deposito nao pode ser negativo.");
		}
		
		this.saldo = this.saldo + valor;
	}

/**
 * Consulta o estado das permiss›es especiais
 * 
 * @return boolean permissoesEspeciaisHabilitadas
 */
	protected boolean permissoesEspeciaisHabilitadas() {
		return this.permissoesEspeciaisHabilitas;
	}
	
/**
 * 	Habilita as permiss›es especiais
 */
	protected void habilitarPermissoesEspeciais() {
		this.permissoesEspeciaisHabilitas = true;
	}

/**
 * Desabilita as permiss›es especiais
 */
	protected void deshabilitarPermissoesEspeciais() {
		this.permissoesEspeciaisHabilitas = false;
	}
}