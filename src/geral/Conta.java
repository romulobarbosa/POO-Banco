package geral;
/**
 * Conta
 * 
 * @author gabriel
 */
public class Conta {
	private byte OPERACAO_OK = 0;
	private byte VALOR_NEGATIVO = 1;
	private byte SALDO_INSUFICIENTE = 2;
	
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
 * Retira um valor da conta
 * 
 * @param valor
 * @return
 */
	public byte sacar(float valor) {
		if (valor < 0) {
			return VALOR_NEGATIVO;
		}
		
		if (this.getSaldo() < valor) {
			return SALDO_INSUFICIENTE;
		}
		
		this.saldo = this.saldo - valor;
		
		return OPERACAO_OK;
	}
	
/**
 * Deposita um valor na conta
 * 
 * @param valor
 * @return
 */
	public byte depositar(float valor) {
		if (valor < 0) {
			return VALOR_NEGATIVO;
		}
		
		this.saldo = this.saldo + valor;
		
		return OPERACAO_OK;
	}
}