package conta;

import execao.ExcecaoNumeroInvalido;
import execao.ExcecaoValorNegativo;

public class Corrente extends Conta {
	
/**
 * A tarifa de manuten��o da conta.
 */
	private float tarifaManutencao = (float) 12.5;

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
	public String listarDados() {
		return super.listarDados() +
				"Tarifa de manutencao: " 	+ this.tarifaManutencao		+ "\n";
	}
	
	@Override
	public String getTipoConta() {
		return "Corrente";
	}

/**
 * Atribui um valor � tarifa de manuten��o.
 * 
 * @param tarifaManutencao
 */
	protected void setTarifaManutencao(float tarifaManutencao) {
		this.tarifaManutencao = tarifaManutencao;
	}

}
