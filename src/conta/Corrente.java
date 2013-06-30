package conta;

import execao.ExcecaoNumeroInvalido;
import execao.ExcecaoValorNegativo;
import geral.Utilitarios;

public class Corrente extends Conta {
	
	private Utilitarios u = new Utilitarios();
	
/**
 * A tarifa de manutenção da conta.
 */
	private float tarifaManutencao = (float) 12.5;

/**
 * Cria uma nova instância e inicializa atributos.
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
		return "Tipo de conta: " 			+ this.getTipoConta() 		+ "\n" +
				"Numero da conta: " 		+ this.getNumero() 			+ "\n" +
				"Proprietario: " 			+ this.getProprietario() 	+ "\n" +
				"Saldo: "					+ this.getSaldo() 			+ "\n" +
				"Tarifa de manutencao: " 	+ this.tarifaManutencao		+ "\n" +
				u.t(24, "=");
	}
	
	@Override
	public String getTipoConta() {
		return "Corrente";
	}

/**
 * Atribui um valor à tarifa de manutenção.
 * 
 * @param tarifaManutencao
 */
	protected void setTarifaManutencao(float tarifaManutencao) {
		this.tarifaManutencao = tarifaManutencao;
	}

}
