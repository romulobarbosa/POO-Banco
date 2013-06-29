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
		
		/*
		Agencia agencia = new Agencia();
		
		int menuNum = 1;
		while(menuNum != 6){
		
			System.out.println("====================||=====================");
	        System.out.println("Sistema Bancario - Operacoes Disponiveis\n");
	        System.out.println("1 - Criar conta");
	        System.out.println("2 - Cancelar conta");
	        System.out.println("3 - Sacar");
	        System.out.println("4 - Depositar");
	        System.out.println("5 - Listar contas existentes");
	        System.out.println("6 - Finalizar programa\n");
	        System.out.print("Selecione uma operacao: ");
	        
	        menuNum = dados.nextInt();
	        System.out.println();
	        
	        if(menuNum == 0 || menuNum >= 7){
	        	System.out.println("Opcao invalida");
	        } else {
	        	int numero;
	        	String proprietario;
	        	float saldo;
	        	
		        switch (menuNum) {
		        	case 1:
		        		System.out.println("1 - Criar conta");
		        		System.out.print("Informe o numero: ");
		                numero = dados.nextInt();
		                System.out.print("Informe o proprietario: ");
		                proprietario = dados.next();
		                System.out.print("Informe o saldo: ");
		                saldo = dados.nextFloat();
		                
		                System.out.println();
		                System.out.println(agencia.criarConta(numero, proprietario, saldo));
		                System.out.println();
		                System.out.println();
		                break;
		                
		        	case 2:
		        		System.out.println("2 - Cancelar conta");
		        		int num;
		        		System.out.print("Informe o numero da conta a ser cancelada");
		        		num = dados.nextInt();
		        		
		        		System.out.println();
		        		System.out.println(agencia.cancelarConta(num));
		        		System.out.println();
		                System.out.println();
		        		break;
		        	
		        	case 3:
		        		System.out.println("3 - Realizar um saque");
		        		int contaSaque;
		        		float valorSaque;
		        		System.out.print("Informe o n�mero da conta:");
		        		contaSaque = dados.nextInt();
		        		System.out.print("Informe o valor do saque:");
		        		valorSaque = dados.nextFloat();
		        		
		        		System.out.println();
		        		System.out.println(agencia.sacar(contaSaque, valorSaque));
		        		System.out.println();
		                System.out.println();
		        		break;
		        		
		        	case 4:
		        		System.out.println("4 - Realizar um deposito");
		        		int contaDep;
		        		float valorDep;
		        		System.out.print("Informe o n�mero da conta:");
		        		contaDep = dados.nextInt();
		        		System.out.print("Informe o valor do deposito:");
		        		valorDep = dados.nextFloat();
		        		
		        		System.out.println();
		        		System.out.println(agencia.depositar(contaDep, valorDep));
		        		System.out.println();
		                System.out.println();
		        		break;
		        		
		        	case 5:
		        		System.out.println("5 - Listar contas existentes");
		        		
		        		System.out.println();
		        		System.out.println();
		        		System.out.println(agencia.listarContas());
		                System.out.println();
		        		break;
	        	}
	        }
		}

	*/}// fecha a void main
	
	/**
	 *  M�todo respons�vel por construir o menu de op��es do usu�rio
	 */
	private void construirMenu() {
		u.pl(u.t(40));
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
	 *  Realiza a valida��o da op��o, lan�ando uma exce��o caso a op��o seja inv�lida
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
	 *  M�todo de tratamento gen�rico das exce��es
	 * @param msg
	 * @param e
	 */
	private void tratarExcecao(String msg, Exception e) {
		
	}
	
	/**
	 *  M�todo respons�vel por exibir um submenu de tipos de conta e obter o tipo escolhido pelo usu�rio
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
	 *  M�todo que inicia a execu��o da aplica��o
	 */
	public void executar() {
		construirMenu();
	}
	
	/**
	 *  M�todo auxiliar da execu��o da cobran�a de juros de conta especial
	 */
	private void cobrarJuros() {
		u.p("Informe o numero da conta:");
		int numero = entrada.nextInt();
		agencia.cobrarJuros(numero);
	}
	
	/**
	 *  M�todo auxiliar da execu��o da cobran�a de tarifa de conta corrente
	 */
	private void cobrarTarifa() {
		u.p("Informe o numero da conta:");
		int numero = entrada.nextInt();
		agencia.cobrarTarifa(numero);
	}
	
	/**
	 *  M�todo auxiliar da execu��o de reajuste de conta poupan�a
	 */
	private void reajustarPoupanca() {
		u.p("Informe o numero da conta e a taxa (%) de reajuste: ");
		int numero = entrada.nextInt();
		float taxa = entrada.nextFloat();
		agencia.reajustarPoupanca(numero, taxa);
	}
	
	/**
	 *  M�todo auxiliar da execu��o da consulta de dados da conta
	 */
	private void consultarConta() {
		u.p("Informe o numero da conta: ");
		int numero = entrada.nextInt();
		agencia.consultarContas(numero);
	}
	
	/**
	 *  M�todo auxiliar da execu��o de um dep�sito
	 */
	private void depositar() {
		u.p("Informe o numero da conta e o valor de deposito:");
		int numero = entrada.nextInt();
		float valor = entrada.nextFloat();
		agencia.depositar(numero, valor);	
	}
	
	/**
	 *  M�todo auxiliar da execu��o de um saque
	 */
	private void sacar() {
		u.p("Informe o numero da conta e o valor de saque:");
		int numero = entrada.nextInt();
		float valor = entrada.nextFloat();
		agencia.sacar(numero, valor);
	}
	
	/**
	 *  M�todo auxiliar da execu��o do cancelamento de conta
	 */
	private void cancelarConta() {
		u.pl("Informe o numero da conta");
		int numero = entrada.nextInt();
		agencia.cancelarConta(numero);
	}
	
	/**
	 *  M�todo auxiliar da execu��o da cria��o de conta
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
	 *  M�todo respons�vel por pausar a execu��o at� o usu�rio digitar ENTER
	 */
	private void pausar() {
		u.pl("Pressione ENTER para continuar...");
		entrada.nextLine();
		construirMenu();
	}	
}