import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
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
		        		System.out.println("Informe o numero da conta a ser cancelada");
		        		num = dados.nextInt();
		        		
		        		System.out.println();
		        		System.out.println(agencia.cancelarConta(num));
		        		System.out.println();
		                System.out.println();
		        		break;
		        	
		        	case 3:
		        		System.out.println("3 - Realizar um saque");
		        		
		        		System.out.println();
		        		System.out.println();
		        		System.out.println();
		                System.out.println();
		        		break;
		        		
		        	case 4:
		        		System.out.println("4 - Realizar um deposito");
		        		
		        		System.out.println();
		        		System.out.println();
		        		System.out.println();
		                System.out.println();
		        		break;
		        		
		        	case 5:
		        		System.out.println("5 - Listar contas existentes");
		        		
		        		System.out.println();
		        		System.out.println();
		        		System.out.println();
		                System.out.println();
		        		break;
	        	}
	        }
	        
	        switch (menuNum) {
	        	case 1:
	        		
	        }
		}

	}

}
