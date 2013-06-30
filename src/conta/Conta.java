package conta;

import execao.ExcecaoNumeroInvalido;
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
 * Cria uma nova inst‰ncia e inicializa atributos.
 * 
 * @param numero
 * @param proprietario
 * @param saldo
 */
	public Conta(int numero, String proprietario, float saldo) throws ExcecaoNumeroInvalido, ExcecaoValorNegativo {
		if (numero < 0) {
			throw new ExcecaoNumeroInvalido("Numero da conta nao pode ser negativo.");
		}
		
		if (saldo < 0) {
			throw new ExcecaoValorNegativo("Saldo inicial nao pode ser negativo.");
		}
		
		this.numero = numero;
		this.proprietario = proprietario;
		this.saldo = saldo;
	}
	
/**
 * ObtŽm o nœmero da conta.
 * 
 * @return int numero
 */
	public int getNumero() {
		return this.numero;
	}
	
/**
 * ObtŽm o propriet‡rio da conta.
 * 
 * @return String propriet‡rio
 */
	public String getProprietario() {
		return this.proprietario;
	}
	
/**
 * ObtŽm o saldo da conta.
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
		return "Tipo de conta: " 			+ this.getTipoConta() 		+ "\n" +
				"Numero da conta: " 		+ this.getNumero() 			+ "\n" +
				"Proprietario: " 			+ this.getProprietario() 	+ "\n" +
				"Saldo: "					+ this.getSaldo() 			+ "\n";
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
			throw new ExcecaoValorNegativo("Valor de saque nao pode ser negativo.");
		}
		
		if (this.getSaldo() < valor) {
			throw new ExcecaoSaqueInvalido("Valor de saque nao pode ser maior que o saldo.");
		}		
	}
	
/**
 * Realiza o dep—sito na conta.
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
	
/**
 * Retorna o tipo da conta como um string.
 * @return
 */
	public abstract String getTipoConta();
}