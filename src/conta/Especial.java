package conta;

import execao.ExcecaoNumeroInvalido;
import execao.ExcecaoValorNegativo;

public class Especial extends Corrente {
	
/**
 * A taxa de juros sobre o valor emprestado.
 */
	private static final float TAXA_JURO = (float) 0.08;

/**
 * O limite de cr�dito da conta.
 */
	private float limite;
	
/**
 * O valor emprestado ao usu�rio (parcela do limite de cr�dito utilizada).
 */
	private float valorEmprestado;
	
/**
 * Os juros cobrados sobre o valor emprestado.
 */
	private float jurosCobrados;
	
/**
 * Construtor da classe
 * 
 * @param numero
 * @param proprietario
 * @param saldo
 * @throws ExcecaoNumeroInvalido
 * @throws ExcecaoValorNegativo
 */
	public Especial(int numero, String proprietario, float saldo, float limite) throws ExcecaoNumeroInvalido, ExcecaoValorNegativo {
		super(numero, proprietario, saldo);
		
		if (limite <= 0) {
			this.limite = (float) 200.0;
			throw new ExcecaoValorNegativo("Limite de credito deve ser positivo.");
		}
	}
	
	@Override
	public String listarDados() {
		return "N�mero: " + this.getNumero() + ", Propriet�rio: " + this.getProprietario() + ", Saldo: " + this.getSaldo();
	}
	
	@Override
	public void sacar(float valor) {
		
	}
	
	@Override
	public float getSaldo() {
		return super.getSaldo();
	}

/**
 * Realiza a cobran�a de juros da conta.
 */
	public void cobrarJuros() {
		
	}
	
	public void depositar(float valor) {
		
	}

	@Override
	public String getTipoConta() {
		return null;
	}

}
