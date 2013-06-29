package conta;

import execao.ExcecaoNumeroInvalido;
import execao.ExcecaoValorNegativo;

public class Especial extends Conta {
	
/**
 * A taxa de juros sobre o valor emprestado.
 */
	private static final float TAXA_JURO = (float) 0.08;
	
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
