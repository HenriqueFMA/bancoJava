package banco;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Principal {
	public static int menuOperacao() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("Escolha a operação desejada:");
		System.out.println("1 -> Depositar dinehiro.");
		System.out.println("2 -> Sacar dinheiro.");
		System.out.println("3 -> Mostrar extrato.");
		System.out.println("4 -> Mostrar saldo.");
		System.out.println("5 -> Encerrar operação.");
		System.out.println("--------------------------------------------------------------");
	    
	    int opcao = sc.nextInt();
		return opcao;
	}  
	public static int menuConta() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("Selecione o tipo de conta desejada:");
		System.out.println("1 -> Conta poupança.");
		System.out.println("2 -> Conta corrente.");
		System.out.println("2 -> Encerrar Programa.");
		
		System.out.println("--------------------------------------------------------------");
	    
	    int opcao = sc.nextInt();
		return opcao;
	}  
	public static void main(String[] args)  	 {
		 Scanner sc = new Scanner(System.in);
	
		String nome= sc.nextLine();
		String cpf=sc.nextLine();
		Cliente cliente01= new Cliente(nome,cpf);
		if (cliente01.cpf.length() >= 11) {
		    System.out.println("Cliente: " + nome + "\n CPF: ***" + cliente01.cpf.charAt(3) + cliente01.cpf.charAt(4) + cliente01.cpf.charAt(5) + "-" + cliente01.cpf.charAt(6) + cliente01.cpf.charAt(7) + cliente01.cpf.charAt(8) + "-**");
		} else {
		    System.out.println("Cliente: " + cliente01.nome + "\n CPF: CPF inválido");
		    System.out.println("Digite nova mente");
		   cpf=sc.nextLine();
		    cliente01.setCpf(cpf);
		}


	
		ContaPopanca poupanca = new ContaPopanca() ;
		ContaCorrente corrente = new ContaCorrente();
		int op1=menuConta();
		int op;
		switch(op1) {
			case 1:
				do {
				op=menuOperacao();
				switch(op){
				case 1:
				    // Depósito
				    System.out.println("Digite o valor que deseja depositar");
				    double valor = sc.nextDouble();
				    poupanca.preencherExtratoDeposito(valor);
				    poupanca.depositar(valor, poupanca.porcetagemRendimentoPorDeposito);
				    break;

				case 2:
				    // Saque
				    System.out.println("Digite o valor que deseja Sacar");
				    double valorS = sc.nextDouble();
				    poupanca.preencherExtratoSaque(valorS); // Preenche o extrato de saque antes de sacar
				    poupanca.sacar(valorS);
				    break;

				case 3:
				    // Extrato
				    poupanca.mostrarExtrato(poupanca.extratoSaque, poupanca.extratoDeposito, cliente01, poupanca.saldo);
				    break;

				case 4:
					//saldo
					  System.out.println("Saldo atual: " + poupanca.saldo);
					    break;
				
					
				}
				}while(op!=5);
			case 2:
				do {
					///////////////
					op=menuOperacao();
					switch(op){
					case 1:
					    // Depósito
					    System.out.println("Digite o valor que deseja depositar");
					    double valor = sc.nextDouble();
					  corrente.preencherExtratoDeposito(valor);
					    corrente.depositar(valor);
					    break;

				
					case 2:
					    // Saque
					    System.out.println("Digite o valor que deseja Sacar");
					    double valorS = sc.nextDouble();
					    corrente.preencherExtratoSaque(valorS);
					    double taxaSaque = corrente.taxaSaque;
					    corrente.sacar(valorS, taxaSaque);
					    break;

					   

					case 3:
					    // Extrato
					 corrente.mostrarExtrato(corrente.extratoSaque,corrente.extratoDeposito, cliente01, corrente.saldo);
					    break;
					case 4:
						//saldo
						  System.out.println("Saldo atual: " + corrente.saldo);
						    break;
						
					}
					}while(op!=5);
			case 3:
				break;
		}
	

}
}