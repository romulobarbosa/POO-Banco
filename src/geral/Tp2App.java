package geral;
import conta.Agencia;
import execao.ExcecaoOpcaoInvalida;
import java.util.Scanner; 
import geral.Utilitarios;


public class Tp2App {
	private static Utilitarios u = new Utilitarios();
	private Agencia agencia = new Agencia();
	private Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		executar();
		
		}// fecha a void main
	
	/**
	 *  MŽtodo respons‡vel por construir o menu de op›es do usu‡rio
	 */
	private void construirMenu() {
		u.pl(u.t(54, "="));
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
		
		int opcao = entrada.nextInt();
		validarOpcao(opcao);		
	}
	
	/**
	 *  Realiza a valida‹o da op‹o, lanando uma exce‹o caso a op‹o seja inv‡lida
	 * @param opcao
	 */
	private void validarOpcao(int opcao) throws ExcecaoOpcaoInvalida {
		if(!(opcao > 0 && opcao < 11)) {
			throw new ExcecaoOpcaoInvalida("Opcao invalida");
		} else {
			switch (opcao) {
				case 1:
					u.pl("1 - Criar Conta");
					u.pl("");
					criarConta();
					break;
				
				case 2:
					u.pl("2 - Cancelar Conta");
					u.pl("");
					cancelarConta();
					break;
					
				case 3:
					u.pl("3 - Sacar");
					u.pl("");
					sacar();
					break;
					
				case 4:
					u.pl("4 - Depositar");
					u.pl("");
					depositar();
				    break;
	
				case 5:
					u.pl("5 - Listar contas existentes (nao tarifado");
					u.pl("");
					agencia.listarContas();
				    break;
	
				case 6:
					u.pl("6 - Consultar dados da conta (tarifado p/ poupanca)");
					u.pl("");
					consultarConta();
				    break;
	
				case 7:
					u.pl("7 - Reajustar poupanca");
					u.pl("");
					reajustarPoupanca();					
				    break;
	
				case 8:
					u.pl("8 - Cobrar tarifa conta corrente ou especial");
					u.pl("");
					cobrarTarifa();
				    break;
	
				case 9:
					u.pl("9 - Cobrar juros conta especial");
					u.pl("");
					cobrarJuros();
				    break;
	
				case 10:
					u.pl("10 - Finalizar programa");
					u.pl("");
					
				    break;
			}
		}
	}
	
	/**
	 *  MŽtodo de tratamento genŽrico das exce›es
	 * @param msg
	 * @param e
	 */
	private void tratarExcecao(String msg, Exception e) {
		
	}
	
	/**
	 *  MŽtodo respons‡vel por exibir um submenu de tipos de conta e obter o tipo escolhido pelo usu‡rio
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
		u.p("Informe o numero da conta:");
		int numero = entrada.nextInt();
		agencia.cobrarJuros(numero);
	}
	
	/**
	 *  MŽtodo auxiliar da execu‹o da cobrana de tarifa de conta corrente
	 */
	private void cobrarTarifa() {
		u.p("Informe o numero da conta:");
		int numero = entrada.nextInt();
		agencia.cobrarTarifa(numero);
	}
	
	/**
	 *  MŽtodo auxiliar da execu‹o de reajuste de conta poupana
	 */
	private void reajustarPoupanca() {
		u.p("Informe o numero da conta e a taxa (%) de reajuste: ");
		int numero = entrada.nextInt();
		float taxa = entrada.nextFloat();
		agencia.reajustarPoupanca(numero, taxa);
	}
	
	/**
	 *  MŽtodo auxiliar da execu‹o da consulta de dados da conta
	 */
	private void consultarConta() {
		u.p("Informe o numero da conta: ");
		int numero = entrada.nextInt();
		agencia.consultarContas(numero);
	}
	
	/**
	 *  MŽtodo auxiliar da execu‹o de um dep—sito
	 */
	private void depositar() {
		u.p("Informe o numero da conta e o valor de deposito:");
		int numero = entrada.nextInt();
		float valor = entrada.nextFloat();
		agencia.depositar(numero, valor);	
	}
	
	/**
	 *  MŽtodo auxiliar da execu‹o de um saque
	 */
	private void sacar() {
		u.p("Informe o numero da conta e o valor de saque:");
		int numero = entrada.nextInt();
		float valor = entrada.nextFloat();
		agencia.sacar(numero, valor);
	}
	
	/**
	 *  MŽtodo auxiliar da execu‹o do cancelamento de conta
	 */
	private void cancelarConta() {
		u.pl("Informe o numero da conta");
		int numero = entrada.nextInt();
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
		int numero = entrada.nextInt();
		String proprietario = entrada.next();
		float saldo = entrada.nextFloat();
		if (tipo == 3){			
			u.pl("Informe o limite");
			limite = entrada.nextFloat();
		}
		agencia.criarConta(numero, proprietario, saldo, tipo, limite);
	}
	
	/**
	 *  MŽtodo respons‡vel por pausar a execu‹o atŽ o usu‡rio digitar ENTER
	 */
	private void pausar() {
		u.pl("Pressione ENTER para continuar...");
		entrada.nextLine();
		construirMenu();
	}	
}