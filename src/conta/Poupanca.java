package conta;

import execao.ExcecaoNumeroInvalido;
import execao.ExcecaoValorNegativo;

public class Poupanca extends Conta {

/**
 * Cria uma nova inst‰ncia e inicializa atributos.
 * 
 * @param numero
 * @param proprietario
 * @param saldo
 * @throws ExcecaoNumeroInvalido
 * @throws ExcecaoValorNegativo
 */
	public Poupanca(int numero, String proprietario, float saldo) throws ExcecaoNumeroInvalido, ExcecaoValorNegativo {
		super(numero, proprietario, saldo);
	}

	@Override
	public String getTipoConta() {
		return null;
	}
	
}
