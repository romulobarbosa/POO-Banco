package conta;

import execao.ExcecaoNumeroInvalido;
import execao.ExcecaoValorNegativo;

public class Especial extends Conta {
	
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
	public Especial(int numero, String proprietario, float saldo) throws ExcecaoNumeroInvalido, ExcecaoValorNegativo {
		super(numero, proprietario, saldo);
	}

	@Override
	public String getTipoConta() {
		return null;
	}

}
