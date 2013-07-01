package geral;
import conta.Agencia;
import execao.ExcecaoContaExistente;
import execao.ExcecaoFaltaEspaco;
import execao.ExcecaoOpcaoInvalida;
import execao.ExcecaoTipoConta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import geral.Utilitarios;


public class Tp2App {
/**
 * Utilitarios
 */
	private static Utilitarios u = new Utilitarios();

/**
 * Objeto agncia banc‡ria.
 */
	private Agencia agencia = new Agencia();

/**
 * Objeto para leitura de dados.
 */
	private Scanner entrada = new Scanner(System.in);
	
/**
 * Vari‡vel auxiliar para o saldo inicial da conta.
 */
	private float saldo;
	
/**
 * Vari‡vel auxiliar para o valor a ser sacado ou depositado.
 */
	private float valor;
	
/**
 * Vari‡vel auxiliar para o nœmero da conta.
 */
	private int numero;

/**
 * Vari‡vel auxiliar para o propriet‡rio da conta.
 */
	private String proprietario;

/**
 * Objeto auxiliar do mŽtodo pausar().
 */
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
/**
 * Constante utilizada para controlar o nœmero de op›es de menu dispon’veis.
 */
	private static int MAX_OP = 10;

/**
 * Construtor da classe.
 * 
 * @param args
 */
	public static void main(String[] args) {
		 Tp2App programa = new Tp2App();
		 programa.executar();
	}
	
/**
 *  MŽtodo respons‡vel por construir o menu de op›es do usu‡rio
 */
	private void construirMenu() {
		u.pl(u.t(54, "="));
		u.pl("Sistema Bancario - Operacoes Disponiveis");
		u.pl("");
		u.pl("1 - Criar conta");
		u.pl("2 - Cancelar conta");
		u.pl("3 - Sacar");
		u.pl("4 - Depositar");
		u.pl("5 - Listar contas existentes (nao tarifado");
		u.pl("6 - Consultar dados da conta (tarifado p/ poupanca)");
		u.pl("7 - Reajustar poupanca");
		u.pl("8 - Cobrar tarifa conta corrente ou especial");
		u.pl("9 - Cobrar juros conta especial");
		u.pl("10 - Finalizar programa");
		u.pl("");
		u.p("Selecione uma operacao: ");
		
		int opcao = entrada.nextInt();
		u.pl("");
		
		try {
			validarOpcao(opcao);
		} catch (Exception e) {
			tratarExcecao("Ocorreu um erro na validacao da opcao.", e);
		}
		
	}
	
/**
 *  Realiza a valida‹o da op‹o, lanando uma exce‹o caso a op‹o seja inv‡lida
 * @param opcao
 */
	private void validarOpcao(int opcao) throws ExcecaoOpcaoInvalida {
		if(!(opcao > 0 && opcao <= MAX_OP))
			throw new ExcecaoOpcaoInvalida("Opcao invalida");
		
		switch (opcao) {
			case 1:
				u.pl("1 - Criar Conta");
				criarConta();
				break;
			
			case 2:
				u.pl("2 - Cancelar Conta");
				cancelarConta();
				break;
				
			case 3:
				u.pl("3 - Sacar");
				sacar();
				break;
				
			case 4:
				u.pl("4 - Depositar");
				depositar();
			    break;

			case 5:
				u.pl("5 - Listar contas existentes (nao tarifado");
				agencia.listarContas();
			    break;

			case 6:
				u.pl("6 - Consultar dados da conta (tarifado p/ poupanca)");
				consultarConta();
			    break;

			case 7:
				u.pl("7 - Reajustar poupanca");
				reajustarPoupanca();					
			    break;

			case 8:
				u.pl("8 - Cobrar tarifa conta corrente ou especial");
				cobrarTarifa();
			    break;

			case 9:
				u.pl("9 - Cobrar juros conta especial");
				cobrarJuros();
			    break;

			case 10:
				u.pl("10 - Finalizar programa");
			    break;
		}
	}
	
/**
 * MŽtodo de tratamento genŽrico das exce›es
 * 
 * @param msg
 * @param e
 */
	private void tratarExcecao(String msg, Exception e) {
		u.pl(u.t(15, "*"));
		u.pl(msg + " Tente novamente.");
		u.pl("Detalhes do erro: " + e.getMessage());
		u.pl(u.t(15, "*"));
		
		pausar();
	}
	
/**
 * MŽtodo respons‡vel por exibir um submenu de tipos de conta e obter o tipo escolhido pelo usu‡rio
 * 
 * @return
 */
	private byte selecionarTipoConta(){
		u.pl("Tipo de conta:");
		u.pl("");
		u.pl("1 - Corrente");
		u.pl("2 - Poupanca");
		u.pl("3 - Especial");
		u.p("tipo: ");
		return entrada.nextByte();
	}
	
/**
 *  MŽtodo que inicia a execu‹o da aplica‹o
 */
	public void executar() {
		construirMenu();
	}
	
/**
 *  MŽtodo auxiliar da execu‹o da cobrana de juros de conta especial
 */
	private void cobrarJuros() {
		u.p("Informe o numero da conta: ");
		numero = entrada.nextInt();
		
		try {
			agencia.cobrarJurosContaEspecial(numero);
		} catch (ExcecaoTipoConta e) {
			tratarExcecao("Ocorreu um erro ao cobrar a tarifa.", e);
		}
	}
	
/**
 *  MŽtodo auxiliar da execu‹o da cobrana de tarifa de conta corrente
 */
	private void cobrarTarifa() {
		u.p("Informe o numero da conta: ");
		numero = entrada.nextInt();
		try {
			agencia.cobrarTarifa(numero);
		} catch (ExcecaoTipoConta e) {
			tratarExcecao("Ocorreu um erro ao cobrar a tarifa.", e);
		}
	}
	
/**
 *  MŽtodo auxiliar da execu‹o de reajuste de conta poupana
 */
	private void reajustarPoupanca() {
		u.p("Informe o numero da conta e a taxa (%) de reajuste: ");
		numero = entrada.nextInt();
		float taxa = entrada.nextFloat();
		
		try {
			agencia.reajustarPoupanca(numero, taxa);
		} catch (ExcecaoTipoConta e) {
			tratarExcecao("Ocorreu um erro ao reajustar a poupanca.", e);
		}
	}
	
/**
 *  MŽtodo auxiliar da execu‹o da consulta de dados da conta
 */
	private void consultarConta() {
		u.p("Informe o numero da conta: ");
		numero = entrada.nextInt();
		agencia.consultarConta(numero);
	}
	
/**
 *  MŽtodo auxiliar da execu‹o de um dep—sito
 */
	private void depositar() {
		u.p("Informe o numero da conta e o valor de deposito:");
		numero = entrada.nextInt();
		valor = entrada.nextFloat();
		agencia.depositar(numero, valor);	
	}
	
/**
 *  MŽtodo auxiliar da execu‹o de um saque
 */
	private void sacar() {
		u.p("Informe o numero da conta e o valor de saque:");
		numero = entrada.nextInt();
		valor = entrada.nextFloat();
		agencia.sacar(numero, valor);
	}

/**
 *  MŽtodo auxiliar da execu‹o do cancelamento de conta
 */
	private void cancelarConta() {
		u.pl("Informe o numero da conta");
		numero = entrada.nextInt();
		agencia.cancelarConta(numero);
	}
	
/**
 *  MŽtodo auxiliar da execu‹o da cria‹o de conta
 */
	private void criarConta() {	
		float limite = 0;
		// Lista os tipos de conta
		selecionarTipoConta();
		byte tipo = selecionarTipoConta();
		
		u.pl("Informe o numero, proprietario e saldo da conta: ");
		
		numero = entrada.nextInt();
		proprietario = entrada.nextLine();
		entrada.nextLine();
		saldo = entrada.nextFloat();
		
		if (tipo == 3){			
			u.pl("Informe o limite: ");
			limite = entrada.nextFloat();
		}
		
		agencia.criarConta(numero, proprietario, saldo, tipo, limite);	
	}
	
/**
 *  MŽtodo respons‡vel por pausar a execu‹o atŽ o usu‡rio digitar ENTER
 */
	private void pausar() {
		String buf = null;
		
		while(buf == null) {
			u.pl("Pressione ENTER para continuar...");
			
			try {
				buf = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		construirMenu();	
	}	
}