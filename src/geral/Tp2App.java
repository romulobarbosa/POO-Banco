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
		        		System.out.print("Informe o nœmero da conta:");
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
		        		System.out.print("Informe o nœmero da conta:");
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
	
	// Imprime o menu	
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
	}
	
	// Valida a opao do menu selecionada
	private void validarOpcao(int opcao) {
		if(!(opcao > 0 && opcao < 11)) {
			
		}
	}
	
	private void tratarExcecao(String msg, Exception e) {
		
	}
	
	private byte selecionarTipoConta(){
		u.pl("Tipo de conta:");
		u.pl("");
		u.pl("1 - Corrente");
		u.pl("2 - Poupanca");
		u.pl("3 - Especial");
		u.p("tipo: ");
		return entrada.nextByte();
	}
	
}