package conta;

import execao.ExcecaoNumeroInvalido;
import execao.ExcecaoValorNegativo;

public class Corrente extends Conta {
	
/**
 * A tarifa de manuten��o da conta.
 */
	private float tarifaManutencao;

/**
 * Cria uma nova inst�ncia e inicializa atributos.
 * 
 * @param numero
 * @param proprietario
 * @param saldo
 * @throws ExcecaoNumeroInvalido
 * @throws ExcecaoValorNegativo
 */
	public Corrente(int numero, String proprietario, float saldo) throws ExcecaoNumeroInvalido, ExcecaoValorNegativo {
		super(numero, proprietario, saldo);
	}

	@Override
	public String getTipoConta() {
		return null;
	}

}
