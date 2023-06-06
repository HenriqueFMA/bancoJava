package banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ContaCorrente extends Conta{
	double taxaSaque=3.0;
	
	public double sacar(double saque,double taxaSaque) {
 
		        saldo -= saque;
		        saldo-=taxaSaque;
		        return saldo;
		    

	}
	 public void mostrarExtrato(String extratoSaque[][], String extratoDeposito[][], Cliente cliente, double saldo) {
		    LocalDateTime dataHoraAtual = LocalDateTime.now();
		    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		    String dataHora = dataHoraAtual.format(formato);

		    System.out.println("///////Extrato Bancario///////\n -Retirado: " + dataHora);
		    System.out.println("Cliente: " + cliente.nome + "\n CPF: ***" + cliente.cpf.charAt(3) + cliente.cpf.charAt(4) + cliente.cpf.charAt(5) + "-" + cliente.cpf.charAt(6) + cliente.cpf.charAt(7) + cliente.cpf.charAt(8) + "-**");

		    System.out.println("-----Saques-----");
		    for (String[] saque : extratoSaque) {
		        System.out.println(Arrays.toString(saque));
		    }

		    System.out.println("-----Depositos-----");
		    for (String[] deposito : extratoDeposito) {
		        System.out.println(Arrays.toString(deposito));
		    }

		    System.out.println("-----Saldo total: " + saldo);
		    System.out.println("Observaçao: taxa de 3 reais por saque.");
		}

}
