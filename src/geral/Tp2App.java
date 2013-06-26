package geral;
import conta.Agencia;
import execao.ExcecaoOpcaoInvalida;
import java.util.Scanner; 
import geral.Utilitarios;

public class Tp2App {
	public static Utilitarios u = new Utilitarios();
	

	public static void main(String[] args) {
		/*
		Scanner dados = new Scanner(System.in);
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

	*/}
	
	public static void construirMenu() {
		u.p(u.t(40));
		u.p("1 - Criar conta");
		u.p("2 - Cancelar conta");
		u.p("3 - Sacar");
		u.p("4 - Depositar");
		u.p("5 - Listar contas existentes (nao tarifado");
		u.p("6 - Consultar dados da conta (tarifado p/ poupanca)");
		u.p("7 - Reajustar poupanca");
		u.p("8 - Cobrar tarifa conta corrente ou especial");
		u.p("9 - Cobrar juros conta especial");
		u.p("10 - Finalizar programa");		
	}
	
	public static void validarOpcao(int opcao) {
		if(!(opcao > 0 && opcao < 11)) {
			ExcecaoOpcaoInvalida teste = new ExcecaoOpcaoInvalida("teste");
		}
	}

	private static void ExcecaoOpcaoInvalida(String string) {
		// TODO Auto-generated method stub
		
	}
}