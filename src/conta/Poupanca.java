package conta;

import execao.ExcecaoNumeroInvalido;
import execao.ExcecaoSaldoInsuficiente;
import execao.ExcecaoValorNegativo;

public class Poupanca extends Conta {
	
/**
 * A tarifa cobrada por consulta excedente ao saldo.
 */
	private static final float TARIFA_CONSULTA = (float) 1.1;

/**
 * A quantidade de consultas realizadas.
 */
	private int quantidadeConsultas = 0;
	
/**
 * Cria uma nova inst‰ncia e inicializa atributos.
 * 
 * @param numero
 * @param proprietario
 * @param saldo
 * @throws ExcecaoNumeroInvalido
 * @throws ExcecaoValorNegativo
 */
	public Poupanca(int numero, String proprietario, float saldo) {
		super(numero, proprietario, saldo);
	}
	
/**
 * ObtŽm o saldo da poupana, considerando o nœmero de consultas realizadas.
 * 
 * @return saldo
 * @throws ExcecaoSaldoInsuficiente 
 */
	@Override
	public float getSaldo() throws ExcecaoSaldoInsuficiente {
		quantidadeConsultas++;
		
		if (quantidadeConsultas > 2) {
			if (super.getSaldo() < TARIFA_CONSULTA) {
				throw new ExcecaoSaldoInsuficiente("O saldo da conta nao e' suficiente para realizar a consulta.");
			}
			
			this.sacar(TARIFA_CONSULTA);
		}
		
		return super.getSaldo();
	}
	

/**
 * Reajusta o saldo da poupana.
 * 
 * @param taxa
 * @throws ExcecaoValorNegativo
 */
	public void reajustar(float taxa) throws ExcecaoValorNegativo {
		if (taxa < 0) {
			throw new ExcecaoValorNegativo("A taxa de juros nao pode ser negativa.");
		}
		
		float saldo = super.getSaldo();
		float reajuste = (saldo * taxa) - saldo;
		
		this.depositar(reajuste);
	}

/**
 * Faz a listagem de dados da conta.
 * @return
 */
	public String listarDados() {
		return super.listarDados() +
				"Quantidade de consultas realizadas: "	+ this.quantidadeConsultas 	+ "\n" +
				"Tarifa por consulta excedente: " 		+ TARIFA_CONSULTA		+ "\n";
	}

	@Override
	public String getTipoConta() {
		return "Poupanca";
	}
	
}
